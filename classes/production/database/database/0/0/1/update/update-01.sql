BEGIN;

ALTER TABLE dance_class DROP COLUMN start_time;
ALTER TABLE dance_class DROP COLUMN end_time;
ALTER TABLE dance_class ADD COLUMN start_time TIME NOT NULL;
ALTER TABLE dance_class ADD COLUMN end_time TIME NOT NULL;

COMMIT;
