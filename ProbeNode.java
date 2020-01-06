import java.io.FileNotFoundException;

/* Name: John Lutz 
 * Student Number: #101078723
 * Date last revised: November 19th, 5:00 PM
 * ProbeNode is a class that defines a node in a linked list. this also including variables
 * for the copy constructor as well
 */


public class ProbeNode {

	public Probe aProbe; //here is the data component
	
	public ProbeNode next; //here is the link component
	
	//node constructors
	public ProbeNode(Probe aProbe) {
		this.aProbe = aProbe;
	}
	
	//copy constructor
	public ProbeNode(ProbeNode aNode) {
		this.aProbe = aNode.aProbe;
		this.next = aNode.next;
	}
	
	/*Test case for class ProbeNode
	public static void main(String[] args)throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		ProbeLList testLink = new ProbeLList(); //Calling ProbeLList Class

		Probe testProber = new Probe(1,"1",1,"1");
		
		testLink.insertProbe(testProber);
		
	//test ProbeNode(Probe aProbe)
		ProbeNode testProbe2 = new ProbeNode(testProber);
	//test ProbeNode(ProbeNode aNode)
		ProbeNode testProbeNode = new ProbeNode(testProbe2);
		
		//test that the next thing after testProbe2 is null since there is nothing (works)
		System.out.println(testProbe2.next);
		
		
	}
	
	*/
	
}
