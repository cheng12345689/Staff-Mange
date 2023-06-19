package bwc04.view;


import bwc04.tools.color.Colour;
import bwc04.tools.font.Fonts;
import bwc04.tools.image.Images;
import jdk.nashorn.internal.scripts.JO;
import kevin.com.SalaryGradeAdmin;
import kevin.com.SalaryGradeSale;
import kevin.com.SalaryGradeSet;
import kevin.com.SalaryGradeTechnology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static bwc04.tools.font.Fonts.button;
import static bwc04.tools.font.Fonts.pane;
import static java.lang.Thread.sleep;

/**
 * 仪表盘信息
 * @author KSaMar
 * @version 1.0
 */
public class HomeView extends JPanel {

    public static int flag = 0;
    private int borrowCount = 0;
    private int overtimeCount = 0;

    /**
     * 文字
     */
    private String bookText = "新增工资等级";
    private String borrowText = "修改工资等级";
    private String overtimeText = "删除工资等级";
    private String timeText = "查找工资等级";


    /**
     * 面板
     */
    private JPanel bookPanel = new JPanel();
    private JPanel borrowPanel = new JPanel();
    private JPanel overtimePanel = new JPanel();
    private JPanel timePanel = new JPanel();

    /**
     * 标签
     */

    private JLabel bookTextLabel = new JLabel();
    private JLabel bookCountLabel = new JLabel();
    private JLabel borrowTextLabel = new JLabel();
    private JLabel borrowCountLabel = new JLabel();
    private JLabel overtimeTextLabel = new JLabel();
    private JLabel overtimeCountLabel = new JLabel();
    private JLabel timeTextLabel = new JLabel();
    private JLabel timeValueLabel = new JLabel();

    private SalaryGradeSet salaryGradeSet;
    private String info;

