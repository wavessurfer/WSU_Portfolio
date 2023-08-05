package lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOccurenceOfWords {
	
	public static Map <String, Integer> countOcurrances(String sentence){
		//TODO add code below
		Map <String, Integer> map = new TreeMap<>();	//the map stores the occurrences of words
		//Split the sentence into a String array of words
		String[] arr = sentence.split(" ");
		//for loop on each word and count the occurrences
		for(String word : arr) {
			//String str = trim leading and ending space from the word
			String str = word.trim();
			//Convert str to lower case
			str=str.toLowerCase();
			//if str is not an empty string
			if (!str.isEmpty()) {
				//If str is not an existing key in the map, put an entry (str , 1) to the map
				if(!map.containsKey(str))
					map.put(str, 1);
				else {
					//get the value corresponding with the key=str in the map.
					//increase the value with 1 to the count of str
					//put  back the entry (str, value) into the map
					int count = map.get(str);
					count++;
					map.put(str, count);	//overwrite the existing entry with new value
				}
			}
			
		}
		
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String sentence = sc.nextLine();
		Map<String, Integer> map = countOcurrances(sentence);
		System.out.println("The ocurrances of words: " + map);
		
		String maxWord = "";
		int maxOcc = 0;
		for (String word : map.keySet()) {
			if(map.get(word) > maxOcc) {
				maxWord = word;
				maxOcc = map.get(word);
			}
		}
		
		System.out.println("The "+maxWord+" has the maximum of "+maxOcc+" occurrances.");
		

	}

}
