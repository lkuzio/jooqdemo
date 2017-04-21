DROP VIEW public.v_person;

CREATE OR REPLACE VIEW public.v_person AS
 SELECT person.id,
    person.firstname,
    person.lastname,
    person.dateofbirth,
    person.enabled
   FROM person;

ALTER TABLE public.v_person
  OWNER TO postgres;
