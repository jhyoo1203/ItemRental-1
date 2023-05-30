package itemrentalmanagement;

import usermanagement.LoginManagement;

import javax.swing.*;
import java.util.Objects;

public class ItemRental extends JFrame {
    public ItemRental(){
        setTitle("물품 대여");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JButton rentalBtn = new JButton("대여 신청하기");
        rentalBtn.addActionListener(e -> {
            int userId = Integer.parseInt(Objects.requireNonNull(JOptionPane.showInputDialog("사용자 ID를 입력하세요.")));

            if(!LoginManagement.searchUserId(userId))
                JOptionPane.showMessageDialog(null, "잘못된 ID 값입니다.", "에러", JOptionPane.ERROR_MESSAGE);

            String itemId = JOptionPane.showInputDialog("물품 ID를 입력하세요.");
            int returnDate = Integer.parseInt(JOptionPane.showInputDialog("반납 예정일을 입력하세요. (YYYYMMDD)"));

            Request request = new Request(userId, itemId, returnDate);
            RentalRequestManagement.getInstance().rentalRequest(request);
            JOptionPane.showMessageDialog(null, "대여 신청이 완료되었습니다.");
        });
        rentalBtn.setBounds(120, 125, 150, 50);

        add(rentalBtn);
        setLayout(null);
        setVisible(true);

        setLayout(null);
        setVisible(true);
    }
}
