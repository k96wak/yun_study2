package jp.co.sisolution.example2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class DozerExample2 {
	public static void main(String[] args) {
		List<String> mappingFiles = new ArrayList<String>();
		mappingFiles.add("dozer-mapping.xml");
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFiles);

		SourceBean sourceBean = new SourceBean();

		sourceBean.setProductId("IPHONE7S");
		sourceBean.setProductPrice(90000);
		sourceBean.setProductionDate("2017-05-20");
		sourceBean.setProductImage(new byte[] { 10, 20, 30, 40, 50 });
		List<String> shopList = new ArrayList<String>();
		shopList.add("Apple");
		shopList.add("Docomo");
		shopList.add("AU");
		shopList.add("SOFTBANK");
		sourceBean.setShopList(shopList);

		DestinationBean destObject = mapper.map(sourceBean, DestinationBean.class);

		System.out.println("PRODUCT_ID:" + destObject.getProductId());
		System.out.println("PRICE:" + destObject.getPrice());
		System.out.println("DATE:" + destObject.getDate());
		System.out.println("PRODUCT_IMAGE:" + destObject.getProductImage());
		System.out.println("SHOP_LIST:" + Arrays.toString(destObject.getShopList()));
	}
}