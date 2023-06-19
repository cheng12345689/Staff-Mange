package kevin.com;

import java.util.Scanner;

public class SalaryChangeMenu {
    private SalaryChangeSet salaryChangeSet;
    public SalaryChangeMenu(){

        salaryChangeSet = new SalaryChangeSet();
    }

    public void SelectOperation(){

        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while (true){
            if(flag == true)break;
            System.out.println("**********工资变动管理************");
            System.out.println("\n1:新增工资变动\n2:删除工资变动信息\n3:修改工资变动信息\n4:查询工资变动信息\n:5:退出");
            int opt = sc.nextInt();
            switch (opt){
                case 1:
                    //新增工资变动
                    AddSalaryChange(sc);
                    break;

                case 2:
                    //删除工资变动信息
                    DeleteSalaryChange(sc);
                    break;

                case 3:
                    //修改工资变动信息
                    EditSalaryChange(sc);
                    break;

                case 4:
                    //查询工资变动信息
                    QuerySalaryChange(sc);
                    break;

                case 5:
                    //退出
                    flag = true;

                default:
                    System.out.println("你输入的指令有误");
                    break;
            }
        }
    }

    public void AddSalaryChange(Scanner sc){
        System.out.println("************添加工资变动信息*************");
        System.out.println("请输入职工编号：\n");
        String Number = sc.next();
        System.out.println("请输入职工姓名：\n");
        String name = sc.next();
        System.out.println("请输入月份：\n");
        String month = sc.next();
        System.out.println("请输入奖励工资：\n");
        double RewardSalary = sc.nextDouble();
        System.out.println("请输入扣款工资：\n");
        double Deduction = sc.nextDouble();
        SalaryChange salaryChange = new SalaryChange(Number,name,month,RewardSalary,Deduction);
        salaryChangeSet.add(salaryChange);


    }

    public void DeleteSalaryChange(Scanner sc){
        System.out.println("*********删除工资变动信息***********");
        System.out.println("请输入职工编号：\n");
        String Number = sc.next();
        System.out.println("请输入日期：\n");
        String Date = sc.next();
        salaryChangeSet.remove(Number,Date);


    }

    public void EditSalaryChange(Scanner sc){
        System.out.println("********修改工资变动信息*********");
        System.out.println("请输入职工编号：\n");
        String Number = sc.next();
        System.out.println("请输入日期：\n");
        String Date = sc.next();
        System.out.println("请输入你想修改的字段：\n");
        String  key = sc.next();
        System.out.println("请输入修改后的值：\n");
        double valueupdate = sc.nextDouble();

        salaryChangeSet.edit(Number,Date,key,valueupdate);

    }

    public void QuerySalaryChange(Scanner sc){
        System.out.println("*********查询职工变动信息***********");
        System.out.println("请输入职工编号：\n");
        String Number = sc.next();
        System.out.println("请输入日期：\n");
        String Date = sc.next();
        salaryChangeSet.query(Number,Date);

    }

}
