/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.MainMenuView;
import View.LevelMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    private MainMenuView mainMenuView;

    public MainMenuController(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;

        mainMenuView.addStartListener(new StartListener());
        mainMenuView.addExitListener(new ExitListener());
    }

    private class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk pindah ke halaman pemilihan level.
            // Contoh: Tampilkan halaman LevelMenuView.
            LevelMenuView levelMenuView = new LevelMenuView();
            LevelMenuController levelMenuController = new LevelMenuController(levelMenuView);
            levelMenuView.addBackListener(new BackListener(levelMenuView, mainMenuView)); // Tambahkan listener back.
            levelMenuView.setVisible(true);
            mainMenuView.dispose(); // Tutup halaman main menu.
        }
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk keluar dari aplikasi.
            System.exit(0);
        }
    }

    // Kelas listener tambahan untuk tombol "Back" di halaman level menu.
    private class BackListener implements ActionListener {
        private LevelMenuView levelMenuView;
        private MainMenuView mainMenuView;

        public BackListener(LevelMenuView levelMenuView, MainMenuView mainMenuView) {
            this.levelMenuView = levelMenuView;
            this.mainMenuView = mainMenuView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk kembali ke halaman main menu dari halaman level menu.
            mainMenuView.setVisible(true);
            levelMenuView.dispose(); // Tutup halaman level menu.
        }
    }
}


