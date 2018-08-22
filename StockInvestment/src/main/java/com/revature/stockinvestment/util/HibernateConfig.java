package com.revature.stockinvestment.util;

import com.revature.stockinvestment.dao.AccountDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.CompanyDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.MemberDaoOracleSqlImpl;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.stockinvestment.dao.TransactionDaoOracleSqlImpl;
import com.revature.stockinvestment.service.AccountServiceLayerImpl;
import com.revature.stockinvestment.service.CompanyServiceLayerImpl;
import com.revature.stockinvestment.service.MemberServiceLayerImpl;
import com.revature.stockinvestment.service.TransactionServiceLayerImpl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.revature")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    @Bean
    public DataSource myDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.revature"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
            }
        };
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager tm = new HibernateTransactionManager();
        tm.setSessionFactory(sessionFactory);
        return tm;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }

    @Bean
    public AccountDaoOracleSqlImpl accountDaoOracleSqlImpl(SessionFactory sessionFactory) {
        AccountDaoOracleSqlImpl accountDao = new AccountDaoOracleSqlImpl();
        accountDao.setSessionFactory(sessionFactory);
        return accountDao;
    }

    @Bean
    public AccountServiceLayerImpl accountService(AccountDaoOracleSqlImpl accountDao) {
        AccountServiceLayerImpl accountService = new AccountServiceLayerImpl();
        accountService.setAccountDao(accountDao);
        return accountService;
    }

    @Bean
    public CompanyDaoOracleSqlImpl companyDaoOracleSqlImpl(SessionFactory sessionFactory) {
        CompanyDaoOracleSqlImpl companyDao = new CompanyDaoOracleSqlImpl();
        companyDao.setSessionFactory(sessionFactory);
        return companyDao;
    }

    @Bean
    public CompanyServiceLayerImpl companyService(CompanyDaoOracleSqlImpl companyDao) {
        CompanyServiceLayerImpl companyService = new CompanyServiceLayerImpl();
        companyService.setCompanyDao(companyDao);
        return companyService;
    }

    @Bean
    public MemberDaoOracleSqlImpl memberDaoOracleSqlImpl(SessionFactory sessionFactory) {
        MemberDaoOracleSqlImpl memberDao = new MemberDaoOracleSqlImpl();
        memberDao.setSessionFactory(sessionFactory);
        return memberDao;
    }

    @Bean
    public MemberServiceLayerImpl memberService(MemberDaoOracleSqlImpl memberDao) {
        MemberServiceLayerImpl memberService = new MemberServiceLayerImpl();
        memberService.setMemberDao(memberDao);
        return memberService;
    }

    @Bean
    public TransactionDaoOracleSqlImpl transactionDaoOracleSqlImpl(SessionFactory sessionFactory) {
        TransactionDaoOracleSqlImpl transactionDao = new TransactionDaoOracleSqlImpl();
        transactionDao.setSessionFactory(sessionFactory);
        return transactionDao;
    }

    @Bean
    public TransactionServiceLayerImpl transactionService(TransactionDaoOracleSqlImpl transactionDao) {
        TransactionServiceLayerImpl transactionService = new TransactionServiceLayerImpl();
        transactionService.setTransactionDao(transactionDao);
        return transactionService;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
