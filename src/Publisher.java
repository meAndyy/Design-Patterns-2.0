import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.Icon;

public class Publisher extends AbstractPublisher {
    public Publisher(String initName, Icon initIcon) {
        name = initName;
        icon = initIcon;
        leaf = true;
    }
    //--------------------------------------
    public Publisher(Publisher initParent, String initName, Icon initIcon) {
        name = initName;
        icon = initIcon;
        parent = initParent;
        leaf = true;
    }
    //--------------------------------------
    public Icon getIcon() {
        return icon;
    }
    //--------------------------------------
    public String getName() {
        return name;
    }
    //--------------------------------------


    public boolean add(Publisher e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");
    }

    public void remove(Publisher e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");
    }




    public Enumeration subordinates () {
        Vector v = new Vector();
        return v.elements ();
    }



    //--------------------------------------
    public Publisher getChild(String s) throws NoSuchElementException {
        throw new NoSuchElementException("No children");
    }

    //--------------------------------------
    /*public Icon getIcons() {
        return icon;
    }*/
    //--------------------------------------
    public Publisher getParent() {
        return parent;
    }
	
	
}
