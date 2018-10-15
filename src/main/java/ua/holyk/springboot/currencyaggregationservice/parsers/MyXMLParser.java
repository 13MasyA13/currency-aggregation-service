package ua.holyk.springboot.currencyaggregationservice.parsers;

import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import ua.holyk.springboot.currencyaggregationservice.tools.EditBankName;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class allows you to parse .xml files
 */
public class MyXMLParser implements Parse {

    EditBankName editBankName = new EditBankName();

    /**
     * This method parses all .xml files to ExchangeRates objects
     * @param files ArrayList of files witch defines in folder for parse
     * @return ArrayList of ExchangeRates objects
     */
    @Override
    public ArrayList<ExchangeRates> parseListOfFiles(ArrayList<File> files) {
        ArrayList<ExchangeRates> currencyList = new ArrayList<>();

        for(int i = 0; i < files.size(); i++) {
            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(files.get(i));
                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("currency");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;

                        ExchangeRates exchangeRates = new ExchangeRates();

                        exchangeRates.setNameOfBank(editBankName.editBankName(files.get(i).getName()));
                        exchangeRates.setCurrencyCode(eElement
                                .getElementsByTagName("currencyCode").item(0)
                                .getTextContent());
                        exchangeRates.setSell(Double.parseDouble(eElement
                                .getElementsByTagName("sell").item(0).getTextContent()));
                        exchangeRates.setBuy(Double.parseDouble(eElement
                                .getElementsByTagName("buy").item(0).getTextContent()));

                        CurrencyAggregationServiceApplication.currencyCodes.add(exchangeRates.getCurrencyCode());
                        CurrencyAggregationServiceApplication.bankNames.add(exchangeRates.getNameOfBank());
                        CurrencyAggregationServiceApplication.fileNames.add(files.get(i).getName());

                        exchangeRates.setAllowedToSell(true);
                        exchangeRates.setAllowedToBuy(true);

                        currencyList.add(exchangeRates);
                    }
                }

            } catch (ParserConfigurationException exc) {

            } catch (SAXException exc) {

            } catch (IOException exc) {

            }
        }
        return currencyList;
    }

    /**
     * This method helps to parse one file with .xml extension
     * @param file File what you want to parse to ExchangeRates object
     * @return ExchangeRates object
     */
    @Override
    public ArrayList<ExchangeRates> parseOneFile(File file) {
        ArrayList<ExchangeRates> list = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("currency");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    ExchangeRates exchangeRates = new ExchangeRates();
                    exchangeRates.setNameOfBank(editBankName.editBankName(file.getName()));
                    exchangeRates.setCurrencyCode(eElement
                            .getElementsByTagName("currencyCode").item(0)
                            .getTextContent());
                    exchangeRates.setSell(Double.parseDouble(eElement
                            .getElementsByTagName("sell").item(0).getTextContent()));
                    exchangeRates.setBuy(Double.parseDouble(eElement
                            .getElementsByTagName("buy").item(0).getTextContent()));

                    exchangeRates.setAllowedToSell(true);
                    exchangeRates.setAllowedToBuy(true);

                    CurrencyAggregationServiceApplication.currencyCodes.add(exchangeRates.getCurrencyCode());
                    CurrencyAggregationServiceApplication.bankNames.add(exchangeRates.getNameOfBank());
                    CurrencyAggregationServiceApplication.finalList.add(exchangeRates);
                    CurrencyAggregationServiceApplication.fileNames.add(file.getName());

                    list.add(exchangeRates);
                }
            }
        } catch (ParserConfigurationException exc) {

        } catch (SAXException exc) {

        } catch (IOException exc) {

        }
        return list;
    }
}
