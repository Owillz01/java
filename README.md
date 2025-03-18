<pre>                                                    


.......##....###....##.....##....###........#######...#######..########.
.......##...##.##...##.....##...##.##......##.....##.##.....##.##.....##
.......##..##...##..##.....##..##...##.....##.....##.##.....##.##.....##
.......##.##.....##.##.....##.##.....##....##.....##.##.....##.########.
.##....##.#########..##...##..#########....##.....##.##.....##.##.......
.##....##.##.....##...##.##...##.....##....##.....##.##.....##.##.......
..######..##.....##....###....##.....##.....#######...#######..##.......
                                                        

</pre>


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
    System.out.println(result);


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

it is the use of multiple versions of a method with same name or constructor within a class. Each method/constructors must have a unique signature
when using constructor overloading, and if there is a need to call a constructor inside another constructor, use the keyword `this` and ensure it's on the first line of the new constructor. 

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

- Classes can access an interface with the `implements` keyword.
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

## 17. Abstraction

Abstraction aims to hide complexity from users and show them only relevant information. it    
- helps avoid repetitive code
- Presents only the signature of internal functionality
- Gives flexibility to programmers to change the implementation of abstract behavior
- Partial abstraction can be achieved with abstract classes
- Total abstraction (100%) can be achieved with interfaces

### 17.1 Abstract classes

Abstract classes are defined with the `abstract` keyword. An abstract class is a parent class that cannot be instantiated. To create a new object, you need to instantiate one of its child classes. Abstract classes can have both abstract (contain only the method signature) and concrete (contains method body) methods.  
E.G  

    abstract  class  Animal  {
        // abstract methods
        abstract  void  move();
        abstract  void  eat();
        
        // concrete method
        void  label()  {
            System.out.println("Animal's data:");
        }
    }

inheriting from an abstract class

    class  Bird  extends Animal {
        void  move()  {
            System.out.println("Moves by flying.");
        }
        void  eat()  {
            System.out.println("Eats birdfood.");
        }
    }
Creating an instance of abstract class

    class  App  {
        public  static  void  main(String[] args)  {
            Animal myBird =  new Bird();
            myBird.label();
            myBird.move();
            myBird.eat();
        }
    }
### 17.2 More on interface

An interface is a 100% abstract class. its fields are static, final, and public by default and methods abstract. It’s frequently referred to as a blueprint of a class as well.  

E.G
    
    interface  Animal  {
        public  void  eat();
        public  void  sound();
    }

    interface  Bird  {
        //fields
        int numberOfLegs = 2;
        String outerCovering =  "feather";
        
        //abstract method
        public  void  fly();
    }

implementing multiple interfaces  

    class  Eagle  implements Animal, Bird {
        public  void  eat()  {
            System.out.println("Eats reptiles and amphibians.");
        }
        public  void  sound()  {
            System.out.println("Has a high-pitched whistling sound.");
        }
        public  void  fly()  {
            System.out.println("Flies up to 10,000 feet.");
        }
    }

creating instance
As static fields (numberOfLegs and outerCovering) don’t belong to a specific object/class instance but to the interface, we need to access them from the Bird interface.  

    class  TestEagleInterfaces  {
        public  static  void  main(String[] args)  {
            Eagle myEagle =  new Eagle();
            
            myEagle.eat();
            myEagle.sound();
            myEagle.fly();
            
            System.out.println("Number of legs: "  + Bird.numberOfLegs); //accessing static Bird interface fields
            System.out.println("Outer covering: "  + Bird.outerCovering); //accessing static Bird interface fields
        }
    }

## 18. Encapsulation

Encapsulation helps with data security, preventing data stored in a class from system-wide access. it safeguards the internal contents of a class like a capsule.  
- Fields are set to private
- Each field has a gpublic etter and setter method
- Getter methods return the field
- Setter methods let us change the value of the field

