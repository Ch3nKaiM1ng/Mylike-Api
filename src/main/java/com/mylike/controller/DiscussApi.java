package com.mylike.controller;


import com.mylike.entity.Discuss;
import com.mylike.service.DiscussService;
import com.mylike.utils.DiscussDTO;
import com.mylike.utils.ReturnDiscern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/discuss")
@RestController
public class DiscussApi {
    @Autowired
    private DiscussService discussService;
    private ReturnDiscern re = new ReturnDiscern();

    //  递归
    private DiscussDTO disTo = new DiscussDTO();

    //  添加评论
    @RequestMapping("/addDiscuss")
    public Map<String, Object> addDiscuss(@RequestBody Discuss discuss) {
        discuss.setIsDelete(0);
        discussService.insert(discuss);
        if (discuss.getId() != null) {
            return re.SUCCESS();
        }
        return re.ERROR();
    }

    //    查询单个评论
    @RequestMapping("/showDiscussById")
    public Map<String, Object> showDiscussById(int id) {
        List<Discuss> discuss = discussService.showDiscussById(id);
        int num = 0;
        for (Discuss discuss1 : discuss) {
            if (discuss1.getId() == id) {
                num = discuss1.getParentId();
            }
        }
        return re.SUCCESSOBJ(disTo.convert(num, discuss));
    }

    /**
     * 修改评论
     */
    @RequestMapping("/update")
    public Map<String, Object> update(@RequestParam("id") Integer id, @RequestParam("content") String content,@RequestParam("parentId")Integer parentId) {
        Discuss discuss = new Discuss();
        discuss.setId(id);
        discuss.setContent(content);
        discuss.setParentId(parentId);
        //修改删除状态
        discuss.setIsDelete(0);
        int count = this.discussService.update(discuss);
        if (count > 0) {
            return re.SUCCESS();
        } else {
            return re.ERROR();
        }
    }

    /**
     * 逻辑删除评论
     */
    @RequestMapping("/delete")
    public Map<String, Object> update(@RequestParam("id") Integer id) {
        Discuss discuss = new Discuss();
        discuss.setId(id);
        discuss.setContent("此评论已删除");
        discuss.setIsDelete(1);
        int count = this.discussService.delectById(discuss);
        if (count > 0) {
            return re.SUCCESS();
        } else {
            return re.ERROR();
        }
    }
}
