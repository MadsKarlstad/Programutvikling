
package obligprog1b;

public class Person extends Bileier
{
    private String personnr;
    
    public Person(String n, String adr, String Nr )
    {

        super(n,adr,Nr);
        personnr = Nr;
        //this.bil=b;
        
    }
    
    public String getNr()
    {
        return personnr;
    }
    
    public String toString()
    {
        String s = "Navn: " + navn + "\n";
        s+="Adresse: " + adresse + "\n";
        s+= "Personnummer: " + personnr + "\n";
        s+="\n*********************************";
        
        return s;
    }
    //dette er en test hallololol

}
