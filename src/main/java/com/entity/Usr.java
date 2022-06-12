package com.entity;

public class Usr {
    private String Uname;
    private String Upwd;
    private String Urank;
    public String getUname(){
        return Uname;
    }
    public String getUpwd(){
        return Upwd;
    }
    public String getUrank(){
        return Urank;
    }
    public void setUname(String uname) {
        Uname = uname;
    }
    public void setUpwd(String upwd) {
        Upwd = upwd;
    }
    public void setUrank(String urank) {
        Urank = urank;
    }
    public Usr()
    {
        Uname="";
        Upwd="";
        Urank="";
    }
    public Usr(String uname,String upwd,String urank)
    {
        Urank=urank;
        Uname=uname;
        Upwd=upwd;
    }
}
