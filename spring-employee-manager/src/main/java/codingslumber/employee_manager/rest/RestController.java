package codingslumber.employee_manager.rest;


import codingslumber.employee_manager.entity.Member;
import codingslumber.employee_manager.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

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


}


