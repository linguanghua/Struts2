package com.junxu.po;

/**
 * Created by LinXu on 2016/12/19.
 */
public class Student {
    private int id;
    private String name;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    public Student(){

    }
}
