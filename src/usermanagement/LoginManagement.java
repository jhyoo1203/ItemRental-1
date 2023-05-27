package usermanagement;

import itemrentalmanagement.SystemMain;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class LoginManagement extends JFrame implements ActionListener {

    private JLabel userLabel, passwordLabel, messageLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton, signUpButton;
    private JPanel idPanel, pwPanel, loginPanel, messagePanel, btnPanel;
    private ArrayList<User> userList = new ArrayList<>();
    private static final int[] idList = { 1000000, 2000000, 3000000 };


    public LoginManagement() {
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
        if (e.getSource() == loginButton)
        {
            int id = Integer.parseInt(userTextField.getText());
            String password = new String(passwordField.getPassword());

            if (isValidId(idList, id) && password.equals("0000"))
            {
                messageLabel.setForeground(Color.BLUE);
                messageLabel.setText("로그인 성공");
                dispose();
                new SystemMain(id, password);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "잘못된 ID 값입니다.", "에러", JOptionPane.ERROR_MESSAGE);
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
            // 회원가입 할 User
            User user;

            JFrame signUp = new JFrame();
            JPanel mainPanel = new JPanel();

            // User의 각 필드 값으로 넣을 Panel 추가
            JPanel namePanel, idPanel, passwordPanel, passwordConfirmPanel, agePanel, genderPanel, phoneNumberPanel, signUpConfirmPanel;
            JLabel nameLabel, idLabel, passwordLabel, passwordConfirmLabel, ageLabel, genderLabel, phoneNumberLabel, messageLabel;
            JTextField nameTextField, idTextField, ageTextField, phoneNumberTextField;
            JPasswordField passwordField, passwordConfirmField;
            JButton idConfirmButton, signUpConfirmButton;

            signUp.setTitle("회원가입");
            signUp.setSize(600, 600);
            signUp.setLocationRelativeTo(null);
            signUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // 각 라인 세로 정렬
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            // 소비자, 제공자 선택 체크박스 추가
            JPanel checkPanel = new JPanel();
            JCheckBox consumerCheckBox = new JCheckBox("소비자");
            JCheckBox providerCheckBox = new JCheckBox("제공자");
            consumerCheckBox.setPreferredSize(new Dimension(100, 30));
            providerCheckBox.setPreferredSize(new Dimension(100, 30));
            checkPanel.add(consumerCheckBox);
            checkPanel.add(providerCheckBox);
            checkPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            mainPanel.add(checkPanel);

            namePanel = new JPanel();
            nameLabel = new JLabel("이름 :");
            nameTextField = new JTextField(10);
            nameLabel.setPreferredSize(new Dimension(100, 30));
            nameTextField.setPreferredSize(new Dimension(100, 30));
            namePanel.add(nameLabel);
            namePanel.add(nameTextField);
            namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            mainPanel.add(namePanel);

            genderPanel = new JPanel();
            genderLabel = new JLabel("성별 :");
            JCheckBox maleCheckBox = new JCheckBox("남");
            JCheckBox femaleCheckBox = new JCheckBox("여");
            genderLabel.setPreferredSize(new Dimension(100, 30));
            maleCheckBox.setPreferredSize(new Dimension(100, 30));
            femaleCheckBox.setPreferredSize(new Dimension(100, 30));
            genderPanel.add(genderLabel);
            genderPanel.add(maleCheckBox);
            genderPanel.add(femaleCheckBox);
            genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            mainPanel.add(genderPanel);

            agePanel = new JPanel();
            ageLabel = new JLabel("나이 :");
            ageTextField = new JTextField(10);
            ageLabel.setPreferredSize(new Dimension(100, 30));
            ageTextField.setPreferredSize(new Dimension(100, 30));
            agePanel.add(ageLabel);
            agePanel.add(ageTextField);
            agePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            mainPanel.add(agePanel);

            phoneNumberPanel = new JPanel();
            phoneNumberLabel = new JLabel("전화번호 :");
            phoneNumberTextField = new JTextField(10);
            phoneNumberLabel.setPreferredSize(new Dimension(100, 30));
            phoneNumberTextField.setPreferredSize(new Dimension(100, 30));
            phoneNumberPanel.add(phoneNumberLabel);
            phoneNumberPanel.add(phoneNumberTextField);
            phoneNumberPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            mainPanel.add(agePanel);

            idPanel = new JPanel();
            idLabel = new JLabel("ID : ");
            idTextField = new JTextField(10);
            idConfirmButton = new JButton("중복확인");
            idLabel.setPreferredSize(new Dimension(100, 30));
            idTextField.setPreferredSize(new Dimension(100, 30));
            idConfirmButton.setPreferredSize(new Dimension(100, 30));
            idPanel.add(idLabel);
            idPanel.add(idTextField);
            idPanel.add(idConfirmButton);
            idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            mainPanel.add(idPanel);

            passwordPanel = new JPanel();
            passwordLabel = new JLabel("비밀번호 : ");
            passwordField = new JPasswordField(15);
            passwordLabel.setPreferredSize(new Dimension(100, 30));
            passwordField.setPreferredSize(new Dimension(100, 30));
            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordField);
            passwordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            mainPanel.add(passwordPanel);

            passwordConfirmPanel = new JPanel();
            passwordConfirmLabel = new JLabel("비밀번호 확인 : ");
            messageLabel = new JLabel();
            passwordConfirmField = new JPasswordField(15);
            passwordConfirmLabel.setPreferredSize(new Dimension(100, 30));
            messageLabel.setPreferredSize(new Dimension(130, 30));
            passwordConfirmField.setPreferredSize(new Dimension(100, 30));
            passwordConfirmPanel.add(passwordConfirmLabel);
            passwordConfirmPanel.add(passwordConfirmField);
            passwordConfirmPanel.add(messageLabel);
            passwordConfirmPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            mainPanel.add(passwordConfirmPanel);

            signUpConfirmPanel = new JPanel();
            signUpConfirmButton = new JButton("가입하기");
            signUpConfirmButton.setPreferredSize(new Dimension(100, 30));
            signUpConfirmPanel.add(signUpConfirmButton);
            mainPanel.add(signUpConfirmPanel);

            signUp.add(mainPanel);
            signUp.setVisible(true);

            // 비밀번호 확인이 옳은 지 표시 함.
            passwordConfirmField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    validatePasswordConfirmation();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    validatePasswordConfirmation();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    validatePasswordConfirmation();
                }

                void validatePasswordConfirmation() {
                    String password = new String(passwordField.getPassword());
                    String confirmPassword = new String(passwordConfirmField.getPassword());

                    if (!password.equals(confirmPassword)) {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("동일하지 않습니다.");
                    } else {
                        messageLabel.setForeground(Color.BLUE);
                        messageLabel.setText("동일합니다.");
                    }
                }
            });

            ItemListener checkBoxItemListener = itemEvent -> {
                boolean consumerSelected = consumerCheckBox.isSelected();
                boolean providerSelected = providerCheckBox.isSelected();
                boolean maleSelected = maleCheckBox.isSelected();
                boolean femaleSelected = femaleCheckBox.isSelected();

                consumerCheckBox.setEnabled(!providerSelected);
                providerCheckBox.setEnabled(!consumerSelected);
                maleCheckBox.setEnabled(!femaleSelected);
                femaleCheckBox.setEnabled(!maleSelected);
            };

            consumerCheckBox.addItemListener(checkBoxItemListener);
            providerCheckBox.addItemListener(checkBoxItemListener);
            maleCheckBox.addItemListener(checkBoxItemListener);
            femaleCheckBox.addItemListener(checkBoxItemListener);
        }
    }

    public boolean isValidId(int[] idList, int id){
        for(int i : idList){
            if(i == id) return true;
        }
        return false;
    }
}