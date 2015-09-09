-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Senasoft
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Senasoft
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Senasoft` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `Senasoft` ;

-- -----------------------------------------------------
-- Table `Senasoft`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Senasoft`.`productos` (
  `idproductos` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(45) NULL COMMENT '',
  `cantidad` VARCHAR(45) NULL COMMENT '',
  `costo` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`idproductos`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Senasoft`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Senasoft`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(45) NULL COMMENT '',
  `apellido` VARCHAR(45) NULL COMMENT '',
  `documento` VARCHAR(45) NULL COMMENT '',
  `productos_idproductos` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idcliente`)  COMMENT '',
  INDEX `fk_cliente_productos1_idx` (`productos_idproductos` ASC)  COMMENT '',
  CONSTRAINT `fk_cliente_productos1`
    FOREIGN KEY (`productos_idproductos`)
    REFERENCES `Senasoft`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Senasoft`.`distribuidora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Senasoft`.`distribuidora` (
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  `descripcion` VARCHAR(45) NULL COMMENT '',
  `productos_idproductos` INT NOT NULL COMMENT '',
  PRIMARY KEY (`nombre`)  COMMENT '',
  INDEX `fk_distribuidora_productos_idx` (`productos_idproductos` ASC)  COMMENT '',
  CONSTRAINT `fk_distribuidora_productos`
    FOREIGN KEY (`productos_idproductos`)
    REFERENCES `Senasoft`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
