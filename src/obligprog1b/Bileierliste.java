
package obligprog1b;

import javax.swing.*;

public class Bileierliste 
{
    private Bileier første;
    private Bil first;
    
    public void settInn(Bileier ny)
    {
        if(første==null)
        {
            første = ny;
            return;
        }
        else
        {
            Bileier løper = første;
            while(løper.neste!=null)
            {
                løper = løper.neste;
            }
            løper.neste=ny;
        }
    }
    
    public void settInn(Bil ny)
    {
        if(first==null)
        {
            first = ny;
            return;
        }
        else
        {
            Bil løper = first;
            while(løper.neste != null)
            {
                løper = løper.neste;
            }
            løper.neste = ny;
        }
    }
    
    public void skrivListe(JTextArea bileiere)
    {
        if(første==null)
            bileiere.append("Ingen bileiere registrert.");
        else
        {
            Bileier løper = første;
            while(løper!=null)
            {
                bileiere.append(løper.toString() + "\n\n");
                løper = løper.neste;
            }
        }
    }
    
    public Bil fjern( String kjennetegn )
        {
            if( first == null ) 
                return null;

            if( first.getKjennetegn().equals( kjennetegn ) )
            {
                Bil retur = first;
                first = first.neste;
                return retur;
            }

            Bil løper = first;

            while( løper.neste != null )
            {
                if( løper.neste.getKjennetegn().equals( kjennetegn ) )
                {
                    Bil retur = løper.neste;
                    løper.neste = løper.neste.neste;
                    return retur;
                }
                else
                løper = løper.neste;
                }

            return null;
  }

}
