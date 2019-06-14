package com.mylike.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.mylike.entity.Complain;
import com.mylike.service.ComplainService;
import com.mylike.utils.DateUtils;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/complain")
public class ComplainApi {

//    调用返回封装文件
    private ReturnDiscern re = new ReturnDiscern();
//  调用时间
    private DateUtils dateUtils = new DateUtils();
//    service
    @Autowired
    private ComplainService service;

//    添加
    @RequestMapping("/addComplain")
    public Map<String,Object>AddComplain(@RequestBody Complain complain){
        complain.setAddtime(dateUtils.NewDate());
        int count = service.install(complain);
        if (count>0){
            return re.SUCCESS();
        }
        return re.ERROR();
    }
//    查询
    @RequestMapping("/selectComplain")
    public Map<String,Object>selectComplain(Integer state){
        return re.SUCCESSOBJ(service.selectComplain(state));
    }
//    更改处理状态
    @RequestMapping("/updateState")
    public Map<String,Object>updateState(@RequestBody Complain complain ){
        int count = 0;
        if (complain.getState()!=null && complain.getId()!=null){
            if (complain.getState()==0){
                complain.setState(1);
                count = service.updateState(complain);
            }else if(complain.getState()==1){
                complain.setState(0);
                count = service.updateState(complain);
            }
            if (count >0){
                return re.SUCCESS();
            }
        }
        return re.ERROR();
    }
//    添加备注
    @RequestMapping("/updateRemake")
    public Map<String,Object>updateRemake(@RequestBody Complain complain){
        int count = 0;
        if (complain.getId()!=null){
            count = service.updateState(complain);
        }
        if (count >0){
            return re.SUCCESS();
        }
        return re.ERROR();
    }
}
