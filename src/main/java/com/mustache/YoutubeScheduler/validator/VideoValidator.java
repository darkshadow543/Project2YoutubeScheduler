package com.mustache.YoutubeScheduler.validator;

import org.springframework.stereotype.Component;

import com.mustache.YoutubeScheduler.exception.ValidatorException;
import com.mustache.YoutubeScheduler.model.Video;

@Component
public class VideoValidator {

	public VideoValidator() {

	}
	public void ValidateVideo(Video video) throws ValidatorException {
		if (video.getName() != null || video.getName().equals("")){
			throw new ValidatorException("Name cannot be null");
		} else if (video.getChannel().getId() < 0) {
			throw new ValidatorException("Faulty Channel id");
		}
	}
}
