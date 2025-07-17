package codingslumber.employee_manager.service;


import codingslumber.employee_manager.dao.CustomDAO;
import codingslumber.employee_manager.dao.MemberDAO;
import codingslumber.employee_manager.dao.RoleDAO;
import codingslumber.employee_manager.entity.Member;
import codingslumber.employee_manager.entity.Roles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final RoleDAO rolesDAO;
    private final CustomDAO customDAO;

    public MemberServiceImpl(MemberDAO memberDAO, RoleDAO rolesDAO, CustomDAO c) {
        this.memberDAO = memberDAO;
        this.rolesDAO = rolesDAO;
        this.customDAO = c;
    }

    @Override
    public List<Member> findAll() {
        return memberDAO.findAll();
    }

    @Override
    public List<Roles> findAllRoles() {
        return rolesDAO.findAll();
    }

    @Override
    public List<Roles> getRolesOfMember(String memberId) {
        return customDAO.getRolesOfMember(memberId);
    }

    // other methods can be added here as needed
}
