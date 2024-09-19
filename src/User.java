public class User extends Password{
    protected String firstName;
    protected String lastName;
    protected String department = "general";
    private static String company;
    private static int cnt = -1;  //set to -1 because of the "dummy" user
    private static int mailBoxCapicity;
    private static int maxMailCapacity = 4;


    public User(){}

    public User(String firstName, String lastName, String department) {
        if(mailBoxCapicity > maxMailCapacity) System.out.println("max email capacity reached, can not add more users");
        else{
            this.firstName = firstName;
            this.lastName = lastName;
            this.department = department;
            cnt++;
            mailBoxCapicity = cnt;
        }

    }

    public User(String firstName, String lastName) {
        if(mailBoxCapicity > maxMailCapacity) System.out.println("max email capacity reached, can not add more users");
        else{
            this.firstName = firstName;
            this.lastName = lastName;
            cnt++;
            mailBoxCapicity = cnt;
        }
    }

    public String generateEmail(){
        return (firstName+"."+lastName+"@"+department+"."+User.company+"."+"com");
    }

    public String generateEmail(boolean isAlternate){
        return isAlternate ? (this.lastName+"."+this.firstName+"@"+this.department+"."+User.company+"."+"alt") : (this.firstName+"."+this.lastName+"@"+this.department+"."+User.company+"."+"com");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getCompany() {
        return company;
    }

    public static void setCompany(String company) {
        User.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static int getMaxMailCapacity() {
        return maxMailCapacity;
    }

    public static void setMaxMailCapacity(int maxMailCapacity) {
        User.maxMailCapacity = maxMailCapacity;
    }

    public static int getMailBoxCapicity() {
        return mailBoxCapicity;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", passoword='" + super.password + '\'' +
                '}';
    }
}
