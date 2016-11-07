
public class Pump {
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Mode getMode() {
        return mode;
    }
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Nozzle getNozzle(int i) {
	Nozzle[] n = nozzles;
        return n[i];
    }
    
    public Nozzle[] getNozzles() {
        return nozzles;
    }
    public void setNozzles(Nozzle[] nozzle) {
        this.nozzles = nozzle;
    }
    private int no;
    private Mode mode;
 
    private Nozzle[] nozzles;


}

