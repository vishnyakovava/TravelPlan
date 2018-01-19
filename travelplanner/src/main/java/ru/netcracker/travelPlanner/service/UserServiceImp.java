package ru.netcracker.travelPlanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.netcracker.travelPlanner.dao.UserDao;
import ru.netcracker.travelPlanner.entities.User;

/**
 * Сервис, позволяющий работать через класс DAO(DataAccessObject), который добавляет
 * сущность в БД
 * Service помечаем класс как Bean, нужен для спинга
 */
@Service
public class UserServiceImp implements UserService {

    /**
     * Autowired  Автоматическая инъекция значения Spring'ом (Spring сам найдёт нужный Bean)
     */
    @Autowired
    private UserDao userDao;

    /**
     * @param user Добавление пользователя, через метод класса DAO(DataAccessObject)
     * Transactional  Откат всех записей к предыдущему значению, если любая операция метода завершится неудачно.
     */
    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }
}
