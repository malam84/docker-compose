CREATE TABLE users (user_id int(11) NOT NULL AUTO_INCREMENT, user_name varchar(255), email varchar(255) NOT NULL, password varchar(255), PRIMARY KEY (user_id));
CREATE TABLE roles (role_id int(10) NOT NULL AUTO_INCREMENT, role varchar(255) NOT NULL, PRIMARY KEY (role_id));
CREATE TABLE user_role (role_id int(10) NOT NULL, user_id int(11) NOT NULL);
ALTER TABLE user_role ADD CONSTRAINT FKuser_role786476 FOREIGN KEY (user_id) REFERENCES users (user_id);