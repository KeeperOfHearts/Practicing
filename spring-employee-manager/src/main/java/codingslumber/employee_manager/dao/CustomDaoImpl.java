package codingslumber.employee_manager.dao;

import codingslumber.employee_manager.entity.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomDaoImpl implements CustomDAO{
    private EntityManager manager;

    @Autowired
    public CustomDaoImpl(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public List<Roles> getRolesOfMember(String memberId) {
        TypedQuery<Roles> query = manager.createQuery(
                "FROM Roles WHERE userId= :memberId", Roles.class);

        query.setParameter("memberId", memberId);

        List<Roles> roles = query.getResultList();

        return roles;
    }
}
