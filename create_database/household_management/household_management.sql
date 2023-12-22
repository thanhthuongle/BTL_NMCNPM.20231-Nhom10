USE quan_ly_nhan_khau;
GO

CREATE TABLE chung_minh_thu (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  idNhanKhau INT DEFAULT NULL,
  soCMT NVARCHAR(12)   NOT NULL,
  ngayCap date DEFAULT NULL,
  noiCap NVARCHAR(100)   DEFAULT NULL
);
GO

-- Cấu trúc bảng cho bảng dinh_chinh
CREATE TABLE dinh_chinh (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  idHoKhau INT DEFAULT NULL,
  thongTinThayDoi NVARCHAR(100)  DEFAULT NULL,
  thayDoiTu NVARCHAR(100)  DEFAULT NULL,
  thayDoiThanh NVARCHAR(100)  DEFAULT NULL,
  ngayThayDoi date DEFAULT NULL,
  nguoiThayDoi INT DEFAULT NULL
);
GO

-- Cấu trúc bảng cho bảng gia_dinh
CREATE TABLE gia_dinh (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  idNhanKhau INT DEFAULT NULL,
  hoTen NVARCHAR(100)   DEFAULT NULL,
  namSinh date DEFAULT NULL,
  gioiTinh NVARCHAR(100)   DEFAULT NULL,
  quanHeVoiNhanKhau NVARCHAR(100)   DEFAULT NULL,
  ngheNghiep NVARCHAR(100)   DEFAULT NULL,
  diaChiHienTai NVARCHAR(100)   DEFAULT NULL
);
GO

-- Cấu trúc bảng cho bảng ho_khau
CREATE TABLE ho_khau (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  maHoKhau NVARCHAR(100)   DEFAULT NULL,
  idChuHo INT DEFAULT NULL,
  maKhuVuc NVARCHAR(100)   DEFAULT NULL,
  diaChi NVARCHAR(100)   DEFAULT NULL,
  ngayLap date DEFAULT NULL,
  ngayChuyenDi date DEFAULT NULL,
  lyDoChuyen text   DEFAULT NULL,
  nguoiThucHien INT DEFAULT NULL
);
GO

-- Cấu trúc bảng cho bảng khai_tu
CREATE TABLE khai_tu (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  soGiayKhaiTu NVARCHAR(100)   DEFAULT NULL,
  idNguoiKhai INT DEFAULT NULL,
  idNguoiChet INT DEFAULT NULL,
  ngayKhai date DEFAULT NULL,
  ngayChet date DEFAULT NULL,
  lyDoChet NVARCHAR(100)   DEFAULT NULL
);
GO

-- Cấu trúc bảng cho bảng nhan_khau
CREATE TABLE nhan_khau (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  maNhanKhau NVARCHAR(100)   DEFAULT NULL,
  hoTen NVARCHAR(100)   DEFAULT NULL,
  bietDanh NVARCHAR(100)   DEFAULT NULL,
  namSinh date DEFAULT NULL,
  gioiTinh NVARCHAR(100)   DEFAULT NULL,
  noiSinh NVARCHAR(100)   DEFAULT NULL,
  nguyenQuan NVARCHAR(100)   DEFAULT NULL,
  danToc NVARCHAR(100)   DEFAULT NULL,
  tonGiao NVARCHAR(100)   DEFAULT NULL,
  quocTich NVARCHAR(100)   DEFAULT NULL,
  soHoChieu NVARCHAR(100)   DEFAULT NULL,
  noiThuongTru NVARCHAR(100)   DEFAULT NULL,
  diaChiHienNay NVARCHAR(100)   DEFAULT NULL,
  trinhDoHocVan NVARCHAR(100)   DEFAULT NULL,
  TrinhDoChuyenMon NVARCHAR(100)   DEFAULT NULL,
  bietTiengDanToc NVARCHAR(100)   DEFAULT NULL,
  trinhDoNgoaiNgu NVARCHAR(100)   DEFAULT NULL,
  ngheNghiep NVARCHAR(100)   DEFAULT NULL,
  noiLamViec NVARCHAR(100)   DEFAULT NULL,
  tienAn NVARCHAR(100)   DEFAULT NULL,
  ngayChuyenDen date DEFAULT NULL,
  lyDoChuyenDen NVARCHAR(100)   DEFAULT NULL,
  ngayChuyenDi date DEFAULT NULL,
  lyDoChuyenDi NVARCHAR(100)   DEFAULT NULL,
  diaChiMoi NVARCHAR(100)   DEFAULT NULL,
  ngayTao date DEFAULT NULL,
  idNguoiTao INT DEFAULT NULL,
  ngayXoa date DEFAULT NULL,
  idNguoiXoa INT DEFAULT NULL,
  lyDoXoa NVARCHAR(100)   DEFAULT NULL,
  ghiChu NVARCHAR(100)   DEFAULT NULL
);
GO

