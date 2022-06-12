package com.dao;

import com.entity.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    public void Member_insert(Connection con, Member member) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="insert into Member values('"+member.getMono()+"','"+member.getMpno()+"','"+member.getMjob()+"','"+member.getMjoin()+"');";
        sta.executeUpdate(sql);
    }
    public void Member_update(Connection con,Member member) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="update Member set Mjob='"+member.getMjob()+"' where Mono='"+member.getMono()+"' and Mpno='"+member.getMpno()+"';";
        sta.executeUpdate(sql);
    }
    public void Member_delete(Connection con,Member member) throws  SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="delete from Member where Mono='"+member.getMono()+"' and Mpno='"+member.getMpno()+"';";
        sta.executeUpdate(sql);
    }
    public void Member_delete_by_club(Connection con,String mono) throws  SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="delete from Member where Mono='"+mono+"';";
        sta.executeUpdate(sql);
    }
    public List<String> Manage_Clubs(Connection con,String pno) throws SQLException {
        List<String> list = new ArrayList<>();
        Statement sta;
        sta=con.createStatement();
        String sql="select Mono from Member where Mpno='"+pno+"' and Mjob in ('社长','副社长');";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String ono = rs.getString("Mono");
            list.add(ono);
        }
        rs.close();
        return list;
    }
    public int Club_person_rank(Connection con,String mono,String mpno) throws SQLException {
        int i = 0;
        Statement sta;
        sta=con.createStatement();
        String sql="select Mjob from Member where Mono='"+mono+"' and Mpno='"+mpno+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        if(rs.getRow()==0){
            rs.close();
            return i;
        }
        String job = rs.getString("Mjob");
        if(job.equals("社长")){
            i = 3;
        }else if(job.equals("副社长")){
            i = 2;
        }else {
            i = 1;
        }
        rs.close();
        return i;
    }
    public int Personal_highest_rank(Connection con,String mpno) throws SQLException {
        int i = 1;
        Statement sta;
        sta=con.createStatement();
        String sql="select Mjob from Member where Mpno='"+mpno+"';";
        ResultSet rs = sta.executeQuery(sql);
        if(rs.getRow()==0){
            rs.close();
            return i;
        }
        String job = rs.getString("Mjob");
        if(job.equals("社长")){
            i = 3;
        }else if(job.equals("副社长")){
            i = 2;
        }else {
            i = 1;
        }
        rs.close();
        return i;
    }
    public boolean Member_check(Connection con,String ono,String pno) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="select * from Member where Mono='"+ono+"' and Mpno='"+pno+"';";
        ResultSet rs=sta.executeQuery(sql);
        rs.next();
        if(rs.getRow()!=0){
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }
}
