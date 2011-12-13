package main;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.buscape.developer.result.type.Product;
import com.buscape.developer.result.type.Result;

/**
 * @see http://developer.buscape.com/api/
 * @author cartagena, neto
 * 
 */
public class FindOfferListExample {

	private static final String //
			HOSTNAME = "http://sandbox.buscape.com",//
			SERVICENAME = "/service/findOfferList",//
			APPID = "/564771466d477a4458664d3d",//
			PARAMETERS = "/?productId=222016",//
			URL = HOSTNAME + SERVICENAME + APPID + PARAMETERS;

	/**
	 * 
	 * Executes a basic offer list search
	 * 
	 * Selected Product Id: 222016 Selected Application Id:
	 * 564771466d477a4458664d3d (Test Id)
	 * 
	 * @param args
	 * @throws JAXBException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws JAXBException,
			MalformedURLException {

		JAXBContext jc = JAXBContext.newInstance(Result.class);

		Unmarshaller u = jc.createUnmarshaller();

		Result result = (Result) u.unmarshal(new URL(URL));

		for (Product product : result.getProducts())
			System.out.println(product.getProductShortName());
	}

}
