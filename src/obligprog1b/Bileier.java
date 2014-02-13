
package obligprog1b;
//HEI hilsen Mads
public abstract class Bileier 
{
    String navn;
    String adresse;
    
    Bileier neste;
    
    private BillisteB register = new BillisteB();
    
    public Bileier(String n, String a)
    {
        navn = n;
        adresse = a;
    }
}

