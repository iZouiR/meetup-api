create table meets
(
    meet_id     BIGINT,
    title       VARCHAR   not null,
    description VARCHAR,
    keeper      VARCHAR   not null,
    date        TIMESTAMP not null,
    place       VARCHAR   not null
);

alter table meets
    add constraint meet_id_pk
        primary key (meet_id);

alter table meets
alter column meet_id add generated always as identity;

INSERT INTO meets (title, description, keeper, date, place) VALUES ('Tech Interview', 'Duration - 30 minutes', 'Modsen', '2022-10-17T09:30:00.0000Z', 'EUROPE');
INSERT INTO meets (title, description, keeper, date, place) VALUES ('Football Game', 'Duration - 120 minutes', 'HighFoot', '2022-10-22T10:00:00.0000Z', 'AFRICA');
INSERT INTO meets (title, description, keeper, date, place) VALUES ('Coffee Break', 'Duration - 5 minutes', 'Modsen', '2022-10-18T014:30:00.0000Z', 'EUROPE');
INSERT INTO meets (title, description, keeper, date, place) VALUES ('Game Preview', 'GameCon 2022 AU', 'LLC GameNet', '2022-10-10T012:30:00.0000Z', 'AUSTRALIA');
INSERT INTO meets (title, description, keeper, date, place) VALUES ('Game Preview', 'GameCon 2022 AS', 'LLC GameDa', '2022-10-11T012:30:00.0000Z', 'ASIA');