package com.example.autotests.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User{
    String fullName;
    String login;
    String password;
    String id;

    public static class UserBuilder {
        User user = new User();

        public UserBuilder setFullName (String fullName) {
            user.setFullName(fullName);
            return this;
        }
        public UserBuilder setId (String id) {
            user.setId(id);
            return this;
        }

        public UserBuilder setLogin (String login) {
            user.setLogin(login);
            return this;
        }

        public UserBuilder setPassword (String password) {
            user.setPassword(password);
            return this;
        }

        public User build () {
            return user;
        }
    }
}
