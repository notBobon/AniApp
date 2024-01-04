/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.UserModel;
import View.LoginView;
import View.SignUpView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SignUpController {
    private SignUpView signUpView;
    private UserModel userModel;

    public SignUpController(SignUpView signUpView, UserModel userModel) {
        this.signUpView = signUpView;
        this.userModel = userModel;

        signUpView.addSignUpListener(new SignUpListener());
    }

    private class SignUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = signUpView.getUsername();
            char[] password = signUpView.getPassword();

            // Logika untuk menambahkan pengguna baru (Anda perlu menyesuaikan logika ini sesuai dengan kebutuhan Anda).
            // Misalnya, menyimpan pengguna baru ke database.
            userModel.setUsername(username);
            userModel.setPassword(new String(password));

            // Tampilkan pesan sukses atau navigasi ke halaman lain.
            JOptionPane.showMessageDialog(signUpView, "Sign Up successful! You can now log in.");
            
            // Pindah ke halaman login atau halaman lain yang sesuai.
            LoginView loginView = new LoginView();
            LoginController loginController = new LoginController(loginView, userModel);
            loginView.setVisible(true);
            signUpView.dispose(); // Tutup halaman sign-up.
        }
    }
}