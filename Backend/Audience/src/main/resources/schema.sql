-- Drop tables if they exist (to make script idempotent)
-- No separate tables for single table inheritance
DROP TABLE IF EXISTS online_conference CASCADE;
DROP TABLE IF EXISTS offline_conference CASCADE;
DROP TABLE IF EXISTS review_paper CASCADE;
DROP TABLE IF EXISTS research_paper CASCADE;
DROP TABLE IF EXISTS paper CASCADE;
DROP TABLE IF EXISTS profile CASCADE;
DROP TABLE IF EXISTS audience_interest CASCADE;
DROP TABLE IF EXISTS interest CASCADE;
DROP TABLE IF EXISTS audience CASCADE;
DROP TABLE IF EXISTS conference CASCADE;
-- Table: conference (abstract, base for Online/OfflineConference)

CREATE TABLE conference (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    location VARCHAR(255),
    date DATE,
    description VARCHAR(255),
    time TIME
);

-- Table: audience (single table for all types)
CREATE TABLE audience (
    audience_id SERIAL PRIMARY KEY,
    audience_type VARCHAR(31) NOT NULL,
    full_name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    affilation VARCHAR(255),
    phone_no VARCHAR(255),
    conference_id INTEGER REFERENCES conference(id),
    -- StudentAudience fields
    enrollment_id VARCHAR(255),
    course VARCHAR(255),
    -- ProfessorAudience fields
    department VARCHAR(255),
    designation VARCHAR(255),
    -- IndustryAudience fields
    company_name VARCHAR(255),
    job_title VARCHAR(255)
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


-- Table-per-class inheritance for Paper
CREATE TABLE paper (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    abstract_text VARCHAR(255),
    file_path VARCHAR(255),
    author VARCHAR(255)
);

CREATE TABLE research_paper (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    abstract_text VARCHAR(255),
    file_path VARCHAR(255),
    author VARCHAR(255),
    methodology VARCHAR(255),
    results_summary VARCHAR(255)
);

CREATE TABLE review_paper (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    abstract_text VARCHAR(255),
    file_path VARCHAR(255),
    author VARCHAR(255),
    reviewed_topics VARCHAR(255),
    number_of_citations INTEGER
);

-- Table: offline_conference (inherits conference)
CREATE TABLE offline_conference (
    id INTEGER PRIMARY KEY REFERENCES conference(id),
    venue_details VARCHAR(255),
    seating_capacity INTEGER
);

-- Table: online_conference (inherits conference)
CREATE TABLE online_conference (
    id INTEGER PRIMARY KEY REFERENCES conference(id),
    meeting_url VARCHAR(255)
);

-- No separate tables for student_audience, professor_audience, industry_audience