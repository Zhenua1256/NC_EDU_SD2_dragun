DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS datausers CASCADE;
DROP TABLE IF EXISTS subscriptions CASCADE;
DROP TABLE IF EXISTS company CASCADE;
DROP TABLE IF EXISTS billingAccounts CASCADE;
DROP TABLE IF EXISTS subscriptionsList CASCADE;

DROP SEQUENCE IF EXISTS users_id_seq CASCADE;
DROP SEQUENCE IF EXISTS datausers_id_seq CASCADE;
DROP SEQUENCE IF EXISTS subscriptions_id_seq CASCADE;
DROP SEQUENCE IF EXISTS billingAccounts_id_seq CASCADE;
DROP SEQUENCE IF EXISTS company_id_seq CASCADE;

CREATE SEQUENCE users_id_seq;

ALTER SEQUENCE users_id_seq
    OWNER TO spring;

CREATE SEQUENCE datausers_id_seq;

ALTER SEQUENCE datausers_id_seq
    OWNER TO spring;

CREATE SEQUENCE subscriptions_id_seq;

ALTER SEQUENCE subscriptions_id_seq
    OWNER TO spring;

CREATE SEQUENCE billingAccounts_id_seq;

ALTER SEQUENCE billingAccounts_id_seq
    OWNER TO spring;

CREATE SEQUENCE company_id_seq;

ALTER SEQUENCE company_id_seq
    OWNER TO spring;

CREATE TABLE users
(
    id       bigint DEFAULT nextval('users_id_seq'::regclass),
    email    character varying(255),
    name     character varying(255),
    last_name character varying(255),
    data_user bigint,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;


CREATE TABLE datausers
(
    id       bigint DEFAULT nextval('datausers_id_seq'::regclass),
    login    character varying(255),
    password     character varying(255),
    role     character varying(255),
    CONSTRAINT datausers_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

CREATE TABLE subscriptions
(
    id                 bigint DEFAULT nextval('subscriptions_id_seq'::regclass),
    name       character varying(255),
    price            bigint,
    type bigint,
    period bigint,
    CONSTRAINT subscriptions_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

CREATE TABLE subscriptionsList
(
    subscription_id bigint,
    user_id bigint
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

CREATE TABLE billingAccounts
(
    id          bigint DEFAULT nextval('billingAccounts_id_seq'::regclass),
    user_id bigint,
    balance bigint,
    CONSTRAINT billingAccounts_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

CREATE TABLE company
(
    id          bigint DEFAULT nextval('company_id_seq'::regclass),
    name character varying(255),
    director character varying(255),
    contact_number character varying(255),
    legal_addres character varying(255),
    data_user bigint,
    CONSTRAINT company_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE users
    ADD CONSTRAINT fk_datausers FOREIGN KEY (data_user)
        REFERENCES datausers (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE billingAccounts
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE subscriptionsList
    ADD CONSTRAINT fk_subscription_id FOREIGN KEY (subscription_id)
        REFERENCES subscriptions (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE CASCADE
           ON DELETE CASCADE;

ALTER TABLE company
    ADD CONSTRAINT fk_datausers FOREIGN KEY (data_user)
        REFERENCES company (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE;