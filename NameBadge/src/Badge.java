public class Badge {
    private String name;

    private String jobTitle;
    private String contact;
    public Badge(String name, String jobTitle, String contact){
        this.name = name;
        this.jobTitle = jobTitle;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public String getContact() {
        return contact;
    }
    
}
