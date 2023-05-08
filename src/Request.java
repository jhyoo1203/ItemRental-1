public class Request {
    private int userId;
    private String itemId;
    private int returnDate;

    public Request(int userId, String itemId, int returnDate){
        this.userId = userId;
        this.itemId = itemId;
        this.returnDate = returnDate;
    }

    public int getUserId() {
        return userId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getReturnDate() {
        return returnDate;
    }
}
