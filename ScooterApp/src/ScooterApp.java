import java.util.ArrayList;
import java.util.HashMap;

public class ScooterApp {

    private HashMap<String, ArrayList<Rentable>> stations = new HashMap<>();
    private HashMap<String, User> registeredUsers  = new HashMap<>();

    public ScooterApp(){
        stations.put("glasgow", new ArrayList<>());
        stations.put("edinburg", new ArrayList<>());
        stations.put("aberdeen", new ArrayList<>());
    }

    public void registerUser(String username, String password, int age){
        if (age >= 18 && !registeredUsers.containsKey(username)) {
            User user = new User(username, password, age);
            System.out.println(user);
            registeredUsers.put(username, user);
            System.out.println("User has been registered");
            // return user;
        }else if (registeredUsers.containsKey(username)) {
            throw new RuntimeException("User already registered!");
        }else{
            throw new RuntimeException("too young to register!");
        }
    }

    public void loginUser(String userName, String password){
        User user = getUser(userName);
        System.out.println(user.getPassword());
        System.out.println(password);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Username or password is incorrect");
        }
        user.login(password);
        System.out.println("User successfully logged in!");
    }

    public void logoutUser(String userName){
        User user = getUser(userName);

        if(user.getLoggedIn()){
            user.logout();
        }else{
            throw new RuntimeException("no such user is logged in");
        }
    }

    public void createScooter(String station){
        try {
            if(stations.containsKey(station)){
              Rentable scooter = new Scooter(station);
              stations.get(station).add(scooter);
               System.out.println("created new scooter");
            }else{
              throw new RuntimeException("station does not exist");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error "+e);
        }
  }

  public void dockVehicle(Rentable scooter, String station){

    if(!stations.containsKey(station)){
     throw new RuntimeException("station does not exist");
    }
    else if(scooter.getStation() != null){
      throw new RuntimeException("scooter already at station");
    }else{
          stations.get(station).add(scooter);
          scooter.dock(station);
          System.out.println(scooter.toString()+" Successfully Docked!");
    }
  }

   public void rentVehicle(Rentable scooter, String userName){
    if(scooter.getUser() != null){
      throw new RuntimeException("scooter already rented");
    }else{
        int index = stations.get(scooter.getStation()).indexOf(scooter);
        User user = getUser(userName);
        stations.get(scooter.getStation()).remove(index);
        scooter.rent(user);
        System.out.println(scooter.toString()+" Successfully rented");
    }
  }

  public Rentable getScooter(String station, int index){
    try {
        if (index < stations.get(station).size()) {
            Rentable scooter = stations.get(station).get(index);
            return scooter;
        }else{

            return null;
        }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
    }
  }

    public User getUser(String userNamee){
        return registeredUsers.get(userNamee);
    }

    // public Scooter getScooter(String )

    @Override
    public String toString() {
        return "ScooterApp []";
    }

}
