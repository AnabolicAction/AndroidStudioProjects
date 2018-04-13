package com.example.student.p447;

import android.content.ClipData;

public class Item {
    String  name;
    String phone;
    int age;
    int resId;

    public Item(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public Item(String  name, String phone, int age, int resId){
     this.age=age;
     this.phone=phone;

     this.name=name;
     this.resId=resId;

    }


}
