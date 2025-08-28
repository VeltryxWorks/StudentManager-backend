--- Svuota tutte le tabelle e resetta gli ID
TRUNCATE TABLE exam RESTART IDENTITY CASCADE;
TRUNCATE TABLE todo RESTART IDENTITY CASCADE;
TRUNCATE TABLE student RESTART IDENTITY CASCADE;

-- Popola la tabella student
INSERT INTO student (name, surname, email)
VALUES ('Emanuele', 'Rossi', 'emanuele.rossi@example.com'),
       ('Luca', 'Bianchi', 'luca.bianchi@example.com'),
       ('Maria', 'Verdi', 'maria.verdi@example.com');

-- Popola la tabella exam
-- ATTENZIONE: student_id deve corrispondere agli ID dei record appena creati
INSERT INTO exam (title, description, exam_date, vote, status, student_id)
VALUES ('Matematica', 'Analisi 1', '2025-09-15', 28, 'PENDING', 1),
       ('Informatica', 'Programmazione Java', '2025-09-20', 30, 'COMPLETED', 1),
       ('Fisica', 'Meccanica', '2025-09-18', 25, 'PENDING', 2),
       ('Chimica', 'Chimica Organica', '2025-09-22', 27, 'COMPLETED', 3);

-- Popola la tabella todo
-- ATTENZIONE: student_id deve corrispondere agli ID dei record appena creati
INSERT INTO todo (task, deadline, completed, student_id)
VALUES ('Studiare Analisi 1', '2025-09-10', false, 1),
       ('Scrivere relazione laboratorio', '2025-09-12', true, 1),
       ('Preparare esame Fisica', '2025-09-14', false, 2),
       ('Leggere capitolo Chimica', '2025-09-13', true, 3);

