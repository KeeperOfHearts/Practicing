package codingslumber.employee_manager.dao;

import codingslumber.employee_manager.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDAO extends JpaRepository<Member, String> {

    // that's it ... no need to write any code LOL!

}