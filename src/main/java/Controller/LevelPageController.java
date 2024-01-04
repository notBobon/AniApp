/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.LevelMenuView;
import View.LevelPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelPageController {
    private LevelPageView levelPageView;

    public LevelPageController(LevelPageView levelPageView) {
        this.levelPageView = levelPageView;

        // Mengatur aksi untuk tombol "Back to Menu", "Back", dan "Next"
        this.levelPageView.addBackToMenuListener(new BackToMenuListener());
        this.levelPageView.addBackListener(new BackListener());
        this.levelPageView.addNextListener(new NextListener());

        // Mengatur aksi untuk flip card hewan
        this.levelPageView.addCardClickListener(new CardClickListener());
    }

    // ActionListener untuk tombol "Back to Menu"
    private class BackToMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mengatur logika untuk kembali ke Level Menu
            LevelMenuView levelMenuView = new LevelMenuView();
            LevelMenuController levelMenuController = new LevelMenuController(levelMenuView);
            levelMenuView.setVisible(true);
            levelPageView.dispose(); // Menutup halaman Level Page
        }
    }

    // ActionListener untuk tombol "Back"
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mengatur logika untuk kembali ke hewan sebelumnya
            levelPageView.showPreviousAnimal();
        }
    }

    // ActionListener untuk tombol "Next"
    private class NextListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mengatur logika untuk pindah ke hewan selanjutnya
            levelPageView.showNextAnimal();
        }
    }

    // ActionListener untuk flip card hewan
    private class CardClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mengatur logika untuk menampilkan informasi lebih detail hewan
            levelPageView.showDetailedInfo();
        }
    }
}




