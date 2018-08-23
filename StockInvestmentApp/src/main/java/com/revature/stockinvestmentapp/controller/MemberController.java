/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestmentapp.controller;

import com.revature.stockinvestmentapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

//    @PostMapping("/member")
//    public void createMember(@Valid @RequestBody Member member) {
//        memberService.addMember(member);
//    }
//
//    @DeleteMapping("/member/{id}")
//    public void deleteMember(@PathVariable("id") int id) {
//        memberService.deleteMember(id);
//    }
//
//    @PutMapping("/member/{id}")
//    public void updateMember(@PathVariable("id") int id, @Valid @RequestBody Member member) {
//        memberService.updateMember(member);
//    }
//
//    @GetMapping("/member/{id}")
//    public Member getMemberByMemberId(@PathVariable("id") int id) {
//        return memberService.getMemberByMemberId(id);
//    }
//
//    @GetMapping("/members")
//    public List<Member> getAllMembers() {
//        return memberService.getAllMembers();
//    }

}
