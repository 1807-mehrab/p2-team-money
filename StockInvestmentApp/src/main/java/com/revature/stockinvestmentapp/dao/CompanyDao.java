/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public void addCompany(Company company) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction t = s.beginTransaction();
//        s.save(company);
//        t.commit();
//    }
//
//    public void deleteCompany(int companyId) {
//        Company company = getCompanyByCompanyId(companyId);
//        Session s = sessionFactory.getCurrentSession();
//        Transaction t = s.beginTransaction();
//        s.delete(company);
//        t.commit();
//    }
//
//    public void updateCompany(Company company) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction t = s.beginTransaction();
//        s.save(company);
//        t.commit();
//    }

//    public Company getCompanyByCompanyId(int companyId) {
//        Company c = null;
//        //List<Company> companies = new ArrayList<Company>();
//        Session s = sessionFactory.getCurrentSession();
//
//        companies = s.createQuery("from Company where company_id = :cId")
//                .setInteger("cId", companyId).list();
//
//        if (!companies.isEmpty()) {
//            c = companies.get(0);
//        }
//
//        return c;
//    }

//    public List<Company> getAllCompanies() {
//        Session s = sessionFactory.getCurrentSession();
//        return s.createQuery("from company").list();
//    }
}
