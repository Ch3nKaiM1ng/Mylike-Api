package com.mylike.entity;

public class Anonymity {
    private Integer aId;

    private String aName;

    private String aHendpic;

    private String aAddtime;

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

    public String getaAddtime() {
        return aAddtime;
    }

    public void setaAddtime(String aAddtime) {
        this.aAddtime = aAddtime == null ? null : aAddtime.trim();
    }
}