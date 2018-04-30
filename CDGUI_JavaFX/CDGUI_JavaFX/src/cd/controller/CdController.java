package cd.controller;

import cd.domain.meditor.CdModel;
import cd.view.CdGUI;

public class CdController {

    private CdModel model;
    private CdGUI view;

    public CdController(CdModel model, CdGUI view) {
        this.model = model;
        this.view = view;
    }

    public String execute(String what) {
        switch (what) {
            case "List": {
                view.show(model.getAll()+"");
                break;
            }
            case "Add": {
                view.show("Add method not implemented");
            }
            case "Remove": {

            }

        }
    }
}
