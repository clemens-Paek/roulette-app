package com.pshyun.roulette.control;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysema.query.jpa.impl.JPAQuery;
import com.pshyun.roulette.common.utils.DateUtils;
import com.pshyun.roulette.common.vo.ResultJSON;
import com.pshyun.roulette.entity.EatMenu;
import com.pshyun.roulette.entity.Menu;
import com.pshyun.roulette.entity.QEatMenu;
import com.pshyun.roulette.entity.QMenu;
import com.pshyun.roulette.service.EatMenuService;
import com.pshyun.roulette.service.MenuService;

@Controller
@RequestMapping("/menu/list")
public class MenuController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	EatMenuService eatMenuService;
	
	@Autowired
	EntityManager em;
	
	/**
	 * 메뉴 전체 리스트 가져오기
	 * @param request
	 * @return
	 */
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
	
	/**
	 * 메뉴 추가
	 * @param request
	 * @param menuName
	 * @return
	 */
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
	
	/**
	 * 메뉴 삭제
	 * @param request
	 * @param menuNo
	 * @return
	 */
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
	
	/**
	 * 룰렛 돌리기
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/roulette", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON runRoulette(HttpServletRequest request) {
		ResultJSON resultJSON = new ResultJSON();
		JPAQuery jpaQuery = new JPAQuery(em);
		QMenu qMenu = QMenu.menu;
		QEatMenu qEatMenu = QEatMenu.eatMenu;
		// 오늘이 포함된 주의 월요일과 일요일 날짜를 가져온다.
		String today = DateUtils.getDateString();
		String monday = DateUtils.getMondayDate(today);
		String sunday = DateUtils.getSundayDate(today);
		String mondayDate = "";
		String sundayDate = "";
		try {
			mondayDate = DateUtils.reFormat(monday, "yyyyMMdd", "yyyy-MM-dd") + " 00:00:00";
			sundayDate = DateUtils.reFormat(sunday, "yyyyMMdd", "yyyy-MM-dd") + " 23:59:59";
		} catch (ParseException e) {
			log.debug("Date reFormat error.");
		}
		
		List<EatMenu> eatMenuList = jpaQuery.from(qEatMenu).where(qEatMenu.eatDate.between(mondayDate, sundayDate)).list(qEatMenu);
		List<Menu> menuList = null;
		if (eatMenuList.size() > 0) {
			Number[] intArray = new Number[eatMenuList.size()];
			for (int i = 0; i < eatMenuList.size(); i++) {
				intArray[i] = eatMenuList.get(i).getMenuNo();
			}
			menuList = jpaQuery.from(qMenu).where(qMenu.menuNo.notIn(intArray)).list(qMenu);
		} else {
			menuList = menuService.findAll();
		}
		
		Random random = new Random();
		resultJSON.setData(menuList.get(random.nextInt(menuList.size())));
		resultJSON.setSuccess(true);
		return resultJSON;
	}
	
	/**
	 * 정한 메뉴 저장하기
	 * @param request
	 * @param menuNo
	 * @param menuName
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON saveMenu(HttpServletRequest request, @RequestParam int menuNo, @RequestParam String menuName) {
		ResultJSON resultJSON = new ResultJSON();
		/*Menu menu = new Menu();
		menu.setMenuNo(menuNo);
		menu = menuService.findByMenuNo(menu);*/
		EatMenu eatMenu = new EatMenu();
		eatMenu.setMenuNo(menuNo);
		eatMenu.setMenuName(menuName);
		eatMenu.setEatDate(DateUtils.getDateTimeString());
		eatMenuService.save(eatMenu);
		
		resultJSON.setSuccess(true);
		return resultJSON;
	}
	
	/**
	 * 메뉴 이름 수정하기
	 * @param request
	 * @param menuNo
	 * @param menuName
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public ResultJSON updateMenu(HttpServletRequest request, @RequestParam int menuNo, @RequestParam String menuName) {
		ResultJSON resultJSON = new ResultJSON();
		int result = em.createQuery("UPDATE menu SET menu_name = '" + menuName + "' WHERE menu_no = " + menuNo).executeUpdate();
		if (1 != result) {
			resultJSON.setSuccess(false);
			return resultJSON;
		}
		
		resultJSON.setSuccess(true);
		return resultJSON;
	}
}
