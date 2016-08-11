package com.example.security;


import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;

public class UserContextService implements UserDetailsService {
	
	 private com.example.service.SecurityManager scurityManager;
	 

	public com.example.service.SecurityManager getScurityManager() {
		return scurityManager;
	}


	public void setScurityManager(com.example.service.SecurityManager scurityManager) {
		this.scurityManager = scurityManager;
	}


	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		UserContext uesrContext = this.scurityManager.getUserContext(username);

	    if (uesrContext == null) {
	      throw new UsernameNotFoundException("user:" + username + " not found");
	    }

	    return uesrContext;
	}


	
	 /** @deprecated */
	  public void loadSecurityContext(HttpServletRequest request){
	    Object contextFromSessionObject = request.getSession(true).getAttribute("ACEGI_SECURITY_CONTEXT");

	    if (contextFromSessionObject == null) {
	      return;
	    }
	    if (!(contextFromSessionObject instanceof SecurityContext)) {
	      return;
	    }
	    SecurityContextHolder.setContext((SecurityContext)contextFromSessionObject);
	  }

	
	
}
