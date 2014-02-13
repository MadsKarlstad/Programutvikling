
package obligprog1b;

public class Bil 
{
    private String kjennetegn;
    private String merke;
    private String type;
    private String regår;
    //private String eier;
    
    Bil neste;
    
    public Bil(String k, String m, String t, String r)
    {
        kjennetegn = k;
        merke = m;
        type = t;
        regår = r;
        //eier = e;
    }
    
    /*public String getEier()
    {
        return eier;
    }*/
    
    public String getKjennetegn()
    {
        return kjennetegn;
    }
    
    public String toString()
    {
        String s = "Kjennetegn: " + kjennetegn;
        s += "\nMerke: " + merke;
        s += "\nType: " + type;
        s += "\nFørst registrert: " + regår;
        return s;
    }

}
