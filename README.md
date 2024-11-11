# JAVA OOP

## 1. To declear a constant in Java, use the word final e.g final int name = 'Godswill';

  let num = 2
  system.out.println(num++) // _prints 2 then increase num by 1_
  system.out.println(++num) _//increase num by 1 then prints 3_
  system.out.println(num+=1) _//increase num by 1 then prints 3_

## 2. type casting: to cast a value from one type to another, wrap the other type in a bracket 

  `int num = (int) 5.2 - 4`

## 3. for Each loop

 ` for(int item:items) {...}`

## 4. Strings in Java

- To define a string value, use double quotes
- comparing string values use equals() or intern()

  e.g
  if(val1.equals(val2)){...} or val3 = val1.intern(), 
  val4 = val2.intern()
  if(val3 == val4) {...} 

- converting values to Strings 
- String.valuesOf(100) //converts 100 to string
- String val = 100 + "!" // stores "100!" in val

### 4.1 String interpolation

    String first = "Interpolation";
    String second = "Java";
    String result = String.format("String %1$s in %2$s with some %2$s examples.", first, second);


## 5. constructor chaining/passing values between constructors 

    public class ClassName{
      
        public ClassName(int age){
        this.age = age;
      } 

        public ClassName(int age, String dob){
          this(age);
        this.dob = dob;
      }
    } 

## 6. Static Members 

Static members of a class are not tied to a class instance, but to the class itself. Think of them like a global variable that's exist outside/above a given class instance .  
Static methods can only access other static members, they can't access instance members

### 6.1 Declearing static member in java
  
  `private static int num1 = 0;`

### 6.2 Static imports

To import multiple static members from a class, use

  `import static com.packageName.ClassName.*`   
  _The use of * tell Java to import all static members_

## 7. String builder

    StringBuilder build = new StringBuilder();
    build.append(add content...);
    build.append(...in here);
    build.toString();

## 8. Overloading

it is the use of multiple versions of a method or constructor within a class. Each method/constructors must have a unique signature
when using constructor overloading, and there is a need to call a constructor inside another constructor, use the keyword `this` and ensure it's on the first line of the new constructor. 

    class Machine {
      private String name;
      private int code;

      public Machine() {

        this("Arnie", 0); _//constructor calling_
        System.out.println("Constructor running!");
      } 

      public Machine (String name) {
        this(name, 0); _//constructor calling_
        System.out.println("Second constructor running");
      }

      public Machine (String name, int code) {
      System.out.println("Third constructor running");
      this.name = name;
      this.code = code;
      } 
    }

### 8.1 Parts of the signature are 

- Method name
- Number of parameters
- Type of each parameter

## 9. Object class

all classes in Java have the Object class as their parent hence why you find some object methods like `toString()`, `equals()`, `getClass()` are inherited by every class instance.
- Root class of the Java class hierarchy
- Object reference can reference an instance of any class
- Every class has Object characteristics
- **useful Info**
-- modify the `toString()` method of every class to log readable info (instead of java hash code info) as this can be used for debugging purpose.

    public String toString() {
    return "useful debugging information" 
    }

## 10. UNDERSTANDING ENUM

    public enum FlightCrewJob {
    FLIGHT_ATTENDANT,
    COPILOT,
    PILOT
    }

### 10.1 Enumeration Types are:
- Useful for defining a type with a finite list of valid values
- Declare using the enum keyword 
- Provide comma-separated value list
- By convention value names are all upper case 
- Enums can have a constructor, method and field because they are Java classes. 
- Each list item of an Enum type is an instance of that Enum. i.e PILOT is a new instance of FlightCrewJob


    public enum FlightCrewJob {

      _//declare Enum types with title passed to each constructor _
      FLIGHT_ATTENDANT ("Flight Attendant"), COPILOT("First Officer"), 
      PILOT("Captain"); 

      private String title; //Enum field

      _//Enum Constructor _
      private FlightCrewJob(String title) {
        this.title = title; 
      } 
      _//Enum Method_
      public String getTitle() { return title; } 
    }


### 10.2 Enum Relative Comparisons

Values are ordered
- First value is lowest
- Last value is highest

Use `compareTo()` for Enum relative comparison
- Returns negative, zero, or positive value
- Indicates current instance's ordering relative to another value
    
    CrewMember geetha = new CrewMember(FlightCrewJob.PILOT, "Geetha");
    CrewMember bob = new CrewMember(FlightCrewJob.FLIGHT_ATTENDANT, "Bob");

    whoIsInCharge(geetha, bob);

    void whoIsInCharge (CrewMember member1, CrewMember member2) {
      CrewMember theBoss = member1.getJob().compareTo(member2.getJob()) > 0 ? member1: member2;
      System.out.println(theBoss.getName() + " is boss"); _// Geetha is boss_
    }

