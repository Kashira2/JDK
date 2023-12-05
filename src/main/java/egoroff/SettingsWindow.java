package egoroff;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    JPanel panBottom;

    JButton btnStart = new JButton("Start new game");

    JLabel gameMode = new JLabel("Выберите режим игры");
    JLabel gameField = new JLabel("Установите размер поля:\n");
    JLabel winField = new JLabel("Установите длину для победы:\n");
    JSlider sizeMap = new JSlider(3, 10);
    JSlider sizeWin = new JSlider(3, 10);
    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека");
    ButtonGroup buttonGroup = new ButtonGroup();
    SettingsWindow(GameWindow gameWindow){
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panBottom = new JPanel(new GridLayout(11, 1));

        buttonGroup.add(humanVsAi);
        buttonGroup.add(humanVsHuman);

        panBottom.add(gameMode);
        panBottom.add(humanVsHuman);
        panBottom.add(humanVsAi);
        panBottom.add(gameField);
        panBottom.add(sizeMap);
        panBottom.add(winField);
        panBottom.add(sizeWin);
        humanVsAi.setSelected(true);

        panBottom.add(btnStart);

        sizeMap.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameField.setText("Установите размер поля:\n" + sizeMap.getValue());
            }
        });

        sizeWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winField.setText("Установите длину для победы:\n" + sizeWin.getValue());
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    gameWindow.startNewGame(humanVsAi.isSelected()?0:1,
                            sizeMap.getValue(), sizeMap.getValue(), sizeWin.getValue());
                    setVisible(false);
            }
        });
        add(panBottom);
//        add(btnStart);
    }
}
