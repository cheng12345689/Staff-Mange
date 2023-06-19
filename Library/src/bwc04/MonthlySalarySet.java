package bwc04;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MonthlySalarySet extends EmployeeSet{
    private ArrayList<MonthlySalary> monthlySalaries;

    public MonthlySalarySet(){

    }

    //新增员工变动工资
    private void addMonthlySalary(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入员工编号：");
        String employeeId = scanner.nextLine();
        boolean flag = false;
        for(Employee employee:employees)
        {
            if(Objects.equals(employee.getID(), employeeId)) //判断employee.getID()和employeeId是否相等
            {
                flag = true;
                break;
            }
        }
        if (!flag)
        {
            System.out.println("员工编号不存在！");
            return;
        }
        System.out.print("请输入月份（yyyymm）： ");
        String month = scanner.nextLine();
        System.out.print("请输入奖励工资：");
        double award = scanner.nextDouble();
        System.out.print("请输入扣款：");
        double deduction = scanner.nextDouble();
        MonthlySalary monthlySalary = new MonthlySalary(employeeId,month,award,deduction);
        monthlySalaries.add(monthlySalary);
    }

    // 修改员工变动工资
    private void changeMonthSalary(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要修改变动工资的员工编号：");
        String employeeId = scanner.nextLine();
        boolean flag = false;
//        for (Employee employee:employees)
//        {
//            if (employee.getID() == employeeId)
//            {
//
//            }
//        }
        for (MonthlySalary monthlySalary : monthlySalaries){
            if (monthlySalary.getEmployeeId()==employeeId)
            {
                System.out.print("请输入修改的奖励工资(原奖励工资为"+monthlySalary.getBonus()+"): ");
                double bonus = scanner.nextDouble();
                System.out.print("请输入修改的扣款工资(原扣款工资为"+monthlySalary.getPenalty()+"): ");
                double penalty = scanner.nextDouble();
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            System.out.println("该员工不存在！");
            return;
        }
    }

    // 删除员工变动工资
    private void deleteMonthlySalary()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你需要删除变动工资的员工工号：");
        String employeeId = scanner.nextLine();
        boolean flag = false;
        for (MonthlySalary monthlySalary : monthlySalaries){
            if (monthlySalary.getEmployeeId()==employeeId)
            {
                System.out.print("请输入修改的奖励工资(原奖励工资为"+monthlySalary.getBonus()+"): ");
                double bonus = 0.0;
                System.out.print("请输入修改的扣款工资(原扣款工资为"+monthlySalary.getPenalty()+"): ");
                double penalty = 0.0;
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            System.out.println("该员工不存在！");
            return;
        }
    }

}