E.G

    class  Animal  {
        private String name;
        
        // Getter methods
        public String getName()  {
            return name;
        }
        
        // Setter methods
        public  void  setName(String name)  {
            this.name  = name;
        }
    }

    class  App  {
        public  static  void  main(String[] args)  {
            Animal myAnimal =  new Animal();
            myAnimal.setName("Eagle");
            System.out.println("Name: "  + myAnimal.getName());
        }
    }

## 19. Inheritance

Inheritance makes it possible to create a child class that inherits the fields and methods of the parent class. The child class can override the values and methods of the parent class if need be. It can also add new data and functionality to its parent.
- it uses the keyword `extend` to inherite properties
- Multi-level inheritance is allowed in Java (a child class can have its own child class as well)
- Multiple inheritances are not allowed in Java (a class can’t extend more than one class)

E.G

    class  Bird  {
        public String reproduction =  "egg";
        
        public  void  flyUp()  {
            System.out.println("Flying up...");
        }
        public  void  flyDown()  {
            System.out.println("Flying down...");
        }
    }

    //Eagle class inheriting the properties of bird
    class  Eagle  extends Bird {
        public String name =  "eagle";
        public  int lifespan = 15;
    }

    //calling eagle's inherited properties
    class  App  {
        public  static  void  main(String[] args)  {
            Eagle myEagle =  new Eagle();
            System.out.println("Name: "  + myEagle.name);  
            System.out.println("Reproduction: "  + myEagle.reproduction);
            System.out.println("Lifespan: "  + myEagle.lifespan);
            myEagle.flyUp();
            myEagle.flyDown();
        }
    }

## 20. Polymorphism

