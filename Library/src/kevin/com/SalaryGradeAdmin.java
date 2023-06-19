package kevin.com;
public class SalaryGradeAdmin extends SalaryGrade{
    private double PerformanceReward;


    public SalaryGradeAdmin(String Grade,double BasicSalary,double PositionSalary,double TransformSalary,String Position,double PerformanceReward){
        super(Grade,BasicSalary,PositionSalary,TransformSalary,Position);
        this.PerformanceReward = PerformanceReward;
    }

    public double getPerformanceReward() {
        return PerformanceReward;
    }
}
