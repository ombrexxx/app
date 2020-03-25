insert into course (id, class_location, name) values (1, 32, "bio");
insert into course (id, class_location, name) values (2, 11, "math");
insert into test.course (class_location, name) values (16, "physics");
insert into test.course (class_location, name) values (6, "history");
insert into test.course (class_location, name) values (12, "english");
insert into test.course (class_location, name) values (25, "programming");

insert into test.student (email,first_name,last_name,year) values ("dsadas@fdsfs","Ondrej","Martin",1554);
insert into test.student (email,first_name,last_name,year) values ("bla@frio","dennis","bob",2000);
insert into test.student (email,first_name,last_name,year) values ("sla@drio","rod","stewart",1999);
insert into test.student (email,first_name,last_name,year) values ("gla@vio","mike","smith",1970);
insert into test.student (email,first_name,last_name,year) values ("cla@zasc","steve","davis",2010);

insert into test.course_student values (1,3);
insert into test.course_student values (1,5);
insert into test.course_student values (2,1);
insert into test.course_student values (2,5);

insert into test.user values (1,true, "pass1", "ROLES_USER", "user1");
insert into test.user values (2,true, "pass2", "ROLES_USER", "user2");