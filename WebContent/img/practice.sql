-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 
-- サーバのバージョン： 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `practice`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `account`
--

CREATE TABLE `account` (
  `USER_ID` char(10) CHARACTER SET utf8 NOT NULL,
  `PASS` varchar(10) CHARACTER SET utf8 NOT NULL,
  `MAIL` varchar(100) CHARACTER SET utf8 NOT NULL,
  `NAME` varchar(40) CHARACTER SET utf8 NOT NULL,
  `AGE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `account`
--

INSERT INTO `account` (`USER_ID`, `PASS`, `MAIL`, `NAME`, `AGE`) VALUES
('0001', 'aaaa', 'aaa@aaa.aaa', 'あああああああ', 20),
('0002', 'bbbb', 'bbb@bbb.bbb', 'いいいいいい', 52),
('0003', 'cccc', 'cccc@ccc.ccc', 'ううううう', 45),
('0004', 'dddd', 'ddd@dddd.dd', 'ええええええ', 32),
('0005', 'eeee', 'eeee@ee.ee', 'おおおおおお', 46);

-- --------------------------------------------------------

--
-- テーブルの構造 `goods`
--

CREATE TABLE `goods` (
  `g_id` int(3) NOT NULL,
  `g_name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `g_price` int(11) NOT NULL,
  `g_contents` varchar(20) CHARACTER SET utf8 NOT NULL,
  `g_flag` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- テーブルのデータのダンプ `goods`
--

INSERT INTO `goods` (`g_id`, `g_name`, `g_price`, `g_contents`, `g_flag`) VALUES
(101, 'いぬ', 1000, 'わんわんわんわん', 0),
(201, 'ねずみ', 1000, 'ちゅうちゅうちゅうちゅう', 0),
(301, 'ねこ', 1000, 'にゃーにゃーにゃ', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`USER_ID`);

--
-- Indexes for table `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`g_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `goods`
--
ALTER TABLE `goods`
  MODIFY `g_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=302;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
