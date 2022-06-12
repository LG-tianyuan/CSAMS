package com.dao;

import com.entity.Apply;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplyDao {
    public void Apply_insert(Connection con, Apply apply) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="insert into Apply values('"+apply.getAno()+"','"+apply.getAtype()+"','"+apply.getAcont()+"','"+apply.getApno()+"','"+apply.getAdate()+"','0');";
        sta.executeUpdate(sql);
    }
    public void Apply_update(Connection con,String ano) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="update Apply set Apass='1' where Ano='"+ano+"';";
        sta.executeUpdate(sql);
    }
    public void Apply_delete(Connection con,String ano) throws  SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="delete from Apply where Ano='"+ano+"';";
        sta.executeUpdate(sql);
    }
    public Apply Apply_Info(Connection con,String ano) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="select * from Apply where Ano='"+ano+"';";;
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        Apply apply = new Apply(ano,rs.getString("Atype"),rs.getString("Acont"),
                rs.getString("Apno"),rs.getString("Adate"),rs.getString("Apass"));
        rs.close();
        return apply;
    }
    public String Apply_count(Connection con) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql = "select count(*) from Apply;";
        ResultSet rs = sta.executeQuery(sql);
        rs.next();
        String cnt = rs.getString(1);
        return cnt;
    }
}
