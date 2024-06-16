package model.client;

public class Client {
    private String firstName;
    private String lastName;
    private int age;
    private int drivingExperience;

    public Client() {
    }

    public Client(String firstName, String lastName, int age, int drivingExperience) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setDrivingExperience(drivingExperience);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be blank");
        }
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be blank");
        }
        this.lastName = lastName;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 16 || age > 100) {
            throw new IllegalArgumentException("Age must be between 16 and 100");
        }
        this.age = age;

    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        if (drivingExperience < 0 || drivingExperience > 84) {
            throw new IllegalArgumentException("Driving experience must be between 0 and 84");
        }
        this.drivingExperience = drivingExperience;

    }
}
