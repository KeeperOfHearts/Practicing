package codingslumber.employee_manager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name="pw")
    private String password;

    @Column(name="active")
    private int active;

    public Member() {
    }

    public Member(String password, int active) {
        this.password = password;
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
