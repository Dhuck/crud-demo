package mx.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.crud.User;
import mx.crud.UserRepository;
import mx.crud.utils.IterableToList;

@Service
public class UserService {
	
    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getaAllUsers() {
    	IterableToList toList = new IterableToList();
    	return toList.toList(userRepository.findAll());
    }
}
