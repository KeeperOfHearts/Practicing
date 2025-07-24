package codingslumber.employee_manager.dao;

import codingslumber.employee_manager.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoleDAO extends JpaRepository<Roles, String> {
    @Modifying
    @Query("delete from Roles r where r.role=:roleId and r.userId=:memberId")
    void deleteRoleOf(@Param("roleId") String roleId, @Param("memberId") String memberId);
}
