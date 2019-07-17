package com.mustache.YoutubeScheduler.validator;

import org.springframework.stereotype.Component;

import com.mustache.YoutubeScheduler.exception.ValidatorException;
import com.mustache.YoutubeScheduler.model.Channel;

@Component
public class ChannelValidator {

	public void ValidateChannel(Channel chan) throws ValidatorException {
		if (chan.getName() != null || chan.getName().equals("")){
			throw new ValidatorException("Name cannot be null");
		} else if (chan.getOwner() == null) {
			throw new ValidatorException("Name cannot be null");
		}
	}

}
