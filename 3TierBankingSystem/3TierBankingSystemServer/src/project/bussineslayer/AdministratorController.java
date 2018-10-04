package project.bussineslayer;

import project.bussineslayer.model.Administrator;
import project.bussineslayer.model.interfaces.IAdminController;

public class AdministratorController implements IAdminController {

    private Administrator admin;


    public AdministratorController(Administrator admin) {
        this.admin = admin;
    }

//    @Override
//    public void CreateAccount(int number, double balance) {
//        admin.CreateAccount(number,balance);
//    }
}