-- Cấu trúc bảng cho bảng tam_tru
CREATE TABLE tam_tru (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  idNhanKhau INT DEFAULT NULL,
  maGiayTamtru NVARCHAR(100)   DEFAULT NULL,
  soDienThoaiNguoiDangKy NVARCHAR(100)   DEFAULT NULL,
  tuNgay date NOT NULL,
  denNgay date NOT NULL,
  lyDo text   NOT NULL
);
GO

-- Cấu trúc bảng cho bảng tam_vang
CREATE TABLE tam_vang (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  idNhanKhau INT DEFAULT NULL,
  maGiayTamVang NVARCHAR(100)   DEFAULT NULL,
  noiTamtru NVARCHAR(100)   DEFAULT NULL,
  tuNgay date DEFAULT NULL,
  denNgay date DEFAULT NULL,
  lyDo NVARCHAR(100)   DEFAULT NULL
);
GO

-- Cấu trúc bảng cho bảng thanh_vien_cua_ho
CREATE TABLE thanh_vien_cua_ho (
  idNhanKhau INT NOT NULL,
  idHoKhau INT NOT NULL,
  quanHeVoiChuHo NVARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (idNhanKhau, idHoKhau)
);
GO

-- Cấu trúc bảng cho bảng tieu_su
CREATE TABLE tieu_su (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  idNhanKhau INT DEFAULT NULL,
  tuNgay date DEFAULT NULL,
  denNgay date DEFAULT NULL,
  diaChi NVARCHAR(100)   DEFAULT NULL,
  ngheNghiep NVARCHAR(100)   DEFAULT NULL,
  noiLamViec NVARCHAR(100)   DEFAULT NULL
);
GO

-- Cấu trúc bảng cho bảng users
CREATE TABLE users (
  ID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  userName NVARCHAR(100)   DEFAULT NULL,
  passwd NVARCHAR(100)   DEFAULT NULL
);
GO


-- Chỉ mục cho các bảng đã đổ
CREATE FULLTEXT CATALOG hokhau_ctlg AS DEFAULT;  
GO  

-- Chỉ mục cho bảng chung_minh_thu
CREATE INDEX ix_idNhanKhau ON chung_minh_thu(idNhanKhau);
GO
CREATE UNIQUE INDEX ui_IDChungMinhThu ON chung_minh_thu(ID);
GO
CREATE FULLTEXT INDEX ON chung_minh_thu
(
	soCMT Language 1066
)
KEY INDEX ui_IDChungMinhThu
GO
--
-- Chỉ mục cho bảng dinh_chinh
CREATE INDEX ix_idHoKhau ON dinh_chinh(idHoKhau);
CREATE INDEX ix_nguoiThayDoi on dinh_chinh(nguoiThayDoi);
GO

--
-- Chỉ mục cho bảng gia_dinh
CREATE INDEX ix_idNhanKhau on gia_dinh(idNhanKhau);
GO

-- Chỉ mục cho bảng ho_khau
CREATE INDEX ix_idChuHo on ho_khau(idChuHo);
GO
CREATE UNIQUE INDEX ui_IDHokhau on ho_khau(ID);
CREATE FULLTEXT INDEX ON ho_khau 
(
	maHoKhau Language 1066
)
KEY INDEX ui_IDHoKhau
GO

--
-- Chỉ mục cho bảng khai_tu
CREATE INDEX ix_idNguoiKhai on khai_tu(idNguoiKhai);
CREATE INDEX ix_idNguoiChet on khai_tu(idNguoiChet);
GO

