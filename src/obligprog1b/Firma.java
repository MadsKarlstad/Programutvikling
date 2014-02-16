
package obligprog1b;

public class Firma extends Bileier
{
    private String foretaksnr;
    
    Firma(String fnr, String n, String a )
    {
        super(n,a);
        foretaksnr = fnr;
    }
    
    public String getNr()
    {
        return foretaksnr;
    }
    
    public String toString()
    {
        String s = "Navn: " + navn
        +"\nAdresse: " + adresse
        +"\nForetaksnummer: " + foretaksnr;
        s+="\n*********************************";
        s+="\nBil: ";
        
        
        return s;
    }

}
