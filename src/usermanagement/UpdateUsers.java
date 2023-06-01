package usermanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUsers {
    private User user;

    public UpdateUsers(User user) {
        this.user = user;
        createUpdateUI();
    }

    private void createUpdateUI() {
        JFrame updateFrame = new JFrame();
        JPanel mainPanel = new JPanel();

        updateFrame.setTitle("회원정보 수정");
        updateFrame.setSize(400, 300);
        updateFrame.setLocationRelativeTo(null);
        updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("이름:");
        JTextField nameTextField = new JTextField(10);
        nameTextField.setText(user.getName());
        nameLabel.setPreferredSize(new Dimension(100, 30));
        nameTextField.setPreferredSize(new Dimension(100, 30));
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(namePanel);

        JPanel passwordPanel = new JPanel();
        JLabel passwordLabel = new JLabel("비밀번호:");
        JPasswordField passwordField = new JPasswordField(15);
        passwordLabel.setPreferredSize(new Dimension(100, 30));
        passwordField.setPreferredSize(new Dimension(100, 30));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        passwordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(passwordPanel);

        JPanel phoneNumberPanel = new JPanel();
        JLabel phoneNumberLabel = new JLabel("전화번호:");
        JTextField phoneNumberTextField = new JTextField(10);
        phoneNumberTextField.setText(user.getPhoneNumber());
        phoneNumberLabel.setPreferredSize(new Dimension(100, 30));
        phoneNumberTextField.setPreferredSize(new Dimension(100, 30));
        phoneNumberPanel.add(phoneNumberLabel);
        phoneNumberPanel.add(phoneNumberTextField);
        phoneNumberPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(phoneNumberPanel);

        JPanel updateButtonPanel = new JPanel();
        JButton updateButton = new JButton("수정하기");
        updateButton.setPreferredSize(new Dimension(100, 30));
        updateButtonPanel.add(updateButton);
        mainPanel.add(updateButtonPanel);

        updateFrame.add(mainPanel);
        updateFrame.setVisible(true);

        updateButton.addActionListener(e -> {
            String newName = nameTextField.getText();
            String newPassword = new String(passwordField.getPassword());
            String newPhoneNumber = phoneNumberTextField.getText();

            user.setName(newName);
            user.setPassword(newPassword);
            user.setPhoneNumber(newPhoneNumber);

            LoginManagement.updateUserData(user);

            JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.", "확인", JOptionPane.PLAIN_MESSAGE);
            updateFrame.dispose();
        });
    }
}
