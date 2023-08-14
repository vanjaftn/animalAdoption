# --- !Ups

CREATE TABLE `users` (
`userId` varchar(255) NOT NULL DEFAULT (UUID()),
`email` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
`firstName` varchar(255) NOT NULL,
`lastName` varchar(255) NOT NULL,
`dateOfBirth` timestamp NOT NULL,
PRIMARY KEY (`userId`)
);

CREATE TABLE `animals` (
`animalId` varchar(255) NOT NULL DEFAULT (UUID()),
`name` varchar(255) NOT NULL,
`dateOfBirth` timestamp NOT NULL,
`location` varchar(255) NOT NULL,
`photoURLs` varchar(255) NOT NULL,
`description` varchar(255) NOT NULL,
`chipNumber` int NOT NULL,
`size` varchar(255) NOT NULL,
`animalTypeId` varchar(255) NOT NULL,
`sterilized` Boolean NOT NULL,
PRIMARY KEY (`animalId`)
);

CREATE TABLE `subscriptions` (
`subscriptionId` varchar(255) NOT NULL DEFAULT (UUID()),
`animalId` varchar(255) NOT NULL,
`userId` varchar(255) NOT NULL,
PRIMARY KEY (`subscriptionId`)
);

CREATE TABLE `adoptions` (
`adoptionId` varchar(255) NOT NULL DEFAULT (UUID()),
`animalId` varchar(255) NOT NULL,
`userId` varchar(255) NOT NULL,
`adoptionDate` timestamp NOT NULL,
`adoptionStatus` varchar(255) NOT NULL,
PRIMARY KEY (`adoptionId`)
);

CREATE TABLE `lostAndFounds` (
`lostAndFoundId` varchar(255) NOT NULL DEFAULT (UUID()),
`animalId` varchar(255) NOT NULL,
`userId` varchar(255) NOT NULL,
`lostAndFoundDate` timestamp NOT NULL,
`lostAndFoundStatus` varchar(255) NOT NULL,
PRIMARY KEY (`lostAndFoundId`)
);

CREATE TABLE `vaccines` (
`vaccineId` varchar(255) NOT NULL DEFAULT (UUID()),
`vaccineType` varchar(255) NOT NULL,
`animalId` varchar(255) NOT NULL,
`vetId` varchar(255) NOT NULL,
`vaccineDate` timestamp NOT NULL,
PRIMARY KEY (`vaccineId`)
);

CREATE TABLE `admins` (
`adminId` varchar(255) NOT NULL DEFAULT (UUID()),
`userId` varchar(255) NOT NULL,
PRIMARY KEY (`adminId`)
);

# --- !Downs

DROP TABLE users;
DROP TABLE animals;
DROP TABLE subscriptions;
DROP TABLE adoptions;
DROP TABLE lostAndFounds;
DROP TABLE vaccines;
DROP TABLE admins;
