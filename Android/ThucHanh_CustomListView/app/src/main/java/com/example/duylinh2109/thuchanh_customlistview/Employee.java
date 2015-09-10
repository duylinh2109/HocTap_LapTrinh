package com.example.duylinh2109.thuchanh_customlistview;

/**
 * Created by duylinh2109 on 9/9/2015.
 */
public class Employee {
    private String id;
    private String name;
    private boolean gender;

    public String getId()
    {
        return id;
    }

    public  void setId(String _id)
    {
        id= _id;
    }

    public String getName()
    {
        return  name;
    }

    public void setName(String _name)
    {
        name=_name;
    }

    public  boolean isGender()
    {
        return  gender;
    }

    public void setGender(boolean _gender)
    {
        gender= _gender;
    }

    public String toString()
    {
        return this.id+"-"+this.name;
    }
}
