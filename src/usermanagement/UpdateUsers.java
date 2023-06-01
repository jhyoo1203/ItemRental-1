package usermanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UpdateUsers {
    private User user;

    public UpdateUsers(int userId) {
        JFrame update = new JFrame();
        JPanel mainPanel = new JPanel();

        // User의 각 필드 값으로 넣을 Panel 추가
        JPanel namePanel, idPanel, passwordPanel, passwordConfirmPanel, agePanel, genderPanel, phoneNumberPanel, updateConfirmPanel;
        JLabel nameLabel, idLabel, passwordLabel, passwordConfirmLabel, ageLabel, genderLabel, phoneNumberLabel, messageLabel;
        JTextField nameTextField, idTextField, ageTextField, phoneNumberTextField;
        JPasswordField passwordField, passwordConfirmField;
        JButton updateButton;
        

        update.setTitle("회원 정보 수정");
        update.setSize(600, 600);
        update.setLocationRelativeTo(null);
        update.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 각 라인 세로 정렬
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        user = LoginManagement.searchUser(userId);

        // 소비자, 제공자 선택 체크박스 추가
        JPanel checkPanel = new JPanel();
        JCheckBox consumerCheckBox = new JCheckBox("소비자");
        JCheckBox providerCheckBox = new JCheckBox("제공자");
        consumerCheckBox.setPreferredSize(new Dimension(100, 30));
        providerCheckBox.setPreferredSize(new Dimension(100, 30));
        checkPanel.add(consumerCheckBox);
        checkPanel.add(providerCheckBox);
        if (user.getClassify().equals("소비자")) {
            consumerCheckBox.setSelected(true);
        }
        else {
            providerCheckBox.setSelected(true);
        }
        consumerCheckBox.setEnabled(false);
        providerCheckBox.setEnabled(false);
        checkPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(checkPanel);


        namePanel = new JPanel();
        nameLabel = new JLabel("이름 :");
        nameTextField = new JTextField(10);
        nameLabel.setPreferredSize(new Dimension(100, 30));
        nameTextField.setPreferredSize(new Dimension(100, 30));
        nameTextField.setText(user.getName());
        nameTextField.setEnabled(false);
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
        if (user.getGender().equals("남")) {
            maleCheckBox.setSelected(true);
        }
        else {
            femaleCheckBox.setSelected(true);
        }
        maleCheckBox.setEnabled(false);
        femaleCheckBox.setEnabled(false);
        genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(genderPanel);

        agePanel = new JPanel();
        ageLabel = new JLabel("나이 :");
        ageTextField = new JTextField(10);
        ageLabel.setPreferredSize(new Dimension(100, 30));
        ageTextField.setPreferredSize(new Dimension(100, 30));
        agePanel.add(ageLabel);
        agePanel.add(ageTextField);
        ageTextField.setText(Integer.toString(user.getAge()));
        agePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(agePanel);

        phoneNumberPanel = new JPanel();
        phoneNumberLabel = new JLabel("전화번호 :");
        phoneNumberTextField = new JTextField(10);
        phoneNumberLabel.setPreferredSize(new Dimension(100, 30));
        phoneNumberTextField.setPreferredSize(new Dimension(100, 30));
        phoneNumberPanel.add(phoneNumberLabel);
        phoneNumberPanel.add(phoneNumberTextField);
        phoneNumberTextField.setText(user.getPhoneNumber());
        phoneNumberPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(phoneNumberPanel);

        idPanel = new JPanel();
        idLabel = new JLabel("ID : ");
        idTextField = new JTextField(10);
        idLabel.setPreferredSize(new Dimension(100, 30));
        idTextField.setPreferredSize(new Dimension(100, 30));
        idPanel.add(idLabel);
        idPanel.add(idTextField);
        idTextField.setText(Integer.toString(user.getId()));
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

        updateConfirmPanel = new JPanel();
        updateButton = new JButton("수정");
        updateButton.setPreferredSize(new Dimension(100, 30));
        updateConfirmPanel.add(updateButton);
        mainPanel.add(updateConfirmPanel);

        update.add(mainPanel);
        update.setVisible(true);

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

        updateButton.addActionListener(e -> {
            if (e.getSource() == updateButton) {
                String classify = consumerCheckBox.isSelected() ? "소비자" : "제공자";
                int id = Integer.parseInt(idTextField.getText());
                String password = new String(passwordField.getPassword());
                String name = nameTextField.getText();
                int age = Integer.parseInt(ageTextField.getText());
                String gender = maleCheckBox.isSelected() ? "남자" : "여자";
                String phoneNumber = phoneNumberTextField.getText();

                User user = new User(classify, id, password, name, age, gender, phoneNumber);
                LoginManagement.userList.add(user);
                updateUser(Integer.toString(userId), user);

                JOptionPane.showMessageDialog(null, "회원 정보 수정이 완료되었습니다.", "확인", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public static void updateUser(String searchString, User newUser) {
        try {
            File inputFile = new File("src/resources/userList.txt");
            File tempFile = new File("src/resources/userListTemp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    found = true;
                    bw.write(newUser.toString());
                    bw.newLine();
                } else {
                    bw.write(line);
                    bw.newLine();
                }
            }

            br.close();
            bw.close();

            if (found) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
            } else {
                tempFile.delete();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
