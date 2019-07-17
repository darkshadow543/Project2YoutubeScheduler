package com.mustache.YoutubeScheduler.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mustache.YoutubeScheduler.model.Subscription;

@Repository
public interface SubscriptionDAO extends JpaRepository<Subscription, Integer> {
	
	Subscription save(Subscription sub);

	@Query("select s from Subscription s")
	List<Subscription> list();

	@Modifying
	@Query("delete from Subscription where id = :id")
	void delete(@Param("id") Integer id);
	
	@Query ("select s from Subscription s where id = :id")
	Subscription select(@Param("id") Integer id);
}
