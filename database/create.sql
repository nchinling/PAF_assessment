-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files



-- create new user 'ncl' and grant access
create user 'ncl'@'localhost' identified by 'Password@123456';
grant ALL PRIVILEGES ON brewery.* TO 'ncl'@'localhost';

--create database/directory named brewery
create database brewery;


--create beers table
DROP TABLE IF EXISTS `beers`;
CREATE TABLE `beers` (
  `id` int(21) NOT NULL auto_increment,
  `brewery_id` int(21) NOT NULL default '0',
  `name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `cat_id` int(11) NOT NULL default '0',
  `style_id` int(11) NOT NULL default '0',
  `abv` float NOT NULL default '0',
  `ibu` float NOT NULL default '0',
  `srm` float NOT NULL default '0',
  `upc` int(40) NOT NULL default '0',
  `filepath` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `descript` text character set utf8 collate utf8_unicode_ci NOT NULL,
  `add_user` int(11) NOT NULL default '0',
  `last_mod` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`),
	foreign key(`brewery_id`) references breweries(`id`),
	foreign key(`cat_id`) references categories(`id`),
	foreign key(`style_id`) references styles(`id`)
);