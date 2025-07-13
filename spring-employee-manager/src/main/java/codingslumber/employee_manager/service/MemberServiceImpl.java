package codingslumber.employee_manager.service;


import codingslumber.employee_manager.dao.MemberDAO;
import codingslumber.employee_manager.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public List<Member> findAll() {
        return memberDAO.findAll();
    }

    // other methods can be added here as needed
}
