package edu.xpu.hcp.entity;

public class SuperUser extends User {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "role='" + role + '\'' +
                super.toString()+
                '}';
    }
}
