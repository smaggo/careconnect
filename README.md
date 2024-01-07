![careconnect](src/main/resources/static/img/careconnect.png)

Care Connect
==============

Care Connect is a portal for a clinic. It helps the patients manage their appointments. It has dashboard so that patient can create their appointments online and get notified about that. It also helps the doctors to manage their appointments.

Introduction
=============
This website helps the patient to communicate with the hospital to create an appointment. Doctors can accept the appointment. And patients can view the prescriptions and history.

Purpose
========

The purpose of the project is to understand the web application architecture. Here we used spring framework, as we learnt it in the theoratical study. As it is only demonstration, it is not fully featured website for patient. 

Design
======
Please refer design document ![here](doc/design/design_doc.pdf)

Usage scenarios
===============

The site has three kinds of users. 

- Patient
- Doctor
- Administrator

The administrator creates doctor. The patient registers in the site and creates appointment. And doctors agrees upon the appointment. Afterwards the patient can see appointment history.

character | description | task 
----------|:------------|:---------------------
Patient | The patient is the client of the hospital. He needs therapy for his or her illness. And he wants to see a doctor. He needs an appointment to do that. | He registers in the hospital and creates appointments.
Doctor | Doctor gives the patient the therapy for illness. He has specialization for some illness. | Doctor confirms registration and he updates the appointments.
Administrator | He is the hospital administrator | He creates new doctor accounts and updates the site.

#### Patient registration

The patient/user clicks on the Register link on the home page and is directed to the Patient Registration page where they need to fill the patient information. 
After successful registration, they are directed to the Patient dashboard.

#### Registration of doctor by admin

The master admin user will login and clicks on the Add Doctor link which will load the Doctor Registration page.  The Admin fills in the Doctor details.
The doctor will login, enters his username and password in the login page.  After successful login, the doctor is directed to the doctor dashboard.    

#### Patient appointment

A patient can request an appointment with a specific doctor.  The patient needs to login and proceeds to the patient dashboard where there is a link to create an appointment.  
In the appointment page, the patient needs to fill the form and enter the illness, date and time of appointment request.  

#### Doctor updates appointment

The doctor will login and proceeds to the dashboard where a list of appointments.  The doctor reviews appointment and Aprove or Reject on his/her availability . 


Technologies
=============

- SpringBoot
- Maven
- Mysql
- HTML
- Java
- Javascript
- CSS
