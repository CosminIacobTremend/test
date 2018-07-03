INSERT INTO actors (actor_id, first_name, last_name) VALUES (1, 'Marlon', 'Brando');
INSERT INTO actors (actor_id, first_name, last_name) VALUES (2, 'Al', 'Pacino');
INSERT INTO actors (actor_id, first_name, last_name) VALUES (3, 'Robert', 'Duvall');
INSERT INTO actors (actor_id, first_name, last_name) VALUES (4, 'Robert', 'De Niro');
INSERT INTO actors (actor_id, first_name, last_name) VALUES (5, 'Sharon', 'Stone');
INSERT INTO actors (actor_id, first_name, last_name) VALUES (6, 'Joe', 'Pesci');


INSERT INTO director (director_id, first_name, last_name) VALUES (1, 'Martin', 'Scorsese');
INSERT INTO director (director_id, first_name, last_name) VALUES (2, 'Francis', 'Ford Coppola');
INSERT INTO director (director_id, first_name, last_name) VALUES (3, 'Harold', 'Ramis');



INSERT INTO movie (movie_id, movie_name, director_id) VALUES (1, 'The Godfather', 2);
INSERT INTO movie (movie_id, movie_name, director_id) VALUES (2, 'The Godfather: Part II', 2);
INSERT INTO movie (movie_id, movie_name, director_id) VALUES (3, 'Casino', 1);
INSERT INTO movie (movie_id, movie_name, director_id) VALUES (4, 'Analyze This', 3);


INSERT INTO genre(genre_id, genre_name) VALUES (1, 'Crime');
INSERT INTO genre(genre_id, genre_name) VALUES (2, 'Drama');
INSERT INTO genre(genre_id, genre_name) VALUES (3, 'Comedy');




INSERT INTO award(award_id, award_name, movie_id) VALUES (1, 'Academy Award for Best Picture', 1);
INSERT INTO award(award_id, award_name, movie_id) VALUES (2, 'Golden Globe Award for Best Actor Motion Picture Drama', 1);
INSERT INTO award(award_id, award_name, movie_id) VALUES (3, 'Golden Globe Award for Best Motion Picture Drama', 1);
INSERT INTO award(award_id, award_name, movie_id) VALUES (4, 'Academy Award for Best Picture', 2);
INSERT INTO award(award_id, award_name, movie_id) VALUES (5, 'Academy Award for Best Original Music Score', 2);
INSERT INTO award(award_id, award_name, movie_id) VALUES (6, 'Academy Award for Best Production Design', 2);
INSERT INTO award(award_id, award_name, movie_id) VALUES (7, 'Golden Globe Award for Best Actress Motion Picture Drama', 3);
INSERT INTO award(award_id, award_name, movie_id) VALUES (8, 'Funniest Motion Picture', 4);


INSERT INTO movies_actors(movie_id, actor_id) VALUES (1, 1);
INSERT INTO movies_actors(movie_id, actor_id) VALUES (1, 2);
INSERT INTO movies_actors(movie_id, actor_id) VALUES (1, 3);

INSERT INTO movies_actors(movie_id, actor_id) VALUES (2, 2);
INSERT INTO movies_actors(movie_id, actor_id) VALUES (2, 3);
INSERT INTO movies_actors(movie_id, actor_id) VALUES (2, 4);

INSERT INTO movies_actors(movie_id, actor_id) VALUES (3, 4);
INSERT INTO movies_actors(movie_id, actor_id) VALUES (3, 5);
INSERT INTO movies_actors(movie_id, actor_id) VALUES (3, 6);

INSERT INTO movies_actors(movie_id, actor_id) VALUES (4, 4);

INSERT INTO movies_genres(movie_id, genre_id) VALUES (1, 1);
INSERT INTO movies_genres(movie_id, genre_id) VALUES (1, 2);
INSERT INTO movies_genres(movie_id, genre_id) VALUES (2, 1);
INSERT INTO movies_genres(movie_id, genre_id) VALUES (2, 2);
INSERT INTO movies_genres(movie_id, genre_id) VALUES (3, 1);
INSERT INTO movies_genres(movie_id, genre_id) VALUES (3, 2);
INSERT INTO movies_genres(movie_id, genre_id) VALUES (4, 1);
INSERT INTO movies_genres(movie_id, genre_id) VALUES (4, 3);

INSERT INTO demo_user(user_id, username, password) VALUES (1, 'test1', '$2a$11$A/U7eTj43Mgnwvjj5j751eHKkBS478MBwNI7gr6sMV2T2FlyG4Ry6');
INSERT INTO demo_user(user_id, username, password) VALUES (2, 'test2', '$2a$11$MPJwu49rFL/H4xDJvhniuuJ1gIXsesBDN6PhAijdxnAMcgqyzxmU6');




