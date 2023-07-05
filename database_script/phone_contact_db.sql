-- -----------------------------------------------------
-- Schema phone_contact
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `phone_contact` ;

-- -----------------------------------------------------
-- Schema phone_contact
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `phone_contact` DEFAULT CHARACTER SET utf8 ;
USE `phone_contact` ;

-- -----------------------------------------------------
-- Table `phone_contact`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phone_contact`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mail` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phone_contact`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phone_contact`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_contact_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_contact_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `phone_contact`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phone_contact`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phone_contact`.`email` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mail` VARCHAR(45) NOT NULL,
  `contact_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`mail`, `contact_id`),
  INDEX `fk_email_contact_idx` (`contact_id` ASC) VISIBLE,
  CONSTRAINT `fk_email_contact`
    FOREIGN KEY (`contact_id`)
    REFERENCES `phone_contact`.`contact` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phone_contact`.`phone_number`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phone_contact`.`phone_number` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NOT NULL,
  `contact_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`number`, `contact_id`),
  INDEX `fk_phone_number_contact1_idx` (`contact_id` ASC) VISIBLE,
  CONSTRAINT `fk_phone_number_contact1`
    FOREIGN KEY (`contact_id`)
    REFERENCES `phone_contact`.`contact` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE )
ENGINE = InnoDB;
