package com.mustache.YoutubeScheduler.validator;

import org.springframework.stereotype.Component;

import com.mustache.YoutubeScheduler.exception.ValidatorException;
import com.mustache.YoutubeScheduler.model.Subscription;

@Component
public class SubscriptionValidator {

	public SubscriptionValidator() {
		// TODO Auto-generated constructor stub
	}
	
	public static void ValidateSub(Subscription sub) throws ValidatorException {
		if (sub.getChannel() < 0) {
			throw new ValidatorException("Name cannot be null");
		} else if (sub.getUser() < 0) {
			throw new ValidatorException("Name cannot be null");
		}
	}

}
