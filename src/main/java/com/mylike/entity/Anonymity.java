package com.mylike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Anonymity implements Serializable {
    private Integer aId;

    private String aName;

    private String aHendpic;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date aAddtime;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getaHendpic() {
        return aHendpic;
    }

    public void setaHendpic(String aHendpic) {
        this.aHendpic = aHendpic == null ? null : aHendpic.trim();
    }

    public Date getaAddtime() {
        return aAddtime;
    }

    public void setaAddtime(Date aAddtime) {
        this.aAddtime = aAddtime;
    }
}