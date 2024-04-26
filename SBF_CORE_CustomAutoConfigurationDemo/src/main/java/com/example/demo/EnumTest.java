package com.example.demo;

import java.lang.Enum.EnumDesc;
import java.util.Optional;
import java.util.jar.Attributes.Name;

enum Days {
	SUNDAY, MONDAY, TUESDAY;

	static {
		System.out.println("Days enum class static-block after Enum Constants are loaded");
	}

	Days() {
		System.out.println("Constructor :" + this.name() + "\t" + this.hashCode());
	}

}

public class EnumTest {
	public static void main(String[] args) {
		Days d1 = Days.MONDAY; // Class Loading starts here
		System.out.println("Printing d1 name: " + d1.name());

		Days d2 = Days.TUESDAY; // Enum class and constant are already loaded.
		System.out.println("Printing d2 name: " + d2.name());

		Days d3 = Days.MONDAY;
		System.out.println("Printing d3 name: " + d3.name());

		// Equality Check: Note at time of class loading: there objects are already been
		// created for Enum...and thereafter whenever we create a new enum...it is just
		// referring to one of the already created enum objects nothing else.
		// hence == (reference checking returning true when d1==d3
		// .equals method also internally using == operator for comparison'

		System.out.println("Hascode of d1: " + d1.hashCode());
		System.out.println("Hascode of d3: " + d3.hashCode());
		System.out.println(d1 == d3); // true
		System.out.println(d1.equals(d3)); // true

		// CTE: can not instantiate
//		Days kDays =  new Days();

		Days kDays = Days.SUNDAY;

	}

}

//public static void main(String[] args) {
//	Days d1 = Days.MONDAY;
//	Days d2 = Days.MONDAY;
//	System.out.println(d2.equals(d1));
//
//	System.out.println(d1);
//	System.out.println(d1.name());
//	System.out.println(d1.ordinal());
//	System.out.println(d1.toString());
//	Optional<EnumDesc<Days>> describeConstable = d1.describeConstable();
//	EnumDesc<Days> enumDesc = describeConstable.get();
//	System.out.println(enumDesc);
//	System.out.println(d1.MONDAY);
//	System.out.println(d1);
//	System.out.println(d1);
//
//}

enum Planet {
	MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), EARTH(5.976e+24, 6.37814e6), MARS(6.421e+23, 3.3972e6),
	JUPITER(1.9e+27, 7.1492e7), SATURN(5.688e+26, 6.0268e7), URANUS(8.686e+25, 2.5559e7), NEPTUNE(1.024e+26, 2.4746e7);

	private final double mass; // in kilograms
	private final double radius; // in meters

	Planet(double mass, double radius) {
		System.out.println("Constructor called");
		this.mass = mass;
		this.radius = radius;
	}

	private double mass() {
		return mass;
	}

	private double radius() {
		return radius;
	}

	// universal gravitational constant (m3 kg-1 s-2)
	public static final double G = 6.67300E-11;

	public static String description() {
		return "Welcome !!! to Planet Enum";
	}

	double surfaceGravity() {
		return G * mass / (radius * radius);
	}

	double surfaceWeight(double otherMass) {
		return otherMass * surfaceGravity();
	}

	public static void main(String[] args) {

		System.out.println("starting");

		if (args.length != 1) {
			System.err.println("Usage: java Planet <earth_weight>");
			System.exit(-1);
		}

		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight / EARTH.surfaceGravity();
		System.out.println("Earth is done calling");
		for (Planet p : Planet.values())
			System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
	}
}

//Define an interface
interface Vehicle {
	void start();

	void stop();
}

//Define an enum implementing the interface
enum CarType implements Vehicle {
	SEDAN, SUV, HATCHBACK;

	@Override
	public void start() {
		System.out.println(name() + " starting...");
	}

	@Override
	public void stop() {
		System.out.println(name() + " stopping...");
	}
}

class Main {
	public static void main(String[] args) {
		// Using enums as objects
		CarType sedan = CarType.SEDAN;
		CarType suv = CarType.SUV;

		// Calling interface methods
		sedan.start();
		suv.stop();
	}
}

class EnumExample3 {
	enum Season {
		WINTER, SPRING, SUMMER, FALL;
	}// semicolon(;) is optional here

	public static void main(String[] args) {
		Season s = Season.WINTER;// enum type is required to access WINTER
		System.out.println(s);
	}
}

