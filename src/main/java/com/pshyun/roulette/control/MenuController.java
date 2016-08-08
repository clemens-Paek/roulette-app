package com.pshyun.roulette.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pshyun.roulette.common.vo.ResultJSON;
import com.pshyun.roulette.entity.Menu;
import com.pshyun.roulette.service.MenuService;

@Controller
@RequestMapping("/menu/list")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	EntityManager em;
	
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON getMenuListAll(HttpServletRequest request) {
		ResultJSON resultJSON = new ResultJSON();
		List<Menu> menuList = menuService.findAllByOrderByMenuNoDesc();
		resultJSON.setItems(menuList);
		resultJSON.setTotal(menuList.size());
		resultJSON.setSuccess(true);
		return resultJSON;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON addMenuList(HttpServletRequest request, @RequestParam String menuName) {
		ResultJSON resultJSON = new ResultJSON();
		Menu menu = new Menu();
		menu.setMenuName(menuName);
		menuService.save(menu);
		resultJSON.setSuccess(true);
		return resultJSON;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON deleteMenu(HttpServletRequest request, @RequestParam int menuNo) {
		ResultJSON resultJSON = new ResultJSON();
		Menu menu = new Menu();
		menu.setMenuNo(menuNo);
		menuService.delete(menu);
		resultJSON.setSuccess(true);
		return resultJSON;
	}
}
