package com.GUI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            com.GUI.Login login = new Login();
            login.setVisible(true);
        });
    }
}
