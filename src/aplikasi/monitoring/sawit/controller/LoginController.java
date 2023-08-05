/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasi.monitoring.sawit.controller;

import aplikasi.monitoring.sawit.entity.LoginEntity;
import aplikasi.monitoring.sawit.implement.LoginImplement;
import aplikasi.monitoring.sawit.view.HomeView;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class LoginController {
    public static LoginImplement loginImplement = new LoginImplement();
    
    public static void loadData(LoginEntity loginEntity) {
        try {
            String username = loginEntity.getUsername();
            String password = loginEntity.getPassword();

            List<LoginEntity> list = loginImplement.getLogin(username, password);
            if (!list.isEmpty()) {
                HomeView home = new HomeView();
                home.setVisible(true);
                home.revalidate();
//                JOptionPane.showMessageDialog(null, "Login Successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed!");
            }
        } catch (Exception error) {
            System.err.println("Terjadi kesalahan pada class " + LoginController.class.getName() + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + LoginController.class.getName() + ", methode loadData");
        }
    }
}