create table Pacientes(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    correo varchar(100) not null unique,
    telefono varchar(100) not null,
    enfermedad varchar(100) not null,
    logradouro varchar(100) not null,
    barrio varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    estado char(2) not null,
    ciudad varchar(100) not null,

    primary key(id)

);