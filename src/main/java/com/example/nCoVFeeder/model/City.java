package com.example.nCoVFeeder.model;

public class City {
    private String confirmedCount;

    private String curedCount;

    private String cityName;

    private String deadCount;

    private String suspectedCount;

    public String getConfirmedCount ()
    {
        return confirmedCount;
    }

    public void setConfirmedCount (String confirmedCount)
    {
        this.confirmedCount = confirmedCount;
    }

    public String getCuredCount ()
    {
        return curedCount;
    }

    public void setCuredCount (String curedCount)
    {
        this.curedCount = curedCount;
    }

    public String getCityName ()
    {
        return cityName;
    }

    public void setCityName (String cityName)
    {
        this.cityName = cityName;
    }

    public String getDeadCount ()
    {
        return deadCount;
    }

    public void setDeadCount (String deadCount)
    {
        this.deadCount = deadCount;
    }

    public String getSuspectedCount ()
    {
        return suspectedCount;
    }

    public void setSuspectedCount (String suspectedCount)
    {
        this.suspectedCount = suspectedCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [confirmedCount = "+confirmedCount+", curedCount = "+curedCount+", cityName = "+cityName+", deadCount = "+deadCount+", suspectedCount = "+suspectedCount+"]";
    }
}
