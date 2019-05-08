package com.mylike.controller;

import com.mylike.SMSUtil;
import com.mylike.enums.TemplateTypeEnum;
import com.mylike.utils.MassageReturnUtils;
import com.mylike.utils.ReturnDiscern;
import com.mylike.utils.TimeContrastUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/Login")
public class LoginApi {

    //    返回
    private ReturnDiscern re = new ReturnDiscern();
    private MassageReturnUtils massageReturn = new MassageReturnUtils();
    //    时间对比
    private TimeContrastUtils time = new TimeContrastUtils();

    //    判定session
    @RequestMapping("/register")
    public Map<String, Object> Login(String phone, HttpServletRequest req) {
        if (req.getSession().getAttribute(phone) != null) {
            String date = (String) req.getSession().getAttribute("time");
            if (date != null) {
                if (time.TimeContrast(date, 1).equals("success")) {
                    return re.TimeError(1);
                }
            }
        }
        int randNum = new Random().nextInt(9999 - 1000) + 1000;
//        String bank = SendMessage(phone, randNum);
//        JSONObject json = JSONObject.parseObject(bank);
        req.getSession().setAttribute(phone, randNum);
        req.getSession().setAttribute("time", "2019");
//        System.out.println(req.getSession().getAttribute(phone));
        return null;
    }

    //    申请短信验证
    public static String SendMessage(String phone, int randNum) {
        SMSUtil sms = new SMSUtil();
        return sms.sendSms(phone, TemplateTypeEnum.REGISTER, randNum, null);
    }

    //  验证
    @RequestMapping("/verification")
    public Map<String, Object> verification(String phone, int verify, HttpServletRequest request) {
        System.out.println("phone----------" + phone);
        System.out.println("verify---------" + verify);
        System.out.println("req-------" + request.getAttribute(phone));
        if (request.getAttribute(phone) != null) {
            int a = (int) request.getAttribute(phone);
            System.out.println("a-------" + a);
            String date = (String) request.getAttribute("time");
            System.out.println("date-------" + date);
            if (date != null) {
                if (time.TimeContrast(date, 3).equals("success")) {
                    if (verify == a) {
                        request.removeAttribute(phone);
                        return re.SUCCESS();
                    } else if (time.TimeContrast(date, 3).equals("error")) {
                        return re.TimeOut();
                    }
                }
            }
        }
        return re.ERROR();
    }
}