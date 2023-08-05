/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasi.monitoring.sawit.implement;

import aplikasi.monitoring.sawit.setting.Koneksi;
import aplikasi.monitoring.sawit.entity.LoginEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class LoginImplement {
    public List<LoginEntity> getLogin(String username, String password) {
        List<LoginEntity> list = new ArrayList<>();
        try (
            Connection conn = Koneksi.getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM auth WHERE username = ? AND password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LoginEntity loginEntity = new LoginEntity();
                loginEntity.setUsername(resultSet.getString("username"));
                loginEntity.setPassword(resultSet.getString("password"));
                loginEntity.setLevel(resultSet.getString("level"));
                list.add(loginEntity);
            }
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan pada class " + LoginImplement.class.getName() + ", methode function getLogin \n Detail : " + e);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + LoginImplement.class.getName() + ", function getLogin");
        }
        return list;
    }
}

