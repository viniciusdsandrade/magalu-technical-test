-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_magalu_technical_test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_magalu_technical_test`;

-- -----------------------------------------------------
-- Schema db_magalu_technical_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_magalu_technical_test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `db_magalu_technical_test`;

-- -----------------------------------------------------
-- Table `tb_channel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_channel`;

CREATE TABLE IF NOT EXISTS `tb_channel`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_channel_description` (`description` ASC) VISIBLE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tb_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_status`;

CREATE TABLE IF NOT EXISTS `tb_status`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_status_description` (`description` ASC) VISIBLE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tb_notification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tb_notification`;

CREATE TABLE IF NOT EXISTS `tb_notification`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `date_time`   DATETIME(6)  NULL DEFAULT NULL,
    `destination` VARCHAR(255) NULL DEFAULT NULL,
    `message`     LONGTEXT     NULL DEFAULT NULL,
    `channel_id`  BIGINT       NOT NULL,
    `status_id`   BIGINT       NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_notification_channel` (`channel_id` ASC) VISIBLE,
    INDEX `fk_notification_status` (`status_id` ASC) VISIBLE,
    CONSTRAINT `fk_notification_channel`
        FOREIGN KEY (`channel_id`)
            REFERENCES `tb_channel` (`id`),
    CONSTRAINT `fk_notification_status`
        FOREIGN KEY (`status_id`)
            REFERENCES `tb_status` (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
