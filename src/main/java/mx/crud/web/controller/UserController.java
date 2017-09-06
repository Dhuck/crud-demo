package mx.crud.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.crud.entity.User;
import mx.crud.service.UserService;
import mx.crud.web.request.UserRequest;
import mx.crud.web.resource.UserResource;
import mx.crud.web.response.UserListResponse;
import mx.crud.web.response.UserResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/all")  
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserListResponse> retrieveAllUsers() {

	    List<UserResource> userResourceList = new ArrayList<UserResource>();
	    UserListResponse response = new UserListResponse();
	  
	    List<User> userList = userService.getAllUsers();
	  
	    if (userList.isEmpty()) {
	    	return new ResponseEntity<UserListResponse>(response, HttpStatus.NO_CONTENT);
	    }

	    for(User user : userList) {
		    UserResource resource = new UserResource();
		    resource.setId(user.getId());
		    resource.setName(user.getName());
		    resource.setEmail(user.getEmail());
		    userResourceList.add(resource);
	    }

	    response.setUsers(userResourceList);

	    return new ResponseEntity<UserListResponse>(response, HttpStatus.OK);
    }

    @RequestMapping("/create")  
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@Validated @RequestBody final UserRequest userRequest) {
    	
    	System.out.println("serRequest.getName(): " + userRequest.getName());
    	
    	User user = new User();
    	user.setId(0);
    	user.setName(userRequest.getName());
    	user.setEmail(userRequest.getEmail());
    	
    	userService.createUser(user);
    	logger.info("User created successfully: {}", userRequest);

	    return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> updateUser(@PathVariable("userId") final Integer userId,
    		@Validated @RequestBody final UserRequest userRequest) {

    	User user = userService.getUsersById(userId);
    	user.setName(userRequest.getName());
    	user.setEmail(userRequest.getEmail());
    	User userUpdated = userService.updateUser(user);

    	UserResource resource = new UserResource();
    	resource.setId(userUpdated.getId());
    	resource.setName(userUpdated.getName());
    	resource.setEmail(userUpdated.getEmail());
    	
    	UserResponse response = new UserResponse();
    	response.setUser(resource);
    	logger.info("User updated successfully: {}", userRequest);

	    return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") final Integer userId) {

    	User user = userService.getUsersById(userId);
    	userService.deleteUser(user);

    	logger.info("User {} deleted successfully: ", userId);

	    return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
