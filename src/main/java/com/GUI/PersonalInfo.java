/*
 * Created by JFormDesigner on Tue May 10 20:45:26 CST 2022
 */

package com.GUI;

import com.dao.DisplayDao;
import com.dao.PersonDao;
import com.entity.Person;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;

/**
 * @author LG-tianyuan
 */
public class PersonalInfo extends JFrame {
    public PersonalInfo(Connection connect, int rk, String uname, String id) throws SQLException {
        con = connect;
        rank = rk;
        usrname = uname;
        studentid = id;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        title = new JLabel();
        username = new JLabel();
        pno = new JLabel();
        pname = new JLabel();
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
        edit = new JButton();
        back = new JButton();
        submit = new JButton();
        Pno = new JTextField();
        Puname = new JTextField();
        Page = new JComboBox();

        //======== this ========
        var contentPane = getContentPane();

        //---- title ----
        title.setText("\u4e2a\u4eba\u4fe1\u606f");
        title.setFont(title.getFont().deriveFont(title.getFont().getSize() + 6f));

        //---- username ----
        username.setText("\u7528\u6237");
        username.setFont(username.getFont().deriveFont(username.getFont().getSize() + 3f));

        //---- pno ----
        pno.setText("\u5b66\u53f7");
        pno.setFont(pno.getFont().deriveFont(pno.getFont().getSize() + 3f));

        //---- pname ----
        pname.setText("\u59d3\u540d");
        pname.setFont(pname.getFont().deriveFont(pname.getFont().getSize() + 3f));

        //---- Pname ----
        Pname.setEnabled(false);

        //---- pgrade ----
        pgrade.setText("\u5e74\u7ea7");
        pgrade.setFont(pgrade.getFont().deriveFont(pgrade.getFont().getSize() + 3f));

        //---- pcname ----
        pcname.setText("\u9662\u7cfb");
        pcname.setFont(pcname.getFont().deriveFont(pcname.getFont().getSize() + 3f));

        //---- Pgrade ----
        Pgrade.setEnabled(false);

        //---- Pcname ----
        Pcname.setEnabled(false);

        //---- Psex ----
        Psex.setEnabled(false);

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

        //---- Ptel ----
        Ptel.setEnabled(false);

        //---- Pwechat ----
        Pwechat.setEnabled(false);

        //---- pqno ----
        pqno.setText("QQ");
        pqno.setFont(pqno.getFont().deriveFont(pqno.getFont().getSize() + 3f));

        //---- Pqno ----
        Pqno.setEnabled(false);

        //---- edit ----
        edit.setText("\u7f16\u8f91");
        edit.setFont(edit.getFont().deriveFont(edit.getFont().getSize() + 2f));

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 2f));

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.setFont(submit.getFont().deriveFont(submit.getFont().getSize() + 2f));
        submit.setEnabled(false);

        //---- Pno ----
        Pno.setEnabled(false);

        //---- Puname ----
        Puname.setEnabled(false);

        //---- Page ----
        Page.setEnabled(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(edit)
                    .addGap(65, 65, 65)
                    .addComponent(submit)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                    .addComponent(back)
                    .addGap(96, 96, 96))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(username)
                                    .addComponent(pno)
                                    .addComponent(pgrade, GroupLayout.Alignment.TRAILING))
                                .addComponent(psex)
                                .addComponent(ptel)
                                .addComponent(pqno))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(Pqno, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Pgrade, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                            .addComponent(Psex, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                            .addComponent(Ptel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                                        .addComponent(Pno, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                    .addGap(46, 46, 46)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(pcname)
                                            .addGap(18, 18, 18)
                                            .addComponent(Pcname, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(pname)
                                            .addGap(18, 18, 18)
                                            .addComponent(Pname, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(page)
                                            .addGap(18, 18, 18)
                                            .addComponent(Page, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(pwechat)
                                            .addGap(18, 18, 18)
                                            .addComponent(Pwechat, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))))
                                .addComponent(Puname, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(251, 251, 251)
                            .addComponent(title)))
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title)
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(username)
                        .addComponent(Puname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pno)
                        .addComponent(pname)
                        .addComponent(Pname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pgrade)
                        .addComponent(Pgrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pcname)
                        .addComponent(Pcname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Psex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(psex)
                        .addComponent(page)
                        .addComponent(Page, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ptel)
                        .addComponent(pwechat)
                        .addComponent(Ptel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pwechat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pqno)
                        .addComponent(Pqno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(back)
                        .addComponent(edit)
                        .addComponent(submit))
                    .addContainerGap(38, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        submit.setEnabled(false);
        edit.setEnabled(true);
        Pname.setEnabled(false);
        Pgrade.setEnabled(false);
        Pcname.setEnabled(false);
        Psex.setEnabled(false);
        Page.setEnabled(false);
        Ptel.setEnabled(false);
        Pwechat.setEnabled(false);
        Pqno.setEnabled(false);
        PersonDao personDao = new PersonDao();
        Person person = personDao.PersonalInfo(con,studentid);
        Puname.setText(person.getPuname());
        Pno.setText(studentid);
        Pname.setText(person.getPname());
        Pgrade.removeAllItems();
        Pgrade.addItem(person.getPgrade());
        Pgrade.setSelectedItem(0);
        Pcname.removeAllItems();
        Pcname.addItem(person.getPcname());
        Pcname.setSelectedItem(0);
        Psex.removeAllItems();
        Psex.addItem(person.getPsex());
        Psex.setSelectedItem(0);
        Page.removeAllItems();
        Page.addItem(person.getPage());
        Page.setSelectedItem(0);
        Ptel.setText(person.getPtel());
        Pwechat.setText(person.getPwechat());
        Pqno.setText(person.getPqno());
    }

    private void ActionListenerDemo() {
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.setEnabled(false);
                submit.setEnabled(true);
                Pname.setEnabled(true);
                Pgrade.setEnabled(true);
                Pcname.setEnabled(true);
                Psex.setEnabled(true);
                Page.setEnabled(true);
                Ptel.setEnabled(true);
                Pwechat.setEnabled(true);
                Pqno.setEnabled(true);
                try {
                    SetSelectableItem();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = Pname.getText();
                String grade = Pgrade.getSelectedItem().toString();
                String cname = Pcname.getSelectedItem().toString();
                String sex = Psex.getSelectedItem().toString();
                String age = Page.getSelectedItem().toString();
                String tel = Ptel.getText();
                String wechat = Pwechat.getText();
                String qq = Pqno.getText();
                if(name.isEmpty()||name.length()>20){
                    JOptionPane.showMessageDialog(submit,"Name invalid! With Length 1~20!","error",0);
                }else if(!tel.matches("[1][3-9][0-9]{9}")){
                    JOptionPane.showMessageDialog(submit,"Tel invalide! Your phone number should be valid with 11 numbers!","error",0);
                }else if(!wechat.isEmpty()&&(wechat.length()<6||wechat.length()>20)){
                    JOptionPane.showMessageDialog(submit,"Wechat invalid! With length 6~20!","error",0);
                }else if(!qq.isEmpty()&&(qq.length()<5||qq.length()>11)){
                    JOptionPane.showMessageDialog(submit,"QQ invalid! With length 6~20!","error",0);
                }else{
                    int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                    if(input == 0){
                        PersonDao personDao = new PersonDao();
                        Person person = new Person(studentid,name,"",grade,cname,sex,age,"",tel,wechat,qq);
                        try {
                            personDao.Person_update(con,person);
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
                //返回上一个页面
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

    private void SetSelectableItem() throws SQLException {
        for(int i = 2015; i < 2022; i++){
            Pgrade.addItem(Integer.toString(i));
        }
        DisplayDao displayDao = new DisplayDao();
        List<String> list = displayDao.CollegeList(con);
        for(int i = 0; i < list.size(); i++){
            String college = list.get(i);
            Pcname.addItem(college);
        }
        Psex.addItem("男");
        Psex.addItem("女");
        for(int i = 0; i < 120; i++){
            Page.addItem(Integer.toString(i));
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel title;
    private JLabel username;
    private JLabel pno;
    private JLabel pname;
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
    private JButton edit;
    private JButton back;
    private JButton submit;
    private JTextField Pno;
    private JTextField Puname;
    private JComboBox Page;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String usrname;
    private String studentid;
    private Stack<String> route;
}
