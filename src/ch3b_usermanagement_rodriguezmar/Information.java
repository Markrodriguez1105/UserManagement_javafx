package ch3b_usermanagement_rodriguezmar;

public class Information {
    byte token;
    private int count, residentID;
    private String username, password, lastName, firstName, middleName;
    boolean status;
    
    public Information(int count, int residentID, String username, String password, String lastName, String firstName, String middleName, byte token, boolean status) {
        this.count = count;
        this.residentID = residentID;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.token = token;
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getResidentID() {
        return residentID;
    }

    public void setResidentID(int residentID) {
        this.residentID = residentID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
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

    public byte getToken() {
        return token;
    }

    public void setToken(byte token) {
        this.token = token;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
