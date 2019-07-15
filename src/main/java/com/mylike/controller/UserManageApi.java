package com.mylike.controller;

import com.mylike.entity.UserManage;
import com.mylike.service.UserManageService;
import com.mylike.utils.DateUtils;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/userManage")
@RestController
public class UserManageApi {
    @Autowired
    private UserManageService userManageService;

    //    时间utils
    private DateUtils data = new DateUtils();
    //    返回utils
    private ReturnDiscern re = new ReturnDiscern();



    //    登陆查询
    @RequestMapping("/userManageLogin")
    public Map<String, Object> userManageLogin(@RequestBody UserManage userManage, HttpSession session) {
        if (userManage.getmPhone() != null && userManage.getmPwd() != null ) {
            UserManage userManageObj = userManageService.selectObj(userManage);
            if(userManageObj!=null){
                session.setAttribute("userManageObj", userManageObj);
                return  re.SUCCESSOBJ(userManageObj);
            }else{
                return  re.ERRORMSG("账号或者密码错误");
            }
        }else{
            return  re.ERRORMSG("输入完善的账号或者密码信息");
        }
    }

    //    根据用户ID修改
    @RequestMapping("/updateUserManageById")
    public Map<String, Object> updateUserManageById(@RequestBody UserManage userManage) {
        if (userManage.getmId() != null) {
            //查找除了该用户ID外是否有手机号码是相同的
            UserManage cUser=new UserManage();
            cUser.setuID(userManage.getmId());
            cUser.setmPhone(userManage.getmPhone());
            UserManage userManageObj=userManageService.selectObj(cUser);
            if(userManageObj!=null){
                return  re.ERRORMSG("你所要修改的手机号码已被注册");
            }
            //查找除了该用户ID外是否有手机号码是相同的---结束


            userManageService.updateObj(userManage);
            return  re.SUCCESS();

        }else{
            return  re.ERRORMSG("缺少用户ID");
        }
    }

    //    登陆查询
    @RequestMapping("/userManageCheck")
    public Map<String, Object> userManageCheck(@RequestBody UserManage userManage, HttpSession session) {

        UserManage obj1= (UserManage) session.getAttribute("userManageObj");
            return re.SUCCESSOBJ(obj1);
    }


}
