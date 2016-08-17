package com.example.controller;

import com.example.domain.UserAuthority;
import com.example.domain.elasticsearch.UserBindElsEntity;
import com.example.repository.elasticsearch.UserBindRepository;
import com.example.security.UserContextHelper;
import com.google.common.collect.Lists;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.elasticsearch.search.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

/**
 * Created by JiangZhe on 16/7/30.
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userBindElsRepository")
    private UserBindRepository userBindRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    @ResponseBody
    public List<UserAuthority> index(){
        List<UserAuthority> userAuthorities = UserContextHelper.getUserContext().getUserAuthorities();
        return  userAuthorities;
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("timeout")
    public String timeout(){
        return "timeout";
    }

    @RequestMapping("getUserBindEls")
    @ResponseBody
    public Iterable<UserBindElsEntity> getUserBindEls(){
        return userBindRepository.findAll();
    }

    @RequestMapping("userBindEls")
    public String userBindEls(){
        return "userBindEls";
    }

    @RequestMapping("searchUserBindEls")
    @ResponseBody
    public Map searchUserBindEls(String searchContent ){

        Map result = new HashMap<>();

        try {
            Page<UserBindElsEntity> search = new PageImpl<UserBindElsEntity>(Lists.newArrayList());

            if(!StringUtils.isEmpty(searchContent)) {
                SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
                        multiMatchQuery(searchContent, "importOrgName", "bindOrgName").analyzer("ik").type(MultiMatchQueryBuilder.Type.BEST_FIELDS).tieBreaker(0.3f))
                        .withHighlightFields(
                                new HighlightBuilder.Field("importOrgName").preTags("<font color='red'>").postTags("</font>"),
                                new HighlightBuilder.Field("bindOrgName").preTags("<font color='red'>").postTags("</font>")
                        ).build();

                 search = elasticsearchTemplate.queryForPage(searchQuery, UserBindElsEntity.class, new SearchResultMapper() {
                    @Override
                    public <T> Page<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                        List<UserBindElsEntity> chunk = Lists.newArrayList();

                        for (SearchHit searchHit : searchResponse.getHits()) {
                            if (searchResponse.getHits().getHits().length <= 0) {
                                return null;
                            }

                            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
                            HighlightField highlightNameField = highlightFields.get("importOrgName");
                            HighlightField highlightBindField = highlightFields.get("bindOrgName");

                            UserBindElsEntity user = null;

                            try {
                                user = (UserBindElsEntity) mapToObject(aClass, searchHit.getSource());
                            } catch (IllegalAccessException | InstantiationException | IntrospectionException | InvocationTargetException e) {
                                e.printStackTrace();
                            }

                            if (highlightNameField != null && highlightNameField.fragments() != null && user != null) {
                                user.setDisplayName(highlightNameField.fragments()[0].string());
                            } else {
                                user.setDisplayName(user.getImportOrgName());
                            }

                            if (highlightBindField != null && highlightBindField.fragments() != null && user != null) {
                                user.setDisplayBindName(highlightBindField.fragments()[0].string());
                            } else {
                                user.setDisplayBindName(user.getBindOrgName());
                            }

                            chunk.add(user);
                        }
                        if (chunk.size() > 0) {
                            return new PageImpl<T>((List<T>) chunk);
                        }
                        return null;
                    }
                });
            }
            result.put("state","success");
            result.put("userBinds",search != null ? search.getContent() : Lists.newArrayList());
        } catch (Exception e) {
            result.put("state","error");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Map转Object
     *
     * @param classType 类
     * @param map Map
     * @return 对象
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    private Object mapToObject(Class classType, Map map) throws IllegalAccessException,
            InstantiationException, IntrospectionException, InvocationTargetException {

        BeanInfo beanInfo = Introspector.getBeanInfo(classType); // 获取类属性
        Object obj = classType.newInstance(); // 创建 JavaBean 对象

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            String type = descriptor.getPropertyType().getTypeName();

            if (map.containsKey(propertyName)) {
                Object value = map.get(propertyName);
                if (value != null) {
                    if (type.endsWith("Long")) {
                        descriptor.getWriteMethod().invoke(obj, Long.valueOf(value.toString()));
                    } else if (type.endsWith("Double")) {
                        descriptor.getWriteMethod().invoke(obj, Double.valueOf(value.toString()));
                    }else if (type.endsWith("Date")) {
                        descriptor.getWriteMethod().invoke(obj, new Date(Long.parseLong(value.toString())));
                    } else {
                        descriptor.getWriteMethod().invoke(obj, value);
                    }
                }
            }
        }
        return obj;
    }
}
