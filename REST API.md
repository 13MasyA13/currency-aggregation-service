This document allows you get functionality of this service by using REST API

All API methods separated by HTTP methods :

**_GET_**

/allCurrencies - Allows you to get all currencies objects.

/bestOffers - Allows you to get best offers of current avalible currencies 

/buys/{currencyCode} - (where {currency code} is code of currency (ISO 4217))
Allows you to get currency's buys by {currencyCode} parameter.

/buys/{currencyCode}/{typeOfSorting} - Allows you to get currencies buys
by {currencyCode} parameter and {typeOfSorting} (descending or ascending).

/sells/{currencyCode} - Allows you to get currency's sells by {currencyCode} parameter.

/sells/{currencyCode}/{typeOfSort} - Allows you to get currencies sells
                                                by {currencyCode} parameter and {typeOfSorting} (descending or ascending).
                                                
**_POST_**

/{bankName}/{currencyCode}/banSell - Allows you to ban sell of currency by {currencyCode} of {bankName} bank.

/{bankName}/{currencyCode}/banBuy - Allows you to ban buy of currency by {currencyCode} of {bankName} bank.

/{bankName}/{currencyCode}/allowSell - Allows you to allow sell of currency by {currencyCode} of {bankName} bank.

/{bankName}/{currencyCode}/allowBuy - Allows you to allow sell of currency by {currencyCode} of {bankName} bank.

/{bankName}/{currencyCode}/setSell/{value} - Allows you to set the value to sell of {currencyCode} currency of {bankName} bank.

/{bankName}/{currencyCode}/setBuy/{value} - Allows you to set the value to buy of {currencyCode} currency of {bankName} bank.

_**PUT**_

/uploadFile/{fileName} - Allows you to upload file to app. File **must be** in /src/upload-files/ directory. Supported extensions : 
.xml, .csv, .json. If file with the same name already uploaded method returns null.


**_DELETE_**

/deleteBank/{bankName} - Allows you to delete from app bank what you want by {bankName} parameter.