package com.training.lab.builder;

import com.training.lab.entity.*;
import com.training.lab.constant.FlowersStructure;
import com.training.lab.exception.FlowersException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FlowersDOMBuilder extends AbstractFlowersParser {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DASH = "-";
    private static final String UNDERLINE = "_";


    private DocumentBuilder documentBuilder;

    public FlowersDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.FATAL, e);
        }
    }

    public void buildListFlowers(String fileName){
        try {
            Document document = documentBuilder.parse(fileName);
            Element rootElement = document.getDocumentElement();

            NodeList indoorNodeList = rootElement.getElementsByTagName(FlowersStructure.INDOOR_FLOWER.getValue());
            NodeList outdoorNodeList = rootElement.getElementsByTagName(FlowersStructure.OUTDOOR_FLOWER.getValue());
            for (int i = 0; i < indoorNodeList.getLength(); i++) {
                Element flowerElement = (Element) indoorNodeList.item(i);
                Flower flower = buildFlower(flowerElement);
                getFlowers().add(flower);
            }
            for (int i = 0; i < outdoorNodeList.getLength(); i++) {
                Element flowerElement = (Element) outdoorNodeList.item(i);
                Flower flower = buildFlower(flowerElement);
                getFlowers().add(flower);
            }
        } catch (SAXException | IOException | FlowersException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        }
    }

    public Flower buildFlower(Element element) throws FlowersException {
        Flower currentFlower = null;
        if(FlowersStructure.OUTDOOR_FLOWER.getValue().equals(element.getTagName())){
            currentFlower = new OutdoorFlower();
            ((OutdoorFlower) currentFlower).setBloomingPeriod(
                    BloomingPeriodType.valueOf(
                            getElementTextContent(element, FlowersStructure.BLOOMING_PERIOD.getValue())
                                    .toUpperCase().replace(DASH, UNDERLINE)));
        } else if (FlowersStructure.INDOOR_FLOWER.getValue().equals(element.getTagName())){
            currentFlower = new IndoorFlower();
            GrowingTips growingTips = new GrowingTips();
            Element growingTipsElement = (Element) element.
                    getElementsByTagName(FlowersStructure.GROWING_TIPS.getValue()).item(0);
            growingTips.setTemperature(
                    Double.valueOf(getElementTextContent(
                            growingTipsElement,FlowersStructure.TEMPERATURE.getValue())));
            growingTips.setLightingType(
                    LightingType.valueOf(getElementTextContent(growingTipsElement,
                            FlowersStructure.REQUIRED_LIGHTING.getValue()).toUpperCase().replace(DASH, UNDERLINE)));
            growingTips.setWaterNeed(
                    Double.valueOf(getElementTextContent(growingTipsElement,
                            FlowersStructure.WATER_NEED.getValue())));
            ((IndoorFlower) currentFlower).setGrowingTips(growingTips);
        }
        if(currentFlower != null) {
            currentFlower.setName(element.getAttribute(FlowersStructure.NAME.getValue()));
            currentFlower.setSoil(
                    SoilType.valueOf(getElementTextContent(element,
                            FlowersStructure.SOIL.getValue()).toUpperCase().replace(DASH, UNDERLINE)));
            currentFlower.setOrigin(getElementTextContent(element, FlowersStructure.ORIGIN.getValue()));
            currentFlower.setMultiplying(
                    MultiplyingType.valueOf(getElementTextContent(element,
                            FlowersStructure.MULTIPLYING.getValue()).toUpperCase().replace(DASH, UNDERLINE)));
            Parameters parameters = new Parameters();
            Element parametersElement = (Element) element.getElementsByTagName(
                    FlowersStructure.PARAMETERS.getValue()).item(0);
            parameters.setStemColor(getElementTextContent(parametersElement,
                    FlowersStructure.STEM_COLOR.getValue()));
            parameters.setLeafColor(getElementTextContent(parametersElement,
                    FlowersStructure.LEAF_COLOR.getValue()));
            parameters.setAvgSize(Double.valueOf(getElementTextContent(parametersElement,
                    FlowersStructure.AVG_SIZE.getValue())));
            currentFlower.setParameters(parameters);

            return currentFlower;
        } else{
            throw new FlowersException("Wrong Flower type :"+element.getTagName());
        }
    }

    private String getElementTextContent(Element element, String tagName){
        NodeList nodeList = element.getElementsByTagName(tagName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }


}