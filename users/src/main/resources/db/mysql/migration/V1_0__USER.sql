CREATE TABLE IF NOT EXISTS java_users.USER (
  ID INT NOT NULL AUTO_INCREMENT,
  FIRST_NAME VARCHAR(50) NOT NULL,
  LAST_NAME VARCHAR(50) NOT NULL,
  EMAIL VARCHAR(60) NOT NULL,
  USERNAME VARCHAR(50) NOT NULL,
  PASSWORD VARCHAR(60) NOT NULL,
  ADD_TS DATETIME(6) NOT NULL,
  PRIMARY KEY (ID))
ENGINE = InnoDB;