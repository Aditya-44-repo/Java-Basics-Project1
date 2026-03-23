import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



  class Car{
	private String carId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAvailable;
	
	// constructor runs the class(variables and methods) automatically without writting additional code for it
	// whenever the variables are used. constructor is used to enable operations on them.
	// basically they help other classes to use variables and methods of this class without any additional code.
  public Car(String carId, String brand, String model, double basePriceDay){
	     this.carId=carId;
	     this.brand=brand;
	     this.model=model;
	     this.basePricePerDay=basePriceDay;
	     this.isAvailable=true;
	     
  }
  // whenever the getCarId function is invoked it returns carId variable thats all
  public String getCarId() {
	  return carId;
  }
  public String getBrand() {
	  return brand;
  }
  public String getModel() {
	  return model;
  }
  
  public double calculatePrice(int rentalDays) {
	  return basePricePerDay* rentalDays;
  }
  
  public boolean isAvailable() {
	  return isAvailable;
  }
  public void rent() {
	  isAvailable=false;
	  
  }
  public void returnCar() {
	  isAvailable=true;
  }
  
  
}
  
  class Customer{
	  private String customerId;
	  private String name;
	  
	  //the constructor is called while creating the object of this class snce other classes cannot directly access the variables of this class we are creating new variables in public method(any class can access) and storing them into the class variables
	  public Customer(String customerId, String name) {
		  this.customerId=customerId;
		  this.name=name;
	  }
	  public  String getcustomerId() {
		  return customerId;
	  }
	  public String getNmae() {
		  return name;
	  }
  }
  
  class Rental{
	  
//	   class is also a datatype when i create a car variable of the datatype Car it means the 
//	   all the details of the car object is present. here car has carId, brand, model and etc.
//	  car variable should have all the properties of class Car
	  private Car car;
	  private Customer customer;
	  private int days;
	  
	  public Rental(Car car, Customer customer, int days) {
		  this.car=car;
		  this.customer=customer;
		  this.days=days;
	  }
	  public Car getCar() {
		  return car;
	  }
	  public Customer getCustomer() {
		  return customer;
	  }
	  public int getDays() {
		  return days;
	  }
  }
  
  class CarRentalSystem{
	  private List<Car> cars;
	  private List<Customer> customers;
	  private List<Rental> rentals;
	  
	  public CarRentalSystem() {
		  cars= new ArrayList<>();
		  customers= new ArrayList<>();
		  rentals= new ArrayList<>();
	  }
	  
	  public void addCar(Car car) {
		  // add method appends car object at the end
		  cars.add(car);
	  }
	  public void addCustomer(Customer customer) {
		  customers.add(customer);
	  }
	  
	  public void rentCar(Car car, Customer customer, int days) {
		  if(car.isAvailable()) {
			  car.rent();
			  rentals.add(new Rental(car, customer, days));
			  
		  }else {
			  System.out.println("Car is not available for rent");
		  }
	  }
	  public void returnCar(Car car) {
		  car.returnCar();
		  Rental rentalToRemove=null;
		  for(Rental rental:rentals) {
			  if(rental.getCar()==car) {
				  rentalToRemove=rental;
				  break;
			  }
		  }
		  if(rentalToRemove != null) {
			  rentals.remove(rentalToRemove);
		  }else {
			  System.out.println("Car was not rented");
			  
		  }
		  
	  }
	  pub
  }
  

public class Main {

	public static void main(String[] args) {



	}

}
