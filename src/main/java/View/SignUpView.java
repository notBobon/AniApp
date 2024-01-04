/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    public SignUpView() {
        setTitle("AniApp - Sign Up");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        signUpButton = new JButton("Sign Up");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(signUpButton);

        add(panel);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public void addSignUpListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
    }
}