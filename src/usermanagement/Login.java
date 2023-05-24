package usermanagement;

import itemrentalmanagement.SystemMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    private JLabel userLabel, passwordLabel, messageLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;
    private JPanel idPanel, pwPanel, loginPanel, messagePanel, btnPanel;
    private static final int[] idList = { 1000000, 2000000, 3000000 };


    public Login() {
        setTitle("물품 대여 시스템 로그인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        userLabel = new JLabel("ID :");
        passwordLabel = new JLabel("PW :");
        messageLabel = new JLabel();

        userTextField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton("로그인");
        resetButton = new JButton("초기화");

        idPanel = new JPanel();
        idPanel.add(userLabel);
        idPanel.add(userTextField);
        userLabel.setPreferredSize(new Dimension(100, 30));
        userTextField.setPreferredSize(new Dimension(150, 30));

        pwPanel = new JPanel();
        pwPanel.add(passwordLabel);
        pwPanel.add(passwordField);
        passwordLabel.setPreferredSize(new Dimension(100, 30));
        passwordField.setPreferredSize(new Dimension(150, 30));

        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());
        loginPanel.setPreferredSize(new Dimension(150, 100));
        loginPanel.add(idPanel);
        loginPanel.add(pwPanel);


        messagePanel = new JPanel();
        messagePanel.add(messageLabel);
        messageLabel.setPreferredSize(new Dimension(100, 30));

        btnPanel = new JPanel();
        btnPanel.add(loginButton);
        btnPanel.add(resetButton);
        loginButton.setPreferredSize(new Dimension(100, 30));
        resetButton.setPreferredSize(new Dimension(100, 30));

        add(loginPanel, "North");
        add(messagePanel, "Center");
        add(btnPanel, "South");

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            int id = Integer.parseInt(userTextField.getText());
            String password = new String(passwordField.getPassword());

            if (isValidId(idList, id) && password.equals("0000")) {
                messageLabel.setForeground(Color.BLUE);
                messageLabel.setText("로그인 성공");
                dispose();
                new SystemMain(id, password);
            } else {
                JOptionPane.showMessageDialog(null, "잘못된 ID 값입니다.", "에러", JOptionPane.ERROR_MESSAGE);
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("다시 시도하세요.");
            }
        } else {
            userTextField.setText("");
            passwordField.setText("");
            messageLabel.setText("");
        }
    }

    public boolean isValidId(int[] idList, int id){
        for(int i : idList){
            if(i == id) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Login();
    }
}