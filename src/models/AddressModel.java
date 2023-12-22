package models;

public class AddressModel {

	private String house_no;
	private String ward;
	private String district;
	private String province;
	
	public AddressModel() {
		super();
	}
	
	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	
	public String getWard() {
		return ward;
	}

	public String getDistrict() {
		return district;
	}

	public String getProvince() {
		return province;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getAddress() {
		return house_no + ", " + ward + ", " + district + ", " + province;
	}
	
	
}
