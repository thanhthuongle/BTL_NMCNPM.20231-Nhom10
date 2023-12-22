USE quan_ly_nhan_khau;
GO

-- Insert data phi_ung_ho table 
INSERT INTO phi_ung_ho (ten_khoan_thu, ngay_tao, idNguoiTao) values 
	( N'Kỉ niệm 20/11', '2023-11-20', 1),
	( N'Kỉ niệm 20/10 ', '2023-10-20', 1),
	( N'Kỉ niệm 8/3', '2023-03-08', 1),
	( N'Quyên góp lũ lụt miền trung', '2023-11-21', 1),
	( N'Quyên góp khó khăn miền núi', '2023-11-22', 1),
	( N'Quỹ phòng, chống thiên tai', '2023-11-23', 1),
	( N'Quỹ xây dựng', '2023-11-01', 1),
	( N'Quỹ chăm sóc người cao tuổi', '2023-12-20', 1),
	( N'Quỹ vì người nghèo', '2023-12-20', 1),
	( N'Quỹ Đền ơn đáp nghĩa', '2023-12-20', 1),
	( N'Quỹ bảo trợ trẻ em', '2023-12-20', 1),
	( N'Quỹ xóa đói giảm nghèo','2023-12-20', 1),
	( N'Quỹ khuyến học', '2023-12-20', 1),
	( N'Quỹ phòng, chống ma túy', '2023-12-20', 1);
GO

-- Insert data phi_bat_buoc table 
INSERT INTO phi_bat_buoc ( ten_khoan_thu, so_tien, dot_thu, ngay_Tao, idNguoiTao) values 
	( N'Phí vệ sinh', 6000, '2023-1', '2023-10-29', 1);
GO

-- Insert data nop_phi table 
INSERT INTO nop_phi ( idNhanKhau, idPhiThu, ngay_nop, so_tien) values 
	( 5, 1, '2023-11-01', 6000),
	( 6, 1, '2023-11-01', 6000);
GO
