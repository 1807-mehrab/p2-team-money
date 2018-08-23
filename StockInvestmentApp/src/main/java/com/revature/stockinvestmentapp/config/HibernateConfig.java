/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.config;

import com.revature.stockinvestmentapp.dao.AccountDao;
import com.revature.stockinvestmentapp.dao.CompanyDao;
import com.revature.stockinvestmentapp.dao.MemberDao;
import com.revature.stockinvestmentapp.dao.TransactionDao;
import com.revature.stockinvestmentapp.service.AccountService;
import com.revature.stockinvestmentapp.service.CompanyService;
import com.revature.stockinvestmentapp.service.MemberService;
import com.revature.stockinvestmentapp.service.TransactionService;
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
    public AccountDao accountDao(SessionFactory sessionFactory) {
        AccountDao accountDao = new AccountDao();
        accountDao.setSessionFactory(sessionFactory);
        return accountDao;
    }

    @Bean
    public AccountService accountService(AccountDao accountDao) {
        AccountService accountService = new AccountService();
        accountService.setAccountDao(accountDao);
        return accountService;
    }

    @Bean
    public CompanyDao companyDao(SessionFactory sessionFactory) {
        CompanyDao companyDao = new CompanyDao();
        companyDao.setSessionFactory(sessionFactory);
        return companyDao;
    }

    @Bean
    public CompanyService companyService(CompanyDao companyDao) {
        CompanyService companyService = new CompanyService();
        companyService.setCompanyDao(companyDao);
        return companyService;
    }

    @Bean
    public MemberDao memberDao(SessionFactory sessionFactory) {
        MemberDao memberDao = new MemberDao();
        memberDao.setSessionFactory(sessionFactory);
        return memberDao;
    }

    @Bean
    public MemberService memberService(MemberDao memberDao) {
        MemberService memberService = new MemberService();
        memberService.setMemberDao(memberDao);
        return memberService;
    }

    @Bean
    public TransactionDao transactionDao(SessionFactory sessionFactory) {
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.setSessionFactory(sessionFactory);
        return transactionDao;
    }

    @Bean
    public TransactionService transactionService(TransactionDao transactionDao) {
        TransactionService transactionService = new TransactionService();
        transactionService.setTransactionDao(transactionDao);
        return transactionService;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
