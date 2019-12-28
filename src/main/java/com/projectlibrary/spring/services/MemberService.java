package com.projectlibrary.spring.services;

import com.projectlibrary.spring.dtos.SimpleResponse;
import com.projectlibrary.spring.models.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private List<Member> members;

    public MemberService() {
        members = new ArrayList<>();
    }

    public List<Member> getAllMembers() {
        return this.members;
    }

    public Member getMemberById(String id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(id)) {
                return members.get(i);
            }
        }

        return null;
    }

    public List<Member> getMembersByName(String name) {
        List<Member> result = new ArrayList<>();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().contains(name)) {
                result.add(members.get(i));
            }
        }

        return result;
    }

    public SimpleResponse insertMember(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(member.getId())) {
                // 이미 존재하는 id면 -1 반환
                return SimpleResponse.FAIL;
            }
        }

        members.add(member);

        return SimpleResponse.SUCCESS;
    }

    public SimpleResponse updateMember(String id, Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(id)) {
                members.get(i).setName(member.getName());
                members.get(i).setContacts(member.getContacts());
                // 업데이트 되었으면 index 반환
                return SimpleResponse.SUCCESS;
            }
        }

        // 업데이트된 것이 없으면 0 반환
        return SimpleResponse.NOTHING;
    }

    public SimpleResponse deleteMember(String id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(id)) {
                members.remove(i);
                // 삭제 되었으면 index 반환
                return SimpleResponse.SUCCESS;
            }
        }

        // 삭제된 것이 없으면 0 반환
        return SimpleResponse.NOTHING;
    }
}
