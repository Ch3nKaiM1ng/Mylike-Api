package com.mylike.controller;

import com.mylike.utils.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/Login")
public class LoginApi {

    //    返回
    private ReturnDiscern re = new ReturnDiscern();
    private MassageReturnUtils massageReturn = new MassageReturnUtils();
    //    时间类
    private DateUtils dateUtils = new DateUtils();
    //    时间对比
    private TimeContrastUtils time = new TimeContrastUtils();
    //    调用信息
    private SMSUtils sms = new SMSUtils();
    //    判定session
    @RequestMapping("/register")
    public Map<String, Object> Login(String phone, HttpServletRequest req) {
        int randNum = new Random().nextInt(9999 - 1000) + 1000;
        if (req.getSession().getAttribute(phone) != null) {
            String date = (String) req.getSession().getAttribute("time");
            if (date != null) {
                if (time.TimeContrast(date, 1).equals("error")) {
                    return re.TimeError(1);
                }
                req.getSession().setAttribute(phone, randNum);
                req.getSession().setAttribute("time", dateUtils.Fornat(dateUtils.NewDate()));
                return SendMessage(phone,randNum);
            }
        }
        req.getSession().setAttribute(phone, randNum);
        req.getSession().setAttribute("time", dateUtils.Fornat(dateUtils.NewDate()));
        return SendMessage(phone,randNum);
    }

    //    申请短信验证
    public  Map<String, Object> SendMessage(String phone, int randNum) {
        String code= sms.SmsCode(String.valueOf(randNum),phone);

        return massageReturn.CodeVerify(code);
    }

    //  验证
    @RequestMapping("/verification")
    public Map<String, Object> verification(String phone, int verify, HttpSession session) {
        System.out.println("phone----------" + phone);
        System.out.println("verify---------" + verify);
        System.out.println("req-------" + session.getAttribute(phone));
        if (session.getAttribute(phone) != null) {
            Integer a = (Integer) session.getAttribute(phone);
            System.out.println("a-------" + a);
            String date = (String) session.getAttribute("time");
            System.out.println("date-------" + date);
            if (date != null) {
                if (time.TimeContrast(date, 3).equals("success")) {
                    if (verify == a) {
                        session.removeAttribute(phone);
                        return re.SUCCESS();
                    }
                }else if (time.TimeContrast(date, 3).equals("error")) {
                    return re.TimeOut();
                }
            }
        }
        return re.ERROR();
    }
}