-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema crimedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `crimedb` ;

-- -----------------------------------------------------
-- Schema crimedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `crimedb` DEFAULT CHARACTER SET utf8 ;
USE `crimedb` ;

-- -----------------------------------------------------
-- Table `crime`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crime` ;

CREATE TABLE IF NOT EXISTS `crime` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_of` VARCHAR(100) NOT NULL,
  `date_of` DATETIME NOT NULL,
  `description` TEXT NULL,
  `location_of` VARCHAR(100) NULL,
  `investigator` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS crimer@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'crimer'@'localhost' IDENTIFIED BY 'crimer';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'crimer'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `crime`
-- -----------------------------------------------------
START TRANSACTION;
USE `crimedb`;
INSERT INTO `crime` (`id`, `type_of`, `date_of`, `description`, `location_of`, `investigator`) VALUES (1, 'robbery', '2022-01-01', 'bank of america', 'baltimore', 'John Doe');
INSERT INTO `crime` (`id`, `type_of`, `date_of`, `description`, `location_of`, `investigator`) VALUES (2, 'fraud', '2024-10-09', 'tax evasion', 'honolulu', NULL);

COMMIT;

