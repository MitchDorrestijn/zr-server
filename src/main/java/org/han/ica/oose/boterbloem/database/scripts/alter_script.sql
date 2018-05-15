-- Add warningColumn to the client table and ads a PKB (persoonlijk kilometer budget)
ALTER TABLE client
ADD warningPKB boolean
ADD PKB int

--Update clients--
UPDATE client SET PKB = 500
UPDATE client set warningPKB = true