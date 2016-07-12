package com.micky.samples.springcouchcache.service;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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
	public Player getPlayer(
			@Valid @Size(max = 2, min = 1, message = "name should have between 1 and 10 characters") @RequestParam Integer playerId) {
		return playerDao.getPlayer("123");
	}

	@RequestMapping(value = "/savePlayer/{playerId}")
	public void savePlayer(@PathVariable String playerId) {
		Player player = new Player();
		player.setBalance(123l);
		player.setName(playerId);
		player.setId(playerId);
		playerDao.savePlayer(player);
	}

}
