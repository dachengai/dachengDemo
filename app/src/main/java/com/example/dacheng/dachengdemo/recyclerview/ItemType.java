package com.example.dacheng.dachengdemo.recyclerview;

import com.example.dacheng.dachengdemo.recyclerview.viewholder.ViewHolderOne;
import com.example.dacheng.dachengdemo.recyclerview.viewholder.ViewHolderThree;
import com.example.dacheng.dachengdemo.recyclerview.viewholder.ViewHolderTwo;

/**
 * Created by dacheng on 16/3/10.
 */
public enum ItemType {
    DEFAULT_TYPE(0,new ViewHolderOne.FactoryOne()),
    TYPE_ONE(1,new ViewHolderOne.FactoryOne()),
    TYPE_TWO(2,new ViewHolderTwo.FactoryTwo()),
    TYPE_THREE(3,new ViewHolderThree.FactoryThree());


    private int mType;
    private IFactory mFactory;

    ItemType(int type,IFactory factory){
        mType = type;
        mFactory = factory;
    }

    public static IFactory getFactoryByType(int type){
        if(type > 0 && type < ItemType.values().length  ){
            return ItemType.values()[type].getFactory();
        }
        return ItemType.values()[0].getFactory();
    }

    public IFactory getFactory(){
        return mFactory;
    }
}
