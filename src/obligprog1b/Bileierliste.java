
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
            if((løper.getNr()).equalsIgnoreCase(nr))
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
    public Bil finnBil(String nr)
    {
        Bileier løper = første;
        while(løper != null)
        {
            if(løper.finnBil(nr)!=null)
            {
                return løper.finnBil(nr);     
            }
            else
            {
                løper = løper.neste;
            }
        }
        return null;
        
    }

    
  public boolean fjernEier( String nr )
  {
      if(EierEmpty())
          return false;
      if((første.getNr().equalsIgnoreCase(nr)))
      {
          første=første.neste;
          return true;
      }
      else
      {
          Bileier løper = første;
          while(løper.neste!=null)
          {
              if(løper.neste.getNr().equalsIgnoreCase(nr))
              {
                  løper.neste=løper.neste.neste;
                  return true;
              }
              løper = løper.neste;
          }
          return false;
      }
  }

  public boolean EierEmpty()
  {
        Bileier løper = første;
        if(første==null)
        {
            while(løper.neste == null)
            return true;
        }
        return false;
  }
  
  public Bileier finnBileier(String nr)
  {
      Bileier løper = første;
      while(løper!=null)
      {
          if((løper.getNr()).equals(nr))
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
