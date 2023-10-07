-- Drop if exists
DROP DATABASE IF EXISTS ecommerce;
DROP USER IF EXISTS 'admin'@'%';

-- Create Database
CREATE DATABASE ecommerce;
CREATE USER 'admin'@'%' IDENTIFIED WITH mysql_native_password BY 'password';
GRANT ALL ON ecommerce.* TO 'admin'@'%';
/* Make sure the privileges are installed */
FLUSH PRIVILEGES;

USE ecommerce;

-- Create Tables
CREATE TABLE `customers` (
  `customer_id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255),
  `password` text,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `email_id` varchar(255) UNIQUE,
  `contact_number` varchar(255) UNIQUE,
  `role` varchar(255) DEFAULT "USER",
  `preferred_payment_type_id` int,
  `preferred_payment_address_id` int,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `authorities` (
  `authority_id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `customer_addresses` (
  `address_id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `address_line1` varchar(255),
  `address_line2` varchar(255),
  `city` varchar(255),
  `state` varchar(255),
  `postal_code` varchar(255),
  `country` varchar(255),
  `phone` varchar(255),
  `is_default` bool,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `products` (
  `product_id` int PRIMARY KEY AUTO_INCREMENT,
  `product_name` varchar(255),
  `description` text,
  `category_id` int NOT NULL,
  `brand` varchar(255),
  `discount` varchar(255),
  `price` decimal,
  `stock_quantity` int,
  `image_url` varchar(255),
  `sku` int COMMENT 'Stock Keeping Unit, A unique identifier used for inventory management.',
  `weight` varchar(255),
  `is_active` varchar(255),
  `rating` varchar(255),
  `reviews_count` varchar(255),
  `manufacturer_part_number` varchar(255),
  `product_url` varchar(255),
  `tax_rate` varchar(255),
  `additional_attributes` varchar(255),
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `categories` (
  `category_id` int PRIMARY KEY AUTO_INCREMENT,
  `category_name` varchar(255) UNIQUE,
  `parent_category_id` int,
  `description` varchar(255),
  `image_url` varchar(255) UNIQUE,
  `is_active` boolean,
  `display_order` int COMMENT 'A numeric value indicating the order in which categories should be displayed on the website or application.',
  `slug` varchar(255) COMMENT 'A URL-friendly version of the category name, useful for creating clean and SEO-friendly URLs.',
  `meta_title` varchar(255) COMMENT 'A title tag used for SEO purposes.',
  `meta_description` varchar(255) COMMENT 'A meta description used for SEO purposes.',
  `meta_keywords` varchar(255) COMMENT 'Meta keywords used for SEO purposes.',
  `custom_attributes` varchar(255) COMMENT 'JSON or other structured data to store additional category attributes, if needed.',
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `invetory` (
  `inventory_id` int PRIMARY KEY AUTO_INCREMENT,
  `product_id` int,
  `quantity` int,
  `location` varchar(255),
  `stock_in_date` timestamp COMMENT 'The date when the product was added or restocked in the inventory.',
  `stock_out_date` timestamp COMMENT 'The date when the product was sold or removed from the inventory.',
  `stock_in_by` int,
  `stock_out_by` int,
  `unit_cost` decimal,
  `expiry_date` timestamp,
  `batch_number` int,
  `supplier_id` int NOT NULL,
  `remarks` varchar(255),
  `reserved_quantity` int,
  `damaged_quantity` int,
  `is_active` boolean,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `suppliers` (
  `supplier_id` int PRIMARY KEY AUTO_INCREMENT,
  `supplier_name` varchar(255),
  `contact_name` varchar(255),
  `email` varchar(255),
  `phone` varchar(255),
  `address` varchar(255),
  `city` varchar(255),
  `state` varchar(255),
  `postal_code` varchar(255),
  `country` varchar(255),
  `website` varchar(255),
  `payment_terms` varchar(255),
  `preferred_shipping_method` varchar(255),
  `tax_id` varchar(255),
  `notes` text,
  `is_active` bool,
  `rating` float,
  `supplier_type` varchar(255),
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `orders` (
  `order_id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int,
  `order_date` datetime,
  `total_amount` decimal,
  `shipping_address_id` int NOT NULL,
  `billing_address` int NOT NULL,
  `is_paid` bool,
  `payment_id` int UNIQUE NOT NULL,
  `delivery_id` int UNIQUE NOT NULL,
  `total` decimal,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `invoices` (
  `invoice_id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `invoice_date` datetime,
  `due_date` datetime,
  `total_amount` decimal,
  `is_paid` bool,
  `payment_date` datetime,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `order_items` (
  `order_item_id` int PRIMARY KEY AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int,
  `unit_price` decimal(10, 2),
  `total_price` decimal(10, 2),
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `deliveries` (
  `delivery_id` int PRIMARY KEY AUTO_INCREMENT,
  `delivery_date` datetime,
  `customer_id` int NOT NULL,
  `customer_address_id` int NOT NULL,
  `tracking_id` int NOT NULL,
  `delivery_notes` text,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `tracking` (
  `tracking_id` int PRIMARY KEY AUTO_INCREMENT,
  `status` varchar(255) COMMENT 'Initiated, In Transit, Delivered, Canceled',
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `carts` (
  `cart_id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `product_id` int UNIQUE NOT NULL,
  `status` varchar(255) COMMENT 'Open, Closed',
  `quantity` int,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `payment_types` (
  `payment_type_id` int PRIMARY KEY AUTO_INCREMENT,
  `payment_type_name` varchar(255) COMMENT 'COD, Netbanking, Cards Payment, UPI Payment',
  `description` varchar(255),
  `is_active` bool,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `payments` (
  `payment_id` int PRIMARY KEY AUTO_INCREMENT,
  `payment_type_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `cart_id` int NOT NULL,
  `payment_date` datetime,
  `amount` decimal,
  `status` varchar(255) COMMENT 'Accepted, Rejected, Pending',
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

ALTER TABLE `customers` add foreign key (`preferred_payment_type_id`) references `payment_types` (`payment_type_id`);
ALTER TABLE `customers` add foreign key (`preferred_payment_address_id`) references `customer_addresses` (`address_id`);
ALTER TABLE `authorities` add foreign key (`customer_id`) references `customers` (`customer_id`);
ALTER TABLE `customer_addresses` add foreign key (`customer_id`) references `customers` (`customer_id`);
ALTER TABLE `products` add foreign key (`category_id`) references `categories` (`category_id`);
ALTER TABLE `categories` add foreign key (`parent_category_id`) references `categories` (`category_id`);
ALTER TABLE `invetory` add foreign key (`product_id`) references `products` (`product_id`);
ALTER TABLE `invetory` add foreign key (`supplier_id`) references `suppliers` (`supplier_id`);
ALTER TABLE `orders` add foreign key (`customer_id`) references `customers` (`customer_id`);
ALTER TABLE `orders` add foreign key (`shipping_address_id`) references `customer_addresses` (`address_id`);
ALTER TABLE `orders` add foreign key (`billing_address`) references `customer_addresses` (`address_id`);
ALTER TABLE `orders` add foreign key (`payment_id`) references `payments` (`payment_id`);
ALTER TABLE `orders` add foreign key (`delivery_id`) references `deliveries` (`delivery_id`);
ALTER TABLE `invoices` add foreign key (`customer_id`) references `customers` (`customer_id`);
ALTER TABLE `order_items` add foreign key (`order_id`) references `orders` (`order_id`);
ALTER TABLE `order_items` add foreign key (`product_id`) references `products` (`product_id`);
ALTER TABLE `deliveries` add foreign key (`customer_id`) references `customers` (`customer_id`);
ALTER TABLE `deliveries` add foreign key (`customer_address_id`) references `customer_addresses` (`address_id`);
ALTER TABLE `deliveries` add foreign key (`tracking_id`) references `tracking` (`tracking_id`);
ALTER TABLE `carts` add foreign key (`customer_id`) references `customers` (`customer_id`);
ALTER TABLE `carts` add foreign key (`product_id`) references `products` (`product_id`);
ALTER TABLE `payments` add foreign key (`payment_type_id`) references `payment_types` (`payment_type_id`);
ALTER TABLE `payments` add foreign key (`customer_id`) references `customers` (`customer_id`);
ALTER TABLE `payments` add foreign key (`cart_id`) references `carts` (`cart_id`);

INSERT INTO `customers` 
(`username`,`password`,`first_name`,`last_name`,`email_id`,`contact_number`,`role`,
`preferred_payment_type_id`,`preferred_payment_address_id`,`created_at`,`modified_at`)
VALUES 
('admin','$2a$12$n2ed/MViZplirBfZss8KFOjhkLt1kRxeIF9UDLinIq6yL1oemt4/S','Admin','Breganza','admin@ecommerce.com','987643210','ADMIN',null,null,now(),now()),
('test','$2a$12$n2ed/MViZplirBfZss8KFOjhkLt1kRxeIF9UDLinIq6yL1oemt4/S','Test','Desuza','test@ecommerce.com','955643210','USER',null,null,now(),now());

INSERT INTO `suppliers`
(`supplier_name`,`contact_name`,`email`,`phone`,`address`,`city`,`state`,`postal_code`,
`country`,`website`,`created_at`,`modified_at`,`payment_terms`,`preferred_shipping_method`,
`tax_id`,`notes`,`is_active`,`rating`,`supplier_type`)
VALUES
('Damodar Supplier','Ashish Dubey','ashish@dubey.com','4578546958','Nimtala Ghat','Jamshedpur','West Bengal','700001','India','https://alekeja.com',now(),now(),null,null,null,null,true,null,null);

INSERT INTO `categories`
(`category_name`,`parent_category_id`,`description`,`image_url`,`is_active`,`display_order`,`slug`,`meta_title`,
`meta_description`,`meta_keywords`,`custom_attributes`,`created_at`,`modified_at`)
VALUES
('Lorem',null,'Lorem ipsum dolor sit amet, consectetur adipiscing elit.','cat (1).jpg',true,1,null,null,null,null,null,now(),now()),
('Phasellus',null,'Phasellus in massa sit amet arcu venenatis commodo.','cat (2).jpg',true,1,null,null,null,null,null,now(),now()),
('Donec',null,'Donec in quam eget sapien consequat dapibus.','cat (3).jpg',true,1,null,null,null,null,null,now(),now()),
('Proin',null,'Proin iaculis turpis eget magna vestibulum pulvinar.','cat (4).jpg',true,1,null,null,null,null,null,now(),now()),
('Suspendisse',null,'Suspendisse non nunc at lectus facilisis dapibus.','cat (5).jpg',true,1,null,null,null,null,null,now(),now()),
('Vestibulum',null,'Vestibulum hendrerit nibh efficitur tellus semper placerat.','cat (6).jpg',true,1,null,null,null,null,null,now(),now()),
('Vivamus',null,'Vivamus non arcu et risus commodo ornare.','cat (7).jpg',true,1,null,null,null,null,null,now(),now()),
('Nulla',null,'Nulla sed odio at magna gravida rutrum at sed quam.','cat (8).jpg',true,1,null,null,null,null,null,now(),now());


INSERT INTO `products`
(`product_name`,`description`,`category_id`,`brand`,`discount`,`price`,`stock_quantity`,
`image_url`,`sku`,`weight`,`is_active`,`rating`,`reviews_count`,`manufacturer_part_number`,
`product_url`,`tax_rate`,`additional_attributes`,`created_at`,`modified_at`)
VALUES
('Vestibulum','Vestibulum efficitur enim eu laoreet fermentum.',1,'Segun',null,100.00,10,'p (1).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Donec volutpat','Donec volutpat nunc vel eros aliquam, in maximus mi tincidunt.',1,'Segun',null,100.00,10,'p (2).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Quisque porta','Quisque porta velit vel nulla dictum elementum nec eu ex.',1,'Segun',null,100.00,10,'p (3).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Vivamus viverra','Vivamus viverra velit in luctus tempor.',1,'Segun',null,100.00,10,'p (4).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nam semper','Nam semper ante id augue imperdiet posuere.',2,'Segun',null,100.00,10,'p (5).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Vivamus lacinia','Vivamus lacinia ante vel porttitor vulputate.',2,'Segun',null,100.00,10,'p (6).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nulla vel','Nulla vel dui sodales, rutrum felis id, vehicula odio.',3,'Segun',null,100.00,10,'p (7).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Phasellus eleifend','Phasellus eleifend est non viverra aliquet.',4,'Segun',null,100.00,10,'p (8).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nunc maximus','Nunc maximus lacus sed eros viverra, at aliquet dolor vulputate.',4,'Segun',null,100.00,10,'p (9).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('In facilisis','In facilisis libero nec tristique mollis.',4,'Segun',null,100.00,10,'p (10).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Sed non','Sed non lectus ultricies, interdum felis ac, semper augue.',4,'Segun',null,100.00,10,'p (11).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Donec vitae','Donec vitae diam lobortis, bibendum libero ut, mattis purus.',4,'Segun',null,100.00,10,'p (12).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Integer at','Integer at nisl commodo, sollicitudin diam et, aliquam erat.',5,'Segun',null,100.00,10,'p (13).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Vivamus quis','Vivamus quis metus malesuada, egestas est nec, tempor turpis.',5,'Segun',null,100.00,10,'p (14).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Cras sit','Cras sit amet ante fermentum, laoreet justo non, pellentesque eros.',5,'Segun',null,100.00,10,'p (15).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Duis vitae','Duis vitae lorem sit amet urna porta auctor.Phasellus id est tempor, consequat sapien eget, iaculis dui.',5,'Segun',null,100.00,10,'p (16).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('In hendrerit','In hendrerit nisl non aliquam venenatis.',6,'Segun',null,100.00,10,'p (17).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Cras ultricies','Cras ultricies nulla sed elit fermentum faucibus.',6,'Segun',null,100.00,10,'p (18).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Vivamus in','Vivamus in lacus lobortis, sodales dui sed, elementum augue.',6,'Segun',null,100.00,10,'p (19).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Maecenas et','Maecenas et quam eget orci pretium tristique at non risus.',6,'Segun',null,100.00,10,'p (20).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nunc pellentesque','Nunc pellentesque mi eget felis pharetra convallis.',6,'Segun',null,100.00,10,'p (21).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Maecenas eget','Maecenas eget ante non dolor lacinia elementum.',6,'Segun',null,100.00,10,'p (22).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Cras egestas','Cras egestas nulla id lacus porttitor porttitor.',7,'Segun',null,100.00,10,'p (23).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nam eu','Nam eu neque nec erat sodales consectetur ac in quam.',7,'Segun',null,100.00,10,'p (24).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nullam at','Nullam at sapien malesuada, blandit tellus ut, euismod erat.',7,'Segun',null,100.00,10,'p (25).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Praesent nec','Praesent nec eros dictum, molestie odio eu, aliquet dui.',7,'Segun',null,100.00,10,'p (26).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Aenean nec','Aenean nec libero sit amet nulla mattis bibendum.',7,'Segun',null,100.00,10,'p (27).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Cras vitae','Cras vitae arcu sed lorem dignissim iaculis sagittis ut dui.',7,'Segun',null,100.00,10,'p (28).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nunc congue','Nunc congue neque non erat mattis rutrum.',7,'Segun',null,100.00,10,'p (29).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Morbi nec','Morbi nec ex lacinia metus tempus dapibus sit amet nec dui.',7,'Segun',null,100.00,10,'p (30).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nullam hendrerit','Nullam hendrerit arcu a libero mollis, sit amet mollis velit porta.',8,'Segun',null,100.00,10,'p (31).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Aenean rhoncus','Aenean rhoncus ligula in pellentesque feugiat.',8,'Segun',null,100.00,10,'p (32).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nullam sed','Nullam sed elit vitae tellus interdum suscipit.',8,'Segun',null,100.00,10,'p (33).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now()),
('Nullam convallis','Nullam convallis est quis ante ullamcorper, id porta urna iaculis.',8,'Segun',null,100.00,10,'p (34).jpg',1,'500 kg',true,3,23,null,null,null,null,now(),now());


INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_USER');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_ADMIN');
