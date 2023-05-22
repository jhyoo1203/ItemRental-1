package itemrentalmanagement;

import javax.swing.*;

public class RentalRequestManagement extends JFrame {

    private static Request request = null;

    public static void showRentalRequest(){
        JFrame frame = new JFrame();
        frame.setTitle("대여신청 관리");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        if(request == null){
            JOptionPane.showMessageDialog(null, "신청 목록이 없습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JLabel requestUserIdLabel = new JLabel("사용자 ID : " + request.getUserId());
        JLabel requestItemIdLabel = new JLabel("물품 ID : " + request.getItemId());
        JLabel requestReturnDateLabel = new JLabel("반납 예정일 : " + request.getReturnDate());

        JButton approveBtn = new JButton("승인");
        approveBtn.addActionListener(e -> {
            RentalRecord.record(request);
            JOptionPane.showMessageDialog(null, "대여 신청이 승인되었습니다.");
            request = null;
        });

        requestUserIdLabel.setBounds(100, 50, 250, 30);
        requestItemIdLabel.setBounds(100, 100, 250, 30);
        requestReturnDateLabel.setBounds(100, 150, 250, 30);
        approveBtn.setBounds(150, 200, 100, 30);

        frame.add(requestUserIdLabel);
        frame.add(requestItemIdLabel);
        frame.add(requestReturnDateLabel);
        frame.add(approveBtn);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void rentalRequest(Request request){
        RentalRequestManagement.request = request;
    }
}
