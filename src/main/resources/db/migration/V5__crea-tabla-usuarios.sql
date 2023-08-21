create table Usuarios(

    id bigint not null auto_increment,
    acceso varchar(100) not null,
    contrasena varchar(255) not null unique,

    primary key(id)
);