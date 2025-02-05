package Networks;

import java.util.ArrayList;

public class Edge extends NetObject{
	int i,j;
	public int idx, weight;
	public Edge(int ln, int un, int id) {
        //Lower node and Upper node
        i=ln;
        j=un;

        ///***DEFAULTS***///
        idx=id; //Edge Index
        weight=-1; //Edge's weight
        
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
	
	void move(int a, int b) {
		i=a;
		j=b;
	}
	
    public int echeck(int a) {
		//Checks which node is at the opposing end of edge
    	if(a==i) {
            return j;
        }
        else {
            return i;
        }
    }
    
	public String string() {
		return "Edge "+Integer.toString(idx)+" connecting nodes "+Integer.toString(i)+" and "+Integer.toString(j)+" with weight "+Integer.toString(weight);
	}
	
	void details(ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		System.out.println(string()); //Print edge
		Node ln = Nlist.get(i); //Lower node
		System.out.println(ln.string()); 
		if(ln.ocheck()) {
			System.out.println(plist.get(ln.ipl).string()); //Print particle if occupied
		}
		Node un = Nlist.get(j); //Upper node
		System.out.println(un.string());
		if(un.ocheck()) {
			System.out.println(plist.get(un.ipl).string()); //Print particle if occupied
		}
	}
}
