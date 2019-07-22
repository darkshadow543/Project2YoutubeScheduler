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
import com.mustache.YoutubeScheduler.model.Video;
import com.mustache.YoutubeScheduler.service.VideoService;

@CrossOrigin

@RestController
@RequestMapping("videos")public class VideoController {

	@Autowired
	private VideoService videoserv;
	
	@PostMapping("/upload")
	public ResponseEntity<?> Upload(@RequestBody Video vid) {
		System.out.println("VideoController->save");
		videoserv.createVideo(vid);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody Video vid) {
		System.out.println("VideoController->update" + id);
		videoserv.update(vid);
	}
	
	@PostMapping("/getall")
	public List<Video> list() {
		List<Video> list = videoserv.getAll();
		return list;
	}

	@GetMapping("/get/{id}")
	public Video findOne(@PathVariable("id") Integer id) {
		Video video = videoserv.getVideo(id);
		return video;
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		videoserv.delete(id);
	}
}
