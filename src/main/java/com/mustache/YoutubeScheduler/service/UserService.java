package com.mustache.YoutubeScheduler.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mustache.YoutubeScheduler.dao.SubscriptionDAO;
import com.mustache.YoutubeScheduler.dao.UserDAO;
import com.mustache.YoutubeScheduler.exception.ServiceException;
import com.mustache.YoutubeScheduler.model.Subscription;
import com.mustache.YoutubeScheduler.model.User;
import com.mustache.YoutubeScheduler.validator.SubscriptionValidator;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Autowired 
	private SubscriptionDAO subdao;
	
	public UserService() {
		
	}
	
	@Transactional
	public void createUser(User user) {
		dao.save(user);
	}
	
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}
	
	@Transactional
	public void update(User user) {
		dao.save(user);
	}
	
	@Transactional
	public List<User> list() {
		return dao.list();
	}
	
	@Transactional
	public User login(User user) {
		User userResult = dao.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return userResult;
	}
	
	@Transactional
	public User getUser(Integer id) {
		return dao.getOne(id);
	}
	
	@Transactional
	public User findOne(Integer id) {
		User user = null;

		user = dao.findOne(id);
		if (user == null) {
			throw new ServiceException("User id not found");
		}
		return user;
	}
	
	@Transactional
	public void sub(Subscription sub) {
		SubscriptionValidator.ValidateSub(sub);
		subdao.save(sub);
	}
	
	public void unsub(int id) {
		subdao.delete(id);
	}
	
	

}
