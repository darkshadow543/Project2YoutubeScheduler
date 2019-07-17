package com.mustache.YoutubeScheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mustache.YoutubeScheduler.dao.ChannelDAO;
import com.mustache.YoutubeScheduler.model.Channel;

@Service
public class ChannelService {

	@Autowired
	private ChannelDAO dao;
	
	public ChannelService() {
		
	}
	
	@Transactional
	public void createChannel(Channel chan) {
		dao.save(chan);
	}
	
	@Transactional
	public void delete(Integer ID) {
		dao.delete(ID);
	}
	
	@Transactional
	public void update(Channel chan) {
		dao.save(chan);
	}
	
	@Transactional
	public List<Channel> getAll() {
		return dao.list();
	}
	
	@Transactional
	public Channel getChannal(Integer id) {
		return dao.getOne(id);
	}
}
