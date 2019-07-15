abstract class Vehicle {

	public String vehicleRegNo;
	public int vehicleMake;
	public String vehicleModel;
	public String vehicleColor;

	public Vehicle(String vehicleRegNo, int vehicleMake, String vehicleModel, String vehicleColor) {
		this.vehicleRegNo = vehicleRegNo;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehicleColor = vehicleColor;
	}

}

abstract class Goods extends Vehicle {
	
	public Goods(String vehicleRegNo, int vehicleMake, String vehicleModel, String vehicleColor) {
		super(vehicleRegNo, vehicleMake, vehicleModel, vehicleColor);
	}
	
	abstract public void vehicleSpecialty();
	abstract public void setGoodsWeight(double goodsWeight);
}

abstract class Passenger extends Vehicle {
	
	private int noOfPassengers;
	public Passenger(String vehicleRegNo, int vehicleMake, String vehicleModel, String vehicleColor, int noOfPassengers) {
		super(vehicleRegNo, vehicleMake, vehicleModel, vehicleColor);
		this.noOfPassengers = noOfPassengers;
	}
	abstract public void vehicleSpecialty();
	abstract public void setPassengers(int num);
	
}

class GoodVehicle extends Goods {

	private double goodsWeight = 500; //in kilograms
	public GoodVehicle(String vehicleRegNo, int vehicleMake, String vehicleModel, String vehicleColor, double goodsWeight) {
		super(vehicleRegNo, vehicleMake, vehicleModel, vehicleColor);
		this.goodsWeight = goodsWeight;
	}

	@Override
	public void vehicleSpecialty() {
		System.out.println("Can carry goods over " + this.goodsWeight + " KGs");
	}

	@Override
	public void setGoodsWeight(double goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	
}

class PassengerVehicle extends Passenger {

	private int noOfPassengers = 4;
	public PassengerVehicle(String vehicleRegNo, int vehicleMake, String vehicleModel, String vehicleColor, int noOfPassengers) {
		super(vehicleRegNo, vehicleMake, vehicleModel, vehicleColor, noOfPassengers);
		this.noOfPassengers = noOfPassengers;	
	}

	@Override
	public void vehicleSpecialty() {
		System.out.println("Passenger vehicle can carry " + this.noOfPassengers + " passengers");
	}

	@Override
	public void setPassengers(int noOfPassengers) {
		if(noOfPassengers <= 6 ) {
			this.noOfPassengers = noOfPassengers;
		}
		else System.out.println("Passenger cars cannot carry more than 6 passengers");
	}

}

class LuxuryVehicle extends Passenger {

	private int noOfPassengers = 2;
	public LuxuryVehicle(String vehicleRegNo, int vehicleMake, String vehicleModel, String vehicleColor, int noOfPassengers) {
		super(vehicleRegNo, vehicleMake, vehicleModel, vehicleColor, noOfPassengers);
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public void vehicleSpecialty() {
		System.out.println("Luxury vehicle can carry " + this.noOfPassengers + " passengers");
	}

	@Override
	public void setPassengers(int noOfPassengers) {
		if(noOfPassengers <= 2) {
			this.noOfPassengers = noOfPassengers;
		}
		else System.out.println("Luxury cars cannot carry more than 2 passengers");
	}
	
}

class RacingVehicle extends Passenger {

	private final int NO_OF_PASSENGERS = 1;
	public RacingVehicle(String vehicleRegNo, int vehicleMake, String vehicleModel, String vehicleColor,
			int NO_OF_PASSENGERS) {
		super(vehicleRegNo, vehicleMake, vehicleModel, vehicleColor, NO_OF_PASSENGERS);
		if(NO_OF_PASSENGERS != 1) {
			System.out.println("Racing vehicles cannot carry more than 1 passenger");
		}

	}

	@Override
	public void vehicleSpecialty() {
		System.out.println("Racong vehicle can carry " + this.NO_OF_PASSENGERS + " passenger");
	}

	@Override
	public void setPassengers(int NO_OF_PASSENGERS) {
		if(NO_OF_PASSENGERS != 1) {
			System.out.println("Racing vehicles cannot carry more than 1 passenger");
		}
	}
	
}