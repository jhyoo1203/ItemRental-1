public class Item {
    private String itemId;
    private String itemName;
    private int maxRentalDate;
    private boolean isAvailableItem;
    private int registrationDate;
    private String category;
    private int price;
    private int qScore;

    public Item(String itemId, String itemName, int maxRentalDate, boolean isAvailableItem,
                int registrationDate, String category, int price, int qScore){
        this.itemId = itemId;
        this.itemName = itemName;
        this.maxRentalDate = maxRentalDate;
        this.isAvailableItem = isAvailableItem;
        this.registrationDate = registrationDate;
        this.category = category;
        this.price = price;
        this.qScore = qScore;
    }

    @Override
    public String toString() {
        return  "물품 ID : " + itemId + '\n' +
                "물품명 : " + itemName + '\n' +
                "최대 대여기간 : " + maxRentalDate + '\n' +
                "대여 가능 여부 : " + isAvailableItem + '\n' +
                "물품 등록일 : " + registrationDate + '\n' +
                "카테고리 : " + category + '\n' +
                "가격 : " + price + '\n' +
                "인기도 : " + qScore ;
    }

    public String getItemId() {
        return "물품 ID : " + itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return "물품명 : " + itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMaxRentalDate() {
        return "최대 대여기간 : " + maxRentalDate;
    }

    public void setMaxRentalDate(int maxRentalDate) {
        this.maxRentalDate = maxRentalDate;
    }

    public String isAvailableItem() {
        return "대여 가능 여부 : " + isAvailableItem;
    }

    public void setAvailableItem(boolean availableItem) {
        isAvailableItem = availableItem;
    }

    public String getRegistrationDate() {
        return "물품 등록일 : " + registrationDate;
    }

    public void setRegistrationDate(int registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCategory() {
        return "카테고리 : " + category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return "가격 : " + price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getqScore() {
        return "인기도 : " + qScore;
    }

    public void setqScore(int qScore) {
        this.qScore = qScore;
    }

    public void qScoreUp(){
        this.qScore += 1;
    }
}
