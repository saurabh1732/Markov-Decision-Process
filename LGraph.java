/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
package part3_editeurdereseau;
/**
 *
 * @author bhuvan
 */
import java.util.*;
public class LGraph extends BaseGraph{


    /**
    *number of colors
    */
    public  int p;

    /**
     *coloring function
     * C[i] belongs to [0,p-1]
    */
    public  int[] C;
   LGraph(int N1,int[][] adjacencymatrix ,int p1,int[] c){
    super(N1,adjacencymatrix);
    p=p1;
    C=new int[N1];
    System.arraycopy(c, 0, C, 0, N1);
    
    }
    /**
     * constructs a lgraph from a basegraph by randomly generating a coloring function
     */
     public  LGraph (BaseGraph basegraph,int p1)
   {  
       super(basegraph.N,basegraph.E);
       p=p1;
       C=new int[basegraph.N];
       for ( int i=1;i<basegraph.N;i++)
       {
           Random random=new Random();
           C[i]=random.nextInt(p);
       }
   }
      /**
     * constructs a lgraph from a gridgraph by randomly generating a coloring function
     */
   public LGraph(GridGraph g,int p1)
   {
       super(g.N,g.E);
       
           p=p1;
           C=new int[g.N];
           for ( int i=1;i<g.N;i++)
       {
           Random random=new Random();
           C[i]=random.nextInt(p);
       }
   }   /**
     * constructs a lgraph from a torus gridgraph by randomly generating a coloring function
     */
    public LGraph(Torus_GridGraph g,int p1)
   {
       super(g.N,g.E);
       
           p=p1;
           C=new int[g.N];
           for ( int i=1;i<g.N;i++)
       {
           Random random=new Random();
           C[i]=random.nextInt(p);
       }
   }
      /**
     * constructs a lgraph from acirculargraph by randomly generating a coloring function
     */
    public LGraph(CircularGraph g,int p1)
   {
       super(g.N,g.E);
       
           p=p1;
           C=new int[g.N];
           for ( int i=1;i<g.N;i++)
       {
           Random random=new Random();
           C[i]=random.nextInt(p);
       }
   }
      /**
     * copy constructor
     */
  public LGraph(LGraph graph)
{

super(graph.N,graph.E);
 C=new int[graph.N];

System.arraycopy(graph.C, 0, C, 0, p);
for(int i=0;i<N;i++)
{
  C[i]=graph.C[i];
}

}


    /**
     *Prints the adjency matrix
     * and the coloring function
    */
    public void print(){
System.out.println("this is the coloring function");
for(int i=0;i<N;i++)
{
    System.out.println(C[i]);
}
System.out.println("this is the adjacency matrix");
for (int i=0;i<N;i++)
{
    System.out.println();
    for(int j=0;j<N;j++){
        System.out.print(E[i][j]);
    }

}
System.out.println();

    }
}

