package Materia.Models;
import Materia.Controllers.*;
import java.util.List;
import java.util.ArrayList;

public class Graph {
    public List<User> users;
    
    public Graph() {
        this.users = new ArrayList<>();
    }




    public void addUser(User user) {
        users.add(user);
    }

    public void addConnection(User user1, User user2) {
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    public List<User> getFriends(User user) {
        return user.getFriends();
    }

    public List<User> recommendFriends(User user) {
        List<User> recommended = new ArrayList<>();
        for (User friend : user.getFriends()) {
            for (User friendOfFriend : friend.getFriends()) {
                if (!user.getFriends().contains(friendOfFriend) && !user.equals(friendOfFriend)) {
                    recommended.add(friendOfFriend);
                }
            }
        }
        return recommended;
    }
    public void printGraph() {
        for (User user : users) {
            System.out.print("vertex " + user.getName() + ": ");
            for (User friend : user.getFriends()) {
                System.out.print("-> " + friend.getName() + " ");
            }
            System.out.println();
        }
    }

    public List<User> getUsers() {
        return users;
    }
}


