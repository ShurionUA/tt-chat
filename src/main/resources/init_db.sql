CREATE SCHEMA IF NOT EXISTS `chat` DEFAULT CHARACTER SET utf8;
USE `chat`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for users
-- ----------------------------
CREATE TABLE IF NOT EXISTS `users` (
                `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

    -- ----------------------------
-- Table structure for messages
-- ----------------------------
CREATE TABLE IF NOT EXISTS `messages` (
                `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                `user_id` bigint unsigned NOT NULL,
                PRIMARY KEY (`id`)  USING BTREE,
                KEY `FK_user_id` (`user_id`) USING BTREE,
                CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
