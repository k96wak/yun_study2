package jp.co.sisloution;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class GSONExample {
public static void main(String[] args) {
	Gson gson = new Gson();
	System.out.println(gson.toJson(1));
	System.out.println(gson.toJson("1"));
	System.out.println(gson.toJson("abcd"));
	System.out.println(gson.toJson(new Long(10)));
	System.out.println(gson.toJson(new int[] {10,20,30}));
	/*gson.toJson(1);
	gson.toJson("abcd");
	gson.toJson(new Long(10));
	int[] values = {1};
	gson.toJson(values);*/
	
	SourceObject obj = new SourceObject();
	obj.setName("YUN");
	obj.setDate(new Date());
	
	System.out.println(gson.toJson(obj));
	
	List<SourceObject> list = new ArrayList<SourceObject>();
	
	list.add(obj);
	
	SourceObject obj2 = new SourceObject();
	obj2.setName("YUN");
	obj2.setDate(new Date());
	
	System.out.println(gson.toJson(obj2));
	}
}
