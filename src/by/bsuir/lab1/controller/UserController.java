package by.bsuir.lab1.controller;

import by.bsuir.lab1.entity.UserRole;

public class UserController {
    private UserRole role;

    public UserController(){
        setRoleGuest();
    }
    public void setRoleGuest(){
        role = UserRole.GUEST;
    }

    public void setRoleUser(){
        role = UserRole.USER;
    }

    public void setRoleAdmin(){
        role = UserRole.ADMIN;
    }

    public void setRole(UserRole role) { this.role = role; }

    public UserRole getRole(){
        return role;
    }

}
