package bwc04.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FartherGradeForm extends JFrame {
    protected JFrame frame;
    protected JLabel titleLabel, levelLabel, basicSalaryLabel, positionSalaryLabel, trafficSubsidyLabel;
    protected JComboBox<String> levelComboBox;
    protected JTextField basicSalaryField, positionSalaryField, trafficSubsidyField;
    protected JButton confirmButton, cancelButton;
    protected JPanel inputPanel;

    public FartherGradeForm(){

    }

    public FartherGradeForm(String title) {

        // Create the main frame
        frame = new JFrame(title);
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);


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

        // 对确认的监听
        confirmButton = new JButton("确认");
        cancelButton = new JButton("取消");


        // Create the input panel and add components
        inputPanel = new JPanel(new GridLayout(6, 2, 10, 10)); //5 2 5 5
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        inputPanel.add(basicSalaryLabel);
        inputPanel.add(basicSalaryField);
        inputPanel.add(positionSalaryLabel);
        inputPanel.add(positionSalaryField);
        inputPanel.add(trafficSubsidyLabel);
        inputPanel.add(trafficSubsidyField);
        frame.add(inputPanel);

    }

    public void setConfirmButtonlisener(ActionListener listener){
        this.confirmButton.addActionListener(listener);
    }

    public void setCancelButtonLisener(ActionListener listener){
        this.cancelButton.addActionListener(listener);
    }

    public void addbutton(){
        inputPanel.add(confirmButton);
        inputPanel.add(cancelButton);
    }



    public String getbasicsalary(){
        return basicSalaryField.getText();
    }

    public String getpositionsalary(){
        return positionSalaryField.getText();
    }

    public String gettraficSubsidy(){
        return trafficSubsidyField.getText();

    }

}
