/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LevelPageView extends JFrame {
    private JLabel animalImageLabel;
    private JButton backButton;
    private JButton nextButton;
    private JButton backToMenuButton;
    private JButton flipCardButton;

    // Dummy data untuk contoh
    private String[] animalNames = {"Lion", "Elephant", "Monkey", "Giraffe"};
    private int currentAnimalIndex;

    public LevelPageView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("AniApp - Level Page");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        animalImageLabel = new JLabel("Animal Image Here", SwingConstants.CENTER);
        panel.add(animalImageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        backButton = new JButton("Back");
        nextButton = new JButton("Next");
        backToMenuButton = new JButton("Back to Menu");
        flipCardButton = new JButton("Flip Card");

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(backToMenuButton);
        buttonPanel.add(flipCardButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    // Menambahkan ActionListener untuk tombol "Back to Menu"
    public void addBackToMenuListener(ActionListener listener) {
        backToMenuButton.addActionListener(listener);
    }

    // Menambahkan ActionListener untuk tombol "Back"
    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    // Menambahkan ActionListener untuk tombol "Next"
    public void addNextListener(ActionListener listener) {
        nextButton.addActionListener(listener);
    }

    // Menambahkan ActionListener untuk flip card hewan
    public void addCardClickListener(ActionListener listener) {
        flipCardButton.addActionListener(listener);
    }

    // Menampilkan hewan selanjutnya
    public void showNextAnimal() {
        currentAnimalIndex = (currentAnimalIndex + 1) % animalNames.length;
        updateAnimalImageLabel();
    }

    // Menampilkan hewan sebelumnya
    public void showPreviousAnimal() {
        currentAnimalIndex = (currentAnimalIndex - 1 + animalNames.length) % animalNames.length;
        updateAnimalImageLabel();
    }

    // Menampilkan informasi lebih detail hewan (contoh)
    public void showDetailedInfo() {
        // Mengganti dengan logika untuk menampilkan informasi lebih detail hewan
        JOptionPane.showMessageDialog(this, "Detailed information about " + animalNames[currentAnimalIndex]);
    }

    // Memperbarui label gambar hewan (contoh)
    private void updateAnimalImageLabel() {
        animalImageLabel.setText("Image of " + animalNames[currentAnimalIndex]);
    }
}

