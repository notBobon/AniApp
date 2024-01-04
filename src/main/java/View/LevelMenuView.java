/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LevelMenuView extends JFrame {
    private JButton[] levelButtons;
    private JButton backButton;

    public LevelMenuView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("AniApp - Level Menu");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3));

        levelButtons = new JButton[6];
        for (int i = 0; i < levelButtons.length; i++) {
            levelButtons[i] = new JButton("Level " + (i + 1));
            panel.add(levelButtons[i]);
        }

        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.add(backButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Menambahkan ActionListener untuk tombol "Start" pada setiap level
    public void addStartListener(ActionListener listener) {
        for (JButton levelButton : levelButtons) {
            levelButton.addActionListener(listener);
        }
    }

    // Menambahkan ActionListener untuk tombol "Back"
    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}


