/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mtgi;

/**
 *
 * @author Mateusz
 */
public class TurniejKlasa {
    int id;
    String nazwa;
    String data;
    String typ;
    String zalozyciel;
    String druzyna;
    TurniejKlasa(int i, String n, String d, String t, String z, String dr){
        id=i;
        nazwa=n;
        data=d;
        typ=t;
        zalozyciel=z;
        druzyna=dr;
    }
}
