USE vietnamese_provinces;
GO

-----------------------------------------------------
-----------------------------------------------------
CREATE FULLTEXT CATALOG vnprovinces_ctlg AS DEFAULT;  
GO  

-----------------------------------------------------
-----------------------------------------------------
CREATE UNIQUE INDEX ui_wardname ON wards(code);
GO
CREATE FULLTEXT INDEX ON wards
(
	name Language 1066
)
KEY INDEX ui_wardname
GO

-----------------------------------------------------
-----------------------------------------------------
CREATE UNIQUE INDEX ui_districtname on districts(code);
CREATE FULLTEXT INDEX ON districts 
(
	name Language 1066
)
KEY INDEX ui_districtname
GO

--

-- Chỉ mục cho bảng nhan_khau
CREATE UNIQUE INDEX ui_provincename ON provinces(code);
CREATE FULLTEXT INDEX ON provinces
(
	name Language 1066
)
KEY INDEX ui_provincename
GO