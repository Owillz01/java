public interface Rentable {
    public void rent(User username);
    public void dock(String station);
    public String getStation();
    public int getSerial();
    public boolean isBroken();
    public User getUser();
}
