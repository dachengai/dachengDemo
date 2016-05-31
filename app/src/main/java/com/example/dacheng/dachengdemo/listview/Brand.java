package com.example.dacheng.dachengdemo.listview;

/**
 * Created by dacheng on 16/5/26.
 */
public class Brand {
    private String bandname;
    private int type;
    public Brand(String bandname){
        this.bandname = bandname;
    }
    public String getBandname() {
        return bandname;
    }
    public void setBandname(String bandname) {
        this.bandname = bandname;
    }

    public int getType() {
        return type;
    }
    public void setType(int type){
        if(type >= 0){
            this.type = type;
        }
    }
}
