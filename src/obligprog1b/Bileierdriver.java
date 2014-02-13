
package obligprog1b;

import java.awt.event.*;

public class Bileierdriver 
{
    public static void main(String[]args)
    {
        BileierGUI vindu = new BileierGUI();
        vindu.addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
    }

}
