/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.service;

import com.revature.stockinvestmentapp.dao.MemberDao;
import com.revature.stockinvestmentapp.model.Member;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService { 

    @Autowired
    private MemberDao memberDao;
    
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
//    public void addMember(Member member) {
//        memberDao.addMember(member);
//    }
//
//    public void deleteMember(int memberId) {
//        memberDao.deleteMember(memberId);
//    }
//
//    public void updateMember(Member member) {
//        memberDao.updateMember(member);
//    }
//
//    public Member getMemberByMemberId(int memberId) {
//        return memberDao.getMemberByMemberId(memberId);
//    }
//
//    public List<Member> getAllMembers() {
//        return memberDao.getAllMembers();
//    }
    
}
