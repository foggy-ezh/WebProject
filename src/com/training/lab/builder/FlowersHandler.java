package com.training.lab.builder;

import com.training.lab.constant.FlowersStructure;
import com.training.lab.entity.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class FlowersHandler extends DefaultHandler {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String DASH = "-";
    private static final String UNDERLINE = "_";

    private List<Flower> flowers;
    private Flower currentFlower;
    private FlowersStructure currentElement = null;

    public FlowersHandler(){
        flowers = new ArrayList<>();
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (FlowersStructure.OUTDOOR_FLOWER.getValue().equals(localName)) {
            currentFlower = new OutdoorFlower();
            currentFlower.setName(attributes.getValue(0));
        } else if (FlowersStructure.INDOOR_FLOWER.getValue().equals(localName)) {
            currentFlower = new IndoorFlower();
            currentFlower.setName(attributes.getValue(0));
        } else if(!FlowersStructure.FLOWERS.getValue().equals(localName)){
            currentElement = FlowersStructure.valueOf(localName.toUpperCase().replace(DASH, UNDERLINE));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (FlowersStructure.OUTDOOR_FLOWER.getValue().equals(localName) ||
             FlowersStructure.INDOOR_FLOWER.getValue().equals(localName)) {
            flowers.add(currentFlower);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        String text = new String(ch, start, length).trim();
        if (currentElement != null ){
            switch (currentElement) {
                case ORIGIN:
                    currentFlower.setOrigin(text);
                    break;
                case SOIL:
                    currentFlower.setSoil(SoilType.valueOf(text.toUpperCase().replace(DASH, UNDERLINE)));
                    break;
                case PARAMETERS:
                    currentFlower.setParameters(new Parameters());
                case STEM_COLOR:
                    currentFlower.getParameters().setStemColor(text);
                    break;
                case LEAF_COLOR:
                    currentFlower.getParameters().setLeafColor(text);
                    break;
                case AVG_SIZE:
                    currentFlower.getParameters().setAvgSize(Double.valueOf(text));
                    break;
                case MULTIPLYING:
                    currentFlower.setMultiplying(MultiplyingType.valueOf(text.toUpperCase()));
                    break;
                case GROWING_TIPS:
                    ((IndoorFlower) currentFlower).setGrowingTips(new GrowingTips());
                    break;
                case TEMPERATURE:
                    ((IndoorFlower) currentFlower).getGrowingTips().setTemperature(Double.valueOf(text));
                    break;
                case REQUIRED_LIGHTING:
                    ((IndoorFlower) currentFlower).getGrowingTips().setLightingType(
                            LightingType.valueOf(text.toUpperCase()));
                    break;
                case WATER_NEED:
                    ((IndoorFlower) currentFlower).getGrowingTips().setWaterNeed(Double.valueOf(text));
                    break;
                case BLOOMING_PERIOD:
                    ((OutdoorFlower) currentFlower).setBloomingPeriod(BloomingPeriodType.valueOf(text.toUpperCase()));
                    break;
                default:
                    LOGGER.log(Level.FATAL, "SAX. Wrong Enum element" + currentElement.toString());
                    throw new RuntimeException();
            }
            currentElement = null;
        }
    }
}
