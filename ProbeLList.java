import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry; 


/* Name: John Lutz
 * Student Number: #101078723
 * Date last revised: November 19th, 5:00 PM
 * The ProbeLList Class is meant to create an linkedlist of the Probe class described before
 * the difference now is that a linkedlist doesn't need a maxSize variable, but still uses other functions such as an insert function to be used
 * to insert Probes into the linkedlist as well as like getprobes to get the number of probes involved in the list.
 */




public class ProbeLList {
//head of the list v
	private ProbeNode head;
	// tail of the list v
	private ProbeNode tail;
	
//linkedlist
    LinkedList<Probe> list = new LinkedList<Probe>(); 



	
	
	//constructor for probellist
	public ProbeLList() {
		this.head = null;
		this.tail = null;
	}
	
	//copy constructor
	public ProbeLList(ProbeLList aList) {
		this.head = aList.head;
		this.tail = aList.tail;
	}

	//returns the current size of the linkedlist, using a whileloop to check if the next variable is null, if it is stop looping and return the size of incrementing throughout
	public int getActualSz() {
		int cursize = 0;
	
	      ProbeNode iter =  head; //this.head
	      while (iter !=null) {
	               cursize++;
	               iter = iter.next;
	      }
		return cursize;
	}
	//inserts probe into array
	public int insertProbe(Probe probe) {
		int position = 0;
			ProbeNode newProbe = new ProbeNode(probe);
			if (head == null) {
				head = new ProbeNode(newProbe);
			}
			else {
				ProbeNode current = head;
				while (current.next != null) {
				 current = current.next;
			}
			current.next = new ProbeNode(newProbe);
			position++;

			}
			return position;

	}
	//^^ DONE
	
	
	//countProbes function checking for a string
    public int countProbes(String ip) {
        int count = 0;
        ProbeNode iter =  head; //this.head
        while (iter !=null) {
               Probe probeTest = iter.aProbe;
               if (probeTest.getOriginIP().equals(ip)) {

                     count++;
               }
               iter = iter.next;
        }
        return count;
    }
    
	// ^^
	
	//countProbes function checking for an integer
	public int countProbes(int destPort) {
        int count = 0;
        ProbeNode iter =  head; //this.head
        while (iter !=null) {
               Probe probeTest = iter.aProbe;
               if (probeTest.getDestPort()==(destPort)) {
                     count++;
               }
               iter = iter.next;
        }
        return count;
	}

	
	
	
	/* IL This functions as the getProbes for the IL function in our PSDB
	we can use this public array to form a arraylist of strings involving all 
	iterations of probe throughout the array that equal our destport input in our
	PSDB
	
	*/
	public ArrayList<String> getProbes(int destPort) {

	    ArrayList<String> array = new ArrayList<String>();
	        ProbeNode iter =  head; //this.head
	        while (iter !=null) {
	               Probe probeTest = iter.aProbe;
	               if (probeTest.getDestPort()==(destPort)) {
	            	   array.add(probeTest.getOriginIP());
	               }
	               iter = iter.next;
	        }
	        return array;
	}


	
	/* PL
	 * Returns an ArrayList of Probe objects. The Probe objects are the
	 * ones where the source IP address is ip.
	 */
	
	public ArrayList<Probe> getProbes(String ip) {

    ArrayList<Probe> array2 = new ArrayList<Probe>();
    ProbeNode iter =  head; //this.head
    while (iter !=null) {
           Probe probeTest = iter.aProbe;
           if (probeTest.getOriginIP().equals(ip)) {

                 array2.add(probeTest);
           }
           iter = iter.next;
    }
    return array2;
}
	public String toString()
	{
	      return getClass().getName()+"@"+Integer.toHexString(hashCode());
	}
	
	
	// Pushing element on the top of the stack 
    static void stack_push(Stack<Integer> stack) 
    { 
        for(int i = 0; i < 5; i++) 
        { 
            stack.push(i); 
        } 
    } 
      
    // Popping element from the top of the stack 
    static void stack_pop(Stack<Integer> stack) 
    { 
        System.out.println("Pop :"); 
  
        for(int i = 0; i < 5; i++) 
        { 
            Integer y = (Integer) stack.pop(); 
            System.out.println(y); 
        } 
    } 
  
    // Displaying element on the top of the stack 
    static void stack_peek(Stack<Integer> stack) 
    { 
        Integer element = (Integer) stack.peek(); 
        System.out.println("Element on stack top : " + element); 
    } 
      
    // Searching element in the stack 
    static void stack_search(Stack<Integer> stack, int element) 
    { 
        Integer pos = (Integer) stack.search(element); 
  
        if(pos == -1) 
            System.out.println("Element not found"); 
        else
            System.out.println("Element is found at position " + pos); 
    } 
    
    
    static void removePlate(Stack<String> stack) {
    	System.out.println("You have undo'd the addition of "+ stack.pop() + " to your stack!");
    }
	
