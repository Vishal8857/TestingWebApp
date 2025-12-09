package com.product.Controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.product.CommanClasses.UserResponse;
import com.product.Entity.User;
import com.product.Service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserCotroller {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<UserResponse> createUser(
			@RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("mobile") long mobile,
            @RequestParam("pinCode") long pinCode,
            @RequestParam("password") String password,
            @RequestParam("address") String address,
            @RequestParam("mail") String mail
    ) throws IOException {
		
		if(userService.userFindByMobile(mobile)) {
			UserResponse userResponse=new UserResponse("User Already created with this mobile number :"+mobile);
			return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
		}
		else {
			User saveUser=userService.saveUser( name, surname, mobile, mail, password, address, pinCode);
			UserResponse response=new UserResponse(saveUser.getName()+" Your account created successfully..", saveUser.getName());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserResponse> updateUser(
			@RequestParam("id") long id,
			@RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("mobile") long mobile,
            @RequestParam("pinCode") long pinCode,
            @RequestParam("password") String password,
            @RequestParam("address") String address,
            @RequestParam("mail") String mail
	)throws IOException{
				
		User user=userService.updateUser(id, name, surname, mobile, mail, password, address, pinCode);
		UserResponse userResponse=new UserResponse(user.getName()+", your profile updated successfully... ",user.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse); 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@RequestParam("id") long id){
		return userService.deleteUser(id);
	}
}
