package Dobbelsteen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
    
public class GridLayOutView extends JPanel implements ActionListener
{
    private JTextArea steenRoodVeld = new JTextArea();
    private final static String newline = "\n";
    DobbelsteenModel d;
    
	public GridLayOutView()
	{
	    this.setLayout(new FlowLayout());
	    this.add(steenRoodVeld);
	}
	
	public void actionPerformed( ActionEvent e )
	{
	    d = (DobbelsteenModel) e.getSource();
	    steenRoodVeld.setText(
                    "Aantal worpen:" + d.getCounter() + newline +
                    "Aantal 1:" + d.getOne() + newline +
                    "Aantal 2:" + d.getTwo() + newline +
                    "Aantal 3:" + d.getThree() + newline +
                    "Aantal 4:" + d.getFour() + newline +       
                    "Aantal 5:" + d.getFive() + newline +
                    "Aantal 6:" + d.getSix() + newline 
            );
            
	}
	
	public Dimension getPreferredSize()
	{
	    return new Dimension(100,100);
	} 
        
}


