-- 1. Inserindo Tutores (precisam existir primeiro por causa das chaves estrangeiras)
INSERT INTO tutor (id, nome, email) VALUES (1, 'Mariana Silva', 'mariana.silva@email.com');
INSERT INTO tutor (id, nome, email) VALUES (2, 'Carlos Eduardo Santos', 'carlos.santos@email.com');
INSERT INTO tutor (id, nome, email) VALUES (3, 'Fernanda Oliveira', 'fernanda.oli@email.com');
-- 2. Inserindo Pets (vinculados aos tutores via tutor_id)
INSERT INTO pet (id, nome, especie, sexo, raca, tutor_id) VALUES (1, 'Thor', 'Cachorro', 'M', 'Golden Retriever', 1);
INSERT INTO pet (id, nome, especie, sexo, raca, tutor_id) VALUES (2, 'Luna', 'Gato', 'F', 'Siamês', 1);
INSERT INTO pet (id, nome, especie, sexo, raca, tutor_id) VALUES (3, 'Bolinha', 'Cachorro', 'M', 'Poodle', 2);
INSERT INTO pet (id, nome, especie, sexo, raca, tutor_id) VALUES (4, 'Mia', 'Gato', 'F', 'SRD', 3);

-- 3. Inserindo Agendamentos (assuma um Enum Status com AGENDADO, CONCLUIDO, CANCELADO)
INSERT INTO agendamento (id, tutor_id, pet_id, data_criacao, data_consulta, status) VALUES (1, 1, 1, '2026-11-10 09:30:00', '2026-11-20 14:00:00', 'AGENDADO');
INSERT INTO agendamento (id, tutor_id, pet_id, data_criacao, data_consulta, status) VALUES (2, 1, 2, '2026-11-12 11:15:00', '2026-11-15 10:30:00', 'CONCLUIDO');
INSERT INTO agendamento (id, tutor_id, pet_id, data_criacao, data_consulta, status) VALUES (3, 2, 3, '2026-11-14 16:00:00', '2026-11-22 09:00:00', 'AGENDADO');
INSERT INTO agendamento (id, tutor_id, pet_id, data_criacao, data_consulta, status) VALUES (4, 3, 4, '2026-11-05 08:45:00', '2026-11-10 15:00:00', 'CANCELADO');