package kevin.com;

import java.sql.*;

public class sql {
    private Connection conn;
    private final String table_staff="staff";
    private final String table_salarychange="salarychange";
    private final String totalsalary = "totalsalary";


    public sql(){

        try{
//            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kevin?" +
                    "serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&" +
                    "autoReconnect=true";
            String user = "root";
            String pass = "root";
            this.conn = DriverManager.getConnection(url,user,pass);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }




    public void insertstaff(String Number,String name,String Gender,String Position,String Date,String SalaryGrade){
      try {
          Statement stmt = conn.createStatement();
          String sql = "insert into staff(number,name,gender,position ,Date,salarygrade)"+"values('"+Number+"','"+name+"','"+Gender+"','"+Position+"'" +
                  ",'"+Date+"','"+SalaryGrade+"')";
          int count = stmt.executeUpdate(sql);
          stmt.close();
          System.out.println("插入成功");
      } catch (SQLException e) {
          e.printStackTrace();
          System.out.println("插入失败");
    }
    }

    public int removestaff(String Number){
        try{
            Statement stmt = conn.createStatement();
            String sql = "delete from staff where number ='"+Number+"'";
            int count = stmt.executeUpdate(sql);
            if(count!=0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("未删除记录");
            }
            stmt.close();
            return count;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }



    }

    public int editstaff(String Number,String key,String valueupdate){

        try{
            Statement stmt = conn.createStatement();
            String sql = "update staff set "+key+"='"+valueupdate+"'where number='"+Number+"'";
            int count = stmt.executeUpdate(sql);
            if(count != 0){
                System.out.println("修改成功");
            }
            else{
                System.out.println("未修改任何行");
            }
            return count;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }

    }

    public  Object[] querystaff(String number){
        try{
            Object[] data=null;

            Statement stmt = conn.createStatement();

            String sql = "select * from staff where number='"+number+"'";
            ResultSet rs = stmt.executeQuery(sql);;
            while(rs.next()){

                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String position = rs.getString("position");
                String salarygrade = rs.getString("salarygrade");
                String date = rs.getString("date");
                data = new Object[]{number,name, gender, position, salarygrade, date};
            }
            rs.close();
            stmt.close();
            return data;

        }catch (SQLException e){
            e.printStackTrace();
            return null;

        }

    }


    public boolean HasStaff(String Number){
        try{

            Statement stmt = conn.createStatement();

            String sql = "select * from staff where number='"+Number+"'";
            ResultSet rs = stmt.executeQuery(sql);
           if(rs.next()==false){
               rs.close();
               stmt.close();
               return false;
           }
            rs.close();
            stmt.close();

        }catch (SQLException e){
            e.printStackTrace();


        }
        return true;

    }

    public int InsertSalarygradeSale(String tablename,String Position,String Grade,double BasicSalary,double PositionSalary,double TransformSalary,double FloatReward,double SaleReward){
        try {
            Statement stmt = conn.createStatement();
            String sql = "insert into "+tablename+"(grade,basicsalary,positionsalary,transformsalary,floatreward,salereward)"+"values('"+Grade+"','"+BasicSalary+"','"+PositionSalary+"'" +
                    ",'"+TransformSalary+"','"+FloatReward+"','"+SaleReward+"')";
            int count = stmt.executeUpdate(sql);

            stmt.close();
            System.out.println("插入成功");
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败");
            return 0;
        }

    }

    public boolean HasGrade(String tablename,String Grade){
        try{

            Statement stmt = conn.createStatement();

            String sql = "select * from "+tablename+" where grade='"+Grade+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                rs.close();
                stmt.close();
                return false;
            }
            rs.close();
            stmt.close();

        }catch (SQLException e){
            e.printStackTrace();
            return false;


        }
        return true;


    }

