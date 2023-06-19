package kevin.com;

public class Staff {
    private String Number;
    private String name;
    private String Position;
    private String Gender;
    private String Date;
    private String SalaryGrade;

    public Staff(){


    }

    public Staff(String Number,String name,String Position,String Gender,String Date,String SalaryGrade){
        this.Number = Number;
        this.name = name;
        this.Position = Position;
        this.Gender = Gender;
        this.Date = Date;
        this.SalaryGrade = SalaryGrade;
    }

    public String getNumber() {
        return Number;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return Position;
    }

    public String getGender() {
        return Gender;
    }

    public String  getSalaryGrade() {
        return SalaryGrade;
    }

    public String getDate() {
        return Date;
    }










}