//output:
// SEDAN starting...
// SUV stopping...

//Define an interface with an abstract method
interface Shape {
	double calculateArea();
}

//Define an enum implementing the interface
enum ShapeType implements Shape {
	SQUARE {
		@Override
		public double calculateArea() {
			double side = 5; // Example side length
			return side * side;
		}

		@Override
		public String message() {
			return "this is your square";
		}
	},
	CIRCLE {
		// Constant specific implementation
		@Override
		public double calculateArea() {
			double radius = 5; // Example radius
			return Math.PI * radius * radius;
		}

		@Override
		public String message() {
			return "this is your circle";
		}
	},
	TRIANGLE {

		@Override
		public String message() {
			return "this is your tringle";
		}
	};

	// implementation common to each instance
	@Override
	public double calculateArea() {
		return 0;
	}

	public abstract String message();
}

class MainTest {
	public static void main(String[] args) {
		// Using enums as objects
		double squareArea = ShapeType.SQUARE.calculateArea();
		double circleArea = ShapeType.CIRCLE.calculateArea();
		double triangleArea = ShapeType.TRIANGLE.calculateArea();

		// Output the areas
		System.out.println("Area of Square: " + squareArea);
		System.out.println("Area of Circle: " + circleArea);
		System.out.println("Area of Triangle: " + triangleArea);

		// Messages:
		System.out.println(ShapeType.SQUARE.message());
		System.out.println(ShapeType.CIRCLE.message());
		System.out.println(ShapeType.TRIANGLE.message());

	}
}

//====

interface Action {
	void perform();
}

enum Direction implements Action {
	NORTH {
		@Override
		public void perform() {
			System.out.println("Moving North");
		}
	},
	SOUTH {
		@Override
		public void perform() {
			System.out.println("Moving South");
		}
	},
	EAST {
		@Override
		public void perform() {
			System.out.println("Moving East");
		}
	},
	WEST {
		@Override
		public void perform() {
			System.out.println("Moving West");
		}
	};

	// Implementing the method from the Action interface
	public abstract void perform();
	// it is optional to write this statement here.
}

class MainY {
	public static void main(String[] args) {
		Direction.NORTH.perform();
		Direction.SOUTH.perform();
		Direction.EAST.perform();
		Direction.WEST.perform();
	}
}

enum Rank {
	DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

enum Suit {
	DIAMONDS, CLUBS, HEARTS, SPADES
}

class Card3 {
	private final Rank rank;
	private final Suit suit;

	public Card3(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public String toString() {
		return rank + " of " + suit;
	}
}

class Deck3 {
	private static Card3[] cards = new Card3[52];

	public Deck3() {
		int i = 0;
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards[i++] = new Card3(rank, suit);
			}
		}
	}
}

class ProductManagement {

	enum Category {
		ELECTRONICS, CLOTHING, BOOKS
	}

	static class Product {
		private String name;
		private double price;
		private Category category;

		public Product(String name, double price, Category category) {
			this.name = name;
			this.price = price;
			this.category = category;
		}

		public String getName() {
			return name;
		}

		public double getPrice() {
			return price;
		}

		public Category getCategory() {
			return category;
		}

		@Override
		public String toString() {
			return "Product{" + "name='" + name + '\'' + ", price=" + price + ", category=" + category + '}';
		}
	}

	public static void main(String[] args) {
		Product laptop = new Product("Laptop", 999.99, Category.ELECTRONICS);
		Product tShirt = new Product("T-Shirt", 19.99, Category.CLOTHING);
		Product javaBook = new Product("Java Book", 39.99, Category.BOOKS);

		System.out.println("Product Information:");
		System.out.println(laptop);
		System.out.println(tShirt);
		System.out.println(javaBook);
	}
}

enum Month {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
}

class MonthTest {
	public static void main(String[] args) {
		Month oct = Month.OCTOBER;

		System.out.println(oct.name());
		System.out.println(oct.toString());
		System.out.println(oct.ordinal());

		// values() : returs array of all enum constants in same order as we
		// declared...it is useful to iterate over it
		Month[] values = Month.values();

		for (Month month : values)
			System.out.print(month.toString() + "\t");

		// This valueOf - static method is used to get enum of any Enum-type of
		// specified value
		// we we get RTE if passed string name does not found
		Days dayMonday = Month.valueOf(Days.class, "MONDAY");
		System.out.println(dayMonday.toString());

	}
}
