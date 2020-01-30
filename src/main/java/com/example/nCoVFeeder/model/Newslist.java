package com.example.nCoVFeeder.model;

public class Newslist {
    private String confirmedCount;

    private String curedCount;

    private String provinceShortName;

    private String comment;

    private String provinceName;

    private String deadCount;

    private String suspectedCount;
    private City[] cities;


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

    public City[] getCities ()
    {
        return cities;
    }

    public void setCities (City[] cities)
    {
        this.cities = cities;
    }

    public String getProvinceShortName ()
    {
        return provinceShortName;
    }

    public void setProvinceShortName (String provinceShortName)
    {
        this.provinceShortName = provinceShortName;
    }

    public String getComment ()
    {
        return comment;
    }

    public void setComment (String comment)
    {
        this.comment = comment;
    }

    public String getProvinceName ()
    {
        return provinceName;
    }

    public void setProvinceName (String provinceName)
    {
        this.provinceName = provinceName;
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
        return "ClassPojo [confirmedCount = "+confirmedCount+", curedCount = "+curedCount+", cities = "+cities+", provinceShortName = "+provinceShortName+", comment = "+comment+", provinceName = "+provinceName+", deadCount = "+deadCount+", suspectedCount = "+suspectedCount+"]";
    }
}
