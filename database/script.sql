create database if not exists webexp;
use webexp;
create table if not exists CLASS
(
    CLASSID   char(8)                            not null,
    CLASSNAME varchar(20)                        not null,
    REGTIME   datetime default CURRENT_TIMESTAMP not null,
    SPECIALTY varchar(20)                        null,
    REMARK    varchar(20)                        null,
    constraint CLASS_CLASSID_uindex
        unique (CLASSID)
);

alter table CLASS
    add primary key (CLASSID);

create table if not exists STUDENT
(
    USERID    char(8)                            not null,
    USERNAME  varchar(20)                        not null,
    PASSWORD  varchar(64)                        not null,
    SEX       enum ('男', '女')                    not null,
    BIRTHDAY  date                               null,
    REGTIME   datetime default CURRENT_TIMESTAMP not null,
    SPECIALTY varchar(20)                        null,
    REMARK    varchar(20)                        null,
    constraint STUDENT_USERID_uindex
        unique (USERID),
    constraint STUDENT_USERNAME_uindex
        unique (USERNAME)
);

alter table STUDENT
    add primary key (USERID);

create table if not exists STUDENT_CLASS
(
    USERID  char(8)                            not null,
    CLASSID char(8)                            not null,
    REGTIME datetime default CURRENT_TIMESTAMP not null,
    GRADE   double                             null,
    primary key (USERID, CLASSID),
    constraint STUDENT_CLASS_CLASS_CLASSID_fk
        foreign key (CLASSID) references CLASS (CLASSID)
            on update cascade on delete cascade,
    constraint STUDENT_CLASS_STUDENT_USERID_fk
        foreign key (USERID) references STUDENT (USERID)
            on update cascade on delete cascade
);


