package ru.mirea.inbo0519.pr4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FootballMatch
{
    private final int SIZE = 6;
    private final int ROWS = 2;
    private final int COLS = 3;
    private final int TIME = 90;
    private JPanel[] jpnl = new JPanel[SIZE];
    private JLabel lastScored;
    private JLabel score;
    private JLabel timerMin;
    private JLabel winner;
    private int RM = 0;
    private int ACM = 0;
    private int time = 0;
    private Timer timer;
    FootballMatch()  {
        Font font = new Font("Verdana", Font.PLAIN, 20);
        Font fontScore = new Font("Verdana", Font.PLAIN, 16);
        JFrame jfrm = new JFrame("Football match");
        jfrm.setLayout(new GridLayout(ROWS, COLS));
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(950, 350);
        jfrm.setMinimumSize(new Dimension(900, 300));

        JButton jbntRM = new JButton("Real Madrid");
        jbntRM.setPreferredSize(new Dimension(200,50));
        jbntRM.setFont(font);

        JButton jbntACM = new JButton("AC Milan");
        jbntACM.setPreferredSize(new Dimension(200,50));
        jbntACM.setFont(font);

        for(int i=0; i<SIZE; i++)
        {
            int r = 165;
            int b = 222;
            int g = 222;
            jpnl[i] = new JPanel();
            jfrm.add(jpnl[i]);
            jpnl[i].setBackground(new Color(r,g,b));
        }
        jpnl[3].setLayout(new FlowLayout());
        jpnl[3].add(jbntRM);

        jpnl[5].setLayout(new FlowLayout());
        jpnl[5].add(jbntACM);

        score = new JLabel("Real Madrid - " + RM + "  " + ACM + " - AC Milan");
        lastScored = new JLabel("Last scored: null");
        timerMin = new JLabel("Time: " + time);
        winner = new JLabel();

        lastScored.setFont(fontScore);
        score.setFont(fontScore);
        timerMin.setFont(font);
        winner.setFont(font);
        jpnl[0].add(lastScored);
        jpnl[4].add(score);
        jpnl[2].add(timerMin);
        jpnl[1].add(winner);

        jbntRM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                lastScored.setText("Last scored: Real Madrid");
                RM++;
                score.setText("Real Madrid - " + RM + "  " + ACM + " - AC Milan");
            }
        });

        jbntACM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                lastScored.setText("Last scored: AC Milan");
                ACM++;
                score.setText("Real Madrid - " + RM + "  " + ACM + " - AC Milan");
            }
        });

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(time<=TIME) {
                    timerMin.setText("Time: " + time);
                    time++;
                }
                else{
                    if(RM>ACM)
                    {
                        winner.setText("<html> <p align=\"center\">Match is over<br>Real Madrid won </p>  </html>");
                        jbntACM.setEnabled(false);
                        jbntRM.setEnabled(false);
                    }

                    else if(RM<ACM)
                    {
                        winner.setText("<html> <p align=\"center\">Match is over<br>AC Milan won </p> </html>");
                        jbntACM.setEnabled(false);
                        jbntRM.setEnabled(false);
                    }
                    else
                    {
                        winner.setText("<html> <p align=\"center\">Match is over<br>The draw! </p> </html>");
                        jbntACM.setEnabled(false);
                        jbntRM.setEnabled(false);
                    }
                }
            }
        });
        timer.start();
        jfrm.setVisible(true);
    }
}
