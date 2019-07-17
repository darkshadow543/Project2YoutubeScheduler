package com.mustache.YoutubeScheduler.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "ChannelId")
	private int channelId;

	@Column(name = "VideoDescription")
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

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
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
