package cd.view;

import cd.domain.model.CdList;

public interface CdView
{
   void start(CdList cdList);
   void show(String value);
   String get(String what);
}
