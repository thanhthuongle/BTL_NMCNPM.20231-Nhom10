package controllers.FeesManagerController;

import java.sql.SQLException;

import beans.PhiBatBuocBean;
import models.FeesModel;
import services.FeesService;

public class AddNewFeeController {
	
	private FeesService feesService;
	
	public AddNewFeeController() {
		this.feesService = new FeesService();
	}

	public boolean newFee(PhiBatBuocBean phiBatBuocBean) throws SQLException, ClassNotFoundException{
		FeesModel feeModel = phiBatBuocBean.getFeesModel();
		if (feeModel.getSo_tien()>=0 && feeModel.getSo_tien()<=10000000) {
			return feesService.newFee(phiBatBuocBean);
		}
		return false;
	}

	public  boolean checkDuplicate(FeesModel value){
		return  feesService.checkDuplicate(value);
	}
}
