package com.example.service.impl;

import com.example.domain.*;
import com.example.security.UserContext;
import com.example.service.*;
import com.example.service.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.*;



public class SecurityManagerImpl  implements SecurityManager {

	 private Class userClass = AclUser.class;
	  private Class userAuthorityClass = UserAuthority.class;
	  private Class userRoleClass = UserRole.class;

	@Autowired
	private AclUserService aclUserService;
	@Autowired
	private UserAuthorityService userAuthorityService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private AuthorityService authorityService;



	public AclUser getUser(String username) {
		return aclUserService.findByName(username);
	}

	public UserContext getUserContext(String username) {

		AclUser user = getUser(username);

		if (user == null) {
			return null;
		}
		UserContext userContext = new UserContext(user);
		userContext.setUserAuthorities(getUserAuthorities(user));
		userContext.setUserRoles(getUserRoles(user));
		return userContext;
	}

	public List<UserRole> getUserRoles(AclUser user) {
		Map map = new HashMap();
		map.put("securityUser",user);
		return userRoleService.selectByMap(map);
	}




	public List<UserAuthority> getUserAuthorities(AclUser user)throws DataAccessException {

		List<UserAuthority> userAuthorities = null;
		if ((user.getUserMgrType() == null) || (user.getUserMgrType().intValue() != UserType.USERTYPE_ADMINISTRATOR)) {//不是超级管理员,读取用户具体权限
			Map map = new HashMap();
			map.put("securityuser",user);
			userAuthorities = userAuthorityService.selectByMap(map);
		} else {//超级管理员可以取得系统的所有权限
			userAuthorities = new ArrayList();
			List<Authority> authorities = authorityService.selectAll();
			for (Authority authority : authorities) {
				UserAuthority userAuthority = new UserAuthority();
				userAuthority.setAuthority(authority.getId());
				userAuthority.setSecurityuser(user.getId());
				userAuthority.setAuthorityObj(authority);
				userAuthorities.add(userAuthority);
			}
		}

		if (userAuthorities == null) {
			throw new DataIntegrityViolationException("user:" + user.getFullName() + " havn't userAuthorities");
		}


		return userAuthorities;
	}



	public Class getUserClass() {
		return userClass;
	}

	public void setUserClass(Class userClass) {
		this.userClass = userClass;
	}

	public Class getUserAuthorityClass() {
		return userAuthorityClass;
	}

	public void setUserAuthorityClass(Class userAuthorityClass) {
		this.userAuthorityClass = userAuthorityClass;
	}

	public Class getUserRoleClass() {
		return userRoleClass;
	}

	public void setUserRoleClass(Class userRoleClass) {
		this.userRoleClass = userRoleClass;
	}

}
