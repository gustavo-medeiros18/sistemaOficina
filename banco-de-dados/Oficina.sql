-- MySQL Workbench Synchronization
-- Generated: 2021-02-22 17:22
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Gustavo Medeiros

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `oficina` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `oficina`.`carro` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(8) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `km` DECIMAL(10,0) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Carro_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Carro_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `oficina`.`cliente` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oficina`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `endereco` VARCHAR(80) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oficina`.`equipe` (
  `id` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oficina`.`mecanico` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `endereco` VARCHAR(80) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `idEquipe` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Mecanico_Equipe1_idx` (`idEquipe` ASC) VISIBLE,
  CONSTRAINT `fk_Mecanico_Equipe1`
    FOREIGN KEY (`idEquipe`)
    REFERENCES `oficina`.`equipe` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oficina`.`os` (
  `numero` INT(11) NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(10) NOT NULL,
  `idCarro` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  `idEquipe` INT(11) NOT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_OS_Carro1_idx` (`idCarro` ASC) VISIBLE,
  INDEX `fk_OS_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  INDEX `fk_OS_Equipe1_idx` (`idEquipe` ASC) VISIBLE,
  CONSTRAINT `fk_OS_Carro1`
    FOREIGN KEY (`idCarro`)
    REFERENCES `oficina`.`carro` (`id`),
  CONSTRAINT `fk_OS_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `oficina`.`cliente` (`id`),
  CONSTRAINT `fk_OS_Equipe1`
    FOREIGN KEY (`idEquipe`)
    REFERENCES `oficina`.`equipe` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oficina`.`os-produto/servico` (
  `idOSPS` INT(11) NOT NULL AUTO_INCREMENT,
  `numeroOS` INT(11) NOT NULL,
  `idProdutoServico` INT(11) NOT NULL,
  PRIMARY KEY (`idOSPS`),
  INDEX `fk_OS-Produto/Servico_OS1_idx` (`numeroOS` ASC) VISIBLE,
  INDEX `fk_OS-Produto/Servico_Produto/Servico1_idx` (`idProdutoServico` ASC) VISIBLE,
  CONSTRAINT `fk_OS-Produto/Servico_OS1`
    FOREIGN KEY (`numeroOS`)
    REFERENCES `oficina`.`os` (`numero`),
  CONSTRAINT `fk_OS-Produto/Servico_Produto/Servico1`
    FOREIGN KEY (`idProdutoServico`)
    REFERENCES `oficina`.`produto/servico` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oficina`.`produto/servico` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
