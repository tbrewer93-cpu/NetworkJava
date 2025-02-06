package Networks;

import java.util.ArrayList;
import java.util.Scanner;


public class NetworkPractice {
	static int N=0; //Number of Nodes
	static int E=0; //Number of Edges
	static int p=0; //Number of particles
	
	static void init(ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		System.out.println("Run!!!");
		boolean run = true;
		Scanner ScObj = new Scanner(System.in);
		NetObject so = null;
		ArrayList<? extends NetObject> sl = null;
		
		Network.addNode(Nlist, 0, 0, N);
		System.out.println(N);
		Network.addNode(Nlist, 10, 10, 2);
		Network.addNode(Nlist, 0, 0, N);
		Network.printn(Nlist);
		Network.printe(Elist);
		Network.printp(plist);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Node> Nlist = new ArrayList<>();
		ArrayList<Edge> Elist = new ArrayList<>();
		ArrayList<Particle> plist = new ArrayList<>();
		
		init(Nlist, Elist, plist);
		System.out.println("End!");
	}
}
