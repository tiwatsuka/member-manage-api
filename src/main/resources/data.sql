DELETE t_subject_tag;
DELETE t_subject;
DELETE t_tag;
INSERT INTO t_subject (subject_id, subject_name) VALUES (0, 'subject');
INSERT INTO t_tag (tag_id, tag_name) VALUES (0, 'tag');
INSERT INTO t_tag (tag_id, tag_name) VALUES (1, 'tag2');
INSERT INTO t_subject_tag (subject_id, tag_id) VALUES (0, 0);
INSERT INTO t_subject_tag (subject_id, tag_id) VALUES (0, 1);
