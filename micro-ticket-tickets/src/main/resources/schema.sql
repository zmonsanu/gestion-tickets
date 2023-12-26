CREATE TABLE IF NOT EXISTS TICKETS (
    id UUID PRIMARY KEY,
    eventId UUID,
    clientId UUID,
    description VARCHAR(500),
    dateOfPurchase timestamp,
    price decimal(5,2),
    validated boolean
);
