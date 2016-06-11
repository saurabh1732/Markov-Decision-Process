/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
package part3_editeurdereseau;
/**
 *
 * @author bhuvan
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Testing
{
   public static void main(String args[]){
       
     FileIO  FileIO1=new FileIO();
    	
     GridGraph g1=new GridGraph(5,5);
     
      LGraph l=new LGraph(g1,2);
      
      ustat ustatone=new ustat(0,l);
      ustatone.print();
     
      SimpleBarChart1 s1=new SimpleBarChart1(l);
      s1.print();
        GrilleEdit G=new GrilleEdit(l,5,5);
       
        FenetreGrid fen=new FenetreGrid(G);
        fen.setVisible(true);
        Torus_GridGraph g2=new Torus_GridGraph(5,5);
     
      LGraph l1=new LGraph(g2,2);

      SimpleBarChart1 s2=new SimpleBarChart1(l);
      s1.print();
        GrilleEdit G1=new GrilleEdit(l,5,5,25);
       
        FenetreGrid fen1=new FenetreGrid(G1);
        fen1.setVisible(true);
}
}
