package com.nmid.items.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Talk {
    private Integer tid;

    private String context;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date talkTime;

    private Integer talkUserid;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Date getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(Date talkTime) {
        this.talkTime = talkTime;
    }

    public Integer getTalkUserid() {
        return talkUserid;
    }

    public void setTalkUserid(Integer talkUserid) {
        this.talkUserid = talkUserid;
    }
}