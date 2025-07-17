package codingslumber.employee_manager.dao;

import codingslumber.employee_manager.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Roles, String> {
}
