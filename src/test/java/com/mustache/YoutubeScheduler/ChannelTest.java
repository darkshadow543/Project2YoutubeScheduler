package com.mustache.YoutubeScheduler;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mustache.YoutubeScheduler.controller.ChannelController;
import com.mustache.YoutubeScheduler.model.Channel;
import com.mustache.YoutubeScheduler.model.Subscription;
import com.mustache.YoutubeScheduler.model.Video;
import com.mustache.YoutubeScheduler.service.ChannelService;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ChannelTest {
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private ChannelService mockService;
	

	@InjectMocks
	ChannelController authController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSave() throws Exception {
		Channel chan = new Channel();
		chan.setName("test");
		chan.setOwner(1);
		chan.setSubs(new ArrayList<Subscription>());
		chan.setVideos(new ArrayList<Video>());
		
		when(mockService.getChannal(any(Integer.class))).thenReturn(chan);
		
		mock.perform(get("/channels/1")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("test"));
		
	}

}
