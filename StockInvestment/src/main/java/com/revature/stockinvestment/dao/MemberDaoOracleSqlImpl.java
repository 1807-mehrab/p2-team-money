/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

import com.revature.stockinvestment.model.Member;
import com.revature.stockinvestment.util.ConnectionUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
/*
    private static final String SQL_INSERT_MEMBER 
            = "INSERT INTO MEMBER (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) "
            + "VALUES (?, ?, ?, ?)";
    
    private static final String SQL_DELETE_MEMBER  
            = "DELETE FROM MEMBER "
            + "WHERE MEMBER_ID = ?"; 
    
    private static final String SQL_UPDATE_MEMBER  
            = "UPDATE MEMBER "
            + "SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ? , PASSWORD = ? "
            + "WHERE MEMBER_ID = ?";
    
    private static final String SQL_SELECT_MEMBER_BY_MEMBER_ID 
            = "SELECT MEMBER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD "
            + "FROM MEMBER "
            + "WHERE MEMBER_ID = ?";
    
    private static final String SQL_SELECT_ALL_MEMBERS 
            = "SELECT MEMBER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD "
            + "FROM MEMBER";
*/
	
    //***************************************
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//***************************************
    
    @Override
    public void addMember(Member member) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction tx = s.beginTransaction();
        s.save(member);
        tx.commit();


    	
    	/*PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_INSERT_MEMBER);
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getPassword());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not write to db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }*/
    }

    @Override
    public void deleteMember(int memberId) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.delete(member);
        t.commit();
    	
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_DELETE_MEMBER);
            ps.setInt(1, memberId);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not write to db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }*/
    }

    @Override
    public void updateMember(Member member) throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        Transaction t = s.beginTransaction();
        s.update(member);
        t.commit();
        
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_UPDATE_MEMBER);
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getPassword());
            ps.setInt(5, member.getMemberId());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not write to db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }*/
    }

    @Override
    public Member getMemberByMemberId(int memberId) throws SIPersistenceException {
        Member m = null;
        List<Member> members = new ArrayList<Member>();
        Session s = sessionFactory.getCurrentSession();
        members = s.createQuery("from Member where member_id = :idVar")
        		.setInteger("idVar", memberId).list();
        if(!members.isEmpty()) {
        	m = members.get(0);
        }
        return m;
        
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;
        Member member = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_MEMBER_BY_MEMBER_ID);
            ps.setInt(1, memberId);
            rs = ps.executeQuery();
            while (rs.next()) {
                member = new Member();
                member.setMemberId(rs.getInt("MEMBER_ID"));
                member.setFirstName(rs.getString("FIRST_NAME"));
                member.setLastName(rs.getString("LAST_NAME"));
                member.setEmail(rs.getString("EMAIL"));
                member.setPassword(rs.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not read from db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }
        return member;*/
    }

    @Override
    public List<Member> getAllMembers() throws SIPersistenceException {
        Session s = sessionFactory.getCurrentSession();
        return s.createQuery("from Member").list();
             		
    	/*
    	PreparedStatement ps = null;
        ResultSet rs = null;
        Member member = null;
        List<Member> members = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            ps = conn.prepareStatement(SQL_SELECT_ALL_MEMBERS);
            rs = ps.executeQuery();
            while (rs.next()) {
                member = new Member();
                member.setMemberId(rs.getInt("MEMBER_ID"));
                member.setFirstName(rs.getString("FIRST_NAME"));
                member.setLastName(rs.getString("LAST_NAME"));
                member.setEmail(rs.getString("EMAIL"));
                member.setPassword(rs.getString("PASSWORD"));
                members.add(member);
            }
        } catch (SQLException e) {
            throw new SIPersistenceException("Could not connect to db.", e);
        } catch (IOException e) {
            throw new SIPersistenceException("Could not read from db.", e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new SIPersistenceException("Could not close db.", e);
            }
        }
        return members;
        */
    }
    
}
