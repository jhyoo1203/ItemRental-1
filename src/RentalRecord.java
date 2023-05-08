import javax.swing.*;

public class RentalRecord {
    public static RentalRecord rentalRecord;

    private String itemId;
    private int userId;
    private final int rentalDate = 20230508;
    private int returnDate;


    public static void record(Request request){
        rentalRecord = new RentalRecord();
        rentalRecord.itemId = request.getItemId();
        rentalRecord.userId = request.getUserId();
        rentalRecord.returnDate = request.getReturnDate();
    }

    public static void showRentalRecord(){
        JFrame frame = new JFrame();
        JLabel userIdLabel, itemIdLabel, rentalDateLabel, returnDateLabel;

        frame.setTitle("대여 기록");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        if(rentalRecord == null){
            JOptionPane.showMessageDialog(null, "대여 기록이 없습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            return;
        }

        userIdLabel = new JLabel("사용자 ID : " + rentalRecord.userId);
        itemIdLabel = new JLabel("물품 ID : " + rentalRecord.itemId);
        rentalDateLabel = new JLabel("대여일 : " + rentalRecord.rentalDate);
        returnDateLabel = new JLabel("반납 예정일 : " + rentalRecord.returnDate);

        userIdLabel.setBounds(100, 50, 250, 30);
        itemIdLabel.setBounds(100, 100, 250, 30);
        rentalDateLabel.setBounds(100, 150, 250, 30);
        returnDateLabel.setBounds(100, 200, 250, 30);

        frame.add(userIdLabel);
        frame.add(itemIdLabel);
        frame.add(rentalDateLabel);
        frame.add(returnDateLabel);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
