/*
SQLyog Ultimate v12.3.2 (64 bit)
MySQL - 5.5.28 : Database - javacontrol
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javacontrol` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `javacontrol`;

/*Table structure for table `acceso` */

DROP TABLE IF EXISTS `acceso`;

CREATE TABLE `acceso` (
  `id_acceso` int(11) NOT NULL,
  `ci` varchar(10) DEFAULT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellido` varchar(60) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL,
  `usu` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_acceso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `acceso` */

insert  into `acceso`(`id_acceso`,`ci`,`nombre`,`apellido`,`direccion`,`email`,`rol`,`usu`,`pass`,`estado`) values 
(1,'3416435','FREDY DAVID','BENITEZ PORTILLO','BARRIO ITA PASO - MANZANA 27 , LOTE 83','lic_fredy_benitez@hotmail.es','ENCARGADO/COMPRA','fredy2017','fredy2017','ACTIVO'),
(2,'4841795','SHYRLEY MARIA','VILLALBA ARGUELLO','BARRIO VILLA DEL MAESTRO - CALLE COSTANERA','svmaria90@hotmail.com','ENCARGADO/COMPRA','maria90','maria90','ACTIVO'),
(3,'1234567','PEDRO','FIGUEREDO','','','ENCARGADO/COMPRA','pedro','pedro','ACTIVO');

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `ci` varchar(20) DEFAULT NULL,
  `nomape` varchar(80) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

/*Table structure for table `compra` */

DROP TABLE IF EXISTS `compra`;

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_acceso` int(11) NOT NULL,
  `nro_boleta` varchar(20) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `anulado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `id_acceso` (`id_acceso`),
  KEY `id_proveedor` (`id_proveedor`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_acceso`) REFERENCES `acceso` (`id_acceso`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `compra` */

insert  into `compra`(`id_compra`,`id_proveedor`,`id_acceso`,`nro_boleta`,`fecha`,`anulado`) values 
(1,1,1,'12345','2017-08-26 00:00:00','NO'),
(2,1,1,'667777','2017-05-05 00:00:00','NO'),
(3,1,1,'156422','2017-08-26 00:00:00','NO'),
(4,1,1,'77777777','2016-12-12 00:00:00','NO'),
(5,1,1,'256000','2017-09-07 00:00:00','NO');

/*Table structure for table `compra_detalle` */

DROP TABLE IF EXISTS `compra_detalle`;

CREATE TABLE `compra_detalle` (
  `id_compra` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `precio` int(11) DEFAULT NULL,
  `cant` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_compra`,`id_producto`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `compra_detalle_ibfk_1` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `compra_detalle_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `compra_detalle` */

insert  into `compra_detalle`(`id_compra`,`id_producto`,`precio`,`cant`) values 
(1,1,10000,5),
(2,1,10,1),
(3,2,150000,5),
(3,3,250000,7),
(3,4,350000,15),
(4,1,160000,10),
(4,3,250000,7),
(5,1,500000,5),
(5,4,350000,15);

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `cod_barra` varchar(25) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `cant_inicial` int(11) DEFAULT NULL,
  `precio_venta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

insert  into `producto`(`id_producto`,`cod_barra`,`nombre`,`descripcion`,`cant_inicial`,`precio_venta`) values 
(1,'11111','hhh','jjj',1,10),
(2,'6889898','termo','',5,150000),
(3,'888888','pantalle','',7,250000),
(4,'999999999','mouse','',15,350000);

/*Table structure for table `proveedor` */

DROP TABLE IF EXISTS `proveedor`;

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `ruc` varchar(15) DEFAULT NULL,
  `razon` varchar(70) DEFAULT NULL,
  `nomape` varchar(70) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `proveedor` */

insert  into `proveedor`(`id_proveedor`,`ruc`,`razon`,`nomape`,`direccion`,`telefono`,`email`) values 
(1,'12345','JUAN s.r.l.','juan','san juan','1111','juan@gmail.com');

/*Table structure for table `venta` */

DROP TABLE IF EXISTS `venta`;

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `id_acceso` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `nro_factura` varchar(20) DEFAULT NULL,
  `anulado` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_acceso` (`id_acceso`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_acceso`) REFERENCES `acceso` (`id_acceso`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `venta` */

/*Table structure for table `venta_detalle` */

DROP TABLE IF EXISTS `venta_detalle`;

CREATE TABLE `venta_detalle` (
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cant` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_venta`,`id_producto`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `venta_detalle_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`),
  CONSTRAINT `venta_detalle_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `venta_detalle` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
