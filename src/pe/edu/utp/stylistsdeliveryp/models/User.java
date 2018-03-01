package pe.edu.utp.stylistsdeliveryp.models;

import java.util.Date;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String email;
    private int dni;
    private String password;
    private UserType userType;
    private District district;

    public User() {
    }

    public User(int id, String firstName, String lastName, Date birthday, String email, int dni, String password, UserType userType, District district) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthday(birthday);
        this.setEmail(email);
        this.setDni(dni);
        this.setPassword(password);
        this.setUserType(userType);
        this.setDistrict(district);
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getDni() {
        return dni;
    }

    public User setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserType getUserType() {
        return userType;
    }

    public User setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public District getDistrict() {
        return district;
    }

    public User setDistrict(District district) {
        this.district = district;
        return this;
    }
}
