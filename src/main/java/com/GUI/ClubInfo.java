/*
 * Created by JFormDesigner on Tue May 10 21:22:26 CST 2022
 */

package com.GUI;

import com.dao.*;
import com.entity.Apply;
import com.entity.Organization;

import javax.swing.*;
import javax.swing.GroupLayout;
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
public class ClubInfo extends JFrame {
    public ClubInfo(Connection connect, int rk, String uname, String uid,String ono,Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        origin_rank = rk;
        usrname = uname;
        usrpno = uid;
        clubid = ono;
        route = rt;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Oname = new JLabel();
        back = new JButton();
        applyin = new JButton();
        ono = new JLabel();
        Ono = new JTextField();
        odate = new JLabel();
        Odate = new JTextField();
        opname = new JLabel();
        Opname = new JTextField();
        otname = new JLabel();
        ocnt = new JLabel();
        Ocnt = new JTextField();
        teacherinfo = new JButton();
        ointro = new JLabel();
        scrollPane1 = new JScrollPane();
        Ointro = new JTextArea();
        quit = new JButton();
        edit = new JButton();
        destroy = new JButton();
        trans = new JButton();
        menberinfo = new JButton();
        mcno = new JLabel();
        Mcno = new JComboBox();
        Mtname = new JComboBox();
        submit = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- Oname ----
        Oname.setText("xxx\u793e\u56e2");
        Oname.setFont(Oname.getFont().deriveFont(Oname.getFont().getSize() + 6f));

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 1f));

        //---- applyin ----
        applyin.setText("\u52a0\u5165");
        applyin.setFont(applyin.getFont().deriveFont(applyin.getFont().getSize() + 1f));
        applyin.setEnabled(false);

        //---- ono ----
        ono.setText("\u793e\u56e2\u7f16\u53f7");
        ono.setFont(ono.getFont().deriveFont(ono.getFont().getSize() + 3f));

        //---- Ono ----
        Ono.setEnabled(false);
        Ono.setEditable(false);

        //---- odate ----
        odate.setText("\u521b\u5efa\u65f6\u95f4");
        odate.setFont(odate.getFont().deriveFont(odate.getFont().getSize() + 3f));

        //---- Odate ----
        Odate.setEnabled(false);
        Odate.setEditable(false);

        //---- opname ----
        opname.setText("\u793e\u56e2\u8d1f\u8d23\u4eba");
        opname.setFont(opname.getFont().deriveFont(opname.getFont().getSize() + 3f));

        //---- Opname ----
        Opname.setEnabled(false);
        Opname.setEditable(false);

        //---- otname ----
        otname.setText("\u6307\u5bfc\u8001\u5e08");
        otname.setFont(otname.getFont().deriveFont(otname.getFont().getSize() + 3f));

        //---- ocnt ----
        ocnt.setText("\u793e\u56e2\u6210\u5458\u6570");
        ocnt.setFont(ocnt.getFont().deriveFont(ocnt.getFont().getSize() + 3f));

        //---- Ocnt ----
        Ocnt.setEnabled(false);

        //---- teacherinfo ----
        teacherinfo.setText("\u8001\u5e08\u7b80\u4ecb");
        teacherinfo.setFont(teacherinfo.getFont().deriveFont(teacherinfo.getFont().getSize() + 1f));
        teacherinfo.setEnabled(false);

        //---- ointro ----
        ointro.setText("\u793e\u56e2\u7b80\u4ecb");
        ointro.setFont(ointro.getFont().deriveFont(ointro.getFont().getSize() + 3f));

        //======== scrollPane1 ========
        {

            //---- Ointro ----
            Ointro.setEnabled(false);
            scrollPane1.setViewportView(Ointro);
        }

        //---- quit ----
        quit.setText("\u9000\u51fa");
        quit.setFont(quit.getFont().deriveFont(quit.getFont().getSize() + 1f));
        quit.setEnabled(false);

        //---- edit ----
        edit.setText("\u7f16\u8f91");
        edit.setFont(edit.getFont().deriveFont(edit.getFont().getSize() + 1f));
        edit.setEnabled(false);

        //---- destroy ----
        destroy.setText("\u89e3\u6563");
        destroy.setFont(destroy.getFont().deriveFont(destroy.getFont().getSize() + 1f));
        destroy.setEnabled(false);

        //---- trans ----
        trans.setText("\u8f6c\u8ba9");
        trans.setFont(trans.getFont().deriveFont(trans.getFont().getSize() + 1f));
        trans.setEnabled(false);

        //---- menberinfo ----
        menberinfo.setText("\u6210\u5458\u4fe1\u606f");
        menberinfo.setFont(menberinfo.getFont().deriveFont(menberinfo.getFont().getSize() + 1f));
        menberinfo.setEnabled(false);

        //---- mcno ----
        mcno.setText("\u6240\u5c5e\u9662\u7cfb");
        mcno.setFont(mcno.getFont().deriveFont(mcno.getFont().getSize() + 3f));

        //---- Mcno ----
        Mcno.setEnabled(false);

        //---- Mtname ----
        Mtname.setEnabled(false);

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.setFont(submit.getFont().deriveFont(submit.getFont().getSize() + 1f));
        submit.setEnabled(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(ointro)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(teacherinfo)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(menberinfo)
                            .addGap(46, 46, 46))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(opname)
                                                .addComponent(ono))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(Ono, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Opname, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addComponent(ocnt)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Ocnt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(59, 59, 59)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(odate)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Odate, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(otname)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Mtname, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(mcno)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Mcno))))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(46, Short.MAX_VALUE))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(destroy, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(trans, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(edit, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(submit, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(applyin, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(quit, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(back, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(243, 243, 243)
                            .addComponent(Oname)))
                    .addContainerGap(32, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Oname)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(odate)
                        .addComponent(Odate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ono)
                        .addComponent(Ono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(opname)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Opname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(otname)
                            .addComponent(Mtname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Ocnt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ocnt)
                        .addComponent(mcno)
                        .addComponent(Mcno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ointro)
                        .addComponent(teacherinfo)
                        .addComponent(menberinfo))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(destroy)
                        .addComponent(trans)
                        .addComponent(edit)
                        .addComponent(submit)
                        .addComponent(applyin)
                        .addComponent(quit)
                        .addComponent(back))
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        //默认
        Ono.setEnabled(false);
        Odate.setEnabled(false);
        Opname.setEnabled(false);
        Ocnt.setEnabled(false);
        Ointro.setEnabled(false);
        Mcno.setEnabled(false);
        Mtname.setEnabled(false);
        teacherinfo.setEnabled(false);
        menberinfo.setEnabled(false);
        destroy.setEnabled(false);
        trans.setEnabled(false);
        edit.setEnabled(false);
        submit.setEnabled(false);
        applyin.setEnabled(false);
        quit.setEnabled(false);
        //
        OrganizationDao organizationDao = new OrganizationDao();
        organization = organizationDao.Organization_Info(con,clubid);
        PersonDao personDao = new PersonDao();
        String pname = personDao.Person_name(con,organization.getOpno());
        if(organization.getOtno()!=null){
            TeacherDao teacherDao = new TeacherDao();
            String tname = teacherDao.Teacher_name(con,organization.getOtno());
            Mtname.removeAllItems();
            Mtname.addItem(tname);
            Mtname.setSelectedIndex(0);
        }
        Oname.setText(organization.getOname());
        Ono.setText(clubid);
        Odate.setText(organization.getOdate());
        Opname.setText(pname);
        Ocnt.setText(organization.getOcnt());
        Mcno.removeAllItems();
        Mcno.addItem(organization.getOcname());
        Mcno.setSelectedIndex(0);
        Ointro.setText(organization.getOintro());
        //根据权限设置不同的选项
        if(rank < 4){
            MemberDao memberDao = new MemberDao();
            rank = memberDao.Club_person_rank(con,clubid,usrpno);
//            System.out.println(rank);
            //社长才可以申请解散、转让，社团干部可编辑和提交，社团成员(社长除外)可退出，社团外人员可申请加入(管理员均不可)
            if(rank>0){
                menberinfo.setEnabled(true);
                if(rank>1){
                    edit.setEnabled(true);
                }
                if(rank == 3){
                    destroy.setEnabled(true);
                    trans.setEnabled(true);
                }else {
                    quit.setEnabled(true);
                }
            }else {
                applyin.setEnabled(true);
            }
        }
        if(organization.getOtno()!=null){
            teacherinfo.setEnabled(true);
        }
    }

    private void ActionListenerDemo() {
        teacherinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得教师工号，跳转到教师信息页面，传递rank等信息
                route.push("ClubInfo");
                try {
                    TeacherInfo teacherInfo = new TeacherInfo(con,rank,usrname,usrpno,organization.getOtno(),clubid,route);
                    teacherInfo.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        menberinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得社团编号，跳转到社团成员列表，传递rank等信息
                route.push("ClubInfo");
                try {
                    MemberList memberList = new MemberList(con,rank,usrname,usrpno,clubid,route);
                    memberList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        destroy.addActionListener(new ActionListener() {//申请解散
            @Override
            public void actionPerformed(ActionEvent e) {
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String date = formatter.format(currentTime);
                Apply apply = new Apply("","解散",clubid,usrpno,date,"0");
                //跳转到申请页面
                route.push("ClubInfo");
                try {
                    com.GUI.Apply apply1 = new com.GUI.Apply(con,rank,usrname,usrpno,"解散",apply,route);
                    apply1.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        trans.addActionListener(new ActionListener() {//申请转让
            @Override
            public void actionPerformed(ActionEvent e) {
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String date = formatter.format(currentTime);
                Apply apply = new Apply("","转让",clubid,usrpno,date,"0");
                //跳转到申请页面
                route.push("ClubInfo");
                try {
                    com.GUI.Apply apply1 = new com.GUI.Apply(con,rank,usrname,usrpno,"转让",apply,route);
                    apply1.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //按钮
                submit.setEnabled(true);
                edit.setEnabled(false);
                teacherinfo.setEnabled(false);
                menberinfo.setEnabled(false);
                destroy.setEnabled(false);
                trans.setEnabled(false);
                applyin.setEnabled(false);
                quit.setEnabled(false);
                //可编辑内容
                Mtname.setEnabled(true);
                Mcno.setEnabled(true);
                Ointro.setEnabled(true);

                DisplayDao displayDao = new DisplayDao();
                List<String> list = null;
                //教师可选项
                try {
                    list = displayDao.TeacherSelectable(con);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Mtname.addItem("");
                for(int i = 0; i < list.size(); i++){
                    String teacher = list.get(i);
                    Mtname.addItem(teacher);
                }
                //院系可选项
                try {
                    list = displayDao.CollegeList(con);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Mcno.addItem("");
                for(int i = 0; i < list.size(); i++){
                    String college = list.get(i);
                    Mcno.addItem(college);
                }
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tname = Mtname.getSelectedItem().toString();
                String college = Mcno.getSelectedItem().toString();
                String intro = Ointro.getText();
                TeacherDao teacherDao = new TeacherDao();
                String tno=null;
                try {
                    tno = teacherDao.Teacher_id(con,tname);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if(!intro.isEmpty()&&intro.length()>200){
                    JOptionPane.showMessageDialog(submit,"No longer than 200!","error",0);
                }else {
                    int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                    if(input == 0){
                        OrganizationDao organizationDao = new OrganizationDao();
                        Organization club = new Organization(clubid,"","",tno,college,"","",intro);
                        try {
                            organizationDao.Organization_update(con,club);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        organization.setOcname(college);
                        organization.setOtno(tno);
                        //重新初始化页面
                        try {
                            initView();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });
        applyin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String date = formatter.format(currentTime);
                Apply apply = new Apply("","加入",clubid,usrpno,date,"0");
                //跳转到申请页面
                route.push("ClubInfo");
                try {
                    com.GUI.Apply apply1 = new com.GUI.Apply(con,rank,usrname,usrpno,"加入",apply,route);
                    apply1.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String date = formatter.format(currentTime);
                Apply apply = new Apply("","退出",clubid,usrpno,date,"0");
                //跳转到申请页面
                route.push("ClubInfo");
                try {
                    com.GUI.Apply apply1 = new com.GUI.Apply(con,rank,usrname,usrpno,"退出",apply,route);
                    apply1.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromwhere = route.pop();
                if(fromwhere.equals("ClubList")){
                    try {
                        ClubList clubList = new ClubList(con,origin_rank,usrname,usrpno,route);
                        clubList.setVisible(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }else if(fromwhere.equals("MainPage")){
                    try {
                        MainPage mainPage = new MainPage(con,Integer.toString(origin_rank),usrname);
                        mainPage.setVisible(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                dispose();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel Oname;
    private JButton back;
    private JButton applyin;
    private JLabel ono;
    private JTextField Ono;
    private JLabel odate;
    private JTextField Odate;
    private JLabel opname;
    private JTextField Opname;
    private JLabel otname;
    private JLabel ocnt;
    private JTextField Ocnt;
    private JButton teacherinfo;
    private JLabel ointro;
    private JScrollPane scrollPane1;
    private JTextArea Ointro;
    private JButton quit;
    private JButton edit;
    private JButton destroy;
    private JButton trans;
    private JButton menberinfo;
    private JLabel mcno;
    private JComboBox Mcno;
    private JComboBox Mtname;
    private JButton submit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private int origin_rank;
    private String usrname;
    private String usrpno;
    private String clubid;
    private Organization organization;
    private Stack<String> route;
}
