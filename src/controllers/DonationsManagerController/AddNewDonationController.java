package controllers.DonationsManagerController;

import java.sql.SQLException;

import beans.PhiUngHoBean;
import services.DonationsService;

public class AddNewDonationController {
	
	private DonationsService donationsService;
	
	public AddNewDonationController() {
		this.donationsService = new DonationsService();
	}

	public boolean newDonation(PhiUngHoBean phiUngHoBean) throws SQLException, ClassNotFoundException{
		return donationsService.newDonation(phiUngHoBean);
	}
}
