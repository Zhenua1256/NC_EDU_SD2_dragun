DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS datausers CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS company CASCADE;
DROP TABLE IF EXISTS billingAccounts CASCADE;
DROP TABLE IF EXISTS subscription CASCADE;

DROP SEQUENCE IF EXISTS users_id_seq CASCADE;
DROP SEQUENCE IF EXISTS datausers_id_seq CASCADE;
DROP SEQUENCE IF EXISTS product_id_seq CASCADE;
DROP SEQUENCE IF EXISTS billingAccounts_id_seq CASCADE;
DROP SEQUENCE IF EXISTS company_id_seq CASCADE;

CREATE SEQUENCE users_id_seq;

ALTER SEQUENCE users_id_seq
    OWNER TO spring;

CREATE SEQUENCE datausers_id_seq;

ALTER SEQUENCE datausers_id_seq
    OWNER TO spring;

CREATE SEQUENCE product_id_seq;

ALTER SEQUENCE product_id_seq
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

CREATE TABLE product
(
    id                 bigint DEFAULT nextval('product_id_seq'::regclass),
    name       character varying(255),
    price            bigint,
    section bigint,

    CONSTRAINT product_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

CREATE TABLE subscription
(
    product_id bigint,
    period bigint,
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
    card_number bigint,
    balance bigint,
    cvv bigint,
    owner character varying(255),
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

ALTER TABLE subscription
    ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id)
        REFERENCES product (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE CASCADE
           ON DELETE CASCADE;

ALTER TABLE company
    ADD CONSTRAINT fk_datausers FOREIGN KEY (data_user)
        REFERENCES datausers (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE;