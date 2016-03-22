package com.example.dacheng.dachengdemo.recyclerview.data;

/**
 * Created by dacheng on 16/3/10.
 */
public class RecyclerViewItemData {
    public int type;//必需
    public String title;
    public String subTitle;

    public RecyclerViewItemData(int type, String title, String subTitle) {
        this.type = type;
        this.title = title;
        this.subTitle = subTitle;
    }
}
