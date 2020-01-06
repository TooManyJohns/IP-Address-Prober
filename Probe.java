import java.io.FileNotFoundException;

/* Name: John Lutz 
 * Student Number: #101078723
 * Date last revised: November 19th, 5:00 PM
 * The Probe Class is created to create a class that can be used to individualize the 
 * lines of text in the PSBD file as well as to have each object saved in the ProbeLList LinkedList
 */


public class Probe {

	
	
	private int desPort;
	private String originIP;
	private int originPort;
	private String probeTime;
	
	
	//define parameters of the probe
	public Probe(int desport, String IP, int oriport, String time){
		this.desPort = desport;
		this.originIP = IP;
		this.originPort = oriport;
		this.probeTime = time;
	}
	
	//getter destination port value
	public int getDestPort() {
		return desPort;
	}
	
	//getter original ip value
	
	public String getOriginIP() {
		return originIP;
	}
	
	//getter original port value
	public int getOriginPort() {
		return originPort;
	}
	//getter original time value of probe 
	public String getProbeTime() {
		return probeTime;
	}
	
	
	/*test case for class Probe
	public static void main(String[] args)throws FileNotFoundException {
		// TODO Auto-generated method stub
	
		Probe testProbe = new Probe(100,"Test1",200,"Test2");
		System.out.println(testProbe.getDestPort());
		System.out.println(testProbe.getOriginIP());
		System.out.println(testProbe.getProbeTime());
		System.out.println(testProbe.getOriginPort());
	}
	*/
	

}
