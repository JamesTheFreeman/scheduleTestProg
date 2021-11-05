/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamesrkiv.scheduleprog;

/**
 * Represents an event, stores relevant info
 * @author james
 */
public class eventObject {
    // Variables
    private final String recurr;    // Recurrence (none, weekly, monthly)
    private final String sDate;     // Start date (beginning of week)
    private final String sTime;     // Start Time
    private final String eTime;     // End time
    private final String event1;    // Event line one
    private final String event2;    // Event line two (null if unused)
    private final String dOfTheW;   // Days of the week (1 2 6) (etc.)
    private final String color;     // Chosen color
    private final String uuid;      // UUID
    
    public boolean kill = false;    // Flag for deletion
    public int inx;                 // Index in event array
    
    // Contructor
    public eventObject(String rc, String sd, String sT, String eT, String e1, String e2, String dotw, String clr, String uuID) {
        recurr = rc;
        sDate = sd;
        sTime = sT;
        eTime = eT;
        event1 = e1;
        if (e2.toLowerCase().equals("empty")) event2 = null;
        else event2 = e2;
        dOfTheW = dotw;
        color = clr;
        uuid = uuID;
    }
    
    // Get functions
    public String getRecurr() {return recurr;}
    public String getsDate() {return sDate;}
    public String getsTime() {return sTime;}
    public String geteTime() {return eTime;}
    public String gete1() {return event1;}
    public String gete2() {return event2;}
    public String getdOfTheW() {return dOfTheW;}
    public String getColor() {return color;}
    public String getUUID() {return uuid;}
}
