
package obligprog1b;

public abstract class Bileier 
{
    private Bil bil;
    String navn;
    String adresse;
    String Nr;
    
    Bileier neste;
    
    private BillisteB register = new BillisteB();
    
    public Bileier(String n, String a, String Nr)
    {
        navn = n;
        adresse = a;
        //this.bil = b;
    }
    
    public String toString()
    {
        String s = "";
        
        
        
        return s;
    }

    public String getNr() 
    {
        return Nr; //To change body of generated methods, choose Tools | Templates.
    }
}

