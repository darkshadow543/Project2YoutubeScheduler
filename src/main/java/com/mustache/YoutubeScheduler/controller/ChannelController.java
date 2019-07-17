package com.mustache.YoutubeScheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mustache.YoutubeScheduler.model.Channel;
import com.mustache.YoutubeScheduler.service.ChannelService;

@CrossOrigin

@RestController
@RequestMapping("channels")
public class ChannelController {

	@Autowired
	private ChannelService chanserv;
	
	@PostMapping()
	public ResponseEntity<?> register(@RequestBody Channel chan) {
		System.out.println("UserController->save");
		chanserv.createChannel(chan);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody Channel user) {
		System.out.println("UserController->update" + id);
		chanserv.update(user);
	}
	
	@GetMapping()
	public List<Channel> list() {
		List<Channel> list = chanserv.getAll();
		return list;
	}

	@GetMapping("/{id}")
	public Channel findOne(@PathVariable("id") Integer id) {
		Channel user = chanserv.getChannal(id);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		chanserv.delete(id);
	}
}
