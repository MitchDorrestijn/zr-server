-- Add type of payment column to driver table and set the values to "Vrijwillig"
ALTER TABLE driver
ADD type_of_payment VARCHAR(255)
UPDATE driver SET type_of_payment = "Vrijwillig"

-- Add price_of_ride column to the ride table and set the values to 25.4
ALTER TABLE ride
ADD price_of_ride FLOAT
UPDATE ride SET price_of_ride = 25.4

-- Create a new table for the ratings
CREATE TABLE ratings (
	driverId	INT				NOT NULL,
    clientId	INT				NOT NULL,
    beoordeling	VARCHAR(1000)	NOT NULL,
    sterren		INT				NOT NULL
)

-- Fill the table ratings with dummy data
INSERT INTO ratings (driverId, clientId, beoordeling, sterren) VALUES
(1, 2, "Goede driver", 5),
(4, 2, "Op tijd", 4),
(8, 2, "Ging te snel", 2),
(9, 3, "Praatejesmaker", 3),
(10, 5, "Galant", 4),
(11, 2, "Een echte heer", 5),
(1, 7, "Hier ga ik niet mee mee rijden, gewoon slecht!", 1),
(1, 6, "Prima", 2),
(4, 6, "Echt een schat van een kerel!", 4),
(10, 7, "Een aanrader", 4)