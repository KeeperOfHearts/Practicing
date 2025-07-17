package codingslumber.employee_manager.dao;

import codingslumber.employee_manager.entity.Roles;

import java.util.List;

public interface CustomDAO {

    List<Roles> getRolesOfMember(String memberId);
}
