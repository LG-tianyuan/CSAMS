package com.dao;

import com.entity.Usr;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsrDao {
    public boolean check_usr(Connection con,String uname) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="select * from Usr;";
        ResultSet rs=sta.executeQuery(sql);
        boolean flag=false;
        while(rs.next()){
            if(rs.getString("Uname").equals(uname)) {
                flag=true;
                break;
            }
        }
        rs.close();
        return flag;
    }

    public void usr_insert(Connection con,Usr usr) throws SQLException{
        Statement sta;
        sta=con.createStatement();
        String sql="insert into Usr values('"+usr.getUname()+"','"+usr.getUpwd()+"','"+usr.getUrank()+"');";
        sta.executeUpdate(sql);
    }

    public String login_check(Connection con, Usr usr) throws SQLException {
        String message="Success!";
        boolean flag1 = false, flag2 = false;
        Statement sta;
        sta=con.createStatement();
        String sql="select * from Usr;";
        ResultSet rs=sta.executeQuery(sql);
        while(rs.next()){
            if(rs.getString("Uname").equals(usr.getUname())) {
                flag1=true;
                if(rs.getString("Upwd").equals(usr.getUpwd())) {
                    flag2=true;
                    message=rs.getString("Urank");
                }
                break;
            }
        }
        if(!flag1) {
            message="The user does not exist!";
        }else if(!flag2) {
            message="Incorrect password!";
        }
        return message;
    }
    public void ResetPassword(Connection con,Usr usr) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="update Usr set Upwd='"+usr.getUpwd()+"' where Uname='"+usr.getUname()+"';";
        sta.executeUpdate(sql);
    }
    public String delete_user(Connection con,String uname) throws SQLException {
        String str="Success";
        Statement sta,state;
        sta=con.createStatement();
        String sql="select Pno from Person where Puname='"+uname+"';";
        ResultSet rs=sta.executeQuery(sql);
        String pno=rs.getString("Pno");
        sql = "select * from Member where Mpno='"+pno+"';";
        rs=sta.executeQuery(sql);
        if(rs.getRow()==0){
            return "请先退出所有社团再注销账户！";
        }
        sql="select * from Usr;";
        rs=sta.executeQuery(sql);
        while(rs.next()){
            if(rs.getString("Uname").equals(uname)) {
                state=con.createStatement();
                sql="delete from Person where Puname='"+uname+"';";
                state.executeUpdate(sql);
                sql="delete from Usr where Uname='"+uname+"';";
                state.executeUpdate(sql);
            }
        }
        rs.close();
        return str;
    }
    public void user_update(Connection con,String uname,String rank) throws SQLException {
        Statement sta;
        sta=con.createStatement();
        String sql="update Usr set Urank='"+rank+"' where Uname='"+uname+"';";
        sta.executeUpdate(sql);
    }
}
