package com.restaurantadvisor.website.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserRole")
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name = "RoleID")
	private long roleId;

	@Column(name = "RoleType")
	private String roleType;

	@OneToMany(mappedBy = "userRole")
	private Set<LoginDetails> loginDetails;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Set<LoginDetails> getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(Set<LoginDetails> loginDetails) {
		this.loginDetails = loginDetails;
	}

}
