/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelPageController {
    private LevelPageView levelPageView;
    private int level;

    public LevelPageController(LevelPageView levelPageView, int level) {
        this.levelPageView = levelPageView;
        this.level = level;

        levelPageView.addBackListener(new BackListener());
        levelPageView.addNextListener(new NextListener());
        levelPageView.setLevelLabel("Level " + level);
    }

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk kembali ke halaman level menu.
            LevelMenuView levelMenuView = new LevelMenuView();
            LevelMenuController levelMenuController = new LevelMenuController(levelMenuView);
            levelMenuView.addBackListener(new BackListener(levelMenuView));
            levelMenuView.setVisible(true);
            levelPageView.dispose(); // Tutup halaman level.
        }
    }

    private class NextListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk lanjut ke level berikutnya.
            int nextLevel = level + 1;

            // Contoh: Tampilkan halaman LevelPageView untuk level berikutnya.
            LevelPageView nextLevelPageView = new LevelPageView(nextLevel);
            LevelPageController nextLevelPageController = new LevelPageController(nextLevelPageView, nextLevel);
            nextLevelPageView.addBackListener(new BackListener());
            nextLevelPageView.addNextListener(new NextListener());
            nextLevelPageView.setVisible(true);
            levelPageView.dispose(); // Tutup halaman level sekarang.
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
            // Logika untuk kembali ke halaman sebelumnya (level menu atau main menu).
            if (levelMenuView != null) {
                levelMenuView.setVisible(true);
                levelPageView.dispose(); // Tutup halaman level.
            } else {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuController mainMenuController = new MainMenuController(mainMenuView);
                mainMenuView.setVisible(true);
            }
        }
    }
}




