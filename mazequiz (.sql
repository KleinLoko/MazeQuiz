-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 27-05-2023 a las 21:55:09
-- Versión del servidor: 8.0.27
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mazequiz`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

DROP TABLE IF EXISTS `jugador`;
CREATE TABLE IF NOT EXISTS `jugador` (
  `jug_id` int NOT NULL AUTO_INCREMENT,
  `jug_nombre` varchar(45) NOT NULL,
  `jug_apellidopat` varchar(45) NOT NULL,
  `jug_apellidomat` varchar(45) NOT NULL,
  `jug_carrera` varchar(45) DEFAULT NULL,
  `jug_puntaje` int DEFAULT NULL,
  `jug_password` varchar(45) NOT NULL,
  PRIMARY KEY (`jug_id`),
  UNIQUE KEY `jug_id_UNIQUE` (`jug_id`),
  UNIQUE KEY `jug_password_UNIQUE` (`jug_password`)
) ENGINE=InnoDB AUTO_INCREMENT=42353449 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`jug_id`, `jug_nombre`, `jug_apellidopat`, `jug_apellidomat`, `jug_carrera`, `jug_puntaje`, `jug_password`) VALUES
(1321313, 'Guadalupe', 'Ruelas', 'Sandoval', 'IEI', 0, '2347'),
(2313133, 'Jose', 'Yañes', 'Lopez', 'IEI', 0, '3588953'),
(13241412, 'Aldo', 'Navarro', 'Medina', 'IEI', 0, '232323'),
(20202225, 'David', 'Vallejo', 'Ortiz', 'ITC', 0, '123'),
(20202226, 'Zayra', 'Avelar', 'Jaime', 'ITC', 7, '123123'),
(20202227, 'Dago', 'Salamanca', 'Puentes', 'IEI', 7, '33231'),
(20202228, 'Diego', 'Salamanca ', 'Puentes', 'ITC', 0, '13213'),
(20202244, 'Katy', 'Romo', 'Lopez', 'ITC', 2, '23131'),
(20202245, 'Cesar', 'Murillo', 'Figueroa', 'IER', 2, '1233223'),
(23131313, 'Claudia', 'Rivera', 'Romero', 'MTC', 0, '4434434'),
(38192453, 'Alfredo', 'Martinez', 'Minjares', 'ITC', 0, '131313'),
(42353445, 'Ulises', 'Lopez', 'Orozco', 'MTC', 0, '324242');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
CREATE TABLE IF NOT EXISTS `pregunta` (
  `pregid` int NOT NULL AUTO_INCREMENT,
  `PREG_DESCRIP` varchar(45) NOT NULL,
  `PREG_VALOR` int NOT NULL,
  PRIMARY KEY (`pregid`),
  UNIQUE KEY `PRE_ID_UNIQUE` (`pregid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`pregid`, `PREG_DESCRIP`, `PREG_VALOR`) VALUES
(1, '1q', 5),
(2, '2q', 5),
(3, '3q', 5),
(4, '4q', 5),
(5, '¿Lenguaje de progrmación orientado a objetos?', 10),
(6, 'Está compuesta de 4 octetos de 8 Bits', 5),
(7, '7q', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quiz`
--

DROP TABLE IF EXISTS `quiz`;
CREATE TABLE IF NOT EXISTS `quiz` (
  `id_quiz` int NOT NULL AUTO_INCREMENT,
  `pregid` int NOT NULL,
  `resid` int NOT NULL,
  `quiz_value` int NOT NULL,
  PRIMARY KEY (`id_quiz`),
  KEY `pregid` (`pregid`),
  KEY `resid` (`resid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `quiz`
--

INSERT INTO `quiz` (`id_quiz`, `pregid`, `resid`, `quiz_value`) VALUES
(1, 6, 7, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
CREATE TABLE IF NOT EXISTS `respuesta` (
  `resid` int NOT NULL,
  `res_descript` varchar(45) NOT NULL,
  PRIMARY KEY (`resid`),
  UNIQUE KEY `pregunta_UNIQUE` (`resid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`resid`, `res_descript`) VALUES
(1, 'MYSQL'),
(2, 'Java'),
(3, 'compilado'),
(4, 'HTML'),
(5, 'C++'),
(6, 'Entidad compuesta'),
(7, 'IP');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `quiz`
--
ALTER TABLE `quiz`
  ADD CONSTRAINT `quiz_ibfk_1` FOREIGN KEY (`pregid`) REFERENCES `pregunta` (`pregid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `quiz_ibfk_2` FOREIGN KEY (`resid`) REFERENCES `respuesta` (`resid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
