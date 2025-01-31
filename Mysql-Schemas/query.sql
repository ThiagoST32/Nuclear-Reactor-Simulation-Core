-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nuclearFission` DEFAULT CHARACTER SET utf8 ;
USE `nuclearFission` ;

-- -----------------------------------------------------
-- Table `nuclearFission`.`Reactor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nuclearFission`.`Reactor` (
  `idReactor` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ReactorType` VARCHAR(45) NULL,
  `Temperature` DOUBLE NULL,
  `NeutronFlux` DOUBLE NULL,
  `TankCapacity` DOUBLE NULL,
  PRIMARY KEY (`idReactor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nuclearFission`.`ChemicalElement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nuclearFission`.`ChemicalElement` (
  `idChemicalElement` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Simbol` CHAR(3) NULL,
  `AtomicNumber` DOUBLE NULL,
  `MassAtomic` DOUBLE NULL,
  `TypeFission` ENUM('SPONTANEA', 'INDUZIDA') NULL,
  PRIMARY KEY (`idChemicalElement`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nuclearFission`.`Simulation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nuclearFission`.`Simulation` (
  `idSimulation` INT NOT NULL AUTO_INCREMENT,
  `VoidProduced` DOUBLE NULL,
  `WaterInject` DOUBLE NULL,
  `EnergyProduced` DOUBLE NULL,
  `SimulationDate` TIMESTAMP NULL,
  `idReactor` INT UNSIGNED NOT NULL,
  `idChemicalElement` INT NOT NULL,
  PRIMARY KEY (`idSimulation`, `idReactor`),
  CONSTRAINT `fk_Simulacao_Reactor1`
    FOREIGN KEY (`idReactor`)
    REFERENCES `nuclearFission`.`Reactor` (`idReactor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Simulation_ChemicalElement1`
    FOREIGN KEY (`idChemicalElement`)
    REFERENCES `nuclearFission`.`ChemicalElement` (`idChemicalElement`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EventLog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nuclearFission`.`EventLog` (
  `idEventoLog` INT NOT NULL AUTO_INCREMENT,
  `idSimulation` INT NOT NULL,
  `Datalog` TIMESTAMP NULL,
  `EventType` ENUM('Fail', 'Critical', 'Avarage') NULL,
  `Eventocol` VARCHAR(45) NULL,
  PRIMARY KEY (`idEventoLog`, `idSimulation`),
  CONSTRAINT `fk_Evento_Simulacao1`
    FOREIGN KEY (`idSimulation`)
    REFERENCES `nuclearFission`.`Simulation` (`idSimulation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
