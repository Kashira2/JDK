package egoroff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loger extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;


    JPanel panBottom;
    JButton btnStart = new JButton("Start server");
    JButton btnExit = new JButton("Stop server");

    boolean isServerWorking = true;
    Loger(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Loger");
        setResizable(false);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isServerWorking){
                    isServerWorking = false;
                    System.out.println("Сервер выключен");
                }else System.out.println("Сервер уже не работает");
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isServerWorking){
                    isServerWorking = true;
                    System.out.println("Запущен");
                }else System.out.println("Сервер уже работает");
            }
        });
        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnExit);
        setVisible(true);
    }
}
