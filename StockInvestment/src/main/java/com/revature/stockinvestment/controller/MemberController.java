package com.revature.stockinvestment.controller;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Member;
import com.revature.stockinvestment.service.MemberServiceLayer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private MemberServiceLayer memberServiceLayer;

    @Inject
    public MemberController(MemberServiceLayer memberServiceLayer) {
        this.memberServiceLayer = memberServiceLayer;
    }

    @PostMapping("/member")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMember(@Valid @RequestBody Member member) {
        try {
            memberServiceLayer.addMember(member);
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @DeleteMapping("/member/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable("id") int id) {
        try {
            memberServiceLayer.deleteMember(id);
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @PutMapping("/member/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMember(@PathVariable("id") int id, @Valid @RequestBody Member member) {
        try {
            memberServiceLayer.updateMember(member);
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @GetMapping("/member/{id}")
    public Member getMemberByMemberId(@PathVariable("id") int id) {
        Member member = null;
        try {
            member = memberServiceLayer.getMemberByMemberId(id);
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
        return member;
    }
    
    @GetMapping("/members")
    public List<Member> getAllMembers() {
        List<Member> memberList = new ArrayList<>();
        try {
            memberList = memberServiceLayer.getAllMembers();
        } catch (SIPersistenceException e) {
            System.out.println(e.getMessage());
        }
        return memberList;
    }
}
