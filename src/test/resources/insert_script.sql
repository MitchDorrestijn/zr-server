-- -----------------------------------------------------

-- Schema zorgrit

-- -----------------------------------------------------





-- -----------------------------------------------------

-- Insert

-- -----------------------------------------------------

INSERT INTO `utility` (name, priority) VALUES('scootmobiel', 3,);

INSERT INTO `utility` (name, priority) VALUES( 'rolstoel', 2,);

INSERT INTO `utility` (name, priority) VALUES(  'rollator', 1);




INSERT INTO `limitation` (name) VALUES('geestelijk gehandicapten');

 INSERT INTO `limitation` (name) VALUES ('zware/Fysieke handicap');

 INSERT INTO `limitation` (name) VALUES ('ouderen');




INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)
VALUES('Wiedo', 'Harkema', 'Wiede@gmail.com', '0612345678', 'Kerkstraat', 7, '1234GB', 'Arnhem', 'wachtwoord', 'abc', '1995-06-23');

INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Robin', 'Schuiling', 'Robin@hotmail.com', '0687654321', 'Dorpstraat', 33, '1234EF', 'Arnhem', 'test', 'fgh', '1997-10-07');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Koen', 'van Keulen', 'koen@yahoo.com', '0678945612', 'Dorplaan', 12, '5673TR', 'Wageningen', 'pass', 'wer', '1997-10-07');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Hoang', 'Nguyen', 'hoang@outlook.com', '0645698712', 'Kruisweg', 7, '2845DF', 'Duiven', 'ww', 'cvb', '1992-02-25');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Piet', 'Jansen', 'piet@jansen.nl', '0638458975', 'Gemeentelaan', 78, '4595HG', 'Nijmegen', 'sesamopenu', 'ghg', '1958-12-13');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Henk', 'Jansen', 'henk@jansen.nl', '0638458976', 'Dorpsweg', 78, '4597HG', 'Nijmegen', 'sesamopenu', 'ghg', '1958-12-13');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Jan', 'Jansen', 'jan@jansen.nl', '0638458977', 'tulpenlaan', 78, '4548HG', 'Nijmegen', 'sesamopenu', 'ghg', '1958-12-13');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Clemens', 'van Barneveld', 'clemens@vanbarneveld.net', '0613657226', 'Dorpsstraat', 83, '5673TR', 'Wageningen', 'sesamopenu', 'ghg', '1958-12-13');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Mitch', 'Zantingh', 'mitch@zantingh.net', '063515266', 'Dorpsstraat', 83, '6932HG', 'Westervoort', 'sesamopenu', 'ghg', '1955-11-17');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Abdirizak', 'Middelburg', 'abdirizakc@kpn.net', '0623458256', 'Johannes Husslaan', 13, '1185BK', 'Amstelveen', 'sesamopenu', 'ghg', '1992-12-11');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Kashif', 'Niewold', 'kashif@niewold.net', '0623458256', 'Hooicamp', 25, '3992BW', 'Houten', 'sesamopenu', 'ghg', '1986-12-11');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Iefke', 'Vloet', 'iefke@vloet.com', '0623458256', 'Haverakker', 102, '2743EJ', 'Waddinxveen', 'sesamopenu', 'ghg', '1989-04-16');
INSERT INTO `user` (firstName, lastName, email, phoneNumber, street, houseNumber, zipCode, residence, password, PasswordSalt, dateOfBirth)

VALUES('Mickey', 'van Zanten', 'mickey@tielmobiel.net', '0623458256', 'Marga Klompestraat', 140, '4133HN', 'Vianen', 'sesamopenu', 'ghg', '1964-02-23');



INSERT INTO `client` (clientId, companion, driverPreferenceForced, warningPKB, PKB, companionRequired, image, bankaccount) VALUES
  (2, 'Sven', FALSE, TRUE, 500, FALSE, NULL, 'NL63RABE3559999235');

INSERT INTO `client` (clientId, companion, driverPreferenceForced, warningPKB, PKB, companionRequired, image, bankaccount) VALUES(
  3, 'Henk', FALSE, TRUE, 500, FALSE, NULL, 'NL63RABE3559999235');

