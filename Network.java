package Networks;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Network {
	static int N=0; //Number of Nodes
	static int E=0; //Number of Edges
	static int p=0; //Number of particles
	
	static int mod(int a, int b) {
		double c = (double) a / (double) b;
		c = Math.floor(c);
		int d = (int) c * (int) b;
		return a - d;
	}
	
	static boolean exists(String Type, int id, ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		boolean ex = false; //Initially assume that object does not exist
		if (Type.equals("node")) {
			if(id<Nlist.size() && Nlist.get(id)!=null) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (Type.equals("edge")) {
			if(id<Elist.size() && Elist.get(id)!=null) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (Type.equals("particle")) {
			if(id<plist.size() && plist.get(id)!=null) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	static void addNode(ArrayList<Node> Nlist, int i, int j, int id) {
		System.out.println("Hello Node!");
		Nlist.add(new Node(i,j,id));
		N=N+1;
	}
	
	static void addEdge(ArrayList<Edge> Elist, ArrayList<Node> Nlist, int a, int b, int id) {
		System.out.println("Hello Edge!");
		Elist.add(new Edge(a,b,id)); //Add edge to list
		E=E+1;
		
		int[] arr=Nlist.get(a).iel; //Take array of lower nodes internal edge list
		arr = Arrays.copyOf(arr, arr.length+1); //Extend it
		arr[arr.length - 1] = id; //Add this new edge
		Nlist.get(a).iel = arr; //Set internal edge list equal to array
		
		//Do the same for upper node
		int[] arr2=Nlist.get(b).iel; //Take array of upper nodes internal edge list
		arr2 = Arrays.copyOf(arr2, arr2.length+1); //Extend it
		arr2[arr2.length - 1] = id; //Add this new edge
		Nlist.get(b).iel = arr2; //Set internal edge list equal to array
	}
	
	static void addParticle(ArrayList<Particle> plist, ArrayList<Node> Nlist, int n, int id) {
		System.out.println("Hello Particle!");
		plist.add(new Particle(n,id));
		p=p+1;
		
		Nlist.get(n).ipl=id;
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

	static void deleteEdge(ArrayList<Node> Nlist, ArrayList<Edge> Elist, int idx) {
		deleteEle(Nlist.get((Elist.get(idx)).i).iel,idx); //Remove edge from nodes internal list
		deleteEle(Nlist.get((Elist.get(idx)).j).iel,idx);
		Elist.remove(idx);
		Elist.add(idx,null);
		System.out.println("Edge removed");
	}

	static void deleteParticle(ArrayList<Node> Nlist, ArrayList<Particle> plist, int idx) {
		Nlist.get((plist.get(idx)).i).ipl=-1; //Remove particle from nodes internal list
		plist.remove(idx);
		plist.add(idx,null);
		System.out.println("Particle removed");
	}
	
	static void deleteEle(int[] arr, int ele) {
		int[] arr_new = new int[arr.length-1];
        for(int i=0, k=0;i<arr.length;i++){
            if(arr[i]!=ele){
                arr_new[k]=arr[i];
                k++;
            }
        }
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
		String subcmd = null;
		NetObject so = null;
		ArrayList<? extends NetObject> sl = null;
		while (run == true) {
			String cmd = ScObj.nextLine();
			if (cmd.equals("add") | cmd.equals("move") | cmd.equals("print") | cmd.equals("select") | cmd.equals("cd") | cmd.equals("cw") | cmd.equals("delete")) {
				System.out.println("Object: ");
				subcmd = ScObj.nextLine();			
			}
			if (cmd.equals("end")) {
				run = false;
			}
			if (cmd.equals("node") | (cmd.equals("add") && subcmd.equals("node"))) {
				System.out.println("x: ");
				int x = Integer.parseInt(ScObj.nextLine());
				System.out.println("y: ");
				int y = Integer.parseInt(ScObj.nextLine());
				addNode(Nlist, x, y, N);
			}
			if (cmd.equals("edge") | (cmd.equals("add") && subcmd.equals("edge"))) {
				System.out.println("Lower node: ");
				int i = Integer.parseInt(ScObj.nextLine());
				System.out.println("Upper node: ");
				int j = Integer.parseInt(ScObj.nextLine());
				//"SAFE" edges: Edges may not duplicate by connecting the same two nodes
				boolean safe = true; //Initially assume safe
				Node ln = Nlist.get(i); //Lower node
				int ne = ln.iel.length; //Number of edges connected to lower node
				for(int a=0; a<ne; a++) { //For each edge in the internal edge list
					if(Elist.get(ln.iel[a]).echeck(i)==j) //If it connects i and j
					{
						safe = false; //Edge would be a duplicate
					}
				}
				if(safe) {
					addEdge(Elist, Nlist, i, j, E);
				}
				else {
					System.out.println("Cannot duplicate edge");
				}		
			}
			if (cmd.equals("particle") | (cmd.equals("add") && subcmd.equals("particle"))) {
				System.out.println("Node: ");
				int i = Integer.parseInt(ScObj.nextLine());
				//"SAFE" particles: Particles may not duplicate by occupying an occupied node
				boolean safe =! Nlist.get(i).ocheck();
				if(safe) {
					addParticle(plist, Nlist, i, p);
				}
				else {
					System.out.println("Cannot duplicate particle");
				}
			}
			if (cmd.equals("bnode")) {
				System.out.println("Adding nodes on bulk");
				System.out.println("How Many?: ");
				int m = Integer.parseInt(ScObj.nextLine());
				for(int a=0; a<m; a++) {
					System.out.println("x: ");
					int x = Integer.parseInt(ScObj.nextLine());
					System.out.println("y: ");
					int y = Integer.parseInt(ScObj.nextLine());
					addNode(Nlist, x, y, N);				
				}				
			}
			if (cmd.equals("bparticle")) {
				System.out.println("Adding particles on bulk");
				System.out.println("How Many?: ");
				int m = Integer.parseInt(ScObj.nextLine());
				for(int a=0; a<m; a++) {
					System.out.println("Node: ");
					int i = Integer.parseInt(ScObj.nextLine());
					//"SAFE" particles: Particles may not duplicate by occupying an occupied node
					boolean safe =! Nlist.get(i).ocheck();
					if(safe) {
						addParticle(plist, Nlist, i, p);
					}
					else {
						System.out.println("Cannot duplicate particle");
						a--;
					}
				}				
			}
			if (cmd.equals("moven") | (cmd.equals("move") && subcmd.equals("node"))) {
				System.out.println("Node: ");
				int id = Integer.parseInt(ScObj.nextLine());
				if(!exists("node",id,Nlist,Elist,plist)) {
					System.out.println("Node does not exist");
				}
				else {
					System.out.println("New x: ");
					int x = Integer.parseInt(ScObj.nextLine());
					System.out.println("New y: ");
					int y = Integer.parseInt(ScObj.nextLine());
					moveNode(Nlist, x, y, id);
				}
			}
			if (cmd.equals("movee") | (cmd.equals("move") && subcmd.equals("edge"))) {
				System.out.println("Edge: ");
				int id = Integer.parseInt(ScObj.nextLine());
				if(!exists("edge",id,Nlist,Elist,plist)) {
					System.out.println("Edge does not exist");
				}
				else {
					System.out.println("New lower node: ");
					int i = Integer.parseInt(ScObj.nextLine());
					System.out.println("New upper node: ");
					int j = Integer.parseInt(ScObj.nextLine());
					moveEdge(Elist, i, j, id);
				}
			}
			if (cmd.equals("movep") | (cmd.equals("move") && subcmd.equals("particle"))) {
				System.out.println("Particle: ");
				int id = Integer.parseInt(ScObj.nextLine());
				if(!exists("particle",id,Nlist,Elist,plist)) {
					System.out.println("Particle does not exist");
				}
				else {
					System.out.println("New node: ");
					int i = Integer.parseInt(ScObj.nextLine());
					moveParticle(plist, i, id);
				}
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
			if (cmd.equals("print") && subcmd.equals("node")) {
				System.out.println("Node: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				System.out.println(Nlist.get(idx).string());
			}
			if (cmd.equals("print") && subcmd.equals("edge")) {
				System.out.println("Edge: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				System.out.println(Elist.get(idx).string());
			}
			if (cmd.equals("print") && subcmd.equals("particle")) {
				System.out.println("Particle: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				System.out.println(plist.get(idx).string());
			}
			if (cmd.equals("select") && subcmd.equals("node")) {
				System.out.println("Node: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				so = Nlist.get(idx);
				sl = Nlist;
			}
			if (cmd.equals("select") && subcmd.equals("edge")) {
				System.out.println("Edge: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				so = Elist.get(idx);
				sl = Elist;
			}
			if (cmd.equals("select") && subcmd.equals("particle")) {
				System.out.println("Particle: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				so = plist.get(idx);
				sl = plist;
			}
			if (cmd.equals("next")) {
				so=so.next(sl);
			}
			if (cmd.equals("previous")) {
				so=so.prev(sl);
			}
			if (cmd.equals("details")) {
				so.details(Nlist, Elist, plist);
			}
			if (cmd.equals("cd") && subcmd.equals("node")) {
				System.out.println("Node: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				if(so.getClass().getName()=="Networks.Node" && so.getIdx()==idx) {
					System.out.println("New x: ");
					int i=Integer.parseInt(ScObj.nextLine());
					System.out.println("New y: ");
					int j=Integer.parseInt(ScObj.nextLine());
					Nlist.get(idx).x=i;
					Nlist.get(idx).y=j;
					so.details(Nlist, Elist, plist);
				}			
				else if(so.getClass().getName()=="Networks.Edge" && (so.geti()==idx | so.getj()==idx)) {
					System.out.println("New x: ");
                    int i=Integer.parseInt(ScObj.nextLine());
                    System.out.println("New y: ");
                    int j=Integer.parseInt(ScObj.nextLine());
                    Nlist.get(idx).x=i;
                    Nlist.get(idx).y=j;
                    so.details(Nlist,Elist,plist);  
				}
				else if(so.getClass().getName()=="Networks.Particle" && so.geti()==idx) {
					System.out.println("New x: ");
                    int i=Integer.parseInt(ScObj.nextLine());
                    System.out.println("New y: ");
                    int j=Integer.parseInt(ScObj.nextLine());
                    Nlist.get(idx).x=i;
                    Nlist.get(idx).y=j;
                    so.details(Nlist,Elist,plist);  
				}

			}
			if (cmd.equals("cd") && subcmd.equals("edge")) {
				System.out.println("Edge: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				if (so.getClass().getName()=="Networks.Node") {
					Node sn = (Node) so; //Selected object parsed to a Selected node object 
					int ne = sn.iel.length; //Number of edges 
					for (int a = 0; a < ne; a++) { //Check nodes connected edges
							if(sn.iel[a]==idx) { //If entered edge is in list
								System.out.println("New Node 1: ");
								int i=Integer.parseInt(ScObj.nextLine());
								System.out.println("New Node 2: ");
	                            int j=Integer.parseInt(ScObj.nextLine());
	                            Elist.get(idx).i=i;
	                            Elist.get(idx).j=j;
	                            so.details(Nlist, Elist, plist); 
							}
						}
				}
				else if(so.getClass().getName()=="Networks.Edge" && so.getIdx()==idx) {
					System.out.println("New Node 1: ");
					int i=Integer.parseInt(ScObj.nextLine());
					System.out.println("New Node 2: ");
					int j=Integer.parseInt(ScObj.nextLine());
					Elist.get(idx).i=i;
					Elist.get(idx).j=j;
					so.details(Nlist, Elist, plist);
				}	
				else if(so.getClass().getName()=="Networks.Particle") {
					Node spn = Nlist.get(so.geti()); //Selected particles node
					int ne = spn.iel.length; //Number of edges
					for (int a = 0; a < ne; a++) { //Check nodes connected edges
						if(spn.iel[a]==idx) { //If entered edge is in list
							System.out.println("New Node 1: ");
							int i=Integer.parseInt(ScObj.nextLine());
							System.out.println("New Node 2: ");
                            int j=Integer.parseInt(ScObj.nextLine());
                            Elist.get(idx).i=i;
                            Elist.get(idx).j=j;
                            so.details(Nlist, Elist, plist); 
						}
					}
				}

			}
			if (cmd.equals("cd") && subcmd.equals("particle")) {
				System.out.println("Particle: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				if (so.getClass().getName()=="Networks.Node" && so.geti()==idx) {
					Node sn = (Node) so; //Selected object parsed to a Selected node object 
					int ne = sn.iel.length; //Number of edges 
					for (int a = 0; a < ne; a++) { //Check nodes connected edges
							if(sn.iel[a]==idx) { //If entered edge is in list
								System.out.println("New Node: ");
								int i=Integer.parseInt(ScObj.nextLine());
	                            plist.get(idx).i=i;
	                            so.details(Nlist, Elist, plist); 
							}
						}
				}
				else if(so.getClass().getName()=="Networks.Edge") {
					Node ln = Nlist.get(so.geti()); //Selected edges lower node
					Node un = Nlist.get(so.getj()); //and upper node
					if(ln.ipl==idx | un.ipl==idx) { //If either is occupied by entered particle
						System.out.println("New Node: ");
						int i=Integer.parseInt(ScObj.nextLine());
						plist.get(idx).i=i; //Update its node
                    	so.details(Nlist,Elist,plist);  
					}
				}
				else if(so.getClass().getName()=="Networks.Particle" && so.getIdx()==idx) {
					System.out.println("New Node:");
					int i=Integer.parseInt(ScObj.nextLine());
					plist.get(idx).i=i;
					so.details(Nlist, Elist, plist);
				}			
			}
			if (cmd.equals("cw") && subcmd.equals("node")) {
				System.out.println("Node: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				System.out.println("Weight: ");
				int w = Integer.parseInt(ScObj.nextLine());
				Nlist.get(idx).weight=w;
			
			}
			if (cmd.equals("cw") && subcmd.equals("edge")) {
				System.out.println("Edge: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				System.out.println("Weight: ");
				int w = Integer.parseInt(ScObj.nextLine());
				Elist.get(idx).weight=w;		
			}
			if (cmd.equals("cw") && subcmd.equals("particle")) {
				System.out.println("Particle: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				System.out.println("Weight: ");
				int w = Integer.parseInt(ScObj.nextLine());
				plist.get(idx).weight=w;		
			}

			if (cmd.equals("deleten") | (cmd.equals("delete") && subcmd.equals("node"))) {
				System.out.println("Node: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				deleteNode(Nlist, idx);
			}
			if (cmd.equals("deletee") | (cmd.equals("delete") && subcmd.equals("edge"))) {
				System.out.println("Edge: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				deleteEdge(Nlist, Elist, idx);
			}
			if (cmd.equals("deletep") | (cmd.equals("delete") && subcmd.equals("particle"))) {
				System.out.println("Particle: ");
				int idx = Integer.parseInt(ScObj.nextLine());
				deleteParticle(Nlist, plist, idx);
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
