package project.bussineslayer.model;

import java.io.Serializable;

public class Administrator implements Serializable {

    private String username;
    private String password;

    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Administrator))
            return false;
        Administrator admin = (Administrator) obj;
        return ((admin.getUsername().equals(this.username) && (admin.getPassword().equals(this.password))));
    }

}
