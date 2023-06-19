package bwc04;

public class MonthlySalary {
    //private static final long serialVersionUID = 1L;
    private String employeeId;
    private String date;
    //奖励
    private double bonus;
    //扣款
    private double penalty;
    // 构造函数
    public MonthlySalary(String employeeId, String date, double bonus, double penalty) {
        this.employeeId = employeeId;
        this.date = date;
        this.bonus = bonus;
        this.penalty = penalty;
    }
    public MonthlySalary()
    {}
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}
