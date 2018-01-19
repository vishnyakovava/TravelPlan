package ru.netcracker.travelPlanner.dao;

import org.springframework.stereotype.Repository;
import ru.netcracker.travelPlanner.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Добавляем новую сущность в БД через объект EntityManager.
 * EntityManager создала фабрика EntutyManagerFactory, прописанная в AppConfig
 * Repository помечаем класс как Bean, нужен для спринга
 */
@Repository
public class UserDaoImp implements UserDao {

    /**
     * PersistenceContext  Автоматичесакое связывание менеджера сущностей с бином
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Добавление информации о пользователе в БД
     * @param user сущность, которую необходимо добавить в БД
     */
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
}
