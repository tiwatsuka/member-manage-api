create table if not exists t_subject (
    subject_id int auto_increment primary key,
    subject_name varchar(255) not null unique
);

create table if not exists t_tag (
    tag_id int auto_increment primary key,
    tag_name varchar(255) not null unique
);

create table if not exists t_group (
    group_id int auto_increment primary key,
    group_name varchar(255) not null unique
);

create table if not exists t_member (
    member_id int auto_increment primary key,
    member_name varchar(255) not null,
    email varchar(255),
    phone varchar(20)
);

create table if not exists t_role (
    role_id int auto_increment primary key,
    role_name varchar(255) not null unique
);

create table if not exists t_subject_tag (
    subject_id int,
    tag_id int,
    foreign key (subject_id) references t_subject(subject_id),
    foreign key (tag_id) references t_tag(tag_id),
    unique(subject_id, tag_id)
);

create index idx_subject_tag ON t_subject_tag(tag_id);

create table if not exists t_subject_detail (
    subject_id int,
    group_id int,
    member_id int,
    role_id int,
    foreign key (subject_id) references t_subject(subject_id),
    foreign key (group_id) references t_group(group_id),
    foreign key (member_id) references t_member(member_id),
    foreign key (role_id) references t_role(role_id),
    unique(subject_id, group_id, member_id, role_id)
);

create index idx_subject_detail ON t_subject_detail(subject_id, group_id)