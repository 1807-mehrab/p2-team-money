/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.service;

import com.revature.stockinvestment.model.Member;
import java.util.List;

/**
 *
 * @author James
 */
public interface MemberServiceLayer { 
    
    public void addMember(Member member);
    
    public void deleteMember(int memberId);
    
    public void updateMember(Member member);
    
    public Member getMemberByMemberId(int memberId);
    
    public List<Member> getAllMembers();
    
}
