package com.dao;

import com.entity.MemberInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisplayDao {
    public List<String> CollegeList(Connection con) throws SQLException{
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select Cname from College";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String cname = rs.getString("Cname");
            list.add(cname);
        }
        rs.close();
        return list;
    }
    public List<String> ClubList(Connection con) throws SQLException {
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select Oname from Organization";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String oname = rs.getString("Oname");
            list.add(oname);
        }
        rs.close();
        return list;
    }
    public List<String> MyClubList(Connection con,String pno) throws SQLException {
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select distinct(Oname) from Organization,MemList where MemList.Mono=Organization.Ono and MemList.Pno='"+pno+"';";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String oname = rs.getString("Oname");
            list.add(oname);
        }
        rs.close();
        return list;
    }
    public List<String> TeacherList(Connection con) throws SQLException {
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select Tno,Tname from Teacher";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String info = rs.getString("Tno");
            info += ",";
            info += rs.getString("Tname");
            list.add(info);
        }
        rs.close();
        return list;
    }
    public List<String> TeacherSelectable(Connection con) throws SQLException {
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select Tname from Teacher";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String info = rs.getString("Tname");
            list.add(info);
        }
        rs.close();
        return list;
    }
    public List<String> MemberList(Connection con,String ono) throws SQLException {
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select Pno,Pname from MemList where Mono='"+ono+"'";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String info = rs.getString("Pno");
            info += ",";
            info += rs.getString("Pname");
            list.add(info);
        }
        rs.close();
        return list;
    }
    public MemberInfo MemberInfo(Connection con,String mono,String pno) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql = "select * from MemInfo where Mono='"+mono+"' and Pno='"+pno+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        MemberInfo memberInfo = new MemberInfo(rs.getString("Mono"),rs.getString("Pno"),
                rs.getString("Pname"),rs.getString("Pgrade"),rs.getString("Mjob"),
                rs.getString("Mjoin"),rs.getString("Pcname"),rs.getString("Psex"),
                rs.getString("Ptel"),rs.getString("Pwechat"),rs.getString("Pqno"));
        rs.close();
        return memberInfo;
    }
    public List<String> ApplyList_Manager_View(Connection con) throws SQLException{
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select * from Apply where Apass=0 AND Atype IN ('创建','转让','解散');";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String apply = rs.getString("Ano");
            apply += ",";
            apply += rs.getString("Apno");
            apply += ",";
            apply += rs.getString("Atype");
            list.add(apply);
        }
        rs.close();
        return list;
    }
    public List<String> ApplyList_Monitor_View(Connection con,String ono) throws SQLException{
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select * from Apply where Acont='"+ono+"' AND Apass=0 AND Atype IN ('加入','退出');";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String apply = rs.getString("Ano");
            apply += ",";
            apply += rs.getString("Apno");
            apply += ",";
            apply += rs.getString("Atype");
            list.add(apply);
        }
        rs.close();
        return list;
    }
    public List<String> ApplyList_Personal_View(Connection con,String pno) throws SQLException{
        List<String> list = new ArrayList<String>();
        Statement sta;
        sta=con.createStatement();
        String sql = "select * from Apply where Apno='"+pno+"';";
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            String apply = rs.getString("Ano");
            apply += ",";
            apply += rs.getString("Apno");
            apply += ",";
            apply += rs.getString("Atype");
            list.add(apply);
        }
        rs.close();
        return list;
    }
}
