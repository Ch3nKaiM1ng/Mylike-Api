package com.mylike.controller;

import com.mylike.entity.ClientUser;
import com.mylike.entity.PhoneRecord;
import com.mylike.service.ClientUserService;
import com.mylike.service.PhoneRecordService;
import com.mylike.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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
    @Autowired
    private ClientUserService clientUserService;
    @Autowired
    private PhoneRecordService phoneRecordService;

    // 判定session
    @RequestMapping("/register")
    public Map<String, Object> register(@RequestParam("phone") String phone, HttpServletRequest req) {

        String time = (String) req.getSession().getAttribute("v-expires");

        if (time == null || this.time.timeCompare(time, 1)) {
            //设置验证码过期时间
            req.getSession().setAttribute("v-expires", dateUtils.Fornat(dateUtils.NewDate()));
        } else {
            //检验是否间隔一分钟
            return re.TimeError(1);
        }

        int randNum = new Random().nextInt(9999 - 1000) + 1000;
        req.getSession().setAttribute(phone, randNum);

        return SendMessage(phone, randNum);
    }

    //    申请短信验证
    public Map<String, Object> SendMessage(String phone, int randNum) {
        String code = sms.SmsCode(String.valueOf(randNum), phone);

        return massageReturn.CodeVerify(code);
    }

    //  验证
    @RequestMapping("/verification")
    public Map<String, Object> verification(String phone, int verify, HttpServletRequest req, HttpServletResponse response) {
//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName());
//        }

        HttpSession session = req.getSession();
        phone = phone.trim();
        String date = (String) session.getAttribute("v-expires");

        if (session.getAttribute(phone) == null && date == null) {
            return re.ERROR();
        }
        if (!time.timeCompare(date, 3)) {
            if (verify == (Integer) session.getAttribute(phone)) {
                if (this.clientUserService.showByPhone(phone) == null) {
                    //保存用户信息
                    ClientUser clientUser = new ClientUser();
                    clientUser.setcAccNumber(phone);
                    clientUser.setcNickname(phone);
                    clientUser.setcStatus("1"); //1启用，0停用
                    clientUser.setcPhone(phone);
                    this.clientUserService.addOrUpdate(clientUser);

                    session.removeAttribute(phone);
                }
            }
        } else if (time.timeCompare(date, 3)) {
            return re.TimeOut();
        }

        String token = UUID.randomUUID().toString();
//        Cookie cookie = new Cookie("token", token);
//        cookie.setPath("/");
//        cookie.setMaxAge(3600);//设置cookie过期时间为1个小时
//        response.addCookie(cookie);
        session.setAttribute("token", token);
        return re.SUCCESS();
    }

    /**
     * 记录手机号码
     */
    @RequestMapping("/addPhoneRecord")
    public Map<String, Object> addPhoneRecord(@RequestParam("phone") String phone) {
        PhoneRecord phoneRecord = new PhoneRecord();
        phoneRecord.setPhone(phone);
        this.phoneRecordService.addOrUpdate(phoneRecord);
        return re.SUCCESS();
    }

}