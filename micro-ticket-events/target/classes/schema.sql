CREATE TABLE IF NOT EXISTS EVENTS (
    id UUID PRIMARY KEY,
    description VARCHAR(255),
    location VARCHAR(255),
    eventDate timestamp,
    production VARCHAR(255)
);
