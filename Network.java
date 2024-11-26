package Networks;
import java.util.ArrayList;
import java.util.Scanner;

public class Network {
	static void addNode(ArrayList<Node> Nlist, int i, int j) {
		System.out.println("Hello Node!");
		Nlist.add(new Node(i,j));
	}
	
	static void moveNode(ArrayList<Node> Nlist, int i, int j, int idx) {
		System.out.println("Node moved");
		Nlist.get(0).x=i;
		Nlist.get(0).y=j;
	}
	
	static void deleteNode(ArrayList<Node> Nlist, int idx) {
		Nlist.remove(0);
		Nlist.add(0,null);
		System.out.println("Node removed");
	}
		
	static void printn(ArrayList<Node> Nlist) {
		String nodes;
		int N=Nlist.size();
		for(int a=0; a<N; a++)
		{
			System.out.println(Nlist.get(a).string());
		}
	}
	
	static void init(ArrayList<Node> Nlist, Node[] Elist, Node[] plist) {
		System.out.println("Run!!!");
		boolean run = true;
		Scanner ScObj = new Scanner(System.in);
		while (run) {
			System.out.println("Running");
			String cmd = ScObj.nextLine();
			if (cmd.equals("end")) {
				run = false;
			}
			if (cmd.equals("node")) {
				addNode(Nlist, 0, 0);
			}
			if (cmd.equals("printn")) {
				printn(Nlist);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Node> Nlist = new ArrayList<>();
		Node[] Elist = {};
		Node[] plist = {};
		
		int N=0;
		int E=0;
		int p=0;
		
		System.out.println("Hello World!");
		init(Nlist, Elist, plist);
		//moveNode(Nlist, 1, 4, 0);
		//deleteNode(Nlist, 0);
		System.out.println("End!");
	}

}
