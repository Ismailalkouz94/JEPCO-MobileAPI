//package com.bi.jepco.controller;
//
//import com.bi.jepco.resources.CelsiusToFahrenheitResponse;
//import org.json.JSONObject;
//import org.json.XML;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//import javax.xml.soap.*;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.time.LocalDateTime;
//import java.util.Iterator;
//import java.util.UUID;
//
//@CrossOrigin
//@RestController
//public class SoapTestController {
//
//
//    @RequestMapping(value = "/billInquiry", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
////    @PostMapping("/billInquiry")
//    public ResponseEntity<String> RedirectSpBillInquiry() throws IOException {
//
//        JSONObject requestJson = new JSONObject();
//
//        String uuid = UUID.randomUUID().toString();
//
//        requestJson.put("clientDate", LocalDateTime.now().withNano(0));
//        requestJson.put("requestUuid", uuid);
//
//        String response = "";
//
//        try {
//            String responseString = "";
//            String outputString = "";
//            String wsURL = "https://sp-test.anb.com.sa/ExtSADADBillInq";
//            URL url = new URL(wsURL);
//            URLConnection connection = url.openConnection();
//            HttpURLConnection httpConn = (HttpURLConnection) connection;
//            ByteArrayOutputStream bout = new ByteArrayOutputStream();
//            String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:anb=\"http://www.anb.com.sa/\">\n"
//                    + "   <soapenv:Header/>\n"
//                    + "   <soapenv:Body>\n"
//                    + "      <anb:ExtSADADBillInqRq>\n"
//                    + "         <ExtMsgRqHdr>\n"
//                    + "            <RqMsgUUID>requestUuid</RqMsgUUID>\n"
//                    + "            <SCId>POST</SCId>\n"
//                    + "            <FuncId>functionId</FuncId>\n"
//                    + "            <AgentId>agentId</AgentId>\n"
//                    + "            <ClientDt>clientDate</ClientDt>\n"
//                    + "            <Sec>\n"
//                    + "               <Info>password</Info>\n"
//                    + "               <InfoType>type</InfoType>\n"
//                    + "            </Sec>\n"
//                    + "         </ExtMsgRqHdr>\n"
//                    + "         <Body>\n"
//                    + "            <LangPref>languageParam</LangPref>\n"
//                    + "            <POI>\n"
//                    + "               <POINum>identityNumber</POINum>\n"
//                    + "               <POIType>identityType</POIType>\n"
//                    + "            </POI>\n"
//                    + "            <BillerID>billerId</BillerID>\n"
//                    + "            <SubscriberNum>subscriptionNumber</SubscriberNum>\n"
//                    + "         </Body>\n"
//                    + "      </anb:ExtSADADBillInqRq>\n"
//                    + "   </soapenv:Body>\n"
//                    + "</soapenv:Envelope>";
//
//            Iterator<?> keys = requestJson.keys();
//
//            while (keys.hasNext()) {
//                String key = (String) keys.next();
//                xmlInput = xmlInput.replace(key, requestJson.get(key).toString());
//            }
//
//            System.out.println("xmlInput: " + xmlInput);
//
//            byte[] buffer = new byte[xmlInput.length()];
//            buffer = xmlInput.getBytes();
//            bout.write(buffer);
//            byte[] b = bout.toByteArray();
//            String SOAPAction = "<SOAP action of the webservice to be consumed>";
//
//            httpConn.setRequestProperty("Content-Length",
//                    String.valueOf(b.length));
//            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//            httpConn.setRequestProperty("SOAPAction", SOAPAction);
//            httpConn.setRequestMethod("POST");
//            httpConn.setDoOutput(true);
//            httpConn.setDoInput(true);
//            OutputStream out = httpConn.getOutputStream();
//            out.write(b);
//            out.close();
//
//            InputStreamReader isr = null;
//            if (httpConn.getResponseCode() == 200) {
//                isr = new InputStreamReader(httpConn.getInputStream());
//            } else {
//                isr = new InputStreamReader(httpConn.getErrorStream());
//            }
//
//            BufferedReader in = new BufferedReader(isr);
//
//            while ((responseString = in.readLine()) != null) {
//                outputString = outputString + responseString;
//            }
//
//            System.out.println("bill Inq: " + outputString);
//
//            JSONObject xmlJSONObj = XML.toJSONObject(outputString);
//            response = xmlJSONObj.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body").toString();
//
//        } catch (MalformedURLException mue) {
//            mue.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new ResponseEntity<String>(response, HttpStatus.valueOf(200));
//    }
//
//
//    @RequestMapping(value = "/soap", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public String soap(){
//        String soapEndpointUrl = "https://www.w3schools.com/xml/tempconvert.asmx";
//        String soapAction = "https://www.w3schools.com/xml/CelsiusToFahrenheit";
//
//        callSoapWebService(soapEndpointUrl, soapAction);
//        return "ok";
//    }
//
//    private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
//        SOAPPart soapPart = soapMessage.getSOAPPart();
//
//        String myNamespace = "myNamespace";
//        String myNamespaceURI = "https://www.w3schools.com/xml/";
//
//        // SOAP Envelope
//        SOAPEnvelope envelope = soapPart.getEnvelope();
//        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
//
//            /*
//            Constructed SOAP Request Message:
//            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="https://www.w3schools.com/xml/">
//                <SOAP-ENV:Header/>
//                <SOAP-ENV:Body>
//                    <myNamespace:CelsiusToFahrenheit>
//                        <myNamespace:Celsius>100</myNamespace:Celsius>
//                    </myNamespace:CelsiusToFahrenheit>
//                </SOAP-ENV:Body>
//            </SOAP-ENV:Envelope>
//            */
//
//        // SOAP Body
//        SOAPBody soapBody = envelope.getBody();
//        SOAPElement soapBodyElem = soapBody.addChildElement("CelsiusToFahrenheit", myNamespace);
//        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Celsius", myNamespace);
//        soapBodyElem1.addTextNode("500");
//    }
//
//    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
//        try {
//            // Create SOAP Connection
//            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//
//            // Send SOAP Message to SOAP Server
//            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);
//
//            // Print the SOAP Response
//            System.out.println("Response SOAP Message:");
//            soapResponse.writeTo(System.out);
//            System.out.println();
//
////            try {
////
////
////                JAXBContext jaxbContext = JAXBContext.newInstance(CelsiusToFahrenheitResponse.class);
////
////                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
////                CelsiusToFahrenheitResponse jaxbExample = (CelsiusToFahrenheitResponse) jaxbUnmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
////                System.out.println(jaxbExample);
////
////            } catch (JAXBException e) {
////                e.printStackTrace();
////            }
//
//            soapConnection.close();
//        } catch (Exception e) {
//            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
//            e.printStackTrace();
//        }
//    }
//
//    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
//        MessageFactory messageFactory = MessageFactory.newInstance();
//        SOAPMessage soapMessage = messageFactory.createMessage();
//
//        createSoapEnvelope(soapMessage);
//
//        MimeHeaders headers = soapMessage.getMimeHeaders();
//        headers.addHeader("SOAPAction", soapAction);
//
//        soapMessage.saveChanges();
//
//        /* Print the request message, just for debugging purposes */
//        System.out.println("Request SOAP Message:");
//        soapMessage.writeTo(System.out);
//        System.out.println("\n");
//
//
//
//
//        return soapMessage;
//    }
//
//
//
//
//}
