public class App {
    public static void main(String[] args) throws Exception {
        String username = "owillz";
        String password = "1234567";
        String station = "glasgow";
        ScooterApp app = new ScooterApp();
        app.registerUser(username, password, 18);
        app.loginUser(username, password);
        app.logoutUser(username);
        app.createScooter(station);
        Scooter scooter = app.getScooter(station, 0);
        app.rentScooter(scooter, username);
        app.dockScooter(scooter, station);
    }
}
