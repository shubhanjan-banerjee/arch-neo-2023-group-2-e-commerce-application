USE ECOMMERCE;

-- Insert Data

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
