CREATE TABLE `product_category` (
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `desc` varchar(255),
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `product_invetory` (
  `id` integer PRIMARY KEY,
  `quantity` integer,
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `products` (
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `desc` text,
  `SKU` varchar(255),
  `category_id` integer,
  `inventory_id` integer,
  `price` decimal,
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `users` (
  `id` integer PRIMARY KEY,
  `username` varchar(255),
  `password` text,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `telephone` integer,
  `preferred_payment_type_id` integer,
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `user_address` (
  `id` integer PRIMARY KEY,
  `user_id` integer,
  `default` boolean,
  `address_line1` varchar(255),
  `address_line2` varchar(255),
  `city` varchar(255),
  `postal_code` varchar(255),
  `country` varchar(255),
  `telephone` varchar(255),
  `mobile` varchar(255)
);

CREATE TABLE `orders` (
  `id` integer PRIMARY KEY,
  `user_id` varchar(255),
  `user_address_id` integer,
  `payment_id` integer,
  `delivery_id` integer,
  `total` decimal,
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `invoices` (
  `id` integer PRIMARY KEY,
  `order_id` integer,
  `invoice_date` date,
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `order_items` (
  `id` integer PRIMARY KEY,
  `order_id` integer,
  `product_id` integer,
  `quantity` integer,
  `price` integer,
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `deliveries` (
  `id` integer PRIMARY KEY,
  `user_id` varchar(255),
  `user_address_id` integer,
  `tracking_id` integer,
  `status` varchar(255) COMMENT 'Initiated, In Transit, Delivered, Canceled',
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `carts` (
  `id` integer PRIMARY KEY,
  `user_id` integer,
  `product_id` integer,
  `status` varchar(255) COMMENT 'Open and Closed',
  `quantity` integer,
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `payment_types` (
  `id` integer PRIMARY KEY,
  `name` varchar(255) COMMENT 'COD, Netbanking, Cards Payment, UPI Payment',
  `status` varchar(255) COMMENT 'Active, Inactive',
  `created_at` timestamp,
  `modified_at` timestamp
);

CREATE TABLE `payments` (
  `id` integer PRIMARY KEY,
  `payment_type_id` integer,
  `user_id` integer,
  `cart_id` integer,
  `transaction_id` integer,
  `amount` decimal,
  `status` varchar(255) COMMENT 'Accepted, Rejected, Pending',
  `created_at` timestamp,
  `modified_at` timestamp
);

ALTER TABLE `products` ADD FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`);

CREATE TABLE `product_invetory_products` (
  `product_invetory_id` integer,
  `products_inventory_id` integer,
  PRIMARY KEY (`product_invetory_id`, `products_inventory_id`)
);

ALTER TABLE `product_invetory_products` ADD FOREIGN KEY (`product_invetory_id`) REFERENCES `product_invetory` (`id`);

ALTER TABLE `product_invetory_products` ADD FOREIGN KEY (`products_inventory_id`) REFERENCES `products` (`inventory_id`);


ALTER TABLE `users` ADD FOREIGN KEY (`preferred_payment_type_id`) REFERENCES `payment_types` (`id`);

ALTER TABLE `user_address` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`user_address_id`) REFERENCES `user_address` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`payment_id`) REFERENCES `payments` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`delivery_id`) REFERENCES `deliveries` (`id`);

ALTER TABLE `invoices` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `order_items` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `order_items` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `deliveries` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `deliveries` ADD FOREIGN KEY (`user_address_id`) REFERENCES `user_address` (`id`);

ALTER TABLE `carts` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `carts` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `payments` ADD FOREIGN KEY (`payment_type_id`) REFERENCES `payment_types` (`id`);

ALTER TABLE `payments` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `payments` ADD FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`);
