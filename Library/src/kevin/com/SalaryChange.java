package kevin.com;

public class SalaryChange {
    private String Number;
    private String name;
    private String Date;
    private double RewardSalary;
    private double Deduction;

    public SalaryChange(String Number,String name,String Date,double RewardSalary,double Deduction){
        this.Number = Number;
        this.name = name;
        this.Date = Date;
        this.RewardSalary = RewardSalary;
        this.Deduction = Deduction;
    }




    public String getNumber() {
        return Number;
    }

    public String getMonth() {
        return Date;
    }

    public double getRewardSalary() {
        return RewardSalary;
    }

    public double getDeduction() {
        return Deduction;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return Date;
    }



}
