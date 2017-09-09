package jp.co.sisolution;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class GetLotto {

	public Lotto getLotto(int drwNo) throws ClientProtocolException, IOException {
		
		Charset charset = StandardCharsets.UTF_8;
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=" + drwNo);
		
		CloseableHttpResponse response = httpclient.execute(request);
		int status = response.getStatusLine().getStatusCode();
		System.out.println("HTTP:" + status);
		//HTTP:200
		
		if (status == HttpStatus.SC_OK){				
			String responseData = 
				EntityUtils.toString(response.getEntity(),charset);				
			System.out.println(responseData);
			Gson gson = new Gson();
			Lotto lotto = gson.fromJson(responseData, Lotto.class);
			return lotto;
		
		}
		return null;
	}
}