Polymorphism refers to the ability to perform a certain action in different ways. In Java, polymorphism can take two forms: method overloading (https://github.com/Owillz01/java#8-overloading) and method overriding.
- The same method name is used several times
- Static polymorphism in Java is implemented by method overloading
- Dynamic polymorphism in Java is implemented by method overriding

### 20.1. Static polymorphism (method overloading)
when performing method overlaoding, ensure that some parts of the method signatures (e.g  the number, names, or types of their parameters) are different.  

E.G

    class  Bird  {
        public  void  fly()  {
            System.out.println("The bird is flying.");
        }
        public  void  fly(int height)  {
            System.out.println("The bird is flying "  + height +  " feet high.");
        }
        public  void  fly(String name,  int height)  {
            System.out.println("The "  + name +  " is flying "  + height +  " feet high.");
        }
    }

    class  App  {
        public  static  void  main(String[] args)  {
            Bird myBird =  new Bird();
            myBird.fly();
            myBird.fly(10000);
            myBird.fly("eagle", 10000);
        }
    }

### 20.2 Dynamic polymorphism (method overriding)
Using the method overriding feature of Java, you can override the methods of a parent class from its child class.  

E.G

    class  Animal  {
        public  void  eat()  {
            System.out.println("This animal eats insects.");
        }
    }

    class  Bird  extends Animal {
        public  void  eat()  {
            System.out.println("This bird eats seeds.");
        }
    }

    class  App  {
        public  static  void  main(String[] args)  {
            Animal myAnimal =  new Animal();
            myAnimal.eat(); // This animal eats insects.
            Bird myBird =  new Bird();
            myBird.eat(); // This bird eats seeds.
        }
    }

## 21. Error Handling
We normally use the `try/catch` block to handle error/exception in our code. When using the `try/ctach` block, the `.getMessage()` and `.printStackTrace()` can be very useful for debugging. e.g.  

      
      try{...}catch(Exception ex) {
      System.out.print(ex.getMessage())
      System.out.print(printStackTrace())
    }

Exception is Java are of teo types. the CHECKED and UNCHECKED exceptions. Checked exceptions are the exceptions that occur during developement phase. `IOException` which is a type pf exception that occurs from input/output operations, is the parent class of all checked exceptions. every other error (e.g `FileNotFoundException`) class that inherits from the `IOException` falls under the checked exception.  Unchecked exceptions are exceptions that occur during runtime. `RuntimeException` is the parent class of unchecked exception ad every other error (e.g `ArithmeticException`) class that inherites from this class falls under the unchecked exception category. 
    
### 21.1 Automatic Clean up in java  
  clean up in java project is the act of writing so that it all resoruce leftover and other unwanted materials are cleared from memory and the filesystem. To implement cleanup in Java prgram, use the try with resource. e.g.
      
    '''
    // by calling the initialisation of BufferReader() within the bracket in try block, tell java to automatically handle the cleanup operation after execution. 
    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
    ...
    }catch (Exception ex){
      System.out.println("Error:" + ex.getMessage())
    }
    '''


  
<pre>
  
█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░███░░░░░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░███░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█
█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀░░███░░▄▀▄▀▄▀░░█░░▄▀░░░░░░░░░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░███░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█
█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░░░▄▀░░███░░░░▄▀░░░░█░░▄▀▄▀▄▀▄▀▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░███░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░░░░░▄▀░░░░░░█
█░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░████░░▄▀░░█████░░▄▀░░███░░▄▀░░░░░░▄▀░░██░░▄▀░░█░░▄▀░░█████████░░▄▀░░██░░▄▀░░███░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█████░░▄▀░░█████
█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░░░▄▀░░█████░░▄▀░░███░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀░░█████████░░▄▀░░░░░░▄▀░░░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█████░░▄▀░░█████
█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀░░█████░░▄▀░░███░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀░░██░░░░░░█░░▄▀▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█████░░▄▀░░█████
█░░░░░░░░░░▄▀░░█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░░░█████░░▄▀░░███░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█████░░▄▀░░█████
█████████░░▄▀░░█░░▄▀░░█████████░░▄▀░░██░░▄▀░░███████░░▄▀░░███░░▄▀░░██░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░████░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█████░░▄▀░░█████
█░░░░░░░░░░▄▀░░█░░▄▀░░█████████░░▄▀░░██░░▄▀░░░░░░█░░░░▄▀░░░░█░░▄▀░░██░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█████░░▄▀░░█████
█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░█████████░░▄▀░░██░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀░░█░░▄▀░░██░░░░░░░░░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█████░░▄▀░░█████
█░░░░░░░░░░░░░░█░░░░░░█████████░░░░░░██░░░░░░░░░░█░░░░░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█████░░░░░░█████
█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
</pre>


## 1. Spring Initializer
this is used for generating a boiler plate spring boot project.  
- goto start.spring.io
- Select the project type (gradle-groovy), language (java), spring boot version, project metadata, and packaging
- Click add dependencies to add any required dependencies. for creating a web application, add SPRING WEB dependency and JPA for database connection
- Click generate, open the generated project and start development

## 2. Application.properties file

This is used to setup the project configuration.
- to store all project logs in a single file, use `logging.file.name=PATH_TO_FILE_FOR_LOGS`
- to set a default port for the project, use `server.port=8000`

## 3. Controllers

this is a java file used for handling the application routes. to create a spring boot controller file, create a normal java class file and annotate it with `@RestController` just before the class declaration line.   
E.g

    @RestController
    public class MControllers {
        //@GetMapping, @PostMapping @DeleteMapping @PutMapping @PatchMapping are used to define the request method
        @GetMapping("/about_us") 
        public String aboutUsPage() {
            return "this is about us page!"
        }
    }

### 3.1 Controller Request Params

to use a request parameter in spring boot, use the `@RequestParam` e.g  

    //localhost:8000/sum?id=2&data="James"
    @GetMapping("/sum")
    public String sum(@RequestParam("id") int id, @RequestParam("data") String data){
      return "hello "+data+" your id is "+id;
    }

### 3.2 Controller Request Body

to use a request body in spring boot, use the `@RequestBody` within the function args. e.g  

    @PostMapping("/student/save")
    public Student createStudent(@RequestBody Student student) {
        //do something
    }
    
### 3.3 Creating a component (dependecy/constructor injection)

To create a spring boot companent file, annotate the file witj `@Component` e.g   


    @Component
    public class Service{
      public String getAboutUs(){
        return "this is the about us service";
      }
    }

    @RestController
    public class MyControllers {

        //constructor injection
        private final Service service;
        public MyControllers(Service service){
          this.service = service
        }
        @GetMapping("/about_us") 
        public String aboutUsPage() {
            return this.service.getAboutUs();
        }
    }

## 4. Serving Static HTML pages

to serve/return a static HTML page, defien the page int he static folder inside the resources folder and naviage to the path in your browser to view it. e.g cretaing an about_us_here.html file inside the static folder and navigating to localhost:8000/about_us_here to view the file content.

## 5. Adding Dependencies  

To add dependencies to your project after generaing it with spring boot,
- goto build.grade file
- under the dependencies object, past the required dependencies there e.g `implementation 'org.springframework.boot:spring-boot-starter-data-jpa'` `implementation 'com.mysql:mysql-connector-j'`

### 5.1 Adding and Configuring JPA database dependency

- after adding the required dependencies using `implementation 'org.springframework.boot:spring-boot-starter-data-jpa'` `implementation 'com.mysql:mysql-connector-j'`
- goto the application.properties file and add the following code below.

      spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE_NAME_HERE/createDatabaselfNotExist=true 
      spring.datasource.username-root 
      spring.datasource.password=root 
      spring.jpa.hibernate.ddl-auto-update

### 5.2 Creating Entity (database tables/fields)

the `@Entity` annotation is used to let spring boot know that the java class file is going to be a database table.   the `@Entity` file is used for creating the tablse while the  `@Repository` annotated interface file is used by apring boot for connecting to the created database table. E.G.   

      @Entity
    public class Student {
    
        @Id //tells spring boot to use this fieled as the primary key for the table.
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        @Column(unique = true, length = 1024) //sets the email column to be unique with a max character length of 1024
        private String email;
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    }


    // public interface StudentRepository extends JpaRepository<ENTITY_CLASS_NAME, ENTITY_CLASS_PK_TYPE>
    
    @Repository
    public interface StudentRepository extends JpaRepository<Student, Long> {

        //this will automatically generate the SQL query to find students email
        Student findByEmail(String email);
    
        @Query("SELECT s from Student s WHERE s.email LIKE %:domain")
        List<Student> findByDomain(@Param("domain") String domain);
    }


  Using the repository and entity files to insert data into the database

    public class StudentController {
    
        private final StudentRepository repository;
    
        public StudentController(StudentRepository repository) {
            this.repository = repository;
        }
    
        @PostMapping("/student/save")
        public Student createStudent() {
            Student student = new Student("Mark", "mark@email.com");
            return repository.save(student);
        }

        @PatchMapping("/student/update")
        public Student findStudent(@RequestParam("student_id") Long id, @RequestParam("new_email") String email) {

            //the Optional is used to avoid a NullPonterException in a case where the provided id is invalid.
            Optional<Student> student = repository.findById(id);
            if (student.isPresent()) {
                Student studentObj = student.get();
                studentObj.setEmail(email);
                return repository.save(studentObj);
            }
            return null;
        }
    
    }

  ### 5.3 Running custome SQL query

  to run custom sql query, use the `@Query` anontation keyword to construct your SQL query statment. e.g, to return database entries with a given email provider domain name, use the query below.   
  
     @Query("SELECT s from Student s WHERE s.email LIKE %:domain")
      List<Student> findByDomain(@Param("domain") String domain);

  `s.email LIKE %:domain` = return only students whose email address ends with the given domain name.  
  `@Param("domain")` =  is used to pass the domain value to spring data.   


  ### 6. Spring boot Actuator (health and performance metrics)

  - add `implementation 'org.springframework.boot:spring-boot-starter-actuator'` dependency to the `build.gradle` file
  - add `management.endpoints.web.exposure.include=health,info,metrics` and ` management.endpoint.health.show-details=always` to the application.properties file
  - visit your server domain /actuator to view the metrics. e.g `localhost:8000/actuator`
