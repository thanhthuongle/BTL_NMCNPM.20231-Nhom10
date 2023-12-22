USE quan_ly_nhan_khau;
GO

CREATE TABLE phi_ung_ho(
    ID int IDENTITY(1,1) PRIMARY KEY,
    ten_khoan_thu NVARCHAR(100) NOT NULL,
	ngay_tao DATE NOT NULL,
	idNguoiTao INT NOT NULL,
	FOREIGN KEY (idNguoiTao) REFERENCES users (ID)
)
GO
CREATE INDEX ix_idPhiUngHo ON phi_ung_ho(ID);
GO

CREATE TABLE phi_bat_buoc(
    ID int IDENTITY(1,1) PRIMARY KEY,
    ten_khoan_thu NVARCHAR(100) NOT NULL,
    so_tien INT NOT NULL,
    dot_thu CHAR(20) NOT NULL,
	ngay_tao DATE NOT NULL,
	idNguoiTao INT NOT NULL,
	FOREIGN KEY (idNguoiTao) REFERENCES users (ID)
)
GO
CREATE INDEX ix_idPhiBatBuoc ON phi_bat_buoc(ID);
GO

CREATE TABLE ung_ho(
    idNhanKhau int NOT NULL, 
    idKhoanThu int NOT NULL,
    ngay_nop DATETIME NOT NULL,
	so_tien INT NOT NULL,
    PRIMARY KEY (idNhanKhau,idKhoanThu),
    FOREIGN KEY ([idNhanKhau]) REFERENCES nhan_khau(ID),
    FOREIGN KEY ([idKhoanThu]) REFERENCES phi_ung_ho(ID),
)
GO

CREATE TABLE nop_phi(
    idNhanKhau int NOT NULL, 
    idPhiThu int NOT NULL,
    ngay_nop DATETIME NOT NULL,
	so_tien INT NOT NULL,
    PRIMARY KEY (idNhanKhau,idPhiThu),
    FOREIGN KEY ([idNhanKhau]) REFERENCES nhan_khau(ID),
    FOREIGN KEY ([idPhiThu]) REFERENCES phi_bat_buoc(ID),
)
GO