INSERT INTO `client` (clientId, companion, driverPreferenceForced, warningPKB, PKB, companionRequired, image, bankaccount) VALUES(
  5, NULL, FALSE, TRUE, 500, FALSE, NULL, 'NL63RABE3559999235');

INSERT INTO `client` (clientId, companion, driverPreferenceForced, warningPKB, PKB, companionRequired, image, bankaccount) VALUES(
  6, 'Klaas', FALSE, TRUE, 500, FALSE, NULL, 'NL63RABE3559999235');

INSERT INTO `client` (clientId, companion, driverPreferenceForced, warningPKB, PKB, companionRequired, image, bankaccount) VALUES(
  7, NULL, TRUE, TRUE, 500, FALSE, NULL, 'NL63RABE3559999235');




INSERT INTO `driver` (driverId, verification, typeOfPayment, image, accountnr) VALUES

  (1, TRUE, 'Vrijwillig', 'base64String', 'NLING3102347823974');

INSERT INTO `driver` (driverId, verification, typeOfPayment, image, accountnr) VALUES(4, FALSE, 'Vrijwillig', 'base64String', 'NLABNB0324320948');

INSERT INTO `driver` (driverId, verification, typeOfPayment, image, accountnr) VALUES(8, FALSE, 'Vrijwillig', 'base64String', 'NLRABO0FSDKJHJKFDS');

INSERT INTO `driver` (driverId, verification, typeOfPayment, image, accountnr) VALUES(9, FALSE, 'Vrijwillig', 'base64String', 'NLKNAB04758678782');

INSERT INTO `driver` (driverId, verification, typeOfPayment, image, accountnr) VALUES(10, FALSE, 'Vrijwillig', 'base64String', 'NLDSB0932483234');

INSERT INTO `driver` (driverId, verification, typeOfPayment, image, accountnr) VALUES(11, FALSE, 'Vrijwillig', 'base64String', 'NLVLSCH042837462334');

INSERT INTO `driver` (driverId, verification, typeOfPayment, image, accountnr) VALUES(12, FALSE, 'Vrijwillig', 'base64String', 'NLSNS03235454234323');

INSERT INTO `driver` (driverId, verification, typeOfPayment, image, accountnr) VALUES(13, FALSE, 'Vrijwillig', 'base64String', 'NLCHASE023432432423');





INSERT INTO `driverCar` (driverId, utility, numberPlate, numberOfPassengers, brand, segment) VALUES
  (1, 'rollator', 'fg-56-rj', 4, 'Toyota', 'A');

  INSERT INTO `driverCar` (driverId, utility, numberPlate, numberOfPassengers, brand, segment) VALUES(4, 'scootmobiel', 'gh-81-ac', 2, 'Ford', 'A');

 INSERT INTO `driverCar` (driverId, utility, numberPlate, numberOfPassengers, brand, segment) VALUES (9, 'rolstoel', 'af-83-dc', 1, 'Chervolet', 'B');

 INSERT INTO `driverCar` (driverId, utility, numberPlate, numberOfPassengers, brand, segment) VALUES (8, 'scootmobiel', 'nf-26-fe', 3, 'Ford', 'C');

 INSERT INTO `driverCar` (driverId, utility, numberPlate, numberOfPassengers, brand, segment) VALUES (10, 'scootmobiel', 'nf-24-fe', 3, 'Nissan', 'D');

 INSERT INTO `driverCar` (driverId, utility, numberPlate, numberOfPassengers, brand, segment) VALUES (11, 'scootmobiel', 'nf-26-fd', 3, 'Audi', 'E');


INSERT INTO `clientLimitation` (clientId, limitation) VALUES (2, 'zware/Fysieke handicap');

INSERT INTO `clientLimitation` (clientId, limitation) VALUES  (3, 'ouderen');

 INSERT INTO `clientLimitation` (clientId, limitation) VALUES (6, 'ouderen');




