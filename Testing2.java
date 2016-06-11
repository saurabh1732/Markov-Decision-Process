/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
package part3_editeurdereseau;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Testing2{
   public static void main(String args[]){
       
     FileIO  FileIO1=new FileIO();
    	
      Torus_GridGraph g2=new Torus_GridGraph(15,5);
     
      LGraph l=new LGraph(g2,2);
      ustat ustatone=new ustat(1,l);
      ustatone.print();
      ustat ustatzero=new ustat(0,l);
      ustatzero.print();
                
      SimpleBarChart s1=new SimpleBarChart(l);
      s1.print();
     
      SimpleBarChart1 s2=new SimpleBarChart1(l);
      s2.print();
      GrilleEdit G1=new GrilleEdit(l,15,5,25);
       
      FenetreGrid fen1=new FenetreGrid(G1);
      fen1.setVisible(true);
   }
}
