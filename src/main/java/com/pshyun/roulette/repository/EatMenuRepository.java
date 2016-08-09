package com.pshyun.roulette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pshyun.roulette.entity.EatMenu;

@Repository
public interface EatMenuRepository extends JpaRepository<EatMenu, Integer> {
	
	
}
