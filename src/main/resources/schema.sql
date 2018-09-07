CREATE TABLE IF NOT EXISTS USER_TBL
(
  ID INTEGER NOT NULL,
  NAME VARCHAR(255) NOT NULL,
  PASSWORD VARCHAR(255) NOT NULL,
  ADDRESS VARCHAR(255) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS LOGIN_TBL
(
  ID INTEGER NOT NULL,
  USER_ID INTEGER NOT NULL,
  TIMESTAMP DATE NOT NULL,
  LOGIN_TYPE VARCHAR(255) NOT NULL,
  PRIMARY KEY(ID),
  FOREIGN KEY (USER_ID) REFERENCES USER_TBL(ID)
);

CREATE TABLE IF NOT EXISTS EVENT_TBL
(
  ID INTEGER NOT NULL,
  USER_ID INTEGER NOT NULL,
  TIMESTAMP DATE NOT NULL,
  EVENT_TYPE VARCHAR(255) NOT NULL,
  FOREIGN KEY (USER_ID) REFERENCES USER_TBL(ID)
);