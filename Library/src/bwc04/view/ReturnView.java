package bwc04.view;


import bwc04.tools.color.Colour;
import bwc04.tools.font.Fonts;
import bwc04.tools.image.Images;
import javafx.scene.layout.GridPane;
import kevin.com.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static bwc04.tools.font.Fonts.button;
import static java.lang.Thread.sleep;

/**
 * 仪表盘信息
 * @author KSaMar
 * @version 1.0
 */
public class ReturnView extends JPanel {

    private int bookCount = 0;
    private int borrowCount = 0;
    private int overtimeCount = 0;
    private StaffSet staffSet;
    private SalaryChangeSet salaryChangeSet;
    private SalaryGradeSet salaryGradeSet;
    private TotalSalarySet totalSalarySet;

    /**
     * 文字
     */
    private String bookText = "查看工资等级";
    private String borrowText = "查看员工信息";
    private String overtimeText = "查看工资变动";
    private String timeText = "汇总查询";
    private String generateText ="生成汇总信息";


    /**
     * 面板
     */
    private JPanel bookPanel = new JPanel();
    private JPanel borrowPanel = new JPanel();
    private JPanel overtimePanel = new JPanel();
    private JPanel timePanel = new JPanel();
    private JPanel GeneratePanel = new JPanel();

    /**
     * 标签
     */
    private JLabel bookIconLabel = new JLabel();
    private JLabel bookTextLabel = new JLabel();
    private JLabel bookCountLabel = new JLabel();
    private JLabel borrowIconLabel = new JLabel();
    private JLabel borrowTextLabel = new JLabel();
    private JLabel borrowCountLabel = new JLabel();
    private JLabel overtimeIconLabel = new JLabel();
    private JLabel overtimeTextLabel = new JLabel();
    private JLabel overtimeCountLabel = new JLabel();
    private JLabel timeIconLabel = new JLabel();
    private JLabel timeTextLabel = new JLabel();
    private JLabel timeValueLabel = new JLabel();
    private JLabel generateTextLabel = new JLabel();
    private JLabel generateValueLabel = new JLabel();

    /**
     * 仪表盘窗体
     */
    public ReturnView() {

        // 初始化
        init();

        //查看所有工资等级按钮图标
        JButton buttonAdd = new JButton();
        buttonAdd.setIcon(Images.bookIcon);
        buttonAdd.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonAdd.setContentAreaFilled(false); //把按钮设置为透明
        buttonAdd.setBounds(3,8,200,188); // 16 36 128 128


        //查看所有工资等级文本标签
        bookTextLabel.setText(bookText);
        bookTextLabel.setBounds(144, 56, 274, 40);
        bookTextLabel.setFont(Fonts.pane);
        bookTextLabel.setForeground(Color.WHITE);
        bookTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //查看所有工资等级标签
        bookCountLabel.setBounds(144, 108, 274, 40);
        bookCountLabel.setFont(Fonts.pane);
        bookCountLabel.setForeground(Color.WHITE);
        bookCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //查看所有工资等级面板
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
                 //JOptionPane.showMessageDialog(bookPanel, "点击了查看所有工资等级按钮！");
                new SelectWork();

            }
        });

        //查看所有员工信息按钮图标
        JButton buttonChange = new JButton();
        buttonChange.setIcon(Images.borrowPaneIcon);
        buttonChange.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonChange.setContentAreaFilled(false); //把按钮设置为透明
        buttonChange.setBounds(488,25,200,188); // 16 36 128 128
