-- MySQL Workbench Synchronization
-- Generated: 2021-01-17 23:27
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Gustavo Medeiros

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Oficina` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `Oficina`.`Cliente` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `endereco` VARCHAR(80) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`Mecanico` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `endereco` VARCHAR(80) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `codigoEquipe` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Mecanico_Equipe1_idx` (`codigoEquipe` ASC) VISIBLE,
  CONSTRAINT `fk_Mecanico_Equipe1`
    FOREIGN KEY (`codigoEquipe`)
    REFERENCES `Oficina`.`Equipe` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`Carro` (
  `placa` VARCHAR(7) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `km` DECIMAL NOT NULL,
  `codigoCliente` INT(11) NOT NULL,
  PRIMARY KEY (`placa`),
  INDEX `fk_Carro_Cliente1_idx` (`codigoCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Carro_Cliente1`
    FOREIGN KEY (`codigoCliente`)
    REFERENCES `Oficina`.`Cliente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`Equipe` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`OS` (
  `numero` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `placaCarro` VARCHAR(8) NOT NULL,
  `codigoCliente` INT(11) NOT NULL,
  `codigoEquipe` INT(11) NOT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_OS_Carro1_idx` (`placaCarro` ASC) VISIBLE,
  INDEX `fk_OS_Cliente1_idx` (`codigoCliente` ASC) VISIBLE,
  INDEX `fk_OS_Equipe1_idx` (`codigoEquipe` ASC) VISIBLE,
  CONSTRAINT `fk_OS_Carro1`
    FOREIGN KEY (`placaCarro`)
    REFERENCES `Oficina`.`Carro` (`placa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OS_Cliente1`
    FOREIGN KEY (`codigoCliente`)
    REFERENCES `Oficina`.`Cliente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OS_Equipe1`
    FOREIGN KEY (`codigoEquipe`)
    REFERENCES `Oficina`.`Equipe` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`Produto/Servico` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`OS-Produto/Servico` (
  `numeroOS` INT(11) NOT NULL,
  `codigoP/S` INT(11) NOT NULL,
  PRIMARY KEY (`numeroOS`, `codigoP/S`),
  INDEX `fk_OS-Produto/Servico_Produto/Servico1_idx` (`codigoP/S` ASC) VISIBLE,
  INDEX `fk_OS-Produto/Servico_OS1_idx` (`numeroOS` ASC) VISIBLE,
  CONSTRAINT `fk_OS-Produto/Servico_Produto/Servico1`
    FOREIGN KEY (`codigoP/S`)
    REFERENCES `Oficina`.`Produto/Servico` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OS-Produto/Servico_OS1`
    FOREIGN KEY (`numeroOS`)
    REFERENCES `Oficina`.`OS` (`numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
