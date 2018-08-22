/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Member;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author James
 */
@Repository
public class MemberDaoOracleSqlImpl {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



  
    public void addMember(Member member) throws SIPersistenceException {

    public void addMember(Member member) {

        Session s = sessionFactory.getCurrentSession();
        Transaction tx = s.beginTransaction();
        s.save(member);
        tx.commit();
    }


   
    public void deleteMember(int memberId) throws SIPersistenceException {

    public void deleteMember(int memberId) {

        Member member = getMemberByMemberId(memberId);
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.delete(member);
        t.commit();
    }


   
    public void updateMember(Member member) throws SIPersistenceException {

    public void updateMember(Member member) {

        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.update(member);
        t.commit();
    }


    
    public Member getMemberByMemberId(int memberId) throws SIPersistenceException {

    public Member getMemberByMemberId(int memberId) {

        Member m = null;
        List<Member> members = new ArrayList<Member>();
        Session s = sessionFactory.getCurrentSession();
        members = s.createQuery("from Member where member_id = :idVar")
                .setInteger("idVar", memberId).list();
        if (!members.isEmpty()) {
            m = members.get(0);
        }
        return m;
    }


    
    public List<Member> getAllMembers() throws SIPersistenceException {

    public List<Member> getAllMembers() {

        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from Member").list();
    }

}
