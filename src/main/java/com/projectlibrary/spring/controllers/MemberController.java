package com.projectlibrary.spring.controllers;

import com.projectlibrary.spring.dtos.SimpleResponse;
import com.projectlibrary.spring.models.Member;
import com.projectlibrary.spring.services.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return memberService.getMembersByName(name);
        } else {
            return memberService.getAllMembers();
        }
    }

    @GetMapping("/{id}")
    public Member getMembersById(@PathVariable("id") String id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public SimpleResponse insertMember(@RequestBody Member member) {
        return memberService.insertMember(member);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateMember(@PathVariable("id") String id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteMember(@PathVariable("id") String id) {
        return memberService.deleteMember(id);
    }

//    @GetMapping("{memberId}/borrowings")
//    public List<Borrowing> getBorrowingList(@PathVariable("memberId") String memberId) {
//        return borrowingService.getBorrowingsByMemberId(memberId);
//    }
//
//    @PostMapping("{memberId}/book/{bookId}")
//    public SimpleResponse borrowBook(@PathVariable("memberId") String memberId, @PathVariable("bookId") int bookId) {
//        return borrowingService.borrowBook(memberId, bookId);
//    }
//
//    @PutMapping("{memberId}/book/{bookId}")
//    public SimpleResponse returnBook(@PathVariable("memberId") String memberId, @PathVariable("bookId") int bookId) {
//        return borrowingService.returnBook(memberId, bookId);
//    }

}