package com.ojt.homeworkfive;

public class RoleServiceImpl implements RoleService{

	@Override
	public void createRole(Role role){
		new RoleDAOImpl().addRole(role);
	}

}