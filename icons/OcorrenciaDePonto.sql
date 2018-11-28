-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Setor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Setor` (
  `idSetor` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `idSetorPai` INT NOT NULL,
  PRIMARY KEY (`idSetor`),
  INDEX `fk_Setor_Setor1_idx` (`idSetorPai` ASC),
  CONSTRAINT `fk_Setor_Setor1`
    FOREIGN KEY (`idSetorPai`)
    REFERENCES `mydb`.`Setor` (`idSetor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cargo` (
  `idCargo` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idCargo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Funcionario` (
  `idFuncionario` INT NOT NULL,
  `nome` VARCHAR(256) NULL,
  `registro` INT NULL,
  `login` VARCHAR(45) NULL,
  `idSetor` INT NOT NULL,
  `idCargo` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  INDEX `fk_Funcionario_Setor1_idx` (`idSetor` ASC),
  INDEX `fk_Funcionario_Cargo1_idx` (`idCargo` ASC),
  CONSTRAINT `fk_Funcionario_Setor1`
    FOREIGN KEY (`idSetor`)
    REFERENCES `mydb`.`Setor` (`idSetor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Cargo1`
    FOREIGN KEY (`idCargo`)
    REFERENCES `mydb`.`Cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Apontamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Apontamento` (
  `idApontamento` INT NOT NULL,
  `dataDoApontamento` DATE NULL,
  `diaSemana` VARCHAR(3) NULL,
  `feriado` TINYINT NULL,
  `hora1` DATETIME NULL,
  `hora2` DATETIME NULL,
  `hora3` DATETIME NULL,
  `hora4` DATETIME NULL,
  `apont1` DATETIME NULL,
  `apont2` DATETIME NULL,
  `apont3` DATETIME NULL,
  `apont4` DATETIME NULL,
  `apont5` DATETIME NULL,
  `apont6` DATETIME NULL,
  `apont7` DATETIME NULL,
  `apont8` VARCHAR(45) NULL,
  `apont9` VARCHAR(45) NULL,
  `apont10` VARCHAR(45) NULL,
  `apont11` VARCHAR(45) NULL,
  `apont12` VARCHAR(45) NULL,
  `apont13` VARCHAR(45) NULL,
  `apont14` VARCHAR(45) NULL,
  `apont15` VARCHAR(45) NULL,
  `apont16` VARCHAR(45) NULL,
  `observacoes` VARCHAR(45) NULL,
  `idFuncionario` INT NOT NULL,
  PRIMARY KEY (`idApontamento`),
  INDEX `fk_Apontamento_Funcionario_idx` (`idFuncionario` ASC),
  CONSTRAINT `fk_Apontamento_Funcionario`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `mydb`.`Funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ocorrencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ocorrencia` (
  `idOcorrencia` INT NOT NULL,
  `dataHora` DATETIME NULL,
  `motivo` VARCHAR(512) NULL,
  `status` VARCHAR(1) NULL,
  `observacoesGerente` VARCHAR(512) NULL,
  `tipo` INT NULL,
  `diaTroca1` DATE NULL,
  `diaTroca2` DATE NULL,
  `horasExtras` TIME NULL,
  `pagar` TINYINT NULL,
  `chegadaAntecipada` DATETIME NULL,
  `chegadaAtrasada` DATETIME NULL,
  `ausenteMarcacao` DATETIME NULL,
  `saidaAntecipadal` DATETIME NULL,
  `naoComparecimento` DATE NULL,
  `idApontamento` INT NOT NULL,
  `idFuncionarioSolicitante` INT NOT NULL,
  `idFuncionarioAprovador` INT NOT NULL,
  `idFuncionarioTrocaTurno` INT NOT NULL,
  PRIMARY KEY (`idOcorrencia`),
  INDEX `fk_Ocorrencia_Apontamento1_idx` (`idApontamento` ASC),
  INDEX `fk_Ocorrencia_Funcionario1_idx` (`idFuncionarioSolicitante` ASC),
  INDEX `fk_Ocorrencia_Funcionario2_idx` (`idFuncionarioAprovador` ASC),
  INDEX `fk_Ocorrencia_Funcionario3_idx` (`idFuncionarioTrocaTurno` ASC),
  CONSTRAINT `fk_Ocorrencia_Apontamento1`
    FOREIGN KEY (`idApontamento`)
    REFERENCES `mydb`.`Apontamento` (`idApontamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ocorrencia_Funcionario1`
    FOREIGN KEY (`idFuncionarioSolicitante`)
    REFERENCES `mydb`.`Funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ocorrencia_Funcionario2`
    FOREIGN KEY (`idFuncionarioAprovador`)
    REFERENCES `mydb`.`Funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ocorrencia_Funcionario3`
    FOREIGN KEY (`idFuncionarioTrocaTurno`)
    REFERENCES `mydb`.`Funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
