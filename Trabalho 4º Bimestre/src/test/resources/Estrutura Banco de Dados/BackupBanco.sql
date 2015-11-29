/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.9-log : Database - tabalho4thbim
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tabalho4thbim` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tabalho4thbim`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  `endereco` varchar(30) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `genero` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `itemvenda` */

DROP TABLE IF EXISTS `itemvenda`;

CREATE TABLE `itemvenda` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `iditemvenda` int(10) NOT NULL,
  `idvenda` int(10) NOT NULL,
  `descricao` varchar(30) DEFAULT NULL,
  `categoria` varchar(20) DEFAULT NULL,
  `quantidade` int(10) DEFAULT NULL,
  `vlrunidade` decimal(10,2) DEFAULT NULL,
  `vlrtotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_venda_idvenda` (`idvenda`),
  CONSTRAINT `fk_venda_idvenda` FOREIGN KEY (`idvenda`) REFERENCES `itemvenda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `produto` */

DROP TABLE IF EXISTS `produto`;

CREATE TABLE `produto` (
  `id` int(10) NOT NULL,
  `codbarras` varchar(30) DEFAULT NULL,
  `categoria` varchar(15) DEFAULT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `unidade` varchar(5) DEFAULT NULL,
  `custo` decimal(10,2) DEFAULT NULL,
  `margemlucro` decimal(10,2) DEFAULT NULL,
  `custofinal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` int(10) NOT NULL,
  `nomecliente` varchar(40) DEFAULT NULL,
  `idcliente` int(10) DEFAULT NULL,
  `senha` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `venda` */

DROP TABLE IF EXISTS `venda`;

CREATE TABLE `venda` (
  `idvenda` int(10) NOT NULL,
  `idcliente` int(10) NOT NULL,
  `nomecliente` varchar(30) DEFAULT NULL,
  `datavenda` date DEFAULT NULL,
  `horavenda` varchar(10) DEFAULT NULL,
  `totalcompra` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idvenda`),
  KEY `fk_cliente_id` (`idcliente`),
  CONSTRAINT `fk_cliente_id` FOREIGN KEY (`idcliente`) REFERENCES `venda` (`idvenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
