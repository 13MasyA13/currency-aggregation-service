_Sigma Test Project_

Author : Maksym Holyk.

All documentation contains in 'docs' directory.
All files that uploading when app starts located in ~/files/ directory.

If you want to upload your file it **must be** located in ~/src/upload-files/ directory **and nothing else!**

_**General Rules**_

If you want to set 'buy' or 'sell' price equal to zero you should write it like in follow example "0.0" **and nothing else!**

_**Rules to uploading files**_ (examples are located in 'example' directory):

**.json files**

JSON files **must have** follow structure :

    {
        "currency-n":{
            "currency-code":"XXX"
            "buy":99.99
            "sell":99.99
        }
    }
Where 'n' - is serial number of currency what you want to add, numbers **must be** in ascending order (starts with '0').

'XXX' - three-letter string that indicates the currency code (**ISO 4217**) what you want to add.

 99.99 - numbers type of 'Double', only positive values.

**.csv files**

 CSV files **must have** follow structure : 
 
 **_'XXX', 99.99, 99.99**_
 
 'XXX' - three-letter string that indicates the currency code (**ISO 4217**) what you want to add.
 
 99.99 - numbers type of 'Double', only positive values.
 
 Separator in **.csv** files **must be** ',' (coma).
 
 Every column have **only three** values, after three values there is a new line feed.
 
 **.xml files**
 
 All XML files **must have** structure declared in follow path :
 
 ~/files/bank-schema.xsd
 
 For using this application uses REST API. All documentation is declared in REST_API.md
