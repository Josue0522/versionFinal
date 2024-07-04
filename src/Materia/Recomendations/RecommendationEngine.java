package Materia.Recomendations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import Materia.Controllers.User;
import Materia.Models.Graph;

public class RecommendationEngine {
    public List<User> recommendFriends (User user, Graph graph){

        List<User> recommendations = new ArrayList<>();
        for (User potentialFriendUsers: graph.getUsers()){

            if (!user.getFriends().contains(potentialFriendUsers) && potentialFriendUsers != user) {
                   double similarity= calculateSimilarity(user, potentialFriendUsers);

                   if(similarity > 0.3){
                    recommendations.add(potentialFriendUsers);
                   }
        }
     }
     return recommendations;

    }

    private double calculateSimilarity(User user1, User user2) {
      Set<String> interests1= new HashSet<>(user1.getInterests());
      Set<String> interests2= new HashSet<>(user2.getInterests());
      Set<String> intersection = new HashSet<>(interests1);
      intersection.retainAll(interests2);
      Set<String>union = new HashSet<>(interests1);
      union.addAll(interests2);

      double resp=(double) intersection.size() / union.size();
      System.out.println("Valor - "+resp);

      return resp;
    }
}