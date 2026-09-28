package version6;

import java.util.Objects;

public final class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name(String firstName, String lastName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        validateRequired(firstName);
        validateRequired(lastName);
        this.firstName = firstName.trim();
        this.middleName = (middleName == null) ? "" : middleName.trim();
        this.lastName = lastName.trim();
        this.suffix = (suffix == null) ? "" : suffix.trim();
    }

    private static void validateRequired(String value){
        if(value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateRequired(firstName);
        this.firstName = firstName.trim();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = (middleName == null) ? "" : middleName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateRequired(lastName);
        this.lastName = lastName.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = (suffix == null) ? "" : suffix.trim();
    }

    public String getFullName(){
        StringBuilder sb = new StringBuilder();
        sb.append(lastName);
        sb.append(", ");
        sb.append(firstName);
        if(!middleName.isEmpty()){
            sb.append(" ");
            sb.append(middleName.charAt(0));
            sb.append(".");
        }
        if(!suffix.isEmpty()){
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