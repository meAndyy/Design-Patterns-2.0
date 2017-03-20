import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.Icon;

public class PublisherHead extends Publisher {
    Vector projects;

    public PublisherHead(String initName, Icon initIcon) {
        super(initName, initIcon);
        leaf = false;
        projects = new Vector();
    }

    public PublisherHead(Publisher initParent, String initName, Icon initIcon) {
        super(initParent, initName, initIcon);
        leaf = false;
        projects= new Vector();
    }

    public PublisherHead(Publisher pro) {
        //promotes an employee position to a Boss
        //and thus allows it to have employees
        super(pro.getName (), pro.getIcon());
        projects = new Vector();
        leaf = false;
    }

    public boolean add(Publisher e) throws NoSuchElementException {
    	projects.add(e);
        return true;
    }

    public void remove(Publisher e) throws NoSuchElementException {
        projects.removeElement(e);
    }

    public Enumeration subordinates () {
        return projects.elements ();
    }

    public Publisher getChild(String s) throws NoSuchElementException {

    	Publisher newPro = null;

        if (getName().equals(s))
            return this;
        else {
            boolean found = false;
            Enumeration e = subordinates();
            while (e.hasMoreElements() && (! found)) {
            	newPro = (Publisher)e.nextElement();
                found = newPro.getName().equals(s);
                if (! found) {
                    if (! newPro.isLeaf ()) {
                    	newPro = newPro.getChild(s);
                    } else
                    	newPro = null;
                    found =(newPro != null);
                }
            }
            if (found)
                return newPro;
            else
                return null;
        }
    }
    //--------------------------------------


    /*public double getSalaries() {
        double sum = time;
        for (int i = 0; i < projects.size(); i++) {
            sum += ((Project)projects.elementAt(i)).getTimes();
        }
        return sum;
    }*/


}
