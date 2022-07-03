package com.ojt.homeworkfive;

public class RoleServiceImpl implements RoleService{

	@Override
	public void createRole(Role role){
		new RoleDAOImpl().addRole(role);
	}


	@Override
	public void updateRoleTitleById(int roleId, String newTitle){
		new RoleDAOImpl().updateRoleTitleById(roleId, newTitle);
	}

	@Override
	public void deleteRoleById(int roleId){
		new RoleDAOImpl().deleteRoleById(roleId);
	}

	@Override
	public Role getRoleById(int roleId){
		return new RoleDAOImpl().fetchRoleById(roleId);
	}
}