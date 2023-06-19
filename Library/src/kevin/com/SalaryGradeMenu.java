package kevin.com;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;
import javafx.geometry.Pos;

import java.util.Scanner;


public class SalaryGradeMenu {
    Scanner sc = new Scanner(System.in);
    boolean flag = false;
    SalaryGradeSet salarygradeset;

    public SalaryGradeMenu(){
        this.salarygradeset=new SalaryGradeSet();
    }

    public void SelectOperation(){


        while(true){
            System.out.println("*************工资等级管理**************");
            System.out.println("\n1:新增工资等级\n2:修改工资等级\n3:查询工资等级信息\n4:退出");
            if(flag == true)break;
            int opt = sc.nextInt();
            switch (opt){
                case 1:
           //新增工资等级
                    Add();
                break;

                case 2:
                    //修改工资等级
                   Edit();
                break;

                case 3:
                    //查询工资等级信息
                   Query();
                break;

                case 4:
                    flag=true;//退出
                break;
            }
        }
    }

    public void Add(){
        System.out.println("请输入岗位：\n");
        String Position = sc.next();
        System.out.println("请输入工资等级：\n");
        String Grade = sc.next();
        System.out.println("请输入基本工资：\n");
        double BasicSalary = sc.nextDouble();
        System.out.println("请输入岗位工资：\n");
        double PositionSalary = sc.nextDouble();
        System.out.println("请输入交通补贴：\n");
        double TransformSalary = sc.nextDouble();
        switch (Position)
        {
            case "Technology":
                //插入技术工资等级
                System.out.println("请输入加班费：\n");
                double WorkoverSalary = sc.nextDouble();
                SalaryGradeTechnology salaryGradeTechnology = new SalaryGradeTechnology(Grade,BasicSalary,PositionSalary,TransformSalary,Position,WorkoverSalary);
                salarygradeset.TechnologySalaryAdd(salaryGradeTechnology);


                break;

            case "Administration":
                //插入行政工资等级
                System.out.println("输入绩效奖金：\n");
                double PerformanceReward = sc.nextDouble();
                SalaryGradeAdmin salaryGradeAdmin = new SalaryGradeAdmin(Grade,BasicSalary,PositionSalary,TransformSalary,Position,PerformanceReward);
                salarygradeset.AdminSalaryAdd(salaryGradeAdmin);

                break;

            case "Sale":
                //插入销售工资等级
                System.out.println("输入浮动奖金：\n");
                double FloatReward = sc.nextDouble();
                System.out.println("输入销售奖金：\n");
                double SaleReward = sc.nextDouble();
                SalaryGradeSale salaryGradeSale = new SalaryGradeSale(Grade,BasicSalary,PositionSalary,TransformSalary,Position,FloatReward,SaleReward);
                SalaryGradeSet salaryGradeSet1= new SalaryGradeSet();

                salaryGradeSet1.SaleSalaryAdd(salaryGradeSale);

                break;
        }

    }


    public void Edit(){
        System.out.println("请输入岗位：\n");
        String Position1 = sc.next();
        System.out.println("请输入工资等级：\n");
        String Grade1 = sc.next();
        switch (Position1){
            case "Technology":
                //修改技术工资等级
                System.out.println("请输入你想修改的工资字段：");
                String key = sc.next();
                System.out.println("请输入更改后的值：\n");
                double updatevalue = sc.nextDouble();
                salarygradeset.TechnologySalaryEdit(Grade1,key,updatevalue);
                //根据字段修改对应的值




                break;

            case "Administration":
                //修改行政工资等级
                System.out.println("请输入你想修改的工资字段：");
                String key1 = sc.next();
                System.out.println("请输入更改后的值：\n");
                double updatevalue1 = sc.nextDouble();
                salarygradeset.AdminSalaryEdit(Grade1,key1,updatevalue1);

                break;

            case "Sale":
                //插入销售工资等级
                System.out.println("请输入你想修改的工资字段：");
                String key2 = sc.next();
                System.out.println("请输入更改后的值：\n");
                double updatevalue2 = sc.nextDouble();
                salarygradeset.SaleSalaryEdit(Grade1,key2,updatevalue2);

                break;
        }

    }

    public void Query(){
        System.out.println("请输入查询岗位：");
        String PositionQueriy = sc.next();
        switch (PositionQueriy){
            case "Technology":
                //查询技术工资等级
                System.out.println("请输入查询等级：\n");
                String GradeQuery = sc.next();
                salarygradeset.TechnologySalaryQuery(GradeQuery);





                break;

            case "Administration":
                //查询行政工资等级
                System.out.println("请输入查询等级：\n");
                String GradeQuery1 = sc.next();
                salarygradeset.AdminSalaryQuery(GradeQuery1);



                break;

            case "Sale":
                //查询销售工资等级
                System.out.println("请输入查询等级：\n");
                String GradeQuery2 = sc.next();
                salarygradeset.SaleSalaryQuery(GradeQuery2);
                break;
        }

    }




}
