package com.buscape.developer.result.parser;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.buscape.developer.result.type.AddressType;
import com.buscape.developer.result.type.AddressesType;
import com.buscape.developer.result.type.CategoryType;
import com.buscape.developer.result.type.ContactType;
import com.buscape.developer.result.type.ContactsType;
import com.buscape.developer.result.type.FilterType;
import com.buscape.developer.result.type.FiltersType;
import com.buscape.developer.result.type.ItemListType;
import com.buscape.developer.result.type.LinkType;
import com.buscape.developer.result.type.LinksType;
import com.buscape.developer.result.type.OfferType;
import com.buscape.developer.result.type.ProductType;
import com.buscape.developer.result.type.Result;
import com.buscape.developer.result.type.SpecificationType;
import com.buscape.developer.util.Messages;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * Implementation of AbstractResultParser that parses data in JSON format to Result.
 * @author cartagena
 */
public final class JsonResultParser extends AbstractResultParser {
	
	private final Gson gson;

	private JsonResultParser(String data) {
		super(data);
		
		Type listOfferType = new TypeToken<List<OfferType>>() {}.getType();
		Type listCategoryType = new TypeToken<List<CategoryType>>() {}.getType();
		Type listProductType = new TypeToken<List<ProductType>>() {}.getType();
		Type listItemType = new TypeToken<List<ItemListType>>() {}.getType();

		gson = new GsonBuilder()
			.setFieldNamingStrategy(new XmlAttributeNamingStrategy())
			.registerTypeAdapter(AddressesType.class, new AddressesTypeDeserializer())
			.registerTypeAdapter(ContactsType.class, new ContactsTypeDeserializer())
			.registerTypeAdapter(FiltersType.class, new FiltersTypeDeserializer())
			.registerTypeAdapter(LinksType.class, new LinksTypeDeserializer())
			
			.registerTypeAdapter(listCategoryType, new CategoryTypeListDeserializer())
			.registerTypeAdapter(listItemType, new ItemListTypeListDeserializer())
			.registerTypeAdapter(listOfferType, new OfferTypeListDeserializer())
			.registerTypeAdapter(listProductType, new ProductTypeListDeserializer())
			
			.registerTypeAdapter(SpecificationType.class, new SpecificationTypeDeserializer())
			
			.registerTypeAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarInstanceCreator())
			.create();
	}

	/**
	 * Creates an instance of {@link JsonResultParser} with provided data.
	 * @param data the raw data, in JSON, that will be parsed.
	 * @return a new instance of {@link JsonResultParser},
	 */
	public static AbstractResultParser createInstance(String data) {
		return new JsonResultParser(data);
	}
	
	@Override
	public Result getResult() {
		if(result == null) {
			JsonObject root = new JsonParser().parse(this.data).getAsJsonObject();
			result = gson.fromJson(root, Result.class);
		}
		
		return result;
	}
	
	private static class XMLGregorianCalendarInstanceCreator implements InstanceCreator<XMLGregorianCalendar> {
		public XMLGregorianCalendar createInstance(Type type) {

			try {
				GregorianCalendar gc = new GregorianCalendar();
				DatatypeFactory dtf = DatatypeFactory.newInstance();
				return dtf.newXMLGregorianCalendar(gc);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}

			return null;
		}
	}

	private static class AddressesTypeDeserializer implements JsonDeserializer<AddressesType> {

		@Override
		public AddressesType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			AddressesType result = new AddressesType();
			List<AddressType> list = new ArrayList<AddressType>();
			
			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject jsonEntry = it.next().getAsJsonObject();
				AddressType entry = context.deserialize(jsonEntry.get(Messages.getString("Json.address-key")), AddressType.class); //$NON-NLS-1$
				list.add(entry);
			}
			
			
			result.setAddress(list);

			return result;
		}
	}
	
	private static class ContactsTypeDeserializer implements JsonDeserializer<ContactsType> {

		@Override
		public ContactsType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			ContactsType result = new ContactsType();
			List<ContactType> list = new ArrayList<ContactType>();
			
			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject jsonEntry = it.next().getAsJsonObject();
				ContactType entry = context.deserialize(jsonEntry.get(Messages.getString("Json.contact-key")), ContactType.class); //$NON-NLS-1$
				list.add(entry);
			}
			
			
			result.setContact(list);

			return result;
		}
	}
	
	private static class FiltersTypeDeserializer implements JsonDeserializer<FiltersType> {

		@Override
		public FiltersType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			FiltersType result = new FiltersType();
			List<FilterType> list = new ArrayList<FilterType>();
			
			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject jsonEntry = it.next().getAsJsonObject();
				FilterType entry = context.deserialize(jsonEntry.get(Messages.getString("Json.contact-key")), FilterType.class); //$NON-NLS-1$
				list.add(entry);
			}
			
			
			result.setFilter(list);

			return result;
		}
	}

	private static class LinksTypeDeserializer implements JsonDeserializer<LinksType> {

		@Override
		public LinksType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			LinksType result = new LinksType();
			List<LinkType> list = new ArrayList<LinkType>();
			
			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject jsonEntry = it.next().getAsJsonObject();
				LinkType entry = context.deserialize(jsonEntry.get(Messages.getString("Json.link-key")),  LinkType.class);  //$NON-NLS-1$
				list.add(entry);
			}
			
			result.setLink(list);

			return result;
		}
	}
	
	private static class CategoryTypeListDeserializer implements JsonDeserializer<List<CategoryType>> {

		@Override
		public List<CategoryType> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<CategoryType> result = new ArrayList<CategoryType>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject jsonEntry = it.next().getAsJsonObject();
				String name = jsonEntry.get(Messages.getString("Json.subcategory-key")) != null ? //$NON-NLS-1$
						Messages.getString("Json.subcategory-key") : //$NON-NLS-1$
						Messages.getString("Json.top5category-key"); //$NON-NLS-1$
				
				CategoryType entry = context.deserialize(jsonEntry.get(name),  CategoryType.class);   
				result.add(entry); 
			}

			return result;
		}
	}
	
	private static class ItemListTypeListDeserializer implements JsonDeserializer<List<ItemListType>> {

		@Override
		public List<ItemListType> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<ItemListType> result = new ArrayList<ItemListType>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject jsonEntry = it.next().getAsJsonObject();
				ItemListType entry = context.deserialize(jsonEntry.get(Messages.getString("Json.item-key")),  ItemListType.class);   //$NON-NLS-1$
				result.add(entry);
			}

			return result;
		}
	}
	
	private static class OfferTypeListDeserializer implements JsonDeserializer<List<OfferType>> {

		@Override
		public List<OfferType> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<OfferType> result = new ArrayList<OfferType>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject jsonEntry = it.next().getAsJsonObject();
				OfferType entry = context.deserialize(jsonEntry.get(Messages.getString("Json.offer-key")),  OfferType.class);   //$NON-NLS-1$
				result.add(entry); 
			}

			return result;
		}
	}
	
	private static class ProductTypeListDeserializer implements JsonDeserializer<List<ProductType>> {

		@Override
		public List<ProductType> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			List<ProductType> result = new ArrayList<ProductType>();

			Iterator<JsonElement> it = json.getAsJsonArray().iterator();
			while (it.hasNext()) {
				JsonObject jsonEntry = it.next().getAsJsonObject();
				ProductType entry = context.deserialize(jsonEntry.get(Messages.getString("Json.product-key")),  ProductType.class);   //$NON-NLS-1$
				result.add(entry); 
			}

			return result;
		}
	}
	
	private static class SpecificationTypeDeserializer implements JsonDeserializer<SpecificationType> {

		@Override
		public SpecificationType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			return json.isJsonArray() ? deserializeArray(json, typeOfT, context) : deserializeObject(json.getAsJsonObject(), typeOfT, context);			
		}
		
		private SpecificationType deserializeArray(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			SpecificationType result = new SpecificationType();
			List<ItemListType> items = result.getItem();
			Type listItemType = new TypeToken<List<ItemListType>>() {}.getType();
		
			List<ItemListType> deserializedItems = context.deserialize(json, listItemType);
			items.addAll(deserializedItems);
			
			return result;
		}
		
		private SpecificationType deserializeObject(JsonObject json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			SpecificationType result = new SpecificationType();
			List<ItemListType> items = result.getItem();
			Type listItemType = new TypeToken<List<ItemListType>>() {}.getType();
			
			if(json.has(Messages.getString("Json.item-key"))) { //$NON-NLS-1$
				List<ItemListType> deserializedItems = context.deserialize(json.get(Messages.getString("Json.item-key")), listItemType); //$NON-NLS-1$
				items.addAll(deserializedItems);			
			}
			
			if(json.has(Messages.getString("Json.links-key"))) { //$NON-NLS-1$
				LinksType deserializedLinks = context.deserialize(json.get(Messages.getString("Json.links-key")), LinksType.class); //$NON-NLS-1$
				result.setLinks(deserializedLinks);
			}
			
			if(json.has(Messages.getString("Json.label-key"))) { //$NON-NLS-1$
				result.setLabel(json.get(Messages.getString("Json.label-key")).getAsString()); //$NON-NLS-1$
			}
			
			return result;
		}
		
	}

	private static class XmlAttributeNamingStrategy implements FieldNamingStrategy {

		@Override
		public String translateName(Field f) {
			XmlAttribute xmlAttribute = f.getAnnotation(XmlAttribute.class);
			if (xmlAttribute != null) {
				return xmlAttribute.name();
			} else {
				return f.getName();
			}
		}
		
	}
}
