-- MySQL Workbench Synchronization
-- Generated: 2021-01-28 18:27
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Gustavo Medeiros

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Oficina` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `Oficina`.`Cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `endereco` VARCHAR(80) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`Mecanico` (
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
    REFERENCES `Oficina`.`Equipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`Carro` (
  `id` INT(11) NOT NULL,
  `placa` VARCHAR(8) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `km` DECIMAL NOT NULL,
  `idCliente` INT(11) NOT NULL,
  INDEX `fk_Carro_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Carro_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `Oficina`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`Equipe` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`OS` (
  `numero` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `idCarro` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  `idEquipe` INT(11) NOT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_OS_Carro1_idx` (`idCarro` ASC) VISIBLE,
  INDEX `fk_OS_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  INDEX `fk_OS_Equipe1_idx` (`idEquipe` ASC) VISIBLE,
  CONSTRAINT `fk_OS_Carro1`
    FOREIGN KEY (`idCarro`)
    REFERENCES `Oficina`.`Carro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OS_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `Oficina`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OS_Equipe1`
    FOREIGN KEY (`idEquipe`)
    REFERENCES `Oficina`.`Equipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`Produto/Servico` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Oficina`.`OS-Produto/Servico` (
  `numeroOS` INT(11) NOT NULL,
  `idProdutoServico` INT(11) NOT NULL,
  PRIMARY KEY (`numeroOS`, `idProdutoServico`),
  INDEX `fk_OS-Produto/Servico_OS1_idx` (`numeroOS` ASC) VISIBLE,
  INDEX `fk_OS-Produto/Servico_Produto/Servico1_idx` (`idProdutoServico` ASC) VISIBLE,
  CONSTRAINT `fk_OS-Produto/Servico_OS1`
    FOREIGN KEY (`numeroOS`)
    REFERENCES `Oficina`.`OS` (`numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OS-Produto/Servico_Produto/Servico1`
    FOREIGN KEY (`idProdutoServico`)
    REFERENCES `Oficina`.`Produto/Servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
