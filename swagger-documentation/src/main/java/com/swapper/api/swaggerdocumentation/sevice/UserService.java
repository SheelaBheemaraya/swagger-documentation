package com.swapper.api.swaggerdocumentation.sevice;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.swapper.api.swaggerdocumentation.model.User;

@Component
public class UserService {
	 private static List<User> list = new ArrayList<>();
	  
     static {
         list.add(new User(1, "Ramesh ", "bangalore"));
         list.add(new User(2, "ravi", "US"));
         list.add(new User(3, "Roopa", "German"));
     }
  // get all users
     public List<User> getAllUsers() {
    	 return list;
     }
     
     // get single user by id
     public User getUserById(int id) {
         User user = null;
         try {
             user = list.stream().filter(e -> e.getId() == id).findFirst().get();
            
         } catch (Exception e) {
             e.printStackTrace();
         }
         return user;
     }
     
     
     //add user
     public User addUser(User b)
     {
    	 list.add(b);
    	 return b;
     }
// delete the user
	public void deleteUser(int userId) {
		list = list.stream().filter(book -> book.getId() != userId).collect(Collectors.toList());
	}
		// update the user
	    public void updateUser(User user, int userId) {
	         list = list.stream().map(b -> {
	             if (b.getId() == userId) {
	                 b.setName(user.getName());
	                 b.setPlace(user.getPlace());
	             }
	             return b;
	         }).collect(Collectors.toList());
			
}

}
