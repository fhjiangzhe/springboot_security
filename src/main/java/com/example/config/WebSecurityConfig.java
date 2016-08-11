package com.example.config;

import com.example.security.UserContextService;
import com.example.service.impl.SecurityManagerImpl;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.event.LoggerListener;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangzhe on 15-11-17.
 */

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, order = 0, mode = AdviceMode.PROXY, proxyTargetClass = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    protected SessionRegistry sessionRegistryImpl() {
//        return new SessionRegistryImpl();
//    }
//
//	@Bean
//	public static ServletListenerRegistrationBean httpSessionEventPublisher() {
//		return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
//	}
//
//   /* @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(
//                new Md5PasswordEncoder());
//
//    }*/
//
//	/**
//	 * 配置验证管理器
//	 *
//	 * @return
//	 */
//	@Bean
//	public ProviderManager authenticationManager() {
//		List<AuthenticationProvider> providers = new ArrayList<>();
//		providers.add(authenticationProvider()); //基于数据库提供验证
//		providers.add(anonymousAuthenticationProvider());//匿名验证
//		ProviderManager providerManager = new ProviderManager(providers);
//		return providerManager;
//	}
//
//	/**
//	 * 匿名验证
//	 * @return
//     */
//	@Bean
//	public AnonymousAuthenticationProvider anonymousAuthenticationProvider(){
//		AnonymousAuthenticationProvider anonymousAuthenticationProvider = new AnonymousAuthenticationProvider("foobar");
//        return anonymousAuthenticationProvider;
//	}
//
//
//	/**
//	 * 数据提供者
//	 *
//	 * @return
//	 */
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//
//		//这里使用自带的DaoAuthenticationProvider(如果满足不了需求,就参照此类再自定义)
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsService());
//		authenticationProvider.setPasswordEncoder(new Md5PasswordEncoder());
//		SaltSource saltSource = new SaltSource() { //盐值
//			@Override
//			public Object getSalt(UserDetails user) {
//				return user.getUsername();
//			}
//		};
//		authenticationProvider.setSaltSource(saltSource);
//		authenticationProvider.setHideUserNotFoundExceptions(false);
//		return authenticationProvider;
//	}
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests()
//				.accessDecisionManager(accessDecisionManager())//自定义accessDecisionManager访问控制器
//				//.antMatchers("/users/**", "/products/**").permitAll() // 任何人(包括没有经过验证的)都可以访问”/users”和”/products”
//				// .antMatchers("/admin/**").hasRole("MANAGER") // “/admin/”开头的URL必须要是管理员用户，譬如”admin”用户
////				.antMatchers("/role/**").hasAuthority("ROLE_LIST")
////				.antMatchers("/org/**").hasAuthority("ORG_LIST")
////				.antMatchers("/user/**").hasAuthority("USER_LIST")
////				.antMatchers("/authority/**").hasAuthority("AUTHORITY_LIST")
////				.antMatchers("/menu/**").hasAuthority("MENU_LIST")
////				.antMatchers("/sjes_users/**").hasAuthority("SJESUSER_LIST")
////				.antMatchers("/sjes_product/**").hasAuthority("COMMODITYINFORMATION_LIST")
////				.antMatchers("/sjes_category/**").hasAuthority("COMMODITYCATEGORY_LIST")
////				.antMatchers("/sjes_attribute/**").hasAuthority("COMMODITYATTRIBUTE_LIST")
////				.antMatchers("/specification/**").hasAnyAuthority("SPECIFICATIONS_LIST")
////				.antMatchers("/topNavigation/**").hasAnyAuthority("TOPNAVIGATION_LIST")
////				.antMatchers("/advertisement/**").hasAnyAuthority("FOCUSMAP_LIST")
////				.antMatchers("/hotGoods/**").hasAnyAuthority("HOTGOODS_LIST")
////				.antMatchers("/article/**").hasAnyAuthority("ARTICLE_LIST")
////				.antMatchers("/hotSearch/**").hasAnyAuthority("HOTSEARCH_LIST")
////				.antMatchers("/floor/**").hasAnyAuthority("FLOOR_LIST")
////				.antMatchers("/floorAdvertisement/**").hasAnyAuthority("FLOOR_LIST")
////				.antMatchers("/floorCategory/**").hasAnyAuthority("FLOOR_LIST")
////				.antMatchers("/floorKeyword/**").hasAnyAuthority("FLOOR_LIST")
////				.antMatchers("/categoryAdvertisement/**").hasAnyAuthority("CLASSIFIEDADMAINTENANCE_LIST")
////				.antMatchers("/order/**").hasAnyAuthority("ORDERSEARCH_LIST")
////				.antMatchers("/promotions/**").hasAnyAuthority("PROMOTION_LIST")
////				.antMatchers("/gifts/**").hasAnyAuthority("GIFT_LIST")
////				.antMatchers("/volume/**").hasAnyAuthority("COUPON_LIST")
////				.antMatchers("/turntable/**").hasAnyAuthority("TURNTABLE_LIST")
////				.antMatchers("/admin/act/**").hasAnyAuthority("ACTIVITY_LIST")
////				.antMatchers("/integal/**").hasAnyAuthority("INTEGAL_LIST")
//				.anyRequest().authenticated() // 所有其他的URL都需要用户进行验证
//				.and()
//				.exceptionHandling().accessDeniedPage("/login")
//				.and()
//				.formLogin() // 使用Java配置默认值设置了基于表单的验证。使用POST提交到”/login”时，需要用”username”和”password”进行验证。
//				.loginPage("/login") // 注明了登陆页面，意味着用GET访问”/login”时，显示登陆页面
//				//.loginProcessingUrl("/login")
//				.failureUrl("/login?error=1")
//				.loginProcessingUrl("/j_spring_security_check")
//				.defaultSuccessUrl("/main")  //登陆成功时跳转到的页面
//				.permitAll()// 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”。permitAll()是指用户可以访问formLogin()相关的任何URL
//				.and().sessionManagement()
//				.invalidSessionUrl("/login")
//				.sessionFixation().changeSessionId()
//				.maximumSessions(1).maxSessionsPreventsLogin(true)
//				.sessionRegistry(this.sessionRegistryImpl())
//				.and()
//				.and().csrf().disable();
//
//		// session管理
////		http.sessionManagement().sessionFixation().changeSessionId()
////				.maximumSessions(1).maxSessionsPreventsLogin(true)
////				.sessionRegistry(this.sessionRegistryImpl()).expiredUrl("/timeout");
//
//		// 自定义注销
//		http.logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login")
//				.invalidateHttpSession(true).deleteCookies("JSESSIONID");
//
//	}
//
//	/**
//	 * 设置账号过期
//	 * @return
//     */
////	public ConcurrentSessionFilter concurrencyFilter(){
////		return new ConcurrentSessionFilter(this.sessionRegistryImpl(),"/timeout");
////	}
////
////
////	public ConcurrentSessionControlAuthenticationStrategy sas(){
////		ConcurrentSessionControlAuthenticationStrategy sas = new ConcurrentSessionControlAuthenticationStrategy(this.sessionRegistryImpl());
////		sas.setExceptionIfMaximumExceeded(true);
////		sas.setMaximumSessions(1);
////        return sas;
////	}
//
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/static/**", "/**/*.html"); // 设置不拦截规则
//	}
//
//	@Bean
//	public UserContextService userDetailsService() {
//		UserContextService userContextService = new UserContextService();
//		userContextService.setScurityManager(securityManager());
//		return userContextService;
//	}
//
//	@Bean
//	public com.example.service.SecurityManager securityManager() {
//		SecurityManagerImpl securityManager = new SecurityManagerImpl();
//		return securityManager;
//	}
//
//	@Bean
//	public LoggerListener loggerListener() {
//		LoggerListener loggerListener = new LoggerListener();
//		return loggerListener;
//	}
//
//	/**
//	 * 事件监听:实现了 ApplicationListener监听接口，包括AuthenticationCredentialsNotFoundEvent 事件，
//	 * AuthorizationFailureEvent事件，AuthorizedEvent事件， PublicInvocationEvent事件
//	 */
//	@Bean
//	public org.springframework.security.access.event.LoggerListener eventLoggerListener() {
//		org.springframework.security.access.event.LoggerListener eventLoggerListener = new org.springframework
//				.security.access.event.LoggerListener();
//
//		return eventLoggerListener;
//	}
//
//	/**
//	 * 这里可以增加自定义的投票器
//	 */
//	@SuppressWarnings("rawtypes")
//	@Bean(name = "accessDecisionManager")
//	public AccessDecisionManager accessDecisionManager() {
//		List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<>();
//		decisionVoters.add(roleVoter());
//		decisionVoters.add(new AuthenticatedVoter());
//		decisionVoters.add(webExpressionVoter());// 启用表达式投票器
//
//		AffirmativeBased accessDecisionManager = new AffirmativeBased(decisionVoters);
//
//		return accessDecisionManager;
//	}
//
//	@Bean
//	public RoleVoter roleVoter() {
//		RoleVoter roleVoter = new RoleVoter();
//		roleVoter.setRolePrefix("");
//		return roleVoter;
//	}
//
//
//	@Bean(name = "expressionHandler")
//	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
//		DefaultWebSecurityExpressionHandler webSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
//		return webSecurityExpressionHandler;
//	}
//
//
//	@Bean(name = "expressionVoter")
//	public WebExpressionVoter webExpressionVoter() {
//		WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
//		webExpressionVoter.setExpressionHandler(webSecurityExpressionHandler());
//		return webExpressionVoter;
//	}
}
