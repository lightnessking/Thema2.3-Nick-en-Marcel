package Dobbelsteen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

// NOTA BENE: Deze code is niet thread-safe omdat jullie dat in de 1e week nog niet kennen. 
// Zie paragraaf 30.2 voor de thread-safe implementatie.
public class DobbelsteenModel
{
	private int waarde;
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();

    
        private int one;
        private int two;
        private int three;
        private int four;
        private int five;
        private int six;
        private int counter;

	public DobbelsteenModel()
	{
		waarde= (int)(Math.random()*6+1);
	}
	
    public int getWaarde()
    {
        return waarde;
    }    
	public void verhoog()
	{
		waarde++;
	    if (waarde>6) waarde=1;
	    updateScore();
	    // Merk op dat we de 3e String-parameter van de constructor van de ActionEvent niet invullen.
	    // In dit geval zou je die kunnen gebruiken om de nieuwe dobbelsteenwaarde mee te geven
	    // aan de ActionListener. Dan hoeft de ActionListener niet met e.getSource() weer naar
	    // het model toe te gaan.
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	public void verlaag()
	{
	    waarde--;
	    if (waarde<1) waarde=6;
            updateScore();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	} 
	public void gooi(){
	    waarde= (int)(Math.random()*6+1);
            updateScore();
	    processEvent( new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	}
	
	public void addActionListener( ActionListener l){
		actionListenerList.add( l );
	}

	public void removeActionListener( ActionListener l){
		if ( actionListenerList.contains( l ) )
			actionListenerList.remove( l );
	}
	
	private void processEvent(ActionEvent e){
		// Hieronder gebruiken we het nieuwe Java "foreach" statement. 
		// Lees het als: "for each ActionListener in actionListenerList do ..."
		// Je kunt ook een for-lus of een iterator gebruiken, maar foreach is het elegantste.
		for( ActionListener l : actionListenerList)
			l.actionPerformed( e );
	}

        public void updateScore()
        {
            this.counter ++;
            switch(this.waarde){
                case 1: this.one ++;
                break;
                case 2: this.two ++;
                break;
                case 3: this.three ++;
                break;
                case 4: this.four ++;
                break;
                case 5: this.five ++;
                break;
                case 6: this.six ++;
                break;
            }
        }
    public int getOne() {
        return one;
    }

    public int getTwo() {
        return two;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getSix() {
        return six;
    }
      
    public int getCounter() {
        return counter;
    }
}
