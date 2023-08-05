package aplikasi.monitoring.sawit.setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Koneksi {
    private static String className = "Koneksi";

    public static Connection getConnection() {
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_sawit";
        String user = "root";
        String password = "";
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException error) {
                System.err.println("Terjadi kesalahan pada class " + className + ", fungsi getConnection \n Detail : " + error);
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada database,silahkan cek pengaturan database anda");
                System.exit(0);
            }

        }
        return connection;
    }
}
