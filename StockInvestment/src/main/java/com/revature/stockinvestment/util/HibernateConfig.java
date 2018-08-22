package com.revature.stockinvestment.util;

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

import com.revature.stockinvestment.dao.AccountDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.CompanyDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.MemberDao;
import com.revature.stockinvestment.dao.MemberDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.TransactionDaoOracleSqlImpl;
import com.revature.stockinvestment.service.AccountServiceLayerImpl;
import com.revature.stockinvestment.service.CompanyServiceLayerImpl;
import com.revature.stockinvestment.service.MemberServiceLayer;
import com.revature.stockinvestment.service.MemberServiceLayerImpl;
import com.revature.stockinvestment.service.TransactionServiceLayerImpl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.revature.stockinvestment")
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
		sessionFactory.setPackagesToScan(new String[] { "com.revature.stockinvestment" });
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
	
	
	//***********************/
	// Account
	//***********************/
	@Bean
	public AccountDaoOracleSqlImpl accountDaoOracleSqlImpl(SessionFactory sessionFactory) {
		AccountDaoOracleSqlImpl dao = new AccountDaoOracleSqlImpl();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
	
	@Bean
	public AccountServiceLayerImpl accountService(AccountDaoOracleSqlImpl accountDao) {
		AccountServiceLayerImpl as = new AccountServiceLayerImpl();
		as.setDao(accountDao);
		return as;
	}	
	
	//***********************/
	// Company
	//***********************/

	@Bean
	public CompanyDaoOracleSqlImpl companyDaoOracleSqlImpl(SessionFactory sessionFactory) {
		CompanyDaoOracleSqlImpl dao = new CompanyDaoOracleSqlImpl();
		dao.setSessionFactory(sessionFactory);

		return dao;
	}

	@Bean
	public CompanyServiceLayerImpl companyService(CompanyDaoOracleSqlImpl companyDao) {
		CompanyServiceLayerImpl cs = new CompanyServiceLayerImpl();
		cs.setDao(companyDao);
		return cs;
	}
		
	//***********************/
	// Member
	//***********************/
	@Bean
	public MemberDaoOracleSqlImpl memberDaoOracleSqlImpl(SessionFactory sessionFactory) {
		MemberDaoOracleSqlImpl dao = new MemberDaoOracleSqlImpl();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
	
	@Bean
	public MemberServiceLayerImpl memberService(MemberDaoOracleSqlImpl memberDao) {
		MemberServiceLayerImpl ms = new MemberServiceLayerImpl();
		ms.setDao(memberDao);
		return ms;
	}
	
	//***********************/
	// Transaction
	//***********************/
	@Bean
	public TransactionDaoOracleSqlImpl transactionDaoOracleSqlImpl(SessionFactory sessionFactory) {
		TransactionDaoOracleSqlImpl dao = new TransactionDaoOracleSqlImpl();
		dao.setSessionFactory(sessionFactory);
		return dao;
	}
	
	@Bean
	public TransactionServiceLayerImpl transactionService(TransactionDaoOracleSqlImpl transactionDao, AccountDaoOracleSqlImpl accountDao, CompanyDaoOracleSqlImpl companyDao) {
		TransactionServiceLayerImpl ts = new TransactionServiceLayerImpl();
		ts.setTDao(transactionDao);
		ts.setADao(accountDao);
		ts.setCDao(companyDao);
		return ts;
	}
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
