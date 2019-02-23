package cd.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cd.controller.CdController;
import cd.domain.model.Cd;
import cd.domain.model.CdList;

public class ButtonHandler implements ActionListener
{
   private CdController controller;
   private CdGUI gui;

   public ButtonHandler(CdController controller, CdGUI gui)
   {
      this.controller = controller;
      this.gui = gui;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      controller.execute(((JButton) e.getSource()).getText().toString());
   }
}