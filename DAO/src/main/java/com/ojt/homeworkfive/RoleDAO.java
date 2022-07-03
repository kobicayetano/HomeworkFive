package com.ojt.homeworkfive;


public interface RoleDAO 
{
    public abstract void addRole(Role role);
    public abstract void deleteRoleById(int roleId);
    public abstract void updateRoleTitleById(int roleId, String newTitle);
    public abstract Role fetchRoleById(int roleId);
    
}
