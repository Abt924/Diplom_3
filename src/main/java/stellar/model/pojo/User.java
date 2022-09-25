package stellar.model.pojo;

import lombok.Data;

@Data
public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Credentials getCredentials() {
        return new Credentials(email, password);
    }
}
