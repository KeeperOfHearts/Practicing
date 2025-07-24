package codingslumber.employee_manager.service;

import codingslumber.employee_manager.entity.Member;
import codingslumber.employee_manager.entity.Roles;

import java.util.List;

public interface MemberService {
    List<Member> findAll();

    List<Roles> findAllRoles();

    List<Roles> getRolesOfMember(String memberId);

    boolean isMemberPresent(String memberId);

    void cleanUpMember(String memberId);

    void deleteRoleOfMember(String memberId, String roleId);
}
