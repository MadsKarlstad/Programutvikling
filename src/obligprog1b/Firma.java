
package obligprog1b;

public class Firma extends Bileier
{
    private String foretaksnr;
    private Bil bil;
    
    Firma(String n, String a, String nr )
    {
        super(n,a,nr);
        foretaksnr = nr;
    }
    
    public String getNr()
    {
        return foretaksnr;
    }
    
    public String toString()
    {

        String s="Navn: " + navn;
        s+="\nAdresse: " + adresse;
        s+="\nForetaksnummer: " + foretaksnr;
        s+="\n*********************************";
        
        
        
        return s;
    }

}
