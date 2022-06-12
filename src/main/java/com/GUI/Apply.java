/*
 * Created by JFormDesigner on Tue May 10 22:02:33 CST 2022
 */

package com.GUI;

import com.dao.*;
import com.entity.Member;
import com.entity.Organization;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/**
 * @author LG-tianyuan
 */
public class Apply extends JFrame {
    //tp:查看，审批，创建，加入，退出，转让，解散
    public Apply(Connection connect, int rk, String uname, String uid, String tp, com.entity.Apply apply,Stack<String> rt) throws SQLException {
        con = connect;
        rank = rk;
        usrname = uname;
        usrpno = uid;
        applyid = apply.getAno();
        clubid = apply.getAcont();
        type = tp;
        origin_type = tp;
        temp = apply;
        route = rt;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        initView();
        ActionListenerDemo();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        title = new JLabel();
        ano = new JLabel();
        atype = new JLabel();
        acont = new JLabel();
        apno = new JLabel();
        Apno = new JTextField();
        adate = new JLabel();
        Adate = new JTextField();
        back = new JButton();
        submit = new JButton();
        Ano = new JTextField();
        pass = new JButton();
        apass = new JLabel();
        Atype = new JTextField();
        Apass = new JTextField();
        Acont = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //---- title ----
        title.setText("\u7533\u8bf7");
        title.setFont(title.getFont().deriveFont(title.getFont().getSize() + 6f));

        //---- ano ----
        ano.setText("\u7533\u8bf7\u7f16\u53f7");
        ano.setFont(ano.getFont().deriveFont(ano.getFont().getSize() + 3f));

        //---- atype ----
        atype.setText("\u7533\u8bf7\u7c7b\u578b");
        atype.setFont(atype.getFont().deriveFont(atype.getFont().getSize() + 3f));

        //---- acont ----
        acont.setText("\u7533\u8bf7\u5185\u5bb9");
        acont.setFont(acont.getFont().deriveFont(acont.getFont().getSize() + 3f));

        //---- apno ----
        apno.setText("\u7533\u8bf7\u4eba");
        apno.setFont(apno.getFont().deriveFont(apno.getFont().getSize() + 3f));

        //---- Apno ----
        Apno.setEnabled(false);

        //---- adate ----
        adate.setText("\u7533\u8bf7\u65f6\u95f4");
        adate.setFont(adate.getFont().deriveFont(adate.getFont().getSize() + 3f));

        //---- Adate ----
        Adate.setEnabled(false);

        //---- back ----
        back.setText("\u8fd4\u56de");
        back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 2f));

        //---- submit ----
        submit.setText("\u63d0\u4ea4");
        submit.setFont(submit.getFont().deriveFont(submit.getFont().getSize() + 2f));
        submit.setEnabled(false);

        //---- Ano ----
        Ano.setEnabled(false);

        //---- pass ----
        pass.setText("\u5ba1\u6279\u901a\u8fc7");
        pass.setFont(pass.getFont().deriveFont(pass.getFont().getSize() + 2f));
        pass.setEnabled(false);

        //---- apass ----
        apass.setText("\u662f\u5426\u901a\u8fc7");
        apass.setFont(apass.getFont().deriveFont(apass.getFont().getSize() + 3f));

        //---- Atype ----
        Atype.setEnabled(false);

        //---- Apass ----
        Apass.setEnabled(false);

        //---- Acont ----
        Acont.setEnabled(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(268, 268, 268)
                            .addComponent(title))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(pass)
                                    .addGap(71, 71, 71)
                                    .addComponent(submit, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                    .addComponent(back, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(apass)
                                                .addComponent(adate))
                                            .addGap(41, 41, 41)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(Adate, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Apass, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(atype)
                                                    .addComponent(ano)
                                                    .addComponent(acont))
                                                .addComponent(apno))
                                            .addGap(41, 41, 41)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(Atype, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Ano, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Acont, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Apno, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))))))))
                    .addGap(79, 79, 79))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title)
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Ano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ano))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Atype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(atype))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Acont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(acont))
                    .addGap(13, 13, 13)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Apno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(apno))
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Adate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(adate))
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(apass)
                        .addComponent(Apass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(back)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(pass)
                            .addComponent(submit)))
                    .addContainerGap(16, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initView() throws SQLException {
        //默认
        Ano.setEnabled(false);
        Acont.setEnabled(false);
        Atype.setEnabled(false);
        Apass.setEnabled(false);
        Apno.setEnabled(false);
        Adate.setEnabled(false);
        pass.setEnabled(false);
        submit.setEnabled(false);
        //根据不同情况初始化
        ApplyDao applyDao = new ApplyDao();
        if(type.equals("查看")||type.equals("审批")){
            com.entity.Apply apply = applyDao.Apply_Info(con,applyid);
            temp = apply;
            Ano.setText(apply.getAno());
            Atype.setText(apply.getAtype());
            Acont.setText(apply.getAcont());
            Apno.setText(apply.getApno());
            Adate.setText(apply.getAdate());
            Acont.setEnabled(false);
            submit.setEnabled(false);
            if(apply.getApass().equals("1")){
                Apass.setText("已通过");
                pass.setEnabled(false);
            }else{
                Apass.setText("未通过");
                if(type.equals("审批")){
                    pass.setEnabled(true);
                }
            }

        }else {
            submit.setEnabled(true);
            String count = applyDao.Apply_count(con);
            int cnt = Integer.parseInt(count) + 1;
            Ano.setText(Integer.toString(cnt));
            temp.setAno(Integer.toString(cnt));//设置申请编号
            Atype.setText(temp.getAtype());
            Apno.setText(temp.getApno());

            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = formatter.format(currentTime);
            Adate.setText(date);
            Apass.setText("待申请");
            if(type.equals("创建")){
                Acont.setEnabled(true);
                Acont.setToolTipText("请输入申请创建的社团名称");
            }else if(type.equals("转让")){
                Acont.setEnabled(true);
                Acont.setToolTipText("请输入转让给的成员的学号");
            }else {
                Acont.setText(temp.getAcont());
                Acont.setToolTipText("申请的社团编号");
            }
        }
    }

    private void ActionListenerDemo() {
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrganizationDao organizationDao = new OrganizationDao();
                MemberDao memberDao = new MemberDao();
                ApplyDao applyDao = new ApplyDao();
                boolean flag = true;
                if(temp.getAtype().equals("创建")){
                    //获得新的社团编号
                    String count="0";
                    try {
                        count = organizationDao.Organization_count(con);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    int cnt = Integer.parseInt(count) + 1 ;
                    String ono = Integer.toString(cnt);
                    //Organization,Member,用户权限更新
                    Date currentTime = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String date = formatter.format(currentTime);
                    Organization organization = new Organization(ono,temp.getAcont(),temp.getApno(),"","",date,"0","");
                    try {
                        organizationDao.Organization_insert(con,organization);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    Member member = new Member(ono,temp.getApno(),"社长",date);
                    try {
                        memberDao.Member_insert(con,member);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    update_rank(temp.getApno(),"3");
                }else if(temp.getAtype().equals("转让")){
                    String cont = temp.getAcont();
                    String[] content = cont.split(",");
                    String cid = content[0];
                    String transtopno = content[1];
                    try {
                        flag = organizationDao.Check(con,cid);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if(flag){
                        //Organization,Member,用户权限更新
                        Organization organization = new Organization(cid,"",transtopno,"","","","","");
                        try {
                            organizationDao.Organization_update(con,organization);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        Member member1 = new Member(cid,transtopno,"社长","");
                        Member member2 = new Member(cid,temp.getApno(),"成员","");
                        try {
                            memberDao.Member_update(con,member1);
                            memberDao.Member_update(con,member2);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        update_rank(transtopno,"3");
                        int urank=1;
                        try {
                            urank = memberDao.Personal_highest_rank(con,temp.getApno());
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        if(urank < 3){ //没有担任其他社团社长时降低权限
                            update_rank(temp.getApno(),Integer.toString(urank));
                        }
                    }else{
                        JOptionPane.showMessageDialog(pass,"The club does not exist!","error",0);
                    }
                }else if(temp.getAtype().equals("解散")){
                    //Organization,Member,用户权限更新
                    try {
                        memberDao.Member_delete_by_club(con,temp.getAcont());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        organizationDao.Organization_delete(con,temp.getAcont());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    int urank=1;
                    try {
                        urank = memberDao.Personal_highest_rank(con,temp.getApno());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if(urank < 3){ //没有担任其他社团社长时降低权限
                        update_rank(temp.getApno(),Integer.toString(urank));
                    }
                }else if(temp.getAtype().equals("加入")){
                    //Organization,Member
                    Date currentTime = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String date = formatter.format(currentTime);
                    Member member = new Member(temp.getAcont(),temp.getApno(),"成员",date);
                    try {
                        memberDao.Member_insert(con,member);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }else if(temp.getAtype().equals("退出")){
                    //Organization,Member
                    Member member = new Member(temp.getAcont(),temp.getApno(),"","");
                    try {
                        memberDao.Member_delete(con,member);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                if(flag){
                    //更新apply
                    try {
                        applyDao.Apply_update(con,temp.getAno());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                //提交完成后转为查看模式
                type = "查看";
                try {
                    initView();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplyDao applyDao = new ApplyDao();
                if(type.equals("创建")){
                    OrganizationDao organizationDao = new OrganizationDao();
                    //检查是否有重名
                    String oname = Acont.getText();
                    if(oname.isEmpty()||oname.length()>20){
                        JOptionPane.showMessageDialog(submit,"Name invalid! No empty and no longer than 20!","error",0);
                    }else{
                        boolean flag = false;
                        try {
                            flag = organizationDao.Organization_check(con,oname);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        if(flag){
                            int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                            if(input == 0){
                                //插入申请记录
                                temp.setAcont(oname);
                                try {
                                    applyDao.Apply_insert(con,temp);
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                //更新视图
                                type = "查看";
                                applyid = temp.getAno();
                                try {
                                    initView();
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(submit,"The name has been registered!","error",0);
                        }
                    }
                }else if(type.equals("转让")){
                    String cid = temp.getAcont();//对应社团编号
                    String transtopno = Acont.getText();//转让给的成员学号
                    if(transtopno.equals(temp.getApno())){
                        JOptionPane.showMessageDialog(submit,"The member should not be yourself!","error",0);
                    }else{
                        //检查要转让的成员是否存在
                        MemberDao memberDao = new MemberDao();
                        boolean flag = false;
                        try {
                            flag = memberDao.Member_check(con,cid,transtopno);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        if(flag){
                            int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                            if(input == 0){
                                String cont = cid + "," + transtopno;
                                temp.setAcont(cont);
                                try {
                                    applyDao.Apply_insert(con,temp);
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                                //更新视图
                                type = "查看";
                                applyid = temp.getAno();
                                try {
                                    initView();
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(submit,"The member not exsit!","error",0);
                        }
                    }

                }else { //加入、退出、解散
                    int input = JOptionPane.showConfirmDialog(submit,"Are you sure to submit?","submit notice",1,2);
                    if(input == 0){
                        try {
                            applyDao.Apply_insert(con,temp);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        //更新视图
                        type = "查看";
                        applyid = temp.getAno();
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
                //跳转回上个界面
                String fromewhere = route.pop();
                if(fromewhere.equals("MainPage")){
                    try {
                        MainPage mainPage = new MainPage(con,Integer.toString(rank),usrname);
                        mainPage.setVisible(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }else if(fromewhere.equals("ApplyList")){
                    try {
                        ApplyList applyList = new ApplyList(con,rank,usrname,usrpno,origin_type,route);
                        applyList.setVisible(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }else if(fromewhere.equals("ClubInfo")){
                    try {
                        ClubInfo clubInfo = new ClubInfo(con,rank,usrname,usrpno,clubid,route);
                        clubInfo.setVisible(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                dispose();
            }
        });
    }

    private void update_rank(String pno,String urank){
        PersonDao personDao = new PersonDao();
        String uname="";
        try {
            uname = personDao.Person_username(con,pno);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        UsrDao usrDao = new UsrDao();
        try {
            usrDao.user_update(con,uname,urank);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel title;
    private JLabel ano;
    private JLabel atype;
    private JLabel acont;
    private JLabel apno;
    private JTextField Apno;
    private JLabel adate;
    private JTextField Adate;
    private JButton back;
    private JButton submit;
    private JTextField Ano;
    private JButton pass;
    private JLabel apass;
    private JTextField Atype;
    private JTextField Apass;
    private JTextField Acont;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Connection con;
    private int rank;
    private String usrname;
    private String type;
    private String origin_type;
    private String usrpno;
    private String applyid;
    private String clubid;
    private com.entity.Apply temp;
    private Stack<String> route;
}
