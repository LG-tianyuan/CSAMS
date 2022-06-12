package com.dao;

import com.entity.Organization;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrganizationDao {
    public boolean Check(Connection con, String ono) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="select * from Organization where Ono='"+ono+"';";
        ResultSet rs=sta.executeQuery(sql);
        rs.next();
        if(rs.getRow()!=0){
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }
    //检测是否存在社团名称冲突
    public boolean Organization_check(Connection con, String oname) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="select Oname from Organization where Oname='"+oname+"';";
        ResultSet rs=sta.executeQuery(sql);
        rs.next();
        if(rs.getRow()==0){
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }
    public void Organization_insert(Connection con, Organization organization) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="insert into Organization values ('"+organization.getOno()+"','"+organization.getOname()+"','"+organization.getOpno()+"',";
        if(organization.getOtno().equals(""))
        {
            sql += "null,";
        }else{
            sql += "'"+organization.getOtno()+"',";
        }
        if(organization.getOcname().equals(""))
        {
            sql += "null,";
        }else {
            sql += "'"+organization.getOcname()+"',";
        }
        sql += "'"+organization.getOdate()+"','0',";
        if(organization.getOintro().equals(""))
        {
            sql += "null";
        }else{
            sql += "'"+organization.getOintro()+"'";
        }
        sql += ");";
        sta.executeUpdate(sql);
    }
    public void Organization_update(Connection con,Organization organization) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql;
        if(!organization.getOname().equals("") && Organization_check(con,organization.getOname())){
            sql = "update Organization set Oname='"+organization.getOname()+"' where Ono='"+organization.getOno()+"';";
            sta.executeUpdate(sql);
        }
        if(!organization.getOpno().equals("")){
            sql = "update Organization set Opno='"+organization.getOpno()+"' where Ono='"+organization.getOno()+"';";
            sta.executeUpdate(sql);
        }
        if(!organization.getOtno().equals("")){
            sql = "update Organization set Otno='"+organization.getOtno()+"' where Ono='"+organization.getOno()+"';";
            sta.executeUpdate(sql);
        }
        if(!organization.getOcname().equals("")){
            sql = "update Organization set Ocname='"+organization.getOcname()+"' where Ono='"+organization.getOno()+"';";
            sta.executeUpdate(sql);
        }
        if(!organization.getOcnt().equals("")){
            sql = "update Organization set Ocnt='"+organization.getOcnt()+"' where Ono='"+organization.getOno()+"';";
            sta.executeUpdate(sql);
        }
        if(!organization.getOintro().equals("")){
            sql = "update Organization set Ointro='"+organization.getOintro()+"' where Ono='"+organization.getOno()+"';";
            sta.executeUpdate(sql);
        }
    }
    public void Organization_delete(Connection con,String ono) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="delete from Organization where Ono='"+ono+"';";
        sta.executeUpdate(sql);
    }
    public String Organization_id(Connection con,String oname) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="select Ono from Organization where Oname='"+oname+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String ono = rs.getString("Ono");
        rs.close();
        return ono;
    }
    public String Organization_name(Connection con,String ono) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="select Oname from Organization where Ono='"+ono+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String oname = rs.getString("Oname");
        rs.close();
        return oname;
    }
    public Organization Organization_Info(Connection con,String ono) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="select * from Organization where Ono='"+ono+"';";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        Organization organization = new Organization(rs.getString("Ono"),rs.getString("Oname"),
                rs.getString("Opno"),rs.getString("Otno"),rs.getString("Ocname"),
                rs.getString("Odate"),rs.getString("Ocnt"),rs.getString("Ointro"));
        rs.close();
        return organization;
    }
    public String Organization_count(Connection con) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql = "select count(*) from Organization;";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String cnt = rs.getString(1);
        return cnt;
    }
}
