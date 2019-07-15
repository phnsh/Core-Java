interface selfDriveVehicles {
	void drive(int option);
}

class VehicleType implements selfDriveVehicles {

	private String source;
	private String destination;
	public VehicleType(String source, String destination) {
		this.source = source;
		this.destination = destination;
	}

	@Override
	public void drive(int option) {
		if(option == 1) {
			System.out.println("You have chosen WagonR to drive from " + this.source + " to " + this.destination);
		}
		else if(option == 2) {
			System.out.println("You have chosen BMW to drive from " + this.source + " to " + this.destination);
		}
	}

}