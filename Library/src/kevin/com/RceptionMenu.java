package kevin.com;

import java.util.Scanner;

public class RceptionMenu {
    public void SelectOperation(){



        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while(true){
        System.out.println("****************前台界面**************");
        System.out.printf("1:工资等级管理\n2：职工管理\n3:工资变动管理\n4:查看工资统计\n5:退出\n");
        System.out.printf("请输入指令：");
        int opt = sc.nextInt();
        if(flag == true)break;
        switch (opt){
            case 1:
                //工资等级管理
                SalaryGradeMenu salaryGradeMenu = new SalaryGradeMenu();
                salaryGradeMenu.SelectOperation();
                break;

            case 2:
                //职工管理
                StaffMenu staffMenu = new StaffMenu();
                staffMenu.SelectOperation();
                break;

            case 3:
                //工资变动管理
                SalaryChangeMenu salaryChangeMenu = new SalaryChangeMenu();
                salaryChangeMenu.SelectOperation();


                break;

            case 4:
                //工资汇总查询
                break;

            case 5:
                flag = true;
                break;

            default:
                System.out.println("您输入的指令有误");
                break;
        }
        }
    }
}
