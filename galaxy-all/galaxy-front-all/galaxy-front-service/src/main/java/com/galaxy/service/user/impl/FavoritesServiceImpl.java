package com.galaxy.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.user.mapper.FavoritesMapper;
import com.galaxy.service.user.FavoritesService;
@Service
public class FavoritesServiceImpl implements FavoritesService {
	@Autowired
	private FavoritesMapper favoritesMapper;

}
