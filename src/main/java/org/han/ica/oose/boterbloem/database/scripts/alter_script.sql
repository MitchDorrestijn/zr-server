-- Add warningColumn to the client table and ads a PKB (persoonlijk kilometer budget)
ALTER TABLE client
ADD warningPKB boolean,
ADD PKB int

-- Update clients--
UPDATE client SET PKB = 500;
UPDATE client set warningPKB = true;


ALTER TABLE client
  ADD companionRequired boolean;

UPDATE client set companionRequired = true where clientId = 2;