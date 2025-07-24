package codingslumber.employee_manager.service;


import codingslumber.employee_manager.dao.CustomDAO;
import codingslumber.employee_manager.dao.MemberDAO;
import codingslumber.employee_manager.dao.RoleDAO;
import codingslumber.employee_manager.entity.Member;
import codingslumber.employee_manager.entity.Roles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean isMemberPresent(String memberId) {
            Optional<Member> result = memberDAO.findById(memberId);

            return result.isPresent();
    }

    @Override
    public void cleanUpMember(String memberId) {
        if (isMemberPresent(memberId)) {
            customDAO.deleteMemberRoles(memberId);
            memberDAO.deleteById(memberId);
        } else {
            throw new RuntimeException("Member with ID " + memberId + " does not exist.");
        }
    }

    @Override
    public void deleteRoleOfMember(String memberId, String roleId) {
        if (isMemberPresent(memberId)) {
            customDAO.deleteRoleOfMember(memberId, roleId);
        } else {
            throw new RuntimeException("Member with ID " + memberId + " does not exist.");
        }
    }


    // other methods can be added here as needed
}
