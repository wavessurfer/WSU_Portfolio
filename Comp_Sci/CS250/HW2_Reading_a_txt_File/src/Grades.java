import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Grades {
	public double grade;
	private static double total, average;
		
	public static ArrayList <Double>  readGradesFromTextFile(String filepath) {
		File infile = new File(filepath);
		try (BufferedReader br = new BufferedReader (new FileReader(infile));) {
			String line;
			line = br.readLine();
			ArrayList <Double> arrG = new ArrayList <Double>();
			while (line != null) {
				String[] arr = line.split("\\s+");
				for ( int i = 0; i < arr.length ; i++ ) {
					double grad = Double.parseDouble(arr[i]);
					arrG.add( grad );	
				}
				line = br.readLine();
				
			}
			return arrG;
			
		} catch(FileNotFoundException fnfe) {
			System.out.println("File " + filepath + "does not exist!");
		} catch(IOException ex) {
			System.out.println("File " + filepath + "could not be read!");
		} catch(NumberFormatException nfe) {
			System.out.println("Invalid inputs in the file " + filepath);
//		} catch (ArrayIndexOutOfBoundsException aiobe) {
//			System.out.println("Check the total number of records in the file " + filepath);

		}
	return null;
	}
	
	public static double calculateTotal( ArrayList <Double> arrG) {
				
		for(int i=0; i<arrG.size(); i++) {
			
			total += arrG.get(i); 
		}
			
		return total;
	}
		
	public static double calculateAverageGrade(ArrayList <Double> arrG) {
			
			for(int i=0; i<arrG.size(); i++) {
			
			   average = total / arrG.size();
			}
			
			return average;
		}


	private static void saveGradesStatsToTextFile(String path, ArrayList <Double> arrG) {
		File outFile = new File(path);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
				bw.write("Total: " + calculateTotal(arrG));
				bw.newLine();
				bw.write("Average: " + calculateAverageGrade(arrG));
			
		} 
		
		catch(IOException ex) {
			System.out.println("Error! Cannot open the file to write!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> arrGrades = readGradesFromTextFile ("src/grades.txt");
		saveGradesStatsToTextFile("src/grades_stats.txt", arrGrades);
	}

}
