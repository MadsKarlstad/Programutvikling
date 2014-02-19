
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
        }  
    }
    public Bil finnBil(String kjennetegn)
    {
                Bil løper = første;
        while(løper != null){
            if((løper.getKjennetegn()).equalsIgnoreCase(kjennetegn)){
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
        if((første.getKjennetegn()).equalsIgnoreCase(kjennetegn)){
            første = første.neste;
            return true;
        }
        else{
            Bil løper = første;
            while(løper.neste!=null){
                if((løper.neste.getKjennetegn()).equalsIgnoreCase(kjennetegn)){
                    løper.neste = løper.neste.neste;
                    return true;
                }
                else{
                    løper = løper.neste;
                }
            }
            return false;
        }
    }
       
    public Bil fjern( String kjennetegn )
    {
            if( første == null ) 
                return null;

            if( første.getKjennetegn().equals( kjennetegn ) )
            {
                Bil retur = første;
                første = første.neste;
                return retur;
            }

            Bil løper = første;

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
