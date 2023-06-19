package kevin.com;

import java.sql.Connection;

public class SalaryChangeSet {
     private  sql sql;

    public SalaryChangeSet(){
        this.sql = new sql();
    }

    public void add(SalaryChange salaryChange){
        //数据库添加
        sql.insertsalarychange(salaryChange.getNumber(),salaryChange.getName(),salaryChange.getDate(),salaryChange.getRewardSalary(),salaryChange.getDeduction());
    }

    public int remove(String Number,String Date){
      return  sql.removesalarychange(Number,Date);

    }

    public int  edit(String Number,String Date,String key,double value){
       return sql.editsalarychange(Number,Date,key,value);
    }

    public boolean HasSalarychange(String number){
        return sql.HasSalarychange(number);
    }

    public Object[] query(String Number,String Date){
      return   sql.querysalarychange(Number,Date);

    }

    public Object[][] GetAllSalaryChange(){
        return sql.GetAllSalarychange();
    }

}
