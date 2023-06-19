package bwc04;

import java.util.Scanner;

public class EmployeeSet {
    Employee[] employees;//存储所有员工信息
    int employeeNum;//记录录入员工信息的个数

    public EmployeeSet() {   //定义构造方法，创建对象数组
        employees = new Employee[100]; //创建对象数组，但没有创建各单元对象
        employeeNum = -1; //初始值为-1
    }

    //增加员工信息
    public void addEmployee() {
        boolean flag = true;
        while (flag && employeeNum < employees.length - 1) {
            employeeNum++;
            employees[employeeNum] = new Employee(); //创建employee对象
            employees[employeeNum].addBasicInfo(); //增加属性

            System.out.print("按Q键退出，其他键继续输入");
            Scanner inStr = new Scanner(System.in);
            String s = inStr.nextLine();
            if (s.length() == 0) flag = true;
            else {
                if ((s.charAt(0) == 'Q' || (s.charAt(0) == 'q')))
                    flag = false;
                else
                    flag = true;
            }
            System.out.println("职工信息新增成功！");
        }
    }

    //删除员工基本信息
    public void deleteEmployee() {
        Scanner inStr = new Scanner(System.in);
        System.out.print("请输入要删除的员工工号：");
        String staffNo = inStr.nextLine();
        int index = indexOf(staffNo);
        if (index == -1) {
            System.out.println("不存在员工工号为：" + staffNo + "的员工");
            return;
        }
        //删除操作
        for (int i = index; i < employeeNum; i++) {
            employees[i] = employees[i + 1];
        }
        System.out.println("员工号" + staffNo + "已经被删除！");
        employeeNum--;
    }

    //修改员工基本信息
    public void editEmployee(){
        Scanner inStr = new Scanner(System.in);
        System.out.println("请输入要修改的员工的工号：");
        String staffNo = inStr.nextLine();
        int index = indexOf(staffNo);
        if (index == -1) {
            System.out.println("不存在员工工号为：" + staffNo + "的员工");
            return;
        }

        employees[index].showBasicInfo();  //先展示一下要修改员工的原信息
        System.out.println("请修改相应属性的值，如不修改，则直接回车");
        System.out.print("姓名：");
        String staffName = inStr.nextLine();
        employees[index].setName(staffName);
        System.out.print("性别：");
        String staffGender = inStr.nextLine();
        employees[index].setName(staffGender);
        System.out.println("岗位类别：(1-行政人员;2-技术人员;3-销售人员)");
        int staffClass1 = inStr.nextInt();
        //staffClass进行校验
        while(staffClass1!=1 && staffClass1!=2 && staffClass1!=3){
            System.out.println("岗位类别输入无效！请重新输入：");
            staffClass1 = inStr.nextInt();
        }
        employees[index].setStaffClass(staffClass1);

        employees[index].showBasicInfo();//展示修改以后的员工信息
    }
    //按编号查询，若找到则返回该对象的下标，否则返回-1；
    private int indexOf(String staffNo){
        int index = -1;
        for (int i = 0; i <= employeeNum; i++) {
            if (employees[i].getID().equals(staffNo)) {
                index = i;
                break;
            }
        }
        return index;
    }

    //查询员工信息
    public void queryStaff(){
        Scanner inStr = new Scanner(System.in);
        System.out.println("请输入要查询的员工工号：");
        String staffNo = inStr.nextLine();
        int index = indexOf(staffNo); //查询是否存在该员工
        if(index==-1){
            System.out.println("不存在员工工号为："+ staffNo + " 的员工");
            return;
        }
        System.out.println("查询成功！");
        employees[index].showBasicInfo();
    }

    //测试类
    public static void main(String[] args) {
        EmployeeSet a = new EmployeeSet();
        a.addEmployee(); //增
        System.out.println("员工的数量为"+a.employeeNum);// 显示员工数量
        a.deleteEmployee(); //删
        System.out.println("员工的数量为"+a.employeeNum);// 显示员工数量
        a.editEmployee(); //改
        a.queryStaff(); //查
    }
}
