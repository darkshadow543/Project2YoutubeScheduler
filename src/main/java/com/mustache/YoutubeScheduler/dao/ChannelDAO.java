package com.mustache.YoutubeScheduler.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mustache.YoutubeScheduler.model.Channel;

@Repository
public interface ChannelDAO extends JpaRepository<Channel, Integer> {

	Channel save(Channel channel);

	@Query("select c from Channel c")
	List<Channel> list();

	@Modifying
	@Query("delete from Channel where where id = :id")
	void delete(@Param("id") Integer id);
	
	@Query ("select u from Channel c where id = :id")
	Channel select(@Param("id") Integer id);
}
