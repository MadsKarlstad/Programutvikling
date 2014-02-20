/**
 * Skrevet av: 
 * Mads M Karlstad, studnr: s193949, HINGDATA
 * Erlend Westbye, studnr: s193377, HINGDATA
 * Christoffer B Jønsberg: s193674, HINGDATA
 */

package obligprog1b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BileierGUI extends JFrame
{
    private JTextField navnfelt, adressefelt, nrfelt, 
                       kjennetegnfelt, merkefelt, typefelt, årfelt;
    private JButton regEierP, regEierF, regBil, finnBil, fjernBil, 
                    visAlle, visEiere, slettEier;
    private JTextArea utskriftsområde;
    private BillisteB register = new BillisteB();
    private Bileierliste liste = new Bileierliste();
    
    public BileierGUI()
    {
        super("BileierGUI");
     
        kjennetegnfelt = new JTextField(18);
        merkefelt = new JTextField(18);
        typefelt = new JTextField(18);
        årfelt = new JTextField(18);
        navnfelt = new JTextField(18);
        adressefelt = new JTextField(18);
        nrfelt = new JTextField(18);
        regBil = new JButton("Registrer bil");
        regEierP = new JButton("Registrer bileier(privat)");
        regEierF = new JButton("Registrer bileier(firma)");
        finnBil = new JButton("Finn bil");
        fjernBil = new JButton("Fjern bil");
        visAlle = new JButton("Vis bilregisteret");
        slettEier = new JButton("Slett bileier");
        utskriftsområde = new JTextArea(15,45);
        utskriftsområde.setEditable(false);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("Kjennetegn: "));
        c.add(kjennetegnfelt);
        c.add(new JLabel("Merke: "));
        c.add(merkefelt);
        c.add(new JLabel("Type:"));
        c.add(typefelt);
        c.add(new JLabel("Første reg.år: "));
        c.add(årfelt);
        c.add(new JLabel("Navn: "));
        c.add(navnfelt);
        c.add(new JLabel("Adresse: "));
        c.add(adressefelt);
        c.add(new JLabel("Person- eller foretaksnummer: "));
        c.add(nrfelt);
        c.add(new JLabel("          "));
        c.add(regBil);
        c.add(finnBil);
        c.add(fjernBil);
        c.add(visAlle);
        c.add(regEierP);
        c.add(regEierF);
        c.add(slettEier);
        c.add(new JScrollPane(utskriftsområde));
        
        Knappelytter lytter = new Knappelytter();
        
        regEierP.addActionListener(lytter);
        regEierF.addActionListener(lytter);
        regBil.addActionListener(lytter);
        finnBil.addActionListener(lytter);
        fjernBil.addActionListener(lytter);
        visAlle.addActionListener(lytter);
        slettEier.addActionListener(lytter);
        setSize(620,500);
        setVisible(true);
    }
    
    public void nyBil()
    {
        String kjennetegn = kjennetegnfelt.getText();
        String merke = merkefelt.getText();
        String type = typefelt.getText();
        String regår = årfelt.getText();
        String navn = navnfelt.getText();
        String adresse = adressefelt.getText();
        String nr = nrfelt.getText();
        
        if(kjennetegn.length() == 0 || merke.length() == 0
	|| type.length() == 0 || regår.length() == 0 || nr.length() == 0)        
        {
            visMelding("Fyll ut nødvendig informasjon");
            return;
            
        }
        if(navn.length()!=0 || adresse.length()!=0 || nr.length()!=0)
        {
            liste.settInn(
                   new Person(navn,adresse,nr));
            Bileier person = liste.finn(nr);
            try
            {
                Bil ny = new Bil(kjennetegn,merke,type,regår,person);
                Bileier find = liste.finn(nr);
                if(register.finnBil(kjennetegn) == null)
                {
                    register.settInn(ny);
                    visMelding("Bil registrert");
                    slettFelter();
                    return;
                }
                visMelding("Bilen finnes fra før, prøv med nytt reg.nummer");
            }
            catch(NullPointerException n)
            {
                visMelding("Det er feil i registeret, yo (Eieren finnes ikke)");
            }
        }
            
        /*try
        {
            Bil ny = new Bil(kjennetegn,merke,type,regår, );
            Bileier find = liste.finn(nr);
            if(liste.finnBil(kjennetegn)==null)
            {
                find.settInnBil(ny);
                visMelding("Bil registrert");
                slettFelter();
                return;
            }
            visMelding("Bilen finnes fra før, prøv med nytt reg.nummer");
        }
        catch(NullPointerException n)
        {
            visMelding("Det er feil i registeret, yo (Eieren finnes ikke)");
        }*/
    }

    public void nyBileierPers()
    {
      
       String navn = navnfelt.getText();
       String adresse = adressefelt.getText();
       String nummer = nrfelt.getText();
       if(nummer.length() == 0 || navn.length() == 0
	|| adresse.length() == 0)
       {
           visMelding("Fyll ut nødvendig informasjon!");
           return;
       }
       try
       {
           liste.settInn(
                   new Person(navn,adresse,nummer));
           visMelding("Ny bileier registrert");
           slettFelter();
       }
       catch(NullPointerException e)
       {
           visMelding("Feil i registeret");
       }
       
    }
    
    public void nyBileierFirma()
    {
       String nummer = nrfelt.getText();
       String navn = navnfelt.getText();
       String adresse = adressefelt.getText();
       if(nummer.length() == 0 || navn.length() == 0
	|| adresse.length() == 0)
       {
           visMelding("Fyll ut nødvendig informasjon!");
           return;
       }
       try
       {
           liste.settInn(
                   new Firma(navn,adresse,nummer));
           visMelding("Ny bileier registrert");
           slettFelter();
       }
       catch(NullPointerException e)
       {
           visMelding("Feil i tallformat");
       }
    }
    
    public void finnBil()
    {
        String kjennetegn = kjennetegnfelt.getText();
        if(kjennetegn.length() == 0)
        {
            visMelding("Skriv inn regnr plz");
            slettFelter();
        }
        Bil b = register.finnBil(kjennetegn);
        if(b!=null)
        {           
            register.skrivListe(utskriftsområde);
            slettFelter();           
        }     
    }

   public void slettBil()
   {

       String kjennetegn = kjennetegnfelt.getText();
       if(kjennetegn.length() == 0)
       {
            visMelding("Skriv inn regnr plz");
            slettFelter();
       }
       try
       {
           utskriftsområde.setText("");
           register.fjernBil(kjennetegn);
           slettFelter();
           
       }
       
       catch(NullPointerException n)
       {
           visMelding("Feil i registeret");
       }
           
       
    }
   
    public void slettEier()
    {
        
        String nr = nrfelt.getText();
        
        if(nr.length() == 0 )
        {
            visMelding("Skriv inn nr plz");
            slettFelter();
        }
        Bileier test = liste.finn(nr);
        if(test!=null)
        {
            if(!test.emptyBil())
            {
                visMelding("Eieren har en bil registrert og kan ikke slettes");
                slettFelter();
            }
            else if(liste.fjernEier(nr))
            {
                visMelding("Eieren er slettet!");
                slettFelter();
                
            }
        }
        else
        {
            visMelding("Finner ikke eier");
        }
        /*{
            utskriftsområde.setText("");
            liste.fjernEier(nr);
            slettFelter();
            
           
        }

        catch(NullPointerException n)
        {
            visMelding("Feil i registeret");
        }*/
        
        
  
    }
   
    public void visRegister()
    {
        utskriftsområde.setText("");
        register.skrivListe(utskriftsområde);
    }
    public void visEiere()
    {
        utskriftsområde.setText("");
        liste.skrivListe(utskriftsområde);
        
    }
    
    private void visMelding( String melding)
    {
        JOptionPane.showMessageDialog(this,melding);
    }
    
    private void slettFelter()
    {
        kjennetegnfelt.setText( "" );
        merkefelt.setText( "" );
        typefelt.setText( "" );
        årfelt.setText( "" );
        navnfelt.setText("");
        adressefelt.setText("");
        nrfelt.setText("");
    }
    
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( e.getSource() == regBil )
                nyBil();
            else if(e.getSource() == regEierP)
                nyBileierPers();
            else if(e.getSource() == regEierF)
                nyBileierFirma();
            else if ( e.getSource() == finnBil )
                finnBil();
            else if ( e.getSource() == fjernBil )
                slettBil();
            else if ( e.getSource() == visAlle )
                visRegister();
            else if ( e.getSource() == slettEier )
                slettEier();
        }
    }

}
