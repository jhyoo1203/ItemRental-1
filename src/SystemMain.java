
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemMain extends JFrame implements ActionListener {
    private int id;
    private String password;
    private JButton intermediaryBtn, consumerBtn, providerBtn, retryBtn;

    // showSystemMain() 대체
    public SystemMain(int id, String password) {
        this.id = id;
        this.password = password;

        setTitle("시스템 메인 화면");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        intermediaryBtn = new JButton("중개자");
        consumerBtn = new JButton("소비자");
        providerBtn = new JButton("제공자");
        retryBtn = new JButton("로그아웃");

        intermediaryBtn.setBounds(150, 30, 100, 30);
        consumerBtn.setBounds(150, 70, 100, 30);
        providerBtn.setBounds(150, 110, 100, 30);
        retryBtn.setBounds(150, 150, 100, 30);

        add(intermediaryBtn);
        add(consumerBtn);
        add(providerBtn);
        add(retryBtn);

        intermediaryBtn.addActionListener(this);
        consumerBtn.addActionListener(this);
        providerBtn.addActionListener(this);
        retryBtn.addActionListener(this);

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == intermediaryBtn){
            if(id >= 1000000 && id < 2000000){
                showIntermediaryScreen();
            }
            else{
                JOptionPane.showMessageDialog(null, "자격이 유효하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == consumerBtn){
            if(id >= 2000000 && id < 3000000){
                showConsumerScreen();
            }
            else{
                JOptionPane.showMessageDialog(null, "자격이 유효하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == providerBtn){
            if(id >= 3000000){
                showProviderScreen();
            }
            else{
                JOptionPane.showMessageDialog(null, "자격이 유효하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            int choice = JOptionPane.showOptionDialog(null,
                    "로그아웃 하시겠습니까?", "확인",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    new String[]{"예", "아니오"}, "아니오");

            if(choice == 0){
                dispose();
                new Login();
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

    public int getId() {
        return id;
    }
}