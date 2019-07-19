package com.mustache.YoutubeScheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Subscription")
public class Subscription {

	public Subscription() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subid_gen")
	@SequenceGenerator(name = "subid_gen", sequenceName = "SubscriptionIdSeq", allocationSize = 1)
	@Column(name = "SubscriptionId")
	private int id;
	
	@Column(name = "userid")
	private int user;
	
	@Column(name = "channelid")
	private int channel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}
	
}
