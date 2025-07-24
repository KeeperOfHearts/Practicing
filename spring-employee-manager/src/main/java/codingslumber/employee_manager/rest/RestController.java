package codingslumber.employee_manager.rest;


import codingslumber.employee_manager.entity.Member;
import codingslumber.employee_manager.entity.Roles;
import codingslumber.employee_manager.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private MemberService memberService;

    private ObjectMapper objectMapper;

    @Autowired
    public RestController(MemberService theMemberService, ObjectMapper theObjectMapper) {
        memberService = theMemberService;
        objectMapper = theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/roles")
    public List<Roles> findAllRoles() {
        return memberService.findAllRoles();
    }

    @GetMapping("/roles/{memberId}")
    public List<Roles> findAllRoles(@PathVariable String memberId) {
        return memberService.getRolesOfMember(memberId);
    }

    @GetMapping("/isMemberPresent/{memberId}")
    public boolean isMemberPresent(@PathVariable String memberId) {
        return memberService.isMemberPresent(memberId);
    }

    @GetMapping("/cleanUpMember/{memberId}")
    public void cleanUpMember(@PathVariable String memberId) {
        memberService.cleanUpMember(memberId);
    }

    @GetMapping("/deleteRoleOfMember/{memberId}/{roleId}")
    public String deleteRoleOfMember(@PathVariable String memberId, @PathVariable String roleId) {
        memberService.deleteRoleOfMember(memberId, roleId);

        return "Role with ID " + roleId + " has been deleted from member with ID " + memberId;
    }

}


