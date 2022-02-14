drop table if exists text;

CREATE TABLE text
(
text_id bigint NOT NULL PRIMARY KEY,
structure character varying(2000),
text character varying(100000)
);