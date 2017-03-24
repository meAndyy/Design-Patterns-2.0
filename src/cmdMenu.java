import java.awt.*;
import javax.swing.*;

public class cmdMenu extends JMenuItem implements CommandHolder {
   protected AbstractCommand menuCommand;
   protected JFrame frame;
//-----------------------
   public cmdMenu(String name, JFrame frm) {
      super(name);
      frame = frm;
   }
//-----------------------
   public void setCommand(AbstractCommand comd) {
      menuCommand = comd;
   }
//-----------------------
   public AbstractCommand getCommand() {
      return menuCommand;
   }

}