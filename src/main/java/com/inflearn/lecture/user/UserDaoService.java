package com.inflearn.lecture.user;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCnt = 3;
    static{
        users.add(new User (1,"Lee", new Date()));
        users.add(new User (2,"Hyun", new Date()));
        users.add(new User (3,"Woo", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId()==null){
            user.setId(++userCnt);
        }
        users.add(user);
        return user;
    }

    public User findById(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
