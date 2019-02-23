package cd.view;
import cd.controller.CdController;
import cd.domain.model.CdList;

public interface CdView
{
   void show(String value);
   String get(String what);
   void start(CdController controller);
}
