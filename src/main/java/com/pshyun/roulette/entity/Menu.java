package com.pshyun.roulette.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "menu")
public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8641620953124023806L;

	@Id
	@GeneratedValue
	@Column(name = "menu_no")
	private int menuNo;
	
	@Column(name = "menu_name")
	private String menuName;
	
	public static Menu newInstance(int menuNo, String menuName) {
		return new Menu(menuNo, menuName);
	}
	
	public Menu() {
		super();
	}
	
	private Menu(int menuNo, String menuName) {
		this.menuNo = menuNo;
		this.menuName = menuName;
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
	
	@Override
	public String toString() {
		return "MenuList [menuNo = " + menuNo + ", menuName = " + menuName + "]";
	}
}
