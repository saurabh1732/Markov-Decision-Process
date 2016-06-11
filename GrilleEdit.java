/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package part3_editeurdereseau;

/**package part3_editeurdereseau;
 *
 * @author bhuvan
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Component.*;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.lang.*;
import java.text.*;
import java.math.BigDecimal;




class Square{

    /**
 * type is "node" or "empty"
 */
    String type;

     /**
     * color of the drawing. In general, color of the node
     */
    int color;



    /**
    * random constructor
     * creates a Square of type "node" with color random in 1,2
    */
    Square(){
        this.type="node";
        this.color=(int)(Math.random()*3);
    }





    /**
    * copy constructor
    */
    Square(Square S){
        this.type=S.type;
        this.color=S.color;
    }

    /**
     * constructor with node type and color as parameter
     */
   Square(String S,int i)
   {
       type=S;
       color=i;
    }


}


/**
 * a Coord is a couple of 2Dimentional coordinate
    */
class Coord{
    int x,y;
    /**
     *constructor with parameter as given x,y coordinates
     */
    Coord(int u,int v){
        x=u;
        y=v;
    }

    Coord(int[] u){
        int l=u.length;
        if(l!=2){
            System.out.println("Problem construction coordinate");
        }
        else{
            x=u[0];
            y=u[1];
        }

    }


    /**
    * copy constructor
    */
    Coord(Coord c){
        this.x=c.x;
        this.y=c.y;
    }
}




/**
 * A GrilleEdit is supposed to be edited on the editor. It is a grid of squares.
 * Each square have their own edit function.
 * Squares can be linked with edges
 * @author mathieutracol
 */
public class GrilleEdit {
    
    
    /**
     * width of the grid
     */
    int w;
    
    /**
     * heigth of the grid
     */
    int h;





    /**
     * the square components of the grid
     */
    Square[][] squares;


    /**
     * the list of the edges between the square components
     * edges[0]
     */
    int[][] edges;
   
