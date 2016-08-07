create database roulette;

CREATE TABLE menu_list (
	number INT NOT NULL AUTO_INCREMENT,
    menuName VARCHAR(50) NOT NULL,
    PRIMARY KEY (NUMBER)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO menu_list (menuName) VALUES ("순대국집");
INSERT INTO menu_list (menuName) VALUES ("중국집");
INSERT INTO menu_list (menuName) VALUES ("교동짬뽕");
INSERT INTO menu_list (menuName) VALUES ("부대찌개");
INSERT INTO menu_list (menuName) VALUES ("닭갈비");
INSERT INTO menu_list (menuName) VALUES ("돈까스반찬집");

CREATE TABLE eat_menu_list (
	number INT NOT NULL,
    menuName VARCHAR(50) NOT NULL,
    eatDate DATETIME NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO eat_menu_list (number, menuName, eatDate) VALUES (2, '중국집', '2016-08-05 11:45:23');

select menuName from menu_list
where number not in (select number from eat_menu_list 
where eatDate between '2016-08-01 00:00:00' and '2016-08-05 23:59:59'); 