    public int InsertSalarygradeTech(String tablename,String Position,String Grade,double BasicSalary,double PositionSalary,double TransformSalary,double WorkoverSalary){
        try {
            int count=0;
            Statement stmt = conn.createStatement();
            String sql = "insert into "+tablename+"(grade,basicsalary,positionsalary,transformsalary,workoversalary)"+"values('"+Grade+"','"+BasicSalary+"','"+PositionSalary+"'" +
                    ",'"+TransformSalary+"','"+WorkoverSalary+"')";
            count = stmt.executeUpdate(sql);
            stmt.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int InsertSalarygradeAdmin(String tablename,String Position,String Grade,double BasicSalary,double PositionSalary,double TransformSalary,double PerformanceReward){
       int count;
        try {
            Statement stmt = conn.createStatement();
            String sql = "insert into "+tablename+"(grade,basicsalary,positionsalary,transformsalary,performancereward)"+"values('"+Grade+"','"+BasicSalary+"','"+PositionSalary+"'" +
                    ",'"+TransformSalary+"','"+PerformanceReward+"')";
            count = stmt.executeUpdate(sql);
            stmt.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int EditSalaryGradeAll(String tablename,String Grade,String key,double valueupdate){
        try{
            Statement stmt = conn.createStatement();
            String sql = "update "+tablename+" set "+key+"='"+valueupdate+"'where grade='"+Grade+"'";
            int count = stmt.executeUpdate(sql);
            if(count != 0){
                System.out.println("修改成功");
            }
            else{
                System.out.println("未修改任何行");
            }
            return count;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }


    }

    public String GetNameByNumber(String tablename,String Number){
        String name = null;
        try{

            Statement stmt = conn.createStatement();

            String sql = "select * from "+tablename+" where number='"+Number+"'";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("职位\t工资等级\t基本工资\t岗位工资\t交通补贴\t效绩奖励");
            if(rs.next()){
                name=rs.getString("name");
            }

            rs.close();
            stmt.close();



        }catch (SQLException e){
            e.printStackTrace();

        }
        return name;

    }

    public int DeleteSalaryGrade(String tablename,String grade){
        try{
            Statement stmt = conn.createStatement();
            String sql = "delete from "+tablename+" where grade='"+grade+"'";
            int count = stmt.executeUpdate(sql);
            if(count!=0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("未删除记录");
            }
            stmt.close();
            return count;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }



    public Object[] QuerySalaryGradeAdmin(String tablename,String Grade){
        try{
            Object[] data=null;
            Statement stmt = conn.createStatement();

            String sql = "select * from "+tablename+" where grade='"+Grade+"'";
            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()){
                String grade = rs.getString("grade");
                double basicsalary= rs.getDouble("basicsalary");
                double positionsalary= rs.getDouble("positionsalary");
                double tranficsubside= rs.getDouble("transformsalary");
                double performancereward = rs.getDouble("performancereward");
                data = new Object[]{grade,basicsalary,positionsalary,tranficsubside,performancereward};

            }
            rs.close();
            stmt.close();
            return data;


        }catch (SQLException e){
            e.printStackTrace();
            return null;

        }
    }

    public Object[] QuerySalaryGradeTech(String tablename,String Grade){
        try{
            Object[] data=null;
            Statement stmt = conn.createStatement();
            String sql = "select * from "+tablename+" where grade='"+Grade+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("职位\t工资等级\t基本工资\t岗位工资\t交通补贴\t加班费");
            while(rs.next()){
                String grade = rs.getString("grade");
                double basicsalary= rs.getDouble("basicsalary");
                double positionsalary= rs.getDouble("positionsalary");
                double tranficsubside= rs.getDouble("transformsalary");
                double workoversalary = rs.getDouble("workoversalary");
                data = new Object[]{grade,basicsalary,positionsalary,tranficsubside,workoversalary};
            }
            rs.close();
            stmt.close();
            return data;


        }catch (SQLException e){
            e.printStackTrace();
            return null;

        }
    }

    public Object[] QuerySalaryGradeSale(String tablename,String Grade){
        try{
            Object[] data=null;
            Statement stmt = conn.createStatement();
            String sql = "select * from "+tablename+" where grade='"+Grade+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("职位\t工资等级\t基本工资\t岗位工资\t交通补贴\t浮动奖金\t销售奖金");
            while(rs.next()){
                String grade = rs.getString("grade");
                double basicsalary= rs.getDouble("basicsalary");
                double positionsalary= rs.getDouble("positionsalary");
                double tranficsubside= rs.getDouble("transformsalary");
                double floatreward = rs.getDouble("floatreward");
                double salereward = rs.getDouble("salereward");
                data = new Object[]{grade,basicsalary,positionsalary,tranficsubside,floatreward,salereward};

            }
            rs.close();
            stmt.close();
            return data;


        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }



    public void insertsalarychange(String Number,String name,String Date,double Rewairdsalary,double Deduction){
        try {
            Statement stmt = conn.createStatement();
            String sql = "insert into "+table_salarychange+"(number,name,date,rewardsalary,deduction)"+"values('"+Number+"','"+name+"','"+Date+"','"+Rewairdsalary+"','"+Deduction+"')";
            int count = stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败");
        }



    }
    public boolean HasSalarychange(String number){
        try{

            Statement stmt = conn.createStatement();

            String sql = "select * from "+table_salarychange+" where number ='"+number+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                rs.close();
                stmt.close();
                return false;
            }
            rs.close();
            stmt.close();

        }catch (SQLException e){
            e.printStackTrace();
            return false;


        }
        return true;
    }

    public int removesalarychange(String Number,String Date){
        int count;
        try{
            Statement stmt = conn.createStatement();
            String sql = "delete from "+table_salarychange+" where number ='"+Number+"' AND date ='"+Date+"'";
             count = stmt.executeUpdate(sql);
            if(count!=0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("未删除记录");
            }
            stmt.close();
            return count;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }

    }

    public int editsalarychange(String Number,String Date,String key,double valueupdate){
        int count;
        try{
            Statement stmt = conn.createStatement();
            String sql = "update "+table_salarychange+" set "+key+"='"+valueupdate+"'where number='"+Number+"'AND date='"+Date+"'";
            count = stmt.executeUpdate(sql);
            if(count != 0){
                System.out.println("修改成功");
            }
            else{
                System.out.println("未修改任何行");
            }
            return count;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }



    }

    public Object[] querysalarychange(String number,String Date){
        try{
            Object[] data=null;

            Statement stmt = conn.createStatement();

            String sql = "select * from "+table_salarychange+" where number='"+number+"'AND date='"+Date+"'";
            ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    String name = rs.getString("name");
                    double rewardsalary= rs.getDouble("rewardsalary");
                    double deduction = rs.getDouble("deduction");
                    data = new Object[]{number,name,Date,rewardsalary,deduction};

                }





            rs.close();
            stmt.close();
            return data;

        }catch (SQLException e){
            e.printStackTrace();
             return null;
        }

    }


    public Object[][] GetAllStaff(){
        try{
            Object[][] data=null;

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String sql = "select * from "+table_staff;
            ResultSet rs = stmt.executeQuery(sql);
          data= ConsvertResToObj(rs);




            rs.close();
            stmt.close();
            return data;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public Object[][] GetAllGrade(String tablename){
        try{
           Object[][] data=null;

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String sql = "select * from "+tablename+"";
            ResultSet rs = stmt.executeQuery(sql);
            data=  ConsvertResToObj(rs);




            rs.close();
            stmt.close();
            return data;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }


    }

    public Object[][] GetAllSalarychange(){
        try{
            Object[][] data=null;

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String sql = "select * from "+table_salarychange;
            ResultSet rs = stmt.executeQuery(sql);
            data=ConsvertResToObj(rs);




            rs.close();
            stmt.close();
            return data;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public int GeneratAllSalaryInfo(String date){
        String number;
        String name;
        String position;
        double basicsalary;
        double positionsalary;
        double reward=0;
        double penalty;
        double totalsalary=0;
        double[] salarychange=null;
        double[] salarygradeinfo=null;
        String grade;
        int line;
        int count=0;
        int col;
        try{
            Statement stmt = conn.createStatement();

            ResultSet AllStaff = Getresult(table_staff);
            while(AllStaff.next()){
                totalsalary = 0;
               name = AllStaff.getString("name");
               number = AllStaff.getString("number");
               position = AllStaff.getString("position");
               grade = AllStaff.getString("salarygrade");
              salarychange= getchange(number,date);
               switch (position){
                   case "行政部":
                       salarygradeinfo=GetSalaryGradeInfo("行政部",grade);
                       break;

                   case "技术部":
                       salarygradeinfo=GetSalaryGradeInfo("技术部",grade);
                       break;

                   case "销售部":
                       salarygradeinfo=GetSalaryGradeInfo("销售部",grade);
                       break;
               }
               if(salarygradeinfo!=null){
               for(int i=0;i<salarygradeinfo.length;i++){
                   totalsalary+=salarygradeinfo[i];
               }
               }
               if(salarychange!=null){
                   totalsalary = salarychange[0]+totalsalary;
                   totalsalary = totalsalary-salarychange[1];
               }
                count=count+InsertSalary(number,name,position,totalsalary,date);




            }return count;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public Object[][] GetAllTotalSalary(String date){
        try{
            Object[][] data=null;

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String sql = "select * from "+totalsalary+" ORDER BY totalsalary DESC ";
            ResultSet rs = stmt.executeQuery(sql);
            data=ConsvertResToObj(rs);




            rs.close();
            stmt.close();
            return data;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public int InsertSalary(String number,String name,String position,double totalsalary,String date){
        try {
            int count=0;
            Statement stmt = conn.createStatement();
            String sql = "insert into totalsalary (number,name,position,totalsalary,date)"+"values('"+number+"','"+name+"','"+position+"','"+totalsalary+"'" +
                    ",'"+date+"')";
            count = stmt.executeUpdate(sql);
            stmt.close();
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double[] getchange(String number,String date){
        try{
            double[] salarychange=null;
            ResultSet rs = null;
            Statement stmt = conn.createStatement();
            String sql = "select * from "+table_salarychange+" where number='"+number+"'AND date='"+date+"'";
            rs = stmt.executeQuery(sql);
            if(rs.next())
            salarychange = new double[]{rs.getDouble("rewardsalary"),rs.getDouble("deduction")};
            stmt.close();
            rs.close();
            return salarychange;




        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public double[] GetSalaryGradeInfo(String position,String grade){
        try{
            double[] salaryinfo=null;
            Statement stmt = conn.createStatement();
            String sql;
            ResultSet rs=null;
            switch(position){
                case "行政部":
                    sql = "select * from salarygrade_admin where grade='"+grade+"'";
                    rs = stmt.executeQuery(sql);
                    if(rs.next()){
                        salaryinfo = new double[]{rs.getDouble("basicsalary"),rs.getDouble("positionsalary"),rs.getDouble("transformsalary"),rs.getDouble("performancereward")};
                    }
                    break;

                case "技术部":
                    sql = "select * from salarygrade_tech where grade='"+grade+"'";
                    rs = stmt.executeQuery(sql);
                    if(rs.next()){
                        salaryinfo = new double[]{rs.getDouble("basicsalary"),rs.getDouble("positionsalary"),rs.getDouble("transformsalary"),rs.getDouble("workoversalary")};
                    }
                    break;

                case "销售部":
                    sql = "select * from salarygrade_sale where grade='"+grade+"'";
                    rs = stmt.executeQuery(sql);
                    if(rs.next()){
                        salaryinfo = new double[]{rs.getDouble("basicsalary"),rs.getDouble("positionsalary"),rs.getDouble("transformsalary"),rs.getDouble("floatreward"),rs.getDouble("salereward")};
                    }
                    break;
            }
            stmt.close();
            rs.close();
            return salaryinfo;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public int DeleteTotalSalary(){
        try{
            Statement stmt = conn.createStatement();
            String sql = "delete from "+totalsalary+"";
           int count = stmt.executeUpdate(sql);
            if(count!=0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("未删除记录");
            }
            stmt.close();
            return count;

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet Getresult(String tablename){
        try{
            ResultSet rs = null;
            Statement stmt = conn.createStatement();

            String sql_staff = "select * from "+tablename+"";
            rs = stmt.executeQuery(sql_staff);
            return rs;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Object[][] ConsvertResToObj(ResultSet rs){
        try {
            int rowCount = getRowCount(rs);
            int columCount = getColumCount(rs);
            Object[][]  data = new Object[rowCount][columCount];
            int row = 0;
            while (rs.next()) {
                for(int col = 2;col<=columCount;col++){
                    data[row][col-2]=rs.getObject(col);
                }
                row++;

            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public  int getRowCount(ResultSet rs){
        int rowcount = 0;
        try {
            if(rs != null){
                rs.last();
                rowcount = rs.getRow();
                rs.beforeFirst();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowcount;
    }

    public int getColumCount(ResultSet rs){
        int columcnt = 0;
        try{
            ResultSetMetaData meta = rs.getMetaData();
            columcnt= meta.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columcnt;


    }

}
