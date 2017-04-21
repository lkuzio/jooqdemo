CREATE TABLE person (
  id bigint NOT NULL,
  firstName character varying(255),
  lastName character varying(255),
  dateOfBirth DATE,
  enabled boolean DEFAULT FALSE,
  CONSTRAINT person_pkey PRIMARY KEY (id)
);