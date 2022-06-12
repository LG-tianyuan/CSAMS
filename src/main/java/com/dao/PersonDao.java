package com.dao;

import com.entity.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDao {
    //检测是否存在主码冲突
    public boolean Person_check(Connection con,String pno) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="select Pno from Person where Pno='"+pno+"';";
        ResultSet rs=sta.executeQuery(sql);
        if(rs.getRow()==0){
            rs.close();
            return false;
        }
        rs.close();
        return true;
    }
    //插入新用户信息
    public void Person_insert(Connection con, Person person) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="insert into Person values('"+person.getPno()+"','"+person.getPname()+"','"+person.getPuname()+"',";
        if(person.getPgrade().equals("")){
            sql += "null,";
        }else {
            sql += "'"+person.getPgrade()+"',";
        }
        if(person.getPcname().equals("")){
            sql += "null,";
        }else {
            sql += "'"+person.getPcname()+"',";
        }
        if(person.getPsex().equals("")){
            sql += "null,";
        }else {
            sql += "'"+person.getPsex()+"',";
        }
        if(person.getPage().equals("")){
            sql += "null,";
        }else {
            sql += "'"+person.getPage()+"',";
        }
        sql += "'"+person.getPdate()+"',";
        sql += "'"+person.getPtel()+"',";
        if(person.getPwechat().equals("")){
            sql += "null,";
        }else {
            sql += "'"+person.getPwechat()+"',";
        }
        if(person.getPqno().equals("")){
            sql += "null";
        }else {
            sql += "'"+person.getPqno()+"'";
        }
        sql += ");";
        sta.executeUpdate(sql);
    }
    public void Person_update(Connection con, Person person) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql;
        if(!person.getPname().equals("")){
            sql = "update Person set Pname='"+person.getPname()+"' where Pno='"+person.getPno()+"';";
            sta.executeUpdate(sql);
        }
        if(!person.getPgrade().equals("")){
            sql = "update Person set Pgrade='"+person.getPgrade()+"' where Pno='"+person.getPno()+"';";
            sta.executeUpdate(sql);
        }
        if(!person.getPcname().equals("")){
            sql = "update Person set Pcname='"+person.getPcname()+"' where Pno='"+person.getPno()+"';";
            sta.executeUpdate(sql);
        }
        if(!person.getPsex().equals("")){
            sql = "update Person set Psex='"+person.getPsex()+"' where Pno='"+person.getPno()+"';";
            sta.executeUpdate(sql);
        }
        if(!person.getPage().equals("")){
            sql = "update Person set Page='"+person.getPage()+"' where Pno='"+person.getPno()+"';";
            sta.executeUpdate(sql);
        }
        if(!person.getPtel().equals("")){
            sql = "update Person set Ptel='"+person.getPtel()+"' where Pno='"+person.getPno()+"';";
            sta.executeUpdate(sql);
        }
        if(!person.getPwechat().equals("")){
            sql = "update Person set Pwechat='"+person.getPwechat()+"' where Pno='"+person.getPno()+"';";
            sta.executeUpdate(sql);
        }
        if(!person.getPqno().equals("")){
            sql = "update Person set Pqno='"+person.getPqno()+"' where Pno='"+person.getPno()+"';";
            sta.executeUpdate(sql);
        }
    }
    public Person PersonalInfo(Connection con,String pno) throws SQLException{
        Person person = new Person();
        person.setPno(pno);
        Statement sta;
        sta=con.createStatement();
        String sql = "select * from Person where Pno='"+pno+"';";
        ResultSet rs=sta.executeQuery(sql);
        rs.next();
        person.setPname(rs.getString("Pname"));
        person.setPuname(rs.getString("Puname"));
        person.setPdate(rs.getString("Pdate"));
        person.setPtel(rs.getString("Ptel"));
        if(rs.getString("Page")!=null){
            person.setPage(rs.getString("Page"));
        }
        if(rs.getString("Pcname")!=null){
            person.setPcname(rs.getString("Pcname"));
        }
        if(rs.getString("Psex")!=null){
            person.setPsex(rs.getString("Psex"));
        }
        if(rs.getString("Pgrade")!=null){
            person.setPgrade(rs.getString("Pgrade"));
        }
        if(rs.getString("Pwechat")!=null){
            person.setPwechat(rs.getString("Pwechat"));
        }
        if(rs.getString("Pqno")!=null){
            person.setPqno(rs.getString("Pqno"));
        }
        rs.close();
        return person;
    }
    public String Personid(Connection con,String uname) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql = "select Pno from Person where Puname='"+uname+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String personid = rs.getString("Pno");
        rs.close();
        return personid;
    }
    public String Person_username(Connection con,String pno) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql = "select Puname from Person where Pno='"+pno+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String uname = rs.getString("Puname");
        rs.close();
        return uname;
    }
    public String Person_name(Connection con,String pno) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql = "select Pname from Person where Pno='"+pno+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String name = rs.getString("Pname");
        rs.close();
        return name;
    }
}
