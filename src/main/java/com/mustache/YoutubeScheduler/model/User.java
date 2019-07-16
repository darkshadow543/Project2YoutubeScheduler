package com.mustache.YoutubeScheduler.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "viewer")
public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userid_gen")
	@SequenceGenerator(name = "userid_gen", sequenceName = "ViewerIdSeq", allocationSize = 1)
	@Column(name = "userid")
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "isYoutuber")
	private Boolean isYoutuber;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Channel> channels;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Subscription> subs;
	

}
