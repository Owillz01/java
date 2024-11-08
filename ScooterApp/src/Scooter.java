public class Scooter {
    private String station;
    private User user;
    private int serial;
    private int charge;
    private Boolean isBroken;
    public static int nextSerial = 1;

    public Scooter(String station){
        this.station = station;
        serial = Scooter.nextSerial;
        charge = 100;
        user = null;
        isBroken = false;
        Scooter.nextSerial += 1;
    }

    public void rent(User user){
        if(charge > 20 && !isBroken){
            setUser(user);
            setStation(null);
        }else{
            System.out.println("Currently unavailable for rent");
        }
    }

    public void dock(String station){
        setStation(station);
        setUser(null);
    }

    public String getStation() {
        return station;
    }

    public User getUser() {
        return user;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Scooter [");
        sb.append(serial);
        sb.append("]");
        return sb.toString();
    }

}
