USE quan_ly_nhan_khau;
GO
--
-- Đang đổ dữ liệu cho bảng users
--
INSERT INTO users (userName, passwd) VALUES
(N'admin', N'1');
GO
--
-- Đang đổ dữ liệu cho bảng nhan_khau
--
INSERT INTO nhan_khau (maNhanKhau, hoTen, bietDanh, namSinh, gioiTinh, noiSinh, nguyenQuan, danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, TrinhDoChuyenMon, bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, tienAn, ngayChuyenDen, lyDoChuyenDen, ngayChuyenDi, lyDoChuyenDi, diaChiMoi, ngayTao, idNguoiTao, ngayXoa, idNguoiXoa, lyDoXoa, ghiChu) VALUES
(NULL, N'Trinh Văn An', N'', N'1990-12-07', N'Nam', NULL, N'Hà Nội', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', N'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', N'12/12 chính quy', N'Thạc sĩ', N'Không', N'Anh trình đọ B', N'Giáo Viên', N'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Nguyễn Minh Quân', N'', N'1995-05-31', N'Nam', NULL, N'Hà Nội', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'12/12 chính quy', N'Thạc sĩ', N'Không', N'Anh trình độ D', N'Kỹ sư', N'Viettel', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Trần Thanh Duyên', N'', N'1997-12-23', N'Nữ', NULL, N'Hải Phòng', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 3, đường Đình Đông, phường Đình Đông, quận Ngô Quyền, Hải Phòng', N'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'12/12 chính quy', N'Thạc sĩ', N'Không', N'Anh trình độ D', N'Nhân viên văn phòng', N'Công ty ABC', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Nguyễn Tiến Dũng', N'', N'1964-06-03', N'Nam', NULL, N'Hải Dương', N'Kinh', N'Thiên chúa giáo', N'Việt Nam', N'', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'12/12 chính quy', N'Kỹ sư', N'Không', N'Không', N'Phó giám đốc', N'Công ty EXE', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Vũ Mỹ Linh', N'', N'1965-12-06', N'Nữ', NULL, N'Hà Nội', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'12/12', N'Cử Nhân', N'Không', N'Không', N'Nội trợ', N'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Nguyễn Tiến Đạt', N'', N'1990-09-09', N'Nam', NULL, N'Hải Dương', N'Kinh', N'Thiên chúa giáo', N'Việt Nam', N'', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'12/12 chính quy', N'Kỹ sư', N'không', N'Anh trình độ C', N'Kỹ sư điện', N'Công ty điện EVN', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Nguyễn Trà My', N'', N'1997-12-12', N'Nữ', NULL, N'Hải Dương', N'Kinh', N'Thiên chúa giáo', N'Việt Nam', N'', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'12/12 chính quy', N'Thạc sĩ', N'không', N'Anh trình đố D', N'Luật sư', N'Văn phòng luật sư 123', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Trần Văn Nam', N'', N'1980-07-09', N'Nam', NULL, N'Hà Nội', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'12/12 chính quy', N'Tiến sĩ', N'Không', N'Anh trình độ D', N'Giảng viên đại học', N'Đại học Bách khoa Hà Nội', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Nguyễn Minh Tuyết', N'', N'1985-09-02', N'Nữ', NULL, N'Nam Định', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'12/12 chính quy', N'Thạc sĩ', N'Không', N'Anh trình độ D', N'Bác sĩ', N'Bệnh viện quốc tế HJK', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Trần Trung Kiên', N'', N'2008-12-25', N'Nam', NULL, N'Hà Nội', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'6/12 chính quy', N'Không', N'Không', N'Không', N'Học sinh', N'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Trần Thúy Ngọc', N'', N'2013-01-15', N'Nữ', NULL, N'Hà Nội', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'1/12 chính quy', N'Không', N'Không', N'Không', N'Học sinh', N'Trường tiểu học Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Lý Văn Công', N'', N'1945-06-04', N'Nam', NULL, N'Hà Nội', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'10/12 chính quy', N'Không', N'Không', N'Không', N'Về hưu', N'Không', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL),
(NULL, N'Bùi Thị Hà', N'', N'1948-02-03', N'Nữ', NULL, N'Hải Phòng', N'Kinh', N'Không', N'Việt Nam', N'', N'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'10/12', 'Không', N'Không', N'Không', N'Nội trợ', N'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, N'2023-10-29', 1, NULL, NULL, NULL, NULL);
GO
--
-- Đang đổ dữ liệu cho bảng chung_minh_thu
--
INSERT INTO chung_minh_thu (idNhanKhau, soCMT, ngayCap, noiCap) VALUES
(1, N'000000000001', NULL, NULL),
(2, N'000000000002', NULL, NULL),
(3, N'000000000003', NULL, NULL),
(4, N'000000000004', NULL, NULL),
(5, N'000000000005', NULL, NULL),
(6, N'000000000006', NULL, NULL),
(7, N'000000000007', NULL, NULL),
(8, N'000000000008', NULL, NULL),
(9, N'000000000009', NULL, NULL),
(10, N'100000000001', NULL, NULL),
(11, N'100000000002', NULL, NULL),
(12, N'000000000010', NULL, NULL),
(13, N'000000000011', NULL, NULL);
GO
--
-- Đang đổ dữ liệu cho bảng gia_dinh
--
INSERT INTO gia_dinh (idNhanKhau, hoTen, namSinh, gioiTinh, quanHeVoiNhanKhau, ngheNghiep, diaChiHienTai) VALUES
(3, N'Nguyễn Minh Quân', N'1995-05-31', N'Nam', N'Chồng', N'Kỹ sư', N'Số 2 Tạ Quang Bửu, Hai Bà Trưng, Hà Nội'),
(2, N'Trần Thanh Duyên', N'1997-12-23', N'Nữ', N'Vợ', N'Nhân viên văn phòng', N'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(4, N'Vũ Mỹ Linh', N'1965-12-06', N'Nữ', N'Vợ', N'Nội trợ', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(4, N'Nguyễn Tiến Đạt', N'1990-09-09', N'Nam', N'Con trai', N'Kỹ sư điện', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(4, N'Nguyễn Trà My', N'1997-12-12', N'Nữ', N'Con gái', N'Luật sư', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(5, N'Nguyễn Tiến Dũng', N'1964-06-03', N'Nam', N'Chồng', N'Phó giám đốc', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(5, N'Nguyễn Tiến Đạt', N'1990-09-09', N'Nam', N'Con trai', N'Kỹ sư điện', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(5, N'Nguyễn Trà My', N'1997-12-12', N'Nữ', N'Con Gái', N'Luật sư', N''),
(6, N'Nguyễn Tiến Dũng', N'1964-06-03', N'Nam', N'Bố', N'Phó giám đốc', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(6, N'Vũ Mỹ Linh', N'1965-12-06', N'Nữ', N'Mẹ', N'Nội trợ', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(6, N'Nguyễn Trà My', N'1997-12-12', N'Nữ', N'Em gái', N'Luật sư', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(7, N'Nguyễn Tiến Dũng', N'1964-06-03', N'Nam', N'Bố', N'Phó giám đốc', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(7, N'Vũ Mỹ Linh', N'1965-12-06', N'Nữ', N'Mẹ', N'Nội trợ', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(7, N'Nguyễn Tiến Đạt', N'1990-09-09', N'Nam', N'Anh trai', N'Kỹ sư điện', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(8, N'Nguyễn Minh Tuyết', N'1985-09-02', N'Nữ', N'Vợ', N'Bác sĩ', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(8, N'Trần Trung Kiên', N'2008-12-25', N'Nam', N'Con trai', N'Học sinh', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(8, N'Trần Thúy Ngọc', N'2013-01-15', N'Nữ', N'Con gái', N'Học sinh', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(9, N'Trần Trung Kiên', N'2008-12-25', N'Nam', N'Con trai', N'Học sinh', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(9, N'Trần Thúy Ngọc', N'2013-01-15', N'Nữ', N'Con gái', N'Học sinh', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(9, N'Trần Văn Nam', N'1980-07-09', N'Nam', N'Chồng', N'Giảng viên đại học', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(10, N'Trần Văn Nam', N'1980-07-09', N'Nam', N'Bố', N'Giảng viên đại học', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(10, N'Nguyễn Minh Tuyết', N'1985-09-02', N'Nữ', N'Mẹ', N'Bác sĩ', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(10, N'Trần Thúy Ngọc', N'2013-01-15', N'Nữ', N'Em gái', N'Học sinh', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(11, N'Trần Văn Nam', N'1980-07-09', N'Nam', N'Bố', N'Giảng viên đại học', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(11, N'Nguyễn Minh Tuyết', N'1985-09-02', N'Nữ', N'Mẹ', N'Bác sĩ', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(11, N'Trần Trung Kiên', N'2008-12-25', N'Nam', N'Anh trai', N'Học sinh', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(12, N'Bùi Thị Hà', N'1948-02-03', N'Nữ', N'Vợ', N'Nội trợ', N'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(12, N'Lý Thành Nam', N'1968-06-12', N'Nam', N'Con Trai', N'Công nhân', N'Số 89, ngõ 98 Trường Chinh, Hà Nội'),
(12, N'Lý Thu Thủy', N'1971-03-05', N'Nữ', N'Con Gái', N'Nhân viên văn phòng', N'Số 3, ngõ 568 Đường Láng, Hà Nội'),
(13, N'Lý Văn Công', N'1945-06-04', N'Nam', N'Chồng', N'Bộ đội về hưu', N'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội'),
(13, N'Lý Thành Nam', N'1968-06-12', N'Nam', N'Con trai', N'Công nhân', N'Số 89, ngõ 98 Trường Chinh, Hà Nội'),
(13, N'Lý Thu Thủy', N'1971-03-05', N'Nữ', N'Con gái', N'Nhân viên văn phòng', N'Số 3, ngõ 568 Đường Láng, Hà Nội');
GO
--
-- Đang đổ dữ liệu cho bảng ho_khau
--
INSERT INTO ho_khau (maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap, ngayChuyenDi, lyDoChuyen, nguoiThucHien) VALUES
(N'TQB002', 2, N'HN03', N'Số 2 Tạ Quang Bửu, quần Hai Bà Trưng, Hà Nội', N'2023-10-29', NULL, NULL, NULL),
(N'TQB001', 1, N'HN03', N'Số 1 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'2023-10-29', NULL, NULL, NULL),
(N'TQB003', 4, N'HN03', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'2023-10-29', NULL, NULL, NULL),
(N'TQB004', 8, N'HN03', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'2023-10-29', NULL, NULL, NULL);
GO
--
-- Đang đổ dữ liệu cho bảng thanh_vien_cua_ho
--
INSERT INTO thanh_vien_cua_ho (idNhanKhau, idHoKhau, quanHeVoiChuHo) VALUES
(1, 2, N'Chủ hộ'),
(2, 1, N'Chủ hộ'),
(3, 1, N'Vợ'),
(4, 3, N'Chủ hộ'),
(5, 3, N'Vợ'),
(6, 3, N'Con trai'),
(7, 3, N'Con gái'),
(8, 4, N'Chủ hộ'),
(9, 4, N'Vợ'),
(10, 4, N'Con trai'),
(11, 4, N'Con gái');
GO
--
-- Đang đổ dữ liệu cho bảng tieu_su
--
INSERT INTO tieu_su (idNhanKhau, tuNgay, denNgay, diaChi, ngheNghiep, noiLamViec) VALUES
(2, N'2015-09-05', N'2015-09-05', N'Số 45, ngõ 56, Nguyễn Khang, Cầu Giấy, Hà Nội', N'Sinh Viên', N'Đại học Thương mại'),
(3, N'2012-09-05', N'2017-09-05', N'556 La Thành, Hà Nội', N'Sinh Viên', N'Đại học Bách khoa Hà Nội'),
(4, N'1989-05-10', N'2000-08-25', N'Số 5 Nguyễn Khuyến, Hà Nội', N'Quản lý nhận sự', N'Công ty BCC'),
(5, N'1987-05-23', N'1997-03-01', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Nhân viên văn phòng', N'Công ty Zezs'),
(6, N'2008-09-05', N'2013-09-05', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Sinh viên', N'Đại học Bách khoa Hà Nội'),
(7, N'2015-09-05', N'2019-09-05', N'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Sinh viên', N'Đại học Luật Hà Nội'),
(8, N'1998-09-05', N'2003-09-05', N'Số 66, ngõ 445 Nguyễn Khang, Cầu Giấy, Hà Nội', N'Sinh Vvên', N'Đại học Bách khoa Hà Nội'),
(8, N'2003-10-03', N'2018-08-06', N'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', N'Giảng viên', N'Đại học Công ngiệp Hà Nội'),
(9, N'2003-09-05', N'2011-09-05', N'Số 8 Tôn Thất Tùng, Hà Nội', N'Sinh viên', N'Đại học Y Hà Nội'),
(9, N'2011-10-03', N'2015-08-09', N'Số 8 Tôn Thất Tùng, Hà Nội', N'Bác sĩ nội trú', N'Bệnh viện Bạch Mai'),
(10, N'1961-01-01', N'1963-01-01', N'Không rõ', N'Bộ đội', N'Hà Nội');
GO










