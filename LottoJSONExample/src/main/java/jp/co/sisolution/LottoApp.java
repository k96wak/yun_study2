package jp.co.sisolution;

import java.io.IOException;

public class LottoApp {
	public static void main(String[] args) {
		GetLotto getLotto = new GetLotto();
		try {
			Lotto lt = getLotto.getLotto(643);
			if(lt != null) {
				System.out.println(lt);
			}else {
				System.out.println("LOTTO IS NOT EXIST!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
