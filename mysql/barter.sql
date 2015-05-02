-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2015 at 11:28 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `barter`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE IF NOT EXISTS `events` (
`item_id` int(11) NOT NULL,
  `item_name` text NOT NULL,
  `item_img` text NOT NULL,
  `item_type` text NOT NULL,
  `item_desc` text NOT NULL,
  `item_origin` text NOT NULL,
  `item_owner` text NOT NULL,
  `item_loc` text NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`item_id`, `item_name`, `item_img`, `item_type`, `item_desc`, `item_origin`, `item_owner`, `item_loc`, `owner_id`) VALUES
(1, 'Guitar', 'http://www.dawsons.co.uk/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/g/r/grestch-5420t-electromatic-electric-guitar-sunburst.jpg', 'Instrument', 'Im selling this guitar', 'Texas', 'Mr Smithy x', 'Bronx, New York', 14),
(2, 'Vase', 'http://cdn.shopify.com/s/files/1/0130/8502/products/VASE2112_grande.jpg?v=1375995506', 'Pottery', 'This can be used for decoration', 'India', 'Mr Smithy x', 'New york, NY', 14);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`id` int(11) NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `age` int(11) NOT NULL,
  `cash` decimal(10,0) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `age`, `cash`) VALUES
(7, 'cj', 'ok', 'c52a51a54ef5b1a8e2ccbd5d64b64cbe', 19, '0'),
(8, 'aa', 'abc', 'c736d582bf503a17663eaf22f473890b', 19, '0'),
(14, 'hi', 'ok', 'a6de76057511d670098e2e99bed266b4', 19, '0'),
(19, 'cjjj', 'dudek12l@gmail.com', 'c52a51a54ef5b1a8e2ccbd5d64b64cbe', 19, '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
 ADD PRIMARY KEY (`item_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
