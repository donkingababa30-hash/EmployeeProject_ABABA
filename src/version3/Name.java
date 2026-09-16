package version3;

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

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(", ").append(firstName);
        if (middleName != null && !middleName.isEmpty() && !middleName.equalsIgnoreCase("N/A")) {
            sb.append(" ").append(middleName.charAt(0)).append(".");
        }
        if (suffix != null && !suffix.isEmpty()) {
            sb.append(" ").append(suffix);
        }
        return sb.toString();
    }

    public void displayName() {
        System.out.println("Name: " + getFullName());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", suffix='").append(suffix).append('\'');
        sb.append(", fullName=").append(getFullName());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name other = (Name) obj;
        return safeEqualsIgnoreCase(firstName, other.firstName)
                && safeEqualsIgnoreCase(middleName, other.middleName)
                && safeEqualsIgnoreCase(lastName, other.lastName)
                && safeEqualsIgnoreCase(suffix, other.suffix);
    }

    private boolean safeEqualsIgnoreCase(String a, String b) {
        if (a == null) {
            return b == null;
        }
        return a.equalsIgnoreCase(b);
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
            throw new AssertionError("Name did not implement Cloneable", e);
        }
    }
}