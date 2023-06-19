package kevin.com;

import javafx.scene.layout.GridPane;

public class SalaryGradeSet {
    private sql sql;
    private final String table_admin="salarygrade_admin";
    private final String table_tech="salarygrade_tech";
    private final String table_sale="salarygrade_sale";

   public SalaryGradeSet(){
       this.sql = new sql();

   }




   public boolean HasGradeTech(String grade){
       return sql.HasGrade(table_tech,grade);
   }

    public boolean HasGradeAdmin(String grade){
        return sql.HasGrade(table_admin,grade);
    }

    public boolean HasGradeSale(String grade){
        return sql.HasGrade(table_sale,grade);
    }

    public int TechnologySalaryAdd(SalaryGradeTechnology salaryGrade){
      return sql.InsertSalarygradeTech(table_tech,salaryGrade.getPosition(),salaryGrade.getGrade(),salaryGrade.getBasicSalary(),salaryGrade.getPositonSalary(),salaryGrade.getTransformSalary(),salaryGrade.getWorkoverSalary());
    }

    public int AdminSalaryAdd(SalaryGradeAdmin salaryGradeAdmin){
      return sql.InsertSalarygradeAdmin(table_admin,salaryGradeAdmin.getPosition(),salaryGradeAdmin.getGrade(),salaryGradeAdmin.getBasicSalary(),salaryGradeAdmin.getPositonSalary(),salaryGradeAdmin.getTransformSalary(),salaryGradeAdmin.getPerformanceReward());
    }

    public int SaleSalaryAdd(SalaryGradeSale salaryGradeSale){
       return sql.InsertSalarygradeSale(table_sale,salaryGradeSale.getPosition(),salaryGradeSale.getGrade(),salaryGradeSale.getBasicSalary(),salaryGradeSale.getPositonSalary(),salaryGradeSale.getTransformSalary(),salaryGradeSale.getFloatReward(),salaryGradeSale.getSaleReward());
    }


    public int TechnologySalaryEdit(String Grade,String key,double updatevalue){
       return sql.EditSalaryGradeAll(table_tech,Grade,key,updatevalue);
    }

    public int AdminSalaryEdit(String Grade,String key,double updatevalue){
       return sql.EditSalaryGradeAll(table_admin,Grade,key,updatevalue);
    }

    public int SaleSalaryEdit(String Grade,String key,double updatevalue){
       return sql.EditSalaryGradeAll(table_sale,Grade,key,updatevalue);
    }

    public Object[] TechnologySalaryQuery(String Grade){
      return sql.QuerySalaryGradeTech(table_tech,Grade);
    }

    public Object[] AdminSalaryQuery(String Grade){
       return sql.QuerySalaryGradeAdmin(table_admin,Grade);

    }

    public Object[] SaleSalaryQuery(String Grade){
       return sql.QuerySalaryGradeSale(table_sale,Grade);

    }

    public Object[][] GetAllGradeAdmin(){
       return sql.GetAllGrade(table_admin);
    }

    public Object[][] GetAllGradeTech(){
       return sql.GetAllGrade(table_tech);
    }

    public Object[][] GetAllGradeSale(){
       return sql.GetAllGrade(table_sale);
    }

    public int Delete_Admin(String grade){
       return sql.DeleteSalaryGrade(table_admin,grade);
    }

    public int Delete_Tech(String grade){
       return sql.DeleteSalaryGrade(table_tech,grade);
    }

    public int Delete_Sale(String grade){
       return sql.DeleteSalaryGrade(table_sale,grade);
    }



}
