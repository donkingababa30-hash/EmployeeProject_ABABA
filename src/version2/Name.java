package version2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        StringBuilder sb = new StringBuilder();
        sb.append(firstName);
        if(middleName != null && !middleName.equals("N/A") && !middleName.isEmpty()){
            sb.append(" ");
            sb.append(middleName);
        }
        sb.append(" ");
        sb.append(lastName);
        return sb.toString();
    }

    public void displayName(){
        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", fullName=").append(getFullName());
        sb.append('}');
        return sb.toString();
    }
}