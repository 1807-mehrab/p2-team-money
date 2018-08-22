/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.dao.MemberDaoOracleSqlImpl;
import com.revature.stockinvestment.model.Member;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author James
 */
@Service
public class MemberServiceLayerImpl /*implements MemberServiceLayer*/ { 

    @Autowired
    private MemberDaoOracleSqlImpl memberDao;
    
    
    public MemberServiceLayerImpl(MemberDaoOracleSqlImpl memberDao) {
        this.memberDao = memberDao;
    }
    
    //@Override
    public void addMember(Member member) {
        memberDao.addMember(member);
    }

    //@Override
    public void deleteMember(int memberId) {
        memberDao.deleteMember(memberId);
    }

    //@Override
    public void updateMember(Member member) {
        memberDao.updateMember(member);
    }

    //@Override
    public Member getMemberByMemberId(int memberId) {
        return memberDao.getMemberByMemberId(memberId);
    }

    //@Override
    public List<Member> getAllMembers() {
        return memberDao.getAllMembers();
    }
    
}
