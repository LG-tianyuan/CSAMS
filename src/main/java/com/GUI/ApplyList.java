/*
 * Created by JFormDesigner on Wed May 11 19:35:35 CST 2022
 */

package com.GUI;

import com.dao.DisplayDao;
import com.dao.MemberDao;
import com.entity.Apply;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LG-tianyuan
 */
public class ApplyList extends JFrame {
    public ApplyList(Connection connect,int rk,String uname,String sid,String tp,Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        usrname = uname;
        pno = sid;
        type = tp;
        route = rt;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        titile1 = new JLabel();
        ApplyList = new JScrollPane();
        applylist = new JList();
        back = new JButton();
        title2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- titile1 ----
        titile1.setText("\u7533\u8bf7");
        titile1.setFont(titile1.getFont().deriveFont(titile1.getFont().getSize() + 6f));

        //======== ApplyList ========
        {

            //---- applylist ----
            applylist.setFont(applylist.getFont().deriveFont(applylist.getFont().getSize() + 2f));
            ApplyList.setViewportView(applylist);
        }

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 1f));

        //---- title2 ----
        title2.setText("\u7533\u8bf7\u5217\u8868\u4fe1\u606f");
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
                                .addComponent(ApplyList, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
                                .addComponent(title2)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(269, 269, 269)
                            .addComponent(titile1)))
                    .addContainerGap(60, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 254, Short.MAX_VALUE)
                    .addComponent(back)
                    .addGap(241, 241, 241))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(titile1)
                    .addGap(18, 18, 18)
                    .addComponent(title2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ApplyList, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(back)
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        applylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ApplyList.setViewportView(applylist);
        if(type.equals("查看")){
            DisplayDao displayDao = new DisplayDao();
            List<String> list = displayDao.ApplyList_Personal_View(con,pno);
            applylist.setListData(list.toArray());
        }else {
            DisplayDao displayDao = new DisplayDao();
            if(rank == 2 || rank == 3)
            {
                MemberDao memberDao = new MemberDao();
                List<String> list1 = memberDao.Manage_Clubs(con,pno);
                List<String> list = new ArrayList<String>();
                for(int i=0;i<list1.size();i++)
                {
                    String ono = list1.get(i);
                    list.addAll(displayDao.ApplyList_Monitor_View(con,ono));
                }
                applylist.setListData(list.toArray());
            }else {
                List<String> list = displayDao.ApplyList_Manager_View(con);
                applylist.setListData(list.toArray());
            }
        }
    }

    private void ActionListenerDemo(){
        applylist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String temp = applylist.getSelectedValue().toString();
                String[] info = temp.split(",");
                String Ano = info[0];
                String Apno = info[1];
                String Atype = info[2];
                Apply apply = new Apply(Ano,Atype,"",Apno,"","");
                route.push("ApplyList");
                try {
                    com.GUI.Apply apply1 = new com.GUI.Apply(con,rank,usrname,pno,type,apply,route);
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
                //跳转回上个页面
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
    private JScrollPane ApplyList;
    private JList applylist;
    private JButton back;
    private JLabel title2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String usrname;
    private String type;
    private String content;
    private String pno;
    private Stack<String> route;
}
