package com.buscape.developer;

import com.buscape.developer.http.HttpRequester;
import com.buscape.developer.request.Country;
import com.buscape.developer.request.Filter;
import com.buscape.developer.request.Parameters;
import com.buscape.developer.request.ParametersBuilder;
import com.buscape.developer.request.Service;
import com.buscape.developer.request.util.URLBuilder;
import com.buscape.developer.result.ResultFormat;
import com.buscape.developer.result.parser.AbstractResultParser;
import com.buscape.developer.result.type.Result;

/**
 * Buscapé API wrapper
 * 
 * @author neto
 */
public final class Lomadee {

	private final String applicationId;
	
	private final String sourceId;

	private final BuscapeFactory factory;

	private final Country countryCode;

	private final Filter filter;
	
	private final ResultFormat format;

	/**
	 * Constructs a wrapper object to Buscapé API, with <code>BRAZIL</code> as
	 * country and <code>XML</code> as default result format.
	 * 
	 * @param applicationId
	 *            identification of application which will use the API.
	 * @param filter
	 *            default filter for all requests made in API.
	 */
	public Lomadee(String applicationId, String sourceId, Filter filter) {
		this(applicationId, sourceId, filter, Country.BRAZIL, ResultFormat.XML);
	}
	
	/**
	 * Constructs a wrapper object to Buscapé API, with <code>BRAZIL</code> as
	 * country.
	 * 
	 * @param applicationId
	 *            identification of application which will use the API.
	 * @param filter
	 *            default filter for all requests made in API.
	 * @param format 
	 * 			  default result format of requests.
	 */
	public Lomadee(String applicationId, String sourceId, Filter filter, ResultFormat format) {
		this(applicationId, sourceId, filter, Country.BRAZIL, format);
	}

	/**
	 * Constructs a wrapper object to Buscapé API.
	 * 
	 * @param applicationId
	 *            identification of application which will use the API. 
	 * @param filter
	 *            default filter for all requests made in API.
	 * @param countryCode
	 *            code of country where the API will be used.            
	 * @param format 
	 * 			  default result format of requests.
	 */
	public Lomadee(String applicationId, String sourceId, Filter filter, Country countryCode, ResultFormat format) {
		super();
		this.applicationId = applicationId;
		this.sourceId = sourceId;
		this.countryCode = countryCode;
		this.filter = filter;
		this.format = format;
		this.factory = new BuscapeFactory();
	}

	/**
	 * Calls the Category List (<i>findCategoryList</i>) service and return a {@link Result} object
	 * containing the result of this request. 
	 * @param categoryId identification of category which will be listed.
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result categoryList(int categoryId) throws BuscapeException {
		return callCategoryList(new ParametersBuilder().categoryId(categoryId).build());
	}
	
	/**
	 * Calls the Category List (<i>findCategoryList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param keyword keyword used to filter the categories.
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result categoryList(String keyword) throws BuscapeException {
		return callCategoryList(new ParametersBuilder().keyword(keyword).build());
	}
	
	/**
	 * Calls the Product List (<i>findProductList</i>) service and return a {@link Result} object
	 * containing the result of this request. 
	 * @param categoryId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result productList(int categoryId, String keyword) throws BuscapeException {
		return callProductList(new ParametersBuilder().categoryId(categoryId).keyword(keyword).build());
	}
	
	/**
	 * Calls the Product List (<i>findProductList</i>) service and return a {@link Result} object
	 * containing the result of this request. 
	 * @param categoryId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result productList(int categoryId) throws BuscapeException {
		return callProductList(new ParametersBuilder().categoryId(categoryId).build());
	}
	
	/**
	 * Calls the Product List (<i>findProductList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param keyword keyword used to filter the products.
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result productList(String keyword) throws BuscapeException {
		return callProductList(new ParametersBuilder().keyword(keyword).build());
	}
		
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param categoryId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerListByCategory(int categoryId) throws BuscapeException {
		return callOfferList(new ParametersBuilder().categoryId(categoryId).build());
	}
	
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param productId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerListByProduct(int productId) throws BuscapeException {
		return callOfferList(new ParametersBuilder().productId(productId).build());
	}
	
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param barcode TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerListByBarcode(String barcode) throws BuscapeException {
		return callOfferList(new ParametersBuilder().barcode(barcode).build());
	}
	
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param keyword TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerListByKeyword(String keyword) throws BuscapeException {
		return callOfferList(new ParametersBuilder().keyword(keyword).build());
	}
	
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param categoryId TODO
	 * @param keyword TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerList(int categoryId, String keyword) throws BuscapeException {
		return callOfferList(new ParametersBuilder().keyword(keyword).categoryId(categoryId).build());
	}
	
	private Result callCategoryList(Parameters f) throws BuscapeException {
		return callGenericService(Service.LIST_CATEGORY, f);
	}
	
	private Result callProductList(Parameters f) throws BuscapeException {
		return callGenericService(Service.LIST_PRODUCT, f);
	}
	
	private Result callOfferList(Parameters f) throws BuscapeException {
		return callGenericService(Service.LIST_OFFER, f);
	}
	
	private Result callCoupons(Parameters f) throws BuscapeException {
		return callGenericService(Service.COUPONS, f);
	}
	
	private Result callGenericService(Service service, Parameters f) throws BuscapeException {
		String url = new URLBuilder().service(service).lomadee(true).applicationId(applicationId).sourceId(sourceId).countryCode(countryCode).formatFilter(format).filter(this.filter).parameters(f).build();
		String data = callService(url);
		AbstractResultParser builder = getResultBuilder(data);

		return builder.getResult();
	}

	private String callService(String url) throws BuscapeException {
		try {
			final HttpRequester request = new HttpRequester(url);
			
			return request.getResponse();
		} catch (Exception e) {
			throw new BuscapeException(String.format("Erro on calling service: %s.", url), e); //$NON-NLS-1$
		}
	}
	
	private AbstractResultParser getResultBuilder(String data) {
		return factory.createParser(data, format);
	}
}