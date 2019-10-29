-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 29 Paź 2019, 21:13
-- Wersja serwera: 5.6.13
-- Wersja PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `aukcja-db`
--
CREATE DATABASE IF NOT EXISTS `aukcja-db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `aukcja-db`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `aukcje`
--

CREATE TABLE IF NOT EXISTS `aukcje` (
  `id-aukcja` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `opis` text,
  `data-create` varchar(45) DEFAULT NULL,
  `data-start` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id-aukcja`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Zrzut danych tabeli `aukcje`
--

INSERT INTO `aukcje` (`id-aukcja`, `name`, `opis`, `data-create`, `data-start`) VALUES
(1, 'test-1', 'bla bla', '21.10.2019', '28.10.2019'),
(2, 'test-2', 'bla bla', '21.10.2019', '26.10.2019'),
(3, 'test-3', 'bla bla', '21.10.2019', '27.10.2019');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `bidders`
--

CREATE TABLE IF NOT EXISTS `bidders` (
  `id-bidder` int(11) NOT NULL AUTO_INCREMENT,
  `id-aukcja` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `domiar` int(11) DEFAULT '0',
  PRIMARY KEY (`id-bidder`),
  KEY `id-aukcja` (`id-aukcja`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Zrzut danych tabeli `bidders`
--

--INSERT INTO `bidders` (`id-bidder`, `id-aukcja`, `name`, `email`, `domiar`) VALUES
--(1, 1, 'EPO', 'epo1@epo.com', 0),
--(2, 1, 'HUA', 'hua@hua.com', 0),
--(3, 1, 'Nokia', 'nokia@nokia.com', 0),
--(4, 2, 'EPO', 'epo@epo.com', 20),
--(5, 2, 'ZTE', 'zte@zte.com', 0),
--(6, 3, 'Computaris', 'c@compt.com', 0),
--(7, 3, 'Asseco', 'ass@ass.com', 0),
--(8, 2, 'Asseco', 'ass@ass.com', 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `bids`
--

CREATE TABLE IF NOT EXISTS `bids` (
  `id-bid` int(11) NOT NULL AUTO_INCREMENT,
  `id-bidder` int(11) NOT NULL,
  `id-step` int(11) NOT NULL,
  `min-post` int(11) NOT NULL,
  `cena` int(11) NOT NULL,
  `pozycja` int(11) NOT NULL,
  `id-aukcja` int(11) NOT NULL,
  PRIMARY KEY (`id-bid`),
  KEY `id-bidder` (`id-bidder`),
  KEY `id-aukcja` (`id-aukcja`),
  KEY `id-step` (`id-step`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `steps`
--

CREATE TABLE IF NOT EXISTS `steps` (
  `id-step` int(11) NOT NULL AUTO_INCREMENT,
  `id-aukcja` int(11) NOT NULL,
  `krok-nr` int(11) NOT NULL,
  `min-change` int(11) NOT NULL,
  PRIMARY KEY (`id-step`),
  KEY `id-aukcja` (`id-aukcja`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `bidders`
--
ALTER TABLE `bidders`
  ADD CONSTRAINT `bidders_ibfk_1` FOREIGN KEY (`id-aukcja`) REFERENCES `aukcje` (`id-aukcja`);

--
-- Ograniczenia dla tabeli `bids`
--
ALTER TABLE `bids`
  ADD CONSTRAINT `bids_ibfk_3` FOREIGN KEY (`id-step`) REFERENCES `steps` (`id-step`),
  ADD CONSTRAINT `bids_ibfk_1` FOREIGN KEY (`id-bidder`) REFERENCES `bidders` (`id-bidder`),
  ADD CONSTRAINT `bids_ibfk_2` FOREIGN KEY (`id-aukcja`) REFERENCES `aukcje` (`id-aukcja`);

--
-- Ograniczenia dla tabeli `steps`
--
ALTER TABLE `steps`
  ADD CONSTRAINT `steps_ibfk_1` FOREIGN KEY (`id-aukcja`) REFERENCES `aukcje` (`id-aukcja`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
