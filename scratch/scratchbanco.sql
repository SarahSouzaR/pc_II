-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 11-Ago-2018 às 01:46
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scratchbanco`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_metodologia`
--

CREATE TABLE `tb_metodologia` (
  `id_metodologia` int(11) NOT NULL,
  `metodo_nome` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_pessoas`
--

CREATE TABLE `tb_pessoas` (
  `id_pessoa` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `sexo` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_tarefa`
--

CREATE TABLE `tb_tarefa` (
  `id_tarefa` int(11) NOT NULL,
  `id_pessoa` int(11) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `prazo_estimado` varchar(20) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `dt_inicio` varchar(20) NOT NULL,
  `dt_termino` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_time`
--

CREATE TABLE `tb_time` (
  `id_time` int(11) NOT NULL,
  `nm_time` varchar(100) NOT NULL,
  `id_pessoa` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_metodologia`
--
ALTER TABLE `tb_metodologia`
  ADD PRIMARY KEY (`id_metodologia`);

--
-- Indexes for table `tb_pessoas`
--
ALTER TABLE `tb_pessoas`
  ADD PRIMARY KEY (`id_pessoa`);

--
-- Indexes for table `tb_tarefa`
--
ALTER TABLE `tb_tarefa`
  ADD PRIMARY KEY (`id_tarefa`);

--
-- Indexes for table `tb_time`
--
ALTER TABLE `tb_time`
  ADD PRIMARY KEY (`id_time`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_metodologia`
--
ALTER TABLE `tb_metodologia`
  MODIFY `id_metodologia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_pessoas`
--
ALTER TABLE `tb_pessoas`
  MODIFY `id_pessoa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_tarefa`
--
ALTER TABLE `tb_tarefa`
  MODIFY `id_tarefa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_time`
--
ALTER TABLE `tb_time`
  MODIFY `id_time` int(11) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
