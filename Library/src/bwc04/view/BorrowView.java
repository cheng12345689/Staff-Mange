package bwc04.view;


import bwc04.tools.color.Colour;
import bwc04.tools.font.Fonts;
import bwc04.tools.image.Images;
import com.sun.javaws.util.JfxHelper;
import javafx.scene.layout.GridPane;
import jdk.nashorn.internal.scripts.JO;
import kevin.com.SalaryChange;
import kevin.com.SalaryChangeSet;
import kevin.com.Staff;
import kevin.com.StaffSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static bwc04.tools.font.Fonts.*;
import static java.lang.Thread.sleep;

/**
 *
 * @author bwc
 * @version 1.0
 */
public class BorrowView extends JPanel {


    /**
     * 文字
     */
    private String bookText = "新增工资变动";
    private String borrowText = "修改工资变动";
    private String overtimeText = "删除工资变动";
    private String timeText = "查找工资变动";


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

    private SalaryChangeSet salaryChangeSet;
    private StaffSet staffSet;

    /**
     * 窗体
     */
    public BorrowView() {
        // 初始化
        init();

        //新增工资变动按钮图标
        JButton buttonAdd = new JButton();
        buttonAdd.setIcon(Images.bookIcon);
        buttonAdd.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonAdd.setContentAreaFilled(false); //把按钮设置为透明
        buttonAdd.setBounds(19,25,200,188); // 16 36 128 128

        //新增工资变动文本标签
        bookTextLabel.setText(bookText);
        bookTextLabel.setBounds(144, 56, 274, 40);
        bookTextLabel.setFont(Fonts.pane);
        bookTextLabel.setForeground(Color.WHITE);
        bookTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //新增工资变动标签
        bookCountLabel.setBounds(144, 108, 274, 40);
        bookCountLabel.setFont(Fonts.pane);
        bookCountLabel.setForeground(Color.WHITE);
        bookCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //新增工资变动面板
        bookPanel.setLayout(null);
        bookPanel.setBounds(16, 16, 456, 200);
        bookPanel.setBackground(Colour.C3C8CE7);
        bookPanel.add(buttonAdd);
        bookPanel.add(bookTextLabel);
        bookPanel.add(bookCountLabel);

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement add action
               // JOptionPane.showMessageDialog(bookPanel, "点击了新增工资变动按钮！");
                new HasStaff();
            }
        });

        //修改工资变动按钮图标
        JButton buttonChange = new JButton();
        buttonChange.setIcon(Images.borrowPaneIcon);
        buttonChange.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonChange.setContentAreaFilled(false); //把按钮设置为透明
        buttonChange.setBounds(488,25,200,188); // 16 36 128 128

        //修改工资变动标签
        borrowTextLabel.setText(borrowText);
        borrowTextLabel.setBounds(144, 56, 274, 40);
        borrowTextLabel.setFont(Fonts.pane);
        borrowTextLabel.setForeground(Color.WHITE);
        borrowTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //修改工资变动标签
        borrowCountLabel.setBounds(144, 108, 274, 40);
        borrowCountLabel.setFont(Fonts.pane);
        borrowCountLabel.setForeground(Color.WHITE);
        borrowCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //修改工资变动面板
        borrowPanel.setLayout(null);
        borrowPanel.setBounds(488, 16, 456, 200);
        borrowPanel.setBackground(Colour.C5AB556);
        borrowPanel.add(buttonChange);
        borrowPanel.add(borrowTextLabel);
        borrowPanel.add(borrowCountLabel);

        buttonChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Edit();
            }
        });

        // 删除工资变动按钮图标
        JButton buttonDelete = new JButton();
        buttonDelete.setIcon(Images.overtimePaneIcon);
        buttonDelete.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonDelete.setContentAreaFilled(false); //把按钮设置为透明
        buttonDelete.setBounds(3,7,201,190); // 16 36 128 128

        // 删除工资变动文本标签
        overtimeTextLabel.setText(overtimeText);
        overtimeTextLabel.setBounds(144, 56, 274, 40);
        overtimeTextLabel.setFont(Fonts.pane);
        overtimeTextLabel.setForeground(Color.WHITE);
        overtimeTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // 删除工资变动标签
        overtimeCountLabel.setBounds(144, 108, 274, 40);
        overtimeCountLabel.setFont(Fonts.pane);
        overtimeCountLabel.setForeground(Color.WHITE);
        overtimeCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        // 删除工资变动面板
        overtimePanel.setLayout(null);
        overtimePanel.setBounds(16, 232, 456, 200);
        overtimePanel.setBackground(Colour.CE54D52);
        overtimePanel.add(buttonDelete);
        overtimePanel.add(overtimeTextLabel);
        overtimePanel.add(overtimeCountLabel);

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement delete action
               // JOptionPane.showMessageDialog(overtimePanel, "请输入你需要删除工资变动的员工工号");
                new InputDemo2();
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
                new QueryForm();

            }
        });


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
        setLayout(null);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    /**
     * 初始化
     */
    //查找变动工资
    public class QueryForm extends JFrame{
        public QueryForm() {
            JLabel label = new JLabel("请输入工号:");
            JTextField textField = new JTextField(20);
            JLabel datelablel = new JLabel("请选择日期");
            SpinnerDateModel model = new SpinnerDateModel();
            JSpinner spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner,"yyyy-MM-dd"));
            spinner.setValue(new Date());
            JButton button = new JButton("确认");
            JPanel panel = new JPanel(); //
            panel.add(label);
            panel.add(textField);
            panel.add(datelablel);
            panel.add(spinner);
            panel.add(button);
            getContentPane().add(panel);
            setTitle("工号");
            setSize(300, 200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String number = textField.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format((Date)spinner.getValue());
                    // 检查输入是否为空
                    if (number.isEmpty()||date.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "工号和日期不能为空");
                    } else if (staffSet.HasStaff(number)) {                 //当输入正确
                        Object[] data = salaryChangeSet.query(number,date);
                        if(data == null)JOptionPane.showMessageDialog(null,"暂无信息");
                        else
                        new QueryTable(data,"工资变动查询");
                    } else {
                        JOptionPane.showMessageDialog(null, "不存在工号为：" + number);
                    }
                }
            });

        }
    }
    public void init() {
      this.salaryChangeSet = new SalaryChangeSet();
      this.staffSet = new StaffSet();
    }



    //新增变动Add
    public class HasStaff extends JFrame{
        public HasStaff(){
            JLabel label = new JLabel("请输入工号");
            JTextField textField = new JTextField(20);
            JLabel datelablel = new JLabel("请选择日期");
            SpinnerDateModel model = new SpinnerDateModel();
            JSpinner spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner,"yyyy-MM-dd"));
            spinner.setValue(new Date());
            JButton confirmbutton = new JButton("确认");
            JPanel panel = new HomePanel();
            panel.add(label);
            panel.add(textField);
            panel.add(datelablel);
            panel.add(spinner);
            panel.add(confirmbutton);
            getContentPane().add(panel);
            setTitle("工号");
            setSize(300,200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            confirmbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String number = textField.getText();
                    System.out.println("你输入的工号为"+number);
                    // 检查输入是否为空
                    if (number.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "工号不能为空");
                    } else if (staffSet.HasStaff(number)) {                 //当输入正确
                        dispose(); // 关闭判断窗体
                       // BookView.AddEmployeeForm form = new BookView.AddEmployeeForm();//改为确定页面
                        AddForm form = new AddForm();
                        form.setConfirmButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // 处理确认按钮点击事件
                                String name = staffSet.GetNameByNumber(number);
                                double reward = Double.parseDouble(form.GetReward());
                                double deduction = Double.parseDouble(form.GetDeduction());
                                //将日期改为字符串
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String date = dateFormat.format((Date)spinner.getValue());
                                //...

                                if(salaryChangeSet.HasSalarychange(number)){
                                    JOptionPane.showMessageDialog(null,"该编号已存在工资变动");
                                }
                                else {
                                    SalaryChange salaryChange = new SalaryChange(number, name, date, reward, deduction);
                                    salaryChangeSet.add(salaryChange);
                                    JOptionPane.showMessageDialog(form, "添加成功！");
                                    form.dispose();
                                }
                            }
                        });
                        form.setCancelButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // 处理取消按钮点击事件
                                form.dispose();
                            }
                        });

                        form.setCancelButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                form.dispose();
                            }
                        });
                        form.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "不存在工号为：" + number);
                    }
                }
            });
        }

    }
    public class AddForm extends JFrame {
        private final JLabel timeLabel;
        private final JTextField bonusInput;
        private final JTextField penaltyInput;
        private JButton confirmbutton;
        private JButton cancelbutton;

        public AddForm() {
            super("奖金和罚款输入窗口");
            this.setSize(800,800);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel mainPanel = new JPanel(); //
            this.setSize(300,300);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            JPanel timePanel = new JPanel();
            timePanel.setLayout(new FlowLayout());
            JLabel timeDescLabel = new JLabel("当前时间:");
            timePanel.add(timeDescLabel);
            timeLabel = new JLabel(getDateTimeString());
            timePanel.add(timeLabel);
            mainPanel.add(timePanel);

            JPanel bonusPanel = new JPanel();
            bonusPanel.setLayout(new FlowLayout());
            JLabel bonusDescLabel = new JLabel("奖金:");
            bonusPanel.add(bonusDescLabel);
            bonusInput = new JTextField(10);
            bonusPanel.add(bonusInput);
            mainPanel.add(bonusPanel);

            JPanel penaltyPanel = new JPanel();
            penaltyPanel.setLayout(new FlowLayout());
            JLabel penaltyDescLabel = new JLabel("罚款:");
            penaltyPanel.add(penaltyDescLabel);
            penaltyInput = new JTextField(10);
            penaltyPanel.add(penaltyInput);
            mainPanel.add(penaltyPanel);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());

            confirmbutton = new JButton("确认");
            buttonPanel.add(confirmbutton);
            cancelbutton = new JButton("取消");
            buttonPanel.add(cancelbutton);
            mainPanel.add(buttonPanel);

            this.getContentPane().add(mainPanel);

            //this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }

        private String getDateTimeString() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            return dateFormat.format(date);
        }
        private String GetReward(){
            return bonusInput.getText();
        }

        private String GetDeduction(){
            return penaltyInput.getText();
        }

        public void setConfirmButtonListener(ActionListener listener) {
            confirmbutton.addActionListener(listener);
        }
        public void setCancelButtonListener(ActionListener listener) {
            cancelbutton.addActionListener(listener);
        }
    }
    //修改变动工资Modify
    public class Edit extends JFrame {
        public Edit() {
            JLabel label = new JLabel("请输入工号:");
            JTextField textField = new JTextField(20);
            JLabel datelablel = new JLabel("请选择日期");
            SpinnerDateModel model = new SpinnerDateModel();
            JSpinner spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner,"yyyy-MM-dd"));
            spinner.setValue(new Date());
            JButton button = new JButton("确认");
            JPanel panel = new HomePanel();
            panel.add(label);
            panel.add(textField);
            panel.add(datelablel);
            panel.add(spinner);
            panel.add(button);
            getContentPane().add(panel);
            setTitle("工号");
            setSize(300, 200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String number = textField.getText().trim();
                    System.out.println("你输入的工号为"+number);
                    // 检查输入是否为空
                    if (number.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "工号不能为空");
                    } else if (staffSet.HasStaff(number)) {                 //当输入正确工号
                        Editform form = new Editform(); //
                        form.setConfirmButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               String updatereward = form.GetReward();
                               String updatededuction = form.GetDeduction();
                               String info;
                               //将日期改为字符串
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String date = dateFormat.format((Date)spinner.getValue());
                                System.out.println("日期："+date);
                               if(!updatededuction.isEmpty()){
                                   double deduction = Double.parseDouble(updatededuction);
                                 int count =  salaryChangeSet.edit(number,date,"deduction",deduction);
                                 if(count!=0)info = "修改成功";
                                 else info="未修改任何行";
                                 JOptionPane.showMessageDialog(form,info);
                                 form.dispose();
                               }
                               if(!updatereward.isEmpty()){
                                   double reward = Double.parseDouble(updatereward);
                                   salaryChangeSet.edit(number,date,"rewardsalary",reward);
                               }

                            }
                        });
                        form.setCancelButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                form.dispose();
                            }
                        });

                    } else {
                        JOptionPane.showMessageDialog(null, "不存在工号为：" + number);
                    }
                }
            });

        }
    }

    //修改变动工资表单
    public class Editform extends JFrame{
        private final JLabel timeLabel;
        private final JTextField bonusInput;
        private final JTextField penaltyInput;
        private JButton confirmbutton;
        private JButton cancelbutton;

        public Editform() {
            super("奖金和罚款修改窗口");
            this.setSize(800,800);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel mainPanel = new JPanel(); //
            this.setSize(300,300);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            JPanel timePanel = new JPanel();
            timePanel.setLayout(new FlowLayout());
            JLabel timeDescLabel = new JLabel("当前时间:");
            timePanel.add(timeDescLabel);
            timeLabel = new JLabel(getDateTimeString());
            timePanel.add(timeLabel);
            mainPanel.add(timePanel);

            JPanel bonusPanel = new JPanel();
            bonusPanel.setLayout(new FlowLayout());
            JLabel bonusDescLabel = new JLabel("修改奖金:");
            bonusPanel.add(bonusDescLabel);
            bonusInput = new JTextField(10);
            bonusPanel.add(bonusInput);
            mainPanel.add(bonusPanel);

            JPanel penaltyPanel = new JPanel();
            penaltyPanel.setLayout(new FlowLayout());
            JLabel penaltyDescLabel = new JLabel("修改罚款:");
            penaltyPanel.add(penaltyDescLabel);
            penaltyInput = new JTextField(10);
            penaltyPanel.add(penaltyInput);
            mainPanel.add(penaltyPanel);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());
            confirmbutton = new JButton("确认");
            buttonPanel.add(confirmbutton);
            cancelbutton = new JButton("取消");
            buttonPanel.add(cancelbutton);
            mainPanel.add(buttonPanel);

            this.getContentPane().add(mainPanel);

            //this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }

        private String getDateTimeString() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            return dateFormat.format(date);
        }
        private String GetReward(){
            return bonusInput.getText();
        }

        private String GetDeduction(){
            return penaltyInput.getText();
        }

        public void setConfirmButtonListener(ActionListener listener) {
            confirmbutton.addActionListener(listener);
        }
        public void setCancelButtonListener(ActionListener listener) {
            cancelbutton.addActionListener(listener);
        }

    }


    //删除变动工资Delete
    public class InputDemo2 extends JFrame {
        public InputDemo2() {
            JLabel label = new JLabel("请输入工号:");
            JTextField textField = new JTextField(20);
            JLabel datelablel = new JLabel("请选择日期");
            SpinnerDateModel model = new SpinnerDateModel();
            JSpinner spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner,"yyyy-MM-dd"));
            spinner.setValue(new Date());
            JButton button = new JButton("确认");
            JPanel panel = new HomePanel();
            panel.add(label);
            panel.add(textField);
            panel.add(datelablel);
            panel.add(spinner);
            panel.add(button);
            getContentPane().add(panel);
            setTitle("工号");
            setSize(300, 200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String number = textField.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format((Date) spinner.getValue());
                    System.out.println("你输入的工号为"+number);
                    // 检查输入是否为空
                    if (number.isEmpty()||date.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "工号和日期不能为空");
                    } else if (staffSet.HasStaff(number)) {                 //当输入正确工号
                         dispose(); // 关闭判断窗体
                        confirmdelete confirmdelete = new confirmdelete(number,date);
                        confirmdelete.SetConfirmbuttonListen(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               int count= salaryChangeSet.remove(number,date);
                               String info;
                               if(count == 0)info="未删除任何行";
                               else info="删除成功";
                                JOptionPane.showMessageDialog(confirmdelete,info);
                                confirmdelete.dispose();
                            }
                        });

                        confirmdelete.SetCancelbuttonListen(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                confirmdelete.dispose();
                            }
                        });

                    } else {
                        JOptionPane.showMessageDialog(null, "不存在工号为：" + number);
                    }
                }
            });

        }
    }

    public class confirmdelete extends JFrame{
        JButton confirmbutton;
        JButton cancelbutton;
        JPanel jPanel;
        JLabel info;
        public confirmdelete(String Number,String Date){
            confirmbutton = new JButton("确认");
            cancelbutton = new JButton("取消");
            jPanel = new JPanel();
            info = new JLabel("你确认删除"+Date+"  "+Number+"的工资变动吗？");
            confirmbutton.setMargin(new Insets(10,20,10,20));
            cancelbutton.setMargin(new Insets(10,20,10,20));
             jPanel.setLayout(new FlowLayout());
             jPanel.add(info);
             jPanel.add(confirmbutton);
             jPanel.add(cancelbutton);
             this.add(jPanel);
             this.setSize(400,200);
             this.setLocation(600,300);
             this.setVisible(true);

        }

        public void SetConfirmbuttonListen(ActionListener listener){
            this.confirmbutton.addActionListener(listener);
        }

        public void SetCancelbuttonListen(ActionListener listener){
            this.cancelbutton.addActionListener(listener);
        }


    }
    //给嵌体加背景图片
    class HomePanel extends JPanel {
        ImageIcon icon;
        Image img;
        public HomePanel() {
            //  /img/HomeImg.jpg 是存放在你正在编写的项目的bin文件夹下的img文件夹下的一个图片
            icon=new ImageIcon(getClass().getResource("/bwc04/images/7.jpg"));
            img=icon.getImage();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
            g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
        }

    }

}

