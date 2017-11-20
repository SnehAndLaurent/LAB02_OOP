

CREATE DATABASE sakila

CREATE TABLE actor( 
actor_id SMALLINT UNSIGNED, 
first_name VARCHAR(45),
last_name VARCHAR(45),
last_update TIMESTAMP, 
PRIMARY KEY (actor_id)
UNIQUE KEY (actor_id)

);

----------------------------------------
CREATE TABLE address( 
address_id SMALLINT UNSIGNED, 
address VARCHAR(50),
address2 VARCHAR(50),
district VARCHAR(20),
city_id SMALLINT UNSIGNED, 
postal_code VARCHAR(10),
phone VARCHAR(20),
last_update TIMESTAMP, 
PRIMARY KEY (address_id)
UNIQUE KEY (address_id)
FOREIGN KEY (city_id)
);

----------------------------------------
CREATE TABLE category( 
category_id TINYINT UNSIGNED, 
name VARCHAR(25),
last_update TIMESTAMP, 
PRIMARY KEY (category_id)
UNIQUE KEY (category_id)

);

----------------------------------------
CREATE TABLE city( 
city_id SMALLINT UNSIGNED, 
city VARCHAR(50),
country_id SMALLINT UNSIGNED, 
last_update TIMESTAMP, 
PRIMARY KEY (city_id)
UNIQUE KEY (city_id)
FOREIGN KEY (country_id)
);

----------------------------------------
CREATE TABLE country( 
country_id SMALLINT UNSIGNED, 
country VARCHAR(50),
last_update TIMESTAMP, 
PRIMARY KEY (country_id)
UNIQUE KEY (country_id)

);

----------------------------------------
CREATE TABLE customer( 
customer_id SMALLINT UNSIGNED, 
store_id TINYINT UNSIGNED, 
first_name VARCHAR(45),
last_name VARCHAR(45),
email VARCHAR(50),
address_id SMALLINT UNSIGNED, 
active BIT, 
create_date DATETIME, 
last_update TIMESTAMP, 
PRIMARY KEY (customer_id)
UNIQUE KEY (customer_id)
FOREIGN KEY (address_id,store_id)
);

----------------------------------------
CREATE TABLE film( 
film_id SMALLINT UNSIGNED, 
title VARCHAR(255),
description TEXT, 
release_year YEAR, 
language_id TINYINT UNSIGNED, 
original_language_id TINYINT UNSIGNED, 
rental_duration TINYINT UNSIGNED, 
rental_rate DECIMAL (2,4),
length SMALLINT UNSIGNED, 
replacement_cost DECIMAL (2,5),
rating ENUM, 
special_features SET, 
last_update TIMESTAMP, 
PRIMARY KEY (film_id)
UNIQUE KEY (film_id)
FOREIGN KEY (language_id,language_id)
);

----------------------------------------
CREATE TABLE film_actor( 
actor_id SMALLINT UNSIGNED, 
film_id SMALLINT UNSIGNED, 
last_update TIMESTAMP, 
PRIMARY KEY (actor_id,film_id)
UNIQUE KEY (actor_id,film_id)
FOREIGN KEY (actor_id,film_id)
);

----------------------------------------
CREATE TABLE film_category( 
film_id SMALLINT UNSIGNED, 
category_id TINYINT UNSIGNED, 
last_update TIMESTAMP, 
PRIMARY KEY (category_id,film_id)
UNIQUE KEY (film_id,category_id)
FOREIGN KEY (category_id,film_id)
);

----------------------------------------
CREATE TABLE film_text( 
film_id SMALLINT (0,0),
title VARCHAR(255),
description TEXT, 
PRIMARY KEY (film_id)
UNIQUE KEY (film_id)

);

----------------------------------------
CREATE TABLE inventory( 
inventory_id MEDIUMINT UNSIGNED, 
film_id SMALLINT UNSIGNED, 
store_id TINYINT UNSIGNED, 
last_update TIMESTAMP, 
PRIMARY KEY (inventory_id)
UNIQUE KEY (inventory_id)
FOREIGN KEY (film_id,store_id)
);

