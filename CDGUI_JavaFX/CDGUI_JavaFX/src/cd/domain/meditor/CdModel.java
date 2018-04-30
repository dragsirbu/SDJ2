package cd.domain.meditor;

import cd.domain.model.Cd;
import cd.domain.model.CdList;

public interface CdModel {

    public CdList getAll();
    public void addCD(Cd cd);
    public Cd removeCD(String title);
    public Cd getCD(int index);
    public CdList getCDs(String title);
    public int getNumberOfCds();


}
