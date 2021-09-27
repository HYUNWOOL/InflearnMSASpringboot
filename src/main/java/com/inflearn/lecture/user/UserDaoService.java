package com.inflearn.lecture.user;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCnt = 3;
//    static{
//        users.add(new User (1,"Lee", new Date(),"121212-1111111", "pwd"));
//        users.add(new User (2,"Hyun", new Date(),"131313-1111111", "pwd"));
//        users.add(new User (3,"Woo", new Date(),"141414-1111111", "pwd"));
//    }

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

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
