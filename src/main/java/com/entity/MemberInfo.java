package com.entity;

public class MemberInfo {
    private String Mono;
    private String Pno;
    private String Pname;
    private String Pgrade;
    private String Mjob;
    private String Mjoin;
    private String Pcname;
    private String Psex;
    private String Ptel;
    private String Pwechat;
    private String Pqno;

    public String getMono() {
        return Mono;
    }

    public String getMjoin() {
        return Mjoin;
    }

    public String getMjob() {
        return Mjob;
    }

    public String getPqno() {
        return Pqno;
    }

    public String getPwechat() {
        return Pwechat;
    }

    public String getPtel() {
        return Ptel;
    }

    public String getPcname() {
        return Pcname;
    }

    public String getPno() {
        return Pno;
    }

    public String getPsex() {
        return Psex;
    }

    public String getPgrade() {
        return Pgrade;
    }

    public String getPname() {
        return Pname;
    }

    public void setMono(String mono) {
        Mono = mono;
    }

    public void setMjoin(String mjoin) {
        Mjoin = mjoin;
    }

    public void setPwechat(String pwechat) {
        Pwechat = pwechat;
    }

    public void setMjob(String mjob) {
        Mjob = mjob;
    }

    public void setPtel(String ptel) {
        Ptel = ptel;
    }

    public void setPsex(String psex) {
        Psex = psex;
    }

    public void setPqno(String pqno) {
        Pqno = pqno;
    }

    public void setPgrade(String pgrade) {
        Pgrade = pgrade;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public void setPno(String pno) {
        Pno = pno;
    }

    public void setPcname(String pcname) {
        Pcname = pcname;
    }

    public MemberInfo() {
        Mono = "";
        Pno = "";
        Pname = "";
        Pgrade = "";
        Mjob = "";
        Mjoin = "";
        Pcname = "";
        Psex = "";
        Ptel = "";
        Pwechat = "";
        Pqno = "";
    }
    public MemberInfo(String mono,String pno,String pname,String pgrade,String mjob,String mjoin,String pcname,String psex, String ptel,String pwechat,String pqno) {
        Mono = mono;
        Pno = pno;
        Pname = pname;
        Pgrade = pgrade;
        Mjob = mjob;
        Mjoin = mjoin;
        Pcname = pcname;
        Psex = psex;
        Ptel = ptel;
        Pwechat = pwechat;
        Pqno = pqno;
    }
}