### 10.3 Common Enum Methods

`values()` = Returns an array contain all values
`valueOf()` = Returns the value that corresponds to a string **(case sensitive)**

## 10.4 Record

- Simplifies creating data-only classes
- Declared using the record keyword 
- Created class is immutable
- Automatically generates common code
-- Constructor to initialize instance fields
-- Getters for each instance field

    _creating a record class_
    public record Passenger (String name, int checkedBags) { }

    _instances of Passenger record class_
    Passenger p1 = new Passenger ("Bob", 2);
    String n = p1.name();
    int b = p1.checkedBags();

    Passenger p2 = new Passenger("Maria", 1);
    _//compares all instance fields within p1 & p2_
    if (p1.equals(p2)) 



## 11. Interface in Java
- Interfaces ensure that some defined methods are present in classes implementing the interface.
- a class can implement multiple interfaces.
- an interface can be used as the return type for a class implementing it. 

    _//Defining an interface_
    public interface Info {
      public void showInfo();
    }

    _//using an Interface_
    public class Machine implements Info {

      private int id = 7;
      public void start() { System.out.println("Machine started.");

      //interface method
      public void showInfo() {
        System.out.println("Machine ID is:)}
      }
    }

## 12. Access modifiers
- `public` = accessible from anywhere
- `private` = accessible only within the class
- `proctected` = accessible within a child class or within the same package

## 13. Error handling
Surround your code in a try catch block to handle any type of exception.

    try {
      test.run();
    } catch (Exception e) {
      e.printStackTrace();
    }

## 14. ArrayList / LinkedList
- ArrayList and other List like LinkedList implements the `List` interface and thus can be defined as the returned data type. 
- if you want to add or remove item from the end of your list frequently, use `ArrayList` and if you want to add/remove from the beginning or middle of the list frequently, use `LinkedList`

   ` import java.util.ArrayList`  
    `import java.util.LinkedList`  
    `import java.util.List`  
    `ArrayList<Integer> items = new ArrayList<Integer>();`

`items.add(value)` = to add item to the list  
`items.add(index, value)` = to add item at index  
`items.size()` = to get the length of the array  
`items.get(index)` = to get value at specific index  
`items.remove(index)` = removes item  

## 15. HashMap/LinkedHashMap
- Hash maps are not ordered. It's highly likely to return it's items in a random order
- `LinkedHashMaps` return items in the order they were added
- `TreeMap` return items in numerical or alphabetical order. 
- these maps implements `Map` interface and thus can be used as their return type. 

    `import java.util.HashMap/LinkedHashMap/TreeMap`
    `HashMap<Integer, String> map = new HashMap/LinkedHashMap/TreeMap<Integer, String>();`

`map.put(key, value)` = adds element to the map  
`map.get(key)` = returns null or the value of the key  
`map.remove(key)` = removes the specified key-value   
`map.putIfAbsent(key, value)` = adds the value if not already in the map  
`map.containsKey(key)` = check if the LinkedHashMap contains the specified key  
`map.containsValue(value)` = check if the LinkedHashMap contains the specified value  

## 15.1 Looping through HashMap.

    _//Method 1_
    for (Map.Entry<Integer, String> entry: map.entrySet()){
      int key = entry.getKey();
      String value = entry.getValue();
      System.out.println(key + ":" + value);
    }

    _//Method 2._
    for (Integer key: map.keySet()) { 
      String value = map.get(key);
    } 

## 16. Set

- It stores only unique elements
- `LinkedHashSet`, `TreeSet` and `HashSet` are the three types of sets available.
- the ordering in these sets applies similar to map.
- they implement the `Set` interface and hence can be used as their return type

*¶ check java doc for methods available under Set interface *
*¶ learn how to implement equals and hashcode methods in your classes*

    import java.util.HashSet/TreeSet/LinkedHashSet;
    import java.util.Set;

    Set<String> set1= new HashSet/TreeSet/LinkedHashSet<String>();

`set1.add(value)` = add value to a set  
`set1.contains(value)` = returns nothing or the value  
`set1.isEmpty()` = checks if a set is empty  
`set1.size()` = the length of the set  
`set1.retainAll(set2)` = keeps items present both in set1 and set2  
`set1.removeAll(set2)` = removes items present both in set1 and set2  

### 16.1 Looping through sets.
  `for (String element: set1) { System.out.println(element) }`
