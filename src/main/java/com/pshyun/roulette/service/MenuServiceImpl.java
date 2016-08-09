package com.pshyun.roulette.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.pshyun.roulette.entity.Menu;
import com.pshyun.roulette.repository.MenuRepository;

@Service(value = "MenuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	MenuRepository repository;
	
	@Override
	public List<Menu> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<Menu> findAllByOrderByMenuNoDesc() {
		return repository.findAllByOrderByMenuNoDesc();
	}
	
	@Override
	public Menu findByMenuNo(Menu menu) {
		return repository.findByMenuNo(menu);
	}
	
	@Transactional
	@Override
	public Menu save(Menu menu) {
		return repository.save(menu);
	}
	
	@Transactional
	@Rollback(true)
	@Override
	public void delete(Menu menu) {
		repository.delete(menu);
	}
}
