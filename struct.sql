CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) NOT NULL,
  `username` varchar(30) NOT NULL,
  `realname` varchar(30),
  `role` varchar(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(17) NOT NULL,
  `title` varchar(200) NOT NULL,
  `year` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `cover` varchar(100),
  `count` int(11) NOT NULL,
  `publisher_id` int(11) NOT NULL,
  `description` text,
  `added_at` date,
  PRIMARY KEY (`id`),
  KEY `book_2604cbea` (`publisher_id`),
  CONSTRAINT `publisher_id_70dfdb61_fk_publisher_id` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `book_authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` varchar(17) NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_authors_book_id_eae32fb5_uniq` (`book_id`,`author_id`),
  KEY `book_authors_author_id_ef2e353b_fk_author_id` (`author_id`),
  CONSTRAINT `book_authors_author_id_ef2e353b_fk_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `book_authors_book_id_94d32c0d_fk_book_ISBN` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` varchar(17) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_category_book_id_49f97e3f_uniq` (`book_id`,`category_id`),
  KEY `book_category_category_id_99e880cf_fk_category_id` (`category_id`),
  CONSTRAINT `book_category_category_id_99e880cf_fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `book_category_book_id_d6f28d4a_fk_book_ISBN` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `book_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` varchar(17) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `main_book_owners_book_id_303f824e_uniq` (`book_id`,`user_id`),
  KEY `main_book_owners_user_id_80f057e4_fk_auth_user_id` (`user_id`),
  CONSTRAINT `main_book_owners_book_id_3de5e13f_fk_main_book_ISBN` FOREIGN KEY (`book_id`) REFERENCES `main_book` (`ISBN`),
  CONSTRAINT `main_book_owners_user_id_80f057e4_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
