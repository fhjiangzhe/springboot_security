/**
 * 
 */
package com.example.domain.mongo;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/** 
 * @ClassName: RouteOrCarrier 
 * @Description: TODO
 * @author 史超
 * @date 2016年6月27日 下午3:27:37 
 */
public class RouteOrCarrier implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 6401727158510775033L;
	private String routeOrCarrierName;
	private String routeOrCarrierRemark;
	
	public RouteOrCarrier(){
		
	}
	
	public RouteOrCarrier(String routeOrCarrierName){
		this.routeOrCarrierName=routeOrCarrierName;
	}
	
	/**
	 * @return routeOrCarrierName
	 */
	public String getRouteOrCarrierName() {
		return routeOrCarrierName;
	}
	/**
	 * @param routeOrCarrierName 赋值为  routeOrCarrierName
	 */
	public void setRouteOrCarrierName(String routeOrCarrierName) {
		this.routeOrCarrierName = routeOrCarrierName;
	}
	/**
	 * @return routeOrCarrierRemark
	 */
	public String getRouteOrCarrierRemark() {
		return routeOrCarrierRemark;
	}
	/**
	 * @param routeOrCarrierRemark 赋值为  routeOrCarrierRemark
	 */
	public void setRouteOrCarrierRemark(String routeOrCarrierRemark) {
		this.routeOrCarrierRemark = routeOrCarrierRemark;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof RouteOrCarrier && this.routeOrCarrierName!=null){
			RouteOrCarrier that = (RouteOrCarrier)obj;
			return this.routeOrCarrierName.equalsIgnoreCase(that.getRouteOrCarrierName());
		}else{
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		RouteOrCarrier c = new RouteOrCarrier();
		c.setRouteOrCarrierName("cc");
		List<RouteOrCarrier> list = Lists.newArrayList(c);
		
		RouteOrCarrier d = new RouteOrCarrier();
		d.setRouteOrCarrierName("cc");
		System.out.println(list.contains(d));
	}
	
}


