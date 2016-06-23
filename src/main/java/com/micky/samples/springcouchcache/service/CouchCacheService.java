package com.micky.samples.springcouchcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micky.samples.springcouchcache.dao.PlayerDao;
import com.micky.samples.springcouchcache.model.Player;

@RestController
public class CouchCacheService {

	@Autowired
	public PlayerDao playerDao;

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/getPlayer")
	public Player getPlayer(@RequestParam String playerId) {
		return playerDao.getPlayer(playerId);
	}

}
