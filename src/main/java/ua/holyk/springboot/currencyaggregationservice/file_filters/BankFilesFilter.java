package ua.holyk.springboot.currencyaggregationservice.file_filters;


import java.io.File;
import java.util.ArrayList;

/**
 * This class allows you to find all files what will load to app's memory
 */
public class BankFilesFilter implements Filter {

    private String pathToFiles = "./src/files/";

    private File filesFolder = new File(pathToFiles);

    private JSONFileFilter jsonFileFilter = new JSONFileFilter();
    private XMLFileFilter xmlFileFilter = new XMLFileFilter();
    private CSVFileFilter csvFileFilter = new CSVFileFilter();

    /**
     * This method helps you to find all .JSON files
     * @return List of all .json files
     */
    public ArrayList<File> JSONFiles() {
        File[] JSONfiles = filesFolder.listFiles(jsonFileFilter);
        ArrayList<File> JSON_list = new ArrayList<File>();

        for (int i = 0; i < JSONfiles.length; i++) {
            JSON_list.add(JSONfiles[i]);
        }
        return JSON_list;
    }

    /**
     * This method helps you to find all .XML files
     * @return List of all .xml files
     */
    public ArrayList<File> XMLFiles() {
        File[] XMLFiles = filesFolder.listFiles(xmlFileFilter);
        ArrayList<File> XML_list = new ArrayList<File>();

        for (int i = 0; i < XMLFiles.length; i++) {
            XML_list.add(XMLFiles[i]);
        }
        return XML_list;
    }

    /**
     * This method helps you to find all .CSV files
     * @return List of all .csv files
     */
    public ArrayList<File> CSVFiles() {
        File[] CSVFiles = filesFolder.listFiles(csvFileFilter);
        ArrayList<File> CSV_list = new ArrayList<File>();

        for (int i = 0; i < CSVFiles.length; i++) {
            CSV_list.add(CSVFiles[i]);
        }
        return CSV_list;
    }
}
