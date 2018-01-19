package ru.netcracker.travelPlanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Класс конфигурации и создания фабрики(Factory) менеджеров сущностей(EntityManager)
 * Configuration аннотация для спринга, говорящая о том, что класс содержин настройки
 * EnableTransactionManagement отвечает за регистрацию компоненнтов спринг, которые отвечают
 * за обработку транзакций.
 * ComponentScans сканирует пакеты, на наличие Bean'ов
 */
@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("ru.netcracker.travelPlanner.dao"),
                          @ComponentScan("ru.netcracker.travelPlanner.service")})
public class AppConfig {

    /**
     * @return фабрику, которая создаёт объекты EntityManager, для управления сущностями
     *
     * factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE"); Получение настроек из файла
     * persistence.xml, раздела <persistence-unit name="LOCAL_PERSISTENCE">
     */
    @Bean
    public LocalEntityManagerFactoryBean getLocalEntityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
        return factoryBean;
    }

    /**
     * @return сервис транзакций
     */
    @Bean
    public JpaTransactionManager getJpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getLocalEntityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
