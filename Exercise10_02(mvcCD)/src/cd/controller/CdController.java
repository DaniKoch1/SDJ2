package cd.controller;

import javax.swing.JButton;

import cd.domain.mediator.CdModel;
import cd.domain.model.Cd;
import cd.domain.model.CdList;
import cd.view.CdView;

public class CdController {
	private CdModel model;
	private CdView view;
	
	public CdController(CdModel modell, CdView vieww)
	{
		model=modell;
		view=vieww; 
	}
	public void execute(String what)
	{
	      if (what.startsWith("List"))
	      {
	         view.show("" + model.getAll());
	      }
	      else if (what.startsWith("Add"))
	      {
	         String msg = "Add method - not implemented";
	         view.show(msg);
	      }
	      else if (what.startsWith("Remove"))
	      {
	         String input = view.get("title");
	         if (input == null)
	            return;
	         String msg = "";
	         Cd cd = model.getAll().removeFirstCdByTitle(input);
	         if (cd != null)
	         {
	            msg = "REMOVED: \n" + cd.toString();
	         }
	         else
	         {
	            msg = "No CD with title: \"" + input + "\" found";
	         }
	         view.show(msg);
	      }
	      else if (what.startsWith("Search"))
	      {
	         String input = view.get("title");
	         if (input == null)
	            return;
	         String msg = "";
	         CdList list = model.getAll().getCdsByTitle(input);
	         for (int i = 0; i < list.getNumberOfCds(); i++)
	         {
	            msg += list.getCD(i) + "\n\n\n";
	         }
	         if (list.getNumberOfCds() == 0)
	         {
	            msg = "No CD with title: \"" + input + "\" found";
	         }
	         view.show(msg);
	      }
	      else if (what.startsWith("Quit"))
	      {
	         System.exit(0);
	      }
	}
}
