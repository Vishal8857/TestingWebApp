package com.product.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.Entity.User;
import com.product.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAllUser() {
		List<User> allUsers=userRepo.findAll();
		return allUsers;
	}
	
	public User userFindById(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	public boolean userFindByMobile(Long mobile){
		List<User> users=getAllUser();
		for(int i=0; i<users.size();i++)
		{
			if(mobile==users.get(i).getMobile()) {
				return true;
			}
		}
		return false;
	}
	
	public User saveUser(String name,String surname,long mobile,String mail,String password,String address,long pinCode)
	{
		User user=new User();
		user.setName(name);
		user.setSurname(surname);
		user.setAddress(address);
		user.setMail(mail);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setPinCode(pinCode);
		
		return createUser(user);
	}
	
	public User updateUser(long id, String name,String surname,long mobile,String mail,String password,String address,long pinCode) {
		
		User user=userFindById(id);
		user.setName(name);
		user.setSurname(surname);
		user.setAddress(address);
		user.setMail(mail);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setPinCode(pinCode);
		
		return userRepo.save(user);
	}
	
	public String deleteUser(long id) {
		userRepo.deleteById(id);
		return "User deleted successfully.... with id="+id;
	}
}
