package Networks;
import java.util.ArrayList;
import java.util.Scanner;

public class Network {
	static int N=0; //Number of Nodes
	static int E=0; //Number of Edges
	static int p=0; //Number of particles
	
	static void addNode(ArrayList<Node> Nlist, int i, int j, int id) {
		System.out.println("Hello Node!");
		Nlist.add(new Node(i,j,id));
		N=N+1;
	}
	
	static void addEdge(ArrayList<Edge> Elist, int a, int b, int id) {
		System.out.println("Hello Edge!");
		Elist.add(new Edge(a,b,id));
		E=E+1;
	}
	
	static void addParticle(ArrayList<Particle> plist, int n, int id) {
		System.out.println("Hello Particle!");
		plist.add(new Particle(n,id));
		p=p+1;
	}
	
	static void moveNode(ArrayList<Node> Nlist, int i, int j, int idx) {
		System.out.println("Node moved");
		Nlist.get(idx).x=i;
		Nlist.get(idx).y=j;
	}

	static void moveEdge(ArrayList<Edge> Elist, int i, int j, int idx) {
		System.out.println("Edge moved");
		Elist.get(idx).i=i;
		Elist.get(idx).j=j;
	}
	
	static void moveParticle(ArrayList<Particle> plist, int i, int idx) {
		System.out.println("Particle moved");
		plist.get(idx).i=i;
	}
	
	static void deleteNode(ArrayList<Node> Nlist, int idx) {
		Nlist.remove(idx);
		Nlist.add(idx,null);
		System.out.println("Node removed");
	}

	static void deleteEdge(ArrayList<Edge> Elist, int idx) {
		Elist.remove(idx);
		Elist.add(idx,null);
		System.out.println("Edge removed");
	}

	static void deleteParticle(ArrayList<Particle> plist, int idx) {
		plist.remove(idx);
		plist.add(idx,null);
		System.out.println("Particle removed");
	}
	
	static void printn(ArrayList<Node> Nlist) {
		String nodes;
		int N=Nlist.size();
		for(int a=0; a<N; a++)
		{
			if(Nlist.get(a)==null) {
				System.out.println("Null");
			}
			else {
				System.out.println(Nlist.get(a).string());
			}
		}
	}
	
	static void printe(ArrayList<Edge> Elist) {
		String edges;
		int E=Elist.size();
		for(int a=0; a<E; a++)
		{
			if(Elist.get(a)==null) {
				System.out.println("Null");
			}
			else {
				System.out.println(Elist.get(a).string());
			}
		}
	}
	
	static void printp(ArrayList<Particle> plist) {
		String particles;
		int p=plist.size();
		for(int a=0; a<p; a++)
		{
			if(plist.get(a)==null) {
				System.out.println("Null");
			}
			else {
				System.out.println(plist.get(a).string());
			}
		}
	}
	
	static void init(ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		System.out.println("Run!!!");
		boolean run = true;
		Scanner ScObj = new Scanner(System.in);
		while (run == true) {
			String cmd = ScObj.nextLine();
			String subcmd = null;			
			if (cmd.equals("end")) {
				run = false;
			}
			if (cmd.equals("node")) {
				System.out.println("x: ");
				int x = Integer.parseInt(ScObj.nextLine());
				System.out.println("y: ");
				int y = Integer.parseInt(ScObj.nextLine());
				addNode(Nlist, x, y, N);
			}
			if (cmd.equals("edge")) {
				System.out.println("Lower node: ");
				int i = Integer.parseInt(ScObj.nextLine());
				System.out.println("Upper node: ");
				int j = Integer.parseInt(ScObj.nextLine());
				addEdge(Elist, i, j, E);
			}
			if (cmd.equals("particle")) {
				System.out.println("Node: ");
				int i = Integer.parseInt(ScObj.nextLine());
				addParticle(plist, i, p);
			}
			if (cmd.equals("moven")) {
				System.out.println("Node: ");
				int id = Integer.parseInt(ScObj.nextLine());
				System.out.println("New x: ");
				int x = Integer.parseInt(ScObj.nextLine());
				System.out.println("New y: ");
				int y = Integer.parseInt(ScObj.nextLine());
				moveNode(Nlist, x, y, id);
			}
			if (cmd.equals("movee")) {
				System.out.println("Edge: ");
				int id = Integer.parseInt(ScObj.nextLine());
				System.out.println("New lower node: ");
				int i = Integer.parseInt(ScObj.nextLine());
				System.out.println("New upper node: ");
				int j = Integer.parseInt(ScObj.nextLine());
				moveEdge(Elist, i, j, id);
			}
			if (cmd.equals("movep")) {
				System.out.println("Particle: ");
				int id = Integer.parseInt(ScObj.nextLine());
				System.out.println("New node: ");
				int i = Integer.parseInt(ScObj.nextLine());
				moveParticle(plist, i, id);
			}
			if (cmd.equals("printn")) {
				printn(Nlist);
			}
			if (cmd.equals("printe")) {
				printe(Elist);
			}
			if (cmd.equals("printp")) {
				printp(plist);
			}
			if (cmd.equals("printN")) {
				printn(Nlist);
				printe(Elist);
				printp(plist);
			}
			if (cmd.equals("deleten")) {
				System.out.println("Node: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				deleteNode(Nlist, idx);
			}
			if (cmd.equals("deletee")) {
				System.out.println("Edge: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				deleteEdge(Elist, idx);
			}
			if (cmd.equals("deletep")) {
				System.out.println("Particle: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				deleteParticle(plist, idx);
			}

		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Node> Nlist = new ArrayList<>();
		ArrayList<Edge> Elist = new ArrayList<>();
		ArrayList<Particle> plist = new ArrayList<>();
		
		int N=0;
		int E=0;
		int p=0;
		
		init(Nlist, Elist, plist);
		System.out.println("End!");
	}

}
