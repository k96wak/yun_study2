package jp.co.sisolution;

import java.util.Map;

import com.google.gson.Gson;

public class Example1 {
	public static void main(String[] args) {
	
		String jsonString ="{\"bnusNo\":8,\"firstAccumamnt\":14651609632,\"firstWinamnt\":1831451204,\"returnValue\":\"success\",\"totSellamnt\":61846599000,\"drwtNo3\":17,\"drwtNo2\":13,\"drwtNo1\":5,\"drwtNo6\":36,\"drwtNo5\":28,\"drwtNo4\":23,\"drwNoDate\":\"2015-04-04\",\"drwNo\":644,\"firstPrzwnerCo\":8}";
		System.out.println(jsonString);
		Gson gson = new Gson();
		Map map = gson.fromJson(jsonString, Map.class);
		System.out.println(map);
		Lotto lotto = gson.fromJson(jsonString, Lotto.class);

	}
}
