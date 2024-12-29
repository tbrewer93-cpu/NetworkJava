package Networks;

public class Particle {
	int i;
	int idx;
	public Particle(int n, int id) {
        //Node
        i=n;

        ///***DEFAULTS***///
        idx=id; //Node Index = -1
        
        //if(kwargs.__contains__('idx')):
        //    self.idx=kwargs['idx'] #Edge ID
	}
	
	public String string() {
		return "Particle "+Integer.toString(idx)+" on node "+Integer.toString(i);
	}
}
