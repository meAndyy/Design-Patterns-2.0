import java.util.Enumeration;
import java.util.NoSuchElementException;

import javax.swing.Icon;


public abstract class AbstractPublisher {
	
	 	protected String name;
	    protected Icon icon;
	    protected Publisher parent = null;
	    protected boolean leaf = true;

	    public abstract Icon getIcon();
	    public abstract String getName();
	    public abstract boolean add(Publisher e)
	        throws NoSuchElementException;
	    public abstract void remove(Publisher e)
	        throws NoSuchElementException;
	    public abstract Enumeration subordinates();
	    public abstract Publisher getChild(String s);
	   // public abstract Icon getIcons();
	    public boolean isLeaf() {
	        return leaf;}
	    }
