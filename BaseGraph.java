/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

package part3_editeurdereseau;
import java.util.*; 
public class BaseGraph {


    /**
     *number of nodes
    */
    public   int N;


    /**
     *adjency matrix of the graph
     * E[i][j] belongs to {0,1}
    */
    public   int[][] E;
    public BaseGraph(BaseGraph graph)
{
System.out.println(graph.N);

N=graph.N;
E=new int[N][N];
System.arraycopy(graph.E, 0, E, 0, N);
    }

     BaseGraph(int N1)
     {
         N=N1;
         int[][] E2=new int[N1][N1];
         E=new int[N1][N1];
         for (int i=0;i<N1;i++)
         {
             for (int j=0;j<N1;j++)
             {
                 E2[i][j]=0;
                 
                }
            }
            for (int i=0;i<N1;i++)
         {
             for (int j=0;j<N1;j++)
             {
                 if(i==j){
                     E[i][j]=0;
                     E2[i][j]=1;
                    }
                 if(E2[i][j]==0)
                 {
                    Random random=new Random();
                     E[i][j]=random.nextInt(2);
                     E[j][i]=E[i][j];
                     E2[i][j]=1;
                     E2[j][i]=1;
                     
                 
                }
            }
        }
    }

     BaseGraph(int N1,int[][] adjacencymatrix)
    {
        N=N1;
        E=new int[N][N];
          System.arraycopy(adjacencymatrix, 0, E, 0, N);

    }
  
    /**
     *Prints the adjency matrix
    */
    public void print(){
System.out.println("this is the adjacency matrix");
for (int i=0;i<N;i++)
{
    System.out.println();
    for(int j=0;j<N;j++){
        System.out.print(E[i][j]);
    }

}
    }
   


}

