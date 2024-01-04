/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelPageView extends JFrame {
    private JLabel levelLabel;
    private JButton backButton;
    private JButton nextButton;

    public LevelPageView(int level) {
        setTitle("AniApp - Level " + level);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        levelLabel = new JLabel("Level " + level, SwingConstants.CENTER);
        backButton = new JButton("Back");
        nextButton = new JButton("Next");

        panel.add(levelLabel);
        panel.add(backButton);
        panel.add(nextButton);

        add(panel);
    }

    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addNextListener(ActionListener listener) {
        nextButton.addActionListener(listener);
    }

    public void setLevelLabel(String levelText) {
        levelLabel.setText(levelText);
    }
}