INSERT INTO `driverAvailability` (driverId, startDateTime, endDateTime) VALUES  (1, '2018-01-03 12:00:00', '2019-01-03 13:00:00');

 INSERT INTO `driverAvailability` (driverId, startDateTime, endDateTime) VALUES (4, '2018-02-03 12:00:00', '2019-01-03 13:00:00');

 INSERT INTO `driverAvailability` (driverId, startDateTime, endDateTime) VALUES (8, '2018-01-03 12:00:00', '2019-01-03 13:00:00');

 INSERT INTO `driverAvailability` (driverId, startDateTime, endDateTime) VALUES (9, '2018-01-03 12:00:00', '2019-01-03 13:00:00');

  INSERT INTO `driverAvailability` (driverId, startDateTime, endDateTime) VALUES(10, '2018-01-03 12:00:00', '2018-05-03 13:00:00');

 INSERT INTO `driverAvailability` (driverId, startDateTime, endDateTime) VALUES (11, '2018-01-03 12:00:00', '2018-07-03 14:00:00');

 INSERT INTO `driverAvailability` (driverId, startDateTime, endDateTime) VALUES (12, '2018-01-03 12:00:00', '2019-01-03 17:00:00');

INSERT INTO `driverAvailability` (driverId, startDateTime, endDateTime) VALUES  (13, '2018-01-03 14:00:00', '2018-02-03 15:00:00');


INSERT INTO `driverLimitationManageable` (driverId, limitation) VALUES (1, 'geestelijk gehandicapten');

INSERT INTO `driverLimitationManageable` (driverId, limitation) VALUES(4, 'ouderen');





INSERT INTO `clientDriverPreference` (clientId, driverId) VALUES  (2, 4);

 INSERT INTO `clientDriverPreference` (clientId, driverId) VALUES (3, 8);

INSERT INTO `clientDriverPreference` (clientId, driverId) VALUES  (5, 4);

 INSERT INTO `clientDriverPreference` (clientId, driverId) VALUES (6, 12);

 INSERT INTO `clientDriverPreference` (clientId, driverId) VALUES (7, 10);






 INSERT INTO `driverClientPreference` (driverId, clientId) VALUES (1, 3);

 INSERT INTO `driverClientPreference` (driverId, clientId) VALUES (4, 2);

 INSERT INTO `driverClientPreference` (driverId, clientId) VALUES (8, 5);

 INSERT INTO `driverClientPreference` (driverId, clientId) VALUES (9, 6);

 INSERT INTO `driverClientPreference` (driverId, clientId) VALUES (11, 2);

INSERT INTO `driverClientPreference` (driverId, clientId) VALUES  (12, 2);

INSERT INTO `driverClientPreference` (driverId, clientId) VALUES  (13, 3);





 INSERT INTO `careInstitution` (name, street, houseNumber, residence, zipCode) VALUES ('Reinearde', 'Energieweg', '25', 'Nijmegen', '6432AB');

INSERT INTO `careInstitution` (name, street, houseNumber, residence, zipCode) VALUES  ('Cordaan', 'Poffertjesweg', '21', 'Zwolle', '5422XY');

INSERT INTO `careInstitution` (name, street, houseNumber, residence, zipCode) VALUES  ('IrisZorg', 'Pannekoekendijk', '123', 'Groningen', 'HUYJ89');

INSERT INTO `careInstitution` (name, street, houseNumber, residence, zipCode) VALUES  ('IZZ', 'Wentelteefjeslaan', '234', 'Amsterdam', 'XOPS86');

INSERT INTO `careInstitution` (name, street, houseNumber, residence, zipCode) VALUES ('NedRAI', 'Dorpstraat', '42', 'Arnhem', 'SDOS82');







 INSERT INTO `clientCareInstitution` (clientId, careInstitutionId, active) VALUES (2, 1, TRUE);

 INSERT INTO `clientCareInstitution` (clientId, careInstitutionId, active) VALUES (3, 2, TRUE);

INSERT INTO `clientCareInstitution` (clientId, careInstitutionId, active) VALUES  (5, 3, TRUE);

 INSERT INTO `clientCareInstitution` (clientId, careInstitutionId, active) VALUES (6, 5, TRUE);

INSERT INTO `clientCareInstitution` (clientId, careInstitutionId, active) VALUES  (7, 4, TRUE);







 INSERT INTO `driverCareInstitution` (driverId, careInstitutionId, active) VALUES (1, 2, TRUE );

