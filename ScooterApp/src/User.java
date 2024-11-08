public class User {

    private int age;
    private String password;
    private String userName;
    private Boolean loggedIn;

    public User(String userName, String password, int age){
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.loggedIn = false;
    }

     public void login(String password) {
        if (this.password.equals(password)) {
                this.loggedIn = true;
        }else{

            throw new RuntimeException("incorrect password");
        }
    }

    public void logout() {
        loggedIn = false;
    }
    

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    @Override
    public String toString() {
        return "User []";
    }

}
