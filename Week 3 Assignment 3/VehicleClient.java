public class VehicleClient {
	public static void main(String args[]) {
		Passenger passengerVehicleSwift = new PassengerVehicle("KA 05 ME 8619", 2018, "Swift", "Red", 3);
		passengerVehicleSwift.vehicleSpecialty();

		passengerVehicleSwift.setPassengers(4);
		passengerVehicleSwift.vehicleSpecialty();

		passengerVehicleSwift.setPassengers(7);
		
		Goods goodsVehicle1 = new GoodVehicle("KA 51 AB 7812", 2014, "Ace", "Grey", 400);
		goodsVehicle1.vehicleSpecialty();
	}
}