package com.example.nCoVFeeder.model;

public class CoronavirusProgress {
    private String msg;

    private String code;

    private Newslist[] newslist;

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

    public Newslist[] getNewslist ()
    {
        return newslist;
    }

    public void setNewslist (Newslist[] newslist)
    {
        this.newslist = newslist;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+", code = "+code+", newslist = "+newslist+"]";
    }
}
