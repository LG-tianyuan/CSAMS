/*
 * Created by JFormDesigner on Wed May 11 18:56:28 CST 2022
 */

package com.GUI;

import com.dao.DisplayDao;
import com.dao.MemberDao;
import com.dao.PersonDao;
import com.dao.UsrDao;
import com.entity.Member;

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
public class MemberInfo extends JFrame {
    public MemberInfo(Connection connect, int rk, String uname, String sid,String pno,String cid,Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        usrname = uname;
        clubid = cid;
        usrpno = sid;
        stuid = pno;
        route = rt;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Mname = new JLabel();
        mpno = new JLabel();
        Mpno = new JTextField();
        mcno = new JLabel();
        mtel = new JLabel();
        Mtel = new JTextField();
        mgrade = new JLabel();
        edit = new JButton();
        back = new JButton();
        msex = new JLabel();
        Mqno = new JTextField();
        mjob = new JLabel();
        mwechat = new JLabel();
        Mwechat = new JTextField();
        mqno = new JLabel();
        Mname2 = new JLabel();
        mwechat2 = new JLabel();
        Mjoin = new JTextField();
        Mcname = new JComboBox();
        Mjob = new JComboBox();
        Mgrade = new JComboBox();
        Msex = new JComboBox();
        submit = new JButton();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        var contentPane = getContentPane();

        //---- Mname ----
        Mname.setText("XXX");
        Mname.setFont(Mname.getFont().deriveFont(Mname.getFont().getSize() + 6f));

        //---- mpno ----
        mpno.setText("\u5b66\u53f7");
        mpno.setFont(mpno.getFont().deriveFont(mpno.getFont().getSize() + 3f));

        //---- Mpno ----
        Mpno.setEnabled(false);
        Mpno.setEditable(false);

        //---- mcno ----
        mcno.setText("\u9662\u7cfb");
        mcno.setFont(mcno.getFont().deriveFont(mcno.getFont().getSize() + 3f));

        //---- mtel ----
        mtel.setText("\u624b\u673a");
        mtel.setFont(mtel.getFont().deriveFont(mtel.getFont().getSize() + 3f));

        //---- Mtel ----
        Mtel.setEnabled(false);
        Mtel.setEditable(false);

        //---- mgrade ----
        mgrade.setText("\u5e74\u7ea7");
        mgrade.setFont(mgrade.getFont().deriveFont(mgrade.getFont().getSize() + 3f));

        //---- edit ----
        edit.setText("\u7f16\u8f91");
        edit.setFont(edit.getFont().deriveFont(edit.getFont().getSize() + 1f));
        edit.setEnabled(false);

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 1f));

        //---- msex ----
        msex.setText("\u6027\u522b");
        msex.setFont(msex.getFont().deriveFont(msex.getFont().getSize() + 3f));

        //---- Mqno ----
        Mqno.setEnabled(false);
        Mqno.setEditable(false);

        //---- mjob ----
        mjob.setText("\u804c\u52a1");
        mjob.setFont(mjob.getFont().deriveFont(mjob.getFont().getSize() + 3f));

        //---- mwechat ----
        mwechat.setText("\u5fae\u4fe1");
        mwechat.setFont(mwechat.getFont().deriveFont(mwechat.getFont().getSize() + 3f));

        //---- Mwechat ----
        Mwechat.setEnabled(false);
        Mwechat.setEditable(false);

        //---- mqno ----
        mqno.setText("QQ");
        mqno.setFont(mqno.getFont().deriveFont(mqno.getFont().getSize() + 3f));

        //---- Mname2 ----
        Mname2.setText("\u793e\u56e2\u6210\u5458");
        Mname2.setFont(Mname2.getFont().deriveFont(Mname2.getFont().getSize() + 6f));

        //---- mwechat2 ----
        mwechat2.setText("\u52a0\u5165\u65f6\u95f4");
        mwechat2.setFont(mwechat2.getFont().deriveFont(mwechat2.getFont().getSize() + 3f));

        //---- Mjoin ----
        Mjoin.setEnabled(false);
        Mjoin.setEditable(false);

        //---- Mcname ----
        Mcname.setEnabled(false);

        //---- Mjob ----
        Mjob.setEnabled(false);

        //---- Mgrade ----
        Mgrade.setEnabled(false);

        //---- Msex ----
        Msex.setEnabled(false);

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.setFont(submit.getFont().deriveFont(submit.getFont().getSize() + 1f));
        submit.setEnabled(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(Mname2)
                            .addGap(18, 18, 18)
                            .addComponent(Mname))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(mwechat2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Mjoin, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(mjob)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Mjob, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(mcno)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Mcname, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(mpno)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Mpno, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(mwechat)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Mwechat, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(49, 49, 49)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(mqno)
                                                .addGap(18, 18, 18)
                                                .addComponent(Mqno, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(mtel)
                                                .addGap(18, 18, 18)
                                                .addComponent(Mtel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(mgrade)
                                                .addGap(18, 18, 18)
                                                .addComponent(Mgrade))
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(msex)
                                                .addGap(18, 18, 18)
                                                .addComponent(Msex, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))))))
                    .addGap(73, 73, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(edit)
                    .addGap(54, 54, 54)
                    .addComponent(submit)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                    .addComponent(back)
                    .addGap(118, 118, 118))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Mname2)
                        .addComponent(Mname))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(mpno)
                        .addComponent(Mpno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(msex)
                        .addComponent(Msex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Mcname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(mgrade)
                        .addComponent(mcno)
                        .addComponent(Mgrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Mjob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(mjob)
                        .addComponent(mtel)
                        .addComponent(Mtel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(mwechat)
                        .addComponent(Mwechat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(mqno)
                        .addComponent(Mqno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Mjoin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(mwechat2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(back)
                        .addComponent(edit)
                        .addComponent(submit))
                    .addGap(25, 25, 25))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        //默认
        Mname.setEnabled(false);
        Msex.setEnabled(false);
        Mcname.setEnabled(false);
        Mgrade.setEnabled(false);
        Mjob.setEnabled(false);
        Mtel.setEnabled(false);
        Mwechat.setEnabled(false);
        Mqno.setEnabled(false);
        Mjoin.setEnabled(false);
        edit.setEnabled(false);
        submit.setEnabled(false);
        //
        DisplayDao displayDao = new DisplayDao();
        com.entity.MemberInfo memberInfo = displayDao.MemberInfo(con,clubid,stuid);
        Mname.setText(memberInfo.getPname());
        Mpno.setText(memberInfo.getPno());
        Msex.removeAllItems();
        Msex.addItem(memberInfo.getPsex());
        Msex.setSelectedIndex(0);
        Mcname.removeAllItems();
        Mcname.addItem(memberInfo.getPcname());
        Mcname.setSelectedIndex(0);
        Mgrade.removeAllItems();
        Mgrade.addItem(memberInfo.getPgrade());
        Mgrade.setSelectedIndex(0);
        Mjob.removeAllItems();
        Mjob.addItem(memberInfo.getMjob());
        Mjob.setSelectedIndex(0);
        Mjob.setEnabled(false);
        Mtel.setText(memberInfo.getPtel());
        Mwechat.setText(memberInfo.getPwechat());
        Mqno.setText(memberInfo.getPqno());
        Mjoin.setText(memberInfo.getMjoin());
        if(rank>2){
            edit.setEnabled(true);
        }
        submit.setEnabled(false);
    }

    private void ActionListenerDemo() {
        edit.addActionListener(new ActionListener() {   //仅可改变成员和副社长的职位，有社长完成任免
            @Override
            public void actionPerformed(ActionEvent e) {
                submit.setEnabled(true);
                edit.setEnabled(false);
                Mjob.setEnabled(true);
                if(rank>3){
                    Mjob.addItem("社长");
                }
                Mjob.addItem("副社长");
                Mjob.addItem("成员");
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonDao personDao = new PersonDao();
                String myid="";
                try {
                    myid = personDao.Personid(con,usrname);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if(myid.equals(stuid)&&rank==3){ //社长不能改变自己的职务，必须申请才能转让社团
                    JOptionPane.showMessageDialog(submit,"你没有更改自己职务的权限！请向管理员申请！","error",0);
                }else{
                    int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                    if(input == 0) {
                        String job = Mjob.getSelectedItem().toString();
                        //更新职务信息
                        Member member = new Member(clubid,stuid,job,"");
                        MemberDao memberDao = new MemberDao();
                        try {
                            memberDao.Member_update(con,member);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        //更新对应账户的权限等级，待考虑
                        String pno = Mpno.getText();
                        String uname="";
                        try {
                            uname = personDao.Person_username(con,pno);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        String temp_rank = "1";
                        if(job.equals("副社长")){
                            temp_rank="2";
                        }else if(job.equals("社长")){
                            temp_rank="3";
                        }
                        UsrDao usrDao = new UsrDao();
                        try {
                            usrDao.user_update(con,uname,temp_rank);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                        try {
                            initView();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }

            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //返回上一个界面
                route.pop();
                try {
                    MemberList memberList = new MemberList(con,rank,usrname,usrpno,clubid,route);
                    memberList.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel Mname;
    private JLabel mpno;
    private JTextField Mpno;
    private JLabel mcno;
    private JLabel mtel;
    private JTextField Mtel;
    private JLabel mgrade;
    private JButton edit;
    private JButton back;
    private JLabel msex;
    private JTextField Mqno;
    private JLabel mjob;
    private JLabel mwechat;
    private JTextField Mwechat;
    private JLabel mqno;
    private JLabel Mname2;
    private JLabel mwechat2;
    private JTextField Mjoin;
    private JComboBox Mcname;
    private JComboBox Mjob;
    private JComboBox Mgrade;
    private JComboBox Msex;
    private JButton submit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String usrname;
    private String usrpno;
    private String clubid;
    private String stuid;
    private Stack<String> route;
}
