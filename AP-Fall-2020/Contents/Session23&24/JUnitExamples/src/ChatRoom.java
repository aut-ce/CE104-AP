import java.util.ArrayList;
import java.util.Iterator;

public class ChatRoom {
    private ArrayList<User> userList = new ArrayList<>();

    public User findOne(String email) {
        Iterator<User> it = userList.iterator();
        while (it.hasNext()) {
            User temp = it.next();
            if (temp.getEmail().equals(email)) {
                return temp;
            }
        }
        return null;
    }
    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public static void main(String[] args) {
        System.out.println("Sample Code with JUnit!");
    }
}
