/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
package part3_editeurdereseau;

public class CircularGraph {
int N;
public int [][]E;
CircularGraph(int n){
N=n;
E=new int[N][N];
for(int i=0;i<N;i++)
     {
         for (int j=0;j<N;j++)
         {
            E[i][j]=0;
            
        }
    }
for(int i=0;i<N-1;i++){

E[i][i+1]=1;
E[i+1][i]=1;
}
E[0][N-1]=1;
E[N-1][0]=1;


}
CircularGraph(CircularGraph graph){
this.N=graph.N;
for(int i=0;i<N;i++){
for(int j=0;j<N;j++){
this.E[i][j]=graph.E[i][j];
}
}
}
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
