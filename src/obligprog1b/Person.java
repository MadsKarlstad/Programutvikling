
package obligprog1b;

public class Person extends Bileier
{
    private String personnr;
    private Bil første;
    
    public Person(String pnr, String n, String a )
    {

        super(n,a);
        personnr = pnr;
    }
    
    public String getNr()
    {
        return personnr;
    }
    
    public String toString()
    {
        String s = "Navn: " + navn
        +"\nAdresse: " + adresse
        +"\nFødselsnummer: " + personnr;
        s+="\n*********************************";
        s+="\nBil: ";
        return s;
    }
    
}
