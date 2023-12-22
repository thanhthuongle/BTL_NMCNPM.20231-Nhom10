package controllers.FeesManagerController;

import java.sql.SQLException;

import beans.PhiBatBuocBean;
import services.FeesService;

public class EditFeeController {
	
	private FeesService feesService;
	
	public EditFeeController() {
		this.feesService = new FeesService();
	}

	public boolean editFee(PhiBatBuocBean phiBatBuocBean, int idFee) throws SQLException, ClassNotFoundException{
		if (idFee != -1) return feesService.editFee(phiBatBuocBean, idFee);
		return false;
	}
}
