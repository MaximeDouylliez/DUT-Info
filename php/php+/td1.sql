-- phpMyAdmin SQL Dump
-- version 3.3.7deb5build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mer 25 Janvier 2012 à 16:21
-- Version du serveur: 5.1.49
-- Version de PHP: 5.3.3-1ubuntu9.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `td1`
--

-- --------------------------------------------------------

--
-- Structure de la table `news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `titre` text NOT NULL,
  `texte` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `news`
--

INSERT INTO `news` (`id`, `date`, `titre`, `texte`) VALUES
(8, '2012-01-24', 'mardi', 'mardi'),
(9, '2012-01-23', 'lundi', 'lundi'),
(10, '2012-01-25', 'mercredi', 'mercredi'),
(11, '2012-01-24', 'tuesday', 'tuesday'),
(12, '2012-01-23', 'monday', 'monday'),
(13, '2012-01-25', 'wednesday', 'wednesday');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `email` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `groupe` int(1) NOT NULL DEFAULT '2',
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`email`, `nom`, `prenom`, `mdp`, `groupe`) VALUES
('test', 'test', 'test', 'test', 2),
('admin', 'admin', 'admin', 'admin', 0),
('igi', 'igi', 'igi', 'igi', 1);
