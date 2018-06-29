User Manual

### Facebook Twitter Data Collector and Analyzer Software

 ###
This software let’s the user fetch data from facebook and twitter and let's the user preprocess the data and apply some queries on the data.. 
From facebook, the data can be downloaded from any public page or group. From twitter, the data is fetched based on hashtag.



### Features
This software can
	1. Fetch public data from facebook based on Group/page id.
	2. Fetch tweet from twitter based on Hashtag.
	3. PreProcess the data which includes Create new row, edit existing row, delete row, merge more than one file etc.
	4. The fetched data can be saved as json format for convenience and later load into the software.
	5. The json file can be load into mysql and some queries can be executed on the data. Results can be also saved as json file.




### Prerequisites


1. Java Runtime Environment(JRE) version 1.8
2. Facebook App id and App secret, user Accesstoken
3. Twitter accesstoken, accesstokenSecret, consumerKey, ConsumerKeySecret

4. You need a local server with 3306 port for mysql and ‘ftdca’ must be created in the database upfront without the quotes. For this, xampp is easier to use.




### Environment Setup
1. Make sure you have java 1.8 installed on your machine. If not, go to https://www.oracle.com/technetwork/java/javase/downloads/index.html and download and install.
2. Download and install Xampp if you do not have this from https://www.apachefriends.org/download.html
3. To get Twitter credentials, follow this official guide https://developer.twitter.com/en/docs/basics/authentication/guides/access-tokens.html
4. For facebook credentials, follow this official guide https://developers.facebook.com/docs/apps/register/
5. To get user access token, go to https://developers.facebook.com/tools/explorer/    (This token is valid for 2 hours only, so you need to update it every 2 hours)
6. Start Apache and Mysql services from Xampp
7. Go to https://localhost/phpmyadmin and create a database named 'ftdca' without the quotes, under the user `root` having no password set.
8. Double click FTDCA.jar to run
9. Register your account with valid credentials

### How to use
1. To collect facebook data
	Start Apache and Mysql from xampp
      	Login into your account
	Click Facebook Button from Menu
	Enter your Acccesstoken
	Enter group/page id and click Search button
	Then click "Save" button after the data has been fetched.

2. To collect data from Twitter
	Start Apache and mysql from xampp
	Login into your account
	Click Twitter button from menu
	Enter the hashtag you want to search with # infront of the tag. Ex: #WorldCup
	Enter the number of tweet
	Click Search button
	Save after the data has been fetched.

3. To preprocess the data
	Load the json file you saved earlier
	To Create a new row, Enter the data in the textfield named "Add New Row" and click "Add"
	To delete a row, Enter the "Id" of the row which is the 1st column.
	To update a row, simply click on that row and edit.
	To CLear the table, click "Clear Table" button.
	To go back to menu, click "Menu" button.
	TO merge more than one json files, just load them one after another.
4. To Load data into mysql
	Load the desired json file using "Choose" Button
	"Clear" button will clear the table from the software as well as from the mysql.
	"Menu" button will return you to menu page.
	If you want to execute any query on the data, write the query and click "Execute" button. The tablename will be the same as the name of the json file except the file extension.
	Clicking the save button will save the data that are available on the table of the software.
	

#Limitations
	1. The number of attributes is 4. The type of the data(since it is from a single page/group from fb or based on hashtag from twitter), actual post/tweet, date of creation and post/tweet id.
	2. The database name must be 'ftdca'  and user name of the mysql must be root and no password must be set. 
	   This are chosen for convenience because without these, user has to enter this information every time they want to use the software.
 	3. Rate limit per user is 15 requests. To know more visit: https://developers.twitters.com/docs/basics/rate-limits.html
	   If data fetching from twitter is not working after some usage, change the credentials.

