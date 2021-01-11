-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Mar 2020 pada 11.11
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `karyawan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dt_absensi`
--

CREATE TABLE `dt_absensi` (
  `ID` varchar(10) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Tanggal` varchar(15) NOT NULL,
  `Keterangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dt_absensi`
--

INSERT INTO `dt_absensi` (`ID`, `Nama`, `Tanggal`, `Keterangan`) VALUES
('001', 'Najib', '1970-01-01', 'Masuk'),
('002', 'Faizin', '2020-02-17', 'Masuk'),
('004', 'Herman', '2020-02-17', 'Masuk'),
('005', 'Surya', '2020-02-17', 'Masuk'),
('006', 'Syaeful A', '2020-02-17', 'Masuk'),
('007', 'Riki', '1970-01-01', 'Absen'),
('22', 'ff', '1970-01-01', 'Masuk');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dt_gaji`
--

CREATE TABLE `dt_gaji` (
  `ID` varchar(10) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Bagian` varchar(20) NOT NULL,
  `Gapok` int(7) NOT NULL,
  `UangMakan` int(7) NOT NULL,
  `Masuk` int(3) NOT NULL,
  `GajiTerima` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dt_gaji`
--

INSERT INTO `dt_gaji` (`ID`, `Nama`, `Bagian`, `Gapok`, `UangMakan`, `Masuk`, `GajiTerima`) VALUES
('001', 'Najib', 'Mandor', 60000, 10000, 6, 420000),
('002', 'Faizin', 'Operator>2', 45000, 10000, 6, 330000),
('003', 'Jafar', 'Operator>2', 45000, 10000, 5, 275000),
('004', 'Herman', 'Operator>2', 45000, 10000, 6, 330000),
('005', 'Surya', 'Operator', 35000, 10000, 6, 270000),
('006', 'Syaeful A', 'Admin', 55000, 10000, 6, 390000),
('007', 'Riki', 'Operator', 35000, 10000, 5, 225000),
('008', 'Ahmad', 'Operator', 35000, 10000, 6, 270000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `dt_karyawan`
--

CREATE TABLE `dt_karyawan` (
  `ID` varchar(10) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Bagian` varchar(20) NOT NULL,
  `No_hp` varchar(13) NOT NULL,
  `Alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dt_karyawan`
--

INSERT INTO `dt_karyawan` (`ID`, `Nama`, `Bagian`, `No_hp`, `Alamat`) VALUES
('001', 'Najib', 'Mandor', '085600099439', 'Pesayangan'),
('002', 'Faizin', 'Operator>2', '08985906793', 'Jatirawa'),
('003', 'Jafar', 'Operator>2', '082328650575', 'Sidapurna'),
('004', 'Herman', 'Operator>2', '087886051987', 'Lemahduwur'),
('005', 'Surya', 'Operator', '089603966754', 'Dukuhturi'),
('006', 'Syaeful Anwar', 'Admin', '085700001397', 'Kalimati'),
('007', 'Riki', 'Operator', '082221031191', 'Pasangan'),
('008', 'Ahmad', 'Operator', '085201424209', 'Kajen');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dt_penjualan`
--

CREATE TABLE `dt_penjualan` (
  `Kd_barang` varchar(10) NOT NULL,
  `Nm_barang` varchar(20) NOT NULL,
  `Qty` int(8) NOT NULL,
  `Penerima` varchar(50) NOT NULL,
  `Tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dt_penjualan`
--

INSERT INTO `dt_penjualan` (`Kd_barang`, `Nm_barang`, `Qty`, `Penerima`, `Tanggal`) VALUES
('D13L9', 'Engsel ', 2000, 'CV Mandiri Jaya Kaligayam', '2020-02-20'),
('D16L7', 'Engsel', 3000, 'UD Sinar Barokah Kalimati', '2020-02-22');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dt_produksi`
--

CREATE TABLE `dt_produksi` (
  `ID` varchar(10) NOT NULL,
  `Kd_barang` varchar(10) NOT NULL,
  `Nm_barang` varchar(20) NOT NULL,
  `Tanggal` date NOT NULL,
  `Stock` int(8) NOT NULL,
  `Qty` int(8) NOT NULL,
  `Total` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dt_produksi`
--

INSERT INTO `dt_produksi` (`ID`, `Kd_barang`, `Nm_barang`, `Tanggal`, `Stock`, `Qty`, `Total`) VALUES
('001', 'NZ03', 'Nozzle', '2020-02-17', 354, 656, 1010),
('002', 'M13L9', 'Engsel', '2020-02-17', 0, 876, 876),
('004', 'M16L7', 'Engsel', '2020-02-17', 450, 884, 1334),
('005', 'F13L9', 'Engsel', '2020-02-17', 0, 894, 894),
('006', 'F13L7', 'Engsel', '2020-02-17', 460, 325, 785),
('008', 'F16L7', 'Engsel', '2020-02-17', 450, 895, 1345),
('009', 'm13l7', 'engsel', '2020-02-18', 550, 200, 750);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dt_absensi`
--
ALTER TABLE `dt_absensi`
  ADD PRIMARY KEY (`ID`);

--
-- Indeks untuk tabel `dt_gaji`
--
ALTER TABLE `dt_gaji`
  ADD PRIMARY KEY (`ID`);

--
-- Indeks untuk tabel `dt_karyawan`
--
ALTER TABLE `dt_karyawan`
  ADD PRIMARY KEY (`ID`);

--
-- Indeks untuk tabel `dt_penjualan`
--
ALTER TABLE `dt_penjualan`
  ADD PRIMARY KEY (`Kd_barang`);

--
-- Indeks untuk tabel `dt_produksi`
--
ALTER TABLE `dt_produksi`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
