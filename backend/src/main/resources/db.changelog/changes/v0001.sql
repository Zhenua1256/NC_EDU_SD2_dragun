DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS logins CASCADE;
DROP TABLE IF EXISTS subscriptions CASCADE;
DROP TABLE IF EXISTS subscriptionTypes CASCADE;
DROP TABLE IF EXISTS billingAccounts CASCADE;
DROP TABLE IF EXISTS subscriptionsList CASCADE;

DROP SEQUENCE IF EXISTS users_id_seq CASCADE;
DROP SEQUENCE IF EXISTS logins_id_seq CASCADE;
DROP SEQUENCE IF EXISTS subscriptions_id_seq CASCADE;
DROP SEQUENCE IF EXISTS billingAccounts_id_seq CASCADE;
DROP SEQUENCE IF EXISTS subscriptionTypes_id_seq CASCADE;

CREATE SEQUENCE users_id_seq;

ALTER SEQUENCE users_id_seq
    OWNER TO spring;

CREATE SEQUENCE logins_id_seq;

ALTER SEQUENCE logins_id_seq
    OWNER TO spring;

CREATE SEQUENCE subscriptions_id_seq;

ALTER SEQUENCE subscriptions_id_seq
    OWNER TO spring;

CREATE SEQUENCE billingAccounts_id_seq;

ALTER SEQUENCE billingAccounts_id_seq
    OWNER TO spring;

CREATE SEQUENCE subscriptionTypes_id_seq;

ALTER SEQUENCE subscriptionTypes_id_seq
    OWNER TO spring;

CREATE TABLE users
(
    id       bigint DEFAULT nextval('users_id_seq'::regclass),
    email    character varying(255),
    role     character varying(255),
    login bigint,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;


CREATE TABLE logins
(
    id       bigint DEFAULT nextval('logins_id_seq'::regclass),
    login    character varying(255),
    password     character varying(255),
    CONSTRAINT logins_pkey PRIMARY KEY (id)
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

CREATE TABLE subscriptionTypes
(
    id          bigint DEFAULT nextval('subscriptionTypes_id_seq'::regclass),
    subscription_type character varying(255),
    CONSTRAINT subscriptionTypes_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE users
    ADD CONSTRAINT fk_login FOREIGN KEY (login)
        REFERENCES logins (id) MATCH SIMPLE
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

ALTER TABLE subscriptions
    ADD CONSTRAINT fk_type FOREIGN KEY (type)
        REFERENCES subscriptionTypes (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE;