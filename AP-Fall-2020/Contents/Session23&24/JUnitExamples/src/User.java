public class User {

    private String name;
    private String email;

    public User (String email, String name){
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
