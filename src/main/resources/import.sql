--create database roulette;

--CREATE TABLE menu_list (
--	number INT NOT NULL AUTO_INCREMENT,
--  menuName VARCHAR(50) NOT NULL,
--  PRIMARY KEY (NUMBER)
--) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO menu (MENU_NAME) VALUES ('순대국집');
INSERT INTO menu (MENU_NAME) VALUES ('중국집');
INSERT INTO menu (MENU_NAME) VALUES ('교동짬뽕');
INSERT INTO menu (MENU_NAME) VALUES ('부대찌개');
INSERT INTO menu (MENU_NAME) VALUES ('닭갈비');
INSERT INTO menu (MENU_NAME) VALUES ('돈까스반찬집');
INSERT INTO menu (MENU_NAME) VALUES ('국수가');
INSERT INTO menu (MENU_NAME) VALUES ('푸드스토리');
INSERT INTO menu (MENU_NAME) VALUES ('분식집');
INSERT INTO menu (MENU_NAME) VALUES ('국수전골');
INSERT INTO menu (MENU_NAME) VALUES ('쭈꾸미');
INSERT INTO menu (MENU_NAME) VALUES ('유메야');
INSERT INTO menu (MENU_NAME) VALUES ('엽기떡볶이');
INSERT INTO menu (MENU_NAME) VALUES ('말뚝이');
INSERT INTO menu (MENU_NAME) VALUES ('돼지한근탕');
INSERT INTO menu (MENU_NAME) VALUES ('일미정');
INSERT INTO menu (MENU_NAME) VALUES ('닭볶음탕');

--CREATE TABLE eat_menu_list (
--  number INT NOT NULL,
--  menuName VARCHAR(50) NOT NULL,
--  eatDate DATETIME NOT NULL
--) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO eat_menu (MENU_NO, MENU_NAME, EAT_DATE) VALUES (1, '순대국집', '2016-08-08 11:45:23');
INSERT INTO eat_menu (MENU_NO, MENU_NAME, EAT_DATE) VALUES (3, '교동짬뽕', '2016-08-09 11:45:23');
INSERT INTO eat_menu (MENU_NO, MENU_NAME, EAT_DATE) VALUES (11, '쭈꾸미', '2016-08-10 11:45:23');

--select menuName from menu_list
--where number not in (select number from eat_menu_list 
--where eatDate between '2016-08-01 00:00:00' and '2016-08-05 23:59:59'); 
