package cd.domain.meditor;

import cd.domain.model.Cd;
import cd.domain.model.CdList;

import java.io.IOException;

public interface CdPersistence
{
   public CdList load() throws IOException;
   public void save(CdList cdList) throws IOException;
   public void save(Cd cd) throws IOException;
   public void remove(Cd cd) throws IOException;
   public void clear() throws IOException;
}
