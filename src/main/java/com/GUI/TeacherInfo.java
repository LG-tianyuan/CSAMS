/*
 * Created by JFormDesigner on Tue May 10 21:39:53 CST 2022
 */

package com.GUI;

import com.dao.DisplayDao;
import com.dao.TeacherDao;
import com.entity.Teacher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author LG-tianyuan
 */
public class TeacherInfo extends JFrame {
    //from where: teacherlist clubinfo
    public TeacherInfo(Connection connect, int rk, String uname, String pno,String tno,String ono,Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        username = uname;
        usrpno = pno;
        teacherid = tno;
        clubid = ono;
        route = rt;
        System.out.println(rank);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        title = new JLabel();
        tjob = new JLabel();
        tcname = new JLabel();
        ttel = new JLabel();
        Ttel = new JTextField();
        tintro = new JLabel();
        scrollPane1 = new JScrollPane();
        Tintro = new JTextPane();
        edit = new JButton();
        delete = new JButton();
        back = new JButton();
        submit = new JButton();
        tname = new JLabel();
        tno = new JLabel();
        Tname = new JTextField();
        Tno = new JTextField();
        Tjob = new JComboBox();
        Tcname = new JComboBox();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        var contentPane = getContentPane();

        //---- title ----
        title.setText("\u6307\u5bfc\u8001\u5e08");
        title.setFont(title.getFont().deriveFont(title.getFont().getSize() + 6f));

        //---- tjob ----
        tjob.setText("\u804c\u79f0");
        tjob.setFont(tjob.getFont().deriveFont(tjob.getFont().getSize() + 3f));

        //---- tcname ----
        tcname.setText("\u9662\u7cfb");
        tcname.setFont(tcname.getFont().deriveFont(tcname.getFont().getSize() + 3f));

        //---- ttel ----
        ttel.setText("\u624b\u673a");
        ttel.setFont(ttel.getFont().deriveFont(ttel.getFont().getSize() + 3f));

        //---- Ttel ----
        Ttel.setEnabled(false);

        //---- tintro ----
        tintro.setText("\u7b80\u4ecb");
        tintro.setFont(tintro.getFont().deriveFont(tintro.getFont().getSize() + 3f));

        //======== scrollPane1 ========
        {

            //---- Tintro ----
            Tintro.setEnabled(false);
            scrollPane1.setViewportView(Tintro);
        }

        //---- edit ----
        edit.setText("\u7f16\u8f91");
        edit.setFont(edit.getFont().deriveFont(edit.getFont().getSize() + 1f));
        edit.setEnabled(false);

        //---- delete ----
        delete.setText("\u5220\u9664");
        delete.setFont(delete.getFont().deriveFont(delete.getFont().getSize() + 1f));
        delete.setEnabled(false);

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 1f));

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.setFont(submit.getFont().deriveFont(submit.getFont().getSize() + 1f));
        submit.setEnabled(false);

        //---- tname ----
        tname.setText("\u59d3\u540d");
        tname.setFont(tname.getFont().deriveFont(tname.getFont().getSize() + 3f));

        //---- tno ----
        tno.setText("\u804c\u5de5\u53f7");
        tno.setFont(tno.getFont().deriveFont(tno.getFont().getSize() + 3f));

        //---- Tname ----
        Tname.setEnabled(false);

        //---- Tno ----
        Tno.setEnabled(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(delete)
                                    .addGap(18, 18, 18)
                                    .addComponent(edit)
                                    .addGap(18, 18, 18)
                                    .addComponent(submit)
                                    .addGap(94, 94, 94)
                                    .addComponent(back))
                                .addComponent(tintro)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(tcname)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Tcname, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(tname)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Tname, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(52, 52, 52)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(ttel)
                                        .addComponent(tjob))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(Ttel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Tjob, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(tno)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tno, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(253, 253, 253)
                            .addComponent(title)))
                    .addContainerGap(73, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title)
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tno)
                        .addComponent(Tno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tname)
                        .addComponent(Tname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tjob)
                        .addComponent(Tjob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tcname)
                        .addComponent(Tcname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ttel)
                        .addComponent(Ttel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tintro)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(back)
                        .addComponent(delete)
                        .addComponent(edit)
                        .addComponent(submit))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        //默认
        Tno.setEnabled(false);
        Tname.setEnabled(false);
        Tjob.setEnabled(false);
        Tcname.setEnabled(false);
        Ttel.setEnabled(false);
        Tintro.setEnabled(false);
        delete.setEnabled(false);
        edit.setEnabled(false);
        submit.setEnabled(false);
        //
        if(teacherid.equals("")) //总管理员插入教师信息
        {
            Tno.setEnabled(true);
            Tname.setEnabled(true);
            Tjob.setEnabled(true);
            Tcname.setEnabled(true);
            Ttel.setEnabled(true);
            Tintro.setEnabled(true);
            submit.setEnabled(true);
            SetSelectableItem();
        } else {
            TeacherDao teacherDao = new TeacherDao();
            Teacher teacher = teacherDao.Teacher_Info(con,teacherid);
            if(rank == 4)  //总管理员可编辑信息和删除
            {
                delete.setEnabled(true);
                edit.setEnabled(true);
                Tno.setText(teacher.getTno());
            } else if (rank == 3 || rank == 2) { //社团干部可编辑信息
                edit.setEnabled(true);
            }
            Tname.setText(teacher.getTname());
            Tjob.removeAllItems();
            Tjob.addItem(teacher.getTjob());
            Tjob.setSelectedIndex(0);
            Tcname.removeAllItems();
            Tcname.addItem(teacher.getTcname());
            Tcname.setSelectedIndex(0);
            Ttel.setText(teacher.getTtel());
            Tintro.setText(teacher.getTintro());
        }
    }

    private void ActionListenerDemo(){
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit.setEnabled(true);
                edit.setEnabled(false);
                delete.setEnabled(false);
                Tjob.setEnabled(true);
                Tcname.setEnabled(true);
                Ttel.setEnabled(true);
                Tintro.setEnabled(true);
                try {
                    SetSelectableItem();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        delete.addActionListener(new ActionListener() { //还需检查是否存在被引用，要么定义级联删除
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(delete,"Are you sure to submit?","submit notice",1,2);
                if(input == 0){
                    TeacherDao teacherDao = new TeacherDao();
                    try {
                        teacherDao.Teacher_delete(con,teacherid);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    //删除后返回上一个页面
                    String fromwhere = route.pop();
                    if(fromwhere.equals("TeacherList")){
                        TeacherList teacherList = null;
                        try {
                            teacherList = new TeacherList(con,rank,username,usrpno,route);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        teacherList.setVisible(true);
                    }else if(fromwhere.equals("ClubInfo")){
                        ClubInfo clubInfo = null;
                        try {
                            clubInfo = new ClubInfo(con,rank,username,usrpno,clubid,route);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        clubInfo.setVisible(true);
                    }
                    dispose();
                }
            }
        });
        submit.addActionListener(new ActionListener() { //problem
            @Override
            public void actionPerformed(ActionEvent e) {
                if(teacherid.equals("")){//插入
                    String id = Tno.getText();
                    String name = Tname.getText();
                    String job = Tjob.getSelectedItem().toString();
                    String college = Tcname.getSelectedItem().toString();
                    String tel = Ttel.getText();
                    String intro = Tintro.getText();
                    if(!id.matches("[0-9]{6,16}")){
                        JOptionPane.showMessageDialog(submit,"Teacher ID invalid! Can only contain number with length 6~16!","error",0);
                    }else if(name.isEmpty()||name.length()>20){
                        JOptionPane.showMessageDialog(submit,"Name invalid! With Length 1~20!","error",0);
                    }else if(!tel.matches("[1][3-9][0-9]{9}")){
                        JOptionPane.showMessageDialog(submit,"Tel invalide! Your phone number should be valid with 11 numbers!","error",0);
                    }else if(!intro.isEmpty() && intro.length()>200){
                        JOptionPane.showMessageDialog(submit,"Introduction invalide! No longer than 200 characters!","error",0);
                    }else{
                        TeacherDao teacherDao = new TeacherDao();
                        boolean flag = false;
                        try {
                            flag = teacherDao.Teacher_check1(con,id);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        if(flag){
                            try {
                                flag = teacherDao.Teacher_check2(con,name);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            if(flag)
                            {
                                int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                                if(input == 0){
                                    Teacher teacher = new Teacher(id,name,job,tel,college,intro);
                                    try {
                                        teacherDao.Teacher_insert(con,teacher);
                                    } catch (SQLException throwables) {
                                        throwables.printStackTrace();
                                    }
                                    teacherid = id;
                                    //更新视图
                                    try {
                                        initView();
                                    } catch (SQLException throwables) {
                                        throwables.printStackTrace();
                                    }
                                }
                            }else {
                                JOptionPane.showMessageDialog(submit,"Duplicate teacher name! Please add number to identify!","error",0);
                            }
                        }else {
                            JOptionPane.showMessageDialog(submit,"Teacher id already exist!","error",0);
                        }
                    }
                }else{
                    String tel = Ttel.getText();
                    String intro = Tintro.getText();
                    if(!tel.matches("[1][3-9][0-9]{9}")){
                        JOptionPane.showMessageDialog(submit,"Tel invalide! Your phone number should be valid with 11 numbers!","error",0);
                    }else if(!intro.isEmpty() && intro.length()>200){
                        JOptionPane.showMessageDialog(submit,"Introduction invalide! No longer than 200 characters!","error",0);
                    }else{
                        int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                        if(input == 0){
                            Teacher teacher = new Teacher(teacherid,"",Tjob.getSelectedItem().toString(),tel,
                                    Tcname.getSelectedItem().toString(),intro);
                            TeacherDao teacherDao = new TeacherDao();
                            try {
                                teacherDao.Teacher_update(con,teacher);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
//                            submit.setEnabled(false);
//                            edit.setEnabled(true);
//                            delete.setEnabled(true);
                            //更新视图
                            try {
                                initView();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
//                            dispose();
                        }
                    }
                }
            }

        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转会上一个页面
                String fromwhere = route.pop();
                if(fromwhere.equals("TeacherList")){
                    TeacherList teacherList = null;
                    try {
                        teacherList = new TeacherList(con,rank,username,usrpno,route);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    teacherList.setVisible(true);
                }else if(fromwhere.equals("ClubInfo")){
                    ClubInfo clubInfo = null;
                    try {
                        clubInfo = new ClubInfo(con,rank,username,usrpno,clubid,route);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    clubInfo.setVisible(true);
                }
                dispose();
            }
        });
    }

    private void SetSelectableItem() throws SQLException {
        Tjob.addItem("");
        Tjob.addItem("教授");
        Tjob.addItem("副教授");
        Tjob.addItem("研究员");
        Tjob.addItem("讲师");
        Tjob.addItem("辅导员");
        Tjob.addItem("其他");
        DisplayDao displayDao = new DisplayDao();
        List<String> list = displayDao.CollegeList(con);
        Tcname.addItem("");
        for(int i = 0; i < list.size(); i++){
            String college = list.get(i);
            Tcname.addItem(college);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel title;
    private JLabel tjob;
    private JLabel tcname;
    private JLabel ttel;
    private JTextField Ttel;
    private JLabel tintro;
    private JScrollPane scrollPane1;
    private JTextPane Tintro;
    private JButton edit;
    private JButton delete;
    private JButton back;
    private JButton submit;
    private JLabel tname;
    private JLabel tno;
    private JTextField Tname;
    private JTextField Tno;
    private JComboBox Tjob;
    private JComboBox Tcname;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String username;
    private String usrpno;
    private String teacherid;
    private String clubid;
    private Stack<String> route;
}
