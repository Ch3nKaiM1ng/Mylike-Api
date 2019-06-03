package com.mylike.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.mylike.dto.DynamicDTO;
import com.mylike.entity.Dynamic;
import com.mylike.service.DiscussService;
import com.mylike.service.DynamicService;
import com.mylike.utils.DiscussDTO;
import com.mylike.utils.ReturnDiscern;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/dynamic")
public class DynamicApi {

    @Autowired
    private DynamicService dynamicService;

    //  评价
    @Autowired
    private DiscussService discussService;
    //  return
    private ReturnDiscern re = new ReturnDiscern();
    //  递归
    private DiscussDTO disTo = new DiscussDTO();

    //    心得/动态添加
    @RequestMapping("/addDynamic")
    public Map<String, Object> addDynamic(@RequestBody Dynamic dynamic) {
        dynamic.setdAddtime(new Date());
        System.out.println(dynamic.toString());
        dynamicService.insert(dynamic);
        if (dynamic.getdId() == null) {
            return re.ERROR();
        }
        return re.SUCCESS();
    }

    //        首页心得/动态主页查询
    @RequestMapping("/showDynamic")
    public Map<String, Object> showDynamic() {
        List<Dynamic> dynamics = dynamicService.selectAll();
        List<DynamicDTO> list = new ArrayList<>();
        for (Dynamic dynamic : dynamics) {
            DynamicDTO dynamicDTO = new DynamicDTO();
            BeanUtils.copyProperties(dynamic, dynamicDTO);
            Integer count = this.discussService.showCountByDid(dynamic.getdId());
            dynamicDTO.setDiscussNum(count);
            list.add(dynamicDTO);
        }
        return re.SUCCESSOBJ(list);
    }

    //    首页心得/动态主页查询
    @RequestMapping("/showDynamicForHide")
    public Map<String, Object> showDynamicForHide(@Param("startId") String startId, String endId) {
        List<Dynamic> dynamics = dynamicService.selectcForHide(startId, endId);
        List<DynamicDTO> list = new ArrayList<>();
        for (Dynamic dynamic : dynamics) {
            DynamicDTO dynamicDTO = new DynamicDTO();
            BeanUtils.copyProperties(dynamic, dynamicDTO);
            Integer count = this.discussService.showCountByDid(dynamic.getdId());
            dynamicDTO.setDiscussNum(count);
            list.add(dynamicDTO);
        }
        return re.SUCCESSOBJ(list);
    }

    //    心得/动态单个查询
    @RequestMapping("/showDynamicById")
    public Map<String, Object> showDynamicById(@RequestParam("dId") Integer dId) {
        Map<String, Object> map = new HashMap<>();
        Dynamic dynamic = dynamicService.showDynamicById(dId);
        if (dynamic.getdId() != null) {
            map.putAll(re.SUCCESSOBJ(dynamic));
//        查询评价
            map.put("discuss", disTo.convert(0, discussService.selectByDId(dId)));
            //浏览量加一
            this.dynamicService.addBrowseNum(dId);
            return map;
        }
        return re.ERROR();
    }

    //    心得点赞
    @RequestMapping("/dynamicLike")
    public Map<String, Object> dynamicLike(Integer dId) {
        dynamicService.dynamicLike(dId);
        return re.SUCCESS();
    }

    //    心得修改
    @RequestMapping("/updateDynamic")
    public Map<String, Object> updateDynamic(@RequestBody Dynamic dynamic) {
        if (dynamic.getdId() != null) {
            dynamicService.updateDynamic(dynamic);
            return re.SUCCESS();
        }
        return re.ERROR();
    }

    //    心得删除
    @RequestMapping("/delectDynamic")
    public Map<String, Object> deldectDynamic(Integer dId) {
        if (dId != null) {
            dynamicService.delecetDynamic(dId);
            return re.SUCCESS();
        }
        return re.ERROR();
    }

    //    所有查询
    @RequestMapping("/showAll")
    public Map<String, Object> showAll() {
        return re.SUCCESSOBJ(dynamicService.showAll());
    }


    @RequestMapping("/giveALike")
    public Map<String, Object> giveALike(@RequestParam("dId") Integer dId) {

        Dynamic oldDynamic = this.dynamicService.showDynamicById(dId);
        if (oldDynamic == null) {
            return re.ERROR();
        }
        Dynamic dynamic = new Dynamic();
        dynamic.setdId(dId);
        int likeNum = oldDynamic.getdLike() == null ? 0 : oldDynamic.getdLike();
        dynamic.setdLike(++likeNum);

        this.dynamicService.updateDynamic(dynamic);

        return re.SUCCESS();
    }


    @RequestMapping("/page")
    public Page<Dynamic> page(@RequestParam("index") Integer index) {

        Page<Dynamic> page = new Page<>(index, 10);

//        page.setCondition(condition);

        return this.dynamicService.pageList(page);
    }
}