//        borrowIconLabel.setIcon(Images.borrowPaneIcon);
//        borrowIconLabel.setBounds(16, 36, 128, 128);

        //查看所有员工信息标签
        borrowTextLabel.setText(borrowText);
        borrowTextLabel.setBounds(144, 56, 274, 40);
        borrowTextLabel.setFont(Fonts.pane);
        borrowTextLabel.setForeground(Color.WHITE);
        borrowTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //查看所有员工信息标签
        borrowCountLabel.setBounds(144, 108, 274, 40);
        borrowCountLabel.setFont(Fonts.pane);
        borrowCountLabel.setForeground(Color.WHITE);
        borrowCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //查看所有员工信息面板
        borrowPanel.setLayout(null);
        borrowPanel.setBounds(488, 16, 456, 200);
        borrowPanel.setBackground(Colour.C5AB556);
        borrowPanel.add(buttonChange);
        //borrowPanel.add(borrowIconLabel);
        borrowPanel.add(borrowTextLabel);
        borrowPanel.add(borrowCountLabel);
            //查看员工信息
        buttonChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement modify action
                //JOptionPane.showMessageDialog(borrowPanel, "点击了修改员工等级按钮！");
                new QueryStaffInformation();

            }
        });

        // 查看工资变动信息按钮图标
        JButton buttonDelete = new JButton();
        buttonDelete.setIcon(Images.overtimePaneIcon);
        buttonDelete.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonDelete.setContentAreaFilled(false); //把按钮设置为透明
        buttonDelete.setBounds(3,7,201,190); // 16 36 128 128

        // 查看工资变动信息文本标签
        overtimeTextLabel.setText(overtimeText);
        overtimeTextLabel.setBounds(144, 56, 274, 40);
        overtimeTextLabel.setFont(Fonts.pane);
        overtimeTextLabel.setForeground(Color.WHITE);
        overtimeTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // 查看工资变动信息标签
        overtimeCountLabel.setBounds(144, 108, 274, 40);
        overtimeCountLabel.setFont(Fonts.pane);
        overtimeCountLabel.setForeground(Color.WHITE);
        overtimeCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // 查看工资变动信息面板
        overtimePanel.setLayout(null);
        overtimePanel.setBounds(16, 232, 456, 200);
        overtimePanel.setBackground(Colour.CE54D52);
        overtimePanel.add(buttonDelete);
        overtimePanel.add(overtimeTextLabel);
        overtimePanel.add(overtimeCountLabel);

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement delete action
                //JOptionPane.showMessageDialog(overtimePanel, "请输入你需要删除工资等级的员工工号");
                new QueryStaffChange();
            }
        });


        // 汇总查询信息图标
        JButton buttonQuery = new JButton();
        buttonQuery.setIcon(Images.timePaneIcon);
        buttonQuery.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonQuery.setContentAreaFilled(false); //把按钮设置为透明
        buttonQuery.setBounds(488,238,201,190); // 16 36 128 128


        //汇总查询信息文本标签
        timeTextLabel.setText(timeText);
        timeTextLabel.setBounds(144, 56, 274, 40);
        timeTextLabel.setFont(Fonts.pane);
        timeTextLabel.setForeground(Color.WHITE);
        timeTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //汇总查询信息标签
        timeValueLabel.setBounds(144, 108, 274, 40);
        timeValueLabel.setFont(Fonts.time);
        timeValueLabel.setForeground(Color.WHITE);
        timeValueLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //汇总查询信息面板
        timePanel.setLayout(null);
        timePanel.setBounds(488, 232, 456, 200);
        timePanel.setBackground(Colour.CFAA64B);
        timePanel.add(buttonQuery);
