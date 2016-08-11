/**
 * 
 */
package com.example.domain.mongo;

import java.io.Serializable;
import java.util.List;

/** 
 * @ClassName: OrgCertBusinessMasters 
 * @Description: TODO
 * @author 史超
 * @date 2016年6月27日 下午3:07:30 
 */
public class OrgCertBusinessMasters implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 2309433236670285314L;

	public OrgCertBusinessMasters(){
		
	}
	
	public OrgCertBusinessMasters(List<RouteOrCarrier> majorBusinessList, List<RouteOrCarrier> normalBusinessList){
		this.majorBusinessList = majorBusinessList;
		this.normalBusinessList = normalBusinessList;
	}
	
	//主营list
	private List<RouteOrCarrier> majorBusinessList;
	//经营list
	private List<RouteOrCarrier> normalBusinessList;
	/**
	 * @return majorBusinessList
	 */
	public List<RouteOrCarrier> getMajorBusinessList() {
		return majorBusinessList;
	}
	/**
	 * @param majorBusinessList 赋值为  majorBusinessList
	 */
	public void setMajorBusinessList(List<RouteOrCarrier> majorBusinessList) {
		this.majorBusinessList = majorBusinessList;
	}
	/**
	 * @return normalBusinessList
	 */
	public List<RouteOrCarrier> getNormalBusinessList() {
		return normalBusinessList;
	}
	/**
	 * @param normalBusinessList 赋值为  normalBusinessList
	 */
	public void setNormalBusinessList(List<RouteOrCarrier> normalBusinessList) {
		this.normalBusinessList = normalBusinessList;
	}
	
	
}


