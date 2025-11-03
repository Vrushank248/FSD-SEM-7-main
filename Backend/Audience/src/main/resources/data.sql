-- Insert Interests
INSERT INTO interest (interest_name, description, category) VALUES
  ('Artificial Intelligence', 'Study and development of intelligent machines and software.', 'AI'),
  ('Machine Learning', 'A subset of AI focused on algorithms that learn from data.', 'ML'),
  ('Data Science', 'Field that uses scientific methods to extract knowledge from data.', 'DS'),
  ('Cybersecurity', 'Protection of computer systems from theft or damage.', 'Security'),
  ('Cloud Computing', 'Delivery of computing services over the internet.', 'Cloud'),
  ('Quantum Computing', 'Computation using quantum-mechanical phenomena.', 'Quantum');

-- Insert Conferences (6-7, both online and offline)
INSERT INTO conference (title, location, date, description, time) VALUES
  ('AI Conference 2025', 'New York', '2025-05-10', 'A conference about AI', '09:00'),
  ('ML Summit', 'San Francisco', '2025-06-15', 'Machine Learning trends and research', '10:00'),
  ('Data Science Expo', 'Chicago', '2025-07-20', 'Data Science applications', '11:00'),
  ('Cybersecurity Forum', 'Online', '2025-08-05', 'Latest in cybersecurity', '12:00'),
  ('Cloud Next', 'Seattle', '2025-09-12', 'Cloud computing innovations', '13:00'),
  ('Quantum Leap', 'Online', '2025-10-18', 'Quantum computing breakthroughs', '14:00'),
  ('Tech Future', 'Boston', '2025-11-22', 'Emerging tech trends', '15:00');

-- Insert Offline Conferences
INSERT INTO offline_conference (id, venue_details, seating_capacity) VALUES
  (1, 'NYC Convention Center', 500),
  (2, 'SF Tech Hall', 400),
  (3, 'Chicago Expo Center', 350),
  (5, 'Seattle Cloud Arena', 300),
  (7, 'Boston Tech Park', 250);

-- Insert Online Conferences
INSERT INTO online_conference (id, meeting_url) VALUES
  (4, 'https://cyberforum.com/meet'),
  (6, 'https://quantumleap.com/meet'); 

INSERT INTO audience (audience_type, full_name, email, password, affilation, phone_no, conference_id, enrollment_id, course, department, designation, company_name, job_title) VALUES
  ('STUDENT', 'John Doe', 'john@example.com', 'password', 'MIT', '1234567890', 1, 'ENR001', 'Computer Science', NULL, NULL, NULL, NULL),
  ('STUDENT', 'Alice Smith', 'alice@example.com', 'alicepass', 'Stanford', '2345678901', 2, 'ENR002', 'Data Science', NULL, NULL, NULL, NULL),
  ('PROFESSOR', 'Bob Lee', 'bob@example.com', 'bobpass', 'Google', '3456789012', 4, NULL, NULL, 'Engineering', 'Associate Professor', NULL, NULL),
  ('STUDENT', 'Priya Kumar', 'priya@example.com', 'priyapass', 'IIT Delhi', '4567890123', 6, 'ENR003', 'Quantum Computing', NULL, NULL, NULL, NULL),
  ('PROFESSOR', 'Carlos Ruiz', 'carlos@example.com', 'carlospass', 'Amazon', '5678901234', 5, NULL, NULL, 'Cybersecurity', 'Professor', NULL, NULL);

-- Insert Profiles (one-to-one with audience)
INSERT INTO profile (bio, linkedin_url, twitter_handle, website, date_of_birth, address, city, country, profile_picture_url, audience_id) VALUES
  ('AI researcher', 'https://linkedin.com/in/johndoe', '@johndoe', 'https://johndoe.com', '1990-01-01', '123 Main St', 'New York', 'USA', 'https://pics.com/john.jpg', 1),
  ('ML enthusiast', 'https://linkedin.com/in/alicesmith', '@alicesmith', 'https://alicesmith.com', '1992-02-02', '456 Elm St', 'San Francisco', 'USA', 'https://pics.com/alice.jpg', 2),
  ('Cloud architect', 'https://linkedin.com/in/boblee', '@boblee', 'https://boblee.com', '1988-03-03', '789 Oak St', 'Los Angeles', 'USA', 'https://pics.com/bob.jpg', 3),
  ('Quantum computing student', 'https://linkedin.com/in/priyakumar', '@priyakumar', 'https://priyakumar.com', '1995-04-04', '321 Pine St', 'Delhi', 'India', 'https://pics.com/priya.jpg', 4),
  ('Cybersecurity expert', 'https://linkedin.com/in/carlosruiz', '@carlosruiz', 'https://carlosruiz.com', '1985-05-05', '654 Maple St', 'Seattle', 'USA', 'https://pics.com/carlos.jpg', 5);

-- Link Audiences to Interests (many-to-many)
INSERT INTO audience_interest (audience_id, interest_id) VALUES
  (1, 1), (1, 2), -- John: AI, ML
  (2, 2), (2, 3), -- Alice: ML, DS
  (3, 5), (3, 3), -- Bob: Cloud, DS
  (4, 6), (4, 1), -- Priya: Quantum, AI
  (5, 4), (5, 5); -- Carlos: Cybersecurity, Cloud


-- Insert Research Papers (all fields)
INSERT INTO research_paper (title, abstract_text, file_path, author, methodology, results_summary) VALUES
  ('Deep Learning Advances', 'Latest advances in deep learning.', '/papers/dl_advances.pdf', 'Mark Brown', 'Experimental', 'Improved accuracy by 5%'),
  ('Data Science in Healthcare', 'Applications of DS in healthcare.', '/papers/ds_healthcare.pdf', 'Alice Smith', 'Case Study', 'Significant impact in hospitals'),
  ('Quantum Algorithms', 'Overview of quantum algorithms.', '/papers/quantum_algorithms.pdf', 'Priya Kumar', 'Algorithm Analysis', 'Faster computation'),
  ('AI Ethics', 'Ethical considerations in AI.', '/papers/ai_ethics.pdf', 'John Doe', 'Survey', 'Ethical gaps identified'),
  ('ML for Finance', 'Machine learning applications in finance.', '/papers/ml_finance.pdf', 'Bob Lee', 'Data Analysis', 'Profitable predictions'),
  ('Research on NLP', 'Natural Language Processing research.', '/papers/nlp_research.pdf', 'Alice Smith', 'Model Development', 'State-of-the-art results');

-- Insert Review Papers (all fields)
INSERT INTO review_paper (title, abstract_text, file_path, author, reviewed_topics, number_of_citations) VALUES
  ('Survey on ML', 'Comprehensive survey on machine learning.', '/papers/ml_survey.pdf', 'Juliet Ceaser', 'ML Algorithms', 120),
  ('Cloud Security', 'Security in cloud computing.', '/papers/cloud_security.pdf', 'Carlos Ruiz', 'Cloud Security Issues', 80),
  ('Review of Cybersecurity Trends', 'Recent trends in cybersecurity.', '/papers/cyber_trends.pdf', 'Carlos Ruiz', 'Cybersecurity Trends', 60),
  ('Review: Quantum Computing', 'Review of quantum computing progress.', '/papers/quantum_review.pdf', 'Priya Kumar', 'Quantum Computing', 45);