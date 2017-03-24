import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;


public class Viewer extends JFrame
implements TreeSelectionListener, ActionListener {
    Publisher prez, sony, ms, nint;
    Publisher analysis, coding;
    

    JScrollPane sp;
    JPanel treePanel, iconPanel, textPanel;
    JTree tree;
    DefaultMutableTreeNode troot;
    JLabel pic;
    JMenu mnuFile;
    cmdMenu mnuDisplay, mnuCreate;
    JTextField text;

    public Viewer() {
        super("Publisher tree");
        makePublishers();
        setGUI();
    }
    //--------------------------------------
    private void setGUI() {
        treePanel = new JPanel();
        iconPanel = new JPanel();
        textPanel = new JPanel();
        getContentPane().setLayout(new GridLayout(2,2));
        getContentPane().add(treePanel);
        getContentPane().add(iconPanel);
        getContentPane().add(textPanel);
        
        treePanel.setLayout(new BorderLayout());
        
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        mnuFile = new JMenu("Menu", true);
        mbar.add(mnuFile);
        
        mnuDisplay = new cmdMenu("Display", this);
        mnuFile.add(mnuDisplay);
        
        mnuCreate = new cmdMenu("Create", this);
        mnuFile.add(mnuCreate);
        
        mnuDisplay.setCommand(new DisplayCommand(this,textPanel));
        mnuDisplay.addActionListener(this);
        
        mnuCreate.setCommand(new CreateCommand(this,textPanel));
        mnuCreate.addActionListener(this);

        sp = new JScrollPane();
        treePanel.add("Center", sp);
        iconPanel.add(pic = new JLabel("          "));
      

        treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        troot = new DefaultMutableTreeNode(prez.getName());
        tree= new JTree(troot);
        tree.setBackground(Color.lightGray);
        loadTree(prez);
        /* Put the Tree in a scroller. */

        sp.getViewport().add(tree);
        //getContentPane().add(iconPanel);
        setSize(new Dimension(700, 450));
        setVisible(true);

    }
    //------------------------------------
    public void loadTree(Publisher topDog) {
        DefaultMutableTreeNode troot;
        troot = new DefaultMutableTreeNode(topDog.getName());
        treePanel.remove(tree);
        tree= new JTree(troot);
        tree.addTreeSelectionListener(this);
        sp.getViewport().add(tree);

        addNodes(troot, topDog);
        tree.expandRow(0);
        repaint();
    }
    //--------------------------------------

    private void addNodes(DefaultMutableTreeNode pnode, Publisher pro) {
        DefaultMutableTreeNode node;

        Enumeration e = pro.subordinates();
        if (e != null) {
            while (e.hasMoreElements()) {
                Publisher newpro = (Publisher)e.nextElement();
                node = new DefaultMutableTreeNode(newpro.getName());
                pnode.add(node);
                addNodes(node, newpro);
            }
        }
    }

    //--------------------------------------

    private void makePublishers() {
        prez = new PublisherHead("Console", new ImageIcon("imgs/bethesda.jpg"));
        prez.add(sony = new PublisherHead("Sony",new ImageIcon("imgs/bethesda.jpg")));
        prez.add(ms = new PublisherHead("Microsoft", new ImageIcon("imgs/bethesda.jpg")));
        prez.add(nint = new PublisherHead("Nintendo", new ImageIcon("imgs/bethesda.jpg")));

       sony.add(new Publisher("Bethesda", new ImageIcon("imgs/bethesda.jpg")));
       sony.add(analysis = new PublisherHead("SquareEnix", new ImageIcon("imgs/bethesda.jpg")));
       analysis.add(new Publisher("Final Fantasy", new ImageIcon("imgs/bethesda.jpg")));
       analysis.add(new Publisher("Days Gone", new ImageIcon("imgs/bethesda.jpg")));
       analysis.add(new Publisher("Kingdom Hearts", new ImageIcon("imgs/bethesda.jpg")));
       sony.add(new Publisher("Electronic Arts",new ImageIcon("imgs/bethesda.jpg") ));
        
       ms.add(new Publisher("Design",new ImageIcon("imgs/bethesda.jpg")));
       ms.add(coding = new PublisherHead("Coding",new ImageIcon("imgs/bethesda.jpg")));
       coding.add(new Publisher("Prog specs", new ImageIcon("imgs/bethesda.jpg")));
       coding.add(new Publisher("Screens", new ImageIcon("imgs/bethesda.jpg")));
       ms.add(new Publisher("Analysis",new ImageIcon("imgs/bethesda.jpg")));
       
       nint.add(new Publisher("Design",new ImageIcon("imgs/bethesda.jpg")));
       nint.add(new Publisher("Coding",new ImageIcon("imgs/bethesda.jpg")));
       nint.add(new Publisher("Testing",new ImageIcon("imgs/bethesda.jpg")));
    }
    
    public void valueChanged(TreeSelectionEvent evt) {
    	
        TreePath path = evt.getPath();
        String selectedTerm = path.getLastPathComponent().toString();

        Publisher pro = prez.getChild(selectedTerm);
        if (pro != null)
            pic.setIcon(pro.getIcon());
    }
    
    public void actionPerformed(ActionEvent e)   {
        CommandHolder obj = (CommandHolder)e.getSource();
        obj.getCommand().execute();
     }
    //--------------------------------------
    static public void main(String argv[]) {
        new Viewer();
    }
}

