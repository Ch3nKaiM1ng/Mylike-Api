package com.mylike.controller.view;

import com.google.gson.JsonObject;
import com.mylike.entity.UserManage;
import com.mylike.service.UserManageService;
import com.mylike.utils.DateUtils;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/test")
@Controller
public class ViewController {
    @Autowired
    private UserManageService userManageService;

    //    时间utils
    private DateUtils data = new DateUtils();
    //    返回utils
    private ReturnDiscern re = new ReturnDiscern();



    //    登陆查询
    @RequestMapping("/testH5")
    public ModelAndView testView(HttpSession session) {
        ModelAndView mv=new ModelAndView();
        UserManage obj1= (UserManage) session.getAttribute("userManageObj");
        mv.addObject("uesrObj",obj1);
        mv.setViewName("test");
        return mv;
    }
    //    登陆查询
    @RequestMapping("/testLogin")
    public ModelAndView testLogin(HttpSession session) {
        UserManage userManage=new UserManage();
        userManage.setmId(1);
        UserManage userManageObj = userManageService.selectObj(userManage);
        session.setAttribute("userManageObj",userManageObj);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("test");
        return mv;
    }
}
