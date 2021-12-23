# Forensic Management System
### Members
##### Aashraya Katiyar
##### Aksaj S.R
##### Sumitha 
##### Nandana
##### Ronak
##### Nikhil




### Database Handling Instruction

We used .csv to store data in out system. There is a **handle_dbms** class in the Helper Class folder. You can create a instance of the class and have the following operations : -
**1**. Object.write_to_file(Data as string, Filename as String)  ***[ Will add the data at the end of the file]***
**2**. object.append(Data as string, Filename as String) ***[ Will overwrite the file with the given data, mostly used for editing any kind of prev data]***
**3**. object.read(Filename as String) ***[Will return the data of csv file as ArrayList of type String object ]***
**3**. object.convert_to_string(Filename as String) ***[Will convert the ArrayList data back to CSV format i.e string, to be supplied to append ]***
