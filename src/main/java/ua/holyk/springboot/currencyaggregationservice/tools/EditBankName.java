package ua.holyk.springboot.currencyaggregationservice.tools;

/**
 * This class helps you to cut out extension of file to define bank name
 */
public class EditBankName {

    /**
     * This method helps you to cut out extension of file to define bank name
     * @param name Name of file what you want to edit
     * @return Name of bank without extension of file in the end
     */
    public String editBankName(String name) {
            return name.replaceFirst("[.][^.]+$", "");
    }
}
