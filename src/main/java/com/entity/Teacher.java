package com.entity;

public class Teacher {
    private String Tno;
    private String Tname;
    private String Tjob;
    private String Ttel;
    private String Tcname;
    private String Tintro;

    public String getTno() {
        return Tno;
    }

    public String getTcname() {
        return Tcname;
    }

    public String getTname() {
        return Tname;
    }

    public String getTjob() {
        return Tjob;
    }

    public String getTtel() {
        return Ttel;
    }

    public String getTintro() {
        return Tintro;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public void setTjob(String tjob) {
        Tjob = tjob;
    }

    public void setTtel(String ttel) {
        Ttel = ttel;
    }

    public void setTcno(String tcname) {
        Tcname = tcname;
    }

    public void setTintro(String tintro) {
        Tintro = tintro;
    }
    public Teacher()
    {
        Tcname="";
        Tno="";
        Tintro="";
        Tjob="";
        Tname="";
        Ttel="";
    }
    public Teacher(String tno,String tname,String tjob,String ttel,String tcname,String tintro){
        Tno=tno;
        Ttel=ttel;
        Tjob=tjob;
        Tname=tname;
        Tintro=tintro;
        Tcname=tcname;
    }
}
