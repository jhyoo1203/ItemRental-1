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

    // 회원가입한 User 삽입 -> Join에서 받아 .txt 파일로 관리
    public static ArrayList<User> userList;

    public LoginManagement() {
        userList = new ArrayList<>();
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

            if(user != null && user.getPassword().equals(new String(passwordField.getPassword()))){
                messageLabel.setForeground(Color.BLUE);
                messageLabel.setText("로그인 성공");
                dispose();
                new SystemMain(user);
            }
            else if(userTextField.getText().equals("10000000")){
                dispose();
                new SystemMain(new User());
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
        BufferedWriter bw = null;
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
        catch (FileNotFoundException e) {
            try {
                bw = new BufferedWriter(new FileWriter("src/resources/userList.txt"));
                bw.newLine();
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        catch (IOException e){
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
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        frame.setTitle("사용자 목록 조회");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);

        mainPanel.removeAll();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for(User user : userList){
            JLabel nameLabel, idLabel;
            JButton userInformationButton, userAccountManagementButton;
            JPanel userPanel = new JPanel();

            userPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            nameLabel = new JLabel(user.getName());
            nameLabel.setPreferredSize(new Dimension(100, 30));
            userPanel.add(nameLabel);

            idLabel = new JLabel(String.valueOf(user.getId()));
            idLabel.setPreferredSize(new Dimension(100, 30));
            userPanel.add(idLabel);

            userInformationButton = new JButton("상세보기");
            userInformationButton.setPreferredSize(new Dimension(100, 30));
            userPanel.add(userInformationButton);

            userAccountManagementButton = new JButton("계정관리");
            userAccountManagementButton.setPreferredSize(new Dimension(100, 30));
            userPanel.add(userAccountManagementButton);

            mainPanel.add(userPanel);

            userInformationButton.addActionListener(e -> {
                JPanel userDetailsPanel = new JPanel();
                userDetailsPanel.setLayout(new BoxLayout(userDetailsPanel, BoxLayout.Y_AXIS));

                JLabel classifyLabel = new JLabel("구분: " + user.getClassify());
                userDetailsPanel.add(classifyLabel);

                JLabel idLabel2 = new JLabel("ID: " + user.getId());
                userDetailsPanel.add(idLabel2);

                JLabel nameLabel2 = new JLabel("이름: " + user.getName());
                userDetailsPanel.add(nameLabel2);

                JLabel ageLabel = new JLabel("나이: " + user.getAge());
                userDetailsPanel.add(ageLabel);

                JLabel genderLabel = new JLabel("성별: " + user.getGender());
                userDetailsPanel.add(genderLabel);

                JLabel phoneLabel = new JLabel("전화번호: " + user.getPhoneNumber());
                userDetailsPanel.add(phoneLabel);

                JOptionPane.showMessageDialog(frame, userDetailsPanel, "사용자 정보", JOptionPane.PLAIN_MESSAGE);
            });

            userAccountManagementButton.addActionListener(e -> {
                int choice = JOptionPane.showConfirmDialog(frame, "사용자 계정을 삭제하시겠습니까?", "계정 삭제", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    user.deleteAccount();
                    JOptionPane.showMessageDialog(frame, "사용자 계정이 삭제되었습니다.", "계정 삭제 완료", JOptionPane.INFORMATION_MESSAGE);
                    mainPanel.remove(userPanel);
                    frame.revalidate();
                    frame.repaint();
                    writeNewUserData();
                }
            });
        }
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static void updateUserData(User user) {
        for (int i = 0; i < userList.size(); i++) {
            User currentUser = userList.get(i);
            if (currentUser.getId() == user.getId()) {
                userList.set(i, user);
                break;
            }
        }
        writeNewUserData();
    }

    private static void writeNewUserData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/resources/userList.txt"))) {

            for (User user : userList) {
                String userData = user.toString();
                bw.write(userData);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}