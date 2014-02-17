
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
    
    public Bileier finn(String nr)
    {
          Bileier løper = første;
        while(løper != null)
        {
            if((løper.getNr()).equalsIgnoreCase(nr))//denne metoden må endres, fungerer ikke
            {
                return løper;
            }
            else
            {
                løper = løper.neste;
            }
        }
        return null;
        
    }
    
    public Bileier fjernEier( String nr )
    {
            if( første == null ) 
                return null;

            if( første.getNr().equals( nr ) )
            {
                Bileier retur = første;
                første = første.neste;
                return retur;
            }

            Bileier løper = første;

            while( løper.neste != null )
            {
                if( løper.neste.getNr().equals( nr ) )
                {
                    Bileier retur = løper.neste;
                    løper.neste = løper.neste.neste;
                    return retur;
                }
                else
                løper = løper.neste;
                }

            return null;
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

}
