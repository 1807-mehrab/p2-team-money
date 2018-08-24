/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.stockinvestment.dao.MemberDaoOracleSqlImpl;
import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Member;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author James
 */
@Service
public class MemberServiceLayerImpl { //implements MemberServiceLayer { 
	
	@Autowired
    private MemberDaoOracleSqlImpl memberDao;

    public void setDao(MemberDaoOracleSqlImpl dao) {
        this.memberDao = dao;
    }

    public void addMember(Member member) throws SIPersistenceException {
        memberDao.addMember(member);
    }

    public void deleteMember(int memberId) throws SIPersistenceException {
        memberDao.deleteMember(memberId);
    }

    public void updateMember(Member member) throws SIPersistenceException {
        memberDao.updateMember(member);
    }

    public Member getMemberByMemberId(int memberId) throws SIPersistenceException {
        return memberDao.getMemberByMemberId(memberId);
    }

    public List<Member> getAllMembers() throws SIPersistenceException {
        return memberDao.getAllMembers();
    }

}
