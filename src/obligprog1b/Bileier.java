
package obligprog1b;

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
    
    public String toString()
    {
        String s = "";
        s += "Bil: \n";
        
        
        return s;
    }

    public String getNr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

