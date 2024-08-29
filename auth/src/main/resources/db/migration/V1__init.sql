create table members (
     created_at timestamp(6) not null,
     member_id binary(16) not null,
     email varchar(255) not null,
     name varchar(255),
     profile_url varchar(255),
     primary key (member_id)
);