package com.micky.samples.springcouchcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micky.samples.springcouchcache.dao.PlayerDao;
import com.micky.samples.springcouchcache.model.Player;

@RestController
@RequestMapping("/couch")
@Validated
public class CouchCacheService {

	@Autowired
	public PlayerDao playerDao;

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/getPlayer")
	public Player getPlayer(@RequestParam String playerId) {
		return playerDao.getPlayer(playerId);
	}

	@RequestMapping(value = "/savePlayer/{playerId}")
	public void savePlayer(@PathVariable String playerId) {
		Player player = new Player();
		player.setBalance(123l);
		player.setName(playerId);
		player.setId(playerId);
		playerDao.savePlayer(player);
	}
	
	@RequestMapping(value = "/deletePlayer/{playerId}")
	public void deletePlayer(@PathVariable String playerId) {
		Player player = getPlayer(playerId);
		playerDao.deletePlayer(player);
	}
	
	@RequestMapping("/clearCache")
	public void cleaCache() {
		playerDao.resetAllEntries();
	}

}
