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
	
	@OneToMany(mappedBy = "viewer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Channel> channels;
	
	@OneToMany(mappedBy = "viewer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Subscription> subs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsYoutuber() {
		return isYoutuber;
	}

	public void setIsYoutuber(Boolean isYoutuber) {
		this.isYoutuber = isYoutuber;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public List<Subscription> getSubs() {
		return subs;
	}

	public void setSubs(List<Subscription> subs) {
		this.subs = subs;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", isYoutuber=" + isYoutuber + ", channels=" + channels + ", subs=" + subs + "]";
	}
	
	
}
