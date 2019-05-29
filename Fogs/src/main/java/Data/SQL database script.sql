/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Fog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Fog
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Fog`;
CREATE SCHEMA IF NOT EXISTS `Fog` DEFAULT CHARACTER SET utf8 ;
USE `Fog` ;

-- -----------------------------------------------------
-- Table `Fog`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog`.`category` (
  `id_category` INT(11) NOT NULL,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog`.`materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog`.`materials` (
  `id_material` INT(11) AUTO_INCREMENT,
  `description` VARCHAR(200) NOT NULL,
  `height` INT(11) NULL,
  `width` INT(11) NULL,
  `length` INT(11) NULL,
  `price` DOUBLE NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  `id_category` INT(11) NOT NULL,
  PRIMARY KEY (`id_material`),
  INDEX `id_category_idx` (`id_category` ASC) ,
  CONSTRAINT `id_category`
    FOREIGN KEY (`id_category`)
    REFERENCES `Fog`.`category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog`.`customers` (
  `id_customer` INT(11) NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_customer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog`.`roles` (
  `id_role` INT(11) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`, `role`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Fog`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog`.`employees` (
	`id_employee` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
	`name` VARCHAR(45) NOT NULL,
	`role` VARCHAR(45) NOT NULL,
	`password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_employee`),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC),
  CONSTRAINT `employees_ibfk_1`
    FOREIGN KEY (`role`)
    REFERENCES `fog`.`roles` (`id_role`))
ENGINE = InnoDB;
  


-- -----------------------------------------------------
-- Table `Fog`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog`.`orders` (
  `id_order` INT (11) AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  `order_width` INT(11) NOT NULL,
  `order_length` INT(11) NOT NULL,
  `order_width_shed` INT(11) DEFAULT NULL,
  `order_length_shed` INT(11) DEFAULT NULL,
  `incline` INT(11) NOT NULL,
  `id_customer` INT(11) NOT NULL,
  `id_employee` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
--  `Date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_order`),
  INDEX `id_customer_idx` (`id_customer` ASC) ,
  INDEX `id_employee_idx` (`id_employee` ASC) ,
  CONSTRAINT `id_customer`
    FOREIGN KEY (`id_customer`)
    REFERENCES `Fog`.`customers` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `Fog`.`employees` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `testuser2`@`%` 
    SQL SECURITY DEFINER
VIEW `Fog`.`users` AS
    SELECT 
        `E`.`id_employee` AS `id_employee`,
        `E`.`username` AS `username`,
        `E`.`name` AS `name`,
        `R`.`role` AS `role`
    FROM
        (`Fog`.`employees` `E`
        JOIN `Fog`.`roles` `R` ON ((`E`.`role` = `R`.`id_role`)));


 CREATE VIEW `ordersview` AS
    SELECT 
        `id_order`,
        `status`,
        `order_width`,
        `order_length`,
        `order_width_shed`,
        `order_length_shed`,
        `incline`,
        `customer_name`,
        `id_customer`,
        `name`,
        `id_employee`,
        `price`
    FROM
        `orders`
            NATURAL JOIN
        `customers`
        NATURAL JOIN
        `employees`;        
        
        
INSERT INTO `Fog`.`category` VALUES(1,'Skruer');
INSERT INTO `Fog`.`category` VALUES(2,'Brædder');
INSERT INTO `Fog`.`category` VALUES(3,'Beslag');
INSERT INTO `Fog`.`category` VALUES(4,'Hængsler');
INSERT INTO `Fog`.`category` VALUES(5,'Tagbeklædning');
INSERT INTO `Fog`.`category` VALUES(6, 'Misc');
-- INSERT INTO customers VALUES(5, 'john', '22548884','simonkruse2@gmail.com');
INSERT INTO roles VALUES(1, 'admin');
INSERT INTO roles VALUES(2, 'salesperson');
INSERT INTO roles VALUES(3, 'picker');
INSERT INTO employees (`username`, `name`,`role`,`password`) VALUES('admin', 'Carl Carlsen', 1, MD5('admin'));
INSERT INTO employees (`username`, `name`,`role`,`password`) VALUES('salesperson', 'Hans Hansen', 2, MD5('salesperson'));


INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('plastmo bundskruer 200 stk. - Ikke i brug', 'Pakke',100,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('hulbånd 1x20 mm. 10 mtr. - Ikke i brug','Rulle',275,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('universal 190 mm. højre','Stk',200,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('universal 190 mm. venstre', 'Stk', 250,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('4,5 x 60 mm. skruer 200 stk. - Skur - Skurdør', 'Pakke',50,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('4,0 x 60 mm. beslagskruer 250 stk. - Carport - Stolpe- og spærbeslagsskruer', 'Pakke',50,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('bræddebolt 10 x 120 mm.', 'Stk',150,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('firkantskiver 40 x 40 x 11 mm', 'Stk',75,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('4,5 x 70 mm. skruer 400 stk. - Skur - Beklædning', 'Pakke',140,1);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('4,5 x 50 mm. skruer 300 stk. - Carport - Rammebeklædning', 'Pakke',175,1);

INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('25x200 mm. trykimp. Brædt - Skur - Skeletbredde','Stk',25,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('25x200 mm. trykimp. Brædt - Skur - Skeletvidde','Stk',25,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('25x125 mm. trykimp. Brædt - Ikke i brug','Stk',90,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('25x125 mm. trykimp. Brædt - Carport - Bjælker','Stk',440,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('19x100 mm. trykimp. Brædt - Ikke i brug','Stk',65,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('19x100 mm. trykimp. Brædt - Ikke i brug','Stk',240,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('19x100 mm. trykimp. Brædt - Carport - ramme','Stk',205,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('38x73 mm. Lægte ubh. - Skur - Dørskelet','Stk',500,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('45x95 mm. Reglar ubh. - Ikke i brug','Stk',165,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('45x95 mm. Reglar ubh. - Ikke i brug','Stk',100,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('45x195 mm. spærtræ ubh. - Carport - Spær','Stk',355,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('45x195 mm. spærtræ ubh. - Ikke i brug','Stk',495,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('45x195 mm. spærtræ ubh. - Ikke i brug','Stk',85,2);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('97x97 mm. trykimp. - Carport - Stolpe','Stk',355,2);

INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('Vinkelbeslag 35 mm - Carport - stolpe- og spærbeslag','Stk',100,3);

INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('Stalddørsgreb 50 x 75 mm. - Skur - dørhåndtag','Sæt',75,6);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('T-hængsel 390 mm. - Skur - dørhængsel','Stk',50,4);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('Plastmo Exolite blåtonet - Lang', 'Stk',402.5,5);
INSERT INTO `materials` (`description`,`unit`,`price`,`id_category`)VALUES('Plastmo Exolite blåtonet - Kort', 'Stk', 195,5);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

USE `Fog`;