-- Chỉ mục cho bảng nhan_khau
CREATE INDEX ix_idNguoiTao on nhan_khau(idNguoiTao);
CREATE INDEX ix_idNguoiXoa on nhan_khau(idNguoiXoa);
GO
CREATE UNIQUE INDEX ui_IDNhanKhau ON nhan_khau(ID)
CREATE FULLTEXT INDEX ON nhan_khau
(
	hoTen Language 1066,
	bietDanh Language 1066
)
KEY INDEX ui_IDNhanKhau
GO

-- Chỉ mục cho bảng tam_tru
CREATE INDEX ix_idNhanKhau on tam_tru(idNhanKhau);
GO

-- Chỉ mục cho bảng tam_vang
CREATE INDEX ix_idNhanKhau on tam_vang(idNhanKhau);
GO

-- Chỉ mục cho bảng thanh_vien_cua_ho
CREATE INDEX ix_idHoKhau on thanh_vien_cua_ho(idHoKhau);
GO

-- Chỉ mục cho bảng tieu_su
CREATE INDEX ix_idNhanKhau on tieu_su(idNhanKhau);
GO

--
ALTER TABLE chung_minh_thu
  ADD CONSTRAINT chung_minh_thu_ibfk_1 FOREIGN KEY (idNhanKhau) REFERENCES nhan_khau (ID);
GO
--
-- Các ràng buộc cho bảng dinh_chinh
--
ALTER TABLE dinh_chinh
  ADD CONSTRAINT dinh_chinh_ibfk_1 FOREIGN KEY (idHoKhau) REFERENCES ho_khau (ID);
GO

ALTER TABLE dinh_chinh
  ADD CONSTRAINT dinh_chinh_ibfk_2 FOREIGN KEY (nguoiThayDoi) REFERENCES users (ID);
GO
 
-- Các ràng buộc cho bảng gia_dinh
--
ALTER TABLE gia_dinh
  ADD CONSTRAINT gia_dinh_ibfk_1 FOREIGN KEY (idNhanKhau) REFERENCES nhan_khau (ID);
GO

--
-- Các ràng buộc cho bảng ho_khau
--
ALTER TABLE ho_khau
  ADD CONSTRAINT ho_khau_ibfk_1 FOREIGN KEY (idChuHo) REFERENCES nhan_khau (ID);
GO

--
-- Các ràng buộc cho bảng khai_tu
--
ALTER TABLE khai_tu
  ADD CONSTRAINT khai_tu_ibfk_1 FOREIGN KEY (idNguoiKhai) REFERENCES nhan_khau (ID);
GO

ALTER TABLE khai_tu
  ADD CONSTRAINT khai_tu_ibfk_2 FOREIGN KEY (idNguoiChet) REFERENCES nhan_khau (ID);
GO

-- Các ràng buộc cho bảng nhan_khau
ALTER TABLE nhan_khau
  ADD CONSTRAINT nhan_khau_ibfk_1 FOREIGN KEY (idNguoiTao) REFERENCES users (ID);

ALTER TABLE nhan_khau
  ADD CONSTRAINT nhan_khau_ibfk_2 FOREIGN KEY (idNguoiXoa) REFERENCES users (ID);
GO

-- Các ràng buộc cho bảng tam_tru
ALTER TABLE tam_tru
  ADD CONSTRAINT tam_tru_ibfk_1 FOREIGN KEY (idNhanKhau) REFERENCES nhan_khau (ID);
GO

-- Các ràng buộc cho bảng tam_vang
ALTER TABLE tam_vang
  ADD CONSTRAINT tam_vang_ibfk_1 FOREIGN KEY (idNhanKhau) REFERENCES nhan_khau (ID);
GO

-- Các ràng buộc cho bảng thanh_vien_cua_ho
ALTER TABLE thanh_vien_cua_ho
  ADD CONSTRAINT thanh_vien_cua_ho_ibfk_1 FOREIGN KEY(idNhanKhau) REFERENCES nhan_khau(ID);
GO

ALTER TABLE thanh_vien_cua_ho
  ADD CONSTRAINT thanh_vien_cua_ho_ibfk_2 FOREIGN KEY(idHoKhau) REFERENCES ho_khau(ID);
GO

-- Các ràng buộc cho bảng tieu_su
ALTER TABLE tieu_su
  ADD CONSTRAINT tieu_su_ibfk_1 FOREIGN KEY (idNhanKhau) REFERENCES nhan_khau (ID);
GO
