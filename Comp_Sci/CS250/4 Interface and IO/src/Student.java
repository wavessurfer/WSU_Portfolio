import java.io.*;
import java.util.Arrays;

public class Student implements Comparable <Student>{
	
	private String id; //student id
	private String name; //name of the student
	private int birthYear; //birth year of the student
	private String major;	//major of Student
	
	
	public Student(String id, String name, int year, String maj) {
		this.id = id;
		this.name = name;
		this.birthYear = year;
		this.major = maj;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public int getBirthYear() { return birthYear; }
	public void setBirthYear(int birthYear) { this.birthYear = birthYear; }
	public String getMajor() {return major;	}
	public void setMajor(String major) { this.major = major; }


	public String toString() {
		return "Student: " + id + ", " + name + ", " + birthYear + ", " + major;
	}
	
	public int compareTo(Student obj) {
		// TODO Auto-generated method stub
		//return this.getId().compareTo(obj.getId()); //sort ascending by id  (String)
	
		if ( this.getBirthYear() == obj.getBirthYear()) return 0; //equals as they have same id
		else if (this.getBirthYear() < obj.getBirthYear()) return -1; //this < obj as it has smaller id
		else return 1; //this > obj as it has bigger id
	}
	
	/**
	 * This method reads an array of Student objects from the input text file
	 * @param filepath: The input file path
	 * @return An array of Student object
	 */
	
	public static Student[]  readStudentsFromTextFile(String filepath) {
		File inFile = new File(filepath);
		try (BufferedReader br = new BufferedReader(new FileReader(inFile));) {
			String line;
			line = br.readLine();
			int len = Integer.parseInt(line);
			Student [] arrStud = new Student [len];
			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",\\s+");
				String id = arr[0];
				String name = arr[1];
				int bYear = Integer.parseInt(arr[2]);
				String major = arr[3];
				Student obj = new Student(id, name, bYear, major);
				arrStud[count] = obj;
				count++;
				}
				return arrStud;
			
			} catch(FileNotFoundException fnfe) {
				System.out.println("File " + filepath + "does not exist!");
			} catch(IOException ex) {
				System.out.println("File " + filepath + "could not be read!");
			} catch(NumberFormatException nfe) {
				System.out.println("Invalid inputs in the file " + filepath);
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.out.println("Check the total number of records in the file " + filepath);

			}
		return null;
	}
	
	/**
	* This method writes an array of Student objects to an output text file
	* @param path: the output file path
	* @param arrStudents: the array list of the students
	*/
	private static void saveStudentsToTextFile(String path, Student[] arrStud) {
		File outFile = new File ( path);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));) {
			
			bw.write(arrStud.length + "\n");
			
			for (Student obj : arrStud) {
				bw.write(obj.getId() + ", ");
				bw.write(obj.getName() + ", ");
				bw.write(obj.getBirthYear() + ", ");
				bw.write(obj.getMajor());
				bw.newLine();
				}
				
		} catch(IOException ex) {
			System.out.println("Cannot open the file to write");
		}
	}
	
	public static void main(String[] args) {
//		Student[] arrStudents = new Student[5];
//		arrStudents[0] = new Student("157886", "Callum", 1985);
//		arrStudents[1] = new Student("865427", "Blake", 1946);
//		arrStudents[2] = new Student("143433", "Kayden", 1999);
//		arrStudents[3] = new Student("774343", "Kason", 2001);
//		arrStudents[4] = new Student("454767", "Colin", 1975);
//		Arrays.sort(arrStudents);
//		for(Student obj : arrStudents)
//			System.out.println(obj);
		
		Student[] arrStud = readStudentsFromTextFile("src/students.txt");
		if (arrStud == null)
			System.out.println("Error in reading the student file");
		else {
			for(Student obj : arrStud)
				if (obj != null)
				System.out.println(obj);
		}
		
		arrStud[0].setName("Ryan Smith");
		arrStud[1].setId("4321");
		arrStud[2].setName("Jane Doe");
		arrStud[3].setBirthYear(1972);
		arrStud[4].setMajor("Statistics");
		saveStudentsToTextFile("src/students_new.txt", arrStud);
		
		}

	
	


}
