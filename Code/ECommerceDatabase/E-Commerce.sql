-- Drop if exists
DROP DATABASE IF EXISTS ECOMMERCE;
DROP USER IF EXISTS 'admin'@'%';

-- Create Database
CREATE DATABASE ECOMMERCE;
CREATE USER 'admin'@'%' IDENTIFIED WITH mysql_native_password BY 'password';
GRANT ALL ON ECOMMERCE.* TO 'admin'@'%';
/* Make sure the privileges are installed */
FLUSH PRIVILEGES;
USE ECOMMERCE;

-- Create Tables
CREATE TABLE `CUSTOMERS` (
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

CREATE TABLE `AUTHORITIES` (
  `authority_id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `CUSTOMER_ADDRESSES` (
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

CREATE TABLE `PRODUCTS` (
  `product_id` int PRIMARY KEY AUTO_INCREMENT,
  `product_name` varchar(255),
  `description` text,
  `category_id` int NOT NULL,
  `brand` varchar(255),
  `discount` varchar(255),
  `price` decimal,
  `stock_quantity` varchar(255),
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

CREATE TABLE `CATEGORIES` (
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

CREATE TABLE `INVETORY` (
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

CREATE TABLE `SUPPLIERS` (
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

CREATE TABLE `ORDERS` (
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

CREATE TABLE `INVOICES` (
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

CREATE TABLE `ORDER_ITEMS` (
  `order_item_id` int PRIMARY KEY AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int,
  `unit_price` decimal(10, 2),
  `total_price` decimal(10, 2),
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `DELIVERIES` (
  `delivery_id` int PRIMARY KEY AUTO_INCREMENT,
  `delivery_date` datetime,
  `customer_id` int NOT NULL,
  `customer_address_id` int NOT NULL,
  `tracking_id` int NOT NULL,
  `delivery_notes` text,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `TRACKING` (
  `tracking_id` int PRIMARY KEY AUTO_INCREMENT,
  `status` varchar(255) COMMENT 'Initiated, In Transit, Delivered, Canceled',
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `CARTS` (
  `cart_id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `product_id` int UNIQUE NOT NULL,
  `status` varchar(255) COMMENT 'Open, Closed',
  `quantity` int,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `PAYMENT_TYPES` (
  `payment_type_id` int PRIMARY KEY AUTO_INCREMENT,
  `payment_type_name` varchar(255) COMMENT 'COD, Netbanking, Cards Payment, UPI Payment',
  `description` varchar(255),
  `is_active` bool,
  `created_at` timestamp DEFAULT (now()),
  `modified_at` timestamp
);

CREATE TABLE `PAYMENTS` (
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

ALTER TABLE `CUSTOMERS` ADD FOREIGN KEY (`preferred_payment_type_id`) REFERENCES `PAYMENT_TYPES` (`payment_type_id`);
ALTER TABLE `CUSTOMERS` ADD FOREIGN KEY (`preferred_payment_address_id`) REFERENCES `CUSTOMER_ADDRESSES` (`address_id`);
ALTER TABLE `AUTHORITIES` ADD FOREIGN KEY (`customer_id`) REFERENCES `CUSTOMERS` (`customer_id`);
ALTER TABLE `CUSTOMER_ADDRESSES` ADD FOREIGN KEY (`customer_id`) REFERENCES `CUSTOMERS` (`customer_id`);
ALTER TABLE `PRODUCTS` ADD FOREIGN KEY (`category_id`) REFERENCES `CATEGORIES` (`category_id`);
ALTER TABLE `CATEGORIES` ADD FOREIGN KEY (`parent_category_id`) REFERENCES `CATEGORIES` (`category_id`);
ALTER TABLE `INVETORY` ADD FOREIGN KEY (`product_id`) REFERENCES `PRODUCTS` (`product_id`);
ALTER TABLE `INVETORY` ADD FOREIGN KEY (`supplier_id`) REFERENCES `SUPPLIERS` (`supplier_id`);
ALTER TABLE `ORDERS` ADD FOREIGN KEY (`customer_id`) REFERENCES `CUSTOMERS` (`customer_id`);
ALTER TABLE `ORDERS` ADD FOREIGN KEY (`shipping_address_id`) REFERENCES `CUSTOMER_ADDRESSES` (`address_id`);
ALTER TABLE `ORDERS` ADD FOREIGN KEY (`billing_address`) REFERENCES `CUSTOMER_ADDRESSES` (`address_id`);
ALTER TABLE `ORDERS` ADD FOREIGN KEY (`payment_id`) REFERENCES `PAYMENTS` (`payment_id`);
ALTER TABLE `ORDERS` ADD FOREIGN KEY (`delivery_id`) REFERENCES `DELIVERIES` (`delivery_id`);
ALTER TABLE `INVOICES` ADD FOREIGN KEY (`customer_id`) REFERENCES `CUSTOMERS` (`customer_id`);
ALTER TABLE `ORDER_ITEMS` ADD FOREIGN KEY (`order_id`) REFERENCES `ORDERS` (`order_id`);
ALTER TABLE `ORDER_ITEMS` ADD FOREIGN KEY (`product_id`) REFERENCES `PRODUCTS` (`product_id`);
ALTER TABLE `DELIVERIES` ADD FOREIGN KEY (`customer_id`) REFERENCES `CUSTOMERS` (`customer_id`);
ALTER TABLE `DELIVERIES` ADD FOREIGN KEY (`customer_address_id`) REFERENCES `CUSTOMER_ADDRESSES` (`address_id`);
ALTER TABLE `DELIVERIES` ADD FOREIGN KEY (`tracking_id`) REFERENCES `TRACKING` (`tracking_id`);
ALTER TABLE `CARTS` ADD FOREIGN KEY (`customer_id`) REFERENCES `CUSTOMERS` (`customer_id`);
ALTER TABLE `CARTS` ADD FOREIGN KEY (`product_id`) REFERENCES `PRODUCTS` (`product_id`);
ALTER TABLE `PAYMENTS` ADD FOREIGN KEY (`payment_type_id`) REFERENCES `PAYMENT_TYPES` (`payment_type_id`);
ALTER TABLE `PAYMENTS` ADD FOREIGN KEY (`customer_id`) REFERENCES `CUSTOMERS` (`customer_id`);
ALTER TABLE `PAYMENTS` ADD FOREIGN KEY (`cart_id`) REFERENCES `CARTS` (`cart_id`);

-- Insert Data
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE `ecommerce`.`customers`;
TRUNCATE TABLE `ecommerce`.`suppliers`;
TRUNCATE TABLE `ecommerce`.`categories`;
TRUNCATE TABLE `ecommerce`.`products`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `ecommerce`.`customers` 
(`username`,`password`,`first_name`,`last_name`,`email_id`,`contact_number`,`role`,
`preferred_payment_type_id`,`preferred_payment_address_id`,`created_at`,`modified_at`)
VALUES 
('admin','$2a$12$n2ed/MViZplirBfZss8KFOjhkLt1kRxeIF9UDLinIq6yL1oemt4/S','Admin','Breganza','admin@ecommerce.com','987643210','ADMIN',null,null,now(),now()),
('test','$2a$12$n2ed/MViZplirBfZss8KFOjhkLt1kRxeIF9UDLinIq6yL1oemt4/S','Test','Desuza','test@ecommerce.com','955643210','USER',null,null,now(),now());

INSERT INTO `ecommerce`.`suppliers`
(`supplier_name`,`contact_name`,`email`,`phone`,`address`,`city`,`state`,`postal_code`,
`country`,`website`,`created_at`,`modified_at`,`payment_terms`,`preferred_shipping_method`,
`tax_id`,`notes`,`is_active`,`rating`,`supplier_type`)
VALUES
('Damodar Supplier','Ashish Dubey','ashish@dubey.com','4578546958','Nimtala Ghat','Jamshedpur','West Bengal','700001','India','https://alekeja.com',now(),now(),null,null,null,null,true,null,null);

INSERT INTO `ecommerce`.`categories`
(`category_name`,`parent_category_id`,`description`,`image_url`,`is_active`,`display_order`,`slug`,`meta_title`,
`meta_description`,`meta_keywords`,`custom_attributes`,`created_at`,`modified_at`)
VALUES
('Chair',null,'All types of chair','chair.jpg',true,null,null,null,null,null,null,now(),now());

INSERT INTO `ecommerce`.`products`
(`product_name`,`description`,`category_id`,`brand`,`discount`,`price`,`stock_quantity`,
`image_url`,`sku`,`weight`,`is_active`,`rating`,`reviews_count`,`manufacturer_part_number`,
`product_url`,`tax_rate`,`additional_attributes`,`created_at`,`modified_at`)
VALUES
('Easy Chair','It is an easy chair',1,'Segun',null,100.00,10,'easy_char.jpg',null,'500 kg',true,3,23,null,null,null,null,now(),now());

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_USER');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_ADMIN');
