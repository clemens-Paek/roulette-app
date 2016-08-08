package com.pshyun.roulette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pshyun.roulette.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
	List<Menu> findAllByOrderByMenuNoDesc();
}