----------------------------------------
CREATE TABLE language( 
language_id TINYINT UNSIGNED, 
name CHAR(20),
last_update TIMESTAMP, 
PRIMARY KEY (language_id)
UNIQUE KEY (language_id)

);

----------------------------------------
CREATE TABLE payment( 
payment_id SMALLINT UNSIGNED, 
customer_id SMALLINT UNSIGNED, 
staff_id TINYINT UNSIGNED, 
rental_id INT, 
amount DECIMAL (2,5),
payment_date DATETIME, 
last_update TIMESTAMP, 
PRIMARY KEY (payment_id)
UNIQUE KEY (payment_id)
FOREIGN KEY (customer_id,rental_id,staff_id)
);

----------------------------------------
CREATE TABLE rental( 
rental_id INT, 
rental_date DATETIME, 
inventory_id MEDIUMINT UNSIGNED, 
customer_id SMALLINT UNSIGNED, 
return_date DATETIME, 
staff_id TINYINT UNSIGNED, 
last_update TIMESTAMP, 
PRIMARY KEY (rental_id)
UNIQUE KEY (rental_id,rental_date,inventory_id,customer_id)
FOREIGN KEY (customer_id,inventory_id,staff_id)
);

----------------------------------------
CREATE TABLE staff( 
staff_id TINYINT UNSIGNED, 
first_name VARCHAR(45),
last_name VARCHAR(45),
address_id SMALLINT UNSIGNED, 
picture MEDIUMBLOB, 
email VARCHAR(50),
store_id TINYINT UNSIGNED, 
active BIT, 
username VARCHAR(16),
password VARCHAR(40),
last_update TIMESTAMP, 
PRIMARY KEY (staff_id)
UNIQUE KEY (staff_id)
FOREIGN KEY (address_id,store_id)
);

----------------------------------------
CREATE TABLE store( 
store_id TINYINT UNSIGNED, 
manager_staff_id TINYINT UNSIGNED, 
address_id SMALLINT UNSIGNED, 
last_update TIMESTAMP, 
PRIMARY KEY (store_id)
UNIQUE KEY (store_id,manager_staff_id)
FOREIGN KEY (address_id,staff_id)
);

----------------------------------------
CREATE VIEW actor_info( 
actor_id SMALLINT UNSIGNED, 
first_name VARCHAR(45),
last_name VARCHAR(45),
film_info TEXT, 

);

----------------------------------------
CREATE VIEW customer_list( 
ID SMALLINT UNSIGNED, 
name VARCHAR(91),
address VARCHAR(50),
zip code VARCHAR(10),
phone VARCHAR(20),
city VARCHAR(50),
country VARCHAR(50),
notes VARCHAR(6),
SID TINYINT UNSIGNED, 

);

----------------------------------------
CREATE VIEW film_list( 
FID SMALLINT UNSIGNED, 
title VARCHAR(255),
description TEXT, 
category VARCHAR(25),
price DECIMAL (2,4),
length SMALLINT UNSIGNED, 
rating ENUM, 
actors TEXT, 

);

----------------------------------------
CREATE VIEW nicer_but_slower_film_list( 
FID SMALLINT UNSIGNED, 
title VARCHAR(255),
description TEXT, 
category VARCHAR(25),
price DECIMAL (2,4),
length SMALLINT UNSIGNED, 
rating ENUM, 
actors TEXT, 

);

----------------------------------------
CREATE VIEW sales_by_film_category( 
category VARCHAR(25),
total_sales DECIMAL (2,27),

);

----------------------------------------
CREATE VIEW sales_by_store( 
store VARCHAR(101),
manager VARCHAR(91),
total_sales DECIMAL (2,27),

);

----------------------------------------
CREATE VIEW staff_list( 
ID TINYINT UNSIGNED, 
name VARCHAR(91),
address VARCHAR(50),
zip code VARCHAR(10),
phone VARCHAR(20),
city VARCHAR(50),
country VARCHAR(50),
SID TINYINT UNSIGNED, 

);

----------------------------------------
