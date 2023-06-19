package bwc04;

public class SalaryLevel {
    //工资等级
    private  String Level;
    //基本工资
    private double basicSalary;
    //岗位工资
    private double postWage;
    //交通补贴
    private double transportationAllowance;

    public SalaryLevel(String sLevel,double sBasicSalary,double sPostWage,double sTransportationAllowance)
    {
        this.Level = sLevel;
        this.basicSalary = sBasicSalary;
        this.postWage = sPostWage;
        this.transportationAllowance = sTransportationAllowance;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getPostWage() {
        return postWage;
    }

    public void setPostWage(double postWage) {
        this.postWage = postWage;
    }

    public double getTransportationAllowance() {
        return transportationAllowance;
    }

    public void setTransportationAllowance(double transportationAllowance) {
        this.transportationAllowance = transportationAllowance;
    }
}
