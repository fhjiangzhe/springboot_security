package com.example;

import com.example.domain.mongo.EnquiryOrgInfo;
import com.example.domain.mongo.ImpdataMyMastersMain;
import com.example.domain.mongo.OrgCertBusinessMasters;
import com.example.domain.mongo.RouteOrCarrier;
import com.example.repository.MasterRepository;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private MasterRepository masterRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSaveImpdataMyMaster() throws Exception{

		ImpdataMyMastersMain impdataMyMastersMain = new ImpdataMyMastersMain();
		impdataMyMastersMain.setOrgId(10062L);
		impdataMyMastersMain.setOrgName("测试掌门");
		impdataMyMastersMain.setDomain("http://www.baidu.com");
		impdataMyMastersMain.setAreaName("欧洲");

		RouteOrCarrier r1 = new RouteOrCarrier();
		r1.setRouteOrCarrierName("ANL");
		r1.setRouteOrCarrierRemark("ANL");

		RouteOrCarrier r2 = new RouteOrCarrier();
		r2.setRouteOrCarrierName("APL");
		r2.setRouteOrCarrierRemark("APL");

		OrgCertBusinessMasters orgCertBusinessMasters = new OrgCertBusinessMasters();

		List<RouteOrCarrier> majorBusinessList = Lists.newArrayList(r1,r2);
		orgCertBusinessMasters.setMajorBusinessList(majorBusinessList);

		Map<String,OrgCertBusinessMasters> areaMap = new HashMap<>();
		areaMap.put(impdataMyMastersMain.getAreaName(),orgCertBusinessMasters);

		impdataMyMastersMain.setAreaMap(areaMap);

		EnquiryOrgInfo enquiryOrgInfo = new EnquiryOrgInfo();
		enquiryOrgInfo.setOrgId(impdataMyMastersMain.getOrgId());
		enquiryOrgInfo.setBindNum(10L);
		enquiryOrgInfo.setEfclDischargeportNum(20L);
		enquiryOrgInfo.setEfclPriceNum(100L);

		impdataMyMastersMain.setEnquiryOrgInfo(enquiryOrgInfo);

		HashSet<String> areaSet = new HashSet<>();
		areaSet.add("欧洲");
		HashSet<String> carrierSet = new HashSet<>();
		carrierSet.add("ANL");
		carrierSet.add("APL");
		HashSet<String> routeSet = new HashSet<>();
		routeSet.add("中东");

		impdataMyMastersMain.setAreaSet(areaSet);
		impdataMyMastersMain.setCarrierSet(carrierSet);
		impdataMyMastersMain.setRouteSet(routeSet);

		impdataMyMastersMain.setPaidDate(new Date());

		masterRepository.save(impdataMyMastersMain);

	}

	@Test
	public void queryMaster(){
		List<ImpdataMyMastersMain> all = masterRepository.findAll();
		for (ImpdataMyMastersMain impdataMyMastersMain : all) {
			System.out.println(impdataMyMastersMain.getPaidDate());
		}
	}

}