INSERT INTO `driverCareInstitution` (driverId, careInstitutionId, active) VALUES  (4, 1, TRUE);

 INSERT INTO `driverCareInstitution` (driverId, careInstitutionId, active) VALUES (8, 5, TRUE);

 INSERT INTO `driverCareInstitution` (driverId, careInstitutionId, active) VALUES (9, 3, TRUE);

INSERT INTO `driverCareInstitution` (driverId, careInstitutionId, active) VALUES  (10, 1, TRUE);

 INSERT INTO `driverCareInstitution` (driverId, careInstitutionId, active) VALUES (11, 1, TRUE);

 INSERT INTO `driverCareInstitution` (driverId, careInstitutionId, active) VALUES (12, 4, TRUE);

 INSERT INTO `driverCareInstitution` (driverId, careInstitutionId, active) VALUES (13, 3, TRUE);




INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(2, 1, '2018-01-03 12:00:00', 'Steenstraat 2, Arnhem', 'Kalverstraat 2, Amsterdam', 1, 0, TRUE, FALSE, 'rollator', 2, FALSE, TRUE, 30, 1500, 25.4, FALSE, TRUE,FALSE, 'Uitbetaling September', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(2, 1, '2018-06-28 12:00:00', 'Ketelstraat 3, Arnhem', 'Coolsingen 3, Rotterdam', 0, 3, TRUE, FALSE, 'rollator', 2, FALSE, FALSE, 30, 6500, 25.4, FALSE, TRUE, FALSE, 'Restant September', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(2, 1, '2018-03-03 12:00:00', 'Velperplein 4, Arnhem', 'Blaak 4, Rotterdam', 1, 0, TRUE, FALSE, 'rollator', 2, TRUE, FALSE, 30, 8500, 25.4, FALSE, TRUE, FALSE, 'Boete flitspaal', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(2, 4, '2018-03-03 12:00:00', 'Barteljorisstraat 5, Haarlem', 'Vreeburg 5, Utrecht', 1, 2, TRUE, FALSE, 'rollator', 2, FALSE, FALSE, 30, 4000, 25.4, FALSE, TRUE, FALSE, 'Voorschot Oktober', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(3, 4, '2018-04-12 12:56:23', 'Steenstraat 6, Arnhem', 'Kalverstraat 6, Amsterdam', 1, 0, TRUE, FALSE, 'rollator', NULL, FALSE, FALSE, 30, 1568, 25.4, FALSE, TRUE, FALSE, 'Uitbetaling Augustus', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(6, NULL, '2018-06-03 16:00:00', 'Willemsplein 13, Arnhem', 'Dorpstraat 3, Kesteren', 0, 0, TRUE, FALSE, 'rollator', NULL, FALSE, FALSE, 30, 3000, 25.4, FALSE, FALSE, FALSE, 'Uitbetaling Augustus', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(7, NULL, '2018-02-03 16:00:00', 'Willemsplein 25, Arnhem', 'Nedereindsestraat 12, Kesteren', 0, 0, TRUE, FALSE, 'scootmobiel', NULL, FALSE, FALSE, 30, 5690, 25.4, FALSE, FALSE, FALSE, 'Reparatiekosten auto', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(5, NULL, '2018-12-10 14:22:53', 'Willemsplein 5, Arnhem', 'Konings-plein 11, Amsterdam', 1, 4, TRUE, FALSE, 'scootmobiel', NULL, FALSE, FALSE, 30, 9850, 25.4, FALSE, FALSE, FALSE, 'Reparatiekosten bus', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(5, NULL, '2018-12-10 14:22:53', 'Velperplein 5, Arnhem', 'Konings-plein 11, Amsterdam', 0, 0, TRUE, FALSE, 'scootmobiel', NULL, FALSE, FALSE, 30, 5670, 25.4, FALSE, FALSE,FALSE, 'Declaratie kouwgom', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(3, NULL, '2018-11-06 14:22:53', 'Velperplein 5, Arnhem', 'Konings-plein 25, Amsterdam', 1, 0, TRUE, FALSE, 'scootmobiel', NULL, FALSE, FALSE, 30, 3200, 25.4, FALSE, FALSE,FALSE, 'Pensioen betaling', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(6, NULL, '2018-12-08 09:16:00', 'Velperplein 5, Arnhem', 'Raamsteeg 46, Amsterdam', 1, 0, TRUE, FALSE, 'scootmobiel', NULL, FALSE, FALSE, 30, 3450, 25.4, FALSE, FALSE,FALSE, 'Uitbetaling zorginstelling', 'Onbetaald', '2018-07-23');

INSERT INTO `ride` (clientId, driverId, pickUpDateTime, pickUpLocation, dropOffLocation, numberOfcompanions, numberOfLuggage, returnRide, callService, utility, repeatingRideId, cancelledByClient, executed, duration, distance, priceOfRide, warning, assignedDriver, fixedRide, paymentDescription, paymentStatus, paymentDueBefore)

VALUES(7, NULL, '2018-01-06 11:00:00', 'Steenstraat 8, Arnhem', 'Kalverstraat 8, Amsterdam', 0, 0, TRUE, FALSE, 'rollator', NULL, FALSE, FALSE, 30, 8650, 25.4, FALSE, FALSE,FALSE, 'Overschot Maart', 'Onbetaald', '2018-07-23');



INSERT INTO `rideCanceledByDriver` (rideId, driverId, cancelledDate) VALUES  (3, 1, '2018-01-01 12:00:00');



INSERT INTO `rideProposedForDriver` (rideId, driverId) VALUES  (6, 4);

 INSERT INTO `rideProposedForDriver` (rideId, driverId) VALUES (7, 4);

INSERT INTO `rideProposedForDriver` (rideId, driverId) VALUES  (6, 1);

INSERT INTO `rideProposedForDriver` (rideId, driverId) VALUES  (7, 1);

INSERT INTO `rideProposedForDriver` (rideId, driverId) VALUES  (8, 1);

 INSERT INTO `rideProposedForDriver` (rideId, driverId) VALUES (9, 8);

 INSERT INTO `rideProposedForDriver` (rideId, driverId) VALUES (10, 9);

INSERT INTO `rideProposedForDriver` (rideId, driverId) VALUES  (11, 10);




INSERT INTO `rideMatchesState` (rideId, status, matched) VALUES  (6, 'CARE_INSTITUTION', FALSE);

 INSERT INTO `rideMatchesState` (rideId, status, matched) VALUES (5, 'CARE_INSTITUTION', TRUE);




INSERT INTO `rideMatchesRejected` (rideId, driverId) VALUES (5, 1);





 INSERT INTO `rideMatchesCache` (rideId, driverId) VALUES (2, 4);

 INSERT INTO `rideMatchesCache` (rideId, driverId) VALUES (2, 1);

 INSERT INTO `rideMatchesCache` (rideId, driverId) VALUES (5, 4);




 INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES (1, 2, 'Goede driver', 5);

INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES  (4, 2, 'Op tijd', 4);

INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES  (8, 2, 'Ging te snel', 2);

INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES  (9, 3, 'Praatejesmaker', 3);

INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES  (10, 5, 'Galant', 4);

INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES  (11, 2, 'Een echte heer', 5);

 INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES (1, 7, 'Hier ga ik niet mee mee rijden, gewoon slecht!', 1);

 INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES (1, 6, 'Prima', 2);

 INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES (4, 6, 'Echt een schat van een kerel!', 4);

 INSERT INTO `ratings` (driverId, clientId, beoordeling, sterren) VALUES (10, 7, 'Een aanrader', 4);


INSERT INTO `authUsers` (userName, password, role, careInstitutionId, latestToken, email) VALUES('Alex', '$2a$10$pPz1NB6EM2Nh.olZeNgKyuuQBCBtH9tNVGKfoU64AUhDi/0BBNWWC', 'ROLE_ADMIN', 1, NULL, 'alex@example.com');
INSERT INTO `authUsers` (userName, password, role, careInstitutionId, latestToken, email) VALUES('Mitch', '$2a$10$t9oda9Urp..59PfZ5xnOR.mCGWpnxBMiEHZPvDuv6qxXnx3WHdele', 'ROLE_ZORGINSTELLING', 1, NULL, 'oose.boterbloem@gmail.com');
