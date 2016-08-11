package com.example.security;

import com.example.domain.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;

/**
 * Created by jiangzhe on 15-11-17.
 * 系统中需要用到的用户信息，用户登陆后才能获取到
 */
public class UserContext implements UserDetails {

    private static final long serialVersionUID = -9145437693158151566L;
    private AclUser user;
    private List<UserAuthority> userAuthorities;
    private List<UserRole> userRoles;
    private Map<String, List<UserAuthority>> authorityNameList;
    private Map<String,List<String>> userMenus = null;
    private Long labId;


    public UserContext(AclUser user) {
        String username = user.getUsername();
        if ((username == null) || ("".equals(username)) || (user.getPassword() == null) || (user.getPassword().equals(""))) {
            throw new BadCredentialsException("Cannot pass null or empty values to constructor");
        }

        this.user = user;
    }

    public AclUser getUser() {
        return user;
    }


    public List<UserAuthority> getUserAuthorities(){
        return this.userAuthorities;
    }

    public void setUserAuthorities(List<UserAuthority> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    public List<UserRole> getUserRoles(){
        return this.userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    /**
     * 超级管理员
     * @return
     */
    public boolean isSupperManager(){
        if (this.user.getUserMgrType() == null)
            return false;
        return this.user.getUserMgrType().equals(UserType.USERTYPE_ADMINISTRATOR);
    }

    /**
     * 系统管理员
     * @return
     */
    public boolean isManager(){
        if (this.user.getUserMgrType() == null)
            return false;
        return this.user.getUserMgrType().equals(UserType.USERTYPE_MANAGER);
    }


    public String getUserName() {
        return this.user.getUsername();
    }

    public Integer getUserId(){
        return this.user.getId().intValue();
    }

    /**
     *
     * @return 返回用户所能访问的所有菜单
     */
    public Set<Menu> getUserMenus(){
        Set<Menu> menus = new HashSet<>();
        for(UserAuthority userAuthority : getUserAuthorities()){
            menus.add(userAuthority.getAuthorityObj().getMenuLink());
        }

        return menus;
    }



    /**
     * 实现接口方法，返回用户所有权限
     * @return
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority[] authorities = new GrantedAuthority[this.userAuthorities.size()];
        for (int i = 0; i < this.userAuthorities.size(); ++i) {
            Authority authority = ((UserAuthority)this.userAuthorities.get(i)).getAuthorityObj();

            authorities[i] = authority;
        }

        return  Arrays.asList(authorities);
    }

    /**
     * 接口方法
     * @return
     */
    public String getPassword() {
        return this.user.getPassword();
    }

    /**
     * 接口方法
     * @return
     */
    public String getUsername() {
        return this.user.getUsername();
    }

    /**
     * 实现接口方法，当前要登录的用户是否已过有效期
     * 目前默认都是不过期的
     * @return
     */
    public boolean isAccountNonExpired() {
        Date expiredDate = new Date();

        if (expiredDate == null) {
            return true;
        }

        return expiredDate.getTime() >= System.currentTimeMillis();
    }

    /**
     * 实现接口方法，用户是否被锁住
     * @return
     */
    public boolean isAccountNonLocked() {
        if (this.user.getAccountLocked() == null) {
            return true;
        }
        return this.user.getAccountLocked().intValue() == 0;
    }

    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * 实现接口方法，用户是否使用中
     * @return
     */
    public boolean isEnabled() {
        if (this.user.getAccountEnabled() == null)
            return true;
        return this.user.getAccountEnabled().intValue() == 1;
    }

    /**
     * 由于自己定义了UserContext类,所以必须重写equals和hashCode方法,否则并发session控制会失效
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserDetails) {
            UserDetails another = (UserDetails)obj;
            return this.getUsername().equals(another.getUsername());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.getUsername().hashCode();
    }


    /**
     * 使用 Map按key进行排序
     * @param
     * @return
     */
//    public  Map<String,List<String>> sortMapByKey(Map<String,List<String>> map) {
//        if (map == null || map.isEmpty()) {
//            return null;
//        }
//        Map<String,List<String>> sortMap = new TreeMap<String,List<String>>(new MapKeyComparator());
//        sortMap.putAll(map);
//        return sortMap;
//    }

}
