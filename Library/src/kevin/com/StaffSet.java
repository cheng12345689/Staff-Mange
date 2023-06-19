package kevin.com;

import javafx.beans.binding.NumberBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffSet {
    private ArrayList<Staff> AllStaff;
    private int Staff_Cnt;
    private sql sql;
    private final String tablename="staff";
    public StaffSet(){
        this.sql = new sql();
    }

    public void Add(Staff staff){
        //插入数据库
        sql.insertstaff(staff.getNumber(),staff.getName(),staff.getGender(),staff.getPosition(),staff.getDate(),staff.getSalaryGrade());

    }

    public int delete(String Number){
       return sql.removestaff(Number);
    }

    public int  edit(String Number,String key,String value){
        //数据库编辑操作
       return  sql.editstaff(Number,key,value);



    }

    public void QueryByNumber(String Number){

            sql.querystaff(Number);

    }

    public String GetNameByNumber(String Number){
      return  sql.GetNameByNumber(tablename,Number);

    }

    public Object[][] GetAllStaff(){
        return sql.GetAllStaff();
    }

    public Object[] query(String number){
        return sql.querystaff(number);
    }



    public boolean HasStaff(String Number){
            return sql.HasStaff(Number);
    }

    public void QueryByName(String name){




    }

}
