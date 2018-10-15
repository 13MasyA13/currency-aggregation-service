package ua.holyk.springboot.currencyaggregationservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.holyk.springboot.currencyaggregationservice.CurrencyAggregationServiceApplication;
import ua.holyk.springboot.currencyaggregationservice.entities.ExchangeRates;
import ua.holyk.springboot.currencyaggregationservice.parsers.MyCSVParser;
import ua.holyk.springboot.currencyaggregationservice.parsers.MyJSONParser;
import ua.holyk.springboot.currencyaggregationservice.parsers.MyXMLParser;

import javax.ws.rs.PUT;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class uses for uploading file to the service
 */
@RestController
public class UploadFileController {

    /**
     * This method allows you to upload file what you declare in param
     * @param fileName name of file what you declare
     * @return list of items in file
     */
    @PUT
    @RequestMapping(value = "/uploadFile/{fileName}")
    public ArrayList<ExchangeRates> uploadFile(@PathVariable String fileName) {
        String pathToFile = "./src/upload-files/" + fileName;
        File file = new File(pathToFile);

        Iterator<String> iterator = CurrencyAggregationServiceApplication.fileNames.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(file.getName())){
                return null;
            }
        }

        if(file.getName().endsWith(".json")) {
            MyJSONParser jsonParser = new MyJSONParser();
            ArrayList<ExchangeRates> list = jsonParser.parseOneFile(file);

            list.stream().forEach(x -> CurrencyAggregationServiceApplication.finalList.add(x));
            return list;
        } else if(file.getName().endsWith(".xml")) {
            MyXMLParser myXMLParser = new MyXMLParser();
            ArrayList<ExchangeRates> list = myXMLParser.parseOneFile(file);
            list.stream().forEach(x -> CurrencyAggregationServiceApplication.finalList.add(x));

            return list;
        } else if(file.getName().endsWith(".csv")) {
            MyCSVParser myCSVParser = new MyCSVParser();
            ArrayList<ExchangeRates> list = myCSVParser.parseOneFile(file);
            list.stream().forEach(x -> CurrencyAggregationServiceApplication.finalList.add(x));

            return list;
        } else {
            return null;
        }
    }
}
