--liquibase formatted sql

--changeset pawel:1
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
  instructor_id INT(11),
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

--changeset pawel:2
INSERT INTO room (sid, name) VALUES
('zxcvblkjhgzxcvblkjhgzxcvblkjhgdf', 'm'),
('zxcvblkjhgzxcvblkjhgzxcvblkjhglv', 'd');

INSERT INTO category (sid, name, code) VALUES
  ('43632299f3434e0889c96b50c1168103', 'Zajęcia solo', 'solo'),
  ('53632299f3434e0889c96b50c1168103', 'Dzieci', 'dzieci'),
  ('5vm32299f3434e0889c96b50c1168103', 'Seniorzy', 'seniorzy'),
  ('5vm32299f3434e0889c96b50c1168nnn', 'Zajecia w parach', 'pary'),
  ('5vm32299f3434e0889c96b50c1mcnnnn', 'Treningi formacji', 'formacje');

INSERT INTO style (sid, name, category_id) VALUES
  ('43632299f3434e0889vjkb50c1168103', 'Aktywne 50+', (SELECT id FROM category WHERE code = 'seniorzy')),
  ('43632299f343445289vjkb50c1168103', 'Balet z elementami gimnastyki artystycznej', (SELECT id FROM category WHERE code = 'dzieci')),
  ('43223299f343445289vjkb50c1168103', 'Taniec towarzyski', (SELECT id FROM category WHERE code = 'pary')),
  ('43223299f343445289vjkb0011168103', 'Taniec użytkowy', (SELECT id FROM category WHERE code = 'pary')),
  ('43223369f343445289vjkb0011168103', 'Dziecięca formacja taneczna', (SELECT id FROM category WHERE code = 'formacje')),
  ('43223mcnv343445289vjkb0011168103', 'Hip hop', (SELECT id FROM category WHERE code = 'solo')),
  ('43223mcnv343445289vjkb0585168103', 'Reggaeton', (SELECT id FROM category WHERE code = 'solo')),
  ('43223mcnv343445289vjkb05851yyv03', 'Trening El-Fuego', (SELECT id FROM category WHERE code = 'formacje')),
  ('43223mcnv343445289vjkb05vvvcxv03', 'Hip hop dla dzieci 5-7 lat', (SELECT id FROM category WHERE code = 'dzieci')),
  ('43223mcnv343445289vjkb05ggvcxv03', 'Mix dance 4-7 lat', (SELECT id FROM category WHERE code = 'dzieci')),
  ('53223mcnv343445289vjkb05ggvcxv03', 'Ladies latino', (SELECT id FROM category WHERE code = 'solo')),
  ('53223mcnv34344vb89vjkb05ggvcxv03', 'Salsa solo', (SELECT id FROM category WHERE code = 'solo')),
  ('53223mcnv34344vb89vjgh05ggvcxv03', 'Bachata', (SELECT id FROM category WHERE code = 'pary')),
  ('53223mcnv34344vb89vjgh05hjvcxv03', 'Balet 3 latki', (SELECT id FROM category WHERE code = 'dzieci')),
  ('5322tycnv34344vb89vjgh05hjvcxv03', 'Salsa kubańska', (SELECT id FROM category WHERE code = 'pary')),
  ('5322tycnv34344vb89vjgh05hjvc1233', 'Zouk', (SELECT id FROM category WHERE code = 'pary'));

INSERT INTO instructor (sid, first_name, last_name, nick) VALUES
  ('536789cnv34344vb89vjgh05hjvc1233', 'Barbara', 'Karpińska', null),
  ('536789cnv34389vb89vjgh05hjvc1233', 'Paweł', 'Radomski', null),
  ('536789cnv11389vb89vjgh05hjvc1233', 'Marta', 'Mościcka', 'Mostek'),
  ('536789cnv11389vb89vjgh05hjvc8763', 'Magda', 'Mróz', null),
  ('536789cnv11389vb110jgh05hjvc8763', 'Julia', 'Utig', null),
  ('536789cnv65488vb110jgh05hjvc8763', 'Marta', 'Brendel', null),
  ('536789cnv65488vb110jgh05hjvcvv63', 'Anna', 'Faściszewska', null),
  ('116789cnv65488vb110jgh05hjvcvv63', 'Barbara Karpińska', 'Paweł Radomski', null),
  ('536789cn111088vb110jgh05hjvcvv63', 'Joanna', 'Sipowicz', null);

