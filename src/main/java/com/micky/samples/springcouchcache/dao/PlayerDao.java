package com.micky.samples.springcouchcache.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.micky.samples.springcouchcache.data.PlayerRepo;
import com.micky.samples.springcouchcache.model.Player;

@Component
public class PlayerDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerDao.class);
	
	@Autowired
	public PlayerRepo playerRepo;

	@Cacheable(cacheNames="players", key = "#playerId")
	public Player getPlayer(String playerId) {
		LOGGER.info("Fetching player id " + playerId);
		return playerRepo.findOne(playerId);
	}
	
	@CacheEvict(cacheNames = "players", key = "#player?.id")
	public void savePlayer(Player player) {
		LOGGER.info("Saving player " + player);
		playerRepo.save(player);
	}
}
