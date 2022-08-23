CREATE DATABASE `procurementsystem` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE USER 'ps-admin'@'localhost' IDENTIFIED BY 'ProcurementSystem'; /* change '%' to the ip or localhost depending on choice of location */

GRANT ALL PRIVILEGES ON procurementsystem.* TO 'ps-admin'@'localhost';