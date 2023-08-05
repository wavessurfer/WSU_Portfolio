import java.util.ArrayList;
import java.util.List;
public class GenericStack<E> {
	
	//An internal array list of generic data type E
	private ArrayList<E> list = new ArrayList<>();
	
	/* Return the size of the stack */
	public int getSize() {
	// TODO Add code below
		return list.size();
	}
	
	/* Return the top element in the stack (not remove) */
	public E peek() {
	// TODO Add code below
		if (getSize() == 0)
			throw new IllegalArgumentException("The stack is empty! Could not peek element from the stack.");
		return list.get(getSize() - 1);
	}
	
	/* Add a new element to the top of the stack */
	public void push(E o) {
	// TODO Add code below
		list.add(o);
	}
	
	/* Remove and return the top element in the stack */
	public E pop() {
	// TODO Add code below
		if (getSize() == 0)
			throw new IllegalArgumentException("The stack is empty! Could not pop element from the stack.");
		
		
		return list.remove(getSize()-1);
		
	}
	
	/* Return true if the stack is empty */
	public boolean isEmpty() {
	// TODO Add code below
			return getSize() == 0;
	}
	
	/* Return the string representation of the stack */
	@Override
	public String toString() {
	// TODO Add code below
		return "Stack: " + list.toString();
	}
	
	public GenericStack <E> clone() {
		GenericStack<E> newObj = new GenericStack<E>();
		for (int i = 0; i < list.size(); i++) {
			E obj = list.get(i);
			newObj.push(obj);
		}
		return newObj;
	}
	
	/** Find the maximum in a stack of numbers
	* @param stack: the stack of Number (only Integer, Double, Float can be applied)
	* @return: the max number in the stack after converting to double
	*/
	public static double max(GenericStack<Double> stack) {
	//TODO Add code below
		GenericStack<Double> obj = stack.clone();
		double max = obj.pop().doubleValue();
		while (!obj.isEmpty()) {
			double val = obj.pop().doubleValue();
			if ( val > max)
				max = val;
		}
		return max;
	}
	
	public static double avg(GenericStack<? extends Number> stack) {
		//TODO Add code below
		double countpop = 0;
		int counttotal = 0;
		while (!stack.isEmpty()) {
			System.out.println(stack.peek());
			countpop += stack.pop().doubleValue();
			counttotal++;
		}
		
			return countpop / counttotal;
	}
			
	
	public static void main(String[] args) {
	// TODO Add code below
		GenericStack<Integer> stack1 = new GenericStack<>();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		System.out.println(stack1);
//		try {
//			for (int i = 0; i < 4; i++)
//			System.out.println("Pop element from stack1: " + stack1.pop());
//		} catch(IllegalArgumentException iae) {
//			System.out.println(iae.getMessage());
//		}
		System.out.println("Stack1 isEmpty() = " + stack1.isEmpty() );
		System.out.println("The average of Stack1 is: " + avg(stack1) );

		
		System.out.println(); 
		
		GenericStack<String> stack2 = new GenericStack<>();
		stack2.push("Winona");
		stack2.push("Rochester");
		stack2.push("Minneapolis");
		System.out.println(stack2);
		try {
			for (int i = 0; i < 3; i++)
			System.out.println("Pop element from stack2: " + stack2.pop());
		} catch(IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		System.out.println("Stack2 isEmpty() = " + stack2.isEmpty() );
		
		System.out.println(); 
		
		GenericStack<Double> stack3 = new GenericStack<>();
		stack3.push(1.5);
		stack3.push(2.5);
		stack3.push(-3.2);
		System.out.println(stack3);
		System.out.println("The max element of stack3: " + max(stack3));
		System.out.println("The average of Stack3 is: " + avg(stack3) );

		
	
	}
	
}
