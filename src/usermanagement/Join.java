package usermanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class Join {
    public Join() {
        JFrame signUp = new JFrame();
        JPanel mainPanel = new JPanel();

        // User의 각 필드 값으로 넣을 Panel 추가
        JPanel namePanel, idPanel, passwordPanel, passwordConfirmPanel, agePanel, genderPanel, phoneNumberPanel, signUpConfirmPanel;
        JLabel nameLabel, idLabel, passwordLabel, passwordConfirmLabel, ageLabel, genderLabel, phoneNumberLabel, messageLabel, idConfirmMessageLabel;
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
        mainPanel.add(phoneNumberPanel);

        idPanel = new JPanel();
        idLabel = new JLabel("ID : ");
        idTextField = new JTextField(10);
        idConfirmButton = new JButton("중복확인");
        idConfirmMessageLabel = new JLabel();
        idLabel.setPreferredSize(new Dimension(100, 30));
        idTextField.setPreferredSize(new Dimension(100, 30));
        idConfirmButton.setPreferredSize(new Dimension(100, 30));
        idConfirmMessageLabel.setPreferredSize(new Dimension(200, 30));
        idPanel.add(idLabel);
        idPanel.add(idTextField);
        idPanel.add(idConfirmButton);
        idPanel.add(idConfirmMessageLabel);
        idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(idPanel);

        // ID 값 8글자로 제한
        AbstractDocument idDocument = (AbstractDocument) idTextField.getDocument();
        idDocument.setDocumentFilter(new DocumentFilter() {
            private int maxCharacters = 8;

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
                int currentLength = fb.getDocument().getLength();
                int overLimit = (currentLength + text.length()) - maxCharacters - length;

                if (overLimit > 0) {
                    text = text.substring(0, text.length() - overLimit);
                }

                if (text.length() > 0) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

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

            // 소비자를 선택했을 경우, 자동으로 맨 앞에 '2'를 추가함.
            if(consumerSelected){
                idTextField.setText("2");
                idConfirmMessageLabel.setForeground(Color.RED);
                idConfirmMessageLabel.setText("ID가 '2'로 시작해야 합니다.");
            }
            // 제공자를 선택했을 경우, 자동으로 맨 앞에 '3'을 추가함.
            else if(providerSelected){
                idTextField.setText("3");
                idConfirmMessageLabel.setForeground(Color.RED);
                idConfirmMessageLabel.setText("ID가 '3'으로 시작해야 합니다.");
            }

            consumerCheckBox.setEnabled(!providerSelected);
            providerCheckBox.setEnabled(!consumerSelected);
            maleCheckBox.setEnabled(!femaleSelected);
            femaleCheckBox.setEnabled(!maleSelected);
        };

        consumerCheckBox.addItemListener(checkBoxItemListener);
        providerCheckBox.addItemListener(checkBoxItemListener);
        maleCheckBox.addItemListener(checkBoxItemListener);
        femaleCheckBox.addItemListener(checkBoxItemListener);

        idConfirmButton.addActionListener(e -> {
            User user = LoginManagement.searchUser(Integer.parseInt(idTextField.getText()));
            if(user == null){
                JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.", "확인", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "에러", JOptionPane.ERROR_MESSAGE);
            }
        });

        signUpConfirmButton.addActionListener(e -> {
            if (e.getSource() == signUpConfirmButton) {
                String classify = consumerCheckBox.isSelected() ? "소비자" : "제공자";
                int id = Integer.parseInt(idTextField.getText());
                String password = new String(passwordField.getPassword());
                String name = nameTextField.getText();
                int age = Integer.parseInt(ageTextField.getText());
                String gender = maleCheckBox.isSelected() ? "남자" : "여자";
                String phoneNumber = phoneNumberTextField.getText();

                User user = new User(classify, id, password, name, age, gender, phoneNumber);
                LoginManagement.userList.add(user);
                LoginManagement.writeUserData(user);

                JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.", "확인", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}