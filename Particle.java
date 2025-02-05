package Networks;

import java.util.ArrayList;

public class Particle extends NetObject{
	int i;
	public int idx, weight;
	public Particle(int n, int id) {
        //Node
        i=n;

        ///***DEFAULTS***///
        idx=id; //Particle Index
        weight=-1; //Particle weight
        
        //if(kwargs.__contains__('idx')):
        //    self.idx=kwargs['idx'] #Edge ID
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
		return sl.get((idx-1)%l);
	}
	
	public String string() {
		return "Particle "+Integer.toString(idx)+" on node "+Integer.toString(i)+" with weight "+Integer.toString(weight);
	}
	
	void details(ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		System.out.println(string()); //Print particle
		
		Node n = Nlist.get(i); //Get corresponding node
		System.out.println(n.string()); //Print node
		
		int ne=(n.iel).length; //Get number of edges
		for(int a=0; a<ne; a++) { //Scroll through edges
			System.out.println(Elist.get(n.iel[a]).string()); //Get edge from internal edge list and print
		}
	}
}
