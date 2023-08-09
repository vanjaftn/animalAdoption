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

CREATE TABLE `dogs` (
`dogId` varchar(255) NOT NULL DEFAULT (UUID()),
`name` varchar(255) NOT NULL,
`dateOfBirth` timestamp NOT NULL,
`location` varchar(255) NOT NULL,
`photoURLs` varchar(255) NOT NULL,
`description` varchar(255) NOT NULL,
PRIMARY KEY (`dogId`)
);

CREATE TABLE `subscriptions` (
`subscriptionId` varchar(255) NOT NULL,
`dogId` varchar(255) NOT NULL,
`userId` varchar(255) NOT NULL,
PRIMARY KEY (`subscriptionId`)
);

CREATE TABLE `adoptions` (
`adoptionId` varchar(255) NOT NULL,
`dogId` varchar(255) NOT NULL,
`userId` varchar(255) NOT NULL,
`adoptionDate` timestamp NOT NULL,
PRIMARY KEY (`adoptionId`)
);

# --- !Downs

DROP TABLE users;
DROP TABLE dogs;
DROP TABLE subscriptions;
DROP TABLE adoptions;
