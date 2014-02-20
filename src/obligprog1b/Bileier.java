
package obligprog1b;

public abstract class Bileier 
{
    private Bil bil;
    private BillisteB liste;
    String navn;
    String adresse;
    String Nr;
    
    Bileier neste;
    
    public Bileier(String n, String adr, String Nr)
    {
        navn = n;
        adresse = adr;
        
    }
    
    public String toString()
    {
        String s = "";
        return s;
    }

    public abstract String getNr();
    /*{
        return Nr; //To change body of generated methods, choose Tools | Templates.
    }*/
    public void settInnBil(Bil ny)
    {
        try
        {
            liste.settInn(ny);
        }
        catch(NullPointerException n)
        {
            liste=new BillisteB();
            liste.settInn(ny);
        }
    }
    public boolean slettBil(String nr)
    {
        if(liste.fjernBil(nr))
        {
            return true;
        }
        return false;
    }
    
    public Bil finnBil(String nr)
    {
        if(emptyBil())
        {
            return null;
        }
        else
        {
            return liste.finnBil(nr);
        }
        
    }
    public boolean emptyBil()
    {
        if(liste==null)
        {
            return true;
        }
        else
        {
            return(liste.BilEmpty());
        }
    }

}

