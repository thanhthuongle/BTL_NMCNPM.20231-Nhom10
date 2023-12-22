package controllers.NhanKhauManagerController;

import java.sql.SQLException;

import beans.NhanKhauBean;
import services.PeopleService;

public class EditController {
	private PeopleService peopleService;
	
	public EditController() {
		this.peopleService = new PeopleService();
	}
    public boolean editPeople(NhanKhauBean nhanKhauBean, int idNhanKhau) throws SQLException, ClassNotFoundException{
    	return this.peopleService.editPeople(nhanKhauBean, idNhanKhau);
    }
}
