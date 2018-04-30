package cd.domain.meditor;

import cd.domain.model.Cd;
import cd.domain.model.CdList;

public class CdModelManager implements CdModel {

    private final String TEXT_FILE_NAME = "src/cds.txt";
    private CdList cdList;
    private CdPersistence cdPersistence;

    public CdModelManager() {
        this.cdList = new CdList();
        try {
            this.cdPersistence = new CdTextFile(TEXT_FILE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CdList getAll() {
        return this.cdList;
    }

    @Override
    public void addCD(Cd cd) {
        cdList.addCd(cd);
    }

    @Override
    public Cd removeCD(String title) {
        return cdList.removeFirstCdByTitle(title);
    }

    @Override
    public Cd getCD(int index) {
        return cdList.getCD(index);
    }

    @Override
    public CdList getCDs(String title) {
        return cdList.getCdsByTitle(title);
    }

    @Override
    public int getNumberOfCds() {
        return cdList.getNumberOfCds();
    }

}
