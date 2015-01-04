BEGIN;

CREATE TABLE user (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(35) NOT NULL,
	login VARCHAR(15) NOT NULL,
	password VARCHAR(65) NOT NULL,
	email VARCHAR(30) NOT NULL,
	type INT(4) NOT NULL,
	UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE category (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	name VARCHAR(128) NOT NULL,
	code VARCHAR(32) NOT NULL,
	UNIQUE (sid),
	UNIQUE (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE category ADD INDEX category_sid_idx (sid);

CREATE TABLE style (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	name VARCHAR(128) NOT NULL,
	category_id INT(11) NOT NULL,
	UNIQUE (sid),
	FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE style ADD INDEX style_sid_idx (sid);
ALTER TABLE style ADD INDEX style_category_idx (category_id);

CREATE TABLE instructor (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	first_name VARCHAR(64) NOT NULL,
	last_name VARCHAR(64),
	nick VARCHAR(64),
	UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE instructor ADD INDEX instructor_sid_idx (sid);

CREATE TABLE instructor_description (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	instructor_id INT(11) NOT NULL,
	description TEXT NOT NULL,
	UNIQUE (sid),
	FOREIGN KEY (instructor_id) REFERENCES instructor(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE instructor_description ADD INDEX instructor_description_sid_idx (sid);
ALTER TABLE instructor_description ADD INDEX instructor_description_instructor_idx (instructor_id);

CREATE TABLE room (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	name VARCHAR(128) NOT NULL,
	UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE room ADD INDEX room_sid_idx (sid);

CREATE TABLE dance_class (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	style_id INT(11) NOT NULL,
	instructor_id INT(11) NOT NULL,
	day INT(4) NOT NULL,
	start_time VARCHAR(5) NOT NULL,
	end_time VARCHAR(5) NOT NULL,
	can_join BOOLEAN NOT NULL DEFAULT false,
	can_register BOOLEAN NOT NULL DEFAULT true,
	in_progress BOOLEAN NOT NULL DEFAULT false,
	level VARCHAR(16) NOT NULL DEFAULT 'BEGINNER',
	room_id INT(11),
	UNIQUE (sid),
	FOREIGN KEY (style_id) REFERENCES style(id) ON DELETE CASCADE,
	FOREIGN KEY (instructor_id) REFERENCES instructor(id) ON DELETE CASCADE,
	FOREIGN KEY (room_id) REFERENCES room(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE dance_class ADD INDEX dance_class_sid_idx (sid);
ALTER TABLE dance_class ADD INDEX dance_class_day_idx (day);

CREATE TABLE email (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	sender VARCHAR(64) NOT NULL,
	subject VARCHAR(256) NOT NULL,
	content TEXT NOT NULL,
	UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE email ADD INDEX email_sid_idx (sid);

CREATE TABLE news (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	sid VARCHAR(32) NOT NULL,
	title VARCHAR(128) NOT NULL,
	created_at VARCHAR(16) NOT NULL,
	content TEXT NOT NULL,
	image_src VARCHAR(1024),
	image_alt VARCHAR(256),
	UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE news ADD INDEX news_sid_idx (sid);

COMMIT;