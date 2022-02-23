package spring_boot.dao;

import org.springframework.stereotype.Repository;
import spring_boot.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("Select usr from User usr", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
//        entityManager.persist(user);
        entityManager.merge(user); //merge insert or update
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void deleteUserById(long id) {
//        User user = entityManager.find(User.class, id);
//        entityManager.remove(user);

        entityManager.createQuery("delete from User where id=:userid")
                .setParameter("userid",id)
                .executeUpdate();
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
