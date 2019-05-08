package com.mylike.controller;

import com.mylike.entity.Doctor;
import com.mylike.entity.Subscribe;
import com.mylike.service.DoctorService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/doctor")
public class DoctorApi {
    @Autowired
    private DoctorService service;

    private ReturnDiscern re = new ReturnDiscern();

//查询医生·总
    @RequestMapping("/showdoctor_other")
    public List<Doctor> showdoctor_other(String doctor){
        return service.selectother();
    }
//    查询单个医生
    @RequestMapping("/showdoctor")
    public Doctor showdoctor(String dId){
       return service.selectAll(dId);
    }
//    预约
    @RequestMapping("/subscribe")
    public Map<String,Object> subscribe(@RequestBody Subscribe subscribe){
        service.insertSub(subscribe);
        if (subscribe.getsId()==null){
            return re.ERROR();
        }
        return re.SUCCESS();
    }
    //添加医生
    @RequestMapping("/addDoctor")
    public Map<String,Object> addDoctor(@RequestBody Doctor doctor){
        service.insertdoctor(doctor);
        if (doctor.getdId()==null){
            return re.ERROR();
        }
        return re.SUCCESSOBJ(doctor);
    }
//    查询所有医生
    @RequestMapping("/showDocAll")
    public Map<String,Object> showDocAll(){
        return re.SUCCESSOBJ(service.selectDocAll());
    }
//    修改医生
    @RequestMapping("/updateDoc")
    public Map<String,Object> updateDoc(@RequestBody Doctor doctor){
        if (doctor.getdId()!=null){
            service.updateDoc(doctor);
            return re.SUCCESS();
        }
        return re.ERROR();
    }
}

