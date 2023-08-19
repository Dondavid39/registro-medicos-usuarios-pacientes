alter table Pacientes add activo tinyint;
update pacientes set activo = 1;
