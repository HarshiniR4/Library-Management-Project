DROP TABLE IF EXISTS author;
CREATE TABLE author (
  name varchar(50) NOT NULL DEFAULT '',
  workplace varchar(30) DEFAULT NULL,
  PRIMARY KEY (name)
) ;
--
-- Data for table "author"
--

INSERT INTO author VALUES 
('John Smith', 'New York'),
('Emma Brown', 'London'),
('Michael Johnson', 'Sydney'),
('Sophia Chen', 'Beijing'),
('Daniel Kim', 'Seoul'),
('Maria Garcia', 'Madrid'),
('Mohammed Ali', 'Cairo');

DROP TABLE IF EXISTS librarian;
CREATE TABLE librarian (
  nameUser varchar(50) NOT NULL DEFAULT '',
  password varchar(50) NOT NULL DEFAULT 'root'
) ;

INSERT INTO librarian VALUES 
('smithj', 'password123'),
('brownE', 'librarian123'),
('johnsonM', 'securePass'),
('chenS', 'adminPass'),
('kimD', '12345678'),
('garciaM', 'librarianPass'),
('aliM', 'password789');

--
-- Structure for table "publisher"
--

DROP TABLE IF EXISTS publisher;
CREATE TABLE publisher (
  name varchar(50) NOT NULL DEFAULT '',
  address varchar(50) DEFAULT NULL,
  PRIMARY KEY (name)
) ;
INSERT INTO publisher VALUES 
('HarperCollins', 'New York'),
('Penguin Books', 'London'),
('Random House', 'Sydney'),
('Beijing Press', 'Beijing'),
('Seoul Publishers', 'Seoul'),
('Madrid Print House', 'Madrid'),
('Nile Publishing', 'Cairo');


DROP TABLE IF EXISTS book;

CREATE TABLE book (
  idBook TEXT NOT NULL DEFAULT '',
  nameBook TEXT DEFAULT NULL,
  price INTEGER DEFAULT NULL,
  kind TEXT DEFAULT NULL,
  author TEXT NOT NULL DEFAULT '',
  publisher TEXT NOT NULL DEFAULT '',
  PRIMARY KEY (idBook),
  FOREIGN KEY (author) REFERENCES author (name),
  FOREIGN KEY (publisher) REFERENCES publisher (name)
);

CREATE INDEX namePublisher ON book (publisher);
CREATE INDEX nameAuthor ON book (author);

INSERT INTO book VALUES 
('101', 'The Art of Programming', 45, 'Computer Science', 'John Smith', 'HarperCollins'),
('102', 'Pride and Prejudice', 30, 'Fiction', 'Emma Brown', 'Penguin Books'),
('103', 'Data Structures Unleashed', 55, 'Computer Science', 'Michael Johnson', 'Random House'),
('104', 'Introduction to AI', 60, 'Computer Science', 'Sophia Chen', 'Beijing Press'),
('105', 'Korean Cuisine', 25, 'Cookbook', 'Daniel Kim', 'Seoul Publishers'),
('106', 'Spanish Flamenco', 40, 'Arts', 'Maria Garcia', 'Madrid Print House'),
('107', 'Ancient Egyptian History', 35, 'History', 'Mohammed Ali', 'Nile Publishing');

DROP TABLE IF EXISTS reader;
CREATE TABLE reader (
  idReader varchar(50) NOT NULL DEFAULT '',
  nameReader varchar(50) DEFAULT NULL,
  kind varchar(7) DEFAULT 'Student',
  sex varchar(8) NOT NULL DEFAULT 'Male',
  password varchar(50) NOT NULL DEFAULT 'root',
  PRIMARY KEY (idReader)
) ;

INSERT INTO reader VALUES 
('011', 'Alice', 'Student', 'Female', 'password123'),
('012', 'Bob', 'Student', 'Male', 'student456'),
('013', 'Charlie', 'Teacher', 'Male', 'teacher789'),
('014', 'Diana', 'Student', 'Female', 'dianaPass'),
('015', 'Eva', 'Teacher', 'Female', 'eva123'),
('016', 'Frank', 'Student', 'Male', 'frankPass'),
('017', 'Grace', 'Student', 'Female', 'gracePass');

DROP TABLE IF EXISTS borrow;
CREATE TABLE borrow (
  idReader TEXT NOT NULL DEFAULT '',
  idBook TEXT NOT NULL DEFAULT '',
  lendDate TEXT NOT NULL DEFAULT '2015-07-25',
  dueDate TEXT NOT NULL DEFAULT '2015-12-19',
  overtime TEXT NOT NULL DEFAULT 'No',
  UNIQUE (idBook),
  FOREIGN KEY (idBook) REFERENCES book (idBook),
  FOREIGN KEY (idReader) REFERENCES reader (idReader)
);

CREATE INDEX idx_idReader ON borrow (idReader);

INSERT INTO borrow VALUES 
('011', '101', '2023-01-10', '2023-02-10', 'No'),  -- Alice borrows 'The Art of Programming'
('012', '102', '2023-02-15', '2023-03-15', 'No'),  -- Bob borrows 'Pride and Prejudice'
('013', '103', '2023-03-20', '2023-04-20', 'No'),  -- Charlie borrows 'Data Structures Unleashed'
('014', '104', '2023-04-25', '2023-05-25', 'No'),  -- Diana borrows 'Introduction to AI'
('015', '105', '2023-05-30', '2023-06-30', 'No'),  -- Eva borrows 'Korean Cuisine'
('016', '106', '2023-06-05', '2023-07-05', 'No'),  -- Frank borrows 'Spanish Flamenco'
('017', '107', '2023-07-10', '2023-08-10', 'No');  -- Grace borrows 'Ancient Egyptian History'