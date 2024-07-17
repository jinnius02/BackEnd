create table `member`(
    id     varchar(20)  primary key ,
    pwd    varchar(20)  not null,
    name   varchar(30)  not null
    
);

insert into member values ('gildong','1234','나길동');
insert into member values ('juwon','2222','나주원');
insert into member values ('lime','3333','차라임');

commit;