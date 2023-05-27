package usermanagement;

public class User {
    // User 타입 중 중개자는 필요하지않다. -> 관리자와 마찬가지이기 때문.
    public static final String[] userClassifies = { "CONSUMER", "PROVIDER"};

    private String classify;
    private int id;
    private String password;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;

    public User(int select){
        switch(userClassifies[select - 1]){
            case "CONSUMER":
                signUpConsumer();
            case "PROVIDER":

        }
    }
}
