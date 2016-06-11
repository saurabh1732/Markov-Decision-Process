package part3_editeurdereseau;
public class Torus_GridGraph {
/**
* variable for storing total number of nodes
*/
int N;
/**
* variable for storing height of grid
*/
int h;
/**
* width of grid
*/
int w;
/**
* adjacency matrix of torus grid
*/
int[][] E;
/**
* creates a torus grid graph given height and width of grid
*/
Torus_GridGraph(int h1,int w1)

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
for(int i=0;i<w;i++)
{
E[i][w*h-w+i]=E[w*h-w+i][i]=1;
}

for(int i=0;i<h;i++)
{
E[i*w][i*w+w-1]=E[i*w+w-1][i*w]=1;
}
}
/**
* copy constructor
*/
Torus_GridGraph(Torus_GridGraph graph){
this.N=graph.N;
w=graph.w;
h=graph.h;
for(int i=0;i<N;i++){
for(int j=0;j<N;j++){
this.E[i][j]=graph.E[i][j];
}
}
}
}