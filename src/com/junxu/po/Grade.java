package com.junxu.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LinXu on 2016/12/19.
 */
public class Grade {
    private int gid;
    private String gname;
    private String ginfo;
    private Set<Student> students = new HashSet<Student>();

    public Grade(int gid, String gname, String ginfo, Set<Student> students) {
        this.gid = gid;
        this.gname = gname;
        this.ginfo = ginfo;
        this.students = students;
    }
    public Grade(String gname, String ginfo){
        this.gname = gname;
        this.ginfo = ginfo;
    }
    public Grade(){

    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGinfo() {
        return ginfo;
    }

    public void setGinfo(String ginfo) {
        this.ginfo = ginfo;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
