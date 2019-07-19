package com.mustache.YoutubeScheduler.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Video")
public class Video {

	public Video() {

	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "videoid_gen")
	@SequenceGenerator(name = "videoid_gen", sequenceName = "VideoIdSeq", allocationSize = 1)
	@Column(name = "VideoId")
	private int id;
	
	@Column(name = "VideoName")
	private String name;

	@Column (name = "ChannelId")
	private int channel;

	@Column(name = "Description")
	private String description;
	
	@Column(name = "ReleaseDate")
	private Date releaseDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
