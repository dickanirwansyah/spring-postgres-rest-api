create table author(
    idauthor varchar(255) not null unique,
    name varchar(255) not null,

    constraint pk_author_idauthor PRIMARY KEY (idauthor)
);

create table category(
    idcategory varchar(255) not null unique,
    name varchar(255) not null,

    constraint pk_category_idcategory PRIMARY KEY (idcategory)
);

create table book(
    idbook varchar(255) not null unique,
    name varchar(255) not null,
    idcategory varchar(255) not null,
    idauthor varchar(255) not null,
    price int not null,
    stock int not null,

    constraint pk_book_idbook PRIMARY KEY (idbook),
    constraint fk_book_idcategory FOREIGN KEY (idcategory)
    REFERENCES category (idcategory),
    constraint fk_author_idauthor FOREIGN KEY (idauthor)
    REFERENCES author (idauthor)
);