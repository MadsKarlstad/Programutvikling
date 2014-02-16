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
    private JButton regEierP, regEierF, regBil, finnBil, fjernBil, visAlle;
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
        visAlle = new JButton("Vis alle registrerte");
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
        c.add(new JScrollPane(utskriftsområde));
        
        Knappelytter lytter = new Knappelytter();
        
        regEierP.addActionListener(lytter);
        regEierF.addActionListener(lytter);
        regBil.addActionListener(lytter);
        finnBil.addActionListener(lytter);
        fjernBil.addActionListener(lytter);
        visAlle.addActionListener(lytter);
        setSize(620,500);
        setVisible(true);
    }
    
    public void nyBil()
    {
       String kjennetegn = kjennetegnfelt.getText();
       String merke = merkefelt.getText();
       String type = typefelt.getText();
       String regår = årfelt.getText();
       String nr = nrfelt.getText();
       String navn = navnfelt.getText();
       String adresse = adressefelt.getText();
       if(kjennetegn.length() == 0 || merke.length() == 0
	|| type.length() == 0 || regår.length() == 0 || nr.length() == 0)
       {
           visMelding("Fyll ut nødvendig informasjon!");
           return;
       }
       try
       {
           Bileier bileier = new Person(nr, navn, adresse);
           liste.settInn(
                   new Person(nr,navn,adresse));
           register.settInn(
                   new Bil(kjennetegn,merke,type,regår, bileier));
           visMelding("Ny bil registrert");
           slettFelter();
       }
       catch(NumberFormatException e)
       {
           visMelding("Feil i tallformat");
       }
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
                   new Person(nummer,navn,adresse));
           visMelding("Ny bileier registrert");
           slettFelter();
       }
       catch(NumberFormatException e)
       {
           visMelding("Feil i tallformat");
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
                   new Firma(nummer,navn,adresse));
           visMelding("Ny bileier registrert");
           slettFelter();
       }
       catch(NumberFormatException e)
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
    
    /*public void finnBileier()
    {
        String nr = nrfelt.getText();
        if(nr.length() == 0)
        {
            visMelding("Skriv inn person- eller foretaksnummer plz");
            slettFelter();
        }
        Bil b = liste.finn(nr);
        if(b!=null)
        {
            
            register.skrivListe(utskriftsområde);
            slettFelter();
            
        }
    }*/
    
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
           register.fjern(kjennetegn);
           slettFelter();
           
       }
       
       catch(NumberFormatException nfe)
       {
           visMelding("Feil i tallformat");
       }
           
       
    }
    public void visRegister()
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
        }
    }

}
