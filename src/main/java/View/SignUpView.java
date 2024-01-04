/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    public SignUpView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("AniApp - Sign Up");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        signUpButton = new JButton("Sign Up");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Spasi kosong
        panel.add(signUpButton);

        add(panel);
    }

    // Mendapatkan nilai username dari field
    public String getUsername() {
        return usernameField.getText();
    }

    // Mendapatkan nilai password dari field
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    // Menambahkan ActionListener untuk tombol sign up
    public void addSignUpListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
    }

    // Menampilkan pesan sukses
    public void displaySuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Menampilkan pesan kesalahan
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
