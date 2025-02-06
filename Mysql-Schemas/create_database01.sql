-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema nuclearfission
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nuclearfission
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nuclearfission` DEFAULT CHARACTER SET utf8 ;
USE `nuclearfission` ;

-- -----------------------------------------------------
-- Table `nuclearfission`.`ChemicalElement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nuclearfission`.`ChemicalElement` ;

CREATE TABLE IF NOT EXISTS `nuclearfission`.`ChemicalElement` (
  `chemical_id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Simbol` CHAR(2) NULL,
  `AtomicNumber` DOUBLE NULL,
  `MassAtomic` DOUBLE NULL,
  `TypeFission` ENUM('SPONTANEA', 'INDUZIDA') NULL,
  PRIMARY KEY (`chemical_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nuclearfission`.`Reactor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nuclearfission`.`Reactor` ;

CREATE TABLE IF NOT EXISTS `nuclearfission`.`Reactor` (
  `reactor_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `reactor_type` VARCHAR(45) NOT NULL,
  `max_temperature` DOUBLE NOT NULL,
  `min_temperature` DOUBLE NOT NULL,
  `fuel_capacity` DOUBLE NOT NULL,
  `moderator_type` VARCHAR(45) NOT NULL,
  `chemical_id` INT NOT NULL,
  PRIMARY KEY (`reactor_id`, `chemical_id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `nuclearfission`.`Simulation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nuclearfission`.`Simulation` ;

CREATE TABLE IF NOT EXISTS `nuclearfission`.`Simulation` (
  `simulation_id` INT NOT NULL AUTO_INCREMENT,
  `status` ENUM('RUNNING', 'COMPLETED', 'ABORTED') NULL DEFAULT 'RUNNING',
  `start_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `reactor_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`simulation_id`, `reactor_id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `nuclearfission`.`EventLog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nuclearfission`.`EventLog` ;

CREATE TABLE IF NOT EXISTS `nuclearfission`.`EventLog` (
  `event_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `start` TIMESTAMP NULL,
  `EventType` ENUM('Fail', 'Critical', 'Avarage') NULL,
  `Eventocol` VARCHAR(45) NULL,
  `simulation_id` INT NOT NULL,
  PRIMARY KEY (`event_id`, `simulation_id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `nuclearfission`.`ReactorState`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nuclearfission`.`ReactorState` ;

CREATE TABLE IF NOT EXISTS `nuclearfission`.`ReactorState` (
  `state_id` INT NOT NULL AUTO_INCREMENT,
  `ReactorStatecol` VARCHAR(45) NOT NULL,
  `timestamp` DATETIME(6) NOT NULL,
  `neutro_flux` DOUBLE NOT NULL,
  `temperature` DOUBLE NOT NULL,
  `pressure` DOUBLE NOT NULL,
  `coolant_flow_rate` DOUBLE NOT NULL,
  `reactor_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`state_id`, `reactor_id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `nuclearfission`.`ReactorSize`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nuclearfission`.`ReactorSize` ;

CREATE TABLE IF NOT EXISTS `nuclearfission`.`ReactorSize` (
  `idReactorSize` INT NOT NULL AUTO_INCREMENT,
  `totalsize` DOUBLE NULL,
  `diameter` DOUBLE NULL,
  `radius` DOUBLE NULL,
  `wallthickness` DOUBLE NULL,
  `reactor_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idReactorSize`, `reactor_id`))
ENGINE = InnoDB;


CREATE INDEX `fk_Reactor_ChemicalElement1_idx` ON `nuclearfission`.`Reactor` (`chemical_id` ASC);
CREATE INDEX `fk_Simulation_Reactor1_idx` ON `nuclearfission`.`Simulation` (`reactor_id` ASC) ;
CREATE INDEX `fk_EventLog_Simulation1_idx` ON `nuclearfission`.`EventLog` (`simulation_id` ASC);
CREATE INDEX `fk_ReactorState_Reactor1_idx` ON `nuclearfission`.`ReactorState` (`reactor_id` ASC);
CREATE INDEX `fk_ReactorSize_Reactor1_idx` ON `nuclearfission`.`ReactorSize` (`reactor_id` ASC);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
