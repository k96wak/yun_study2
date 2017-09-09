package jp.co.sisolution;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class Example3 {

	public static void main(String[] args) {
		Charset charset = StandardCharsets.UTF_8;
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=644");
		
		CloseableHttpResponse response = null;
		
		try {
			
			response = httpclient.execute(request);
			int status = response.getStatusLine().getStatusCode();
			System.out.println("HTTPステータス:" + status);
			//HTTPステータス:200
			
			if (status == HttpStatus.SC_OK){				
				String responseData = 
					EntityUtils.toString(response.getEntity(),charset);				
				System.out.println(responseData);
				Gson gson = new Gson();
				Lotto lotto = gson.fromJson(responseData, Lotto.class);
				System.out.println(lotto);
				//取得したデータが表示される
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
