package com.micky.samples.springcouchcache.data;

import org.springframework.data.repository.CrudRepository;

import com.micky.samples.springcouchcache.model.Player;

public interface PlayerRepo extends CrudRepository<Player, String>{

	
}
