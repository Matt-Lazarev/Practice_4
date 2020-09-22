package ru.mirea.inbo0519.pr4;

import javax.swing.*;

public class TestFootballMatch {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new FootballMatch();
            }
        });
    }
}