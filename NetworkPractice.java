package Networks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import java.awt.*;
import javax.swing.*;  
import java.awt.geom.*; 

public class NetworkPractice extends JPanel{
	static int N=0; //Number of Nodes
	static int E=0; //Number of Edges
	static int p=0; //Number of particles
	
	ArrayList<Node> Nlist;
	ArrayList<Edge> Elist;
	ArrayList<Particle> plist;
	
	ArrayList<Node> nodes;
	ArrayList<Edge> edges;
	ArrayList<Particle> particles;
	
	public NetworkPractice(ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		nodes = Nlist;
		//addNodeR(nodes,2,5,0);
		//addNodeR(nodes,5,2,1);
		//addNodeR(nodes,4,6,2);
	}
	
	static void addNodeR(ArrayList<Node> Nlist, int i, int j, int id) { //Add node decorator to update node count
			Network.addNode(Nlist, i, j, id);
			N=N+1;
	}
	
	static void addEdgeR(ArrayList<Edge> Elist, ArrayList<Node> Nlist, int a, int b, int id) { //Add edge decorator to update edge count
		Network.addEdge(Elist, Nlist, a, b, id);
		E=E+1;
	}
	
	static void addParticleR(ArrayList<Particle> plist, ArrayList<Node> Nlist, int n, int id) { //Add particle decorator to update particle count
		Network.addParticle(plist, Nlist, n, id);
		p=p+1;
	}
	
	static ArrayList<Node> init(ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		System.out.println("Run!!!");
		boolean run = true;
		Scanner ScObj = new Scanner(System.in);
		NetObject so = null;
		ArrayList<? extends NetObject> sl = null;
		
		System.out.println("How many nodes?: ");
		int m = Integer.parseInt(ScObj.nextLine());
		
		System.out.println("How many edges?: ");
		int l = Integer.parseInt(ScObj.nextLine());
		
		System.out.println("How many particles?: ");
		int k = Integer.parseInt(ScObj.nextLine());
		
		for(int a=0; a<m; a++)
		{
			int i = (int)(Math.random()*101);
			int j = (int)(Math.random()*101);
			System.out.println(N);
			addNodeR(Nlist, i, j, N);
			System.out.println(N);
			System.out.println(a);
			System.out.println(i);
			System.out.println(j);
			System.out.println(Nlist.get(a).x);			
			System.out.println(Nlist.get(a).y);
		}
		for(int a=0; a<l; a++)
		{
			int i = (int)(Math.random()*m);
			int j = (int)(Math.random()*m);
			addEdgeR(Elist, Nlist, i, j, E);
		}
		for(int a=0; a<k; a++)
		{
			int i = (int)(Math.random()*m);
			addParticleR(plist, Nlist, i, p);
		}
		Network.printp(plist);
		for(int a=0; a<p; a++) //Perform p hops, where p is the number of particles
		{
			int i = (int)(Math.random()*p);	//Random particle
			System.out.println("Hop: ");
			System.out.println(plist.get(i).i);
			int n = (int)(Math.random()*N); //Random node
			System.out.println(n);
			Network.moveParticle(plist,n,i); //Perform hop
		}
		Network.printp(plist);
	
		System.out.println(Nlist.get(0).i);
		System.out.println(Nlist.get(0).j);
		System.out.println(Nlist.get(1).i);
		System.out.println(Nlist.get(1).j);
		System.out.println(Nlist.get(2).i);
		System.out.println(Nlist.get(2).j);
		return Nlist;
	}

	protected void paintComponent(Graphics grf){ 
		super.paintComponent(grf);
		Graphics2D graph = (Graphics2D)grf;
		
		for (int a=0; a<N; a++) {
			int i = 2*nodes.get(a).x;
			int j = 2*nodes.get(a).y;
			Ellipse2D ed = new Ellipse2D.Double(i, 350-j, 7, 7);
			graph.setColor(Color.red);
			graph.fill(ed);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Node> Nlist = new ArrayList<>();
		ArrayList<Edge> Elist = new ArrayList<>();
		ArrayList<Particle> plist = new ArrayList<>();
		
		Nlist =	init(Nlist, Elist, plist);
		System.out.println("Returned");
		System.out.println(Nlist.get(0).i);
		System.out.println(Nlist.get(0).j);
		System.out.println(Nlist.get(1).i);
		System.out.println(Nlist.get(1).j);
		System.out.println(Nlist.get(2).i);
		System.out.println(Nlist.get(2).j);
	
		//create an instance of JFrame class  
        JFrame frame = new JFrame();  
        // set size, layout and location for frame.  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.add(new NetworkPractice(Nlist, Elist, plist));  
        frame.setSize(400, 400);  
        frame.setLocation(200, 200);  
        frame.setVisible(true);  
		
		System.out.println("End!");
	}
}
