package com.example.lenovo.project;

import android.widget.ImageView;

public class Shirts {
    //ImageView image;
    String name;
    int price;
    int small;
    int medium;
    int large;
    int quantity;

    public Shirts(String n,int p,int s,int m,int l)
    {
        //this.image=im;
        this.name=n;
        this.price=p;
        this.small=s;
        this.medium=m;
        this.large=l;
        this.quantity=s+m+l;
    }
}
