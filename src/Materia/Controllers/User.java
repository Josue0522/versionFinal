package Materia.Controllers;
import java.util.List;
import java.util.LinkedList;

public class User {
    private String name;
    private int age;
    private List<String> interests;
    private List<User> friends;

    public User(String name, int age, List<String> interests, List<User> friends) {
        this.name = name;
        this.age = age;
        this.interests = interests;
        this.friends = friends;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age, List<String> interests) {
        this.name = name;
        this.age = age;
        this.interests = interests;
        this.friends = new LinkedList<>();
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public List<User> getFriends() {
        return friends;
    }
    public List<String> getInterests() {
        return interests;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
