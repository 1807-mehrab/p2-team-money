/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Member;
import java.util.List;

/**
 *
 * @author James
 */
public interface MemberDao { 
    
    public void addMember(Member member) throws SIPersistenceException;
    
    public void deleteMember(int memberId) throws SIPersistenceException;
    
    public void updateMember(Member member) throws SIPersistenceException;
    
    public Member getMemberByMemberId(int memberId) throws SIPersistenceException;
    
    public List<Member> getAllMembers() throws SIPersistenceException;
    
}
