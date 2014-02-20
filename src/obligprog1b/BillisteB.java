
package obligprog1b;

import javax.swing.JTextArea;


public class BillisteB
{
    private Bil første;
    
    public void settInn(Bil ny)
    {
        if(BilEmpty())
        {
            første = ny;
            return;
        }
        else
        {
            Bil løper = første;
            while(løper.neste != null)
            {
                løper = løper.neste;
            }
            løper.neste = ny;
            return;
        }  
    }
    public Bil finnBil(String kjennetegn)
    {
                Bil løper = første;
        while(løper != null)
        {
            if((løper.getKjennetegn()).equalsIgnoreCase(kjennetegn))
            {
                return løper;
            }
            else{
                løper = løper.neste;
            }
        }
        return null;     
    }
    
    public boolean fjernBil(String kjennetegn)
    {
        if((første.getKjennetegn()).equalsIgnoreCase(kjennetegn))
        {
            første = første.neste;
            return true;
        }
        else
        {
            Bil løper = første;
            while(løper.neste!=null)
            {
                if((løper.neste.getKjennetegn()).equalsIgnoreCase(kjennetegn))
                {
                    løper.neste = løper.neste.neste;
                    return true;
                }
                else
                {
                    løper = løper.neste;
                }
            }
            return false;
        }
    }
       
    public boolean BilEmpty()
    {
        if(første==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*public String skrivListe()
    {
        String print = "";
        Bil løper = første;
        while(løper != null)
        {
            print += løper.toString() + "\n";
            løper = løper.neste;
        }
        return print;
    }*/
        
  public void skrivListe(JTextArea biler)
  {
        if(første==null)
            biler.append("Ingen biler registrert.");
        else
        {
            //biler.setText("");
            Bil løper = første;
            while(løper!=null)
            {
                biler.append(løper.toString() + "\n\n");
                løper = løper.neste;
            }
        }      
    }
 
}
