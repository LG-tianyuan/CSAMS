/*
 * Created by JFormDesigner on Tue May 10 19:51:58 CST 2022
 */

package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

import com.dao.UsrDao;
import com.entity.Usr;
import com.util.DButil;

/**
 * @author LG.tianyuan
 */
public class Login extends JFrame{
    public Login() {
        DButil dButil = new DButil();
        con = dButil.getConnection();
        initComponents();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        title = new JLabel();
        username = new JLabel();
        Uname = new JTextField();
        password = new JLabel();
        Loginbutton = new JButton();
        Registerbutton = new JButton();
        Upwd = new JPasswordField();
        quit = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- title ----
        title.setText("\u6b22\u8fce\u767b\u9646\u9ad8\u6821\u793e\u56e2\u7ba1\u7406\u7cfb\u7edf");
        title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

        //---- username ----
        username.setText("\u7528\u6237\u540d");
        username.setFont(username.getFont().deriveFont(username.getFont().getSize() + 3f));

        //---- password ----
        password.setText("\u5bc6  \u7801");
        password.setFont(password.getFont().deriveFont(password.getFont().getSize() + 3f));

        //---- Loginbutton ----
        Loginbutton.setText("\u767b\u5f55");
        Loginbutton.setFont(Loginbutton.getFont().deriveFont(Loginbutton.getFont().getSize() + 2f));

        //---- Registerbutton ----
        Registerbutton.setText("\u6ce8\u518c");
        Registerbutton.setFont(Registerbutton.getFont().deriveFont(Registerbutton.getFont().getSize() + 2f));

        //---- quit ----
        quit.setText("\u9000\u51fa");
        quit.setFont(quit.getFont().deriveFont(quit.getFont().getSize() + 2f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(username, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addComponent(password))
                            .addGap(51, 51, 51)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(Upwd, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Uname, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(176, 176, 176)
                            .addComponent(title))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(Loginbutton)
                            .addGap(67, 67, 67)
                            .addComponent(Registerbutton)
                            .addGap(66, 66, 66)
                            .addComponent(quit)))
                    .addContainerGap(106, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title)
                    .addGap(61, 61, 61)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(username, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Uname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Upwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(password))
                    .addGap(50, 50, 50)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(quit)
                        .addComponent(Registerbutton)
                        .addComponent(Loginbutton))
                    .addGap(90, 90, 90))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void ActionListenerDemo(){
        Loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = Uname.getText();
                String upwd = new String(Upwd.getPassword());
                if(uname.isEmpty()||uname.length()>20){
                    JOptionPane.showMessageDialog(Loginbutton,"Username invalid! No empty and no longer than 20!","error",0);
                }else if(!upwd.matches("[0-9a-zA-Z]{6,10}")){
                    JOptionPane.showMessageDialog(Loginbutton,"Password invalid! Can only contain number,letter,_ with length 6~10!","error",0);
                }else{
                    String urank = "1";
                    Usr usr = new Usr(uname,upwd,urank);
                    UsrDao dao = new UsrDao();
                    try {
                        urank = dao.login_check(con,usr);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if(urank.equals("The user does not exist!")||urank.equals("Incorrect password!")){
                        JOptionPane.showMessageDialog(Loginbutton,urank,"error",0);
                    }else{
                        rank = urank;
                        //跳转到主页
                        try {
                            MainPage mainPage = new MainPage(con,rank,uname);
                            mainPage.setVisible(true);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        dispose();
                    }
                }

            }
        });
        Registerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到注册页面
                try {
                    Register register = new Register(con);
                    register.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel title;
    private JLabel username;
    private JTextField Uname;
    private JLabel password;
    private JButton Loginbutton;
    private JButton Registerbutton;
    private JPasswordField Upwd;
    private JButton quit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private String rank;

}