INSERT INTO dance_class (sid, style_id, instructor_id, day, start_time, end_time, can_join, can_register, in_progress, level, room_id) VALUES
  ('536789cnv34344vb89vjgh05hjvclakk', (SELECT id FROM style WHERE sid = '43632299f3434e0889vjkb50c1168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 0, '11:00', '12:00', false, false, true, 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('736dd9cnv34344vb89vjgh05hjvclakk', (SELECT id FROM style WHERE sid = '43632299f3434e0889vjkb50c1168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 0, '12:00', '13:00', false, true, false, 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('936789cnv34344vb89vjgh05hjvclakk', (SELECT id FROM style WHERE sid = '43632299f343445289vjkb50c1168103'), (SELECT id FROM instructor WHERE sid = '536789cnv11389vb89vjgh05hjvc8763'), 0, '17:00', '17:45', false, false, true, 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('5367czcnv34344vb89vjgh05hjvclakk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb50c1168103'), (SELECT id FROM instructor WHERE sid = '536789cnv65488vb110jgh05hjvcvv63'), 0, '18:30', '19:30', true, false, true, 'ADVANCED', (SELECT id FROM room WHERE name = 'd')),
  ('736789hnv34344vb89vjgh05hjvclakk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 0, '19:30', '20:30', true, false, true, 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd')),
  ('336789hnv34344v1166jgh0jkjvclakk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 0, '20:30', '21:30', false, true, false, 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('436789hnv3434jj1166jgh05hjvclakk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 0, '21:30', '22:30', true, false, true, 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),

  ('536789hnv3434jj1214jgh05hjvnbvkk', (SELECT id FROM style WHERE sid = '43223369f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 1, '17:30', '18:30', true, false, true, 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd')),
  ('ghj789hnv3434jj1166jgh043jvnbvkk', (SELECT id FROM style WHERE sid = '43223mcnv343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv11389vb89vjgh05hjvc1233'), 1, '18:30', '19:30', true, false, true, 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('aaj789hnv3434jj1166jt55hjtvnbvkk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 1, '18:45', '19:45', false, false, true, 'ADVANCED', (SELECT id FROM room WHERE name = 'm')),
  ('aaj789hnv3434jj1166jgvbnxzvnbvkk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv11389vb89vjgh05hjvc8763'), 1, '20:00', '21:00', true , false, true, 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd')),
  ('fgtr89hnv3434jj1166jgvbngzvnbvkk', (SELECT id FROM style WHERE sid = '43223mcnv343445289vjkb0585168103'), (SELECT id FROM instructor WHERE sid = '536789cnv11389vb110jgh05hjvc8763'), 1, '21:00', '22:00', false , true , false , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('abcd89hnv3434jj1166jgvbnxzvnbvkk', (SELECT id FROM style WHERE sid = '43223mcnv343445289vjkb05851yyv03'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 1, '21:30', '24:00', false , false , true , 'ADVANCED', (SELECT id FROM room WHERE name = 'd')),

  ('bvgh89hnv3434jj1166jgvbnxzvczvkk', (SELECT id FROM style WHERE sid = '43223mcnv343445289vjkb05vvvcxv03'), null, 2, '17:00', '18:00', false , true , false , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('kvlb89hnv3434jj1166jgvbnxzwqbvkk', (SELECT id FROM style WHERE sid = '43223mcnv343445289vjkb05ggvcxv03'), (SELECT id FROM instructor WHERE sid = '536789cnv11389vb110jgh05hjvc8763'), 2, '17:00', '18:00', false , true , false , 'BEGINNER', (SELECT id FROM room WHERE name = 'm')),
  ('kvlbsdfgv3434jj1166jgvbrezvnbvkk', (SELECT id FROM style WHERE sid = '53223mcnv343445289vjkb05ggvcxv03'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 2, '19:30', '20:30', true , false , true , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('hxlbsdfgv3434jj1166jgvbnxzvnbvkk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv11389vb89vjgh05hjvc8763'), 2, '19:30', '20:30', true , false , true , 'BEGINNER', (SELECT id FROM room WHERE name = 'm')),
  ('qwebsdfgv3434jj1166jgvbnxnnvbvkk', (SELECT id FROM style WHERE sid = '53223mcnv34344vb89vjkb05ggvcxv03'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 2, '19:30', '20:30', true , false , true , 'ADVANCED', (SELECT id FROM room WHERE name = 'd')),
  ('452fsdfgv3434jj1166jgvbnxzdfbvkk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), null, 2, '20:30', '21:30', false , true , false , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),

  ('qwebsdfgv34vbhyt166jgvbnxzvnnkkk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 2, '21:30', '22:30', true , false , true , 'ADVANCED', (SELECT id FROM room WHERE name = 'd')),
  ('qwebsdfgv34vbh64756jgvbnxzvnnkkk', (SELECT id FROM style WHERE sid = '43223mcnv343445289vjkb05ggvcxv03'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 3, '16:30', '17:15', true , false , true , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('qwebsdfgv34vbh64756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '43223369f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 3, '17:30', '18:30', true , false , true , 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd')),
  ('1468sdfgv34vbh64756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '53223mcnv34344vb89vjgh05ggvcxv03'), (SELECT id FROM instructor WHERE sid = '116789cnv65488vb110jgh05hjvcvv63'), 3, '19:30', '20:30', true , false , true , 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd')),
  ('2466sdfgv34vbh64756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '53223mcnv34344vb89vjgh05ggvcxv03'), (SELECT id FROM instructor WHERE sid = '116789cnv65488vb110jgh05hjvcvv63'), 3, '20:30', '21:30', false , true , false , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('3464sdfgv34vbh64756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv11389vb89vjgh05hjvc8763'), 3, '20:30', '21:30', false , true , false , 'BEGINNER', null),
  ('4466sdfgv34vbh64756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb50c1168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 3, '21:30', '22:30', false, false , true , 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd')),

  ('5466sd44v34vbh64756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '53223mcnv34344vb89vjgh05hjvcxv03'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 4, '17:00', '17:45', true, false , true , 'BEGINNER', (SELECT id FROM room WHERE name = 'm')),
  ('5466sd44v34v73jd756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '5322tycnv34344vb89vjgh05hjvcxv03'), (SELECT id FROM instructor WHERE sid = '116789cnv65488vb110jgh05hjvcvv63'), 4, '19:15', '20:15', true, false , true , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('54839d44v34v73jd756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '5322tycnv34344vb89vjgh05hjvcxv03'), (SELECT id FROM instructor WHERE sid = '116789cnv65488vb110jgh05hjvcvv63'), 4, '20:15', '21:15', true, false , true , 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd')),
  ('54839d44kclv73jd756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '5322tycnv34344vb89vjgh05hjvc1233'), (SELECT id FROM instructor WHERE sid = '536789cnv11389vb89vjgh05hjvc8763'), 4, '21:15', '22:15', false, false , true , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),

  ('73839d44kclv73jd756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '43223369f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 5, '10:00', '11:00', true, false , true , 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd')),
  ('73hdjd44kclv73jd756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '43632299f343445289vjkb50c1168103'), null, 5, '11:00', '11:45', false, true, false , 'BEGINNER', (SELECT id FROM room WHERE name = 'd')),
  ('03999d44kclv73jd756j0plmxzvnnkkk', (SELECT id FROM style WHERE sid = '43223299f343445289vjkb0011168103'), (SELECT id FROM instructor WHERE sid = '536789cnv34344vb89vjgh05hjvc1233'), 5, '16:00', '17:00', false, true , false , 'INTERMEDIATE', (SELECT id FROM room WHERE name = 'd'));

INSERT INTO news (sid, title, created_at, content, image_src, image_alt) VALUES
  ('73hdjd44kclv73jd756j0plmxzvycuxk', 'Ooga Booga!', '2013-06-24 00:21', 'Instruktorka z naszej szkoły - Barbara Karpińska podczas wczorajszego wrocławskiego turnieju tańca nowoczesnego dla dzieci i młodzieży "Ooga Booga" pełniła funkcję przewodniczącego jury :)<br/><br/>W szkole funkcjonuje formacja dziecięca, prowadzona przez Barbarę - od września ruszamy z kolejnym naborem dla nowych członków, w związku z czym zapraszamy dzieci w wieku 5-11 lat. Formacja bierze udział w licznych konkursach w kategorii Show dance oraz wielu pokazach. W najbliższym czasie nasze dzieciaki będziemy mogli podziwiać 14 lipca w Lwówku Śląskim podczas Lwóweckiego Lata Agatowego :)<br/><br/>Zapraszamy do oglądania galerii z wczorajszego turnieju.', 'img/photos/oogabooga.jpg', 'konkurs tańca wrocław'),
  ('73hdjd44kclv73jd756j0plmxzvycjck', 'Lwóweckie lato agatowe', '2013-07-23 14:05', '14 lipca małe Setenty wystąpiły podczas tegorocznych obchodów Lwóweckiego Lata Agatowego.<br/><br/>Zaprezentowały swój najnowszy układ w rytmach country - kapelusze kowbojskie, energetyczna muzyka... Publiczność dosłownie oszalała z zachwytu :)<br/><br/>Gratulujemy, było super!', 'img/photos/lwowek.jpg', 'pokazy tańca dolnośląskie'),
  ('73hdjd44kclv73jd756j0plmxzvyycns', 'Ruszają zajęcia z zouka!', '2013-08-29 15:03', 'Już w najbliższą środę o 20:30 ruszamy z długo oczekiwanymi zajęciami z zouka dla średniozaawansowanych! Zajęcia poprowadzi Julia Utig.<br/><br/>ZOSTAŁY JESZCZE WOLNE MIEJSCA!<br/>Nie trzeba się zapisywać w parach, można przyjść samemu :)<br/><br/>Ważna informacja dla początkujących! Formujemy już grupę od podstaw :)<br/><br/>Zapisy pod numerem telefonu: 695 081 437', 'img/photos/zouk.jpg', 'zouk wrocław'),
  ('73hdjd44kclv73jd7ueiiplmxzvyycns', 'Nowa szata graficzna!', '2013-09-13 09:25', 'W końcu ruszyła nasza strona internetowa po generalnej przebudowie graficznej!<br/><br/>Zachęcamy do częstych odwiedzin - już niebawem zupełnie nowe, REWOLUCYJNE funkcjonalności!', 'img/photos/nowastrona.png', 'szkoła tańca wrocław'),
  ('73hdjd44kcuejdmd7ueiiplmxzvyycns', 'Uwaga! Zmieniamy lokalizację!', '2013-11-01 08:47', 'Przenosimy zajęcia na Sienkiewicza 6a - wejście od strony pl. Bema!<br /><br />Dwie przestronne sale będą do Waszej dyspozycji już od poniedziałku!', 'https://scontent-b-ams.xx.fbcdn.net/hphotos-prn2/1425738_533370393413415_1125803338_n.png', 'taniec wrocław'),
  ('bcnmxd44kclv73jd756j0plmxzvycjck', 'Zajęcia z zumby', '2013-11-02T18:20', 'Niesamowita, żywiołowa i energetyczna Angela to <strong>KOLEJNY NOWY INSTRUKTOR</strong> w naszej kadrze! Zabierz znajome i wpadnij do nas na zumbę! Zumba Angela ma już swoją renomę we Wrocławiu, przekonaj się i Ty! :)<br/><br/>Zajęcia ruszają już w czwartek, 14 listopada - dołączyć można w każdej chwili!<br/><br/>TERMIN:<br/>czwartek 18:30 - 19:30<br/><br/>ZAPISY:<br/>Telefon: 695 081 437<br/>E-mail: kontakt@setenta.wroclaw.pl','http://igglamour.files.wordpress.com/2012/01/zumba-fitness.jpg','zumba wrocław'),
  ('bcnmxd44k567ujjd756j0plmxzvycjck', 'Hip-hop z Mostkiem!','2013-11-02 21:31','Zapraszamy serdecznie na zajęcia hip-hop z <strong>NOWYM INSTRUKTOREM</strong>! Zajęcia poprowadzi znana i ceniona w środowisku Marta Mościcka - Mostek, <strong>wielokrotna finalistka mistrzostw Polski w hip-hopie</strong>.<br/><br/>TERMIN: wtorek 18:30 - 19:30<br/><br/>RUSZAJĄ ZAPISY - GRUPA RUSZY PO ZEBRANIU WYMAGANEJ LICZBY UCZESTNIKÓW<br/><br/>Telefon: 695 081 437<br/>E-mail: kontakt@setenta.wroclaw.pl','img/photos/mostek.jpg','hip hop wrocław'),
  ('22wexd44k567ujjd756j0plmxzvycjck', 'Przedsylwestrowe warsztaty taneczne', '2013-12-15 22:14',"Masz dość podpierania ścian w sylwestra? Zapraszamy Cię na <strong>przedsylwestrowe warsztaty tańca użytkowego</strong> - discofox, blues, rock'n'roll, walc oraz salsa. Przełam się i zostań królem parkietu!<br /><br />1,5 h zajęć przez trzy dni - 27, 28, 29 grudnia, godz. 19:00. Koszt trzydniowych warsztatów to <strong>JEDYNE 35 zł od osoby</strong>!<br /><br />Zapisy telefoniczne: 695 081 437 bądź z poziomu naszej strony internetowej (szybka wiadomość)",  'https://scontent-b-vie.xx.fbcdn.net/hphotos-prn2/t1/1469900_553053174778470_122507627_n.jpg','taniec na sylwestra'),
  ('bcnmxd44k5llskamnn6j0plmxzvycjck', 'Bal przebierańców dla dzieci','2014-02-05 12:53', 'Są jeszcze miejsca na niedzielny (<em>10 lutego</em>) <strong>BAL PRZEBIERAŃCÓW DLA DZIECI</strong>! Zwariowana zabawa pod okiem wykwalifikowanej kadry instruktorów.<br /><br />W programie:<ul><li>Zabawy taneczne</li><li>Zabawy plastyczne</li><li>Konkursy</li><li>Nauka tańca</li></ul>Zapewniamy napoje i słodycze.<br/><br/>Czas: 15:00 - 18:00<br/>Koszt: 15 zł', 'https://scontent-a-ams.xx.fbcdn.net/hphotos-frc1/t1/1897992_576863989064055_839558548_n.png','balik przebierańców'),
  ('b5557844k5llskamnn6j0plmxzvycjck', 'Walentynkowy wieczorek taneczny', '2014-02-06 19:06', 'Brak pomysłów na walentynkowy weekend?<br/>W sobotę (<em>15 lutego</em>) zapraszamy na <strong>WALENTYNKOWY WIECZOREK TANECZNY</strong>!<br/><br/>W programie:<ul><li>lekcje tańca</li><li>animacje</li><li>pokazy tańca</li></ul>Oferujemy:<ul><li>lampkę szampana</li><li>przekąski</li></ul>Startujemy o godz. 18:00<br/>Koszt: 15 zł', 'https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-ash3/t1/1000956_577420719008382_815465883_n.jpg','walentynkowy wieczorek taneczny'),
  ('g5557844k5llskamnn6j0plmxzvycjck', 'Walentynkowa promocja dla narzeczonych', '2014-02-12 15:03','Każda para, która w dzień WALENTYNEK zgłosi się do nas telefonicznie (<em>695 081 437</em>) bądź mailowo (<em>kontakt@setenta.wroclaw.pl</em>) otrzyma możliwość zakupu karnetu na pierwszy taniec! <br/><br /><strong>4 lekcje INDYWIDUALNE w cenie 110 zł zamiast 220 zł!</strong><br/><br/>Instruktor ułoży Wam choreografię pod wybraną muzykę i wymagania :)<br/><br/>Zapraszamy!','img/photos/dirty-dancing.jpg','walentynkowy wieczorek taneczny');

INSERT INTO user (sid, first_name, last_name, login, password, email, type) VALUES
  ('hdjfkhdjfkhdjfkhdjfkhdjfkhdjfkpp', 'Pawel', 'Radomski', 'test', 'test', 'test@mail.com', 1);

--changeset pawel:3
INSERT INTO news (sid, title, created_at, content, image_src, image_alt) VALUES
('g5557844k5vnncamnn6j0plmxzvycjck', 'Nowy sezon taneczny', '2014-08-19 10:17','Wkrótce udostępnimy rozkład zajęć na nowy sezon taneczny. Więcej szczegółów już niedługo!','https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-xpa1/v/t1.0-9/10446669_671875722896214_5959040016819759075_n.jpg?oh=23cff3609a091378d531443a8e44a6aa&oe=5469E1AB&__gda__=1415565075_77ba39a6598ae3ca2a3f9beed3902080','zajęcia taneczne jesień');

--changeset pawel:4
INSERT INTO news (sid, title, created_at, content, image_src, image_alt) VALUES
('g55578jdkeenncamnn6j0plmxzvycjck', 'Zajęcia dla dzieci od września', '2014-08-21 16:06','Już od września ruszamy z naborem do nowych grup taneczny dla dzieci i młodzieży:<ul><li>balet (4-7 lat)</li><li>balet z elementami gimnastyki artystycznej</li><li>balet dla 3-latków</li><li>grupa pokazowa - formacja taneczna (<strong>konkursy, pokazy plenerowe</strong>)</li><li>taniec towarzyski (<strong>wyjazdy na turnieje, możliwość zdobycia pierwszych klas tanecznych</strong>)</li><li>mix dance</li><li>zajęcia ruchowo taneczne w języku angielskim</li><li>hip-hop dla malucha</li><li>hip-hop dla młodzieży (12-18 lat)</li></ul><br /><br/>Zadzwoń i zapisz swoje dziecko: 695 081 437','http://bielskiemamy.pl/wp-content/uploads/2013/05/po-co-dziecku-taniec_slider2.jpg','zajęcia taneczne dla dzieci');

--changeset pawel:5
UPDATE news SET image_src='http://www.fit.pl/g/str/image/dziecko%20fit/ChildrenDancing.jpg' WHERE sid='g55578jdkeenncamnn6j0plmxzvycjck';

--changeset pawel:6
TRUNCATE dance_class;

--changeset pawel:7
ALTER TABLE dance_class ADD COLUMN comment TEXT;

--changeset pawel:8
ALTER TABLE room ADD COLUMN code VARCHAR(16) NOT NULL DEFAULT "test";

--changeset pawel:9
ALTER TABLE user ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;
ALTER TABLE category ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;
ALTER TABLE style ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;
ALTER TABLE dance_class ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;
ALTER TABLE room ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;
ALTER TABLE instructor ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;
ALTER TABLE instructor_description ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;
ALTER TABLE news ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;

--changeset pawel:10
ALTER TABLE email ADD COLUMN object_state INT(4) NOT NULL DEFAULT 0;
CREATE TABLE password (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  sid VARCHAR(32) NOT NULL,
  object_state INT(4) NOT NULL,
  value VARCHAR(128) NOT NULL,
  user_id INT(11) NOT NULL,
  UNIQUE (sid),
  FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE password ADD INDEX password_sid_idx (sid);
ALTER TABLE password ADD INDEX password_user_idx (user_id);