    /**
     * 仪表盘窗体
     */
    public HomeView() {

        // 初始化
        init();


        //新增工资等级按钮图标
        JButton buttonAdd = new JButton();
        buttonAdd.setIcon(Images.bookIcon);
        buttonAdd.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonAdd.setContentAreaFilled(false); //把按钮设置为透明
        buttonAdd.setBounds(19,25,200,188); // 16 36 128 128


        //新增工资等级文本标签
        bookTextLabel.setText(bookText);
        bookTextLabel.setBounds(144, 56, 274, 40);
        bookTextLabel.setFont(Fonts.pane);
        bookTextLabel.setForeground(Color.WHITE);
        bookTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //新增工资等级标签
        bookCountLabel.setBounds(144, 108, 274, 40);
        bookCountLabel.setFont(Fonts.pane);
        bookCountLabel.setForeground(Color.WHITE);
        bookCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //新增工资等级面板
        bookPanel.setLayout(null);
        bookPanel.setBounds(16, 16, 456, 200);
        bookPanel.setBackground(Colour.C3C8CE7);
        bookPanel.add(buttonAdd);
        //bookPanel.add(bookIconLabel);
        bookPanel.add(bookTextLabel);
        bookPanel.add(bookCountLabel);

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement add action
              // JOptionPane.showMessageDialog(bookPanel, "点击了新增员工等级按钮！");
                new SelectWork();

            }
        });

        //修改工资等级按钮图标
        JButton buttonChange = new JButton();
        buttonChange.setIcon(Images.borrowPaneIcon);
        buttonChange.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonChange.setContentAreaFilled(false); //把按钮设置为透明
        buttonChange.setBounds(488,25,200,188); // 16 36 128 128

        //修改工资等级标签
        borrowTextLabel.setText(borrowText);
        borrowTextLabel.setBounds(144, 56, 274, 40);
        borrowTextLabel.setFont(Fonts.pane);
        borrowTextLabel.setForeground(Color.WHITE);
        borrowTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //修改工资等级标签
        borrowCountLabel.setBounds(144, 108, 274, 40);
        borrowCountLabel.setFont(Fonts.pane);
        borrowCountLabel.setForeground(Color.WHITE);
        borrowCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //修改工资等级面板
        borrowPanel.setLayout(null);
        borrowPanel.setBounds(488, 16, 456, 200);
        borrowPanel.setBackground(Colour.C5AB556);
        borrowPanel.add(buttonChange);

        borrowPanel.add(borrowTextLabel);
        borrowPanel.add(borrowCountLabel);

        buttonChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement modify action
               // JOptionPane.showMessageDialog(borrowPanel, "点击了修改员工等级按钮！");
                new InputDemo1();  //修改按钮
            }
        });

        // 删除工资等级按钮图标
        JButton buttonDelete = new JButton();
        buttonDelete.setIcon(Images.overtimePaneIcon);
        buttonDelete.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonDelete.setContentAreaFilled(false); //把按钮设置为透明
        buttonDelete.setBounds(3,7,201,190); // 16 36 128 128



        // 删除工资等级文本标签
        overtimeTextLabel.setText(overtimeText);
        overtimeTextLabel.setBounds(144, 56, 274, 40);
        overtimeTextLabel.setFont(Fonts.pane);
        overtimeTextLabel.setForeground(Color.WHITE);
        overtimeTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        // 删除工资等级标签
        overtimeCountLabel.setBounds(144, 108, 274, 40);
        overtimeCountLabel.setFont(Fonts.pane);
        overtimeCountLabel.setForeground(Color.WHITE);
        overtimeCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        // 删除工资等级面板
        overtimePanel.setLayout(null);
        overtimePanel.setBounds(16, 232, 456, 200);
        overtimePanel.setBackground(Colour.CE54D52);
        overtimePanel.add(buttonDelete);
        overtimePanel.add(overtimeTextLabel);
        overtimePanel.add(overtimeCountLabel);

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement delete action
               // JOptionPane.showMessageDialog(overtimePanel, "点击了删除按钮");
                new DeleteSalaryGrade();
            }
        });

        //查找工资等级图标
        JButton buttonQuery = new JButton();
        buttonQuery.setIcon(Images.timePaneIcon);
        buttonQuery.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonQuery.setContentAreaFilled(false); //把按钮设置为透明
        buttonQuery.setBounds(488,238,201,190); // 16 36 128 128


        //查找工资等级文本标签
        timeTextLabel.setText(timeText);
        timeTextLabel.setBounds(144, 56, 274, 40);
        timeTextLabel.setFont(Fonts.pane);
        timeTextLabel.setForeground(Color.WHITE);
        timeTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //查找工资等级标签
        timeValueLabel.setBounds(144, 108, 274, 40);
        timeValueLabel.setFont(Fonts.time);
        timeValueLabel.setForeground(Color.WHITE);
        timeValueLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //查找工资等级面板
        timePanel.setLayout(null);
        timePanel.setBounds(488, 232, 456, 200);
        timePanel.setBackground(Colour.CFAA64B);
        timePanel.add(buttonQuery);
        timePanel.add(timeTextLabel);
        timePanel.add(timeValueLabel);

        buttonQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement search action
               // JOptionPane.showMessageDialog(timePanel, "点击了查询按钮");
                new QuerySelect();

            }
        });
        setLayout(null);
        // 添加组件
       add(buttonAdd);
       add(buttonChange);
       add(buttonQuery);
        add(bookPanel);
        add(borrowPanel);
        add(overtimePanel);
        add(timePanel);


        // 窗体设置
        setSize(960, 768);

        setBackground(Color.WHITE);
        setVisible(true);
    }

    /**
     * 初始化
     */
    public void init() {
        salaryGradeSet = new SalaryGradeSet();
    }
    //修改
    public class InputDemo1 extends JFrame {
        ModifyEmployeeLevelAdmin editformadmin;
        ModifyEmployeeLevelTech editformtech;
        ModifyEmployeeLevelSale editformsale;
        public InputDemo1() {
            JLabel positionlabel = new JLabel("请选择部门");
            JComboBox<String> postCombox = new JComboBox(new String[]{"技术部","行政部","销售部"});
            JLabel gradelabel = new JLabel("请选择等级");
            JComboBox<String> gradeCombox = new JComboBox<>(new String[]{"一级","二级","三级"});
            JButton button = new JButton("确认");
            JPanel panel = new HomePanel2();  //
            panel.add(positionlabel);
            panel.add(postCombox);
            panel.add(gradelabel);
            panel.add(gradeCombox);
            panel.add(button);
            getContentPane().add(panel);
            setTitle("工号");
            setSize(300, 200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String grade = (String)gradeCombox.getSelectedItem();
                    String position = (String)postCombox.getSelectedItem();
                    // 检查输入是否为空
                    if (grade.isEmpty()||position.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "岗位等级不能为空");
                    } else if (position.equals("行政部")&&salaryGradeSet.HasGradeAdmin(grade)) {
                        dispose(); // 关闭窗体
                       editformadmin =  new ModifyEmployeeLevelAdmin();
                      editformadmin.setConfirmButtonlisener(new ActionListener() {
                          @Override
                          public void actionPerformed(ActionEvent e) {
                              String grade = (String)gradeCombox.getSelectedItem();
                              String position = (String)postCombox.getSelectedItem();
                              String basicsalary = editformadmin.getbasicsalary();
                              String positionsalary = editformadmin.getpositionsalary();
                              String trafficsuside = editformadmin.gettraficSubsidy();
                              String performancereward = (editformadmin.getperpormancereward());
                              modifyadmin(grade,"basicsalary",basicsalary);
                              modifyadmin(grade,"positionsalary",positionsalary);
                              modifyadmin(grade,"transformsalary",trafficsuside);
                              modifyadmin(grade,"performancereward",performancereward);

                          }
                      });
                      editformadmin.setCancelButtonLisener(new ActionListener() {
                          @Override
                          public void actionPerformed(ActionEvent e) {
                             editformadmin.dispose();
                          }
                      });
                    }else if(position.equals("技术部")&&salaryGradeSet.HasGradeTech(grade)){
                        dispose(); // 关闭窗体
                        editformtech =  new ModifyEmployeeLevelTech();
                        editformtech.setConfirmButtonlisener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String grade = (String)gradeCombox.getSelectedItem();
                                String position = (String)postCombox.getSelectedItem();
                                String basicsalary = editformtech.getbasicsalary();
                                String positionsalary = editformtech.getpositionsalary();
                                String trafficsuside = editformtech.gettraficSubsidy();
                                String workoversalary = (editformtech.getoverworksalary());
                                modifytech(grade,"basicsalary",basicsalary);
                                modifytech(grade,"positionsalary",positionsalary);
                                modifytech(grade,"transformsalary",trafficsuside);
                                modifytech(grade,"workoversalary",workoversalary);

                            }
                        });
                        editformtech.setCancelButtonLisener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                editformtech.dispose();
                            }
                        });

                    }else if(position.equals("销售部")&&salaryGradeSet.HasGradeSale(grade)){
                        dispose(); // 关闭窗体
                        editformsale =  new ModifyEmployeeLevelSale();
                        editformsale.setConfirmButtonlisener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String grade = (String)gradeCombox.getSelectedItem();
                                String position = (String)postCombox.getSelectedItem();
                                String basicsalary = editformsale.getbasicsalary();
                                String positionsalary = editformsale.getpositionsalary();
                                String trafficsuside = editformsale.gettraficSubsidy();
                                String floatreward = (editformsale.getfloatreward());
                                String salereward = (editformsale.getsalareward());
                                modifysale(grade,"basicsalary",basicsalary);
                                modifysale(grade,"positionsalary",positionsalary);
                                modifysale(grade,"transformsalary",trafficsuside);
                                modifysale(grade,"floatreward",floatreward);
                                modifysale(grade,"salereward",salereward);

                            }
                        });
                        editformtech.setCancelButtonLisener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               editformsale.dispose();
                            }
                        });
                    }

                    else {
                        JOptionPane.showMessageDialog(null, position+"未添加"+grade );
                    }
                }
            });
        }

        public void modifyadmin(String grade,String key,String value){
            if(!value.isEmpty()){
                double value_dou = Double.parseDouble(value);
               int count= salaryGradeSet.AdminSalaryEdit(grade,key,value_dou);
               if(count!=0)
               JOptionPane.showMessageDialog(editformadmin,grade+key+"修改成功");
               else  JOptionPane.showMessageDialog(editformadmin,"未修改任何行");
            }

        }

        public void modifytech(String grade,String key,String value){
            if(!value.isEmpty()){
                double value_dou = Double.parseDouble(value);
                int count= salaryGradeSet.TechnologySalaryEdit(grade,key,value_dou);
                if(count!=0)
                JOptionPane.showMessageDialog(editformtech,grade+key+"修改成功");
                else JOptionPane.showMessageDialog(editformtech,"未修改任何行");
            }
        }

        public void modifysale(String grade,String key,String value){
            if(!value.isEmpty()){
                double value_dou = Double.parseDouble(value);
                int count= salaryGradeSet.SaleSalaryEdit(grade,key,value_dou);
                if(count!=0)
                    JOptionPane.showMessageDialog(editformsale,grade+key+"修改成功");
                else JOptionPane.showMessageDialog(editformsale,"未修改任何行");
            }
        }
    }
    //删除
    public class DeleteSalaryGrade extends JFrame {
        public DeleteSalaryGrade() {
            JLabel positionlabel = new JLabel("请选择部门:");
            JComboBox<String> postCombox = new JComboBox<>(new String[]{"技术部","行政部","销售部"});
            JLabel gradelabel = new JLabel("请选择你要删除的等级");
            JComboBox<String> gardecombox= new JComboBox<>(new String[]{"一级","二级","三级"});
            JButton button = new JButton("确认");
            JPanel panel = new HomePanel2(); //
            panel.add(positionlabel);
            panel.add(postCombox);
            panel.add(gradelabel);
            panel.add(gardecombox);
            panel.add(button);
            getContentPane().add(panel);
            setTitle("选择");
            setSize(250, 201);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String position =(String)postCombox.getSelectedItem();
                    String grade = (String)gardecombox.getSelectedItem();
                    // 检查输入是否为空
                    if (position.isEmpty()||grade.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "部门和等级为必选字段");
                    } else if (position.equals("行政部")&&salaryGradeSet.HasGradeAdmin(grade)) {
                        dispose(); // 关闭窗体
                      int count=  salaryGradeSet.Delete_Admin(grade);
                      if(count!=0)JOptionPane.showMessageDialog(null,"删除成功");
                      else JOptionPane.showMessageDialog(null,"未删除任何行");
                    }else if(position.equals("技术部")&&salaryGradeSet.HasGradeTech(grade)){
                        dispose();
                       int count= salaryGradeSet.Delete_Tech(grade);
                       if(count!=0)JOptionPane.showMessageDialog(null,"删除成功");
                       else JOptionPane.showMessageDialog(null,"未删除任何行");
                    }else if(position.equals("销售部")&&salaryGradeSet.HasGradeSale(grade)){
                        dispose();
                       int count= salaryGradeSet.Delete_Sale(grade);
                        if(count!=0)JOptionPane.showMessageDialog(null,"删除成功");
                        else JOptionPane.showMessageDialog(null,"删除失败");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, position+"没有" + grade);
                    }
                }
            });

        }
    }
    //查询
    public class QuerySelect extends JFrame{
        private JLabel positioninfo;
        private JLabel gradeinfo;
        private JComboBox<String> selectposition;
        private JComboBox<String> selectgrade;
        private JButton confirmbutton;
        private JPanel panel;

        public QuerySelect(){
            positioninfo = new JLabel("选择岗位");
            gradeinfo = new JLabel("选择工资等级");
            selectgrade = new JComboBox<>(new String[]{"一级", "二级", "三级", "四级", "五级"});
            selectposition = new JComboBox<>(new String[]{"行政部","技术部","销售部"});
            confirmbutton = new JButton("确认");
            JFrame jf = new JFrame("选择工种");
            jf.setSize(420,270);
            jf.setLocation(800,400);
            panel = new JPanel();
            panel.setLayout(new GridLayout(3,2));
            jf.add(panel, BorderLayout.CENTER);
            panel.add(positioninfo);
            panel.add(selectposition);
            panel.add(gradeinfo);
            panel.add(selectgrade);
            panel.add(confirmbutton);

            //对按钮进行监听
            confirmbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String position =(String)selectposition.getSelectedItem();
                    String grade = (String)selectgrade.getSelectedItem();
                    if(position.isEmpty()||grade.isEmpty()){
                        JOptionPane.showMessageDialog(null,"岗位，等级为必选字段");
                    }else if(position.equals("行政部")&&salaryGradeSet.HasGradeAdmin(grade)){
                        //展示
                       Object[] data= salaryGradeSet.AdminSalaryQuery(grade);
                       new QueryTable(data,"行政部工资等级查询");
                    }else if(position.equals("技术部")&&salaryGradeSet.HasGradeTech(grade)){
                        Object[] data = salaryGradeSet.TechnologySalaryQuery(grade);
                        new QueryTable(data,"技术部工资等级查询");

                    }else if(position.equals("销售部")&&salaryGradeSet.HasGradeSale(grade)){
                        Object[] data = salaryGradeSet.SaleSalaryQuery(grade);
                        new QueryTable(data,"销售部工资等级查询");

                    }
                    else JOptionPane.showMessageDialog(null,position+"不存在"+grade);
                }
            });
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setVisible(true);
        }


    }

    public class InputDemo3 extends JFrame {
        public InputDemo3() {
            JLabel label = new JLabel("请输入工号:");
            JTextField textField = new JTextField(20);
            JButton button = new JButton("确认");
            JPanel panel = new HomePanel2(); //
            panel.add(label);
            panel.add(textField);
            panel.add(button);
            getContentPane().add(panel);
            setTitle("工号");
            setSize(300, 200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String input = textField.getText().trim();
                    System.out.println("你输入的工号为"+input);
                    // 检查输入是否为空
                    if (input.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "工号不能为空");
                    } else if (input.equals("1")) {
                        dispose(); // 关闭窗体
                        new SearchEmployeeLevelGUI1();
                    } else {
                        JOptionPane.showMessageDialog(null, "不存在工号为：" + input);
                    }
                }
            });

        }
    }
    //选择工种类型
    public class SelectWork extends JFrame {
        JButton technology = new JButton("技术人员");
        JButton administrative = new JButton("行政人员");
        JButton saleMan = new JButton("销售人员");
        public SelectWork(){
            JFrame jf = new JFrame("选择工种");
            jf.setSize(400,350);
            jf.setLocation(800,400);
            JPanel panel = new HomePanel();

            jf.add(panel,BorderLayout.CENTER);
            panel.add(technology, BorderLayout.CENTER);
            panel.add(administrative,BorderLayout.CENTER);
            panel.add(saleMan,BorderLayout.CENTER);
            //对技术人员按钮进行监听
            technology.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddEmployeeLevelGUI1();//技术人员
                    jf.dispose();
                }
            });
            administrative.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddEmployeeLevelGUI2();
                    jf.dispose();
                }
            });
            saleMan.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddEmployeeLevelGUI3();
                    jf.dispose();
                }
            });
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setVisible(true);
        }
    }
    //给嵌体加背景图片
    class HomePanel extends JPanel {
        ImageIcon icon;
        Image img;
        public HomePanel() {
            //  /img/HomeImg.jpg 是存放在你正在编写的项目的bin文件夹下的img文件夹下的一个图片
            icon=new ImageIcon(getClass().getResource("/bwc04/images/6.jpg"));
            img=icon.getImage();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
            g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
        }

    }
    class HomePanel2 extends JPanel {
        ImageIcon icon;
        Image img;
        public HomePanel2() {
            //  /img/HomeImg.jpg 是存放在你正在编写的项目的bin文件夹下的img文件夹下的一个图片
            icon=new ImageIcon(getClass().getResource("/bwc04/images/2.png"));
            img=icon.getImage();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
            g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
        }

    }
    //技术人员
    public class AddEmployeeLevelGUI1 {

        private JFrame frame;
        private JLabel titleLabel, levelLabel, basicSalaryLabel, positionSalaryLabel, trafficSubsidyLabel,overWorkLabel;
        private JComboBox<String> levelComboBox;
        private JTextField basicSalaryField, positionSalaryField, trafficSubsidyField,overWorkField;
        private JButton confirmButton, cancelButton;

        public AddEmployeeLevelGUI1() {

            // Create the main frame
            frame = new JFrame("新增技术员工等级");
            frame.setSize(450, 350);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Create the title label
            titleLabel = new JLabel("新增技术员工等级", SwingConstants.CENTER);
            titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 35));

            // Create the level label and combo box
            levelLabel = new JLabel("工资等级：");
            levelLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            String[] levels = {"一级", "二级", "三级", "四级", "五级"};
            levelComboBox = new JComboBox<>(levels);

            // Create the basic salary label and text field
            basicSalaryLabel = new JLabel("基本工资：");
            basicSalaryLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            basicSalaryField = new JTextField("", 15);

            // Create the position salary label and text field
            positionSalaryLabel = new JLabel("岗位工资：");
            positionSalaryLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            positionSalaryField = new JTextField("", 15);

            // Create the traffic subsidy label and text field
            trafficSubsidyLabel = new JLabel("交通补贴：");
            trafficSubsidyLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            trafficSubsidyField = new JTextField("", 15);

            //加班费
            overWorkLabel = new JLabel("技术人员加班费：");
            overWorkLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            overWorkField = new JTextField("",15);

            // 对确认的监听
            confirmButton = new JButton("确认");
            confirmButton.setBounds(20,20,20,20);
            confirmButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement add action
                    String level = (String)levelComboBox.getSelectedItem();
                    double basicSalary = Double.parseDouble(basicSalaryField.getText());
                    double positionSalary =Double.parseDouble( positionSalaryField.getText());
                    double trafficSubsidy =Double.parseDouble(trafficSubsidyField.getText());
                    double overWorkSalary = Double.parseDouble(overWorkField.getText());
                    if(salaryGradeSet.HasGradeTech(level)){
                        JOptionPane.showMessageDialog(null,"技术部已存在"+level);
                    }
                    else {
                        SalaryGradeTechnology salaryGradeTechnology = new SalaryGradeTechnology(level, basicSalary, positionSalary, trafficSubsidy, "技术部", overWorkSalary);
                        int count = salaryGradeSet.TechnologySalaryAdd(salaryGradeTechnology);
                        String info;
                        if (count != 0) info = "添加成功";
                        else info = "添加失败";
                        JOptionPane.showMessageDialog(frame, info);
                        frame.dispose();
                    }
                }
            });
            cancelButton = new JButton("取消");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Close the add employee level window
                    frame.dispose(); //关闭当前窗口
                }
            });

            // Create the input panel and add components
            JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10)); //5 2 5 5
            inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
            inputPanel.add(levelLabel);
            inputPanel.add(levelComboBox);
            inputPanel.add(basicSalaryLabel);
            inputPanel.add(basicSalaryField);
            inputPanel.add(positionSalaryLabel);
            inputPanel.add(positionSalaryField);
            inputPanel.add(trafficSubsidyLabel);
            inputPanel.add(trafficSubsidyField);
            inputPanel.add(overWorkLabel);
            inputPanel.add(overWorkField);
            inputPanel.add(confirmButton);
            inputPanel.add(cancelButton);

            // Create the content panel and add components
            JPanel contentPanel = new JPanel(new BorderLayout());
            contentPanel.add(titleLabel, BorderLayout.NORTH);
            contentPanel.add(inputPanel, BorderLayout.CENTER);

            // Add the content panel to the frame
            frame.setContentPane(contentPanel);

            // Make the frame visible
            frame.setVisible(true);

        }

    }

    public void setinfo(int count){
        if(count!=0)this.info="操作成功";
        else this.info="操作失败";
    }


    //行政人员
    public class AddEmployeeLevelGUI2 {

        private JFrame frame;
        private JLabel titleLabel, levelLabel, basicSalaryLabel, positionSalaryLabel, trafficSubsidyLabel,performanceLabel;
        private JComboBox<String> levelComboBox;
        private JTextField basicSalaryField, positionSalaryField, trafficSubsidyField,performanceField;
        private JButton confirmButton, cancelButton;

        public AddEmployeeLevelGUI2() {

            // Create the main frame
            frame = new JFrame("新增行政员工等级");
            frame.setSize(450, 350);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Create the title label
            titleLabel = new JLabel("新增行政员工等级", SwingConstants.CENTER);
            titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 35));

            // Create the level label and combo box
            levelLabel = new JLabel("工资等级：");
            levelLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            String[] levels = {"一级", "二级", "三级", "四级", "五级"};
            levelComboBox = new JComboBox<>(levels);

            // Create the basic salary label and text field
            basicSalaryLabel = new JLabel("基本工资：");
            basicSalaryLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            basicSalaryField = new JTextField("", 15);

            // Create the position salary label and text field
            positionSalaryLabel = new JLabel("岗位工资：");
            positionSalaryLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            positionSalaryField = new JTextField("", 15);

            // Create the traffic subsidy label and text field
            trafficSubsidyLabel = new JLabel("交通补贴：");
            trafficSubsidyLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            trafficSubsidyField = new JTextField("", 15);

            //绩效奖金
            performanceLabel = new JLabel("行政人员绩效费：");
            performanceLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            performanceField = new JTextField("",15);

            // 对确认的监听
            confirmButton = new JButton("确认");
            confirmButton.setBounds(20,20,20,20);
            confirmButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement add action
                    String level = (String)levelComboBox.getSelectedItem();
                    double basicSalary = Double.parseDouble(  basicSalaryField.getText());
                    double positionSalary =Double.parseDouble(positionSalaryField.getText());
                    double trafficSubsidy = Double.parseDouble(trafficSubsidyField.getText());
                    double performancereward = Double.parseDouble(performanceField.getText());
                    if(salaryGradeSet.HasGradeAdmin(level)){
                        JOptionPane.showMessageDialog(null,"行政部已存在"+level);
                    }
                    else {
                        SalaryGradeAdmin salaryGradeAdmin = new SalaryGradeAdmin(level, basicSalary, positionSalary, trafficSubsidy, "行政部", performancereward);
                        int count = salaryGradeSet.AdminSalaryAdd(salaryGradeAdmin);
                        String info;
                        if (count != 0) info = "操作成功";
                        else info = "操作失败";
                        JOptionPane.showMessageDialog(frame, "新增行政人员工资等" + info);
                        frame.dispose();
                    }
                }
            });
            cancelButton = new JButton("取消");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Close the add employee level window
                    frame.dispose(); //关闭当前窗口
                }
            });

            // Create the input panel and add components
            JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10)); //5 2 5 5
            inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
            inputPanel.add(levelLabel);
            inputPanel.add(levelComboBox);
            inputPanel.add(basicSalaryLabel);
            inputPanel.add(basicSalaryField);
            inputPanel.add(positionSalaryLabel);
            inputPanel.add(positionSalaryField);
            inputPanel.add(trafficSubsidyLabel);
            inputPanel.add(trafficSubsidyField);
            inputPanel.add(performanceLabel);
            inputPanel.add(performanceField);
            inputPanel.add(confirmButton);
            inputPanel.add(cancelButton);

            // Create the content panel and add components
            JPanel contentPanel = new JPanel(new BorderLayout());
            contentPanel.add(titleLabel, BorderLayout.NORTH);
            contentPanel.add(inputPanel, BorderLayout.CENTER);

            // Add the content panel to the frame
            frame.setContentPane(contentPanel);

            // Make the frame visible
            frame.setVisible(true);

        }

    }
    //销售人员
    public class AddEmployeeLevelGUI3 {

        private JFrame frame;
        private JLabel titleLabel, levelLabel, basicSalaryLabel, positionSalaryLabel, trafficSubsidyLabel,floatLabel,saleLabel;
        private JComboBox<String> levelComboBox;
        private JTextField basicSalaryField, positionSalaryField, trafficSubsidyField,floatField,saleField;
        private JButton confirmButton, cancelButton;

        public AddEmployeeLevelGUI3() {

            // Create the main frame
            frame = new JFrame("新增销售人员员工等级");
            frame.setSize(460, 370);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Create the title label
            titleLabel = new JLabel("新增销售员工等级", SwingConstants.CENTER);
            titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 32));

            // Create the level label and combo box
            levelLabel = new JLabel("工资等级：");
            levelLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
            String[] levels = {"一级", "二级", "三级", "四级", "五级"};
            levelComboBox = new JComboBox<>(levels);

            // Create the basic salary label and text field
            basicSalaryLabel = new JLabel("基本工资：");
            basicSalaryLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
            basicSalaryField = new JTextField("", 15);

            // Create the position salary label and text field
            positionSalaryLabel = new JLabel("岗位工资：");
            positionSalaryLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
            positionSalaryField = new JTextField("", 15);

            // Create the traffic subsidy label and text field
            trafficSubsidyLabel = new JLabel("交通补贴：");
            trafficSubsidyLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
            trafficSubsidyField = new JTextField("", 15);

            //浮动奖金float
            floatLabel = new JLabel("销售人员浮动奖金：");
            floatLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
            floatField = new JTextField("",15);
            //销售奖金sale
            saleLabel = new JLabel("销售人员销售奖金：");
            saleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
            saleField = new JTextField("",15);

            // 对确认的监听
            confirmButton = new JButton("确认");
            confirmButton.setBounds(20,20,20,20);
            confirmButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement add action
                    String level = (String)levelComboBox.getSelectedItem();
                    double basicSalary = Double.parseDouble(basicSalaryField.getText());
                    double positionSalary = Double.parseDouble( positionSalaryField.getText());
                    double trafficSubsidy = Double.parseDouble(trafficSubsidyField.getText());
                    double floatSalary = Double.parseDouble( floatField.getText());
                    double saleSalary = Double.parseDouble( saleField.getText());
                    if(salaryGradeSet.HasGradeSale(level)){
                        JOptionPane.showMessageDialog(null,"销售部已存在"+level);
                    }
                    else {
                        SalaryGradeSale salaryGradeSale = new SalaryGradeSale(level, basicSalary, positionSalary, trafficSubsidy, "销售部", floatSalary, saleSalary);
                        int count = salaryGradeSet.SaleSalaryAdd(salaryGradeSale);
                        if (count != 0) JOptionPane.showMessageDialog(frame, "新增销售人员工资等级成功！");
                        else JOptionPane.showMessageDialog(frame, "新增销售人员工资等级失败！");

                        frame.dispose();
                    }
                }
            });
            cancelButton = new JButton("取消");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Close the add employee level window
                    frame.dispose(); //关闭当前窗口
                }
            });

            // Create the input panel and add components
            JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10)); //5 2 5 5
            inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
            inputPanel.add(levelLabel);
            inputPanel.add(levelComboBox);
            inputPanel.add(basicSalaryLabel);
            inputPanel.add(basicSalaryField);
            inputPanel.add(positionSalaryLabel);
            inputPanel.add(positionSalaryField);
            inputPanel.add(trafficSubsidyLabel);
            inputPanel.add(trafficSubsidyField);
            inputPanel.add(floatLabel);
            inputPanel.add(floatField);
            inputPanel.add(saleLabel);
            inputPanel.add(saleField);
            inputPanel.add(confirmButton);
            inputPanel.add(cancelButton);

            // Create the content panel and add components
            JPanel contentPanel = new JPanel(new BorderLayout());
            contentPanel.add(titleLabel, BorderLayout.NORTH);
            contentPanel.add(inputPanel, BorderLayout.CENTER);

            // Add the content panel to the frame
            frame.setContentPane(contentPanel);

            // Make the frame visible
            frame.setVisible(true);

        }

    }

    public class ModifyEmployeeLevelAdmin extends FartherGradeForm{

        private JLabel performanceSubsidyLabel;

        private JTextField performanceSubsidyField;
        public ModifyEmployeeLevelAdmin() {
            super("修改行政工资等级");

            // Create the main frame
            super.setLocation(800,400);
            super.setSize(400,400);

            performanceSubsidyLabel = new JLabel("效绩奖励：");
            performanceSubsidyLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            performanceSubsidyField = new JTextField("", 15);

            super.inputPanel.add(performanceSubsidyLabel);
            super.inputPanel.add(performanceSubsidyField);
            super.addbutton();

            // Create the content panel and add components
            JPanel contentPanel = new JPanel(new BorderLayout());
          //  contentPanel.add(titleLabel, BorderLayout.NORTH);
            contentPanel.add(inputPanel, BorderLayout.CENTER);

            // Add the content panel to the frame
            this.setContentPane(contentPanel);

            // Make the frame visible
            this.setVisible(true);

        }

        public String getperpormancereward(){
            return this.performanceSubsidyField.getText();
        }

    }

    public class ModifyEmployeeLevelTech extends FartherGradeForm{

        private JLabel overworkLabel;

        private JTextField overworkField;
        public ModifyEmployeeLevelTech() {
            super("修改技术人员工资等级");

            // Create the main frame
           super.setLocation(800,400);
            super.setSize(400,500);

            overworkLabel = new JLabel("加班费：");
            overworkLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            overworkField = new JTextField("", 15);

            super.inputPanel.add(overworkLabel);
            super.inputPanel.add(overworkField);
            super.addbutton();

            // Create the content panel and add components
            JPanel contentPanel = new JPanel(new BorderLayout());
          //  contentPanel.add(titleLabel, BorderLayout.NORTH);
            contentPanel.add(inputPanel, BorderLayout.CENTER);

            // Add the content panel to the frame
            this.setContentPane(contentPanel);

            // Make the frame visible
            this.setVisible(true);

        }

        public String getoverworksalary(){
            return this.overworkField.getText();
        }

    }

    public class ModifyEmployeeLevelSale extends FartherGradeForm{

        private JLabel floatrewardLabel;
        private JTextField floatrewardField;
        private JLabel salelableLabel;
        private JTextField salerewardField;
        public ModifyEmployeeLevelSale() {
            super("修改销售工资等级");

            super.setTitle("修改销售工资等级");
            super.setLocation(800,400);
            super.setSize(400,500);
            // Create the main frame


            floatrewardLabel = new JLabel("浮动奖金：");
            floatrewardLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            floatrewardField = new JTextField("", 15);

            salelableLabel = new JLabel("销售奖金");
            salelableLabel.setFont(new Font("微软雅黑",Font.BOLD,20));
            salerewardField = new JTextField("",15);

            super.inputPanel.add(floatrewardLabel);
            super.inputPanel.add(floatrewardField);
            super.inputPanel.add(salelableLabel);
            super.inputPanel.add(salerewardField);
            super.addbutton();

            // Create the content panel and add components
            JPanel contentPanel = new JPanel(new BorderLayout());
            //contentPanel.add(titleLabel, BorderLayout.NORTH);
            contentPanel.add(inputPanel, BorderLayout.CENTER);

            // Add the content panel to the frame
            this.setContentPane(contentPanel);

            // Make the frame visible
            this.setVisible(true);

        }

      public String getfloatreward(){
            return floatrewardField.getText();
      }

      public String getsalareward(){
            return salerewardField.getText();
      }

    }

    public class ConfirmDelete extends JFrame{
        private JLabel infolabel;
        private JButton confirmButton, cancelButton;
        private JPanel panel;
        public ConfirmDelete(){}
        public ConfirmDelete(String position,String grade) {
            infolabel = new JLabel("你确认删除"+position+"的"+grade+"吗?");
            confirmButton = new JButton("确认");
            cancelButton = new JButton("取消");
            panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(infolabel,BorderLayout.CENTER);
            panel.add(confirmButton,BorderLayout.SOUTH);
            panel.add(cancelButton,BorderLayout.SOUTH);
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (position){
                        case "行政部":
                            break;

                        case "技术部":
                            break;

                        case "销售部":
                            break;

                        default:
                            JOptionPane.showMessageDialog(null,"没有该部门");
                            break;
                    }
                }
            });
            this.add(panel);
            this.setSize(400,200);
            this.setLocation(600,300);
            this.setVisible(true);

        }


    }
    public class SearchEmployeeLevelGUI1 {

        private JFrame frame;
        private JLabel titleLabel;

        public SearchEmployeeLevelGUI1() {

            // Create the main frame
            frame = new JFrame("查找员工等级");
            frame.setSize(450, 350);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Create the title label
            titleLabel = new JLabel("这是查找员工等级窗口", SwingConstants.CENTER);

            // Add the title label to the frame
            frame.getContentPane().add(titleLabel, BorderLayout.CENTER);

            // Make the frame visible
            frame.setVisible(true);

        }

    }

}

