package by.tms.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AuthorizedUser {

    private static long idInc = 1;
    private long id = idInc++;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    public AuthorizedUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthorizedUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
