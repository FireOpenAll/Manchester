package com.galaxy.service.user.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.galaxy.service.user.TokenService;
@Service
public class DefaultTokenService implements TokenService {

	@Override
	public String generateToken() {
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}

}
