
package obligprog1b;

public class Person extends Bileier
{
    private String personnr;
    
    public Person(String pnr, String n, String a )
    {

        super(n,a);
        personnr = pnr;
    }
    
    public String getPersonnr()
    {
        return personnr;
    }
    
    public String toString()
    {
        String s = "Navn: " + navn
        +"\nAdresse: " + adresse
        +"\nFødselsnummer: " + personnr;
        return s;
    }
    
}
