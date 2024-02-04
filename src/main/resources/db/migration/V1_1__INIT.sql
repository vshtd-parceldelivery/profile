CREATE SEQUENCE base_profile_seq;
CREATE TABLE base_profile (
  id                    BIGINT  DEFAULT nextval('base_profile_seq') PRIMARY KEY,
  username              VARCHAR NOT NULL UNIQUE,
  profile_type          VARCHAR NOT NULL,
  registration_date     TIMESTAMP NOT NULL
);

----------------------------------------------------------

CREATE SEQUENCE user_info_seq;
CREATE TABLE user_info (
  id                    BIGINT  NOT NULL UNIQUE,
  status                VARCHAR(50) NOT NULL,
  CONSTRAINT fk_base_profile FOREIGN KEY (id) REFERENCES base_profile (id)
);

----------------------------------------------------------

CREATE SEQUENCE courier_seq;
CREATE TABLE courier (
  id                    BIGINT  NOT NULL UNIQUE,
  status                VARCHAR(50) NOT NULL,
  CONSTRAINT fk_base_profile FOREIGN KEY (id) REFERENCES base_profile (id)
);
----------------------------------------------------------

CREATE SEQUENCE admin_seq;
CREATE TABLE admin (
  id                    BIGINT  NOT NULL UNIQUE,
  status                VARCHAR(50) NOT NULL,
  CONSTRAINT fk_base_profile FOREIGN KEY (id) REFERENCES base_profile (id)
);

---------------------------------------------------------

INSERT INTO base_profile (id, username, profile_type, registration_date)
VALUES (nextval('base_profile_seq'), 'admin', 'ADMIN', '2024-02-02 08:00:00.000000');

INSERT INTO admin (id, status)
VALUES (currval('base_profile_seq'), 'ACTIVE');

---------------------------------------------------------

INSERT INTO base_profile (id, username, profile_type, registration_date)
VALUES (nextval('base_profile_seq'), 'user', 'USER', '2024-02-02 08:00:00.000000');

INSERT INTO user_info (id, status)
VALUES (currval('base_profile_seq'), 'CREATED');

---------------------------------------------------------

INSERT INTO base_profile (id, username, profile_type, registration_date)
VALUES (nextval('base_profile_seq'), 'courier', 'COURIER', '2024-02-02 08:00:00.000000');

INSERT INTO courier (id, status)
VALUES (currval('base_profile_seq'), 'ACTIVE');