//        timePanel.add(timeIconLabel);
        timePanel.add(timeTextLabel);
        timePanel.add(timeValueLabel);

        buttonQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement search action
                //JOptionPane.showMessageDialog(timePanel, "请输入你需要查询员工的工资等级的工号：");
                new QueryTotalSalary();
            }
        });

        //生成汇总信息




        // 添加组件
        add(buttonChange);
        add(buttonChange);
        add(buttonQuery);
        add(bookPanel);
        add(borrowPanel);
        add(overtimePanel);
        add(timePanel);
        add(GeneratePanel);

        // 窗体设置
        setSize(960, 768);
        setLayout(null);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    /**
     * 初始化
     */
    public void init() {
        this.salaryChangeSet = new SalaryChangeSet();
        this.salaryGradeSet = new SalaryGradeSet();
        this.staffSet = new StaffSet();
        this.totalSalarySet = new TotalSalarySet();
    }

        //查询所有工资等级信息
        //选择工种类型
        public class SelectWork extends JFrame {

            private JLabel choiceLabel ;// 选择标签
            //下拉框
            private JComboBox<String> choiceBox;
            private JButton confirmButton; // 确定按钮
            private JButton cancelButton; // 取消按钮
            public SelectWork(){
                JFrame jf = new JFrame("选择工种");
                jf.setSize(400,350);
                jf.setLocation(800,400);

                choiceLabel = new JLabel("员工工种：");
                choiceLabel.setFont(new Font("微软雅黑",Font.BOLD,20));
                String[] choices = {"技术部","行政部","销售部"};
                choiceBox = new JComboBox<>(choices);
                JPanel panel = new JPanel();
                confirmButton = new JButton("确认");
                cancelButton = new JButton("取消");
                panel.add(choiceLabel);
                panel.add(choiceBox);
                panel.add(confirmButton);
                panel.add(cancelButton);

                jf.add(panel,BorderLayout.CENTER);


                //对确认按钮进行监听
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String choice = (String)choiceBox.getSelectedItem();
                        switch (choice)
                        {
                            case "技术部" :
                               new TechEmployeeLevel();
                                break;
                            case "行政部":
                                new AdminEmployeeLevel();
                                break;
                            case "销售部":
                                new SaleEmployeeLevel();
                                break;
                        }
                        jf.dispose();
                    }
                });

                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jf.dispose();
                    }
                });

                jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jf.pack();
                jf.setVisible(true);
            }
        }
        //技术人员工资等级表单
    private static Object[][] tableData = new Object[][] {
            { "一级", 3500,2000,500,500},
            { "二级", 4000,3500,800,1000},
            { "三级", 5500,5000,1000,1500},
    };

    public class QueryTotalSalary extends JFrame{
        public QueryTotalSalary(){
            JLabel datelablel = new JLabel("请选择日期");
            SpinnerDateModel model = new SpinnerDateModel();
            JSpinner spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner,"yyyy-MM-dd"));
            spinner.setValue(new Date());
            JButton button = new JButton("确认");
            JButton buttongenerte = new JButton("一键生成工资信息");
            JPanel panel = new JPanel();
            panel.add(datelablel);
            panel.add(spinner);
            panel.add(button);
            panel.add(buttongenerte);
            getContentPane().add(panel);
            setTitle("查询工资");
            setSize(300, 200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format((Date) spinner.getValue());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if(date.isEmpty()){
                        JOptionPane.showMessageDialog(null,"请选择日期");
                    }
                    else{
                        new AllQuery(date);
                        totalSalarySet.DeleteTotalSalary();
                    }

                }
            });

            buttongenerte.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                   int count= totalSalarySet.GenerateTotalSalary(date);
                   if(count!=0){
                       JOptionPane.showMessageDialog(null,"生成成功");
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"生成失败");
                   }
                }
            });
        }
    }

        //技术人员工资等级表单
    public class TechEmployeeLevel extends JFrame
     {
         // 表头
         private final String[] columnGradeTech = {"工资等级","基础工资","岗位工资","交通补贴","加班费"};
         private Object[][] data;
        public TechEmployeeLevel(){
            //创建表格模型
            data= salaryGradeSet.GetAllGradeTech();
            DefaultTableModel tableModel = new DefaultTableModel(data,columnGradeTech);

            //创建JTable
             JTable table = new JTable(tableModel);

             //设置表格的可编辑性
             table.setEnabled(true);

             //创建JScrollPane，使用JTable作为视图组件
             JScrollPane scrollPane = new JScrollPane(table,
                     JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                     JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
             // 创建JFrame并添加JScrollPane到JPanel中
             JFrame frame = new JFrame("技术人员工资等级");
             frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame.setLocationRelativeTo(null);
             JPanel panel = new JPanel();
             panel.add(scrollPane);
             frame.getContentPane().add(panel);
             frame.pack();
             frame.setVisible(true);
         }


     }

    //行政人员工资等级表单
    private static Object[][] tableData2 = new Object[][] {
            { "一级", 3000,2300,600,600},
            { "二级", 4500,3000,800,1000},
            { "三级", 5000,4500,1000,1200},

    };
    //行政人员工资等级表单
    public class AdminEmployeeLevel extends JFrame
    {
        // 表头
        private final String[] columnGradeAdmin = {"工资等级","基础工资","岗位工资","交通补贴","绩效奖励"};
        private Object[][] data;
        public AdminEmployeeLevel(){
            //创建表格模型
          data=  salaryGradeSet.GetAllGradeAdmin();
            DefaultTableModel tableModel = new DefaultTableModel(data,columnGradeAdmin);

            //创建JTable
            JTable table = new JTable(tableModel);

            //设置表格的可编辑性
            table.setEnabled(true);

            //创建JScrollPane，使用JTable作为视图组件
            JScrollPane scrollPane = new JScrollPane(table,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            // 创建JFrame并添加JScrollPane到JPanel中
            JFrame frame = new JFrame("行政人员工资等级");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        }


    }

    //销售人员工资等级表单
    private static Object[][] tableData3 = new Object[][] {
            { "一级", 3000,2300,600,600,500},
            { "二级", 4500,3000,800,1000,500},
            { "三级", 5000,4500,1000,1200,800},

    };
    //销售人员工资等级表单
    public class SaleEmployeeLevel extends JFrame
    {
        // 表头
        private final String[] columnGradeSale = {"工资等级","基础工资","岗位工资","交通补贴","浮动奖金","销售奖金"};
        private Object[][] data;
        public SaleEmployeeLevel(){
            //创建表格模型
          data=  salaryGradeSet.GetAllGradeSale();
            DefaultTableModel tableModel = new DefaultTableModel(data,columnGradeSale);

            //创建JTable
            JTable table = new JTable(tableModel);

            //设置表格的可编辑性
            table.setEnabled(true);

            //创建JScrollPane，使用JTable作为视图组件
            JScrollPane scrollPane = new JScrollPane(table,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            // 创建JFrame并添加JScrollPane到JPanel中
            JFrame frame = new JFrame("销售人员工资等级");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        }

    }


    //查看员工信息
    private static Object[][] tableData4 = new Object[][] {
            { "001","罗凯坤","女","技术人员","三级","2021-07"},
            { "002","罗凯鸡","男","行政人员","二级","2022-08"},
            { "003","张无忌","男","销售人员","二级","2022-01"},
            { "004","小琪","女","销售人员","一级","2023-02"}
    };
    public class QueryStaffInformation{
        // 表头
        private Object[][] data;
        private final String[] columnGradeInf = {"工号","姓名","性别","岗位","工资等级","注册日期"};
        public QueryStaffInformation(){
            //创建表格模型
            data = staffSet.GetAllStaff();
            DefaultTableModel tableModel = new DefaultTableModel(data,columnGradeInf);

            //创建JTable
            JTable table = new JTable(tableModel);

            //设置表格的可编辑性
            table.setEnabled(true);

            //创建JScrollPane，使用JTable作为视图组件
            JScrollPane scrollPane = new JScrollPane(table,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            // 创建JFrame并添加JScrollPane到JPanel中
            JFrame frame = new JFrame("员工信息：");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        }
    }


    //查看工资变动信息
    private static Object[][] tableData5 = new Object[][] {
            { "001","罗凯坤","2021-07",800,100},
            { "002","罗凯鸡","2022-08",500,100},
            { "003","张无忌","2022-01",500,50},
            { "004","小琪","2023-02",1000,0}
    };
    public class QueryStaffChange{
        // 表头
        private final String[] columnGradeSale = {"工号","姓名","日期","奖金","罚金"};
        private Object[][] data;
        public QueryStaffChange(){
            //创建表格模型
            data = salaryChangeSet.GetAllSalaryChange();
           DefaultTableModel tableModel = new DefaultTableModel(data,columnGradeSale);

            //创建JTable
            JTable table = new JTable(tableModel);

            //设置表格的可编辑性
            table.setEnabled(true);

            //创建JScrollPane，使用JTable作为视图组件
            JScrollPane scrollPane = new JScrollPane(table,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            // 创建JFrame并添加JScrollPane到JPanel中
            JFrame frame = new JFrame("工资变动信息：");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        }
    }

    //汇总查询
    //选择时间然后建表，在确定按钮中监听有
    public class SelectDate extends JFrame{

        public SelectDate()
        {
            // 创建JFrame
            JFrame frame = new JFrame("选择时间");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300,160);
            frame.setLocation(750,450);
            frame.setPreferredSize(new Dimension(400, 150));

            // 创建标签
            JPanel topPanel = new JPanel();
            JLabel label = new JLabel("请选择一个日期");
            topPanel.add(label);

            // 创建日期选择器
            SpinnerDateModel dateModel = new SpinnerDateModel();
            JSpinner datePicker = new JSpinner(dateModel);
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datePicker, "yyyy-MM");
            datePicker.setEditor(dateEditor);

            // 创建确定按钮
            JButton okButton = new JButton("确定");
            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 获取选择的日期
                    SimpleDateFormat dateFormat = dateEditor.getFormat();
                    String selectedDate = dateFormat.format(datePicker.getValue());
                    System.out.println("Selected date: " + selectedDate);
                    ArrayList<Object> boj = new ArrayList<>();
                    for (int i=0;i<tableData6.length;i++)
                    {
                        if(selectedDate.equals(tableData6[i][2]))
                        {
                            boj.add(tableData6[i]);
                            //boj.add(list);

                        }
                    }
                }
            });

            // 创建取消按钮
            JButton cancelButton = new JButton("取消");
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 退出应用程序
                    System.exit(0);
                }
            });

            // 将确定和取消按钮放在同一行，并居中显示
            JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);

            // 创建主面板并添加组件
            JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
            mainPanel.add(topPanel, BorderLayout.NORTH);
            mainPanel.add(datePicker, BorderLayout.CENTER);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            // 将面板添加到JFrame并显示
            frame.getContentPane().add(mainPanel);
            frame.setVisible(true);
        }
    }


    //汇总查询
    private static Object[][] tableData6 = new Object[][] {
            { "001","罗凯坤","2021-07",9500},
            { "002","罗凯鸡","2022-08",8000},
            { "003","张无忌","2022-01",6000},
            { "004","小琪","2023-02",7800},
            { "005","小晨","2023-02",6800},
            { "006","小谦","2023-02",8800},
            { "007","小俊","2023-02",6500}
    };
    public class AllQuery{
        // 表头
        private final String[] columnGradeSale = {"工号","姓名","部门","总工资","日期"};
        private Object[][] data;
        private TotalSalarySet totalSalarySet;
        public AllQuery(){

        }
        public AllQuery(String date){
            //创建表格模型
            totalSalarySet = new TotalSalarySet();
            data = totalSalarySet.GetAllTotalSalary(date);
            DefaultTableModel tableModel = new DefaultTableModel(data,columnGradeSale);

            //创建JTable
            JTable table = new JTable(tableModel);

            //设置表格的可编辑性
            table.setEnabled(true);

            //创建JScrollPane，使用JTable作为视图组件
            JScrollPane scrollPane = new JScrollPane(table,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            // 创建JFrame并添加JScrollPane到JPanel中
            JFrame frame = new JFrame("工资变动信息：");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public class SearchEmployeeLevelGUI1 {

        private JFrame frame;
        private JLabel titleLabel;

        public SearchEmployeeLevelGUI1() {

            // Create the main frame
            frame = new JFrame("查找员工等级");
            frame.setSize(800, 800);
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

