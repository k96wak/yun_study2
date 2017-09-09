package jp.co.sisolution.example1;

import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class DozerExample1 {
	public static void main(String[] args) {
		SourceObject sourceObject = new SourceObject();
		sourceObject.setName("hoge");
		sourceObject.setDate(new Date());
		
		/*DestinationObject dest = new DestinationObject();
		dest.setDate(sourceObject.getDate().toString());
		dest.setName(sourceObject.getName());*/
		
		Mapper mapper = new DozerBeanMapper();
		DestinationObject destObject = mapper.map(sourceObject, DestinationObject.class);
		
		System.out.println("NAME:" + destObject.getName());
		System.out.println("DATE:" + destObject.getDate());
	}
}