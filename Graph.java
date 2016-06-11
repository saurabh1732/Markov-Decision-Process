/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package part3_editeurdereseau;


public class Graph extends LGraph{

    /**
     *centre is the index of the center of the graph
    */
    public int center;





    
    public Graph(int N1,int[][] adjacencymatrix,int p,int[] c,int centre1){

        super(N1,adjacencymatrix,p,c);
        center=centre1;

    }
    
    /**
     *copy constructor
    */
public Graph(Graph graph)
{
super(graph.N,graph.E,graph.p,graph.C);
center=graph.center;
}

    /**
     *return true is the graphs are isomorphic, considered as
     * labeled and centered graphs,k1 is the parameter of the neighborhood,distance from centre
    */
    public boolean isomorphism(Graph G2,int k1){
        boolean decision=false;
        if(k1==0){
       if((C[center]==G2.C[G2.center])&&(p==G2.p)) {return true;}
       else{
           return false;}}
        if((G2.isNeigb(k1))&&(this.isNeigb(k1))){
        if(k1==1)
        {
            if((C[center]==G2.C[G2.center])&&(p==G2.p))
            {
                 
             int[] count1=new int[p];
             int[] count2=new int[G2.p];
             for(int z=0;z<p;z++)
             {
                 count1[z]=0;
                 count2[z]=0;
                }
            for(int i=0;i<count1.length;i++)
            {
                for (int k=0;k<N;k++)
                {
                for(int j=0;j<p;j++)
                {
                    if((E[center][k]==1 )&&(C[k]==j)){
                        count1[j]=count1[j]+1;
                        break;
                    }
                }
                }
            }
                for(int i=0;i<count2.length;i++)
            {
                for (int k=0;k<G2.N;k++)
                {
                for(int j=0;j<G2.p;j++)
                {
                    if((G2.E[G2.center][k]==1 )&&(G2.C[k]==j)){
                        count2[j]=count2[j]+1;
                        break;
                    }
                }
                }
                }
                for(int i=0;i<p;i++)
                {
                    if (count1[i]!=count2[i]) return false;
                }
                return true;
            }
            return false;
            }
            return false;
            }return false;
    }
    /**
     *return true if the graph is a neigborhood of depth k: that is if all the nodes
     * are at distance at most k from the center
    */
    public boolean isNeigb(int k){
        boolean decision=true;
        if(k==1)
        {
            for(int j=0;j<N;j++)
            {   if (decision==false) break;
                if(E[center][j]==1)
                {

                    for(int r=0;r<N;r++)
                    {  if(decision==false) break;
                      if((  E[j][r]==1)&&(r!=center) )
                      {
                          decision=false;
                          break;
                      }
                    }
                }
            }
        }
        return decision;
    }



    @Override
    /**
     *Prints the adjency matrix,
     *the coloring function,
     * and the center of the graph
    */
    public void print(){
        System.out.println("the centre is " +center);
        super.print();

    }
/**
 * returns the color distribution of the graph i.e. frequency of different colors
 */
    public int[] colordistribution()
    {
        int[] cdistribution=new int[p];
        for(int m=0;m<p;m++)
        {
            cdistribution[m]=0;
          
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<p;j++)
            {
                if ((C[i]==j)&&(E[center][i]==1))
                {
                    cdistribution[j]=cdistribution[j]+1;
                    break;
                }
            }
        }
        return cdistribution;


}
}
