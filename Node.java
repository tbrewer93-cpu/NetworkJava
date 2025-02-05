package Networks;

import java.util.ArrayList;

public class Node extends NetObject {
	int x,y;
	int[] iel = {};
	int ipl;
	public int idx, edge_max, weight;
	public Node(int i, int j, int id) {
        //X position, Y Position and Weight
        x=i;
        y=j;
        ipl=-1; //Internal particle list

        ///***DEFAULTS***///
        idx=id; //Node Index
        edge_max=0; //Maximum edges = 0
        weight=-1; //Node's weight
        
        //if(kwargs.__contains__('idx')):
        //    self.idx=kwargs['idx'] #Edge ID
        //if(kwargs.__contains__('conn')):
        //    self.edge_max=kwargs['conn'] #Connectivity
	}
	
	public int getIdx() {
		return idx;
	}
	
	public int geti() {
		return i;
	}
	
	public int getj() {
		return j;
	}
	
	public NetObject next(ArrayList<? extends NetObject> sl) {
		int l=sl.size();
		return sl.get((idx+1)%l);
	}
	
	public NetObject prev(ArrayList<? extends NetObject> sl) {
		int l=sl.size();
		return sl.get(Network.mod(idx-1,l));
	}
	
	public boolean ocheck() {
		//Occupancy check
		boolean occ = false;
		if(ipl==-1) {
			occ = false;
		}
		else {
			occ = true;
		}
		return occ;
	}
	
	public String string() {
		return "Node "+Integer.toString(idx)+" at co-ord "+Integer.toString(x)+","+Integer.toString(y)+" with weight "+Integer.toString(weight);
	}
	
	void details(ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		System.out.println(string());
		int ne=iel.length;
		for(int a=0; a<ne; a++) {
			System.out.println(Elist.get(iel[a]).string());
		}
		if(ocheck()) {
			System.out.println(plist.get(ipl).string());
		}
	}
}
