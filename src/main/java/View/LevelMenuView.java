/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelMenuView extends JFrame {
    private JButton[] levelButtons;
    private JButton backButton;

    public LevelMenuView() {
        setTitle("AniApp - Level Menu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        levelButtons = new JButton[6];

        for (int i = 0; i < 6; i++) {
            levelButtons[i] = new JButton("Level " + (i + 1));
            panel.add(levelButtons[i]);
        }

        backButton = new JButton("Back");
        panel.add(backButton);

        add(panel);
    }

    public void addLevelButtonListener(int level, ActionListener listener) {
        levelButtons[level - 1].addActionListener(listener);
    }

    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}




