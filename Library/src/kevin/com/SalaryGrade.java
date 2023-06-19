package kevin.com;

public abstract class SalaryGrade {
    protected String Grade;//工资等级
    protected double BasicSalary;//基本工资
    protected double PositionSalary;//岗位工资
    protected double TransformSalary;//交通补贴
    protected String Position;//部门

    public SalaryGrade(){

    }

    public SalaryGrade(String Grade,double BasicSalary,double PositionSalary,double TransformSalary,String Position){
        this.Grade = Grade;
        this.BasicSalary = BasicSalary;
        this.PositionSalary = PositionSalary;
        this.TransformSalary = TransformSalary;
        this.Position = Position;
    }

    public String  getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public double getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        BasicSalary = basicSalary;
    }

    public double getPositonSalary() {
        return PositionSalary;
    }

    public void setPositonSalary(double positonSalary) {
        PositionSalary = positonSalary;
    }

    public double getTransformSalary() {
        return TransformSalary;
    }

    public void setTransformSalary(double transformSalary) {
        TransformSalary = transformSalary;
    }

    public String getPosition() {
        return Position;
    }


}
