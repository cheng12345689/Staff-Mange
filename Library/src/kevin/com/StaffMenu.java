package kevin.com;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffMenu {
    StaffSet staffSet;
    public StaffMenu(){
        this.staffSet = new StaffSet();
    }

    public void SelectOperation(){


        Scanner sc=new Scanner(System.in);
        boolean flag = false;
        int opt;
        while (true){
            if(flag==true)break;
            System.out.println("*************员工信息管理**************");
            System.out.println("\n1:新增员工\n2:删除员工信息\n3:修改员工信息\n4:查询员工信息\n:5:退出");
            opt = sc.nextInt();
            switch (opt){
                case 1:
                    //新增员工
                    AddStaff(sc);
                    break;

                case 2:
                    //删除员工信息
                    RemoveStaff(sc);
                    break;

                case 3:
                    //修改员工信息
                    EditStaff(sc);
                    break;

                case 4:
                    //查询员工信息
                    QueryStaff(sc);
                    break;

                case 5:
                    flag =true;
                    break;

                default:
                    System.out.printf("无法识别指令\n");
                    break;
            }

        }

    }

    public void AddStaff(Scanner sc){
        System.out.println("*****添加员工*********");
        System.out.println("请输入员工编号：\n");
        String Number = sc.next();
        System.out.println("请输入姓名：\n");
        String name = sc.next();
        System.out.println("请输入性别：\n");
        String Genger = sc.next();
        System.out.println("请输入岗位：\n");
        String Position = sc.next();
        System.out.println("请输入入职年份：\n");
        String Date = sc.next();
        System.out.println("请输入工资等级：\n");
        String Grade = sc.next();
        Staff staff = new Staff(Number,name,Position,Genger,Date,Grade);
        staffSet.Add(staff);
        System.out.println("添加成功\n");



    }

    public void RemoveStaff(Scanner sc){
        System.out.println("**********删除员工信息*********\n");
        System.out.println("请输入你想删除的员工工号：\n");
        String Number = sc.next();
        staffSet.delete(Number);
        System.out.println("删除成功\n");

    }

    public void EditStaff(Scanner sc){
        System.out.println("**********修改员工信息**********");

        System.out.println("请输入你想修改的员工工号：\n");
        String Number = sc.next();
        System.out.println("请输入你想修改的字段：\n");
        String key = sc.next();
        System.out.printf("请输入更新后的值：\n");
        String updatevalue = sc.next();
        staffSet.edit(Number,key,updatevalue);

    }

    public void QueryStaff(Scanner sc){
        System.out.println("***************查询员工信息************");
        System.out.println("请输入工号：\n");
        String Number = sc.next();
        staffSet.QueryByNumber(Number);

    }


}
