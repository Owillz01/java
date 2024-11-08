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
valueOf(enum_type) = Returns the value that corresponds to a string (case sensitive)
name() = returns the enum type 

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

===== looping through an Array

for(String fruit: fruits) { System.out.println(fruit); }


===== calling a constructor in a constructor
When calling a constructor within another constructor, use the keyword "this" and ensure it's on the first line of the new constructor. 

class Machine {

private String name;
private int code;

public Machine() {

this("Arnie", 0); //constructor calling

System.out.println("Constructor running!");
} 
public Machine (String name) {

this(name, 0); //constructor calling

System.out.println("Second constructor running");
}

public Machine (String name, int code) {
System.out.println("Third constructor running");
this.name = name;
this.code = code;
} }

===== useful Info
 all classes in Java have the Object class as their parent hence why you find some object methods like toString(), equals(), getClass() are inherited by every class instance.
- modify the toString() method of every class to log readable info (instead of java hash code info) as this can be used for debugging purpose.
##
public String toString() {
return "useful debugging information" }

===== Interface in Java
- Interfaces ensure that some defined methods are present in classes implementing the interface.
- a class can implement multiple interfaces.
- an interface can be used as the return type for a class implementing it. 

=== Defining an interface
public interface Info {
public void showInfo();
}

==== using an Interface
public class Machine implements Info {

private int id = 7;
public void start() { System.out.println("Machine started.");

//interface method
public void showInfo() {
 System.out.println("Machine ID is:)}

==== Access modifiers
public = accessible from anywhere
private = accessible only within the class
proctected = accessible within a child class or within the same package

==== Error handling
Surround your code in a try catch block to handle any type of exception.

#E.G
try {
test.run();
} catch (Exception e) {
e.printStackTrace();
}

====== ArrayList / LinkedList
- ArrayList and other List like LinkedList implements the List interface and thus can be defined as the returned data type. 
- if you want to add or remove item from the end of your list frequently, use ArrayList and if you want to add/remove from the beginning or middle of the list frequently, use LinkedList


import java.util.ArrayList
import java.util.LinkedList
import java.util.List

ArrayList<Integer> items = new ArrayList<Integer>() ;

items.add(value)= to add item to the list
items.add(index, value)= to add item at index
items.size() = to get the length of the array
items.get(index) = to get value at specific index
items.remove(index) = remove item

====== HashMap/LinkedHashMap
- Hash maps are not ordered. It's highly likely to return it's items in a random order
- Linked hash maps return items in the order they were added
- Tree Map return items in numerical or alphabetical order. 
- these maps implements Map interface and thus can be used as their return type. 

import java.util.HashMap/LinkedHashMap/TreeMap

HashMap<Integer, String> map = new HashMap/LinkedHashMap/TreeMap<Integer, String>();

map.put(key, value) = adds element to the map
map.get(key) = returns null or the value of the key

=== Looping through HashMap.

Method 1 ===
for (Map.Entry<Integer, String> entry: map.entrySet()){

int key = entry.getKey();
String value = entry.getValue();
System.out.println(key + ":" + value);
}

Method 2. ====
for (Integer key: map.keySet()) { 
String value = map.get(key);
} 

======== Set
- It stores only unique elements
- LinkedHashSet, TreeSet and HastSet are the three types of sets available.
- the order of these sets applies similar to map.
- they implement the Set interface and hence can be used as their return type

¶ check java doc for methods available under Set interface 
¶ learn how to implement equals and hashcode methods in your classes


import java.util.HashSet/TreeSet/LinkedHashSet;
import java.util.Set;

Set<String> set1= new HashSet/TreeSet/LinkedHashSet<String>();

set1.add(value) = add value to a set
set1.contains(value) = returns nothing or the value
set1.isEmpty() = checks if a set is empty
set1.size() = the length of the set
set1.retainAll(set2) = keeps items present both in set1 and set2
set1.removeAll(set2) = removes items present both in set1 and set2

====Looping through sets.
for (String element: set1) { System.out.println(element) }
