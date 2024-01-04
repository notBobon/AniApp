/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.UserModel;
import View.SignUpView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    private SignUpView signUpView;
    private DatabaseManager databaseManager;

    public SignUpController(SignUpView signUpView, DatabaseManager databaseManager) {
        this.signUpView = signUpView;
        this.databaseManager = databaseManager;

        // Mengatur aksi untuk tombol sign up
        this.signUpView.addSignUpListener(new SignUpListener());
    }

    // ActionListener untuk tombol sign up
    private class SignUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = signUpView.getUsername();
            String password = signUpView.getPassword();

            // Memastikan username tidak kosong
            if (username.isEmpty()) {
                signUpView.displayErrorMessage("Username tidak boleh kosong.");
                return;
            }

            // Memastikan password tidak kosong
            if (password.isEmpty()) {
                signUpView.displayErrorMessage("Password tidak boleh kosong.");
                return;
            }

            // Memastikan username belum digunakan
            if (databaseManager.isUsernameTaken(username)) {
                signUpView.displayErrorMessage("Username sudah digunakan. Silakan pilih username lain.");
                return;
            }

            // Menambahkan pengguna baru ke database
            UserModel newUser = new UserModel(username, password);
            databaseManager.addUser(newUser);

            // Menampilkan pesan sukses dan menutup halaman sign-up
            signUpView.displaySuccessMessage("Pendaftaran berhasil! Silakan login.");
            signUpView.dispose();
        }
    }
}


