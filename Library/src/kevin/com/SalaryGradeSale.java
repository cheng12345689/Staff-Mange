package kevin.com;

public class SalaryGradeSale extends SalaryGrade{

    private double FloatReward;//浮动奖金
    private double SaleReward;//销售奖金

    public SalaryGradeSale(String Grade,double BasicSalary,double PositionSalary,double TransformSalary,String Position,double FloatReward,double SaleReward){
        super(Grade,BasicSalary,PositionSalary,TransformSalary,Position);
        this.FloatReward = FloatReward;
        this.SaleReward = SaleReward;

    }




    public double getFloatReward() {
        return FloatReward;
    }

    public double getSaleReward() {
        return SaleReward;
    }








}
