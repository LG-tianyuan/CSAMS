package com.entity;

public class Organization {
    private String Ono;
    private String Oname;
    private String Opno;
    private String Otno;
    private String Ocname;
    private String Odate;
    private String Ocnt;
    private String Ointro;

    public String getOcname() {
        return Ocname;
    }

    public String getOcnt() {
        return Ocnt;
    }

    public String getOdate() {
        return Odate;
    }

    public String getOintro() {
        return Ointro;
    }

    public String getOname() {
        return Oname;
    }

    public String getOno() {
        return Ono;
    }

    public String getOpno() {
        return Opno;
    }

    public String getOtno() {
        return Otno;
    }

    public void setOcname(String ocname) {
        Ocname = ocname;
    }

    public void setOcnt(String ocnt) {
        Ocnt = ocnt;
    }

    public void setOdate(String odate) {
        Odate = odate;
    }

    public void setOintro(String ointro) {
        Ointro = ointro;
    }

    public void setOname(String oname) {
        Oname = oname;
    }

    public void setOno(String ono) {
        Ono = ono;
    }

    public void setOpno(String opno) {
        Opno = opno;
    }

    public void setOtno(String otno) {
        Otno = otno;
    }
    public Organization(){
        Oname="";
        Ono="";
        Opno="";
        Otno="";
        Ocname="";
        Odate="";
        Ocnt="";
        Ointro="";
    }
    public Organization(String ono,String oname,String opno,String otno,String  ocname,String odate,String ocnt,String ointro){
        Oname=oname;
        Ono=ono;
        Opno=opno;
        Otno=otno;
        Ocname=ocname;
        Odate=odate;
        Ocnt=ocnt;
        Ointro=ointro;
    }
}
