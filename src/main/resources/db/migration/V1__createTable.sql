drop table if exists users;
drop table if exists admins;
drop table if exists course;
drop table if exists groups;
drop table if exists teachers;
drop table if exists student;
drop table if exists courses_students;
drop table if exists groups_courses;
drop table if exists course_teacher;

create table if not exists users(
    id serial primary key,
    email                     varchar(255),
    is_account_non_expired     boolean not null,
    is_account_non_locked      boolean not null,
    is_credentials_non_expired boolean not null,
    is_enabled                 boolean not null,
    password                 varchar(255),
    role                      varchar(255)
    );
create table admins
(
    id serial not null
        primary key,
    first_name varchar(255),
    last_name  varchar(255),
    user_id bigint references users(id)
);

create table if not exists course(
    id serial not null
        primary key,
    course_name   varchar(255),
    date_of_start date,
    description   varchar(255),
    image         varchar(255)
);

create table if not exists groups
(
    id serial not null
    primary key,
    date_of_start date,
    description   varchar(255),
    group_name    varchar(255),
    imagine       varchar(255)
    );
create table if not exists teachers
(
    id  serial not null
    primary key,
    last_name      varchar(255),
    name          varchar(255),
    phone_number   varchar(255),
    specialization varchar(255),
    user_id        bigint
    references users(id)
    );

create table if not exists student
(
    id  serial not null
    primary key,
    email        varchar(255),
    last_name    varchar(255),
    phone_number varchar(255),
    role         varchar(255),
    student_name varchar(255),
    study_format varchar(255),
    group_id     bigint
    references groups(id)
    );



create table courses_students
(
    course_id  bigint not null
            references course(id),
    student_id bigint not null
            references student(id)
);

create table groups_courses
(
    group_id   bigint not null
            references groups(id),
    courses_id bigint not null
            references course(id)
);


create table if not exists course_teacher
(
    course_id  bigint not null
    references course(id),
    teacher_id bigint not null
    references teachers(id)
);

insert into users(email, password, role, is_account_non_expired,
                  is_account_non_locked, is_credentials_non_expired, is_enabled) values
    ('admin@gmail.com', '$2a$04$bgaWpBkJrajY/yO9sbjPe.dAZkMCGp.XZEJiwhFxOyLS6ENMe5Y7m',
     'ROLE_ADMIN',true,true,true,true);

insert into admins(first_name, last_name, user_id) values
    ('Kairatbek', 'Shabotoev', (
        select id from users where email = 'admin@gmail.com'
    ));














