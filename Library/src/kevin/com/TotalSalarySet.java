package kevin.com;

public class TotalSalarySet {
    private final String tablename="totalsalary";
    private sql sql;

    public TotalSalarySet(){
        this.sql = new sql();
    }

    public int GenerateTotalSalary(String date){
       return sql.GeneratAllSalaryInfo(date);
    }

    public int DeleteTotalSalary(){
        return sql.DeleteTotalSalary();
    }

    public Object[][] GetAllTotalSalary(String date){
       Object[][]data= sql.GetAllTotalSalary(date);
       return data;

    }
}
