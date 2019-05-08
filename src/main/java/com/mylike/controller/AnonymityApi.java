package com.mylike.controller;

import com.mylike.service.AnonymityService;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mylike.entity.Anonymity;

import java.util.List;
import java.util.Map;

@RequestMapping("/anonymity")
@RestController
public class AnonymityApi {

    @Autowired
    private AnonymityService service;

    private ReturnDiscern re = new ReturnDiscern();

//    查询所有匿名库name
    @RequestMapping("/selectAll")
    public Map<String,Object> selectAll(){
        List<Anonymity> anonymity = service.selectAll();
        return re.SUCCESSOBJ(anonymity);
    }
//    添加匿名
    @RequestMapping("/addName")
    public Map<String,Object> addName(@RequestBody Anonymity anonymity){
        service.addName(anonymity);
        if (anonymity.getaId()==null){
            return re.ERROR();
        }
        return re.SUCCESS();
    }
}
