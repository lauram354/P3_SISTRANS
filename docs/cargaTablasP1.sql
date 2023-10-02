-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-01 20:00:45 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE consumhabi (
    productshabi_producto INTEGER NOT NULL,
    cuentaconsu_idcuenta  INTEGER NOT NULL,
    cantidad              INTEGER NOT NULL,
    costo                 FLOAT NOT NULL
);

ALTER TABLE consumhabi ADD CONSTRAINT consumhabi_pk PRIMARY KEY ( productshabi_producto,
                                                                  cuentaconsu_idcuenta );

CREATE TABLE cuentaconsu (
    pagado             NUMBER NOT NULL,
    idcuenta           INTEGER NOT NULL,
    reservas_idreserva INTEGER NOT NULL
);

ALTER TABLE cuentaconsu ADD CONSTRAINT cuentaconsu_pk PRIMARY KEY ( idcuenta );

CREATE TABLE gimnasios (
    idservicio INTEGER NOT NULL,
    capacidad  INTEGER NOT NULL,
    costo      FLOAT NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( idservicio );

CREATE TABLE habitaciones (
    id                  INTEGER NOT NULL,
    tv                  NUMBER NOT NULL,
    minibar             NUMBER NOT NULL,
    cafetera            NUMBER NOT NULL,
    tipohabi_tipo       VARCHAR2(200) NOT NULL,
    hoteles_nombrehotel VARCHAR2(200) NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( id );

CREATE TABLE horariogym (
    gimnasios_idservicio INTEGER NOT NULL,
    horarios_idservicio  INTEGER NOT NULL
);

ALTER TABLE horariogym ADD CONSTRAINT horariogym_pk PRIMARY KEY ( gimnasios_idservicio,
                                                                  horarios_idservicio );

CREATE TABLE horariopisc (
    piscinas_idservicio INTEGER NOT NULL,
    horarios_idservicio INTEGER NOT NULL
);

ALTER TABLE horariopisc ADD CONSTRAINT horariopisc_pk PRIMARY KEY ( piscinas_idservicio,
                                                                    horarios_idservicio );

CREATE TABLE horarios (
    idservicio  INTEGER NOT NULL,
    horainicial VARCHAR2(200) NOT NULL,
    dias        VARCHAR2(200) NOT NULL,
    horafinal   VARCHAR2(200) NOT NULL
);

ALTER TABLE horarios ADD CONSTRAINT horarios_pk PRIMARY KEY ( idservicio );

CREATE TABLE hoteles (
    nombrehotel       VARCHAR2(200) NOT NULL,
    cant_habitaciones INTEGER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nombrehotel );

CREATE TABLE maquigym (
    gimnasios_idservicio INTEGER NOT NULL,
    maquinas_maquinas_id NUMBER NOT NULL
);

ALTER TABLE maquigym ADD CONSTRAINT maquigym_pk PRIMARY KEY ( gimnasios_idservicio,
                                                              maquinas_maquinas_id );

CREATE TABLE maquinas (
    maquinas_id NUMBER NOT NULL,
    nombre      VARCHAR2(200) NOT NULL
);

ALTER TABLE maquinas ADD CONSTRAINT maquinas_pk PRIMARY KEY ( maquinas_id );

CREATE TABLE piscinas (
    idservicio  INTEGER NOT NULL,
    capacidad   INTEGER NOT NULL,
    profundidad FLOAT NOT NULL,
    costo       FLOAT NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( idservicio );

CREATE TABLE planesconsum (
    tipo                VARCHAR2(200) NOT NULL,
    descuento           FLOAT NOT NULL,
    dias                INTEGER NOT NULL,
    hoteles_nombrehotel VARCHAR2(200) NOT NULL
);

ALTER TABLE planesconsum ADD CONSTRAINT planesconsum_pk PRIMARY KEY ( tipo );

CREATE TABLE planserv (
    planesconsum_tipo    VARCHAR2(200) NOT NULL,
    servicios_idservicio INTEGER NOT NULL,
    descuento            FLOAT NOT NULL
);

ALTER TABLE planserv ADD CONSTRAINT planserv_pk PRIMARY KEY ( planesconsum_tipo,
                                                              servicios_idservicio );

CREATE TABLE productshabi (
    producto        INTEGER NOT NULL,
    costo           FLOAT NOT NULL,
    id              INTEGER NOT NULL,
    habitaciones_id INTEGER NOT NULL
);

ALTER TABLE productshabi ADD CONSTRAINT productshabi_pk PRIMARY KEY ( producto );

CREATE TABLE reservan (
    reservas_idreserva INTEGER NOT NULL,
    usuarios_idusuario INTEGER NOT NULL
);

ALTER TABLE reservan ADD CONSTRAINT reservan_pk PRIMARY KEY ( reservas_idreserva,
                                                              usuarios_idusuario );

CREATE TABLE reservas (
    idreserva    INTEGER NOT NULL,
    numpersonas  INTEGER NOT NULL,
    fechainicial DATE NOT NULL,
    fechafinal   DATE NOT NULL,
    tipo         VARCHAR2(200) NOT NULL
);

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( idreserva );

CREATE TABLE servconsum (
    servicios_idservicio INTEGER NOT NULL,
    reservas_idreserva   INTEGER NOT NULL,
    fecha                DATE NOT NULL
);

ALTER TABLE servconsum ADD CONSTRAINT servconsum_pk PRIMARY KEY ( servicios_idservicio,
                                                                  reservas_idreserva );

CREATE TABLE servhotel (
    hoteles_nombrehotel  VARCHAR2(200) NOT NULL,
    servicios_idservicio INTEGER NOT NULL
);

ALTER TABLE servhotel ADD CONSTRAINT servhotel_pk PRIMARY KEY ( hoteles_nombrehotel,
                                                                servicios_idservicio );

CREATE TABLE servicios (
    idservicio     INTEGER NOT NULL,
    tipo           VARCHAR2(200) NOT NULL,
    servicios_type VARCHAR2(9) NOT NULL
);

ALTER TABLE servicios
    ADD CONSTRAINT ch_inh_servicios CHECK ( servicios_type IN ( 'Gimnasios', 'Piscinas', 'Servicios' ) );

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( idservicio );

CREATE TABLE tipohabi (
    tipo      VARCHAR2(200) NOT NULL,
    capacidad INTEGER NOT NULL
);

ALTER TABLE tipohabi ADD CONSTRAINT tipohabi_pk PRIMARY KEY ( tipo );

CREATE TABLE usuarios (
    idusuario           INTEGER NOT NULL,
    nombreusuario       VARCHAR2(200) NOT NULL,
    email               VARCHAR2(200) NOT NULL,
    rol                 VARCHAR2(200) NOT NULL,
    hoteles_nombrehotel VARCHAR2(200) NOT NULL,
    tipoid              VARCHAR2(200) NOT NULL
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( idusuario );

ALTER TABLE consumhabi
    ADD CONSTRAINT consumhabi_cuentaconsu_fk FOREIGN KEY ( cuentaconsu_idcuenta )
        REFERENCES cuentaconsu ( idcuenta );

ALTER TABLE consumhabi
    ADD CONSTRAINT consumhabi_productshabi_fk FOREIGN KEY ( productshabi_producto )
        REFERENCES productshabi ( producto );

ALTER TABLE cuentaconsu
    ADD CONSTRAINT cuentaconsu_reservas_fk FOREIGN KEY ( reservas_idreserva )
        REFERENCES reservas ( idreserva );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( hoteles_nombrehotel )
        REFERENCES hoteles ( nombrehotel );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_tipohabi_fk FOREIGN KEY ( tipohabi_tipo )
        REFERENCES tipohabi ( tipo );

ALTER TABLE horariogym
    ADD CONSTRAINT horariogym_gimnasios_fk FOREIGN KEY ( gimnasios_idservicio )
        REFERENCES gimnasios ( idservicio );

ALTER TABLE horariogym
    ADD CONSTRAINT horariogym_horarios_fk FOREIGN KEY ( horarios_idservicio )
        REFERENCES horarios ( idservicio );

ALTER TABLE horariopisc
    ADD CONSTRAINT horariopisc_horarios_fk FOREIGN KEY ( horarios_idservicio )
        REFERENCES horarios ( idservicio );

ALTER TABLE horariopisc
    ADD CONSTRAINT horariopisc_piscinas_fk FOREIGN KEY ( piscinas_idservicio )
        REFERENCES piscinas ( idservicio );

ALTER TABLE maquigym
    ADD CONSTRAINT maquigym_gimnasios_fk FOREIGN KEY ( gimnasios_idservicio )
        REFERENCES gimnasios ( idservicio );

ALTER TABLE maquigym
    ADD CONSTRAINT maquigym_maquinas_fk FOREIGN KEY ( maquinas_maquinas_id )
        REFERENCES maquinas ( maquinas_id );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE planesconsum
    ADD CONSTRAINT planesconsum_hoteles_fk FOREIGN KEY ( hoteles_nombrehotel )
        REFERENCES hoteles ( nombrehotel );

ALTER TABLE planserv
    ADD CONSTRAINT planserv_planesconsum_fk FOREIGN KEY ( planesconsum_tipo )
        REFERENCES planesconsum ( tipo );

ALTER TABLE planserv
    ADD CONSTRAINT planserv_servicios_fk FOREIGN KEY ( servicios_idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE productshabi
    ADD CONSTRAINT productshabi_habitaciones_fk FOREIGN KEY ( habitaciones_id )
        REFERENCES habitaciones ( id );

ALTER TABLE reservan
    ADD CONSTRAINT reservan_reservas_fk FOREIGN KEY ( reservas_idreserva )
        REFERENCES reservas ( idreserva );

ALTER TABLE reservan
    ADD CONSTRAINT reservan_usuarios_fk FOREIGN KEY ( usuarios_idusuario )
        REFERENCES usuarios ( idusuario );

ALTER TABLE servconsum
    ADD CONSTRAINT servconsum_reservas_fk FOREIGN KEY ( reservas_idreserva )
        REFERENCES reservas ( idreserva );

ALTER TABLE servconsum
    ADD CONSTRAINT servconsum_servicios_fk FOREIGN KEY ( servicios_idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE servhotel
    ADD CONSTRAINT servhotel_hoteles_fk FOREIGN KEY ( hoteles_nombrehotel )
        REFERENCES hoteles ( nombrehotel );

ALTER TABLE servhotel
    ADD CONSTRAINT servhotel_servicios_fk FOREIGN KEY ( servicios_idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_hoteles_fk FOREIGN KEY ( hoteles_nombrehotel )
        REFERENCES hoteles ( nombrehotel );

CREATE OR REPLACE TRIGGER arc_fkarc_2_gimnasios BEFORE
    INSERT OR UPDATE OF idservicio ON gimnasios
    FOR EACH ROW
DECLARE
    d VARCHAR2(9);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Gimnasios' ) THEN
        raise_application_error(-20223, 'FK Gimnasios_Servicios_FK in Table Gimnasios violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Gimnasios'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE OR REPLACE TRIGGER arc_fkarc_2_piscinas BEFORE
    INSERT OR UPDATE OF idservicio ON piscinas
    FOR EACH ROW
DECLARE
    d VARCHAR2(9);
BEGIN
    SELECT
        a.servicios_type
    INTO d
    FROM
        servicios a
    WHERE
        a.idservicio = :new.idservicio;

    IF ( d IS NULL OR d <> 'Piscinas' ) THEN
        raise_application_error(-20223, 'FK Piscinas_Servicios_FK in Table Piscinas violates Arc constraint on Table Servicios - discriminator column Servicios_TYPE doesn''t have value ''Piscinas'''
        );
    END IF;

EXCEPTION
    WHEN no_data_found THEN
        NULL;
    WHEN OTHERS THEN
        RAISE;
END;
/

CREATE SEQUENCE cuentaconsu_idcuenta_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER cuentaconsu_idcuenta_trg BEFORE
    INSERT ON cuentaconsu
    FOR EACH ROW
    WHEN ( new.idcuenta IS NULL )
BEGIN
    :new.idcuenta := cuentaconsu_idcuenta_seq.nextval;
END;
/

CREATE SEQUENCE habitaciones_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER habitaciones_id_trg BEFORE
    INSERT ON habitaciones
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := habitaciones_id_seq.nextval;
END;
/

CREATE SEQUENCE maquinas_maquinas_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER maquinas_maquinas_id_trg BEFORE
    INSERT ON maquinas
    FOR EACH ROW
    WHEN ( new.maquinas_id IS NULL )
BEGIN
    :new.maquinas_id := maquinas_maquinas_id_seq.nextval;
END;
/

CREATE SEQUENCE productshabi_producto_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER productshabi_producto_trg BEFORE
    INSERT ON productshabi
    FOR EACH ROW
    WHEN ( new.producto IS NULL )
BEGIN
    :new.producto := productshabi_producto_seq.nextval;
END;
/

CREATE SEQUENCE reservas_idreserva_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER reservas_idreserva_trg BEFORE
    INSERT ON reservas
    FOR EACH ROW
    WHEN ( new.idreserva IS NULL )
BEGIN
    :new.idreserva := reservas_idreserva_seq.nextval;
END;
/

CREATE SEQUENCE servicios_idservicio_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER servicios_idservicio_trg BEFORE
    INSERT ON servicios
    FOR EACH ROW
    WHEN ( new.idservicio IS NULL )
BEGIN
    :new.idservicio := servicios_idservicio_seq.nextval;
END;
/


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            21
-- CREATE INDEX                             0
-- ALTER TABLE                             46
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           8
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          6
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
