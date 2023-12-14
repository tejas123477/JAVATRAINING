package DBconncet;
import java.sql.*;

public class DBConnUtil {

    public static Connection getDBConnection(String cString) {
        Connection con = null;
        //"resources\\\\Application.properties"
        try {
//            String className = DBPropertyUtil.getClassName("resources\\\\Application.properties");
//            Class.forName(className);
//            con = DriverManager.getConnection(cString);
            String className = DBPropertyUtil.getClassName("D:\\JAVA\\Training\\resources\\Application.properties");
            Class.forName(className);
            con = DriverManager.getConnection(cString,"root","Tejasrai123@");
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return con;

    }

    public static void main(String[] args) {
        String conStr = DBPropertyUtil.getConnectionString("resources\\Application.properties");
        Connection con = DBConnUtil.getDBConnection(conStr);
        String query = " select  * from employees where employee_id between 100 and 120";
        String query1 = " select  * from employees where employee_id between ? and ?";
        PreparedStatement ps =  null;
        ResultSet rs2 = null;

        try {
            ps = con.prepareStatement(query1);
            System.out.println(ps);
            ps.setInt(1, 135);
            ps.setInt(2, 145);
            System.out.println(ps);
            rs2 = ps.executeQuery();
            System.out.println(rs2);
            while (rs2.next()) {
                System.out.println(
                        rs2.getInt(1) + " " + rs2.getString(2) + " " + rs2.getDate(6) + " " + rs2.getDouble("salary"));
            }


        } catch (SQLException e) {


            e.printStackTrace();
        }finally {
            try {
                ps.close();
                rs2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        Statement s = null;
        ResultSet rs = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(6) + " " + rs.getDouble("salary"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                rs.close();
                s.close();
                con.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

        System.out.println(con);

    }

}