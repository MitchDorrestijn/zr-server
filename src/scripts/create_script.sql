-- -----------------------------------------------------

-- Schema zorgrit

-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `zorgrit`;

-- -----------------------------------------------------

-- Schema zorgrit

-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `zorgrit`;

USE zorgrit;

-- -----------------------------------------------------

-- Table utility

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `utility` (

  name     VARCHAR(255) NOT NULL,
  priority INT(11)      NOT NULL,
  PRIMARY KEY (name)
);

-- -----------------------------------------------------

-- Table limitation

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `limitation` (

  name VARCHAR(255) NOT NULL,

  PRIMARY KEY (name)

);

-- -----------------------------------------------------

-- Table user

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `user` (

  id                    INT(11)      NOT NULL AUTO_INCREMENT,

  firstName             VARCHAR(255) NOT NULL,

  lastName              VARCHAR(255) NOT NULL,

  email                 VARCHAR(255) NOT NULL,

  phoneNumber           VARCHAR(10)  NULL     DEFAULT NULL,

  street                VARCHAR(255) NULL,

  houseNumber           VARCHAR(6)   NULL,

  zipCode               VARCHAR(6)   NULL,

  residence             VARCHAR(255) NULL,

  password              VARCHAR(255) NULL     DEFAULT NULL,

  PasswordSalt          VARCHAR(255) NULL     DEFAULT NULL,

  dateOfBirth           DATE         NULL     DEFAULT NULL,

  firstTimeProfileCheck BOOLEAN      NULL     DEFAULT FALSE,

  PRIMARY KEY (id)

);

-- -----------------------------------------------------

-- Table Client

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `client` (

  clientId               INT(11)      NOT NULL,

  companion              VARCHAR(255) NULL     DEFAULT NULL,

  driverPreferenceForced BOOLEAN      NOT NULL DEFAULT FALSE,

  warningPKB             BOOLEAN      NOT NULL,

  PKB                    INT(10)      NOT NULL,

  companionRequired      BOOLEAN      NOT NULL,

  image                  LONGTEXT     NULL,

  bankAccount            VARCHAR(255) NOT NULL,
  PRIMARY KEY (clientId),

  CONSTRAINT ClientUser FOREIGN KEY (clientId) REFERENCES user (id)

    ON DELETE CASCADE

    ON UPDATE CASCADE

);

-- -----------------------------------------------------

-- Table driver

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `driver` (

  driverId        INT(11)      NOT NULL,

  verification    BOOLEAN      NOT NULL,

  typeOfPayment VARCHAR(255) NULL,

  image           LONGTEXT     NULL,

  accountnr       VARCHAR(255) NULL,
  PRIMARY KEY (driverId),

  CONSTRAINT DriverUser FOREIGN KEY (driverId) REFERENCES user (id)

    ON DELETE CASCADE

    ON UPDATE CASCADE

  -- -----------------------------------------------------

);

-- -----------------------------------------------------

