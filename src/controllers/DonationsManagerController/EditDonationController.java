package controllers.DonationsManagerController;

import java.sql.SQLException;

import beans.PhiUngHoBean;
import services.DonationsService;

public class EditDonationController {
	
	private DonationsService donationsService;
	
	public EditDonationController() {
		this.donationsService = new DonationsService();
	}

	public boolean editDonation(PhiUngHoBean phiUngHoBean, int idDonation) throws SQLException, ClassNotFoundException{
		return donationsService.editDonation(phiUngHoBean, idDonation);
	}
}
