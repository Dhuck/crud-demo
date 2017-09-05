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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.crud.entity.User;
import mx.crud.service.UserService;
import mx.crud.web.resource.UserResource;
import mx.crud.web.response.UserResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/all")  
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserResponse> retrieveAllUsers() {

	    List<UserResource> userResourceList = new ArrayList<UserResource>();
	    UserResponse response = new UserResponse();
	  
	    List<User> userList = userService.getAllUsers();
	  
	    if (userList.isEmpty()) {
            return new ResponseEntity<UserResponse>(response, HttpStatus.NO_CONTENT);
	    }

	    for(User user : userList) {
		    UserResource resource = new UserResource();
		    resource.setId(user.getId());
		    resource.setName(user.getName());
		    resource.setEmail(user.getEmail());
		    userResourceList.add(resource);
	    }
	  
	    response.setUsers(userResourceList);

	    return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
    }
}
