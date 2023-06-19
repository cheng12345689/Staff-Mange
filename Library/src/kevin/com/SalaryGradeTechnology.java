package kevin.com;

public class SalaryGradeTechnology extends SalaryGrade{
    private double WorkoverSalary;//加班费


    public double getWorkoverSalary() {
        return WorkoverSalary;
    }

    public SalaryGradeTechnology(String Grade,double BasicSalary,double PositionSalary,double TransformSalary,String Position,double WorkoverSalary){
        super(Grade,BasicSalary,PositionSalary,TransformSalary,Position);
        this.WorkoverSalary = WorkoverSalary;
    }
}
