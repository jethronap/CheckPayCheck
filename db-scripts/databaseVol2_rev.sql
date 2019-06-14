CREATE SCHEMA `CheckPay` DEFAULT CHARACTER SET utf8 ;

-- The first three table are all you need to run registration & login app:

CREATE TABLE IF NOT EXISTS `CheckPay`.`user` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `username` VARCHAR(30) NOT NULL,
   `password` VARCHAR(100) NOT NULL,
   `fname` VARCHAR(30) NOT NULL,
   `lname`  VARCHAR(30) NOT NULL,
   `email` VARCHAR(30) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE (`username`)
);

CREATE TABLE IF NOT EXISTS `CheckPay`.`role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
);

CREATE TABLE IF NOT EXISTS `CheckPay`.`user_role`(
	`user_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `CheckPay`.`admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `profession` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `passHashed` VARCHAR(50) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `CheckPay`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `profession` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `passHashed` VARCHAR(50) NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `CheckPay`.`history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_empl_id` INT NOT NULL,
  `dateOfWork` DATE NOT NULL,
  `hoursWorked` DECIMAL(6,2) DEFAULT NULL,
  `overtime` DECIMAL(6,2) DEFAULT NULL,
  `hoursSunday` DECIMAL(6,2) DEFAULT NULL,
  `salary` DECIMAL(10,2) DEFAULT NULL,
  `entitledSalary` DECIMAL(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employee_id_idx` (`fk_empl_id` ASC) VISIBLE,
  CONSTRAINT `fk_empl_id`
  FOREIGN KEY (`fk_empl_id`)
  REFERENCES `CheckPay`.`employee` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);
/*
CREATE TABLE IF NOT EXISTS `CheckPay`.`history` (
`id` INT NOT NULL AUTO_INCREMENT,
`dateOfWork` DATE NOT NULL,
`hoursWorked` DECIMAL(6,2) DEFAULT NULL,
`overtime` DECIMAL(6,2) DEFAULT NULL,
`hoursSunday` DECIMAL(6,2) DEFAULT NULL,
`salary` DECIMAL(10,2) DEFAULT NULL,
`entitledSalary` DECIMAL(10,2) DEFAULT NULL,
PRIMARY KEY (`id`)
);
*/
/*
CREATE TABLE IF NOT EXISTS `CheckPay`.`historyEmployees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_empl_id` INT NOT NULL,
  `fk_hist_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx1` (`fk_hist_id` ASC) VISIBLE,
  INDEX `fk_empl_id_idx` (`fk_empl_id` ASC) VISIBLE,
  CONSTRAINT `fk_empl_id`
    FOREIGN KEY (`fk_empl_id`)
    REFERENCES `CheckPay`.`employee` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_hist_id`
    FOREIGN KEY (`fk_hist_id`)
    REFERENCES `CheckPay`.`history` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
*/

CREATE TABLE IF NOT EXISTS `CheckPay`.`volunteer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `profession` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `passHashed` VARCHAR(50) NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `CheckPay`.`wallet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_vol_id` INT NOT NULL,
  `balance` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vol_id_idx` (`fk_vol_id` ASC) VISIBLE,
  CONSTRAINT `fk_vol_id`
    FOREIGN KEY (`fk_vol_id`)
    REFERENCES `CheckPay`.`volunteer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
