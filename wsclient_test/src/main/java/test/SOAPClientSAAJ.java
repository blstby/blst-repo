package test;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Unmarshaller;  

import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("restriction")
public class SOAPClientSAAJ {

	public static void main(String args[]) throws Exception {
		// Create SOAP Connection
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		String url = "http://localhost:8080/TiersAffaires(Oracle)/ServicesImpl";
//		String filepath = "C:/Users/rnajid/Desktop/file.xml";

		SOAPMessage requestMsg = createSOAPRequest();
//		// File Creation
//		File file = new File(filepath);
//		if (!file.exists()) {
//			file.createNewFile();
//		}
//		FileOutputStream fop = new FileOutputStream(file);
//
		// Sending request to webservice
		SOAPMessage soapResponse = soapConnection.call(requestMsg, url);
		// print SOAP Response
		System.out.print("Response SOAP Message:");
		soapResponse.writeTo(System.out);
		// transforming the response
		Document doc = soapResponse.getSOAPBody().extractContentAsDocument();
		Element root = doc.getDocumentElement();
		doc.renameNode(root, null, "Affaires");

//		 writing the content into xml file
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(doc);
//		StreamResult result = new StreamResult(file);
//		transformer.transform(source, result);

		soapConnection.close();
		
		//Mapping xml document response to Object
		JAXBContext jaxbContext = JAXBContext.newInstance(Affaires.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Affaires aff = (Affaires) jaxbUnmarshaller.unmarshal(doc);

		System.out.println("Affaires:");
		for (Affaire ans : aff.getAffList())
			System.out.println(ans.getId()+" "+ans.getCode_produit()+"  "+ans.getMontant_fin()+"  "+ans.getId_tier());  
	}

	private static SOAPMessage createSOAPRequest() throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		// TargetNamespace
		String serverURI = "http://service.hibernate.com/";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("example", serverURI);

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		// operation name
		SOAPElement soapBodyElem = soapBody.addChildElement("AffaireByTiers", "example");
		// parameter name
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id_Tier");
		// parameter value
		soapBodyElem1.addTextNode("1");
		// SOAPElement soapBodyElem2 =
		// soapBodyElem.addChildElement("LicenseKey", "example");
		// soapBodyElem2.addTextNode("123");

		// MimeHeaders headers = soapMessage.getMimeHeaders();
		// soap action
		// headers.addHeader("SOAPAction", serverURI + "AllTiers");

		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}

}