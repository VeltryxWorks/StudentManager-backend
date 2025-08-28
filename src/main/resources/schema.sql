-- Tabella STUDENT
CREATE TABLE IF NOT EXISTS student
(
    student_id SERIAL PRIMARY KEY,
    name       VARCHAR(100)        NOT NULL,
    surname    VARCHAR(100)        NOT NULL,
    email      VARCHAR(150) UNIQUE NOT NULL
);

-- Tabella EXAM
CREATE TABLE IF NOT EXISTS exam
(
    exam_id     SERIAL PRIMARY KEY,
    title       VARCHAR(200) NOT NULL,
    description TEXT,
    exam_date   DATE,
    vote        INTEGER,
    status      VARCHAR(50),

    -- relazione con STUDENT
    student_id  BIGINT       NOT NULL,
    CONSTRAINT fk_exam_student FOREIGN KEY (student_id)
        REFERENCES student (student_id) ON DELETE CASCADE
);

-- Tabella TODO
CREATE TABLE IF NOT EXISTS todo
(
    todo_id    SERIAL PRIMARY KEY,
    task       VARCHAR(255) NOT NULL,
    deadline   DATE,
    completed  BOOLEAN DEFAULT FALSE,

    -- relazione con STUDENT
    student_id BIGINT       NOT NULL,
    CONSTRAINT fk_todo_student FOREIGN KEY (student_id)
        REFERENCES student (student_id) ON DELETE CASCADE
);
