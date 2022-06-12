/*
 * Created by JFormDesigner on Mon May 16 10:38:41 CST 2022
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
public class ClubList extends JFrame {
    public ClubList(Connection connect,int rk,String uname,String id,Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        usrname = uname;
        studentid = id;
        route = rt;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        titile1 = new JLabel();
        ClubList = new JScrollPane();
        clublist = new JList();
        back = new JButton();
        title2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- titile1 ----
        titile1.setText("\u6211\u7684\u793e\u56e2");
        titile1.setFont(titile1.getFont().deriveFont(titile1.getFont().getSize() + 6f));

        //======== ClubList ========
        {

            //---- clublist ----
            clublist.setFont(clublist.getFont().deriveFont(clublist.getFont().getSize() + 2f));
            ClubList.setViewportView(clublist);
        }

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 1f));

        //---- title2 ----
        title2.setText("\u793e\u56e2\u5217\u8868\u4fe1\u606f");
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
                                .addComponent(ClubList, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
                                .addComponent(title2)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(245, 245, 245)
                            .addComponent(titile1)))
                    .addContainerGap(60, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 250, Short.MAX_VALUE)
                    .addComponent(back)
                    .addGap(245, 245, 245))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(titile1)
                    .addGap(18, 18, 18)
                    .addComponent(title2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ClubList, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(back)
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        DisplayDao displayDao = new DisplayDao();
        List<String> list = displayDao.MyClubList(con,studentid);
        clublist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ClubList.setViewportView(clublist);
        clublist.setListData(list.toArray());
    }

    private void ActionListenerDemo() {
        clublist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String club = clublist.getSelectedValue().toString();
                OrganizationDao organizationDao = new OrganizationDao();
                String clubid = null;
                try {
                    clubid = organizationDao.Organization_id(con,club);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                //跳转到社团信息页面
                route.push("ClubList");
                try {
                    ClubInfo clubInfo = new ClubInfo(con,rank,usrname,studentid,clubid,route);
                    clubInfo.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //退出该页面
                route.pop();
                try {
                    MainPage mainPage = new MainPage(con,Integer.toString(rank),usrname);
                    mainPage.setVisible(true);
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
    private JList clublist;
    private JButton back;
    private JLabel title2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String studentid;
    private String usrname;
    private Stack<String> route;
}
