/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {
    private JButton startButton;
    private JButton exitButton;

    public MainMenuView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("AniApp - Main Menu");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        startButton = new JButton("Start");
        exitButton = new JButton("Exit");

        panel.add(startButton);
        panel.add(exitButton);

        add(panel);
    }

    // Menambahkan ActionListener untuk tombol "Start"
    public void addStartListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    // Menambahkan ActionListener untuk tombol "Exit"
    public void addExitListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}


