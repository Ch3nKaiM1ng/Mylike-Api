package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Discuss implements Serializable {
    private Integer id;

    private Integer vId;

    private Integer aId;

    private Integer dId;

    private Integer uId;

    private Integer anId;

    private Integer parentId;

    private String content;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date addtime;

    private List<Anonymity> anonymity;

    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId ;
    }

    public Integer getParentId() {
        if("".equals(parentId)||parentId==null){
            return 0;//去除该属性的前后空格并进行非空非null判断
        }
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId ;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public List<Anonymity> getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(List<Anonymity> anonymit) {
        this.anonymity = anonymit;
    }
}