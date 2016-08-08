package com.pshyun.roulette.service;

import java.util.List;

import com.pshyun.roulette.entity.Menu;

public interface MenuService {
	
	List<Menu> findAllByOrderByMenuNoDesc();
	
	Menu save(Menu menu);
	
	void delete(Menu menu);
}
