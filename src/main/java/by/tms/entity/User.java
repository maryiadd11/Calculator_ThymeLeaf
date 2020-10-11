package by.tms.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
public class User {

    private static long idInc = 1;
    private long id = idInc++;

    @NotBlank
    private String name;

    @NotBlank
    @Length (min = 4, max = 8, message = "Login must be between 4 to 8 symbols")
    private String login;

    @NotBlank
    @Length (min = 6, max = 16, message = "Password must be between 6 to 16 symbols")
    private String password;


    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
