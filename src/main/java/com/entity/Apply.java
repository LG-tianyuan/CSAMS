package com.entity;

public class Apply {
    private String Ano;
    private String Atype;
    private String Acont;
    private String Apno;
    private String Adate;
    private String Apass;

    public String getAcont() {
        return Acont;
    }

    public String getAdate() {
        return Adate;
    }

    public String getAno() {
        return Ano;
    }

    public String getApass() {
        return Apass;
    }

    public String getApno() {
        return Apno;
    }

    public String getAtype() {
        return Atype;
    }

    public void setAcont(String acont) {
        Acont = acont;
    }

    public void setAdate(String adate) {
        Adate = adate;
    }

    public void setAno(String ano) {
        Ano = ano;
    }

    public void setApass(String apass) {
        Apass = apass;
    }

    public void setApno(String apno) {
        Apno = apno;
    }

    public void setAtype(String atype) {
        Atype = atype;
    }
    public  Apply(){
        Ano="";
        Atype="";
        Acont="";
        Apno="";
        Adate="";
        Apass="";
    }
    public Apply(String ano,String atype,String acont,String apno,String adate,String apass){
        Ano=ano;
        Atype=atype;
        Acont=acont;
        Apno=apno;
        Adate=adate;
        Apass=apass;
    }
}
