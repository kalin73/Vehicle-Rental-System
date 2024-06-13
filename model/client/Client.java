package model.client;

public class Client {
    private String firstName;
    private String lastName;
    private int age;
    private int drivingExperience;

    public Client() {
    }

    public Client(String firstName, String lastName, int age, int drivingExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.drivingExperience = drivingExperience;
    }

    public String getFirstName() {
        return firstName;
    }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Client setAge(int age) {
        this.age = age;
        return this;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public Client setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
        return this;
    }
}
