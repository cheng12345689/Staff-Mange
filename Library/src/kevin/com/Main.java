package kevin.com;

public class Main {
    public static void main(String[] args) {
        /*RceptionMenu rceptionMenu = new RceptionMenu();
        rceptionMenu.SelectOperation();*/
        sql sql = new sql();
        sql.GeneratAllSalaryInfo("2023-06-12 00:00:00");
    }
}
