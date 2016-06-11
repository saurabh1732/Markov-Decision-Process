/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
package part3_editeurdereseau;
/**
 *
 * @author bhuvan
 */
import java.io.*; 


public class FileIO {


    public Graph read(String FileName){
       
        Graph graph;
        graph=null;
        
        try{
        
        
        FileInputStream fstream = new FileInputStream(FileName);
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String[] strline=new String[1000];
    strline[0]=br.readLine();
     int N= Integer.parseInt(strline[0]);
    
    strline[1]=br.readLine();
    int p=  Integer.parseInt(strline[1]);
    
     strline[2]=br.readLine();
    int center=Integer.parseInt(strline[2]);

    strline[3]=br.readLine();
   int[]  C=new int[N];
    for(int k=0;k<N;k++)
    {
        
        C[k]=Integer.parseInt(strline[3].substring(k,k+1));
       
       
        
        
        
    }
    System.out.println();

      int[][]E=new int[N][N];
      
     for(int i=4;i<N+4;i++)
     
    {   
          strline[i]=br.readLine();
          
        for(int j=0;j<N;j++)
        {
           
            E[i-4][j]=Integer.parseInt(strline[i].substring(j,j+1));
            
            
            
        }
        
       
    }
     graph=new Graph(N,E,p,C,center);
     
   
     
  
    
    in.close();
     return graph;
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
    
    
    return graph;
  }
  public void write(Graph G)
  {
     

        
                FileOutputStream out; // declare a file output object
                PrintStream p; // declare a print stream object

                try
                {
                        // Create a new file output stream
                        // connected to "myfile.txt"
                        out = new FileOutputStream("C:\\Users\\saurabh\\Documents\\graph2.txt");

                        // Connect print stream to the output stream
                        p = new PrintStream( out );
		
                        p.println (G.N);
                        p.println(G.p);
                        p.println(G.center);
                        for(int i=0;i<G.N;i++)
                        {
                          p.print(G.C[i]); 
                          
                        }
                        p.println();
                        for(int i=0;i<G.N;i++)
                        {
                            for(int j=0;j<G.N;j++)
                            {
                            p.print(G.E[i][j]);
                        }
                        p.println();
                    }

                        p.close();
                }
                catch (Exception e)
                {
                        System.err.println ("Error writing to file");
                }
        }
        
    public LGraph readCG(String FileName){
       
        LGraph graph;
        graph=null;
        
        try{
        
        
        FileInputStream fstream = new FileInputStream(FileName);
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String[] strline=new String[1000];
    strline[0]=br.readLine();
     int N= Integer.parseInt(strline[0]);
    
    strline[1]=br.readLine();
    int p=  Integer.parseInt(strline[1]);
    
    

    strline[2]=br.readLine();
   int[]  C=new int[N];
    for(int k=0;k<N;k++)
    {
        
        C[k]=Integer.parseInt(strline[2].substring(k,k+1));
       
       
        
        
        
    }
    System.out.println();

      int[][]E=new int[N][N];
      
     for(int i=3;i<N+3;i++)
     
    {   
          strline[i]=br.readLine();
          
        for(int j=0;j<N;j++)
        {
           
            E[i-3][j]=Integer.parseInt(strline[i].substring(j,j+1));
            
            
            
        }
        
       
    }
     graph=new LGraph(N,E,p,C);
     
   
     
  
    
    in.close();
     return graph;
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
    
    
    return graph;
  }
  /**
   * 
   */
  public void writeCG(LGraph G)
  {
     

        
                FileOutputStream out; // declare a file output object
                PrintStream p; // declare a print stream object

                try
                {
                        // Create a new file output stream
                        // connected to "myfile.txt"0
                        out = new FileOutputStream("C:\\Users\\saurabh\\Documents\\basegraph2.txt");

                        // Connect print stream to the output stream
                        p = new PrintStream( out );
		
                        p.println (G.N);
                        p.println(G.p);
                      
                        for(int i=0;i<G.N;i++)
                        {
                          p.print(G.C[i]); 
                          
                        }
                        p.println();
                        for(int i=0;i<G.N;i++)
                        {
                            for(int j=0;j<G.N;j++)
                            {
                            p.print(G.E[i][j]);
                        }
                        p.println();
                    }

                        p.close();
                }
                catch (Exception e)
                {
                        System.err.println ("Error writing to file");
                }
        }
          public BaseGraph readBG(String FileName){
       
        BaseGraph graph;
        graph=null;
        
        try{
        
        
        FileInputStream fstream = new FileInputStream(FileName);
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String[] strline=new String[1000];
    strline[0]=br.readLine();
     int N= Integer.parseInt(strline[0]);
   
    System.out.println();

      int[][]E=new int[N][N];
      
     for(int i=1;i<N+1;i++)
     
    {   
          strline[i]=br.readLine();
          
        for(int j=0;j<N;j++)
        {
           
            E[i-1][j]=Integer.parseInt(strline[i].substring(j,j+1));
            
            
            
        }
        
       
    }
     graph=new BaseGraph(N,E);
     
   
     
  
    
    in.close();
     return graph;
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
    
    
    return graph;
  }
  public void writeBG(BaseGraph G)
  {
     

        
                FileOutputStream out; // declare a file output object
                PrintStream p; // declare a print stream object

                try
                {
                        // Create a new file output stream
                        // connected to "myfile.txt"
                        out = new FileOutputStream("C:\\Users\\saurabh\\Documents\\basegraph2.txt");

                        // Connect print stream to the output stream
                        p = new PrintStream( out );
		
                        p.println (G.N);
                       
                        for(int i=0;i<G.N;i++)
                        {
                            for(int j=0;j<G.N;j++)
                            {
                            p.print(G.E[i][j]);
                        }
                        p.println();
                    }

                        p.close();
                }
                catch (Exception e)
                {
                        System.err.println ("Error writing to file");
                }
        }
}
