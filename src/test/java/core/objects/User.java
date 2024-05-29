package core.objects;

import lombok.Data;

@Data
public class User extends BaseObject {
    private String login;
    private String password;

    public User(String login) {
        this.login = login;
        setPassword();
    }

    enum Users {
        CORRECT ("VIDN-16763", "Olgathebest7"),
        ERROR ("FDGE", "DKLKFLS");
        private String login;
        private String password;

        Users(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

    }

    private void setPassword() {
        for(Users user:
        Users.values()) {
            user.getLogin().equals(this.login);
            this.password = user.getPassword();
            break;
        }
    }
}
