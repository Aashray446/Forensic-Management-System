<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Forensic_Management_System_0"></a>Forensic Management System</h1>
<h3 class="code-line" data-line-start=1 data-line-end=2 ><a id="Members_1"></a>Members</h3>
<h5 class="code-line" data-line-start=2 data-line-end=3 ><a id="Aashraya_Katiyar_2"></a>Aashraya Katiyar</h5>
<h5 class="code-line" data-line-start=3 data-line-end=4 ><a id="Aksaj_SR_3"></a>Aksaj S.R</h5>
<h5 class="code-line" data-line-start=4 data-line-end=5 ><a id="Sumitha_4"></a>Sumitha</h5>
<h5 class="code-line" data-line-start=5 data-line-end=6 ><a id="Nandana_5"></a>Nandana</h5>
<h5 class="code-line" data-line-start=6 data-line-end=7 ><a id="Ronak_6"></a>Ronak</h5>
<h5 class="code-line" data-line-start=7 data-line-end=8 ><a id="Nikhil_7"></a>Nikhil</h5>
<h3 class="code-line" data-line-start=12 data-line-end=13 ><a id="Database_Handling_Instruction_12"></a>Database Handling Instruction</h3>
<p class="has-line-data" data-line-start="14" data-line-end="19">We used .csv to store data in out system. There is a <strong>handle_dbms</strong> class in the Helper Class folder. You can create a instance of the class and have the following operations : - &lt;/ br&gt;<br>
<strong>1</strong>. Object.write_to_file(Data as string, Filename as String)  <strong style="color:red;"><em>[ Will add the data at the end of the file]</em></strong><br>
<strong>2</strong>. object.append(Data as string, Filename as String) <strong><em>[ Will overwrite the file with the given data, mostly used for editing any kind of prev data]</em></strong><br>
<strong>3</strong>. object.read(Filename as String) <strong><em>[Will return the data of csv file as ArrayList of type String object ]</em></strong><br>
<strong>3</strong>. object.convert_to_string(Filename as String) <strong><em>[Will convert the ArrayList data back to CSV format i.e string, to be supplied to append ]</em></strong></p>

