package com.mylike.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.mylike.dto.ArticleDTO;
import com.mylike.entity.Article;
import com.mylike.entity.FloatWindow;
import com.mylike.service.ArticleService;
import com.mylike.service.DiscussService;
import com.mylike.service.FloatWindowService;
import com.mylike.utils.DateUtils;
import com.mylike.utils.DiscussDTO;
import com.mylike.utils.ReturnDiscern;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/floatWindow")
@RestController
public class FloatWindowApi {
    /*@Autowired
    private ArticleService articleService;*/
    @Autowired
    private FloatWindowService floatWindowService;

    //    时间utils
    private DateUtils data = new DateUtils();
    //    返回utils
    private ReturnDiscern re = new ReturnDiscern();

    //  添加浮框
    @RequestMapping("/addFloatWindow")
    public Map<String, Object> addFloatWindow(@RequestBody FloatWindow floatWindow) {
        floatWindowService.insertFloat(floatWindow);
        if (floatWindow.getId() != null) {
            return re.SUCCESS();
        }
        return re.ERROR();
    }

    //    查询全部浮框
    @RequestMapping("/findAllFloatWindow")
    public Map<String, Object> findAllFloatWindow() {

        List<FloatWindow> floatWindowList = floatWindowService.selectAll();
        return re.SUCCESSOBJ(floatWindowList);
    }

    //    根据ID查询浮框
    @RequestMapping("/findFloatWindowById")
    public Map<String, Object> findFloatWindowById(@RequestBody FloatWindow floatWindow) {
        System.out.print(floatWindow.getId());
        if (floatWindow.getId() != null) {
            return  re.SUCCESSOBJ(floatWindowService.selectObj(floatWindow));

        }else{
            return  re.ERROR();
        }
    }

    //    根据ID修改浮框
    @RequestMapping("/updateFloatWindowById")
    public Map<String, Object> updateFloatWindowById(@RequestBody FloatWindow floatWindow) {
        if (floatWindow.getId() != null) {
            floatWindowService.updateFloat(floatWindow);
            return re.SUCCESS();
        }
        return re.ERROR();
    }

    //    根据ID假删除浮框
    @RequestMapping("/delectFloatWindow")
    public Map<String, Object> delectFloatWindow(@RequestBody FloatWindow floatWindow) {
        if (floatWindow.getId() != null) {
            floatWindow.setStatus(1);//将浮框状态改为1实现删除
            floatWindowService.updateFloat(floatWindow);
            return re.SUCCESS();
        }
        return re.ERROR();
    }


}
