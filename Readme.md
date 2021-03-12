# AliExpressParser

TCP client for download data from page https://flashdeals.aliexpress.com/en.htm.
Downloaded data saves in SCV file.
The principle of operation is based on the use of a link obtained by analyzing the work of the original page.

Build

```bash
./gradlew build
```

Allow script execution
```bash
chmod +x ./AliExpressParser 
```

Run application
```bash
./AliExpressParser 
```

Run application using only jar file
```bash
java -jar ./build/libs/AliExpressParser-1.0-all.jar 
```

### Technologies

* Java 8
* Gradle
* GSON
* OpenCSV

### Output example

| Title                                                                                                                            | Original min price | Original max price | Min price | Max price  | Discount, % | Number of reviews | Positive rate | Average star | URL                                                                                                                                                                                |
|----------------------------------------------------------------------------------------------------------------------------------|--------------------|--------------------|-----------|------------|-------------|-------------------|---------------|--------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Wholesale Mink Eyelashes 30/40/50/100pcs 3d Mink Lashes Natural false Eyelashes messy fake Eyelashes Makeup False Lashes In Bulk | US $13.38          | US $278.00         | US $6.02  | US $125.10 | 55,0        | 775               | 95,0          | 4,7          | //aliexpress.ru/item/1005001483534438.html?gps-id=5547572&scm=1007.19201.130907.0&scm_id=1007.19201.130907.0&scm-url=1007.19201.130907.0&pvid=e0997056-8457-4a63-afb2-08bdf748d908 |
| CHEAP Deep Wave Wig Transparent Lace Frontal Wigs Wet And Wavy Curly Human Hair Wigs T Part Remy Brazilian Deep Wave Frontal Wig | US $163.11         | US $663.66         | US $45.67 | US $185.82 | 72,0        | 501               | 96,6          | 4,8          | //aliexpress.ru/item/4000510698820.html?gps-id=5547572&scm=1007.19201.130907.0&scm_id=1007.19201.130907.0&scm-url=1007.19201.130907.0&pvid=e0997056-8457-4a63-afb2-08bdf748d908    |
| UWIGS 613 Blonde Lace Front Wig Human Hair 30 inch Body Wave Lace Front Wig Transparent Lace Frontal Wigs For Black Women Remy   | US $131.19         | US $650.01         | US $53.79 | US $266.50 | 59,0        | 566               | 93,0          | 4,7          | //aliexpress.ru/item/4000804721321.html?gps-id=5547572&scm=1007.19201.130907.0&scm_id=1007.19201.130907.0&scm-url=1007.19201.130907.0&pvid=e0997056-8457-4a63-afb2-08bdf748d908    |
