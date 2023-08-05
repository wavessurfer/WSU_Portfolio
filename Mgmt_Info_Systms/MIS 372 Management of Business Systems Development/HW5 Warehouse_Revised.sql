-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema warehouse_revised
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema warehouse_revised
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `warehouse_revised` DEFAULT CHARACTER SET utf8mb4 ;
USE `warehouse_revised` ;

-- -----------------------------------------------------
-- Table `warehouse_revised`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_revised`.`categories` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_revised`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_revised`.`products` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `quantity` VARCHAR(50) NULL DEFAULT NULL,
  `buy_price` DECIMAL(25,2) NULL DEFAULT NULL,
  `sale_price` DECIMAL(25,2) NOT NULL,
  `categorie_id` INT(11) UNSIGNED NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name` (`name` ASC) VISIBLE,
  INDEX `categorie_id` (`categorie_id` ASC) VISIBLE,
  CONSTRAINT `FK_products`
    FOREIGN KEY (`categorie_id`)
    REFERENCES `warehouse_revised`.`categories` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_revised`.`media`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_revised`.`media` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(255) NOT NULL,
  `file_type` VARCHAR(100) NOT NULL,
  `products_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id` (`id` ASC) VISIBLE,
  INDEX `fk_media_products1_idx` (`products_id` ASC) VISIBLE,
  CONSTRAINT `fk_media_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `warehouse_revised`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `warehouse_revised`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_revised`.`sales` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_id` INT(11) UNSIGNED NOT NULL,
  `qty` INT(11) NOT NULL,
  `price` DECIMAL(25,2) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `SK`
    FOREIGN KEY (`product_id`)
    REFERENCES `warehouse_revised`.`products` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `warehouse_revised`.`user_groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_revised`.`user_groups` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(150) NOT NULL,
  `group_level` INT(11) NOT NULL,
  `group_status` INT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `group_level` (`group_level` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `warehouse_revised`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_revised`.`users` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `user_level` INT(11) NOT NULL,
  `image` VARCHAR(255) NULL DEFAULT 'no_image.jpg',
  `status` INT(1) NOT NULL,
  `last_login` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_level` (`user_level` ASC) VISIBLE,
  CONSTRAINT `FK_user`
    FOREIGN KEY (`user_level`)
    REFERENCES `warehouse_revised`.`user_groups` (`group_level`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `warehouse_revised`.`salesTransactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse_revised`.`salesTransactions` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `description` VARCHAR(45) NULL,
  `sales_id` INT(11) UNSIGNED NOT NULL,
  `users_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_salesTransactions_sales1_idx` (`sales_id` ASC) VISIBLE,
  INDEX `fk_salesTransactions_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_salesTransactions_sales1`
    FOREIGN KEY (`sales_id`)
    REFERENCES `warehouse_revised`.`sales` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_salesTransactions_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `warehouse_revised`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