    /**
     * INDICATES whether its a gridgraph(0),generalgraph(1)or circular graph(2)or a torus graph(3)
     */
     int indicator;
    /**
     * random generation constructor
     * build a random grid with n*m nodes
    */
     GrilleEdit(int h,int w){
        this.w=w;
        this.h=h;

        this.squares=new Square[h][w];

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                this.squares[i][j]=new Square();
            } 
        }

    }





    /**
     * copy constructor
     * reste edges à faire
    */
    GrilleEdit(GrilleEdit G){
        this.w=G.w;
        this.h=G.h;
        int l=G.squares.length;
        int m=G.squares[0].length;

        this.squares=new Square[h][w];
        
        for(int i=0;i<l;i++){
            for(int j=0;j<m;j++){
                
                this.squares[i][j]=new Square(G.squares[i][j]);
                
            }
        }
       edges=new int [h][w];
         for(int i=0;i<l;i++){
            for(int j=0;j<m;j++){
                
                this.edges[i][j]=G.edges[i][j];
                
            }
        }
        indicator=G.indicator;
    }



   



    /**
     * constructor of a grid from a general LGRAPH
    */
    
     GrilleEdit(LGraph L)
     {
         indicator=1;
       this.w=L.N;
       this.h=L.N;
       squares=new Square[w][h];
      
           for (int k=0;k<w;k++)
           {
              
              
              Random random=new Random();
              int j=random.nextInt(w);
               squares[k][j]=new Square("node",L.C[k]);
            }   
               edges=new int[w][w];
               for(int i=0;i<w;i++)
               {
                   for(int j=0;j<w;j++)
                   {
                       edges[i][j]=L.E[i][j];
                
                    }
                }    
                
          
       
        
        for(int q=0;q<w;q++)
        {
           for(int m=0;m<w;m++) 
           {
               if(squares[q][m]==null)
               {
                   squares[q][m]=new Square("empty",2);
                   
                   
                }
                
            }
            
            
        }
        
    }
       
          /**
           * constructor for GridGraph
           */
       GrilleEdit(LGraph L,int w1,int h1)
           {
              indicator=0;
              w=w1;
              h=h1;
              squares=new Square[h][w];
              for(int i=0;i<h;i++)
              {
                  for(int j=0;j<w;j++)
                  {
                      squares[i][j]=new Square("node",L.C[w*i+j]);
                    }
                }
                edges=new int[w*h][w*h];
                 for(int i=0;i<h*w;i++)
                 {
                  for(int j=0;j<h*w;j++)
                  {
                      edges[i][j]=L.E[i][j];
                   }
                 }
        }
        /**
         * Constructor for Torus_GridGraph
         */
        GrilleEdit(LGraph L,int w1,int h1,int  N)
           {
              indicator=3;
              w=w1;
              h=h1;
              squares=new Square[h][w];
              for(int i=0;i<h;i++)
              {
                  for(int j=0;j<w;j++)
                  {
                      squares[i][j]=new Square("node",L.C[w*i+j]);
                    }
                }
                edges=new int[w*h][w*h];
                 for(int i=0;i<h*w;i++)
              {
                  for(int j=0;j<h*w;j++)
                  {edges[i][j]=L.E[i][j];
                    }
            }
        }
        
        /**
         * constructor for circular graph
         */
     GrilleEdit(LGraph L,int N)
     {
         indicator=2;
         w=N;h=N;
         squares=new Square[N][1];
         for(int i=0;i<N;i++)
         {
             squares[i][0]=new Square("node",L.C[i]);
             
            }
            edges=new int[N][N];
             for(int i=0;i<N;i++)
              {
                  for(int j=0;j<N;j++)
                  {edges[i][j]=L.E[i][j];
                    }
            }
             
     
    }
            
    void affiche(){
        FenetreGrid fen=new FenetreGrid(this);
        
        fen.setVisible(true);
    }


    public static void main (String args[]){
        CircularGraph g=new CircularGraph(100);
        LGraph l=new LGraph(g,2);
        
      GrilleEdit G=new GrilleEdit(l,100);
       
        FenetreGrid fen=new FenetreGrid(G);
        fen.setVisible(true);
        Torus_GridGraph g1=new Torus_GridGraph(20,10);
        LGraph l1=new LGraph(g1,2);
        GrilleEdit G2=new GrilleEdit(l1,20,10,625);
       
        FenetreGrid fen1=new FenetreGrid(G2);
        fen1.setVisible(true);
        

    }



}



    class FenetreGrid extends JFrame{
        private JPanel pan;


        FenetreGrid(GrilleEdit G){
            setTitle("Grid of components");


            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setSize(1000,1000);
            pan=new Panneau(G,600,600);

            getContentPane().add(pan);
            }
        }




    class Panneau extends JPanel{
        GrilleEdit G;
        int larg;
        int haut;

        public Panneau(GrilleEdit G,int larg,int haut){
            System.out.println("trest");
            this.G=new GrilleEdit(G);
            System.out.println("trest2");
            this.larg=larg;
            this.haut=haut;
        }


        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int graphH=haut;
            int nh=graphH/G.w;
            int graphW=larg;
            int nw=graphW/G.h;
            
            
            if(G.indicator==3)
            {
                 Coord cLoc;
            Coord[][]carray=new Coord[G.h][G.w];

           
            for(int i=0;i<G.h;i++){
                for(int j=0;j<G.w;j++){
                                                          
                    cLoc=new Coord((j*graphW/G.w)+200,(i*graphH/G.h)+50);
                    carray[i][j]=new Coord(cLoc);
                    
                    if(G.squares[i][j].type.equals("node")){

                        int color=G.squares[i][j].color%3;
                        if(color==0){g.setColor(Color.red);g.fillRect(cLoc.x,cLoc.y,10,10);}
                        if(color==1){g.setColor(Color.blue);g. fillRect(cLoc.x,cLoc.y,10,10);}                                                                                               
                        //g.drawRect(10,10,11,11);
                    }
                }
            }
          
       
            for(int i=0;i<G.h;i++)
            {
                g.setColor(Color.black);
                g.drawLine(5+carray[i][0].x,5+carray[i][0].y,5+carray[i][G.w-1].x,5+carray[i][G.w-1].y);
            }
       
            for(int j=0;j<G.w;j++)
            {
           
             g.setColor(Color.black);
              g.drawLine(5+carray[0][j].x,5+carray[0][j].y,5+carray[G.h-1][j].x,5+carray[G.h-1][j].y);
            }
             g.drawLine(5+carray[0][0].x,5+carray[0][0].y,5+carray[0][0].x,carray[0][0].y-15);
             g.drawLine(5+carray[0][G.w-1].x,5+carray[0][G.w-1].y,5+carray[0][G.w-1].x,carray[0][G.w-1].y-15);
             g.drawLine(5+carray[0][0].x,carray[0][0].y-15,5+carray[0][G.w-1].x,carray[0][G.w-1].y-15);
             g.drawLine(5+carray[G.h-1][0].x,5+carray[G.h-1][0].y,5+carray[G.h-1][0].x,carray[G.h-1][0].y+15);
             g.drawLine(5+carray[G.h-1][G.w-1].x,5+carray[G.h-1][G.w-1].y,5+carray[G.h-1][G.w-1].x,carray[G.h-1][G.w-1].y+15);
             g.drawLine(5+carray[G.h-1][0].x,carray[G.h-1][0].y+15,5+carray[G.h-1][G.w-1].x,carray[G.h-1][G.w-1].y+15); 
            } 
            
            
                
            if(G.indicator==2)
            {
                Point center = new Point( 300, 300 ) ;
                int num = G.w ; // play with this number
		        int radius = 200 ;
		        setSize( 600, 600) ;
		       setLocation( 100, 100 ) ;
		        g.setColor( Color.black ) ;
		
		        
		        g.drawOval( center.x - radius, center.y - radius, 2 * radius, 2 * radius ) ;
		        for(int i=0;i<G.w;i++)
		        {
		            Point nodeCenter = new Point( center.x + (int) ( ( 3 + radius ) * Math.cos( 2 * Math.PI * i / num ) ),
									 	  center.y - (int) ( ( 3 + radius ) * Math.sin( 2 * Math.PI * i / num ) ) ) ;
			if(G.squares[i][0].color==0)	{ g.setColor( Color.red); }					 	  
			if(G.squares[i][0].color==1){g.setColor( Color.blue)  ;}
			g.fillOval( nodeCenter.x - 3, nodeCenter.y - 3, 2 * 3, 2 * 3 ) ;
		
            }
        }
            
            
        if(G.indicator==0)
            {
                 Coord cLoc;
            Coord[][]carray=new Coord[G.h][G.w];

           
            for(int i=0;i<G.h;i++){
                for(int j=0;j<G.w;j++){
                   
                    
                    

                    cLoc=new Coord(200+j*graphW/G.w,50+i*graphH/G.h);
                    carray[i][j]=new Coord(cLoc);
                    
                    if(G.squares[i][j].type.equals("node")){

                        int color=G.squares[i][j].color%3;
                        if(color==0){g.setColor(Color.red);g.fillRect(cLoc.x,cLoc.y,10,10);}
                        if(color==1){g.setColor(Color.blue);g. fillRect(cLoc.x,cLoc.y,10,10);}
                       
                        
                        
                        
                        //g.drawRect(10,10,11,11);
                    }
                }
            }
          
       
            for(int i=0;i<G.h;i++)
            {
             g.setColor(Color.black);
              g.drawLine(5+carray[i][0].x,5+carray[i][0].y,5+carray[i][G.w-1].x,5+carray[i][G.w-1].y);
            }
       
         for(int j=0;j<G.w;j++)
            {
           
             g.setColor(Color.black);
              g.drawLine(5+carray[0][j].x,5+carray[0][j].y,5+carray[G.h-1][j].x,5+carray[G.h-1][j].y);
            }
       
            }
            
if(G.indicator==1)
{
            Coord cLoc;
            Coord[][]carray=new Coord[G.h][G.w];

           
            for(int i=0;i<G.h;i++){
                for(int j=0;j<G.w;j++){
                   
                    

                    

                    cLoc=new Coord(j*graphW/G.w,i*graphH/G.h);
                    carray[i][j]=new Coord(cLoc);
                    
                    if(G.squares[i][j].type.equals("node")){

                        int color=G.squares[i][j].color%3;
                        if(color==0){g.setColor(Color.red);g.fillRect(cLoc.x,cLoc.y,3,3);}
                        if(color==1){g.setColor(Color.blue);g. fillRect(cLoc.x,cLoc.y,3,3);}
                       
                        
                        
                        
                        //g.drawRect(10,10,11,11);
                    }
                }
            }
                int index1=0,index2=0;
                for(int i0=0;i0<G.w;i0++)
                {
                for(int j=0;j<G.w;j++)
                {
                    if(G.edges[i0][j]==1)
                    {
                        for(int i1=0;i1<G.w;i1++)
                        {
                           if(G.squares[i0][i1].type.equals("node"))
                           {
                               index1=i1;
                               break;
                            }
                        }
                        for(int i1=0;i1<G.w;i1++)
                        {
                           if(G.squares[j][i1].type.equals("node"))
                           {
                               index2=i1;
                               break;
                            }
                        }
                        g.setColor(Color.black);
                        g.drawLine(carray[i0][index1].x+1,carray[i0][index1].y+1,carray[j][index2].x+1,carray[j][index2].y+1);
                    }
                        
                    }
                }
                           
            }

        }
    }

