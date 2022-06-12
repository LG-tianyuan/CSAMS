/*
 * Created by JFormDesigner on Wed May 11 09:30:26 CST 2022
 */

package com.GUI;

import com.dao.CollegeDao;
import com.dao.DisplayDao;

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
public class CollegeList extends JFrame {
    public CollegeList(Connection connect, int rk, String uname, String pno, Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        username = uname;
        usrpno = pno;
        route = rt;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        titile1 = new JLabel();
        CollegeList = new JScrollPane();
        collegelist = new JList();
        back = new JButton();
        title2 = new JLabel();
        create = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- titile1 ----
        titile1.setText("\u9662\u7cfb\u4fe1\u606f");
        titile1.setFont(titile1.getFont().deriveFont(titile1.getFont().getSize() + 6f));

        //======== CollegeList ========
        {

            //---- collegelist ----
            collegelist.setFont(collegelist.getFont().deriveFont(collegelist.getFont().getSize() + 2f));
            CollegeList.setViewportView(collegelist);
        }

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 1f));

        //---- title2 ----
        title2.setText("\u9662\u7cfb\u5217\u8868\u4fe1\u606f");
        title2.setFont(title2.getFont().deriveFont(title2.getFont().getSize() + 3f));

        //---- create ----
        create.setText("\u65b0\u589e");
        create.setFont(create.getFont().deriveFont(create.getFont().getSize() + 1f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(CollegeList, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
                                .addComponent(title2)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(245, 245, 245)
                            .addComponent(titile1)))
                    .addContainerGap(60, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(122, 122, 122)
                    .addComponent(create)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                    .addComponent(back)
                    .addGap(137, 137, 137))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(titile1)
                    .addGap(18, 18, 18)
                    .addComponent(title2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(CollegeList, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(create)
                        .addComponent(back))
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        DisplayDao displayDao = new DisplayDao();
        List<String> list = displayDao.CollegeList(con);
        collegelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        CollegeList.setViewportView(collegelist);
        collegelist.setListData(list.toArray());
    }

    private void ActionListenerDemo() {
        collegelist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String collegename = collegelist.getSelectedValue().toString();
                //跳转到院系信息页面
                CollegeDao collegeDao = new CollegeDao();
                String cno=null;
                try {
                    cno = collegeDao.College_id(con,collegename);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                route.push("CollegeList");
                try {
                    CollegeInfo collegeInfo = new CollegeInfo(con,rank,username,usrpno,cno,route);
                    collegeInfo.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispose();
            }
        });
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到院系信息页面
                route.push("CollegeList");
                try {
                    CollegeInfo collegeInfo = new CollegeInfo(con,rank,username,usrpno,"",route);
                    collegeInfo.setVisible(true);
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
                    MainPage mainPage = new MainPage(con,Integer.toString(rank),username);
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
    private JScrollPane CollegeList;
    private JList collegelist;
    private JButton back;
    private JLabel title2;
    private JButton create;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String username;
    private String usrpno;
    private Stack<String> route;
}
