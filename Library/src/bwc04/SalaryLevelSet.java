package bwc04;

import java.util.ArrayList;
import java.util.Scanner;

public class SalaryLevelSet {
    public ArrayList<SalaryLevel> salaryLevels;

    public SalaryLevelSet()
    {

    }
    //

    //新增工资等级
    private void addSalaryLevel()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入工资等级: ");
        String level = scanner.nextLine();
        System.out.print("请输入基本工资: ");
        double basicSalary = scanner.nextDouble();
        System.out.print("请输入岗位工资: ");
        double postSalary = scanner.nextDouble();
        System.out.print("请输入交通补贴: ");
        double transportationAllowance = scanner.nextDouble();
        SalaryLevel salaryLevel = new SalaryLevel(level,basicSalary,postSalary,transportationAllowance);
        salaryLevels.add(salaryLevel);
        System.out.println("工资等级新增成功 !");
    }
    // 修改工资等级
    private void changeSalaryLevel(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("你要修改的工资等级: ");
        String level = scanner.nextLine();
        boolean flag = false;
        for(SalaryLevel salaryLevel:salaryLevels){
            if(salaryLevel.getLevel() == level)
            {
                System.out.print("请输入基本工资(原基本工资为"+salaryLevel.getBasicSalary()+"): ");
                double basicSalary = scanner.nextDouble();
                System.out.print("请输入岗位工资(原岗位工资为"+salaryLevel.getPostWage()+"): ");
                double postWage = scanner.nextDouble();
                System.out.print("请输入交通补贴(原交通补贴为"+salaryLevel.getTransportationAllowance()+"): ");
                double transportation = scanner.nextDouble();
                salaryLevel = new SalaryLevel(level,basicSalary,postWage,transportation);
                salaryLevels.set(salaryLevels.indexOf(salaryLevel),salaryLevel);
                flag = true;
                System.out.println("工资等级修改成功！");
                break;
            }
        }
        if(!flag)
        {
            System.out.println("工资等级不存在!");
        }
    }

    //查询工资等级
    private void querySalaryLevel(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的工资等级（如需列出所有工资等级请输入：0）： ");
        String level = scanner.nextLine();
        if(level=="0")
        {
            System.out.println("所有工资等级如下：");
            for(SalaryLevel salaryLevel:salaryLevels)
            {
                System.out.println(salaryLevel);
            }
        }
        else {
            boolean flag = false;
            for (SalaryLevel salaryLevel:salaryLevels)
            {
                if (salaryLevel.getLevel() == level)
                {
                    System.out.println("工资等级如下： ");
                    System.out.println(salaryLevel);
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                System.out.println("工资等级不存在！");
            }
        }

    }

    //新增
    public void port1()
    {
        addSalaryLevel();
    }
    //改
    public void port2()
    {
        changeSalaryLevel();
    }

}
