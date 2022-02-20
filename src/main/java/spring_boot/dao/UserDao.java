package spring_boot.dao;

import spring_boot.entity.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void deleteUser(User user);
    public void deleteUserById(long id);
    public void updateUser(long id, User user);
    public User getUserById (long id);
    public List<User> getAllUsers();
}
