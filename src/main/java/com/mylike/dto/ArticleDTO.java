package com.mylike.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ArticleDTO implements Serializable {
    private Integer aId;

    private String aTitle;

    private String aContent;

    private String aCoverimg;

    private String aSignature;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date aAddtime;

    private String aSynopsis;

    private Integer aSortId;

    private Integer aSonId;
    //评论数
    private Integer discussNum;

    private String  aLabel;

    private Integer aNum;

    private Integer aBrowse;

    private Integer boutique;

    public Integer getaBrowse() {
        return aBrowse;
    }

    public void setaBrowse(Integer aBrowse) {
        this.aBrowse = aBrowse;
    }

    public Integer getBoutique() {
        return boutique;
    }

    public void setBoutique(Integer boutique) {
        this.boutique = boutique;
    }

    public Integer getaNum() {
        return aNum;
    }

    public void setaNum(Integer aNum) {
        this.aNum = aNum;
    }


    public String getaLabel() {
        return aLabel;
    }

    public void setaLabel(String aLabel) {
        this.aLabel = aLabel;
    }

    public Integer getDiscussNum() {
        return discussNum;
    }

    public void setDiscussNum(Integer discussNum) {
        this.discussNum = discussNum;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle == null ? null : aTitle.trim();
    }

    public String getaContent() {
        return aContent;
    }

    public void setaContent(String aContent) {
        this.aContent = aContent == null ? null : aContent.trim();
    }

    public String getaCoverimg() {
        return aCoverimg;
    }

    public void setaCoverimg(String aCoverimg) {
        this.aCoverimg = aCoverimg == null ? null : aCoverimg.trim();
    }

    public String getaSignature() {
        return aSignature;
    }

    public void setaSignature(String aSignature) {
        this.aSignature = aSignature == null ? null : aSignature.trim();
    }

    public Date getaAddtime() {
        return aAddtime;
    }

    public void setaAddtime(Date aAddtime) {
        this.aAddtime = aAddtime;
    }

    public String getaSynopsis() {
        return aSynopsis;
    }

    public void setaSynopsis(String aSynopsis) {
        this.aSynopsis = aSynopsis == null ? null : aSynopsis.trim();
    }

    public Integer getaSortId() {
        return aSortId;
    }

    public void setaSortId(Integer aSortId) {
        this.aSortId = aSortId;
    }

    public Integer getaSonId() {
        return aSonId;
    }

    public void setaSonId(Integer aSonId) {
        this.aSonId = aSonId;
    }
}