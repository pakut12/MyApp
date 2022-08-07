/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gus
 */
public class ConnDB {

    public static Connection getConnDB() {
        Connection con = null;
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@10.0.62.18:1521:stock", "comp", "pmoc4");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test" +
                    "?user=root&password=");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return con;
    }

    public static ArrayList getsqldata(String sql, String data) throws SQLException {
        ResultSet rec = null;
        Statement s = null;

        List<String> arr = new ArrayList<String>();
        try {
            s = ConnDB.getConnDB().createStatement();
            rec = s.executeQuery(sql);

            while (rec.next()) {
                arr.add(rec.getString(data));
            }

        } catch (Exception e) {
            arr.add(e.toString());
            e.printStackTrace();

        }
        return (ArrayList) arr;
    }

    

    public static boolean getsql(String sql) throws SQLException {
        Statement s = null;
        try {
            s = ConnDB.getConnDB().createStatement();
            s.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static String getpathupload() {
        String pathwork = "C:/Users/pakutsing/Desktop/Github/MyPJ/web/upload/";
        String pathhome = "C:/Users/Gus/Desktop/Github/MyPJ/web/upload/";
        return pathhome.toString();
    }

    public static String getpathfont() {
        String pathwork = "C:/Users/pakutsing/Desktop/Github/MyPJ/web/font/";
        String pathhome = "C:/Users/Gus/Desktop/Github/MyPJ/web/font/";
        return pathhome.toString();
    }

    public static String getpathExport() {
        String pathwork = "C:/Users/pakutsing/Desktop/Github/MyPJ/web/Export/";
        String pathhome = "C:/Users/Gus/Desktop/Github/MyPJ/web/Export/";
        return pathhome.toString();
    }
}
