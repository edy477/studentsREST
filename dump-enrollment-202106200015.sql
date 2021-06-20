--
-- PostgreSQL database dump
--

-- Dumped from database version 12.7 (Ubuntu 12.7-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.7 (Ubuntu 12.7-0ubuntu0.20.04.1)

-- Started on 2021-06-20 00:15:37 CST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 7 (class 2615 OID 16385)
-- Name: enrolled; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA enrolled;


ALTER SCHEMA enrolled OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 16394)
-- Name: courses; Type: TABLE; Schema: enrolled; Owner: postgres
--

CREATE TABLE enrolled.courses (
    course_name character varying,
    created character varying,
    category character varying(50),
    course_id uuid NOT NULL,
    start_date timestamp(0) without time zone
);


ALTER TABLE enrolled.courses OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16402)
-- Name: enrollment; Type: TABLE; Schema: enrolled; Owner: postgres
--

CREATE TABLE enrolled.enrollment (
    enrollment_id uuid NOT NULL,
    student_id uuid,
    course_id uuid,
    date_of_enrollment timestamp(0) without time zone
);


ALTER TABLE enrolled.enrollment OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16386)
-- Name: students; Type: TABLE; Schema: enrolled; Owner: postgres
--

CREATE TABLE enrolled.students (
    student_id uuid NOT NULL,
    password character varying,
    email character varying,
    date_of_birth character varying,
    first_name character varying,
    last_name character varying,
    username character varying
);


ALTER TABLE enrolled.students OWNER TO postgres;

--
-- TOC entry 2977 (class 0 OID 16394)
-- Dependencies: 204
-- Data for Name: courses; Type: TABLE DATA; Schema: enrolled; Owner: postgres
--

COPY enrolled.courses (course_name, created, category, course_id, start_date) FROM stdin;
"UX centering"	\N	"User Experience"	47911090-5e74-4053-84bb-716c080082d2	\N
"Mooc"	\N	"Nova"	126ed5b7-1cbc-4b78-95bc-f8e46c6d9e85	\N
\.


--
-- TOC entry 2978 (class 0 OID 16402)
-- Dependencies: 205
-- Data for Name: enrollment; Type: TABLE DATA; Schema: enrolled; Owner: postgres
--

COPY enrolled.enrollment (enrollment_id, student_id, course_id, date_of_enrollment) FROM stdin;
f9820659-caf8-4d0e-87df-22bd52919cef	7f000101-7a25-1ce3-817a-25f51d1b0000	47911090-5e74-4053-84bb-716c080082d2	\N
e22e008c-2c0a-41c0-94f6-daa46c9d5995	7f000101-7a25-1ce3-817a-25f51d1b0000	126ed5b7-1cbc-4b78-95bc-f8e46c6d9e85	\N
\.


--
-- TOC entry 2976 (class 0 OID 16386)
-- Dependencies: 203
-- Data for Name: students; Type: TABLE DATA; Schema: enrolled; Owner: postgres
--

COPY enrolled.students (student_id, password, email, date_of_birth, first_name, last_name, username) FROM stdin;
7f000101-7a25-1ce3-817a-25f51d1b0000	Hora	bl2@com	\N	carolina	Tsar	Jordan
9114078c-f722-42ad-af6f-3c851a522527	Nuevo	bl2@com	\N	nuevo	Sve	fernando
\.


--
-- TOC entry 2845 (class 2606 OID 16401)
-- Name: courses courses_pk; Type: CONSTRAINT; Schema: enrolled; Owner: postgres
--

ALTER TABLE ONLY enrolled.courses
    ADD CONSTRAINT courses_pk PRIMARY KEY (course_id);


--
-- TOC entry 2847 (class 2606 OID 16409)
-- Name: enrollment enrollment_pk; Type: CONSTRAINT; Schema: enrolled; Owner: postgres
--

ALTER TABLE ONLY enrolled.enrollment
    ADD CONSTRAINT enrollment_pk PRIMARY KEY (enrollment_id);


--
-- TOC entry 2843 (class 2606 OID 16393)
-- Name: students students_pk; Type: CONSTRAINT; Schema: enrolled; Owner: postgres
--

ALTER TABLE ONLY enrolled.students
    ADD CONSTRAINT students_pk PRIMARY KEY (student_id);


--
-- TOC entry 2848 (class 2606 OID 16410)
-- Name: enrollment enrollment_fk; Type: FK CONSTRAINT; Schema: enrolled; Owner: postgres
--

ALTER TABLE ONLY enrolled.enrollment
    ADD CONSTRAINT enrollment_fk FOREIGN KEY (student_id) REFERENCES enrolled.students(student_id);


--
-- TOC entry 2849 (class 2606 OID 16415)
-- Name: enrollment enrollment_fk_1; Type: FK CONSTRAINT; Schema: enrolled; Owner: postgres
--

ALTER TABLE ONLY enrolled.enrollment
    ADD CONSTRAINT enrollment_fk_1 FOREIGN KEY (course_id) REFERENCES enrolled.courses(course_id);


-- Completed on 2021-06-20 00:15:37 CST

--
-- PostgreSQL database dump complete
--

