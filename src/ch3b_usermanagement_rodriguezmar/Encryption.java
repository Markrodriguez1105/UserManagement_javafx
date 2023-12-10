package ch3b_usermanagement_rodriguezmar;

public class Encryption {

    public String DecryptionToken(byte token) {
        switch (token) {
            case 1:
                return "RESIDENT";
            case 2:
                return "ADMIN";
            default:
                return "INVALID";
        }
    }
    
    public String DecryptionStatus(boolean status) {
        if (status) {
            return "ACTIVE";
        }else {
            return "INACTIVE";
        }
    }
    
    public byte ecryptionToken(String token) {
        return switch (token) {
            case "RESIDENT" -> 1;
            case "ADMIN" -> 2;
            default -> 0;
        };
    }
    
    public boolean ecryptionStatus(String status) {
        return switch (status) {
            case "ACTIVE" -> true;
            case "INACTIVE" -> false;
            default -> false;
        };
    }
}
