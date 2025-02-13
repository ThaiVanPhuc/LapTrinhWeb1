-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 25, 2024 lúc 04:04 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `tkbdb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ca_hoc`
--

CREATE TABLE `ca_hoc` (
  `id` bigint(20) NOT NULL,
  `created_at` varchar(19) NOT NULL,
  `created_by_user_id` bigint(20) NOT NULL,
  `ten_lop_hoac_ten_lop_ghep` varchar(100) NOT NULL,
  `thoi_gian` varchar(19) NOT NULL,
  `updated_at` varchar(19) DEFAULT NULL,
  `updated_by_user_id` bigint(20) DEFAULT NULL,
  `giang_vien_id` bigint(20) DEFAULT NULL,
  `hoc_phan_id` bigint(20) DEFAULT NULL,
  `lop_id` bigint(20) DEFAULT NULL,
  `phong_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giang_vien`
--

CREATE TABLE `giang_vien` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `ten_giang_vien` varchar(100) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `giang_vien`
--

INSERT INTO `giang_vien` (`id`, `created_at`, `ten_giang_vien`, `updated_at`) VALUES
(1, '2024-12-15 12:15:55.000000', 'Trương Văn Hiệu', '2024-12-15 12:15:55.000000'),
(3, '2024-12-15 12:18:03.000000', 'Nguyen Văn An', '2024-12-15 12:18:03.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoc_phan`
--

CREATE TABLE `hoc_phan` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `ten_hoc_phan` varchar(100) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoc_phan`
--

INSERT INTO `hoc_phan` (`id`, `created_at`, `ten_hoc_phan`, `updated_at`) VALUES
(1, '2024-12-15 12:15:55.000000', 'Lập trình Web 1', '2024-12-15 12:15:55.000000'),
(3, '2024-12-15 12:18:03.000000', 'Mạng máy tính', '2024-12-15 12:18:03.000000'),
(4, '2024-12-14 08:00:00.000000', 'Mạng máy tính', NULL),
(5, '2024-12-14 08:00:00.000000', 'Lập trình Web 1', NULL),
(6, '2024-12-14 08:00:00.000000', 'Lập trình mã nguồn mở', NULL),
(7, '2024-12-14 08:00:00.000000', 'Hệ điều hành', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lich_giang_vien`
--

CREATE TABLE `lich_giang_vien` (
  `id` bigint(20) NOT NULL,
  `ca` int(11) NOT NULL,
  `ngay` date NOT NULL,
  `thu` int(11) NOT NULL,
  `giangvien_id` bigint(20) DEFAULT NULL,
  `hoc_phan_id` bigint(20) DEFAULT NULL,
  `lop_hoc_id` bigint(20) DEFAULT NULL,
  `phong_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `lich_giang_vien`
--

INSERT INTO `lich_giang_vien` (`id`, `ca`, `ngay`, `thu`, `giangvien_id`, `hoc_phan_id`, `lop_hoc_id`, `phong_id`) VALUES
(2, 2, '2024-12-15', 2, 1, 1, 1, 1),
(4, 4, '2024-12-15', 4, 3, 3, 3, 3),
(22, 1, '2024-12-16', 2, 1, 1, 1, 1),
(23, 2, '2024-12-16', 3, 1, 3, 3, 1),
(24, 3, '2024-12-17', 4, 1, 1, 1, 1),
(25, 4, '2024-12-17', 4, 1, 3, 3, 1),
(26, 5, '2024-12-18', 5, 1, 3, 3, 3),
(27, 2, '2024-12-18', 5, 1, 4, 4, 3),
(28, 1, '2024-12-19', 6, 1, 4, 4, 4),
(29, 3, '2024-12-19', 6, 1, 1, 1, 4),
(30, 2, '2024-12-16', 3, 3, 1, 1, 1),
(31, 4, '2024-12-17', 4, 3, 1, 3, 3),
(32, 1, '2024-12-18', 5, 3, 3, 3, 3),
(33, 5, '2024-12-19', 6, 3, 4, 4, 4),
(34, 1, '2024-12-16', 2, 3, 1, 1, 1),
(35, 3, '2024-12-17', 3, 3, 3, 4, 1),
(36, 5, '2024-12-18', 4, 3, 3, 3, 3),
(37, 5, '2024-12-19', 5, 3, 4, 4, 4),
(38, 5, '2024-12-20', 6, 3, 1, 1, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lich_lop`
--

CREATE TABLE `lich_lop` (
  `id` bigint(20) NOT NULL,
  `ca` int(11) NOT NULL,
  `lop` varchar(255) DEFAULT NULL,
  `thu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lich_phong_may`
--

CREATE TABLE `lich_phong_may` (
  `id` bigint(20) NOT NULL,
  `ca` int(11) NOT NULL,
  `phong` varchar(255) DEFAULT NULL,
  `thu` int(11) NOT NULL,
  `trangthai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop_hoc`
--

CREATE TABLE `lop_hoc` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `ten_lop` varchar(100) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `lop_hoc`
--

INSERT INTO `lop_hoc` (`id`, `created_at`, `ten_lop`, `updated_at`) VALUES
(1, '2024-12-15 12:15:55.000000', 'ST22A', '2024-12-15 12:15:55.000000'),
(3, '2024-12-15 12:18:03.000000', 'ST22A', '2024-12-15 12:18:03.000000'),
(4, '2024-12-14 08:00:00.000000', 'ST22A', NULL),
(5, '2024-12-14 08:00:00.000000', 'ST22B', NULL),
(6, '2024-12-14 08:00:00.000000', 'ST22C', NULL),
(7, '2024-12-14 08:00:00.000000', 'ST22D', NULL),
(8, '2024-12-14 08:00:00.000000', 'ST23A', NULL),
(9, '2024-12-14 08:00:00.000000', 'ST23B', NULL),
(10, '2024-12-14 08:00:00.000000', 'ST22A', NULL),
(11, '2024-12-14 08:00:00.000000', 'ST22B', NULL),
(12, '2024-12-14 08:00:00.000000', 'ST22C', NULL),
(13, '2024-12-14 08:00:00.000000', 'ST22D', NULL),
(14, '2024-12-14 08:00:00.000000', 'ST23A', NULL),
(15, '2024-12-14 08:00:00.000000', 'ST23B', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phong_hoc`
--

CREATE TABLE `phong_hoc` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `ten_phong` varchar(100) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phong_hoc`
--

INSERT INTO `phong_hoc` (`id`, `created_at`, `ten_phong`, `updated_at`) VALUES
(1, '2024-12-15 12:15:55.000000', '102', '2024-12-15 12:15:55.000000'),
(3, '2024-12-15 12:18:03.000000', '101', '2024-12-15 12:18:03.000000'),
(4, '2024-12-14 08:00:00.000000', '107', NULL),
(5, '2024-12-14 08:00:00.000000', '106', NULL),
(6, '2024-12-14 08:00:00.000000', '103', NULL),
(7, '2024-12-14 08:00:00.000000', '104', NULL),
(8, '2024-12-14 08:00:00.000000', '105', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `created_at` varchar(19) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) DEFAULT NULL,
  `updated_at` varchar(19) DEFAULT NULL,
  `username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `created_at`, `password`, `role`, `updated_at`, `username`) VALUES
(1, '2024-12-14 19:59:17', '$2a$10$dspl7yyLH/ctT69kXD9bnOKKR9BslSrxjmeGq0EN0oCNm4Y7uYV.O', 'USER', '2024-12-14 19:59:17', 'phuc'),
(2, '2024-12-15 12:52:03', '$2a$10$w8Iz0Odfaac6OeKFOZ5tf.LBFuWCCTGo.E7VJJlTdeMu/mLGs.JMi', 'ADMIN', '2024-12-15 12:52:03', 'admin'),
(3, '2024-12-19 21:38:43', '$2a$10$TwwVHcls8J5FVfgYbdM8juU.WYxz78/d9SnAvSEJp6cJ/yaePJvbq', NULL, '2024-12-19 21:38:43', 'phuc1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users_roles`
--

CREATE TABLE `users_roles` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users_roles`
--

INSERT INTO `users_roles` (`id`, `role_id`, `user_id`) VALUES
(1, 1, 2),
(2, 2, 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ca_hoc`
--
ALTER TABLE `ca_hoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_GiangVien` (`giang_vien_id`),
  ADD KEY `FK_HocPhan` (`hoc_phan_id`),
  ADD KEY `FK_LopHoc` (`lop_id`),
  ADD KEY `FK_PhongHoc` (`phong_id`);

--
-- Chỉ mục cho bảng `giang_vien`
--
ALTER TABLE `giang_vien`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hoc_phan`
--
ALTER TABLE `hoc_phan`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `lich_giang_vien`
--
ALTER TABLE `lich_giang_vien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcfahekyxfavfytowpput8lgqh` (`giangvien_id`),
  ADD KEY `FK8lcuh630028m7jsixbogucydj` (`hoc_phan_id`),
  ADD KEY `FKpsdk8baeaysdnicn5wk94isvy` (`lop_hoc_id`),
  ADD KEY `FKaovndvrqyqej7jqbnxk11hr85` (`phong_id`);

--
-- Chỉ mục cho bảng `lich_lop`
--
ALTER TABLE `lich_lop`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `lich_phong_may`
--
ALTER TABLE `lich_phong_may`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `lop_hoc`
--
ALTER TABLE `lop_hoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `phong_hoc`
--
ALTER TABLE `phong_hoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  ADD KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ca_hoc`
--
ALTER TABLE `ca_hoc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `giang_vien`
--
ALTER TABLE `giang_vien`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `hoc_phan`
--
ALTER TABLE `hoc_phan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `lich_giang_vien`
--
ALTER TABLE `lich_giang_vien`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT cho bảng `lich_lop`
--
ALTER TABLE `lich_lop`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `lich_phong_may`
--
ALTER TABLE `lich_phong_may`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `lop_hoc`
--
ALTER TABLE `lop_hoc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `phong_hoc`
--
ALTER TABLE `phong_hoc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `users_roles`
--
ALTER TABLE `users_roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ca_hoc`
--
ALTER TABLE `ca_hoc`
  ADD CONSTRAINT `FK_GiangVien` FOREIGN KEY (`giang_vien_id`) REFERENCES `giang_vien` (`id`),
  ADD CONSTRAINT `FK_HocPhan` FOREIGN KEY (`hoc_phan_id`) REFERENCES `hoc_phan` (`id`),
  ADD CONSTRAINT `FK_LopHoc` FOREIGN KEY (`lop_id`) REFERENCES `lop_hoc` (`id`),
  ADD CONSTRAINT `FK_PhongHoc` FOREIGN KEY (`phong_id`) REFERENCES `phong_hoc` (`id`);

--
-- Các ràng buộc cho bảng `lich_giang_vien`
--
ALTER TABLE `lich_giang_vien`
  ADD CONSTRAINT `FK8lcuh630028m7jsixbogucydj` FOREIGN KEY (`hoc_phan_id`) REFERENCES `hoc_phan` (`id`),
  ADD CONSTRAINT `FKaovndvrqyqej7jqbnxk11hr85` FOREIGN KEY (`phong_id`) REFERENCES `phong_hoc` (`id`),
  ADD CONSTRAINT `FKcfahekyxfavfytowpput8lgqh` FOREIGN KEY (`giangvien_id`) REFERENCES `giang_vien` (`id`),
  ADD CONSTRAINT `FKpsdk8baeaysdnicn5wk94isvy` FOREIGN KEY (`lop_hoc_id`) REFERENCES `lop_hoc` (`id`);

--
-- Các ràng buộc cho bảng `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
