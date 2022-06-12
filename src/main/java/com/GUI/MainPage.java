/*
 * Created by JFormDesigner on Tue May 10 21:10:32 CST 2022
 */

package com.GUI;

import com.dao.DisplayDao;
import com.dao.OrganizationDao;
import com.dao.PersonDao;
import com.entity.Apply;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 * @author LG-tianyuan
 */
public class MainPage extends JFrame {
    public MainPage(Connection connect,String rk,String uname) throws SQLException {
        con = connect;
        rank = Integer.parseInt(rk);
        username = uname;
        route = new Stack<String>();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        titile1 = new JLabel();
        ClubList = new JScrollPane();
        organizationlist = new JList();
        loginout = new JButton();
        personalinfo = new JButton();
        title2 = new JLabel();
        college = new JButton();
        teacher = new JButton();
        create = new JButton();
        apply = new JButton();
        personalapply = new JButton();
        title3 = new JLabel();
        personalclub = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- titile1 ----
        titile1.setText("\u4e3b\u9875");
        titile1.setFont(titile1.getFont().deriveFont(titile1.getFont().getSize() + 6f));

        //======== ClubList ========
        {

            //---- organizationlist ----
            organizationlist.setFont(organizationlist.getFont().deriveFont(organizationlist.getFont().getSize() + 2f));
            ClubList.setViewportView(organizationlist);
        }

        //---- loginout ----
        loginout.setText("\u9000\u51fa\u767b\u5f55");
        loginout.setFont(loginout.getFont().deriveFont(loginout.getFont().getSize() + 1f));

        //---- personalinfo ----
        personalinfo.setText("\u6211\u7684\u4fe1\u606f");
        personalinfo.setFont(personalinfo.getFont().deriveFont(personalinfo.getFont().getSize() + 1f));

        //---- title2 ----
        title2.setText("\u793e\u56e2\u5217\u8868\u4fe1\u606f");
        title2.setFont(title2.getFont().deriveFont(title2.getFont().getSize() + 3f));

        //---- college ----
        college.setText("\u9662\u7cfb\u4fe1\u606f");
        college.setFont(college.getFont().deriveFont(college.getFont().getSize() + 1f));
        college.setEnabled(false);

        //---- teacher ----
        teacher.setText("\u6559\u5e08\u4fe1\u606f");
        teacher.setFont(teacher.getFont().deriveFont(teacher.getFont().getSize() + 1f));
        teacher.setEnabled(false);

        //---- create ----
        create.setText("\u521b\u5efa\u65b0\u793e\u56e2");
        create.setFont(create.getFont().deriveFont(create.getFont().getSize() + 1f));

        //---- apply ----
        apply.setText("\u5ba1\u6279\u7533\u8bf7");
        apply.setFont(apply.getFont().deriveFont(apply.getFont().getSize() + 1f));
        apply.setEnabled(false);

        //---- personalapply ----
        personalapply.setText("\u6211\u7684\u7533\u8bf7");
        personalapply.setFont(personalapply.getFont().deriveFont(personalapply.getFont().getSize() + 1f));

        //---- title3 ----
        title3.setText("\u6b22\u8fcexxx");

        //---- personalclub ----
        personalclub.setText("\u6211\u7684\u793e\u56e2");
        personalclub.setFont(personalclub.getFont().deriveFont(personalclub.getFont().getSize() + 1f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(college)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(teacher)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(apply)
                            .addGap(30, 30, 30)
                            .addComponent(create)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                            .addComponent(loginout))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(titile1)
                                    .addGap(137, 137, 137)
                                    .addComponent(title3))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(ClubList, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(personalclub)
                                                .addComponent(personalapply)
                                                .addComponent(personalinfo)))
                                        .addComponent(title2))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(23, 23, 23))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(titile1)
                        .addComponent(title3))
                    .addGap(21, 21, 21)
                    .addComponent(title2)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ClubList, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addGap(18, 18, 18))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(personalinfo)
                            .addGap(48, 48, 48)
                            .addComponent(personalapply)
                            .addGap(49, 49, 49)
                            .addComponent(personalclub)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginout)
                        .addComponent(college)
                        .addComponent(teacher)
                        .addComponent(apply)
                        .addComponent(create))
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        PersonDao personDao = new PersonDao();
        usrpno = personDao.Personid(con,username);
        String welcome="Welcome "+username;
        title3.setText(welcome);
        if(rank>1){
            apply.setEnabled(true);
        }
        if(rank == 4){
            college.setEnabled(true);
            teacher.setEnabled(true);
            create.setEnabled(false);
        }
        DisplayDao displayDao = new DisplayDao();
        List<String> list = displayDao.ClubList(con);
        organizationlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ClubList.setViewportView(organizationlist);
        organizationlist.setListData(list.toArray());
    }

    private void ActionListenerDemo() throws SQLException {
        organizationlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String club = organizationlist.getSelectedValue().toString();
                OrganizationDao organizationDao = new OrganizationDao();
                String clubid="";
                try {
                    clubid = organizationDao.Organization_id(con,club);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                //跳转到相应社团信息页
                route.push("MainPage");
                try {
                    ClubInfo clubInfo = new ClubInfo(con,rank,username,usrpno,clubid,route);
                    clubInfo.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        personalinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到个人信息界面
                route.push("MainPage");
                try {
                    PersonalInfo personalInfo = new PersonalInfo(con,rank,username,usrpno);
                    personalInfo.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        personalapply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到申请列表页面
                route.push("MainPage");
                try {
                    ApplyList applyList = new ApplyList(con,rank,username,usrpno,"查看",route);
                    applyList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        personalclub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到个人加入的社团界面
                route.push("MainPage");
                try {
                    ClubList clubList = new ClubList(con,rank,username,usrpno,route);
                    clubList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        college.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到院系列表界面
                route.push("MainPage");
                try {
                    CollegeList collegeList = new CollegeList(con,rank,username,usrpno,route);
                    collegeList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        teacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到教师列表界面
                route.push("MainPage");
                try {
                    TeacherList teacherList = new TeacherList(con,rank,username,usrpno,route);
                    teacherList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String date = formatter.format(currentTime);
                com.entity.Apply apply = new Apply("","创建","",usrpno,date,"0");
                //跳转到创建社团申请界面，传递个人学号信息
                route.push("MainPage");
                try {
                    com.GUI.Apply apply1 = new com.GUI.Apply(con,rank,username,usrpno,"创建",apply,route);
                    apply1.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        loginout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //退出登录
                int input = JOptionPane.showConfirmDialog(loginout,"Are you sure to loginout?","submit notice",1,2);
                if(input == 0){
                    com.GUI.Login login = new Login();
                    login.setVisible(true);
                    dispose();
                }
            }
        });
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                route.push("MainPage");
                try {
                    ApplyList applyList = new ApplyList(con,rank,username,usrpno,"审批",route);
                    applyList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel titile1;
    private JScrollPane ClubList;
    private JList organizationlist;
    private JButton loginout;
    private JButton personalinfo;
    private JLabel title2;
    private JButton college;
    private JButton teacher;
    private JButton create;
    private JButton apply;
    private JButton personalapply;
    private JLabel title3;
    private JButton personalclub;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private int rank;
    private String username;
    private String usrpno;
    private Connection con;
    private Stack<String> route;
}
