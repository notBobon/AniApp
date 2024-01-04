/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelMenuController {
    private LevelMenuView levelMenuView;

    public LevelMenuController(LevelMenuView levelMenuView) {
        this.levelMenuView = levelMenuView;

        for (int i = 0; i < 6; i++) {
            final int level = i + 1;
            levelMenuView.addLevelButtonListener(level, new LevelButtonListener(level));
        }

        levelMenuView.addBackListener(new BackListener());
    }

    private class LevelButtonListener implements ActionListener {
        private int level;

        public LevelButtonListener(int level) {
            this.level = level;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk memulai level tertentu.
            // Contoh: Tampilkan halaman LevelPageView untuk level yang dipilih.
            LevelPageView levelPageView = new LevelPageView(level);
            LevelPageController levelPageController = new LevelPageController(levelPageView, level);
            levelPageView.addBackListener(new BackListener(levelMenuView));
            levelPageView.setVisible(true);
            levelMenuView.dispose(); // Tutup halaman level menu.
        }
    }

    private class BackListener implements ActionListener {
        private LevelMenuView levelMenuView;

        public BackListener() {
        }

        public BackListener(LevelMenuView levelMenuView) {
            this.levelMenuView = levelMenuView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk kembali ke halaman sebelumnya (main menu atau level menu).
            if (levelMenuView != null) {
                levelMenuView.setVisible(true);
                levelMenuView.dispose(); // Tutup halaman level menu.
            } else {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuController mainMenuController = new MainMenuController(mainMenuView);
                mainMenuView.setVisible(true);
            }
        }
    }
}




