package com.bi.jepco.controller;

import com.bi.jepco.utils.MessageBody;
import com.bi.jepco.resources.reportproblem.*;
import com.bi.jepco.utils.Utils;
import com.squareup.okhttp.*;
import com.squareup.okhttp.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/reportProblem")
public class ReportProblemController {

    private final String WS_URL = "http://192.168.91.20/XMLJepcoNew/issue.asmx";

    //لمحافظات almohafzat
    @RequestMapping(value = "/getProvincesList/{lang}", method = RequestMethod.GET)
    public ResponseEntity<MessageBody> getBranchList(@PathVariable("lang") Integer lang) throws IOException {

        String outputString = null;
        List<GetProvincesList> provincesList = new ArrayList<>();
        try {

            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <GetBranchList xmlns=\"http://tempuri.org/\">\n" +
                    "      <CompanyID>1</CompanyID>\n" +
                    "      <Lang>" + lang + "</Lang>\n" +
                    "    </GetBranchList>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>");
            Request request = new Request.Builder()
                    .url("http://192.168.91.20/XMLJepcoNew/issue.asmx")
                    .post(body)
                    .addHeader("Content-Type", "text/xml")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            outputString = response.body().string();

            if (response.code() != 200) {
                MessageBody messageBody = MessageBody.getInstance();
                messageBody.setStatus("error");
                messageBody.setKey("error");
                messageBody.setBody(null);
                return new ResponseEntity<>(messageBody, HttpStatus.INTERNAL_SERVER_ERROR);
            }


            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(outputString)));

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Table");
            GetProvincesList provinces = null;
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    provinces = new GetProvincesList();
                    provinces.setBranchId(Integer.parseInt(eElement.getElementsByTagName("BranchID").item(0).getTextContent()));
                    provinces.setDesc1(eElement.getElementsByTagName("desc1").item(0).getTextContent());
                    provinces.setDesc2(eElement.getElementsByTagName("desc2").item(0).getTextContent());
                    provinces.setCountry(eElement.getElementsByTagName("Country").item(0).getTextContent());
                    provinces.setCode(Integer.parseInt(eElement.getElementsByTagName("code").item(0).getTextContent()));

                }
                provincesList.add(provinces);
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(provincesList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


    @RequestMapping(value = "/getAreaList/{provinceId}/{lang}", method = RequestMethod.GET)
    public ResponseEntity<MessageBody> getAreaList(@PathVariable("provinceId") Integer provinceId, @PathVariable("lang") Integer lang) throws IOException {

        String outputString = null;
        List<GetAreaList> areaList = new ArrayList<>();
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <GetProjectServicesList xmlns=\"http://tempuri.org/\">\n" +
                    "      <UserID>1</UserID>\n" +
                    "      <ProjectID>1</ProjectID>\n" +
                    "      <BranchID>" + provinceId + "</BranchID>\n" +
                    "      <Lang>" + lang + "</Lang>\n" +
                    "    </GetProjectServicesList>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>");
            Request request = new Request.Builder()
                    .url("http://192.168.91.20/XMLJepcoNew/issue.asmx")
                    .post(body)
                    .addHeader("Content-Type", "text/xml")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            outputString = response.body().string();

            if (response.code() != 200) {
                MessageBody messageBody = MessageBody.getInstance();
                messageBody.setStatus("error");
                messageBody.setKey("error");
                messageBody.setBody(null);
                return new ResponseEntity<>(messageBody, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(outputString)));

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Table");
            GetAreaList area = null;
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    area = new GetAreaList();
                    area.setServiceId(Integer.parseInt(eElement.getElementsByTagName("ServiceID").item(0).getTextContent()));
                    area.setDesc(eElement.getElementsByTagName("Desc1").item(0).getTextContent());

                }
                areaList.add(area);
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(areaList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


    @RequestMapping(value = "/getNeighborhood/{areaId}/{provinceId}/{lang}", method = RequestMethod.GET)
    public ResponseEntity<MessageBody> getNeighborhood(@PathVariable("areaId") Integer areaId,
                                                       @PathVariable("provinceId") Integer provinceId,
                                                       @PathVariable("lang") Integer lang) throws IOException {

        String outputString = null;
        List<GetNeighborhoodList> neighborhoodList = new ArrayList<>();
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <GetServiceCategories xmlns=\"http://tempuri.org/\">\n" +
                    "      <ServiceID>" + areaId + "</ServiceID>\n" +
                    "      <BranchID>" + provinceId + "</BranchID>\n" +
                    "      <Lang>" + lang + "</Lang>\n" +
                    "    </GetServiceCategories>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>");
            Request request = new Request.Builder()
                    .url("http://192.168.91.20/XMLJepcoNew/issue.asmx")
                    .post(body)
                    .addHeader("Content-Type", "text/xml")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            outputString = response.body().string();

            if (response.code() != 200) {
                MessageBody messageBody = MessageBody.getInstance();
                messageBody.setStatus("error");
                messageBody.setKey("error");
                messageBody.setBody(null);
                return new ResponseEntity<>(messageBody, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(outputString)));

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Table");
            GetNeighborhoodList neighborhood = null;
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    neighborhood = new GetNeighborhoodList();
                    neighborhood.setCode(Integer.parseInt(eElement.getElementsByTagName("code").item(0).getTextContent()));
                    neighborhood.setDesc(eElement.getElementsByTagName("Desc1").item(0).getTextContent());

                }
                neighborhoodList.add(neighborhood);
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(neighborhoodList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


    @RequestMapping(value = "/getStreetList/{provinceId}/{neighborhoodId}/{lang}", method = RequestMethod.GET)
    public ResponseEntity<MessageBody> getStreetList(@PathVariable("provinceId") Integer provinceId,
                                                     @PathVariable("neighborhoodId") Integer neighborhoodId,
                                                     @PathVariable("lang") Integer lang) throws IOException {

        String outputString = null;
        List<GetStreetList> streetList = new ArrayList<>();
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <getIssueSubCategories xmlns=\"http://tempuri.org/\">\n" +
                    "      <BranchID>" + provinceId + "</BranchID>\n" +
                    "      <Lang>" + lang + "</Lang>\n" +
                    "      <MajorCategoryID>" + neighborhoodId + "</MajorCategoryID>\n" +
                    "      <orderby>1</orderby>\n" +
                    "      <OrderByType>1</OrderByType>\n" +
                    "    </getIssueSubCategories>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>");
            Request request = new Request.Builder()
                    .url("http://192.168.91.20/XMLJepcoNew/issue.asmx")
                    .post(body)
                    .addHeader("Content-Type", "text/xml")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            outputString = response.body().string();
            if (response.code() != 200) {
                MessageBody messageBody = MessageBody.getInstance();
                messageBody.setStatus("error");
                messageBody.setKey("error");
                messageBody.setBody(null);
                return new ResponseEntity<>(messageBody, HttpStatus.INTERNAL_SERVER_ERROR);
            }


            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(outputString)));

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Table");

            GetStreetList street = null;
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    street = new GetStreetList();
                    street.setCode(Integer.parseInt(eElement.getElementsByTagName("code").item(0).getTextContent()));
                    street.setDesc(eElement.getElementsByTagName("Desc1").item(0).getTextContent());

                }
                streetList.add(street);
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(streetList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


    @RequestMapping(value = "/submitIssue", method = RequestMethod.POST)
    public ResponseEntity<MessageBody> submitIssue(@org.springframework.web.bind.annotation.RequestBody SubmitIssue submitIssue) throws IOException {

        submitIssue.setAttachName(Utils.randomNumber(10)+".jpg");
        String outputString = null;
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("text/xml");
            RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <JEPCO_IssueSave xmlns=\"http://tempuri.org/\">\n" +
                    "      <BranchID>" + submitIssue.getProvinceId() + "</BranchID>\n" +
                    "      <RequesterMobile>" + submitIssue.getRequesterMobile().substring(4) + "</RequesterMobile>\n" +
                    "      <RequesterName>" + submitIssue.getRequesterName() + "</RequesterName>\n" +
                    "      <RequesterTel>" + submitIssue.getCounterNumber() + "</RequesterTel>\n" +
                    "      <ServiceID>" + submitIssue.getAreaId() + "</ServiceID>\n" +
                    "      <CategoryID>" + submitIssue.getNeighborhoodId() + "</CategoryID>\n" +
                    "      <SubCategoryID>" + submitIssue.getStreetId() + "</SubCategoryID>\n" +
                    "      <AttachName>" + submitIssue.getAttachName() + "</AttachName>\n" +
                    "      <AttachValue>" + submitIssue.getAttachValue() + "</AttachValue>\n" +
                    "      <SubItemID>-1</SubItemID>\n" +
                    "      <IssueTitle>Report a Problem</IssueTitle>\n" +
                    "      <IssueDescription>" + submitIssue.getDescription() + "</IssueDescription>\n" +
                    "    </JEPCO_IssueSave>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>");
            Request request = new Request.Builder()
                    .url("http://192.168.91.20/XMLJepcoNew/issue.asmx")
                    .post(body)
                    .addHeader("Content-Type", "text/xml")
                    .addHeader("Cache-Control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            outputString = response.body().string();


            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(outputString)));

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("JEPCO_IssueSaveResponse");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    outputString = eElement.getElementsByTagName("JEPCO_IssueSaveResult").item(0).getTextContent();
                }
            }

            if (response.code() != 200) {
                MessageBody messageBody = MessageBody.getInstance();
                messageBody.setStatus("error");
                messageBody.setKey("error");
                messageBody.setBody(outputString);
                return new ResponseEntity<>(messageBody, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(outputString);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
