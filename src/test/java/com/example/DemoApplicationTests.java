package com.example;


import com.example.domain.elasticsearch.Article;
import com.example.domain.elasticsearch.UserBindElsEntity;
import com.example.domain.mongo.EnquiryOrgInfo;
import com.example.domain.mongo.ImpdataMyMastersMain;
import com.example.domain.mongo.OrgCertBusinessMasters;
import com.example.domain.mongo.RouteOrCarrier;
import com.example.repository.MasterRepository;
import com.example.repository.elasticsearch.ArticleSearchRepository;
import com.example.repository.elasticsearch.UserBindRepository;
import com.google.common.collect.Lists;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.*;
import static org.elasticsearch.index.query.QueryBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private MasterRepository masterRepository;

	@Autowired
	@Qualifier("userBindElsRepository")
	private UserBindRepository userBindRepository;

	@Autowired
	private ArticleSearchRepository articleSearchRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

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

	@Test
	public void before() {
		//elasticsearchTemplate.deleteIndex(UserBindElsEntity.class);
		elasticsearchTemplate.createIndex(UserBindElsEntity.class);
		//elasticsearchTemplate.refresh(UserBindElsEntity.class);
	}


	@Test
	public void queryUserBindEls(){

//		Predicate predicate = user.firstname.equalsIgnoreCase("dave")
//				.and(user.lastname.startsWithIgnoreCase("mathews"));
//
//		userRepository.findAll(predicate);


//		Iterable<UserBindElsEntity> all = userBindRepository.findAll();
//		for (UserBindElsEntity userBindElsEntity : all) {
//			System.out.println(userBindElsEntity.getImportOrgName());
//		}

		//"掌门测试0"被分解成"掌门,测试,0"三个词,那么所有包含这三个词中的一个或多个的文档就会被搜索出来
		//NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(matchQuery("import_org_name","掌门测试0"));

        //如果我们希望两个字段进行匹配，其中一个字段有这个文档就满足的话，使用multi_match
		// 我们希望完全匹配的文档占的评分比较高，则需要使用best_fields,只匹配汝建斌或上海的文档评分乘以0.3的系数
		//我们希望越多字段匹配的文档评分越高，就要使用most_fields
		//我们会希望这个词条的分词词汇是分配到不同字段中的，那么就使用cross_fields
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(
				multiMatchQuery("汝建斌上海","import_org_name","bind_org_name").analyzer("ik").type(MultiMatchQueryBuilder.Type.BEST_FIELDS).tieBreaker(0.3f))
		.withHighlightFields(new HighlightBuilder.Field("import_org_name").preTags("<b class=\"highlight\">").postTags("</b>"));

		//match_phrase 精确匹配所有同时包含"掌门,测试,0"三个词

//		BoolQueryBuilder boolQueryBuilder = boolQuery();
//
//		boolQueryBuilder.must(termQuery("import_org_name","掌门测试0")); //使用term必须保证import_org_name未被分析 not_analyzed
//		"bool": {
//			"must": {
//				"term": {
//					"content": "宝马"
//				}
//			},
//			"must_not": {
//				"term": {
//					"tags": "宝马"
//				}
//			}
//		}
//
//		nativeSearchQueryBuilder.withFilter(boolQueryBuilder);

		Page<UserBindElsEntity> search = userBindRepository.search(nativeSearchQueryBuilder.build());

		for (UserBindElsEntity userBindElsEntity : search) {
			System.out.println(userBindElsEntity.getImportOrgName());
		}

	}

	@Test
	public void saveUserBindEls(){
		UserBindElsEntity userBindElsEntity = new UserBindElsEntity();
		userBindElsEntity.setId(2);
		userBindElsEntity.setImportOrgId(10002);
		userBindElsEntity.setImportOrgName("宁波江北掌柜0");
		userBindElsEntity.setBindOrgId(10003);
		userBindElsEntity.setBindOrgName("鄞州掌门1");
		userBindElsEntity.setApplyTime(new Date());
		userBindElsEntity.setApplySource(0);
		userBindElsEntity.setApplyUserId(1);
		userBindElsEntity.setApplyUserName("测试人员");
		userBindElsEntity.setBindStatus(10);
		userBindElsEntity.setEffectStatus(1);
		userBindElsEntity.setDomain("http://www.baidu.com");
		userBindRepository.save(userBindElsEntity);
	}

	@Test
	public void testSave(){
		Article article=new Article();
		article.setId(1L);
		article.setTitle("elasticsearch教程");
		article.setAbstracts("spring-data-elastichSearch");
		article.setContent("SpringBoot与spring-data-elastichSearch整合");
		article.setClickCount(100l);
		articleSearchRepository.save(article);
	}

	@Test
	public void queryArticles(){
		Iterable<Article> all = articleSearchRepository.findAll();
		for (Article article : all) {
			System.out.println(article.getTitle());
		}
	}

	@Test
	public void removeUserBindEls(){
		userBindRepository.deleteAll();
	}


}
