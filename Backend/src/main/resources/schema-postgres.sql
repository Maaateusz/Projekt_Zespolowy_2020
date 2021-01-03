
CREATE TABLE IF NOT EXISTS guest_survey_participate (id_survey serial REFERENCES survey (id) ON UPDATE CASCADE ON DELETE CASCADE, id_guest serial REFERENCES guest (id) ON UPDATE CASCADE ON DELETE CASCADE, CONSTRAINT guest_survey_pkey PRIMARY KEY (id_survey, id_guest))

CREATE TABLE IF NOT EXISTS guest_survey_creator (id_survey serial REFERENCES survey (id) ON UPDATE CASCADE ON DELETE CASCADE, id_guest serial REFERENCES guest (id) ON UPDATE CASCADE ON DELETE CASCADE, CONSTRAINT guest_survey_pkey PRIMARY KEY (id_survey, id_guest))
