/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package part3_editeurdereseau;

/**
 *The class of ustat vectors of graphs
 */
public class ustat {

    /**
    *the order of the statistics
    */
    public int k;


    /**
    *the number of different components
     * i.e. the number of different k-neigborhoods which appear in
     * the ustat vector
    */
    public int m;

    /**
    *the maximal number of components which may appear in the ustat vector
    */
    public static int nbMaxComp=1000;


    /**
    *contains the neigborhoods which have appeared so far
     * Neighb[i] is null for i>=m
    */
    public Graph[] Neighb=new Graph[nbMaxComp];


    /**
    *counts the number of different neigborhoods
     * val[i]=0 for i>=m
    */
    public  int[] val=new int[nbMaxComp];



    /**
    *Constructor for the ustat_k vector of a given labeled graph
    */
    public ustat(int k,LGraph G){
    nbMaxComp=1000;

    m=0;
    if(k==0)
    {
      for(int i=0;i<G.N;i++)
      {
        int [][] E1=new int [G.N][G.N];
        for(int k1=0;k1<G.N;k1++)
            {
                for(int r=0;r<G.N;r++)
                {
                    E1[k1][r]=0;
                }
        }
        Graph potentialustat0=new Graph(G.N,E1,G.p,G.C,i);
         for(int z=0;z<1000;z++)
         {
            if  ( Neighb[z]==null)
            {Neighb[z]=potentialustat0;
            val[z]=1;
            m++;
             break;
            
             
            }
            if(Neighb[z].isomorphism(potentialustat0,0))
            {
                val[z]=val[z]+1;
                break;

            }
           
          }
      }           
 }
 
if(k==1){
    
    for(int i=0;i<G.N;i++)
    {
    int d=0;
    
       for(int j=0;j<G.N;j++)
        {
            if(G.E[i][j]==1)
            {
                d=1;
                break;
            }
        }
        if(d==0)
        {
            break;
        }
          
        
        int [][] E1=new int [G.N][G.N];
        for(int k1=0;k1<G.N;k1++)
        {
            for(int r=0;r<G.N;r++)

            {
             E1[k1][r]=0;
            }

        }
        for(int k2=0;k2<G.N;k2++)
        {
            E1[i][k2]=G.E[i][k2];

        }
        for(int k2=0;k2<G.N;k2++)
        {
          E1[k2][i]=G.E[k2][i];  
        }
        Graph potentialustat1=new Graph(G.N,E1,G.p,G.C,i);
        for(int z=0;z<1000;z++)
        {
            if  ( Neighb[z]==null)
            {Neighb[z]=potentialustat1;
            val[z]=1;
            m++;
             break;
            
             
            }
            if(Neighb[z].isomorphism(potentialustat1,1))
            {
                val[z]=val[z]+1;
                break;

            }
           
            }
        }
    }

             this.k=k;



            }

                      
    /**
    *outputs the value associated to the component which corresponds to neigborhood H
     * if H is not a k neigborhood, or if H does not appear in Neighb,
     * then outputs 0
    */
    public int component(Graph H){

        if (!(H.isNeigb(1)))  return 0;
        for(int i=0;i<m;i++)
        {  if(Neighb[i]==null) return 0;
           if(Neighb[i].isomorphism(H,1)) return val[i];
        }
        return 0;
    }
    public void print()
    {
        System.out.println("this is the ustat "+k+" vector");
        for(int i=0;i<m;i++)
        {
        System.out.println(val[i]);
            }
        }

    }

