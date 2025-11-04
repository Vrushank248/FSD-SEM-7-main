
# 🎓 Conference & Audience Management System

A **Full-Stack Conference & Audience Management Platform** built with **Angular**, **Spring Boot**, and **MySQL** that enables users to register, manage profiles, explore conferences (online/offline), and submit or review research papers — all under a secure, role-based environment.

---

## 🚀 Overview

The **Conference & Audience Management System** simplifies the organization of academic and professional conferences by providing a unified digital workspace for students, professors, and industry professionals.

It handles **audience registration, conference listings, paper submission, and interest tracking** through an intuitive and responsive web interface.

---

## 🧠 Key Features

- 🔐 **Role-Based Authentication:** Separate login and access for Students, Professors, and Professionals using Spring Security & JWT.
- 📋 **Audience Management:** Create, view, and update personal profiles and professional interests.
- 🧾 **Conference Management:** List, filter, and register for **Online** or **Offline** conferences dynamically.
- 📄 **Paper Submission System:** Upload, manage, and review **Research** or **Review** papers seamlessly.
- 💬 **Interest Mapping:** Many-to-many linking between users and interests for personalized conference suggestions.
- ⚙️ **Admin Control:** Backend endpoints for managing conferences, users, and paper data.
- 📱 **Responsive UI:** Angular components with reactive forms and validation, optimized for all screen sizes.
- 🔁 **RESTful APIs:** 25+ APIs ensure efficient communication between frontend and backend.

---

## 🧩 Tech Stack

| Layer | Technologies Used |
|-------|-------------------|
| **Frontend** | Angular, TypeScript, HTML5, CSS3 |
| **Backend** | Spring Boot, Java, REST API |
| **Database** | MySQL |
| **Security** | JWT, CORS Configuration |
| **Tools & Build** | Maven, Node.js, Angular CLI |
| **Version Control** | Git, GitHub |

---

## 🏗️ System Architecture

```

┌───────────────────────────────────────────────┐
│                 Frontend (Angular)            │
│  - User Registration/Login                    │
│  - Dashboard & Profile Management             │
│  - Paper & Conference Modules                 │
│  - REST API Integration                       │
└───────────────▲───────────────────────────────┘
│  JSON over HTTP (REST)
┌───────────────┴───────────────────────────────┐
│               Backend (Spring Boot)           │
│  - Controllers (Audience, Conference, Paper)  │
│  - Services & Repositories                    │
│  - JPA Entities with Relationships            │
│  - JWT Authentication                         │
└───────────────▲───────────────────────────────┘
│  JDBC ORM
┌───────────────┴───────────────────────────────┐
│                Database (MySQL)               │
│  - Tables: audience, conference, paper, etc.  │
│  - Relationships: One-to-Many, Many-to-Many   │
└───────────────────────────────────────────────┘

```

---

## 🗂️ Folder Structure

```

FSD-SEM-7-main/
│
├── Backend/
│   └── Audience/
│       ├── src/main/java/com/example/audience/
│       │   ├── controller/        # REST controllers
│       │   ├── service/           # Business logic
│       │   ├── repository/        # JPA repositories
│       │   └── model/             # Entity classes
│       └── src/main/resources/
│           ├── application.properties
│           └── database.sql
│
├── Frontend/
│   └── AudienceManagement/
│       ├── src/app/
│       │   ├── components/        # Angular components
│       │   ├── services/          # API and Auth services
│       │   ├── models/            # TypeScript models
│       │   └── app-routing.module.ts
│       └── package.json
│
└── README.md

````

---

## ⚙️ Installation & Setup

### 🔧 Backend (Spring Boot)

1. Navigate to backend folder:
   ```bash
   cd Backend/Audience
````

2. Import as a **Maven project** in your IDE (IntelliJ / Eclipse).
3. Configure your database in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/conference_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Run the backend server:

   ```bash
   mvn spring-boot:run
   ```

   Server runs on: `http://localhost:8080`

---

### 💻 Frontend (Angular)

1. Navigate to frontend folder:

   ```bash
   cd Frontend/AudienceManagement
   ```

2. Install dependencies:

   ```bash
   npm install
   ```

3. Start the Angular development server:

   ```bash
   ng serve
   ```

   App runs on: `http://localhost:4200`

4. Ensure CORS is enabled in Spring Boot backend for frontend requests.

---

## 🧪 Usage

1. Register as a new **Audience** (Student/Professor/Professional).
2. Login to access your **dashboard**.
3. Explore **Online/Offline Conferences** and view details.
4. Submit or review **papers** under your account.
5. Update your **profile and interests** dynamically.
6. Admin can manage users, conferences, and paper approvals from backend APIs.

---


## 🧱 Database Design

* **Tables:** `audience`, `conference`, `paper`, `interest`, `audience_interest`
* **Relationships:**

  * `Audience` ↔ `Interest` → Many-to-Many
  * `Audience` ↔ `Paper` → One-to-Many
  * `Conference` ↔ `Paper` → One-to-Many
* **Inheritance:**

  * `Audience` → `StudentAudience`, `ProfessorAudience`
  * `Conference` → `OnlineConference`, `OfflineConference`

---

## 📬 API Endpoints (Examples)

| Endpoint                     | Method | Description              |
| ---------------------------- | ------ | ------------------------ |
| `/api/audience/register`     | POST   | Register a new user      |
| `/api/audience/login`        | POST   | Authenticate audience    |
| `/api/conference/all`        | GET    | Retrieve all conferences |
| `/api/paper/submit`          | POST   | Submit a paper           |
| `/api/audience/{id}/profile` | GET    | Get audience profile     |

---

## 🧰 Future Enhancements

* 🔸 Integration of Email/OTP-based verification
* 🔸 Paper review and scoring system for professors
* 🔸 Admin dashboard (Angular-based) for managing submissions
* 🔸 Cloud-based file storage (AWS S3 / Firebase)
* 🔸 Role-based analytics and reporting dashboard

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!
Feel free to fork this repo and submit a pull request.

---

## 📜 License

This project is licensed under the **MIT License**.
See [LICENSE](LICENSE) for more information.

---


⭐ **If you like this project, consider giving it a star on GitHub!**

```

visual/impact highlights)?
```
