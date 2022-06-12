/*
 * Created by JFormDesigner on Wed May 11 12:50:52 CST 2022
 */

package com.GUI;

import com.dao.CollegeDao;
import com.entity.College;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Stack;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LG-tianyuan
 */
public class CollegeInfo extends JFrame {
    //要么增加、要么查看、要么删除、要么更新
    public CollegeInfo(Connection connect,int rk,String uname,String pno,String cno,Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        username = uname;
        usrpno = pno;
        collegeid = cno;
        route = rt;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        titile = new JLabel();
        cno = new JLabel();
        Cno = new JTextField();
        cname = new JLabel();
        Cname = new JTextField();
        submit = new JButton();
        update = new JButton();
        delete = new JButton();
        back = new JButton();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        var contentPane = getContentPane();

        //---- titile ----
        titile.setText("\u5b66\u9662\u4fe1\u606f");
        titile.setFont(titile.getFont().deriveFont(titile.getFont().getSize() + 6f));

        //---- cno ----
        cno.setText("\u5b66\u9662\u7f16\u53f7");
        cno.setFont(cno.getFont().deriveFont(cno.getFont().getSize() + 3f));

        //---- cname ----
        cname.setText("\u5b66\u9662\u540d\u79f0");
        cname.setFont(cname.getFont().deriveFont(cname.getFont().getSize() + 3f));

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.setFont(submit.getFont().deriveFont(submit.getFont().getSize() + 1f));
        submit.setEnabled(false);

        //---- update ----
        update.setText("\u66f4\u65b0");
        update.setFont(update.getFont().deriveFont(update.getFont().getSize() + 1f));

        //---- delete ----
        delete.setText("\u5220\u9664");
        delete.setFont(delete.getFont().deriveFont(delete.getFont().getSize() + 1f));

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 1f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(titile)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(cname)
                                        .addComponent(cno))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(Cname, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Cno, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(submit)
                            .addGap(32, 32, 32)
                            .addComponent(update)
                            .addGap(39, 39, 39)
                            .addComponent(delete)
                            .addGap(35, 35, 35)
                            .addComponent(back)))
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(titile)
                    .addGap(49, 49, 49)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cno)
                        .addComponent(Cno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Cname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cname))
                    .addGap(65, 65, 65)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(submit)
                        .addComponent(update)
                        .addComponent(delete)
                        .addComponent(back))
                    .addContainerGap(63, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private  void initView() throws SQLException {
        Cno.setEnabled(false);
        Cname.setEnabled(false);
        submit.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        if(collegeid.equals("")){//增加学院信息
            mode = "add";
            submit.setEnabled(true);
            update.setEnabled(false);
            delete.setEnabled(false);
            Cno.setEnabled(true);
            Cname.setEnabled(true);
        }else {//查看学院信息
            mode = "view";
            CollegeDao collegeDao = new CollegeDao();
            collegename = collegeDao.College_info(con,collegeid);
            Cno.setText(collegeid);
            Cname.setText(collegename);
            update.setEnabled(true);
            delete.setEnabled(true);
        }
    }

    private void ActionListenerDemo() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collegeid = Cno.getText();
                collegename = Cname.getText();
                if(!collegeid.matches("[0-9]{1,6}")){
                    JOptionPane.showMessageDialog(submit,"College ID invalid! Can only contain number with length 1~6!","error",0);
                }else if(collegename.isEmpty()||collegename.length()>20){
                    JOptionPane.showMessageDialog(submit,"College name invalid! No empty and no longer than 20!","error",0);
                }else {
                    College college = new College(collegeid,collegename);
                    CollegeDao collegeDao = new CollegeDao();
                    String rs="success";
                    try {
                        rs = collegeDao.College_check(con,college);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if(rs.equals("success")) {
                        int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                        if(input == 0){
                            if(mode.equals("add"))
                            {
                                try {
                                    collegeDao.College_insert(con,college);
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }else{
                                try {
                                    collegeDao.College_update(con,college);
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }
                        }
                        //更新视图
                        try {
                            initView();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
//                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(submit,rs,"error",0);
                    }
                }
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit.setEnabled(true);
                update.setEnabled(false);
                delete.setEnabled(false);
                Cname.setEnabled(true);
            }
        });
        delete.addActionListener(new ActionListener() { //还需检查是否存在被引用，要么定义级联删除
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(delete,"Are you sure to submit?","submit notice",1,2);
                if(input == 0){
                    CollegeDao collegeDao = new CollegeDao();
                    try {
                        collegeDao.College_delete(con,collegeid);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                //删除后返回上一个页面
                route.pop();
                try {
                    CollegeList collegeList = new CollegeList(con,rank,username,usrpno,route);
                    collegeList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //返回上一个页面
                route.pop();
                try {
                    CollegeList collegeList = new CollegeList(con,rank,username,usrpno,route);
                    collegeList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel titile;
    private JLabel cno;
    private JTextField Cno;
    private JLabel cname;
    private JTextField Cname;
    private JButton submit;
    private JButton update;
    private JButton delete;
    private JButton back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String username;
    private String usrpno;
    private String collegeid;
    private String collegename;
    private Stack<String> route;
    private String mode;
}
