# 🎓 Student Manager App

> 📚 **Student Manager** è un’applicazione backend + database progettata per uso personale.  
> ⚠️ **Nota:** Questo progetto è **solo a scopo didattico e personale**, non è pensato per essere pubblicato.

---

## 🛠 Tecnologie utilizzate

- **💻 Backend:**
    - Java 17
    - Spring Boot 3
    - Spring Data JPA
    - Spring Web

- **🗄 Database:**
    - PostgreSQL (Docker)
    - pgAdmin

- **📦 Gestione dei dati:**
    - Entità JPA: `Student`, `Exam`, `ToDo`
    - Relazioni: OneToMany / ManyToOne

- **🛠 Strumenti di sviluppo:**
    - IntelliJ IDEA
    - Docker e Docker Compose

- **🧪 Test API:**
    - Postman

---

## 📂 Struttura del progetto

```text
src/main/java/com/veltryxworks/studentmanager
│
├─ controller      → Gestisce le richieste HTTP (Auth, Exam, ToDo)
├─ service         → Logica applicativa e gestione dei repository
├─ repository      → Interfacce per accedere al database
├─ model           → Classi JPA (Student, Exam, ToDo)
└─ StudentManagerApplication.java → Classe principale Spring Boot
```
## 🔑 Funzionalità principali

### 🔐 Autenticazione
- Registrazione studenti
- Login tramite email

### 📖 Gestione esami
- Creazione e modifica esami
- Collegamento esami agli studenti

### ✅ To-Do list
- Creazione e gestione task
- Collegamento task agli studenti

### 🌐 Backend RESTful
- Tutte le entità accessibili tramite API HTTP

---

## 🧪 Test API con Postman
- `POST /api/auth/register` → Registrazione
- `POST /api/auth/login` → Login
- `/api/todo`, `/api/exam` → Gestione ToDo e Exam

---

## 📝 Note
- ⚠️ I dati non sono protetti: progetto solo per uso personale
- 🔒 Possibili estensioni future:
    - Autenticazione con password e JWT
    - Dashboard grafica per visualizzare esami e task
    - Notifiche e reminder

---

## 🌟 Conclusioni
Student Manager è un progetto didattico completo, perfetto per imparare a:

- Creare entità e relazioni JPA
- Gestire database PostgreSQL con Docker
- Costruire un backend RESTful con Spring Boot
- Testare API con Postman

