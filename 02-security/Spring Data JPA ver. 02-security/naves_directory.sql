CREATE DATABASE  IF NOT EXISTS `naves_directory`;
USE `naves_directory`;

DROP TABLE IF EXISTS `nave_espacial`;

CREATE TABLE `nave_espacial` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `capacidad_tripulacion` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `nave_espacial` VALUES 
    (1,'Halcón Milenario','Carguero corelliano YT-1300',4),
    (2,'USS Enterprise','Clase Constitución',430),
    (3,'Endurance','Exploración Interespacial',4);