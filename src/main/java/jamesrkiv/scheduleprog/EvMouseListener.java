/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamesrkiv.scheduleprog;
// Imports
import static jamesrkiv.scheduleprog.scheduleApp.eventArray;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

// Custom listener for use with event blocks, since
// they're created dynamically. Makes me wonder how
// horribly wrong I'm doing all this, lol
public class EvMouseListener implements MouseListener
{    
    // Variables
    private int pDay, h_1, m_1, h_2, m_2;
    private boolean am_1, am_2;
    private boolean[] rec;
    private String[] ev;
    private Color clr;
    public String uid;
    
    private int inx;
    
    // Info Block
    BlockInfo blck;
    
    // Basic constructor to get important info
    // Now I know for a fact this isn't a good idea
    public EvMouseListener(int parentDay, int h1, int m1, int h2, int m2,
            boolean am1, boolean am2, boolean[] r, String[] e, Color c, String uuid)
    {   
        pDay= parentDay;
        h_1 = h1; m_1 = m1; am_1 = am1; // Start time
        h_2 = h2; m_2 = m2; am_2 = am2; // End time
        rec = r;                        // Recurrence array
        ev = e;                         // Event info array
        clr = c;                        // Color
        uid = uuid;                     // UUID
        
        blck = new BlockInfo();         // Info block for event
        blck.setVisible(false);
        
        blck.setEv(e);
        blck.setCol(c);
        
        // Formatting variables
        String desc = "";
        String am01 = "";
        String am02 = "";
        String m01 = "";
        String m02 = "";
        
        // Adds day to desc
        switch(pDay)
        {
            case 1:
                desc += "Sunday\n";
                break;
            case 2:
                desc += "Monday\n";
                break;
            case 3:
                desc += "Tuesday\n";
                break;
            case 4:
                desc += "Wednesday\n";
                break;
            case 5:
                desc += "Thursday\n";
                break;
            case 6:
                desc += "Friday\n";
                break;
            case 7:
                desc += "Saturday\n";
                break;
            default: // Shouldn't be possible
                desc += "Uh oh\n";
                break;
        }
        
        // AM/PM formatting
        if (am_1) am01 = "AM";
        else am01 = "PM";
        if (am_2) am02 = "AM";
        else am02 = "PM";
        
        // Prevents times looking like "9:0 PM" etc
        if (m1 == 0) m01 = "00";
        else m01 = Integer.toString(m1);
        if (m2 == 0) m02 = "00";
        else m02 = Integer.toString(m2);
        
        // Adds times to desc
        desc += h1 + ":" + m01 + " " + am01 +
                " - " + h2 + ":" + m02 + " " + am02;
        
        // Changes textbox
        blck.setDesc(desc);
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        try
        {
            // Gets component position
            Point ml = MouseInfo.getPointerInfo().getLocation();
            int evX = ml.x;
            int evY = ml.y;
            
            blck.setLocation(evX, evY);
            blck.setVisible(true);
            // System.out.println("Info box opened... hopefully");
        }
        catch (NullPointerException exc)
        {
            System.out.println("Err: Unable to get component from listener!");
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        return;
    }
}
