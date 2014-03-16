package com.android.mygson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.domain.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTools {

	public GsonTools() {
		// TODO Auto-generated constructor stub
	}

	public static String createGsonString(Object object) {
		Gson gson = new Gson();
		String gsonString = gson.toJson(object);
		return gsonString;
	}

	public static <T> T changeGsonToBean(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		T t = gson.fromJson(gsonString, cls);
		return t;
	}

	public static <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		List<T> list_person = gson.fromJson(gsonString,
				new TypeToken<List<T>>() {
				}.getType());
		return list_person;
	}

	public static List<Map<String, Object>> changeGsonToListMaps(String gsonString) {
		List<Map<String, Object>> list = null;
		Gson gson = new Gson();
		list = gson.fromJson(gsonString,
				new TypeToken<List<Map<String, Object>>>() {
				}.getType());
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Person person1 = new Person("����1", 24, "����1");
		// Person person2 = new Person("����2", 23, "����2");
		// List<Person> list = new ArrayList<Person>();
		// list.add(person1);
		// list.add(person2);
		//
		// String gsonString = createGsonString(list);
		// System.out.println(gsonString);
		// Gson gson = new Gson();
		// List<Person> list_person = changeGsonToList(gsonString,Person.class);
		// System.out.println(list_person.toString());
		// Person pp = changeGsonToBean(gsonString,Person.class);
		// System.out.println(pp);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "jack");
		map.put("age", 23);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "rose");
		map2.put("age", 24);
		list.add(map);
		list.add(map2);
		String gsonString = createGsonString(list);
		System.out.println(gsonString);
		List<Map<String, Object>> list2 = changeGsonToListMaps(gsonString);
		System.out.println(list2.toString());
	}

}
