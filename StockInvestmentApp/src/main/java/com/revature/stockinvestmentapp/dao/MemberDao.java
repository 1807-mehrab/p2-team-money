/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.dao;

import com.revature.stockinvestmentapp.model.Member;
import com.revature.stockinvestmentapp.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//
//    public void addMember(Member member) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction tx = s.beginTransaction();
//        s.save(member);
//        tx.commit();
//    }
//
//    public void deleteMember(int memberId) {
//        Member member = getMemberByMemberId(memberId);
//        Session s = sessionFactory.getCurrentSession();
//        Transaction t = s.beginTransaction();
//        s.delete(member);
//        t.commit();
//    }
//
//    public void updateMember(Member member) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction t = s.beginTransaction();
//        s.update(member);
//        t.commit();
//    }
//
//    public Member getMemberByMemberId(int memberId) {
//        Member m = null;
//        List<Member> members = new ArrayList<Member>();
//        Session s = sessionFactory.getCurrentSession();
//        members = s.createQuery("from Member where member_id = :idVar")
//                .setInteger("idVar", memberId).list();
//        if (!members.isEmpty()) {
//            m = members.get(0);
//        }
//        return m;
//    }
//
//    public List<Member> getAllMembers() {
//        Session s = sessionFactory.getCurrentSession();
//        return s.createQuery("from Member").list();
//    }

}
