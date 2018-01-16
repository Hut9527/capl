package com.sunjays.capl.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;

import net.sf.json.JSONArray;

/**
 * 淘淘商城自定义响应结构
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json结果集转化为对象
     * 
     * @param jsonData json数据
     * @param clazz 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    public static List<Map<String,String>> jsonToListMap(String jsonData) {
    	JSONArray ja = JSONArray.fromObject(jsonData);
        @SuppressWarnings({ "deprecation", "unchecked" })
        List<Map<String,String>> list = JSONArray.toList(ja, HashMap.class);
    	
    	return list;
    }
    public static void toListMapTest() {
        Map<String,String> map1 = new HashMap<String,String>();
        Map<String,String> map2 = new HashMap<String,String>();
        Map<String,String> map3 = new HashMap<String,String>();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        map1.put("name","小明");
        map1.put("age","23");
        map1.put("sex","男");
        list.add(map1);
 
        map2.put("name","小王");
        map2.put("age","24");
        map2.put("sex","女");
        list.add(map2);
 
        map3.put("name","小张");
        map3.put("age","22");
        map3.put("sex","男");
        list.add(map3);
        String jsonStr = JSONArray.fromObject(list).toString();
         System.out.println(jsonStr);
        JSONArray ja = JSONArray.fromObject(jsonStr);
         
        @SuppressWarnings({ "deprecation", "unchecked" })
        List<Map<String,String>> listBack = JSONArray.toList(ja, HashMap.class);
         
        System.out.println(listBack.size());
        int i = 0;
        for (Map<String, String> map : listBack) {
            i++;
            StringBuffer sb = new StringBuffer();
            sb.append("第 "+i+" 个MAP ---》");
            if(map.containsKey("name")){
                sb.append(" Name:"+map.get("name"));
            }
            if(map.containsKey("age")){
                sb.append(" Age:"+map.get("age"));       
            }
            if(map.containsKey("sex")){
                sb.append(" Sex:"+map.get("sex"));
            }
             
            System.out.println(sb.toString());
        }
    }
    public static void main(String[] args) {
    	 String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}"; 
    	 Map<String,String> maps=Maps.newHashMap();
    	 maps=jsonToPojo(str,maps.getClass());
    	 for (Object map : maps.entrySet()){  
             System.out.println(((Map.Entry)map).getKey()+"     " + ((Map.Entry)map).getValue());  
         }  
    	 
	}
}
