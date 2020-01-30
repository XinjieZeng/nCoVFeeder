package com.example.nCoVFeeder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RumorList {
    private String date;

    private String explain;

    private String author;

    private String markstyle;

    private String id;

    private String title;

    @JsonIgnore
    private String imgsrc;

    private String desc;

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getExplain ()
    {
        return explain;
    }

    public void setExplain (String explain)
    {
        this.explain = explain;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getMarkstyle ()
    {
        return markstyle;
    }

    public void setMarkstyle (String markstyle)
    {
        this.markstyle = markstyle;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getImgsrc ()
    {
        return imgsrc;
    }

    public void setImgsrc (String imgsrc)
    {
        this.imgsrc = imgsrc;
    }

    public String getDesc ()
    {
        return desc;
    }

    public void setDesc (String desc)
    {
        this.desc = desc;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", explain = "+explain+", author = "+author+", markstyle = "+markstyle+", id = "+id+", title = "+title+", imgsrc = "+imgsrc+", desc = "+desc+"]";
    }
}
