package egoroff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 800;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JPanel panelServer = new JPanel(new GridLayout(6, 2));
    JPanel panelSms = new JPanel(new GridLayout(5,1));

    JButton btnSend = new JButton("Send sms");

    JLabel lblLogin = new JLabel("Login");
    JLabel lblPassword = new JLabel("Password");
    JLabel lblIp = new JLabel("IP");
    JLabel lblMassage = new JLabel("Massage");

    JTextField txtFieldLogin = new JTextField();
    JTextField txtFieldPassword = new JTextField();
    JTextField txtFieldIp = new JTextField();
    JTextField txtFieldMassage = new JTextField();
    JTextArea areaText = new JTextArea();

    String login;
    String password;
    String ip;
    String massage;

    char [] log = new char[500];

    Chat()throws IOException{
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat");
        setResizable(false);


        FileReader reader = new FileReader("loger.txt");
        FileWriter writer = new FileWriter("loger.txt", true);
        reader.read(log);
        for (char c: log) {
            areaText.append(String.valueOf(c));
        }
        reader.close();

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = txtFieldLogin.getText();
                massage = login + ": " + txtFieldMassage.getText() + "\n";
                areaText.append(massage);
                System.out.println("Отправлено сообщение: " + massage);

                try {
                    writer.write(massage);
                    writer.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        txtFieldMassage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login = txtFieldLogin.getText();
                    massage = login + ": " + txtFieldMassage.getText() + "\n";
                    areaText.append(massage);
                    System.out.println("Отправлено сообщение: " + massage);

                    try {
                        writer.write(massage);
                        writer.flush();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        panelServer.add(lblLogin);
        panelServer.add(txtFieldLogin);
        panelServer.add(lblPassword);
        panelServer.add(txtFieldPassword);
        panelServer.add(lblIp);
        panelServer.add(txtFieldIp);

        panelSms.add(lblMassage);
        panelSms.add(txtFieldMassage);
        panelSms.add(btnSend);
        panelSms.add(areaText);

        add(panelServer, BorderLayout.NORTH);
        add(panelSms, BorderLayout.SOUTH);

        setLayout(new GridLayout(2,1));
        setVisible(true);

    }
}
