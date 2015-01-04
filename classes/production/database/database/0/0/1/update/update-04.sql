UPDATE dance_class set day = 'PN' WHERE day='MONDAY';
UPDATE dance_class set day = 'WT' WHERE day='TUESDAY';
UPDATE dance_class set day = 'ŚR' WHERE day='WEDNESDAY';
UPDATE dance_class set day = 'CZ' WHERE day='THURSDAY';
UPDATE dance_class set day = 'PT' WHERE day='FRIDAY';
UPDATE dance_class set day = 'SB' WHERE day='SATURDAY';
UPDATE dance_class set day = 'ND' WHERE day='SUNDAY';

ALTER TABLE dance_class MODIFY day INT4 NOT NULL;
ALTER TABLE dance_class MODIFY start_time VARCHAR(5) NOT NULL;
ALTER TABLE dance_class MODIFY end_time VARCHAR(5) NOT NULL;
ALTER TABLE news MODIFY created_at VARCHAR(16) NOT NULL;