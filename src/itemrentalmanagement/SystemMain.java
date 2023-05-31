package itemrentalmanagement;

import usermanagement.LoginManagement;
import usermanagement.User;
import usermanagement.UpdateUsers;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemMain extends JFrame implements ActionListener {
    private User user;
    private JButton intermediaryBtn, consumerBtn, providerBtn, logoutBtn, updateBtn;
    private JPanel btnPanel, userPanel, blankPanel;

    // showSystemMain() 대체
    public SystemMain(User user) {
        this.user = user;

        setTitle("시스템 메인 화면");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        intermediaryBtn = new JButton("중개자");
        consumerBtn = new JButton("소비자");
        providerBtn = new JButton("제공자");
        updateBtn = new JButton("회원 정보 수정");
        logoutBtn = new JButton("로그아웃");

        btnPanel = new JPanel();
        // hgap = x margin, vgap = y margin
        btnPanel.setLayout(new FlowLayout(1, 20, 0));
        btnPanel.setPreferredSize(new Dimension(100, 150));
        intermediaryBtn.setPreferredSize(new Dimension(100, 30));
        consumerBtn.setPreferredSize(new Dimension(100, 30));
        providerBtn.setPreferredSize(new Dimension(100, 30));
        
        btnPanel.add(intermediaryBtn);
        btnPanel.add(consumerBtn);
        btnPanel.add(providerBtn);
        
        userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout(1, 20, 0));
        userPanel.add(updateBtn);
        userPanel.add(logoutBtn);
        logoutBtn.setPreferredSize(new Dimension(100, 30));

        blankPanel = new JPanel();
        blankPanel.setPreferredSize(new Dimension(1, 100));

        // intermediaryBtn.setBounds(150, 30, 100, 30);
        // consumerBtn.setBounds(150, 70, 100, 30);
        // providerBtn.setBounds(150, 110, 100, 30);
        // logoutBtn.setBounds(150, 150, 100, 30);
        
        intermediaryBtn.addActionListener(this);
        consumerBtn.addActionListener(this);
        providerBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        add(blankPanel, "North");
        add(btnPanel, "Center");
        add(userPanel, "South");

        setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e){
        int userId = user.getId();
        if(e.getSource() == intermediaryBtn){
            if(userId == 10000000){
                showIntermediaryScreen();
            }
            else{
                JOptionPane.showMessageDialog(null, "자격이 유효하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == consumerBtn){
            if(userId >= 20000000 && user.getId() < 30000000){
                showConsumerScreen();
            }
            else{
                JOptionPane.showMessageDialog(null, "자격이 유효하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == providerBtn){
            if(userId >= 30000000){
                showProviderScreen();
            }
            else{
                JOptionPane.showMessageDialog(null, "자격이 유효하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == updateBtn){
            new UpdateUsers(userId);
        }
        else{
            int choice = JOptionPane.showOptionDialog(null,
                    "로그아웃 하시겠습니까?", "확인",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    new String[]{"예", "아니오"}, "아니오");

            if(choice == 0){
                dispose();
                new LoginManagement();
            }

        }
    }

    private void showProviderScreen() {
        JFrame frame = new JFrame();
        frame.setTitle("제공자");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JOptionPane.showMessageDialog(null, "아직 기능이 없습니다.", "에러", JOptionPane.ERROR_MESSAGE);
        frame.dispose();
    }

    private void showConsumerScreen() {
        JFrame frame = new JFrame();
        frame.setTitle("소비자");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton itemSearchBtn = new JButton("물품 조회");
        itemSearchBtn.setBounds(120, 50, 150, 30);

        JButton itemRentalBtn = new JButton("물품 대여");
        itemRentalBtn.setBounds(120, 100, 150, 30);

        JButton rentalRecordBtn = new JButton("대여기록 보기");
        rentalRecordBtn.setBounds(120, 150, 150, 30);

        frame.add(itemSearchBtn);
        frame.add(itemRentalBtn);
        frame.add(rentalRecordBtn);

        itemSearchBtn.addActionListener(e -> new ItemSearch());

        itemRentalBtn.addActionListener(e -> new ItemRental());

        rentalRecordBtn.addActionListener(e -> RentalRecord.showRentalRecord());

        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void showIntermediaryScreen() {
        JFrame frame = new JFrame();

        frame.setTitle("중개자");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton rentalRequestManagementBtn = new JButton("대여신청 관리");
        rentalRequestManagementBtn.setBounds(120, 125, 150, 50);

        frame.add(rentalRequestManagementBtn);

        rentalRequestManagementBtn.addActionListener(e -> {
            frame.dispose();
            RentalRequestManagement.showRentalRequest();
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

}