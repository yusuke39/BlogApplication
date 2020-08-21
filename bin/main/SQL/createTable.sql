CREATE SCHEMA `blog` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

CREATE TABLE `blog`.`users` (
  `user_id` INT NOT NULL,
  `user_name` VARCHAR(50) NOT NULL,
  `user_img` VARCHAR(200) NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `blog_name` VARCHAR(50) NOT NULL,
  `blog_img` VARCHAR(200) NULL,
  `delete_flag` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `blog_name_UNIQUE` (`blog_name` ASC) VISIBLE);

  CREATE TABLE `blog`.`articles` (
  `article_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `article_title` VARCHAR(50) NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `private_flg` INT NOT NULL,
  `delete_flag` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`article_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `blog`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `blog`.`comments` (
  `comment_id` INT NOT NULL,
  `article_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `comment` VARCHAR(200) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `article_id_idx` (`article_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
    FOREIGN KEY (`article_id`)
    REFERENCES `blog`.`articles` (`article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`user_id`)
    REFERENCES `blog`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `blog`.`good_articles` (
  `good_article_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `article_id` INT NOT NULL,
  `save_date` DATETIME NOT NULL,
  PRIMARY KEY (`good_article_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `article_id_idx` (`article_id` ASC) VISIBLE,
    FOREIGN KEY (`user_id`)
    REFERENCES `blog`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`article_id`)
    REFERENCES `blog`.`articles` (`article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `blog`.`save_articles` (
  `save_article_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `article_id` INT NOT NULL,
  `save_date` DATETIME NOT NULL,
  PRIMARY KEY (`save_article_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `article_id_idx` (`article_id` ASC) VISIBLE,
	FOREIGN KEY (`user_id`)
    REFERENCES `blog`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`article_id`)
    REFERENCES `blog`.`articles` (`article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `blog`.`tags` (
  `tag_id` INT NOT NULL,
  `tag_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`tag_id`));

CREATE TABLE `blog`.`tag_articles` (
  `tag_article_id` INT NOT NULL,
  `article_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`tag_article_id`),
  INDEX `article_id_idx` (`article_id` ASC) VISIBLE,
  INDEX `tag_id_idx` (`tag_id` ASC) VISIBLE,
    FOREIGN KEY (`article_id`)
    REFERENCES `blog`.`articles` (`article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`tag_id`)
    REFERENCES `blog`.`tags` (`tag_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `blog`.`article_images` (
  `article_image_id` INT NOT NULL,
  `article_id` INT NOT NULL,
  `article_img` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`article_image_id`),
  INDEX `article_id_idx` (`article_id` ASC) VISIBLE,
    FOREIGN KEY (`article_id`)
    REFERENCES `blog`.`articles` (`article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


