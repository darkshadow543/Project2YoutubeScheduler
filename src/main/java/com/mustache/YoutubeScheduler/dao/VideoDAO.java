package com.mustache.YoutubeScheduler.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mustache.YoutubeScheduler.model.Video;

@Repository
public interface VideoDAO extends JpaRepository<Video, Integer>{
	
	
	@SuppressWarnings("unchecked")
	Video save(Video channel);
	
	@Query("select v from Video v")
	List<Video> list();

	@Modifying
	@Query("delete from Video where id = :id")
	void delete(@Param("id") Integer id);
	
	@Query ("select v from Video v where id = :id")
	Video select(@Param("id") Integer id);
	
	
}
