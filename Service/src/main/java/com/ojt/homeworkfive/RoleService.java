package com.ojt.homeworkfive;

public interface RoleService{

	public abstract void createRole(Role role);
	public abstract void updateRoleTitleById(int roleId, String newTitle);
	public abstract void deleteRoleById(int roleId);
	public abstract Role getRoleById(int roleId);

}