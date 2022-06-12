package com.entity;

public class Member {
    private String Mono;
    private String Mpno;
    private String Mjob;
    private String Mjoin;

    public String getMjob() {
        return Mjob;
    }

    public String getMjoin() {
        return Mjoin;
    }

    public String getMono() {
        return Mono;
    }

    public String getMpno() {
        return Mpno;
    }

    public void setMjob(String mjob) {
        Mjob = mjob;
    }

    public void setMjoin(String mjoin) {
        Mjoin = mjoin;
    }

    public void setMono(String mono) {
        Mono = mono;
    }

    public void setMpno(String mpno) {
        Mpno = mpno;
    }

    public Member(){
        Mono="";
        Mpno="";
        Mjob="";
        Mjoin="";
    }
    public Member(String mono,String mpno,String mjob,String mjoin){
        Mono=mono;
        Mpno=mpno;
        Mjob=mjob;
        Mjoin=mjoin;
    }
}