-- Table driverCar

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `driverCar` (

  driverId           INT(11)      NOT NULL,

  utility            VARCHAR(255) NOT NULL,

  numberPlate        VARCHAR(255) NOT NULL,

  numberOfPassengers INT(11)      NOT NULL,

  brand              VARCHAR(255) NULL,

  segment            VARCHAR(255) NULL,

  PRIMARY KEY (driverId, utility),

  CONSTRAINT driverCarUtilityDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT driverCarUtility FOREIGN KEY (utility) REFERENCES utility (name)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table clientLimitation

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `clientLimitation` (

  clientId   INT(11)      NOT NULL,
  limitation    VARCHAR(255) NOT NULL,
  PRIMARY KEY (clientId, limitation),


  CONSTRAINT clientLimitationClient FOREIGN KEY (clientId) REFERENCES client (clientId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,
  CONSTRAINT clientLimitationLimitation FOREIGN KEY (limitation) REFERENCES limitation (name)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table driverAvailability

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `driverAvailability` (

  driverId      INT(11)  NOT NULL,

  startDateTime DATETIME NOT NULL,

  endDateTime   DATETIME NOT NULL,

  PRIMARY KEY (driverId, startDateTime, endDateTime),

  CONSTRAINT driverAvailabilityDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table driverLimitationManageable

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `driverLimitationManageable` (

  driverId   INT(11)      NOT NULL,
  limitation VARCHAR(255) NOT NULL,
  PRIMARY KEY (driverId, limitation),


  CONSTRAINT driverLimitationManageableDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,
  CONSTRAINT driverLimitationManageableLimitation FOREIGN KEY (limitation) REFERENCES limitation (name)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table ClientDriverPreference

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `clientDriverPreference` (

  clientId INT(11) NOT NULL,

  driverId INT(11) NOT NULL,

  PRIMARY KEY (clientId, driverId),

  CONSTRAINT clientDriverPreferenceClient FOREIGN KEY (clientId) REFERENCES client (clientId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT clientDriverPreferenceDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table driverClientPreference

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `driverClientPreference` (

  driverId INT(11) NOT NULL,

  clientId INT(11) NOT NULL,

  PRIMARY KEY (driverId, clientId),

  CONSTRAINT driverClientPreferenceDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT driverClientPreferenceClient FOREIGN KEY (clientId) REFERENCES client (clientId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table careInstitution

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `careInstitution` (

  id   INT(11)      NOT NULL AUTO_INCREMENT,

  name VARCHAR(255) NOT NULL,

  street VARCHAR(255) NULL,

  houseNumber VARCHAR (255) NULL,

  residence VARCHAR(255) NULL,

  zipCode VARCHAR(255) NULL,

  PRIMARY KEY (id)

);

-- -----------------------------------------------------

-- Table clientCareInstitution

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `clientCareInstitution` (

  clientId          INT(11) NOT NULL,

  careInstitutionId INT(11) NOT NULL,

  active            boolean NOT NULL,

  PRIMARY KEY (clientId, careInstitutionId),

  CONSTRAINT careInstitutionClient FOREIGN KEY (clientId) REFERENCES client (clientId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT clientCareInstitution FOREIGN KEY (careInstitutionId) REFERENCES careInstitution (id)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table driverCareInstitution

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `driverCareInstitution` (

  driverId          INT(11) NOT NULL,

  careInstitutionId INT(11) NOT NULL,

  active            BOOLEAN NOT NULL,

  PRIMARY KEY (driverId, careInstitutionId),

  CONSTRAINT careInstitutionDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT driverCareInstitution FOREIGN KEY (careInstitutionId) REFERENCES careInstitution (id)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table ride

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `ride` (

  id                      INT(11)      NOT NULL AUTO_INCREMENT,

  clientId                INT(11)      NOT NULL,

  driverId                INT(11)      NULL,

  preferedCareInstitution INT(11)      NULL,

  preferedDriver          INT(11)      NULL,

  pickUpDateTime          DATETIME     NOT NULL,

  pickUpLocation          VARCHAR(255) NOT NULL,

  dropOffLocation         VARCHAR(255) NOT NULL,

  duration                INT(11)      NOT NULL,

  distance                INT(11)      NOT NULL,

  numberOfcompanions      INT(11)      NOT NULL,

  numberOfLuggage         INT(11)      NOT NULL,

  returnRide              BOOLEAN      NOT NULL,

  callService             BOOLEAN      NOT NULL,

  utility                 VARCHAR(255) NULL,

  repeatingRideId         INT(11)      NULL,

  cancelledByClient       BOOLEAN      NULL,

  executed                BOOLEAN      NOT NULL DEFAULT FALSE,

  priceOfRide           FLOAT        NOT NULL,

  warning                 BOOLEAN      NULL,

  assignedDriver          BOOLEAN      NOT NUlL,

  fixedRide               BOOLEAN      NOT NULL ,

  paymentDescription      VARCHAR(255) NULL,

  paymentStatus           VARCHAR(255) NULL,

  paymentDueBefore        DATE         NULL,


  PRIMARY KEY (id),

  CONSTRAINT RideClient FOREIGN KEY (clientId) REFERENCES client (clientId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT RidePreferdDriver FOREIGN KEY (preferedDriver) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT preferedCareInstitution FOREIGN KEY (preferedCareInstitution) REFERENCES careInstitution (id)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT RideDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT RideUtility FOREIGN KEY (utility) REFERENCES utility (name)

    ON DELETE NO ACTION

    ON UPDATE CASCADE

);

-- -----------------------------------------------------

-- Table rideCanceledByDriver

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `rideCanceledByDriver` (

  rideId        INT      NOT NULL,

  driverId      INT      NOT NULL,

  cancelledDate DATETIME NOT NULL,

  PRIMARY KEY (rideId, driverId, cancelledDate),

  CONSTRAINT CancelledRide FOREIGN KEY (rideId) REFERENCES ride (id)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT CancelledDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table rideProposedForDriver

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `rideProposedForDriver` (

  rideId   INT NOT NULL,

  driverId INT NOT NULL,

  PRIMARY KEY (rideId, driverId),

  CONSTRAINT ProposedRide FOREIGN KEY (rideId) REFERENCES ride (id)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT ProposedDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table rideMatchesState

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `rideMatchesState` (

  rideId  INT          NOT NULL,

  status  VARCHAR(255) NOT NULL,

  matched BOOLEAN      NOT NULL DEFAULT FALSE,

  PRIMARY KEY (rideId),

  CONSTRAINT rideMatchesStateRide FOREIGN KEY (rideId) REFERENCES ride (id)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table rideMatchesCache

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `rideMatchesCache` (

  rideId   INT NOT NULL,

  driverId INT NOT NULL,

  PRIMARY KEY (rideId, driverId),

  CONSTRAINT rideMatchesCacheDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table rideMatchesRejected

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `rideMatchesRejected` (

  rideId   INT NOT NULL,

  driverId INT NOT NULL,

  PRIMARY KEY (rideId, driverId),

  CONSTRAINT rideMatchesRejectedDriver FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table ratings

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `ratings` (

  driverId    INT           NOT NULL,

  clientId    INT           NOT NULL,

  beoordeling VARCHAR(1000) NOT NULL,

  sterren     INT           NOT NULL,

  PRIMARY KEY (clientId, driverId),

  CONSTRAINT ratings FOREIGN KEY (driverId) REFERENCES driver (driverId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table client utility

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `clientUtility` (

  clientId INT(11)      NOT NULL,

  utility  VARCHAR(255) NOT NULL,

  PRIMARY KEY (clientId, utility),

  CONSTRAINT clientReference FOREIGN KEY (clientId) REFERENCES client (clientId)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT utilityReference FOREIGN KEY (utility) REFERENCES utility (name)

    ON DELETE NO ACTION

    ON UPDATE NO ACTION

);

-- -----------------------------------------------------

-- Table authUsers

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `authUsers` (
    userName			      VARCHAR(255)	NOT NULL,
    password			      VARCHAR(255)	NOT NULL,
    role				        VARCHAR(255)	NOT NULL,
    careInstitutionId	  INT     			NULL,
    latestToken			    VARCHAR(1000)	NULL,
    email               VARCHAR(255)  NOT NULL,
	  PRIMARY KEY (userName)
);