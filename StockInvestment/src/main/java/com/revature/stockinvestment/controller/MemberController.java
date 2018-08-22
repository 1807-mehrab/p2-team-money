package com.revature.stockinvestment.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockinvestment.dao.SIPersistenceException;
import com.revature.stockinvestment.model.Member;
import com.revature.stockinvestment.service.MemberServiceLayerImpl;

@RestController
public class MemberController {
	
	@Autowired
    private MemberServiceLayerImpl memberServiceLayer;

    @Inject
    public MemberController(MemberServiceLayerImpl memberServiceLayer) {
        this.memberServiceLayer = memberServiceLayer;
    }

    @PostMapping("/member")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMember(@Valid @RequestBody Member member) throws SIPersistenceException {
        memberServiceLayer.addMember(member);
    }

    @DeleteMapping("/member/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable("id") int id) throws SIPersistenceException {
        memberServiceLayer.deleteMember(id);
    }

    @PutMapping("/member/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMember(@PathVariable("id") int id, @Valid @RequestBody Member member) throws SIPersistenceException {
        memberServiceLayer.updateMember(member);
    }

    @GetMapping("/member/{id}")
    public Member getMemberByMemberId(@PathVariable("id") int id) throws SIPersistenceException {
        return memberServiceLayer.getMemberByMemberId(id);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() throws SIPersistenceException {
        return memberServiceLayer.getAllMembers();
    }
    
}
