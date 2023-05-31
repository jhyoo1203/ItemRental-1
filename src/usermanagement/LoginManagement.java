package usermanagement;

import itemrentalmanagement.SystemMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LoginManagement extends JFrame implements ActionListener {

    private JLabel userLabel, passwordLabel, messageLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton, signUpButton;
    private JPanel idPanel, pwPanel, loginPanel, messagePanel, btnPanel;

    // 회원가입한 User 삽입 예정. -> Join에서 받아 .txt 파일로 관리
    public static ArrayList<User> userList = new ArrayList<>();

    public LoginManagement() {
        loadUserList();

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
        signUpButton = new JButton("회원가입");

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
        btnPanel.add(signUpButton);
        loginButton.setPreferredSize(new Dimension(100, 30));
        resetButton.setPreferredSize(new Dimension(100, 30));
        signUpButton.setPreferredSize(new Dimension(100, 30));

        add(loginPanel, "North");
        add(messagePanel, "Center");
        add(btnPanel, "South");

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        signUpButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton){
            User user = searchUser(Integer.parseInt(userTextField.getText()));

            if(user != null){
                messageLabel.setForeground(Color.BLUE);
                messageLabel.setText("로그인 성공");
                dispose();
                new SystemMain(user);
            }
            else {
                JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인하세요.", "에러", JOptionPane.ERROR_MESSAGE);
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("다시 시도하세요.");
            }
        }
        else if(e.getSource() == resetButton)
        {
            userTextField.setText("");
            passwordField.setText("");
            messageLabel.setText("");
        }
        else if(e.getSource() == signUpButton)
        {
            new Join();
        }
    }

    public static void writeUserData(User user) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/resources/userList.txt", true));
            bw.write(user.toString());
            bw.newLine();
            bw.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadUserList(){
        BufferedReader br = null;
        String data = null;
        StringTokenizer st = null;
        try {
            br = new BufferedReader(new FileReader("src/resources/userList.txt"));
            while((data = br.readLine()) != null){
                st = new StringTokenizer(data, ",");

                String classify = st.nextToken();
                int id = Integer.parseInt(st.nextToken());
                String password = st.nextToken();
                String name = st.nextToken();
                int age = Integer.parseInt(st.nextToken());
                String gender = st.nextToken();
                String phoneNumber = st.nextToken();

                userList.add(new User(classify, id, password, name, age, gender, phoneNumber));
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User searchUser(int id) {
        for(User user : userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public static void showUserList(){

    }
}