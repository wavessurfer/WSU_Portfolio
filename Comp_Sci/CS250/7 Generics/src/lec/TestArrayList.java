package lec;
import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	
	public static <E extends Comparable <E>> E max(List<E> arl) {
		if (arl == null || arl.isEmpty())
			throw new IllegalArgumentException("The input array is invalid");
		E max = arl.get(0);
		for (int i = 1; 1 < arl.size(); i++) {
			if (arl.get(i).compareTo(max) > 0)
				max = arl.get(i);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Integer> arlInt = new ArrayList<>();
			arlInt.add(5);
			arlInt.add(9);
			arlInt.add(10);
			arlInt.add(-3);
			arlInt.add(4);
			arlInt.remove(3);
			arlInt.set(2, 15);
			System.out.println("Size of arrInt: " + arlInt.size());
			System.out.println(arlInt.size());
			System.out.println("The index of 9 in arrInt: " + arlInt.indexOf(9));
			System.out.println("The index of 9 in arrInt: " + arlInt.indexOf(99));
			
			System.out.println();
			
			System.out.println("Max element of arlInt: " + max(arlInt));
			
			List <String> arlStr = new ArrayList<>();
			arlStr.add("CS250");
			arlStr.add("CS405");
			arlStr.add("Computer Science");
			System.out.println("Max element of arlStr: " + max(arlStr));






	}

}
