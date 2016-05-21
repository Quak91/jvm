## JVM - zadanie 6

###Uruchamianie
mvn clean install exec:java

###Opis
Program pokazuje, że SimpleDateFormat nie jest bezpieczny względem operacji wykonywanych na wielu wątkach. Do zapewnienia "thread safety" skorzystałem z klasy ThreadLocal - dzięki temu każdy wątek dostaje swoją instancję klasy SimpleDateFormat. Nie wymaga synchronizacji.

###Przykładowe wyniki

```
=========================== Unsafe.test() ===========================
Sun Jan 01 00:00:00 CET 243300897
Thu Jan 01 00:00:00 CET 201620161
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
=========================== Safe.test() ===========================
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
Fri Jan 01 00:00:00 CET 2016
```
