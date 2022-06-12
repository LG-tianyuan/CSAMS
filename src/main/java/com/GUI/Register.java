/*
 * Created by JFormDesigner on Tue May 10 20:10:33 CST 2022
 */

package com.GUI;

import javax.swing.*;

import com.dao.DisplayDao;
import com.dao.PersonDao;
import com.dao.UsrDao;
import com.entity.Person;
import com.entity.Usr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LG-tianyuan
 */
public class Register extends JFrame {
    public Register(Connection connection) throws SQLException {
        con = connection;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView(con);
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        title = new JLabel();
        username = new JLabel();
        pno = new JLabel();
        Pno = new JTextField();
        pno2 = new JLabel();
        Pname = new JTextField();
        pgrade = new JLabel();
        pcname = new JLabel();
        Pgrade = new JComboBox();
        Pcname = new JComboBox();
        Psex = new JComboBox();
        psex = new JLabel();
        page = new JLabel();
        ptel = new JLabel();
        pwechat = new JLabel();
        Ptel = new JTextField();
        Pwechat = new JTextField();
        pqno = new JLabel();
        Pqno = new JTextField();
        register = new JButton();
        back = new JButton();
        Puname = new JTextField();
        ppwd = new JLabel();
        Ppwd = new JPasswordField();
        Page = new JComboBox();
        check_pwd = new JLabel();
        check_Ppwd = new JPasswordField();

        //======== this ========
        var contentPane = getContentPane();

        //---- title ----
        title.setText("\u6ce8\u518c");
        title.setFont(title.getFont().deriveFont(title.getFont().getSize() + 6f));

        //---- username ----
        username.setText("\u7528\u6237\u540d");
        username.setFont(username.getFont().deriveFont(username.getFont().getSize() + 2f));

        //---- pno ----
        pno.setText("\u5b66\u53f7");
        pno.setFont(pno.getFont().deriveFont(pno.getFont().getSize() + 3f));

        //---- pno2 ----
        pno2.setText("\u59d3\u540d");
        pno2.setFont(pno2.getFont().deriveFont(pno2.getFont().getSize() + 3f));

        //---- pgrade ----
        pgrade.setText("\u5e74\u7ea7");
        pgrade.setFont(pgrade.getFont().deriveFont(pgrade.getFont().getSize() + 3f));

        //---- pcname ----
        pcname.setText("\u9662\u7cfb");
        pcname.setFont(pcname.getFont().deriveFont(pcname.getFont().getSize() + 3f));

        //---- psex ----
        psex.setText("\u6027\u522b");
        psex.setFont(psex.getFont().deriveFont(psex.getFont().getSize() + 3f));

        //---- page ----
        page.setText("\u5e74\u9f84");
        page.setFont(page.getFont().deriveFont(page.getFont().getSize() + 3f));

        //---- ptel ----
        ptel.setText("\u624b\u673a");
        ptel.setFont(ptel.getFont().deriveFont(ptel.getFont().getSize() + 3f));

        //---- pwechat ----
        pwechat.setText("\u5fae\u4fe1");
        pwechat.setFont(pwechat.getFont().deriveFont(pwechat.getFont().getSize() + 3f));

        //---- pqno ----
        pqno.setText("QQ");
        pqno.setFont(pqno.getFont().deriveFont(pqno.getFont().getSize() + 3f));

        //---- register ----
        register.setText("\u63d0\u4ea4");
        register.setFont(register.getFont().deriveFont(register.getFont().getSize() + 2f));

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 2f));

        //---- ppwd ----
        ppwd.setText("\u5bc6\u7801");
        ppwd.setFont(ppwd.getFont().deriveFont(ppwd.getFont().getSize() + 3f));

        //---- check_pwd ----
        check_pwd.setText("\u786e\u8ba4\u5bc6\u7801");
        check_pwd.setFont(check_pwd.getFont().deriveFont(check_pwd.getFont().getSize() + 3f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(264, 264, 264)
                            .addComponent(title))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(pqno)
                                        .addComponent(pgrade, GroupLayout.Alignment.LEADING))
                                    .addGap(21, 21, 21))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(username, GroupLayout.Alignment.TRAILING)
                                        .addComponent(psex, GroupLayout.Alignment.TRAILING)
                                        .addComponent(pno2, GroupLayout.Alignment.TRAILING)
                                        .addComponent(ppwd, GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)))
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Pqno, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pwechat)
                                    .addGap(18, 18, 18)
                                    .addComponent(Pwechat, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(Puname, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Pgrade, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Pname, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                    .addGap(46, 46, 46)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(page)
                                            .addGap(18, 18, 18)
                                            .addComponent(Page))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(pcname)
                                                .addComponent(pno))
                                            .addGap(18, 18, 18)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(Pcname, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Pno, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(check_Ppwd, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(Psex, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ptel)
                                    .addGap(18, 18, 18)
                                    .addComponent(Ptel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Ppwd, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(check_pwd)))))
                    .addContainerGap(37, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(register)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                    .addComponent(back)
                    .addGap(123, 123, 123))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title)
                    .addGap(9, 9, 9)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Puname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(username)
                        .addComponent(pno)
                        .addComponent(Pno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ppwd)
                        .addComponent(Ppwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(check_Ppwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(check_pwd))
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pcname)
                        .addComponent(Pcname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pno2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(page)
                        .addComponent(Page, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pgrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pgrade))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Ptel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ptel)
                        .addComponent(Psex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(psex))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pqno)
                        .addComponent(Pqno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pwechat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwechat))
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(register)
                        .addComponent(back))
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView(Connection con) throws SQLException {
        Pgrade.addItem("");
        for(int i = 2015; i < 2022; i++){
            Pgrade.addItem(Integer.toString(i));
        }
        DisplayDao displayDao = new DisplayDao();
        List<String> list = displayDao.CollegeList(con);
        Pcname.addItem("");
        for(int i = 0; i < list.size(); i++){
            String college = list.get(i);
            Pcname.addItem(college);
        }
        Psex.addItem("");
        Psex.addItem("男");
        Psex.addItem("女");
        Page.addItem("");
        for(int i = 1; i < 120; i++){
            Page.addItem(Integer.toString(i));
        }
    }

    private void ActionListenerDemo() {
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = Puname.getText();
                String password = new String(Ppwd.getPassword());
                String check_pwd = new String(check_Ppwd.getPassword());
                String no = Pno.getText();
                String name = Pname.getText();
                String grade = Pgrade.getSelectedItem().toString();
                String cname = Pcname.getSelectedItem().toString();
                String sex = Psex.getSelectedItem().toString();
                String age = Page.getSelectedItem().toString();
                String tel = Ptel.getText();
                String wechat = Pwechat.getText();
                String qq = Pqno.getText();
                if(!uname.matches("[0-9a-zA-Z_-]{5,20}")){
                    JOptionPane.showMessageDialog(register,"Username invalid! Can only contain number,letter,_,- with length 5~20!","error",0);
                }else if(!no.matches("[0-9]{6,16}")){
                    JOptionPane.showMessageDialog(register,"Student ID invalid! Can only contain number with length 6~16!","error",0);
                }else if(!password.matches("[0-9a-zA-Z]{6,10}")){
                    JOptionPane.showMessageDialog(register,"Password invalid! Can only contain number,letter,_ with length 6~10!","error",0);
                }else if(!password.equals(check_pwd)){
                    JOptionPane.showMessageDialog(register,"Password and Confirm Password do not match!","error",0);
                }else if(name.isEmpty()||name.length()>20){
                    JOptionPane.showMessageDialog(register,"Name invalid! With Length 1~20!","error",0);
                }else if(!tel.matches("[1][3-9][0-9]{9}")){
                    JOptionPane.showMessageDialog(register,"Tel invalide! Your phone number should be valid with 11 numbers!","error",0);
                }else if(!wechat.isEmpty()&&(wechat.length()<6||wechat.length()>20)){
                    JOptionPane.showMessageDialog(register,"Wechat invalid! With length 6~20!","error",0);
                }else if(!qq.isEmpty()&&(qq.length()<5||qq.length()>11)){
                    JOptionPane.showMessageDialog(register,"QQ invalid! With length 6~20!","error",0);
                }else{
                    //检验是否已被注册
                    UsrDao usrdao = new UsrDao();
                    PersonDao personDao = new PersonDao();
                    boolean flag1=false,flag2=false;
                    try {
                        flag1 = usrdao.check_usr(con,uname);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        flag2 = personDao.Person_check(con,no);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if(flag1 || flag2){
                        if(flag1)
                            JOptionPane.showMessageDialog(register,"The username has been registered!","error",0);
                        if(flag2)
                            JOptionPane.showMessageDialog(register,"The student id has been registered!","error",0);
                    }else{
                        Usr usr = new Usr(uname,password,"1");
                        //获取当前日期
                        Date currentTime = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String date = formatter.format(currentTime);
                        Person person = new Person(no,name,uname,grade,cname,sex,age,date,tel,wechat,qq);
                        int input = JOptionPane.showConfirmDialog(register,"Are you sure to submit?","submit notice",1,2);
                        if(input == 0){
                            try {
                                usrdao.usr_insert(con,usr);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            try {
                                personDao.Person_insert(con,person);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            //跳转到主页
                            try {
                                MainPage mainPage = new MainPage(con,"1",uname);
                                mainPage.setVisible(true);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            dispose();
                        }
                    }
                    ;
                }

            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转回登录界面
                com.GUI.Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel title;
    private JLabel username;
    private JLabel pno;
    private JTextField Pno;
    private JLabel pno2;
    private JTextField Pname;
    private JLabel pgrade;
    private JLabel pcname;
    private JComboBox Pgrade;
    private JComboBox Pcname;
    private JComboBox Psex;
    private JLabel psex;
    private JLabel page;
    private JLabel ptel;
    private JLabel pwechat;
    private JTextField Ptel;
    private JTextField Pwechat;
    private JLabel pqno;
    private JTextField Pqno;
    private JButton register;
    private JButton back;
    private JTextField Puname;
    private JLabel ppwd;
    private JPasswordField Ppwd;
    private JComboBox Page;
    private JLabel check_pwd;
    private JPasswordField check_Ppwd;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private String rank;
    private Connection con;
}
