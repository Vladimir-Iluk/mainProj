CREATE TABLE companies (
    company_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    activity_type VARCHAR(255),
    address TEXT,
    phone VARCHAR(50)
);

CREATE TABLE employers (
    employer_id SERIAL PRIMARY KEY,
    last_name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    qualification VARCHAR(255),
    activity_type VARCHAR(255),
    other_info TEXT,
    expected_salary NUMERIC(10, 2)
);

CREATE TABLE agreements (
    agreement_id SERIAL PRIMARY KEY,
    employer_id INT REFERENCES employers(employer_id) ON DELETE CASCADE,
    company_id INT REFERENCES companies(company_id) ON DELETE CASCADE,
    pos VARCHAR(255),
    commission NUMERIC(10, 2)
);