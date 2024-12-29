package Networks;

public class Node {
	int x,y;
	int[] iel;
	int ipl;
	int idx, edge_max;
	public Node(int i, int j, int id) {
        //X position, Y Position and Weight
        x=i;
        y=j;
        ipl=-1; //Internal particle list

        ///***DEFAULTS***///
        idx=id; //Node Index = -1
        edge_max=0; //Maximum edges = 0
        
        //if(kwargs.__contains__('idx')):
        //    self.idx=kwargs['idx'] #Edge ID
        //if(kwargs.__contains__('conn')):
        //    self.edge_max=kwargs['conn'] #Connectivity
	}
	
	public String string() {
		return "Node "+Integer.toString(idx)+" at co-ord "+Integer.toString(x)+","+Integer.toString(y);
	}
	
	static void details() {
		System.out.println(string());
		int ne=iel.size();
		for(int a=0; a<ne; a++) {
			System.out.println(Elist[iel[a]].string());
		}
	}
}
