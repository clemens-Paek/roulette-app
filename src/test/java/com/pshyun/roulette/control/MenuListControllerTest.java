package com.pshyun.roulette.control;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pshyun.roulette.entity.Menu;
import com.pshyun.roulette.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class MenuListControllerTest {

	@Autowired
	MenuService menuListService;
	
	@Test
	public void test() {
		List<Menu> menuList = menuListService.findAllByOrderByMenuNoDesc();
		System.out.println("@@ menuList : " + menuList.size());
	}

}
