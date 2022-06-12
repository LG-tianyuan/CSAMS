package com.dao;

import com.entity.College;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CollegeDao {
    //检测是否存在主码冲突
    public String College_check(Connection con, College college) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="select * from College where Cno='"+college.getCno()+"'";
        ResultSet rs=sta.executeQuery(sql);
        if(rs.getRow()!=0){
            rs.close();
            return "The college id already exist!";
        }
        sql = "select * from College where Cname='"+college.getCname()+"'";
        rs=sta.executeQuery(sql);
        if(rs.getRow()!=0){
            rs.close();
            return "The college name already exist!";
        }
        rs.close();
        return "success";
    }
    public void College_insert(Connection con, College college) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="insert into College values('"+college.getCno()+"','"+college.getCname()+"');";
        sta.executeUpdate(sql);
    }
    public void College_update(Connection con,College college) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="update College set Cname='"+college.getCname()+"' where Cno='"+college.getCno()+"';";
        sta.executeUpdate(sql);
    }
    public void College_delete(Connection con,String cno) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="delete from College where Cno='"+cno+"';";
        sta.executeUpdate(sql);
    }
    public String College_info(Connection con,String cno) throws SQLException{
        String cname;
        Statement sta;
        sta=con.createStatement();
        String sql="select Cname from College where Cno='"+cno+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        cname = rs.getString("Cname");
        return cname;
    }
    public String College_id(Connection con,String cname) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="select Cno from College where Cname='"+cname+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String cno = rs.getString("Cno");
        return cno;
    }
}
