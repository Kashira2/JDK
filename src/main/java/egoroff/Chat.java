package egoroff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JPanel panelServer = new JPanel(new GridLayout(6, 2));
    JPanel panelSms = new JPanel(new GridLayout(5,1));

    JButton btnSend = new JButton("Send sms");
    JButton btnExit = new JButton("Exit");

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


    Chat(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat");
        setResizable(false);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = txtFieldLogin.getText();
                massage = login + ": " + txtFieldMassage.getText() + "\n";
                areaText.append(massage);
                System.out.println("Отправлено сообщение: " + massage);
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
