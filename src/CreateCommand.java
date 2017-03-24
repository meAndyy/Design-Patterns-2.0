import java.awt.*;
import javax.swing.*;

public class CreateCommand implements AbstractCommand {
   JFrame frame;
   JPanel panel;

   public CreateCommand(JFrame fr, JPanel pl) {
      frame = fr;
      panel = pl;
   }
//------------------------------
   public void execute() {
	   
	   panel.setLayout(new BorderLayout());
	   JLabel text = new JLabel("Design Patterns by Andrew Richards and Stephen O'Brien");
	   panel.add(text);
	   
   }
}

