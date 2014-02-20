
package obligprog1b;

public class Firma extends Bileier
{
    private String foretaksnr;
    
    Firma(String n, String adr, String nr)
    {
        super(n,adr,nr);
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
