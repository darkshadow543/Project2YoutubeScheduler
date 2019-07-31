package com.mustache.YoutubeScheduler.channel;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mustache.YoutubeScheduler.dao.ChannelDAO;
import com.mustache.YoutubeScheduler.dao.UserDAO;
import com.mustache.YoutubeScheduler.model.Channel;
import com.mustache.YoutubeScheduler.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
/*
 * @ContextConfiguration( classes = { TestDBConfig.class }, loader =
 * AnnotationConfigContextLoader.class)
 * 
 * @Transactional
 */
@SpringBootTest
public class ChannelDAOTest {

	@Resource
	private ChannelDAO rep;
	
	@Resource
	private UserDAO userRep;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setId(1);
		user.setUserName("testuser");
		user.setPassword("test");
		userRep.save(user);
		
		
		Channel channel = new Channel(1, 1, null, null, "test");
		rep.save(channel);
		
		
		Channel test = rep.select(1);
		assertEquals("test", test.getName());
	}

}
