package mx.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.crud.entity.User;
import mx.crud.repository.UserRepository;
import mx.crud.utils.IterableToList;

@Service
public class UserService {
	
    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
    	IterableToList toList = new IterableToList();
    	return toList.toList(userRepository.findAll());
    }
}
