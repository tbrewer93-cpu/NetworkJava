package Networks;

public class Edge {
	int i,j;
	int idx;
	public Edge(int ln, int un, int id) {
        //Lower node and Upper node
        i=ln;
        j=un;

        ///***DEFAULTS***///
        idx=id; //Node Index = -1
        
        //if(kwargs.__contains__('idx')):
        //    self.idx=kwargs['idx'] #Edge ID
	}
	
	public String string() {
		return "Edge "+Integer.toString(idx)+" connecting nodes "+Integer.toString(i)+" and "+Integer.toString(j);
	}
}
