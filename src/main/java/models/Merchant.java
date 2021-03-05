package models;

public class Merchant {

    private String id;
    private String email;
    private String status;
    private String username;
    private String userGroup;


    public Merchant(String id, String username, String email, String status, String userGroup)  {
        this.id = id;
        this.email= email;
        this.status = status;
        this.username = username;
        this.userGroup = userGroup;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getUsername() {
        return username;
    }

    public String getEmailStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }
}
