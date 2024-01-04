/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.LevelMenuView;
import View.LevelPageView;
import View.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelMenuController {
    private LevelMenuView levelMenuView;

    public LevelMenuController(LevelMenuView levelMenuView) {
        this.levelMenuView = levelMenuView;

        // Mengatur aksi untuk tombol "Start" dan "Back"
        this.levelMenuView.addStartListener(new StartListener());
        this.levelMenuView.addBackListener(new BackListener());
    }

    // ActionListener untuk tombol "Start"
    private class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mengatur logika untuk memulai level, misalnya pindah ke halaman Level
            LevelPageView levelPageView = new LevelPageView();
            LevelPageController levelPageController = new LevelPageController(levelPageView);
            levelPageView.setVisible(true);
            levelMenuView.dispose(); // Menutup halaman Level Menu
        }
    }

    // ActionListener untuk tombol "Back"
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mengatur logika untuk kembali ke Main Menu
            MainMenuView mainMenuView = new MainMenuView();
            MainMenuController mainMenuController = new MainMenuController(mainMenuView);
            mainMenuView.setVisible(true);
            levelMenuView.dispose(); // Menutup halaman Level Menu
        }
    }
}


