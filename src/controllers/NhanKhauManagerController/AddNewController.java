package controllers.NhanKhauManagerController;

import java.sql.SQLException;

import beans.NhanKhauBean;
import services.PeopleService;

public class AddNewController {
	private PeopleService peopleService;
	
	public AddNewController() {
		this.peopleService = new PeopleService();
	}
    public boolean newPeople(NhanKhauBean nhanKhauBean) throws SQLException, ClassNotFoundException{
    	return this.peopleService.newPeople(nhanKhauBean);
    }
}
