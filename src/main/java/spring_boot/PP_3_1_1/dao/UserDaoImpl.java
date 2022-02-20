package spring_boot.PP_3_1_1.dao;

import org.springframework.stereotype.Repository;
import spring_boot.PP_3_1_1.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> list = entityManager.createQuery("Select usr from User usr", User.class).getResultList();
        return list;
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(long id, User userUpdate) {
        User user = getUserById(id);
        System.out.println("UserDaoImpl");
        System.out.println(user.toString());
        user.setFirstname(userUpdate.getFirstname());
        user.setLastname(userUpdate.getLastname());
        user.setAge(userUpdate.getAge());
    }

}
