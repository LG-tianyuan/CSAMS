package com.entity;

public class College {
    private String Cno;
    private String Cname;

    public String getCname() {
        return Cname;
    }

    public String getCno() {
        return Cno;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public void setCno(String cno) {
        Cno = cno;
    }
    public College() {
        Cno="";
        Cname="";
    }
    public College(String cno,String cname) {
        Cno=cno;
        Cname=cname;
    }
}
