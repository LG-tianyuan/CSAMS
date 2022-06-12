package com.dao;

import com.entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDao {
    //检测是否存在主码冲突
    public boolean Teacher_check1(Connection con, String tno) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="select * from Teacher where Tno='"+tno+"';";
        ResultSet rs=sta.executeQuery(sql);
        rs.next();
        if(rs.getRow()==0){
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }
    public boolean Teacher_check2(Connection con, String tname) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="select * from Teacher where Tname='"+tname+"';";
        ResultSet rs=sta.executeQuery(sql);
        rs.next();
        if(rs.getRow()==0){
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }
    public void Teacher_insert(Connection con, Teacher teacher) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="insert into Teacher values('"+teacher.getTno()+"','"+teacher.getTname()+"',";
        if(teacher.getTjob().equals("")){
            sql += "null,";
        }else {
            sql += "'"+teacher.getTjob()+"',";
        }
        sql += "'"+teacher.getTtel()+"',";
        if(teacher.getTcname().equals("")){
            sql += "null,";
        }else {
            sql += "'"+teacher.getTcname()+"',";
        }
        if(teacher.getTintro().equals("")){
            sql += "null";
        }else {
            sql += "'"+teacher.getTintro()+"'";
        }
        sql += ");";
        sta.executeUpdate(sql);
    }

    public void Teacher_update(Connection con,Teacher teacher)throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql;
        if(!teacher.getTname().equals("")){
            sql = "update Teacher set Tname='"+teacher.getTname()+"' where Tno='"+teacher.getTno()+"';";
            sta.executeUpdate(sql);
        }
        if(!teacher.getTjob().equals("")){
            sql = "update Teacher set Tjob='"+teacher.getTjob()+"' where Tno='"+teacher.getTno()+"';";
            sta.executeUpdate(sql);
        }
        if(!teacher.getTtel().equals("")){
            sql = "update Teacher set Ttel='"+teacher.getTtel()+"' where Tno='"+teacher.getTno()+"';";
            sta.executeUpdate(sql);
        }
        if(!teacher.getTcname().equals("")){
            sql = "update Teacher set Tcname='"+teacher.getTcname()+"' where Tno='"+teacher.getTno()+"';";
            sta.executeUpdate(sql);
        }
        if(!teacher.getTintro().equals("")){
            sql = "update Teacher set Tintro='"+teacher.getTintro()+"' where Tno='"+teacher.getTno()+"';";
            sta.executeUpdate(sql);
        }
    }
    public void Teacher_delete(Connection con,String tno) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql = "delete from Teacher where Tno='"+tno+"';";
        sta.executeUpdate(sql);
    }
    public Teacher Teacher_Info(Connection con,String tno) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql = "select * from Teacher where Tno='"+tno+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        Teacher teacher = new Teacher(rs.getString("Tno"),rs.getString("Tname"),
                rs.getString("Tjob"),rs.getString("Ttel"), rs.getString("Tcname"),
                rs.getString("Tintro"));
        rs.close();
        return teacher;
    }
    public String Teacher_name(Connection con,String tno) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql = "select Tname from Teacher where Tno='"+tno+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String name = rs.getString("Tname");
        rs.close();
        return name;
    }
    public String Teacher_id(Connection con,String tname) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql = "select Tno from Teacher where Tname='"+tname+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String tno = rs.getString("Tno");
        rs.close();
        return tno;
    }
}
