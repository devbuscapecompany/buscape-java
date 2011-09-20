package com.buscape.developer.result.parser;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.buscape.developer.result.type.Result;

/**
 * Implementation of AbstractResultParser that parses data in XML format to Result.
 * @author cartagena
 */
public final class XmlResultParser extends AbstractResultParser {
	
	private XmlResultParser(String data) {
		super(data);
	}
	
	/**
	 * Creates an instance of {@link XmlResultParser} with provided data.
	 * @param data the raw data, in XML, that will be parsed.
	 * @return a new instance of {@link XmlResultParser},
	 */
	public static AbstractResultParser createInstance(String data) {
		return new XmlResultParser(data);
	}
	
	@Override
	public Result getResult() {

		try {
			JAXBContext jc = JAXBContext.newInstance("com.buscape.developer.result.type"); //$NON-NLS-1$
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			Result result = (Result) unmarshaller.unmarshal(new ByteArrayInputStream(this.data.getBytes()));

			return result;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}


}
