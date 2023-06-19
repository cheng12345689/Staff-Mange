package bwc04.view;

import kevin.com.SalaryChangeSet;
import kevin.com.SalaryGradeSet;
import kevin.com.StaffSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QueryTable extends JFrame {
    private final String[] cloum_staff = {"工号","姓名","性别","岗位","工资等级","注册日期"};
    private final String[] cloum_grade_tech = {"工资等级","基础工资","岗位工资","交通补贴","加班费"};
    private final String[] cloum_grade_admin = {"工资等级","基础工资","岗位工资","交通补贴","效绩奖励"};
    private final String[] cloum_grade_sale = {"工资等级","基础工资","岗位工资","交通补贴","浮动奖金","销售奖金"};
    private final String[] cloum_salarychange = {"工号","姓名","日期","奖金","罚金"};
    StaffSet staffSet = new StaffSet();
    SalaryGradeSet salaryGradeSet= new SalaryGradeSet();
    SalaryChangeSet salaryChangeSet = new SalaryChangeSet();
    DefaultTableModel model;//表格模型
    JTable table;
    JScrollPane scrollPane;
    private Object[][] data;

    //员工表
    public QueryTable(Object[] data,String SortofQuery){
        switch (SortofQuery){
            case "员工查询":
                CreateTable(data, cloum_staff);
                break;

            case "行政部工资等级查询":
                CreateTable(data,cloum_grade_admin);
                break;

            case "技术部工资等级查询":
                CreateTable(data,cloum_grade_tech);
                break;

            case "销售部工资等级查询":
                CreateTable(data,cloum_grade_sale);
                break;

            case "工资变动查询":
                CreateTable(data,cloum_salarychange);
                break;
        }
    }

    public void CreateTable(Object[]data,String[] cloum){
        this.data = new Object[1][1];
        this.data[0]=data;
        model = new DefaultTableModel(this.data,cloum);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        table.setEnabled(true);
        setLocationRelativeTo(null);
        setSize(500,200);
        setVisible(true);

    }
}