    static void searchForPlate(Stack<String> stack, String word) {
    	
    	if (stack.search(word) == 1 ) {
    		System.out.println("The plate your looking for is in the pile!");
    	}
    	else {
    		System.out.println("The plate cannot be found in this pile!");
    	}
    	
    }
    
    static void addPlate(Stack<String> stack, String string) {
    	stack.push(string);
    	System.out.println("You added " + stack.peek() + " to your pile of plates!"); 
    }
    
    static void bubbleSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    } 
    
    
    static void recursiveB(Stack<Integer> numbers, Integer element) {
    	if(numbers.isEmpty())
    		numbers.push(element);
    	else
    	        {
    	           Integer x = numbers.pop();
    	           recursiveB (numbers, element);
    	           numbers.push(x);
    	} }
    
    public static int search(int[] arr, int x) 
    { 
        int n = arr.length; 
        for(int i = 0; i < n; i++) 
        { 
            if(arr[i] == x) 
                return i; 
        } 
        return -1; 
    } 
    
        
        
        
        
        // Returns true if 'num' is  
        // triangular, else false 
        static boolean isTriangular(int num) 
        { 
            // Base case 
            if (num < 0) 
                return false; 
          
            // A Triangular number must be 
            // sum of first n natural numbers 
            int sum = 0; 
              
            for (int n = 1; sum <= num; n++) 
            { 
                sum = sum + n; 
                if (sum == num) 
                    return true; 
            } 
          
            return false; 
        } 
    
        
        static void reversequeue( Queue<Integer> queue)
        {

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
        	int x = queue.remove();
        	reversequeue(queue);
        	stack.push(x);
        }
        
        
        while (!stack.isEmpty()) {
        	int x = stack.pop();
        	queue.add(x);
        }
        
        
        
        
        System.out.println(queue);
       }
        
        
        public static void test_a(int n ) {
        	System.out.println(n+ "");
        		if (n > 2)
        			test_a(n-2);
        	}
    
        public static List<Character> alphabet() {

  	      //arraylist stuff
  	      ArrayList<Character> alphabet = new ArrayList<Character>();
  	      
  	      for (char c = 'A'; c <= 'Z'; c++) {
  	    	  alphabet.add(c);
  	    	  
  	      }
  	      
  	      //Using a arraylist to print out alphabetin an arraylist
  	      System.out.println(alphabet);
  	      
  	      System.out.println(alphabet.size());
  	      return alphabet;
        }
        
        
        
        
        public static ArrayList<Character> alphaBro() {
        	
        	ArrayList<Character> jeffsBet = new ArrayList<Character>();
        	
        	for (char a = 'A'; a <= 'Z'; a++) {
        		jeffsBet.add(a);
        	}
        	return jeffsBet;
        	
        }
        
        
        public static Queue<Character> alphaQueue() {
        	
        	Queue<Character> alphaQ = new PriorityQueue<Character>();
        	
        	for (char a = 'A'; a <= 'Z'; a++) {
        		alphaQ.add(a);
        	}
        	
        	
        	return alphaQ;
        	
        }
        
        
        public static TreeMap<Integer, Character> alphaTree(){
        	
        	TreeMap<Integer,Character> alphaT = new TreeMap<Integer, Character>();
        	int count = 1;
     
        	for (char a = 'A'; a <= 'Z'; a++) {
        		alphaT.put(count,a);
        		count++;
        	}
        	
        	return alphaT;
        }
        
        
        public static boolean isDisjoint(List<Integer> listA, List<Integer> listB) {
        	boolean arraysAreDisjoint = true;
        	
        	if (listA.containsAll(listB)) {
        		arraysAreDisjoint = false;
        	}

        	return arraysAreDisjoint;
        }
        
        
        
        public static int searchLinear(int arr[], int x) 
        // above takes input of array, and integer you want to find in it
        { 
        	int arrSize = arr.length; //take size of array for -> for loop
        	for (int i=0; i < arrSize; i++) { //use i as iteration for the array
        		
        		if (arr[i] == x) { // if array @ "i" == x input, return 1
        			return 1;
        		}
        		
        	}
        	return -1; //if not return -1....
        }
        
        //reverse queue using stack
        public static void reverseQ(Queue<String> queue) {
        	
        	Stack<String> stack = new Stack<>();//make INITIALLY EMPTY stack
        	while (!queue.isEmpty()) {  //is the queue empty? if not proceed
        		String temp = queue.remove(); //temperorary temp value and make it = to what you remove
        		reverseQ(queue); //perform the same shit on the removed value of queue until = null
        		stack.push(temp); //after it all push them onto the stack reversing the order
        	}
        	while(!stack.isEmpty()) {
        		String temp2 = stack.pop();
        		reverseQ(queue);
        		queue.add(temp2);
        	}
        	
        	
        	
        	
        }
        
        public static String reverseString(String str)
        {
         // Create an empty character array stack
         Stack<String> stringStack = new Stack<>();
         String[] words = str.split(" "); 
         
         int wordSz = words.length;
         
         for (int i = 0; i < wordSz; i++) {
        	 stringStack.push(words[i]);
        	 
         }
         System.out.println(stringStack);
         
         int stackSize = stringStack.size();
         
         for (int j = 0; j < stackSize; j++) {
        	 String temp = stringStack.pop();
        	 words[j] = temp;
         }
         
         String REALWORDSBRUH = null;
     
         int wordSz2 = words.length;
         
         
         for (int w = 0; w < wordSz2; w++) {
        	 System.out.println(words[w].toString());
         }
         
         REALWORDSBRUH = Arrays.deepToString(words);
         
         
         return REALWORDSBRUH;
        }
        
        public static boolean compare(int arr1[], int arr2[]) {
        	
        	boolean eqarray = true;
        	
        	int sz1 = arr1.length;
        	int sz2 = arr2.length;
        	
        	if (sz1 == sz2) {
        		
        		for (int i = 0; i < sz1; i++) {
        			if (arr1[i] == arr2[i]) {
        				eqarray = true;
        			}
        			else {
        				eqarray = false;
        				break;
        			}		
        		}	
        		
        		
        	}
        	
        	if (sz1 != sz2) {
        		eqarray = false;
        	}
        	
        	return eqarray;
        	
        }
        
        
        
        
        public static void reverse(char[] str) {
        	int l = str.length;
        	
        	Stack<Character> stack = new Stack<Character>();
        	Character temp = null;
        	for (int i = 0; i <l; i++) {
        		temp = str[i];
        		stack.push(temp);
        	}
        	
        	while (!stack.isEmpty()) {
        		for (int j = 0; j < l; j++) {
        		temp = stack.pop();
        		str[j] = temp;
        		}
        	}
        	
        	
        	
        	
        }
        
        
       //gonna do an example with a stack..
        public static Stack<Character> alphaPatStack(){ //so we are wanting to return a stack with the wrapper of character
        	Stack<Character> patStack = new Stack<Character>();
        	//^ this initializes a return variable since you aren't inputting anything here
        	
        	for (char i = 'A'; i <= 'Z'; i++) { //for a character named "i" we will use a for loop to keep going up as we do with numbers, you must declare the characters the way i did here i <= Z or it WILL stop at Z
        		patStack.push(i); //we push the character "i" onto the stack with each iteration
        	}
        	
        	
        	return patStack; //return the stack
        }
        
        
        public static void reversePat(Stack<Character> stack) {
        	//so in this function the stack variable you input replaces the pat stack in the previous example
        	Queue<Character> queue = new LinkedList<Character>();
        	int stackSz = stack.size();
        	
        	while (!stack.isEmpty()) {
        		char temp = stack.pop();
        		reversePat(stack);
        		queue.add(temp);
        	
        	}
        	System.out.println(queue);
        	while (!queue.isEmpty()) {
        		char temp2 = queue.remove();
        		stack.push(temp2);
        	}
        }
        
        
        public static void reverseQUEUE(Queue<String> q) {
        	Stack<String> stack = new Stack<String>();
        	String temp;
        	while (!q.isEmpty()) {
        		temp = q.remove();
        		reverseQUEUE(q);
        		stack.push(temp);
        	}
        	String temp2;
        	while (!stack.isEmpty()) {
        		temp2 = stack.pop();
        		reverseQUEUE(q);
        		q.add(temp2);
        	}
        	
        	
        }
        
        
        
        
    public static char[] lowerAlpha() {
    	char[] arr = new char[26]; 
    	int counter = 0;
    	for (char i = 'a'; i <= 'z'; i++) {
    		arr[counter] = i;
    		counter++;
    	}
    	//now we print em
    	for (int j = 0; j < counter; j++) {
    		System.out.println(arr[j]);
    	}
    	return arr;
    }
        
    public static char[] alphaBRUH() {
    	char[] alpha = new char[26];
    	int counter = 0;
    	for (char i = 'z'; i >= 'a'; i--) {
    		alpha[counter] = i;
    		counter++;
    	}
    	
    	for (int j = 0; j < counter; j++) {
    		System.out.println(alpha[j]);
    	}
    	
    	return alpha;
    }
        
    public static ArrayList<Character> alphaList(){
    	ArrayList<Character> test = new ArrayList<Character>();
    	
    	for (char i = 'a'; i <= 'z'; i++) {
    		test.add(i);
    	}
    	
    	System.out.println(test);
    	return test;
    	
    	
    }
        
        
	  public static void main(String[] args) {
		  
		  
		  //Autoboxing
		  
		  //Autoboxing of a int
		  Character jeff = 'a';
		  
		  //AutoUnboxing of that integer
		  char jeffUnboxed = jeff;
		  
		  System.out.println(jeff);
		  System.out.println(jeffUnboxed);
		  
		  
	  }
}