
package obligprog1b;

public class Bil 
{
    private String kjennetegn;
    private String merke;
    private String type;
    private String regår;
    private Bileier eier;
    
    Bil neste;
    
    public Bil(String k, String m, String t, String r)
    {
        kjennetegn = k;
        merke = m;
        type = t;
        regår = r;
        neste=null;
        //this.eier = e;
    }
    
    public String getKjennetegn()
    {
        return kjennetegn;
    }
        
    public String toString()
    {
        
        String s = "Bil: ";
        s += "\nKjennetegn: " + kjennetegn;
        s += "\nMerke: " + merke;
        s += "\nType: " + type;
        s += "\nFørst registrert: " + regår;
        s += "\n\nEier: \n" + eier;
        return s;
    }

}
