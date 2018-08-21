/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Member;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author James
 */
@Repository
public class MemberDaoOracleSqlImpl implements MemberDao {

    private SessionFactory sessionFactory;

    @Inject
    public MemberDaoOracleSqlImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addMember(Member member) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction tx = s.beginTransaction();
        s.save(member);
        tx.commit();
    }

    @Override
    public void deleteMember(int memberId) throws SIPersistenceException {
        Member member = getMemberByMemberId(memberId);
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.delete(member);
        t.commit();
    }

    @Override
    public void updateMember(Member member) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.update(member);
        t.commit();
    }

    @Override
    public Member getMemberByMemberId(int memberId) throws SIPersistenceException {
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

    @Override
    public List<Member> getAllMembers() throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from Member").list();
    }

}
