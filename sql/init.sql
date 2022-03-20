CREATE TABLE `app`.`user` (
    `user_id` BIGINT(20) NOT NULL,
    `user_name` VARCHAR(45) NULL,
    `mobile` VARCHAR(20) NULL,
    `mobile_national_code` VARCHAR(6) NULL,
    `email` VARCHAR(60) NULL,
    PRIMARY KEY (`user_id`));
