package com.logiston.services;


import com.logiston.entity.User;

public interface UserService {
    Iterable<User> listAllUsers();

    User getUserById(Long id);

    void saveUser(User user);

    User findUserByEmail(String email);

    void delete(Long id);

    void saveEditUser(User user);
}
