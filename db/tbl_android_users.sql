-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2020 at 05:58 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `android_crud_mysql`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_android_users`
--

CREATE TABLE `tbl_android_users` (
  `id` int(11) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_android_users`
--

INSERT INTO `tbl_android_users` (`id`, `fullname`, `username`, `password`) VALUES
(186, 'red jumpsuit apparatus', 'damn regret', '$2y$10$vV/4MCRTMh7/rx5kyfQBiuYLglHDptojLQcSC9/cc1sSlZyJtI/RG'),
(187, 'red jumpsuit2', 'rja', '$2y$10$DLAulYbX233ZhflhP6gLT.gZTXfAEgP0ieKPItaK1YINkgGAreMF2'),
(188, 'k', 'k', '$2y$10$0GMW59aajaTLsJcBcZkZG.AxcZbcUdZPeVSskpGQP5PO/NmmIKiu6');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_android_users`
--
ALTER TABLE `tbl_android_users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_android_users`
--
ALTER TABLE `tbl_android_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=190;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
