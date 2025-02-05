package Networks;

import java.util.ArrayList;

public class NetObject {
	int i,j;
	int idx;
	public void NetObject(int id) {
        ///***DEFAULTS***///
        //idx=id; //Node Index = -1
        
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
		return "";
	}
	
	void details(ArrayList<Node> Nlist, ArrayList<Edge> Elist, ArrayList<Particle> plist) {
		System.out.println(this.string());
	}
}
