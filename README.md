# JAVA OOP

==== To declear a constant in Java, use the word final e.g final int name = 'Godswill';

==== let num = 2
system.out.println(num++) // prints 2 then increase num by 1
system.out.println(++num) increase num by 1 then prints 3
system.out.println(num+=1) increase num by 1 then prints 3

====type casting: to cast a value from one type to another, wrap the other type in a bracket 
int num = (int) 5.2 - 4

==== for Each loop
for(int item:items) {...}

===Strings in Java
- To define a string value, use double quotes
- comparing string values use equals() or intern()
e.g
if(val1.equals(val2)){...} or val3 = val1.inteen(), 
val4 = val2.intern()
if(val3 == val4) {...} 
- converting values to Strings 
- String.valuesOf(100) //converts 100 to string
- String val = 100 + "!" // stores "100!" in val

===== constructor chaining/passing values between constructors 

public class ClassName{
   
  public ClassName(int age){
  this.age = age;
} 

public ClassName(int age, String dob){
  this(age);
 this.dob = dob;
}
} 

=======Static Members 
Static members of a class are not tied to a class instance, but to the class itself. Think of them like a global variable that's exist outside/above a given class instance .  
Static methods can only access other static members, they can't access instance members

======Declearing static member in java
private static int num1 = 0;

===== Static imports
To import multiple static members from a ass, use

import static com.packageName.ClassName.*
The use of * tell Java to import all static members

===== String builder
StringBuilder build = new StringBuilder()
build.append(add content...)
build.append(...in here)
build.toString()

===========Overloading
Multiple versions of a method or constructor within a class
Each must have a unique signature

==Parts of the signature are 
Method name
Number of parameters
Type of each parameter

==Object class is
Root class of the Java class hierarchy
Object reference can reference an instance of any class
Every class has Object characteristics

======= UNDERSTANDING ENUM

public enum FlightCrewJob {
FLIGHT_ATTENDANT,
COPILOT,
PILOT
}

Enumeration Types are:
- Useful for defining a type with a finite list of valid values
- Declare using the enum keyword 
-Provide comma-separated value list
- By convention value names are all upper case 
- Enums can have a constructor, method and field because they are Java classes. 
- Each list item of an Enum type is an instance of that Enum. i.e PILOT is a new instance of FlightCrewJob

###
public enum FlightCrewJob {

//declare Enum types with title passed to each constructor 
FLIGHT_ATTENDANT ("Flight Attendant"), COPILOT("First Officer"), 
PILOT("Captain"); 

private String title; //Enum field

//Enum Constructor 
private FlightCrewJob(String title) {
this.title = title; 
} 
//Enum Method
public String getTitle() { return title; } 


=== Enum Relative Comparisons
Values are ordered
--First value is lowest
--Last value is highest

===Use compareTo for Enum relative comparison
- Returns negative, zero, or positive value
- Indicates current instance's ordering relative to another value

###
CrewMember geetha = new CrewMember(FlightCrewJob.PILOT, "Geetha");

CrewMember bob = new CrewMember(FlightCrewJob.FLIGHT_ATTENDANT, "Bob");

whoIsInCharge(geetha, bob);

void whoIsInCharge (CrewMember member1, CrewMember member2) {

CrewMember theBoss = member1.getJob().compareTo(member2.getJob()) > 0 ? member1: member2;

 System.out.println(theBoss.getName() + " is boss"); // Geetha is boss
}

====Common Enum Methods
values = Returns an array contain all values
valueOf = Returns the value that corresponds to a string (case sensitive)

======= Record
Simplifies creating data-only classes
-Declared using the record keyword 
-Created class is immutable

Automatically generates common code
-Constructor to initialize instance fields
-Getters for each instance field

#creating a record class
public record Passenger (String name, int checkedBags) { }

##instances of Passenger record class
Passenger p1 = new Passenger ("Bob", 2);
String n = p1.name();
int b = p1.checkedBags();

Passenger p2 = new Passenger("Maria", 1);
// compares all instance fields within p1 & p2
if (p1.equals(p2)) 
