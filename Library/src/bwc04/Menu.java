package bwc04;

import java.util.Scanner;

public class Menu {


    public static void main(String[] args) {
        EmployeeSet staff = new EmployeeSet();
        //填加员工
        staff.addEmployee();

        //工资等级类
        SalaryLevelSet level = new SalaryLevelSet();
        level.port1();
        //修改工资等级类
        level.port2();

        // 变动工资
        MonthlySalary c = new MonthlySalary();

        //总工资
        double sum[]= new double[100];

        //员工数
//        int len = staff.employeeNum;
//        for(int i=0;i<len;i++)
//        {
//            sum[i]=
//        }
    }


    //登录/注册菜单
    public void menu1()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择登录或者注册（1-登录，0-注册");
        int choice = scanner.nextInt();
        while (choice!=1&&choice!=0)
        {
            System.out.println("输入有误，请重新输入：");
            choice = scanner.nextInt();
        }

    }
}
