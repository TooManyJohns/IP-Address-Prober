/* Name: John Lutz 
 * Student Number: #101078723
 * Date last revised: November 19th, 5:00 PM
 * The PSBD Class stands for (Port Scan Database) provides a user interface to allow the firewall.log.txt file to be
 * queried. It also provides cases for what the user wants to check from the txtfile, such as described and commented with each case below
 * the only difference being this assignment uses a linkedlist that we learned in lectures
 */





import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PSBD {

	public static void main(String[] args)throws FileNotFoundException {
		// TODO Auto-generated method stub
	
		
		
		
		// reads txtfile placing it in an array to be scanned for addresses/port number later in the assignment
		Scanner s = new Scanner(new File( "/Users/John/Desktop/Assignment 2 Data Structures/Assignment2/firewall.log.txt" )); //file location to be changed depending on what your testing
		ProbeLList p = new ProbeLList(); //Calling ProbeLList Class
		boolean moreLines = true; //Read end of file
		int probArrayFull = 0; //If Probelinkedlist is full
		while (moreLines) {
		if (s.hasNext()) {
		String tmpPTime = s.next(); //Date and Time
		String[] tmpSIP = s.next().split(":"); //SourceIP:Port
		String[] tmpDIP = s.next().split(":");//DestinationIP:Port
		probArrayFull = p.insertProbe(new Probe(Integer.parseInt(tmpDIP[1]), tmpSIP[0],Integer.parseInt(tmpSIP[ 1]), tmpPTime));//add to ProbeLList
		if (probArrayFull == -1){
		moreLines = false;
		System.out.println("ProbeLList is Full");
		}
		} else
		moreLines = false;
		}
		
		p.insertProbe(new Probe(1,"1",1,"1"));
				
		System.out.println("\n"+"Done");
		//finished ^^! 
		System.out.println("Welcome to the Port Scan Database.");
		
		
		
		
		
	    String choice;

		do{

			Scanner myInput = new Scanner(System.in); 
		
			System.out.println("Enter IP/DP/PL/IL/END (IP address/Destination Port/Port\n" + 
					"List/IP List/END):");
			//takes in input for IP
			String input = myInput.nextLine();
			choice = input;
			
			
	        switch(choice){

	        // input an IP address number to receive the statistics involving the number of probes.
	        // if the IP number doens't exist tell the user so
	            case "IP":
	            	 System.out.println("For which IP do you wish to receive statistics?");
	            	 String ipNumber = myInput.nextLine();
	           
	            	 int numberIP = p.countProbes(ipNumber);
	            	 
	            	 boolean hasIP = false;
	            	 
         		    if (numberIP > 0) {
         		       hasIP = true;
         		    }
	            	 
	            	if (hasIP == true) {
	            		System.out.println("There were " + numberIP + "  probes from " + ipNumber + ".");
	            		
	            	}
	            	else {
	            		System.out.println("There were no probes from that IP address");

	                }
	                break;
	          // done ^^
	                
	                //case dp takes input for the port #, checks if it exists 
	                //if it does return the number of ports along with the original input number by the user
	                //if it doesn't exist in the txt file, return to user telling it doesn't have any probes from that IP addres
	            case "DP":
	             	 System.out.println("For which port do you wish to retrieve statistics?");
	            	 String dpNumber = myInput.nextLine();
	            	
	            	 int numberDP = p.countProbes(Integer.parseInt(dpNumber)); 
	            	 boolean hasDP = false;
         		    if (numberDP > 0) {
         		       hasDP = true;
         		    }
	            	if (hasDP == true) {
	            		System.out.println("There were " + numberDP + " of port " + dpNumber + ".");
	            	}
	            	else {
	            		System.out.println("There were no probes from that IP address");
	                }
	                break;
	                // done ^^
	                
	               // case PL : enters source IP, checks if the IP exists in the given txtfile, 
	                // if it does, returns the IP number along with which number sent a packet from what port number
	            case "PL":
	            	System.out.println("Enter a source IP address to see a list of ports that it scanned");
	            	String plNumber = myInput.nextLine();
	            	
	            	int numberPL = p.countProbes(plNumber);
	            	
	            	boolean hasPL = false;
	            	if (numberPL > 0) {
	            		hasPL = true; 
	            		
	            	}
	            	
	            	if (hasPL == true) {
	            		ArrayList<Probe> pl = p.getProbes(plNumber);
	            		for (int i = 0; i < pl.size(); i++) {
	            			System.out.println("IP " + plNumber + " sent a packet from port " + pl.get(i).getOriginPort() + " to port " + pl.get(i).getDestPort() + " IP ");
	            		}	
	            		
	            	}
	            	
	            	else 
            		{
	            		System.out.println("There were no probes from that IP address");
	                }
	                break;
	                
	                
// case IL - if IL is picked as choice it'll ask for the port number, take input, compare to all of the 
	                //probelist itself returning either false, in which it'll say that there were no probes
	                // found at this address, or it'll return a list of ips probed at the port number that was input by the user
	            case "IL":
	            	System.out.println("For which port do you wish to retrieve statistics?");
	            	String ilNumber = myInput.nextLine();
	            	
	            	int numberIL = p.countProbes(Integer.parseInt(ilNumber));
	            	boolean hasIL = false;
	            	if (numberIL > 0) {
	            		hasIL = true;      
	            	}
	            
	            	if (hasIL == true) {
	            		System.out.println("The " + numberIL + " different IP’s who probed port " + ilNumber + " are as follows:");
	            		
	            		System.out.println(p.getProbes(Integer.parseInt(ilNumber)));
	            	}
	            	
	            	else {
	            		System.out.println("There were no probes from that IP address");
	                }
	            	
	     
	                break;
	        }
	    }
		//no matter if it's caps or lower case it'll end the program below!
	    while ((!choice.toUpperCase().equals("END")));
		
		System.out.println("Goodbye");
		
	
	}
	

}
