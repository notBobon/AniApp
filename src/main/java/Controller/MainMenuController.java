/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.LevelMenuView;
import View.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    private MainMenuView mainMenuView;

    public MainMenuController(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;

        // Mengatur aksi untuk tombol "Start" dan "Exit"
        this.mainMenuView.addStartListener(new StartListener());
        this.mainMenuView.addExitListener(new ExitListener());
    }

    // ActionListener untuk tombol "Start"
    private class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mengatur logika untuk memulai aplikasi AniApp, misalnya pindah ke halaman Level Menu
            LevelMenuView levelMenuView = new LevelMenuView();
            LevelMenuController levelMenuController = new LevelMenuController(levelMenuView);
            levelMenuView.setVisible(true);
            mainMenuView.dispose(); // Menutup halaman Main Menu
        }
    }

    // ActionListener untuk tombol "Exit"
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mengatur logika untuk keluar dari aplikasi
            System.exit(0);
        }
    }
}


