/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
package part3_editeurdereseau;
/**
 *
 * @author bhuvan
 */
class GridGraph
{
  int N;
  int h;
  int w;
  int[][] E;
  
  GridGraph(int w1,int h1)
  
  {
      
     this.h=h1;
     this.w=w1;
     N=w*h;
     E=new int[h*w][w*h];
     for(int i=0;i<h*w;i++)
     {
         for (int j=0;j<h*w;j++)
         {
            E[i][j]=0;
            
        }
    }
     for(int i=0;i<h;i++)
     {
         for(int j=0;j<w-1;j++)
         {
          E[j+i*w][j+1+i*w]=1;
          E[1+j+i*w][j+i*w]=1;
        }
    }
     
     for(int i=0;i<w;i++)
     {
         for(int j=0;j<h-1;j++)
         {
             E[i+j*w][i+(j+1)*w]=1;
             E[i+(j+1)*w][i+j*w]=1;
             
            }
            
        }
        
        
    }
    GridGraph(GridGraph g)
    {
        h=g.h;
        w=g.w;
        for(int i=0;i<h*w;i++)
     {
         for (int j=0;j<h*w;j++)
         {
            E[i][j]=g.E[i][j];
            
        }
    }
}
}

