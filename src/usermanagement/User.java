package usermanagement;

public class User {
    private String classify;
    private int id;
    private String password;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;

    public User(String classify, int id, String password, String name,
                int age, String gender, String phoneNumber){
        this.classify = classify;
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public User() {
        this.id = 10000000;
    }

    public void deleteAccount(){
        LoginManagement.userList.remove(this);
    }

    public String getClassify() {
        return classify;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(classify + "," + id + "," + password + "," + name + "," + age + "," + gender + "," + phoneNumber);
    }
}
