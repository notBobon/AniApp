/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.*;

public class LoginController {
    private LoginView loginView;
    private UserModel userModel;

    public LoginController(LoginView loginView, UserModel userModel) {
        this.loginView = loginView;
        this.userModel = userModel;

        loginView.addLoginListener(new LoginListener());
        loginView.addSignUpListener(new SignUpListener());
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            char[] password = loginView.getPassword();

            // Logika untuk validasi dan autentikasi pengguna
            // (Anda perlu menyesuaikan logika ini sesuai dengan kebutuhan Anda).
            if (validateLogin(username, password)) {
                // Jika autentikasi berhasil, lanjutkan ke halaman utama atau level menu.
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuController mainMenuController = new MainMenuController(mainMenuView);
                mainMenuView.setVisible(true);
                loginView.dispose(); // Tutup halaman login.
            } else {
                // Tampilkan pesan kesalahan atau tindakan yang sesuai.
                JOptionPane.showMessageDialog(loginView, "Login failed. Invalid credentials.");
            }
        }

        private boolean validateLogin(String username, char[] password) {
            // Logika validasi pengguna (contoh sederhana).
            // Anda dapat menambahkan logika untuk memeriksa kredensial dari database.
            return username.equals(userModel.getUsername()) && new String(password).equals(userModel.getPassword());
        }
    }

    private class SignUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk pindah ke halaman sign-up atau menampilkan halaman sign-up.
            SignUpView signUpView = new SignUpView();
            SignUpController signUpController = new SignUpController(signUpView, userModel);
            signUpView.setVisible(true);
            loginView.dispose(); // Tutup halaman login.
        }
    }
}



