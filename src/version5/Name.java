package version5;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
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

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFullName(){
        StringBuilder sb = new StringBuilder();
        sb.append(lastName);
        sb.append(", ");
        sb.append(firstName);
        if(middleName != null && !middleName.isEmpty() && !middleName.equalsIgnoreCase("N/A")){
            sb.append(" ");
            sb.append(middleName.charAt(0));
            sb.append(".");
        }
        if(suffix != null && !suffix.isEmpty()){
            sb.append(" ");
            sb.append(suffix);
        }
        return sb.toString();
    }

    public void displayName(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getFullName());
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        return getFullName();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Name other = (Name) obj;
        return firstName.equalsIgnoreCase(other.firstName) &&
                middleName.equalsIgnoreCase(other.middleName) &&
                lastName.equalsIgnoreCase(other.lastName) &&
                suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}