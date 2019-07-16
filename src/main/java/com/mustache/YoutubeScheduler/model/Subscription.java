package com.mustache.YoutubeScheduler.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Channel channel;
	
}
