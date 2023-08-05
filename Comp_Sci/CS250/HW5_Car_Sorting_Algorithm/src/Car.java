
public class Car {
	private int ID, year;
	private String make, model, plate;
		
	/**
	 * @param iD
	 * @param year
	 * @param make
	 * @param model
	 * @param plate
	 */
	public Car(int ID, int year, String make, String model, String plate) {
		super();
		this.ID = ID;
		this.year = year;
		this.make = make;
		this.model = model;
		this.plate = plate;
	}


	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}
	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}


	@Override
	public String toString() {
		return "Car [ID=" + ID + ", year=" + year + ", make=" + make + ", model=" + model + ", plate=" + plate + "]";
	}
	
	
}
