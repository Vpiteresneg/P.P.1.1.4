package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class Util {
    private static final String PASSWORD = "89928992";
    private static final String USERNAME = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/555";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static SessionFactory sessionFactory;//получаем наши обьекты. (пул значений)session обертка вокруг connection который работает с нашими сущностями, отслеживает полный жизненый цикл сущностей


    private Util() {

    }

    //открывает соединение и возвращает его
    public static Connection openConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);//
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        Configuration config = new Configuration();
        config.addAnnotatedClass(User.class);

        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/555");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "89928992");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");


        SessionFactory sessionFactory = config.buildSessionFactory();

        return sessionFactory;
    }


}




