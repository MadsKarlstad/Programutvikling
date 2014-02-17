
package obligprog1b;

public class Person extends Bileier
{
    private String personnr;
    private Bil bil;
    private Bil første;
    
    public Person(String n, String a, String nr )
    {

        super(n,a,nr);
        personnr = nr;
        //this.bil=b;
        
    }
    
    public String getNr()
    {
        return personnr;
    }
    
    public String toString()
    {
        String s = "Navn: " + navn;
        s+="\nAdresse: " + adresse;
        s+="\nFødselsnummer: " + personnr;
        s+="\n*********************************";
        
        return s;
    }
    
}
