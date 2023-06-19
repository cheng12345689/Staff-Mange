package bwc04.view;


//import bwc04.EmployeeForm;
import bwc04.tools.color.Colour;
import bwc04.tools.font.Fonts;
import bwc04.tools.image.Images;
import kevin.com.Staff;
import kevin.com.StaffSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

        import static java.lang.Thread.sleep;

/**
 * 仪表盘信息
 * @author KSaMar
 * @version 1.0
 */
public class BookView extends JPanel {

    private int bookCount = 0;
    private int borrowCount = 0;
    private int overtimeCount = 0;

    /**
     * 文字
     */
    private String bookText = "新增员工";
    private String borrowText = "修改员工信息";
    private String overtimeText = "删除员工";
    private String timeText = "查找员工信息";


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

    private StaffSet staffSet;

    /**
     * 仪表盘窗体
     */
    public BookView() {

        // 初始化
        init();


        //新增员工按钮图标
        JButton buttonAdd = new JButton();
        buttonAdd.setIcon(Images.bookIcon);
        buttonAdd.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonAdd.setContentAreaFilled(false); //把按钮设置为透明
        buttonAdd.setBounds(19,25,200,188); // 16 36 128 128


        //新增员工文本标签
        bookTextLabel.setText(bookText);
        bookTextLabel.setBounds(144, 56, 274, 40);
        bookTextLabel.setFont(Fonts.pane);
        bookTextLabel.setForeground(Color.WHITE);
        bookTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //新增员工标签
        bookCountLabel.setBounds(144, 108, 274, 40);
        bookCountLabel.setFont(Fonts.pane);
        bookCountLabel.setForeground(Color.WHITE);
        bookCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //新增员工面板
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
               // JOptionPane.showMessageDialog(bookPanel, "点击了新增员工按钮！");
                AddEmployeeForm form = new AddEmployeeForm();
                form.setConfirmButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 处理确认按钮点击事件
                        String name = form.getNameText();
                        String number = form.getIdText();
                        String gender = form.getGenderText();
                        String position = form.getPosition();
                        String hireDate = form.getHireDateText();
                        String salaryLevel = form.getSalaryLevelText();
                        //...
                        if(staffSet.HasStaff(number)){
                            JOptionPane.showMessageDialog(null,"改编号已存在");
                        }
                        else {
                            Staff staff = new Staff(number, name, position, gender, hireDate, salaryLevel);
                            staffSet.Add(staff);
                            JOptionPane.showMessageDialog(form, "新增工资等级成功！");
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
                form.setVisible(true);
            }
        });

        //修改员工按钮图标
        JButton buttonChange = new JButton();
        buttonChange.setIcon(Images.borrowPaneIcon);
        buttonChange.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonChange.setContentAreaFilled(false); //把按钮设置为透明
        buttonChange.setBounds(488,25,200,188); // 16 36 128 128


        //修改员工标签
        borrowTextLabel.setText(borrowText);
        borrowTextLabel.setBounds(144, 56, 274, 40);
        borrowTextLabel.setFont(Fonts.pane);
        borrowTextLabel.setForeground(Color.WHITE);
        borrowTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //修改员工标签
        borrowCountLabel.setBounds(144, 108, 274, 40);
        borrowCountLabel.setFont(Fonts.pane);
        borrowCountLabel.setForeground(Color.WHITE);
        borrowCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        //修改员工面板
        borrowPanel.setLayout(null);
        borrowPanel.setBounds(488, 16, 456, 200);
        borrowPanel.setBackground(Colour.C5AB556);
        borrowPanel.add(buttonChange);
        borrowPanel.add(borrowTextLabel);
        borrowPanel.add(borrowCountLabel);

        buttonChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement modify action
               // JOptionPane.showMessageDialog(borrowPanel, "点击了修改员工信息按钮！");
                new HasStaff(); // 修改窗体页面
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
               // JOptionPane.showMessageDialog(overtimePanel, "请输入你需要删除工资等级的员工工号");
                new DeleteHasStaff(); //删除
            }
        });

        //查找员工图标
        JButton buttonQuery = new JButton();
        buttonQuery.setIcon(Images.timePaneIcon);
        buttonQuery.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonQuery.setContentAreaFilled(false); //把按钮设置为透明
        buttonQuery.setBounds(488,238,201,190); // 16 36 128 128

        //查找工资文本标签
        timeTextLabel.setText(timeText);
        timeTextLabel.setBounds(144, 56, 274, 40);
        timeTextLabel.setFont(Fonts.pane);
        timeTextLabel.setForeground(Color.WHITE);
        timeTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //查找工资标签
        timeValueLabel.setBounds(144, 108, 274, 40);
        timeValueLabel.setFont(Fonts.time);
        timeValueLabel.setForeground(Color.WHITE);
        timeValueLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //查找工资面板
        timePanel.setLayout(null);
        timePanel.setBounds(488, 232, 456, 200);
        timePanel.setBackground(Colour.CFAA64B);
        timePanel.add(buttonQuery);
        timePanel.add(timeTextLabel);
        timePanel.add(timeValueLabel);

        buttonQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement search action
              QueryPanel queryPanel =  new QueryPanel();
              queryPanel.setConfirmbuttonListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      String number = queryPanel.getnumber();
                      Object[] data = staffSet.query(number);
                      new QueryTable(data,"员工查询");
                  }
              });
              queryPanel.setCancelbuttonListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      queryPanel.dispose();
                  }
              });
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
    public void init() {
        this.staffSet = new StaffSet();
    }

    //员工查询页面
    public class QueryPanel extends JFrame{
        private JLabel numberlabel;
        private JTextField numberinput;
        private JButton confirmbutton;
        private JButton cancelbutton;
        private JPanel panel;

        public QueryPanel(){
            this.setTitle("工号窗口");
            numberlabel = new JLabel("请输入员工工号:");
            numberinput = new JTextField(15);
            confirmbutton = new JButton("确认");
            cancelbutton = new JButton("取消");
            panel = new JPanel();
            panel.setLayout(new GridLayout(2,2,3,4));
            panel.add(numberlabel);
            panel.add(numberinput);
            panel.add(confirmbutton,BorderLayout.SOUTH);
            panel.add(cancelbutton,BorderLayout.SOUTH);
            panel.setSize(350,200);
            this.add(panel);
            this.setSize(350,200);
            this.setLocation(800,400);
            this.setVisible(true);

        }

        public void setConfirmbuttonListener(ActionListener listener){
            confirmbutton.addActionListener(listener);
        }

        public void setCancelbuttonListener(ActionListener listener){
            cancelbutton.addActionListener(listener);
        }

        public String getnumber(){
            return numberinput.getText();
        }
    }

    //给嵌体加背景图片1
    class HomePanel extends JPanel {
        ImageIcon icon;
        Image img;
        public HomePanel() {
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

    //添加员工窗体
    public class AddEmployeeForm extends JFrame {

        private JLabel nameLabel,idLabel,genderLabel,dateLabel,postLabel,salaryLevelLabel;
        private JTextField nameField;
        private JTextField idField;
        private JComboBox<String> genderComboBox;
        private JComboBox<String> postComboBox;
        private JComboBox<String> salaryLevelComboBox;
        private JButton confirmButton;
        private JButton cancelButton;
        private JSpinner spinner;
        public AddEmployeeForm() {
            initUI();

        }
        private void initUI() {
            setTitle("员工信息");
            setSize(600, 450);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            SpinnerDateModel model = new SpinnerDateModel();
            spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner,"yyyy-MM-dd"));
            spinner.setValue(new Date());

            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            nameLabel = new JLabel("姓名:");
            nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            panel.add(nameLabel);
            nameField = new JTextField();
            panel.add(nameField);

            idLabel = new  JLabel("工号:");
            idLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            panel.add(idLabel);
            idField = new JTextField();
            panel.add(idField);

            genderLabel = new JLabel("性别:");
            genderLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            panel.add(genderLabel);
            genderComboBox = new JComboBox<>(new String[] {"男", "女", "其他"});
            panel.add(genderComboBox);

            dateLabel = new JLabel("入职日期:");
            dateLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            panel.add(dateLabel);
            panel.add(spinner);

            postLabel = new JLabel("工作职务：");
            postLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            panel.add(postLabel);
            postComboBox = new JComboBox<>(new String[] {"技术部","行政部","销售部"});
            panel.add(postComboBox);

            salaryLevelLabel = new JLabel("工资等级:");
            salaryLevelLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            panel.add(salaryLevelLabel);
            salaryLevelComboBox = new JComboBox<>(new String[] {"0级","一级", "二级", "三级"});
            panel.add(salaryLevelComboBox);

            confirmButton = new JButton("确认");
            cancelButton = new JButton("取消");

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.add(confirmButton);
            buttonPanel.add(cancelButton);

            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(panel, BorderLayout.CENTER);
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            setVisible(true);
        }
        public void setConfirmButtonListener(ActionListener listener) {
            confirmButton.addActionListener(listener);
        }
        public void setCancelButtonListener(ActionListener listener) {
            cancelButton.addActionListener(listener);
        }
        public String getNameText() {
            return nameField.getText();
        }
        public String getIdText() {
            return idField.getText();
        }
        public String getGenderText() {
            return (String) genderComboBox.getSelectedItem();
        }
        public String getHireDateText() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format((Date) spinner.getValue());
            return date;
        }
        public String getSalaryLevelText() {
            return (String) salaryLevelComboBox.getSelectedItem();
        }

        public String getPosition(){
              return (String) postComboBox.getSelectedItem();
        }

}
    //修改员工信息窗体
    public class HasStaff extends JFrame {
        public HasStaff() {
            JLabel label = new JLabel("请输入工号:");
            JTextField textField = new JTextField(20);
            JButton button = new JButton("确认");
            JPanel panel = new HomePanel(); //
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
                    String number = textField.getText();
                    System.out.println("你输入的工号为"+number);
                    // 检查输入是否为空
                    if (number.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "工号不能为空");
                    } else if (staffSet.HasStaff(number)) {                 //当输入正确
                        dispose(); // 关闭判断窗体
                        ModifyEmployeeForm form = new ModifyEmployeeForm();
                        form.setConfirmButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // 处理确认按钮点击事件
                                String salaryLevel = form.getSalaryLevelText();
                                String name = form.getStaffname();
                                String position = form.getPosition();
                                //...6.13
                                ChangeStaff(number,"salarygrade",salaryLevel);
                                ChangeStaff(number,"name",name);
                                ChangeStaff(number,"position",position);
                                JOptionPane.showMessageDialog(form, "修改员工信息成功！");
                                form.dispose();
                            }
                        });
                        form.setCancelButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // 处理取消按钮点击事件
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
        //6.13
        public void ChangeStaff(String number,String key,String value){
            int count=0;
            if(value!=null&&!value.equals("")){
                count= staffSet.edit(number,key,value);
                if(count!=0)JOptionPane.showMessageDialog(null,"修改成功");
                else JOptionPane.showMessageDialog(null,"修改失败");
            }

        }
    }
    public class ModifyEmployeeForm extends JFrame {

        private JTextField nameField;
        private JTextField idField;
        private JComboBox<String> position;
        private JComboBox<String> genderComboBox;
        private JTextField hireDateField;
        private JComboBox<String> salaryLevelComboBox;
        private JButton confirmButton;
        private JButton cancelButton;
        public ModifyEmployeeForm() {
            initUI();
        }
        private void initUI() {
            setTitle("员工信息");
            setSize(400, 226);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(new JLabel("姓名"));
            nameField = new JTextField(20);
            panel.add(nameField);
            panel.add(new JLabel("工资等级:"));
            salaryLevelComboBox = new JComboBox<>(new String[] {"一级", "二级", "三级"});
            panel.add(salaryLevelComboBox);
            panel.add(new JLabel("部门"));
            position = new JComboBox<>(new String[]{"行政部","技术部","销售部"});
            panel.add(position);


            confirmButton = new JButton("确认");
            cancelButton = new JButton("取消");

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.add(confirmButton);
            buttonPanel.add(cancelButton);

            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(panel, BorderLayout.CENTER);
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            setVisible(true);
        }
        //6.13
        public void setConfirmButtonListener(ActionListener listener) {
            confirmButton.addActionListener(listener);
        }
        public void setCancelButtonListener(ActionListener listener) {
            cancelButton.addActionListener(listener);
        }
        public String getSalaryLevelText() {
            return (String) salaryLevelComboBox.getSelectedItem();
        }
        public String getStaffname(){return nameField.getText();}
        public String getPosition(){return (String)position.getSelectedItem();}

    }

    //删除员工信息窗体
    public class DeleteHasStaff extends JFrame {
        public DeleteHasStaff() {
            JLabel label = new JLabel("请输入工号:");
            JTextField textField = new JTextField(20);
            JButton button = new JButton("确认");
            JPanel panel = new HomePanel();  //
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
                    String number = textField.getText();
                    System.out.println("你输入的工号为"+number);
                    // 检查输入是否为空
                    if (number.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "工号不能为空");
                    } else if (staffSet.HasStaff(number)) {                 //当输入正确
                        dispose(); // 关闭判断窗体
                        int count=  staffSet.delete(number);
                        //6.13
                        if(count!=0)
                            JOptionPane.showMessageDialog(null, "删除成功！");
                        else JOptionPane.showMessageDialog(null,"删除失败");


                    } else {
                        JOptionPane.showMessageDialog(null, "不存在工号为：" + number);
                    }
                }
            });

        }
    }
    public class SearchEmployeeLevelGUI1 {

        private JFrame frame;
        private JLabel titleLabel;

        public SearchEmployeeLevelGUI1() {
            // Create the main frame
            frame = new JFrame("查找员工等级");
            frame.setSize(450, 450);
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

