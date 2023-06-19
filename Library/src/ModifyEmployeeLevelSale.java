import javax.swing.*;
import java.awt.*;

public class ModifyEmployeeLevelSale extends JFrame {
    private JPanel panel;
    private JLabel basicSalaryLabel, positionSalaryLabel, trafficSubsidyLabel, floatrewardLabel, salelableLabel;
    private JTextField basicSalaryField, positionSalaryField, trafficSubsidyField, floatrewardField, salerewardField;
    private JButton confirmButton, cancelButton;

    public ModifyEmployeeLevelSale() {
        // Create the main frame
        super("修改销售工资等级");
        setSize(400, 500);
        setLocation(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create the panel
        panel = new JPanel(new GridLayout(5, 2));

        // Create the basic salary label and text field
        basicSalaryLabel = new JLabel("基本工资:");
        basicSalaryLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        panel.add(basicSalaryLabel);
        basicSalaryField = new JTextField("", 15);
        panel.add(basicSalaryField);

        // Create the position salary label and text field
        positionSalaryLabel = new JLabel("岗位工资:");
        positionSalaryLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        panel.add(positionSalaryLabel);
        positionSalaryField = new JTextField("", 15);
        panel.add(positionSalaryField);

        // Create the traffic subsidy label and text field
        trafficSubsidyLabel = new JLabel("交通补贴:");
        trafficSubsidyLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        panel.add(trafficSubsidyLabel);
        trafficSubsidyField = new JTextField("", 15);
        panel.add(trafficSubsidyField);

        // Create the float reward label and text field
        floatrewardLabel = new JLabel("浮动奖金:");
        floatrewardLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        panel.add(floatrewardLabel);
        floatrewardField = new JTextField("", 15);
        panel.add(floatrewardField);

        // Create the sale reward label and text field
        salelableLabel = new JLabel("销售奖金:");
        salelableLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        panel.add(salelableLabel);
        salerewardField = new JTextField("", 15);
        panel.add(salerewardField);

        // Create the confirm and cancel buttons
        confirmButton = new JButton("确认");
        cancelButton = new JButton("取消");

        // Add listener to the confirm and cancel buttons
        confirmButton.addActionListener(e -> {
            // TODO: Implement the confirm button listener
        });
        cancelButton.addActionListener(e -> {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dispose();
        });

        // Add the panel and buttons to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(confirmButton, BorderLayout.SOUTH);
        getContentPane().add(cancelButton, BorderLayout.EAST);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ModifyEmployeeLevelSale();
    }
}