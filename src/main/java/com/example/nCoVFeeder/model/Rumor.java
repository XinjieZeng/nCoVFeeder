package com.example.nCoVFeeder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Rumor {
    @JsonIgnore
    private String msg;

    @JsonIgnore
    private String code;

    private List<RumorList> newslist;

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public List<RumorList> getNewslist ()
    {
        return newslist;
    }

    public void setNewslist (List<RumorList> newslist)
    {
        this.newslist = newslist;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+", code = "+code+", newslist = "+newslist+"]";
    }
}
