package com.mustache.YoutubeScheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mustache.YoutubeScheduler.dao.VideoDAO;
import com.mustache.YoutubeScheduler.model.Video;

@Service
public class VideoService {

	@Autowired 
	private VideoDAO dao;
	
	public VideoService() {

	}
	

	@Transactional
	public void createVideo(Video video) {
		dao.save(video);
	}
	
	@Transactional
	public void delete(Integer ID) {
		dao.delete(ID);
	}
	
	@Transactional
	public void update(Video video) {
		dao.save(video);
	}
	
	@Transactional
	public List<Video> getAll() {
		return dao.list();
	}
	
	@Transactional
	public Video getVideo(Integer id) {
		return dao.getOne(id);
	}
}
