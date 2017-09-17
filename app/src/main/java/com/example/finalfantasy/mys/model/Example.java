package com.example.finalfantasy.mys.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class Example {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<com.example.finalfantasy.mys.model.List> list = null;
    @SerializedName("city")
    @Expose
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.example.finalfantasy.mys.model.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.finalfantasy.mys.model.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }
    public List<List<com.example.finalfantasy.mys.model.List>> getFillLists()
    {
        List<List<com.example.finalfantasy.mys.model.List>> mL= new ArrayList<List<com.example.finalfantasy.mys.model.List>>();
        for(int i=0;i<5;i++)
        {
            Calendar c=Calendar.getInstance();
            c.set(Calendar.DAY_OF_YEAR,c.get(Calendar.DAY_OF_YEAR)+i);
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            String text = dateFormat.format(c.getTime());
            List<com.example.finalfantasy.mys.model.List> mA=new ArrayList<com.example.finalfantasy.mys.model.List>();

            for(int j=0;j<list.size();j++)
            {
                String s=list.get(j).getDtTxt().substring(2,10);
                if(text.equals(s))
                {
                    boolean a=true;
                    mA.add(list.get(j));
                }
            }
            mL.add(mA);

        }
        return mL;
    }
    public void setCity(City city) {
        this.city = city;
    }

}
