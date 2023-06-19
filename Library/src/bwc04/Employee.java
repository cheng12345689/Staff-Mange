package bwc04;

import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.indexOf;

public class Employee {
    //员工工号
    private String ID;
    // 员工姓名
    private String name;
    //员工性别
    private String gender;
    // 员工入职日期
    private String date;
    // 员工工资等级
    private String salaryGrade;
    // 员工工作部门
    private int staffClass;
    // 员工奖励工资
    private double bonus;
    // 员工扣款工资
    private double penalty;

    //构造函数
    public Employee(String sID,String sName,String sGender,String sDate,String sSalaryGrade,int sStaffClass)
    {
        this.ID = sID;
        this.name = sName;
        this.gender = sGender;
        this.date = sDate;
        this.salaryGrade = sSalaryGrade;
        this.staffClass = sStaffClass;
    }

    public Employee() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalaryGrade() {
        return salaryGrade;
    }

    public void setSalaryGrade(String salaryGrade) {
        this.salaryGrade = salaryGrade;
    }
    public int getStaffClass() {
        return staffClass;
    }

    public void setStaffClass(int staffClass) {
        this.staffClass = staffClass;
    }
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
    //基本信息增加
    public void addBasicInfo(){
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        System.out.println("请输入员工的基本信息：");
        System.out.print("工号：");
        this.ID = inStr.nextLine();
        System.out.print("姓名：");
        this.name = inStr.nextLine();
        System.out.println("性别（男/女）：");
        this.gender = inStr.nextLine();
        System.out.println("入职日期（年月yyyymm）：");
        this.date = inStr.nextLine();
        System.out.println("岗位类别：(1-行政人员;2-技术人员;3-销售人员)");
        while(true)
        {
            try{
                String strStaffClass = inStr.nextLine();
                this.staffClass = Integer.parseInt(strStaffClass);
                //staffClass进行校验
                if(staffClass!=1 && staffClass!=2 && staffClass!=3){
                    System.out.println("岗位类别输入无效！请重新输入：");
                }
                else break;
            }catch (Exception e){
                System.out.println("岗位类别输入无效！请重新输入：");
            }
        }


    }
    String job[] = {"0","行政人员","技术人员","销售人员"};
    //基本信息显示
    public void showBasicInfo(){
        System.out.println("员工信息：");
        System.out.println("工号\t姓名\t性别\t入职日期\t岗位类别");
        System.out.println(ID+"\t"+name+"\t"+gender
                +"\t"+date+"\t"+job[staffClass]);
    }
    //没有标题信息显示
    public void showBasicInfoWithoutTitle(){
        System.out.println(ID+"\t"+name+"\t"+gender
                +"\t"+date+"\t"+job[staffClass]);
    }

    //测试类
    public static void main(String[] args) {
        Employee a = new Employee();
        a.addBasicInfo();
        a.showBasicInfo();
    }

}
