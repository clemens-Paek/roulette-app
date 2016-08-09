package com.pshyun.roulette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pshyun.roulette.entity.EatMenu;
import com.pshyun.roulette.repository.EatMenuRepository;

@Service(value = "EatMenuService")
public class EatMenuServiceImpl implements EatMenuService {
	
	@Autowired
	EatMenuRepository repository;
	
	@Transactional
	@Override
	public EatMenu save(EatMenu eatMenu) {
		return repository.save(eatMenu);
	}
}
