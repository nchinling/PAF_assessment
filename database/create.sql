-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files



-- create new user 'ncl' and grant access
create user 'ncl'@'localhost' identified by 'Password@123456';
grant ALL PRIVILEGES ON brewery.* TO 'ncl'@'localhost';

--create database/directory named brewery
create database brewery;
USE brewery

--upload. use command prompt, go to folder where the sql files are stored.
--run each commandss 
mysql -u ncl -p brewery < beers.sql
mysql -u ncl -p brewery < breweries.sql
mysql -u ncl -p brewery < categories.sql
mysql -u ncl -p brewery < geocodes.sql
mysql -u ncl -p brewery < styles.sql

