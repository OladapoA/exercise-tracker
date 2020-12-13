INSERT INTO users (first_name, last_name) VALUES ('ORIGINAL', 'CREATOR');
INSERT INTO users (first_name, last_name) VALUES ('John', 'Doe');
INSERT INTO users (first_name, last_name) VALUES ('Jane', 'Doe');

INSERT INTO routines (user_id, is_public, name, description, created_at) VALUES (2, FALSE, 'Best Workout', 'The best workout according to me', '2020-11-28 14:55:00');
INSERT INTO routines (user_id, is_public, name, description, created_at) VALUES (3, TRUE, 'Worst Workout', 'The worst workout in name only', '2020-11-28 14:56:00');

INSERT INTO exercises (user_id, name, variation_parent, description) VALUES (1, 'Rest', NULL, 'Rest');
INSERT INTO exercises (user_id, name, variation_parent, description) VALUES (1, 'Pull-ups', NULL, 'Pull body to bar');
INSERT INTO exercises (user_id, name, variation_parent, description) VALUES (1, 'Chin-ups', 2, 'Pull body to bar with the back of your hand facing away from you and elbows point downwards with a narrow grip');
INSERT INTO exercises (user_id, name, variation_parent, description) VALUES (1, 'Typewriter pull-up', 2, 'Keeping your head above bar, pull yourself from side to side');

INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (1, 2, 4, '0:02:00', 10, '0:00:30', NULL);
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (1, 1, NULL,	NULL, NULL,	NULL, '0:05:00');
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (1, 3, 4, '0:02:00', 10, '0:00:30', NULL);
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (1, 1, NULL, NULL, NULL,	NULL, '0:05:00');
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (1, 4, 4, '0:02:00', 10, '0:00:30', NULL);
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (2, 2, 1000, '0:00:01', 1000, '0:00:01', NULL);
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (2, 1, NULL, NULL, NULL,	NULL, '0:00:01');
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (2, 3, 1000, '0:00:01', 1000, '0:00:01', NULL);
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (2, 1, NULL, NULL, NULL,	NULL, '0:00:01');
INSERT INTO routine_exercises (routine_id, exercise_id, sets, set_break, reps, rep_break, time) VALUES (2, 4, 1000, '0:00:01', 1000, '0:00:01', NULL);

INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Quadriceps', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Hamstrings', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Calves', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Chest', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Back', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Shoulders', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Triceps', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Biceps', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Forearms', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Trapezius', NULL);
INSERT INTO muscle_groups (major_name, minor_name) VALUES ('Abs', NULL);

INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (2, 5);
INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (2, 6);
INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (2, 8);
INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (3, 5);
INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (3, 6);
INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (3, 8);
INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (4, 5);
INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (4, 6);
INSERT INTO exercise_muscle_groups (exercise_id, muscle_group_id) VALUES (4, 8);
