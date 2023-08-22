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
`gender` varchar(255) NOT NULL,
`dateOfBirth` timestamp NOT NULL,
`location` varchar(255) NOT NULL,
`description` varchar(255) NOT NULL,
`chipNumber` int NOT NULL,
`size` varchar(255) NOT NULL,
`animalType` varchar(255) NOT NULL,
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
`approved` Boolean NOT NULL,
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

CREATE TABLE `vets` (
`vetId` varchar(255) NOT NULL DEFAULT (UUID()),
`userId` varchar(255) NOT NULL,
PRIMARY KEY (`vetId`)
);

CREATE TABLE `adopters` (
`adopterId` varchar(255) NOT NULL DEFAULT (UUID()),
`userId` varchar(255) NOT NULL,
PRIMARY KEY (`adopterId`)
);

CREATE TABLE `photos` (
`photoId` varchar(255) NOT NULL DEFAULT (UUID()),
`animalId` varchar(255) NOT NULL,
`photoURL` varchar(255) NOT NULL,
PRIMARY KEY (`photoId`)
);

CREATE TABLE `videos` (
`videoId` varchar(255) NOT NULL DEFAULT (UUID()),
`animalId` varchar(255) NOT NULL,
`videoURL` varchar(255) NOT NULL,
PRIMARY KEY (`videoId`)
);

CREATE TABLE `animalTypes` (
`animalTypeId` varchar(255) NOT NULL DEFAULT (UUID()),
`animalType` varchar(255) NOT NULL,
PRIMARY KEY (`animalTypeId`)
);

# --- password 123
INSERT INTO `users` (`userId`, `email`, `password`, `firstName`, `lastName`, `dateOfBirth`)
VALUES ('d022ab98-403a-11ee-a70e-2cea7f077dd9', 'vanjateodorovic00@gmail.com', '$2a$12$AD1WXBqgWeJm09CFtuNPRu5FNgWBvtAvBmIcfOSfYzgcIsp7TKTbe', 'Vanja', 'Teodorovic', '2000-07-12 00:00:00');
# --- password miki
INSERT INTO `users` (`userId`, `email`, `password`, `firstName`, `lastName`, `dateOfBirth`)
VALUES ('6c125f42-403c-11ee-be56-0242ac120002', 'mihajlo.m1k12000@gmail.com', '$2a$12$hTRrJRLYTuzoWi/yFBIHfez8AJ1xe4zm6xaDST1stm7weG15kNr2u', 'Mihajlo', 'Maksimovic', '2000-04-12 00:00:00');
# --- password vaskica
INSERT INTO `users` (`userId`, `email`, `password`, `firstName`, `lastName`, `dateOfBirth`)
VALUES ('bffeea1c-403c-11ee-be56-0242ac120002', 'saskavujovic00@gmail.com', '$2a$12$.nISyNeIwBLKJdTQy0dyVuImbBbytRrXPwxnizWrQWFzQfiJGu9zC', 'Aleksandra', 'Vujovic', '2000-06-03 00:00:00');

INSERT INTO `admins` (`userId`)
VALUES ('d022ab98-403a-11ee-a70e-2cea7f077dd9');

INSERT INTO `vets` (`userId`)
VALUES ('6c125f42-403c-11ee-be56-0242ac120002');

INSERT INTO `animals` (`animalId`, `name`, `gender`, `dateOfBirth`, `location`, `description`, `chipNumber`, `size`, `animalType`, `sterilized`)
VALUES ('e8b87eec-403b-11ee-be56-0242ac120002', 'Alex', 'Male', '2021-12-12 00:00:00', 'Sabac', 'Good boy', 2000, 'Big', 'Dog', true);
INSERT INTO `animals` (`animalId`, `name`, `gender`, `dateOfBirth`, `location`, `description`, `chipNumber`, `size`, `animalType`, `sterilized`)
VALUES ('2899106c-403c-11ee-be56-0242ac120002', 'Bobo', 'Male', '2020-04-04 00:00:00', 'Sabac', 'Black', 1414, 'Medium', 'Cat', true);
INSERT INTO `animals` (`animalId`, `name`, `gender`, `dateOfBirth`, `location`, `description`, `chipNumber`, `size`, `animalType`, `sterilized`)
VALUES ('2e9c3746-403c-11ee-be56-0242ac120002', 'Nella', 'Female', '2023-07-01 00:00:00', 'Sabac', 'Good boy', 8888, 'Small', 'Dog', false);

INSERT INTO `adoptions` (`animalId`, `userId`, `adoptionDate`, `adoptionStatus`)
VALUES ('2899106c-403c-11ee-be56-0242ac120002', 'bffeea1c-403c-11ee-be56-0242ac120002', '2023-08-21 00:00:00', 'APPROVED');

INSERT INTO `photos` (`animalId`, `photoURL`)
VALUES ('e8b87eec-403b-11ee-be56-0242ac120002', 'beli.jpg');
INSERT INTO `photos` (`animalId`, `photoURL`)
VALUES ('e8b87eec-403b-11ee-be56-0242ac120002', 'beli1.jpg');
INSERT INTO `photos` (`animalId`, `photoURL`)
VALUES ('2899106c-403c-11ee-be56-0242ac120002', 'bobo.jpg');
INSERT INTO `photos` (`animalId`, `photoURL`)
VALUES ('2899106c-403c-11ee-be56-0242ac120002', 'bobo1.jpg');
INSERT INTO `photos` (`animalId`, `photoURL`)
VALUES ('2e9c3746-403c-11ee-be56-0242ac120002', 'nella.jpg');
INSERT INTO `photos` (`animalId`, `photoURL`)
VALUES ('2e9c3746-403c-11ee-be56-0242ac120002', 'nella1.jpg');
INSERT INTO `photos` (`animalId`, `photoURL`)
VALUES ('2e9c3746-403c-11ee-be56-0242ac120002', 'nella2.jpg');

INSERT INTO `animalTypes` (`animalType`)
VALUES ('Dog');
INSERT INTO `animalTypes` (`animalType`)
VALUES ('Cat');
INSERT INTO `animalTypes` (`animalType`)
VALUES ('Bunny');

# --- !Downs

DROP TABLE users;
DROP TABLE animals;
DROP TABLE subscriptions;
DROP TABLE adoptions;
DROP TABLE lostAndFounds;
DROP TABLE vaccines;
DROP TABLE admins;
DROP TABLE vets;
DROP TABLE adopters;
DROP TABLE photos;
DROP TABLE animalTypes;
DROP TABLE play_evolutions;
