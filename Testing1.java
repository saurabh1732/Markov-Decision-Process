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
class Testing1
{
   public static void main(String args[])
   
   {
       
     FileIO  FileIO1=new FileIO();
    	
     CircularGraph g1=new CircularGraph(20);
     
      LGraph l=new LGraph(g1,2);
      
      ustat ustatone=new ustat(1,l);
      ustatone.print();
      ustat ustatzero=new ustat(0,l);
      ustatzero.print();
     
      SimpleBarChart1 s1=new SimpleBarChart1(l);
      s1.print();
       SimpleBarChart s=new SimpleBarChart(l);
      s.print();
        GrilleEdit G=new GrilleEdit(l,20);
       
        FenetreGrid fen=new FenetreGrid(G);
        fen.setVisible(true);
        
}
   
   

}
