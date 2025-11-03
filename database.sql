-- Table: conference (abstract, base for Online/OfflineConference)
CREATE TABLE conference (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    location VARCHAR(255),
    date DATE,
    description VARCHAR(255),
    time TIME
);

-- Table: audience (base for StudentAudience, ProfessorAudience, IndustryAudience)
CREATE TABLE audience (
    audience_id SERIAL PRIMARY KEY,
    full_name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    affilation VARCHAR(255),
    phone_no VARCHAR(255),
    conference_id INTEGER REFERENCES conference(id)
);

-- Table: interest
CREATE TABLE interest (
    interest_id SERIAL PRIMARY KEY,
    interest_name VARCHAR(255) UNIQUE NOT NULL,
    description VARCHAR(255),
    category VARCHAR(255) NOT NULL
);

-- Many-to-many: audience_interest
CREATE TABLE audience_interest (
    audience_id INTEGER REFERENCES audience(audience_id),
    interest_id INTEGER REFERENCES interest(interest_id),
    PRIMARY KEY (audience_id, interest_id)
);

-- Table: profile (one-to-one with audience)
CREATE TABLE profile (
    profile_id SERIAL PRIMARY KEY,
    bio TEXT,
    linkedin_url VARCHAR(255),
    twitter_handle VARCHAR(255),
    website VARCHAR(255),
    date_of_birth DATE,
    address VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255),
    profile_picture_url VARCHAR(255),
    audience_id INTEGER UNIQUE REFERENCES audience(audience_id)
);

-- Table: paper (abstract, base for ResearchPaper, ReviewPaper)
CREATE TABLE paper (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    abstractText VARCHAR(255),
    filePath VARCHAR(255),
    author VARCHAR(255)
);

-- Table: research_paper (inherits paper)
CREATE TABLE research_paper (
    id INTEGER PRIMARY KEY REFERENCES paper(id),
    methodology VARCHAR(255),
    resultsSummary VARCHAR(255)
);

-- Table: review_paper (inherits paper)
CREATE TABLE review_paper (
    id INTEGER PRIMARY KEY REFERENCES paper(id),
    reviewedTopics VARCHAR(255),
    numberOfCitations INTEGER
);

-- Table: offline_conference (inherits conference)
CREATE TABLE offline_conference (
    id INTEGER PRIMARY KEY REFERENCES conference(id),
    venueDetails VARCHAR(255),
    seatingCapacity INTEGER
);

-- Table: online_conference (inherits conference)
CREATE TABLE online_conference (
    id INTEGER PRIMARY KEY REFERENCES conference(id),
    meetingUrl VARCHAR(255)
);

-- Table: student_audience (inherits audience)
CREATE TABLE student_audience (
    audience_id INTEGER PRIMARY KEY REFERENCES audience(audience_id),
    enrollmentId VARCHAR(255),
    course VARCHAR(255)
);

-- Table: professor_audience (inherits audience)
CREATE TABLE professor_audience (
    audience_id INTEGER PRIMARY KEY REFERENCES audience(audience_id),
    department VARCHAR(255),
    designation VARCHAR(255)
);

-- Table: industry_audience (inherits audience)
CREATE TABLE industry_audience (
    audience_id INTEGER PRIMARY KEY REFERENCES audience(audience_id),
    companyName VARCHAR(255),
    jobTitle VARCHAR(255)
);