/*
 * Created by JFormDesigner on Wed May 11 13:12:21 CST 2022
 */

package com.GUI;

import com.dao.DisplayDao;
import com.dao.OrganizationDao;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;

/**
 * @author LG-tianyuan
 */
public class MemberList extends JFrame {
    public MemberList(Connection connect, int rk, String uname,String pno, String id,Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        clubid = id;
        usrpno = pno;
        username = uname;
        route = rt;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        title1 = new JLabel();
        MemberList = new JScrollPane();
        memberlist = new JList();
        back = new JButton();
        title2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- title1 ----
        title1.setText("xxx\u793e\u56e2\u6210\u5458\u4fe1\u606f");
        title1.setFont(title1.getFont().deriveFont(title1.getFont().getSize() + 6f));

        //======== MemberList ========
        {

            //---- memberlist ----
            memberlist.setFont(memberlist.getFont().deriveFont(memberlist.getFont().getSize() + 2f));
            MemberList.setViewportView(memberlist);
        }

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 1f));

        //---- title2 ----
        title2.setText("\u6210\u5458\u5217\u8868\u4fe1\u606f");
        title2.setFont(title2.getFont().deriveFont(title2.getFont().getSize() + 3f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(MemberList, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
                                .addComponent(title2)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(title1)))
                    .addContainerGap(60, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 248, Short.MAX_VALUE)
                    .addComponent(back)
                    .addGap(247, 247, 247))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(title1)
                    .addGap(18, 18, 18)
                    .addComponent(title2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(MemberList, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(back)
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        OrganizationDao organizationDao = new OrganizationDao();
        String club_name = organizationDao.Organization_name(con,clubid);
        String title = club_name + "成员信息";
        title1.setText(title);
        DisplayDao displayDao = new DisplayDao();
        List<String> list = displayDao.MemberList(con,clubid);
        memberlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        MemberList.setViewportView(memberlist);
        memberlist.setListData(list.toArray());
    }

    private void ActionListenerDemo() {
        memberlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String temp = memberlist.getSelectedValue().toString();
                String[] info = temp.split(",");
                String pno = info[0];
                //跳转到memberinfo界面
                route.push("MemberList");
                try {
                    MemberInfo memberInfo = new MemberInfo(con,rank,username,usrpno,pno,clubid,route);
                    memberInfo.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转回上个页面
                route.pop();
                try {
                    ClubInfo clubInfo = new ClubInfo(con,rank,username,usrpno,clubid,route);
                    clubInfo.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel title1;
    private JScrollPane MemberList;
    private JList memberlist;
    private JButton back;
    private JLabel title2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String clubid;
    private String username;
    private String usrpno;
    private Stack<String> route;
}
