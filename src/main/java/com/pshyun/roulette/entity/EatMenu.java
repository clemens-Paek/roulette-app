package com.pshyun.roulette.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "eat_menu")
public class EatMenu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 14382108098924905L;

	@Id
	private int menuNo;
	
	private String menuName;
	
	private String eatDate;
	
	public static EatMenu newInstance(int menuNo, String menuName, String eatDate) {
		return new EatMenu(menuNo, menuName, eatDate);
	}
	
	private EatMenu() {
		super();
	}
	
	private EatMenu(int menuNo, String menuName, String eatDate) {
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.eatDate = eatDate;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getEatDate() {
		return eatDate;
	}

	public void setEatDate(String eatDate) {
		this.eatDate = eatDate;
	}
	
	@Override
	public String toString() {
		return "EatMenuList [menuNo = " + menuNo + ", menuName = " + menuName + ", eatDate = " + eatDate + "]";
	}
	
}
