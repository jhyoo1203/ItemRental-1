package itemrentalmanagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemSearch extends JFrame implements ActionListener {

    private JButton cleanerBtn, batteryBtn, monitorBtn;
    private JButton cleanerRentalBtn, batteryRentalBtn, monitorRentalBtn;
    public static Item cleaner, battery, monitor;

    static {
        cleaner = new Item("001", "청소기", 20230520, true,
                20230628, "가전제품", 20000, 0);

        battery = new Item("002", "보조 배터리", 20230531, true,
                20241225, "전자제품", 3000, 0);

        monitor = new Item("003", "모니터", 20231225, true,
                20240302, "전자제품", 50000, 0);
    }

    public ItemSearch(){
        setTitle("물품 조회");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        ImageIcon cleanerIcon = new ImageIcon(getClass().getResource("../resources/cleaner.png"));
        JLabel cleanerLabel = new JLabel(cleanerIcon);
        cleanerLabel.setBounds(100, 50, 200, 200);

        JLabel cleanerIdLabel = new JLabel(cleaner.getItemId());
        cleanerIdLabel.setBounds(310, 50, 100, 30);

        JLabel cleanerNameLabel = new JLabel(cleaner.getItemName());
        cleanerNameLabel.setBounds(310, 80, 100, 30);

        JLabel cleanerPriceLabel = new JLabel(cleaner.getPrice());
        cleanerPriceLabel.setBounds(310, 110, 100, 30);

        JLabel cleanerIsAvailableLabel = new JLabel(cleaner.isAvailableItem());
        cleanerIsAvailableLabel.setBounds(310, 140, 200, 30);

        cleanerBtn = new JButton("상세 정보");
        cleanerBtn.setBounds(310, 170, 100, 30);
        cleanerBtn.addActionListener(this);

        cleanerRentalBtn = new JButton("대여");
        cleanerRentalBtn.setBounds(310, 200, 100, 30);
        cleanerRentalBtn.addActionListener(this);

        ImageIcon batteryIcon = new ImageIcon(getClass().getResource("../resources/battery.png"));
        JLabel batteryLabel = new JLabel(batteryIcon);
        batteryLabel.setBounds(100, 300, 200, 200);

        JLabel batteryIdLabel = new JLabel(battery.getItemId());
        batteryIdLabel.setBounds(310, 300, 100, 30);

        JLabel batteryNameLabel = new JLabel(battery.getItemName());
        batteryNameLabel.setBounds(310, 330, 250, 30);

        JLabel batteryPriceLabel = new JLabel(battery.getPrice());
        batteryPriceLabel.setBounds(310, 360, 100, 30);

        JLabel batteryIsAvailableLabel = new JLabel(battery.isAvailableItem());
        batteryIsAvailableLabel.setBounds(310, 390, 200, 30);

        batteryBtn = new JButton("상세 정보");
        batteryBtn.setBounds(310, 420, 100, 30);
        batteryBtn.addActionListener(this);

        batteryRentalBtn = new JButton("대여");
        batteryRentalBtn.setBounds(310, 450, 100, 30);
        batteryRentalBtn.addActionListener(this);

        ImageIcon monitorIcon = new ImageIcon(getClass().getResource("../resources/monitor.png"));
        JLabel monitorLabel = new JLabel(monitorIcon);
        monitorLabel.setBounds(100, 550, 200, 200);

        JLabel monitorIdLabel = new JLabel(monitor.getItemId());
        monitorIdLabel.setBounds(310, 550, 100, 30);

        JLabel monitorNameLabel = new JLabel(monitor.getItemName());
        monitorNameLabel.setBounds(310, 580, 250, 30);

        JLabel monitorPriceLabel = new JLabel(monitor.getPrice());
        monitorPriceLabel.setBounds(310, 610, 100, 30);

        JLabel monitorIsAvailableLabel = new JLabel(monitor.isAvailableItem());
        monitorIsAvailableLabel.setBounds(310, 640, 200, 30);

        monitorBtn = new JButton("상세 정보");
        monitorBtn.setBounds(310, 670, 100, 30);
        monitorBtn.addActionListener(this);

        monitorRentalBtn = new JButton("대여");
        monitorRentalBtn.setBounds(310, 700, 100, 30);
        monitorRentalBtn.addActionListener(this);

        add(monitorLabel);
        add(monitorIdLabel);
        add(monitorNameLabel);
        add(monitorPriceLabel);
        add(monitorIsAvailableLabel);
        add(monitorBtn);
        add(monitorRentalBtn);
        add(batteryLabel);
        add(batteryIdLabel);
        add(batteryNameLabel);
        add(batteryPriceLabel);
        add(batteryIsAvailableLabel);
        add(batteryBtn);
        add(batteryRentalBtn);
        add(cleanerBtn);
        add(cleanerRentalBtn);
        add(cleanerIsAvailableLabel);
        add(cleanerPriceLabel);
        add(cleanerIdLabel);
        add(cleanerNameLabel);
        add(cleanerLabel);

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cleanerBtn){
            JFrame cleanerFrame = new JFrame();
            cleanerFrame.setTitle("청소기 상세 정보");
            cleanerFrame.setSize(400, 300);
            cleanerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cleanerFrame.setLocationRelativeTo(null);

            JLabel idLabel = new JLabel(cleaner.getItemId());
            JLabel nameLabel = new JLabel(cleaner.getItemName());
            JLabel maxRentalDateLabel = new JLabel(cleaner.getMaxRentalDate());
            JLabel isAvailableItemLabel = new JLabel(cleaner.isAvailableItem());
            JLabel registrationDateLabel = new JLabel(cleaner.getRegistrationDate());
            JLabel categoryLabel = new JLabel(cleaner.getCategory());
            JLabel priceLabel = new JLabel(cleaner.getPrice());
            JLabel qScoreLabel = new JLabel(cleaner.getqScore());

            idLabel.setBounds(50, 10, 250, 30);
            nameLabel.setBounds(50, 40, 250, 30);
            maxRentalDateLabel.setBounds(50, 70, 250, 30);
            isAvailableItemLabel.setBounds(50, 100, 250, 30);
            registrationDateLabel.setBounds(50, 130, 250, 30);
            categoryLabel.setBounds(50, 160, 250, 30);
            priceLabel.setBounds(50, 190, 250, 30);
            qScoreLabel.setBounds(50, 220, 250, 30);

            cleanerFrame.add(idLabel);
            cleanerFrame.add(nameLabel);
            cleanerFrame.add(maxRentalDateLabel);
            cleanerFrame.add(isAvailableItemLabel);
            cleanerFrame.add(registrationDateLabel);
            cleanerFrame.add(categoryLabel);
            cleanerFrame.add(priceLabel);
            cleanerFrame.add(qScoreLabel);

            cleanerFrame.setLayout(null);
            cleanerFrame.setVisible(true);
        }
        else if(e.getSource() == cleanerRentalBtn){
            new ItemRental();
            cleaner.setAvailableItem(false);
            cleaner.qScoreUp();
        }
        else if(e.getSource() == batteryBtn){
            JFrame batteryFrame = new JFrame();
            batteryFrame.setTitle("보조 배터리 상세 정보");
            batteryFrame.setSize(400, 300);
            batteryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            batteryFrame.setLocationRelativeTo(null);

            JLabel idLabel = new JLabel(battery.getItemId());
            JLabel nameLabel = new JLabel(battery.getItemName());
            JLabel maxRentalDateLabel = new JLabel(battery.getMaxRentalDate());
            JLabel isAvailableItemLabel = new JLabel(battery.isAvailableItem());
            JLabel registrationDateLabel = new JLabel(battery.getRegistrationDate());
            JLabel categoryLabel = new JLabel(battery.getCategory());
            JLabel priceLabel = new JLabel(battery.getPrice());
            JLabel qScoreLabel = new JLabel(battery.getqScore());


            idLabel.setBounds(50, 10, 250, 30);
            nameLabel.setBounds(50, 40, 250, 30);
            maxRentalDateLabel.setBounds(50, 70, 250, 30);
            isAvailableItemLabel.setBounds(50, 100, 250, 30);
            registrationDateLabel.setBounds(50, 130, 250, 30);
            categoryLabel.setBounds(50, 160, 250, 30);
            priceLabel.setBounds(50, 190, 250, 30);
            qScoreLabel.setBounds(50, 220, 250, 30);

            batteryFrame.add(idLabel);
            batteryFrame.add(nameLabel);
            batteryFrame.add(maxRentalDateLabel);
            batteryFrame.add(isAvailableItemLabel);
            batteryFrame.add(registrationDateLabel);
            batteryFrame.add(categoryLabel);
            batteryFrame.add(priceLabel);
            batteryFrame.add(qScoreLabel);

            batteryFrame.setLayout(null);
            batteryFrame.setVisible(true);
        }
        else if(e.getSource() == batteryRentalBtn){
            new ItemRental();
            battery.setAvailableItem(false);
            battery.qScoreUp();
        }
        else if(e.getSource() == monitorBtn){
            JFrame monitorFrame = new JFrame();
            monitorFrame.setTitle("모니터 상세 정보");
            monitorFrame.setSize(400, 300);
            monitorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            monitorFrame.setLocationRelativeTo(null);

            JLabel idLabel = new JLabel(monitor.getItemId());
            JLabel nameLabel = new JLabel(monitor.getItemName());
            JLabel maxRentalDateLabel = new JLabel(monitor.getMaxRentalDate());
            JLabel isAvailableItemLabel = new JLabel(monitor.isAvailableItem());
            JLabel registrationDateLabel = new JLabel(monitor.getRegistrationDate());
            JLabel categoryLabel = new JLabel(monitor.getCategory());
            JLabel priceLabel = new JLabel(monitor.getPrice());
            JLabel qScoreLabel = new JLabel(monitor.getqScore());


            idLabel.setBounds(50, 10, 250, 30);
            nameLabel.setBounds(50, 40, 250, 30);
            maxRentalDateLabel.setBounds(50, 70, 250, 30);
            isAvailableItemLabel.setBounds(50, 100, 250, 30);
            registrationDateLabel.setBounds(50, 130, 250, 30);
            categoryLabel.setBounds(50, 160, 250, 30);
            priceLabel.setBounds(50, 190, 250, 30);
            qScoreLabel.setBounds(50, 220, 250, 30);

            monitorFrame.add(idLabel);
            monitorFrame.add(nameLabel);
            monitorFrame.add(maxRentalDateLabel);
            monitorFrame.add(isAvailableItemLabel);
            monitorFrame.add(registrationDateLabel);
            monitorFrame.add(categoryLabel);
            monitorFrame.add(priceLabel);
            monitorFrame.add(qScoreLabel);

            monitorFrame.setLayout(null);
            monitorFrame.setVisible(true);
        }
        else if(e.getSource() == monitorRentalBtn){
            new ItemRental();
            monitor.setAvailableItem(false);
            monitor.qScoreUp();
        }
    }
}
