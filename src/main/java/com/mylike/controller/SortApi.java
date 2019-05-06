package com.mylike.controller;

import com.mylike.entity.Sort;
import com.mylike.service.SortService;
import com.mylike.utils.ReturnDiscern;
import com.mylike.utils.SortDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sort")
public class SortApi {

    @Autowired
    private SortService service;

    private ReturnDiscern re = new ReturnDiscern();

    private SortDTO dto = new SortDTO();

    //展示all
    @RequestMapping("/showSort")
    public Map<String,Object> showAllSort(){
        List<Sort> sort = service.selectAll();
        return re.SUCCESSOBJ(dto.convert(0,sort));
    }
//    通过父分类ID展示子分类
    @RequestMapping("/showSortById")
    public Map<String,Object> showSortById(int sSid){
        System.out.println("---------"+sSid+"1111111");
        List<Sort> sort = service.showSortById(sSid);
        for (Sort sort1:sort){
            System.out.println(sort1.toString());
        }
        return re.SUCCESSOBJ(dto.convert(sSid,sort));
    }
//    添加分类
    @RequestMapping("/addSort")
    public Map<String,Object> addSort(Sort sort){
        service.insert(sort);
        if (sort.getsId()==null){
            return re.ERROR();
        }else {
            return re.SUCCESS();
        }
    }
    @RequestMapping("/delectSort")
    public Map<String,Object>delectSort(int sId){
        service.delectSort(sId);
        return re.SUCCESS();
    }
}
