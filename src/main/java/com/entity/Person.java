package com.entity;

public class Person {
    private String Pno;
    private String Pname;
    private String Puname;
    private String Pgrade;
    private String Pcname;
    private String Psex;
    private String Page;
    private String Pdate;
    private String Ptel;
    private String Pwechat;
    private String Pqno;

    public String getPno() {
        return Pno;
    }

    public String getPname() {
        return Pname;
    }

    public String getPuname() {
        return Puname;
    }

    public String getPgrade() {
        return Pgrade;
    }

    public String getPcname() {
        return Pcname;
    }

    public String getPsex() {
        return Psex;
    }

    public String getPage() {
        return Page;
    }

    public String getPdate() {
        return Pdate;
    }

    public String getPtel() {
        return Ptel;
    }

    public String getPwechat() {
        return Pwechat;
    }

    public String getPqno() {
        return Pqno;
    }

    public void setPno(String pno) {
        Pno = pno;
    }

    public void setPage(String page) {
        Page = page;
    }

    public void setPcname(String pcname) {
        Pcname = pcname;
    }

    public void setPdate(String pdate) {
        Pdate = pdate;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public void setPgrade(String pgrade) {
        Pgrade = pgrade;
    }

    public void setPqno(String pqno) {
        Pqno = pqno;
    }

    public void setPsex(String psex) {
        Psex = psex;
    }

    public void setPtel(String ptel) {
        Ptel = ptel;
    }

    public void setPuname(String puname) {
        Puname = puname;
    }

    public void setPwechat(String pwechat) {
        Pwechat = pwechat;
    }
    public Person(){
        Pno="";
        Pname="";
        Puname="";
        Pgrade="";
        Pcname="";
        Psex="";
        Page="";
        Pdate="";
        Ptel="";
        Pwechat="";
        Pqno="";
    }
    public Person(String pno,String pname,String puname,String pgrade,String pcname,String psex,String page,String pdate,String ptel,String pwechat,String pqno){
        Pno=pno;
        Pname=pname;
        Puname=puname;
        Pgrade=pgrade;
        Pcname=pcname;
        Psex=psex;
        Page=page;
        Pdate=pdate;
        Ptel=ptel;
        Pwechat=pwechat;
        Pqno=pqno;
    }
}
