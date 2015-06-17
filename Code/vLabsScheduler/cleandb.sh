#!/bin/sh


psql -d exams -f ~/vmportal/exams/create_tables.sql
psql -d vescheduler -f ~/vmportal/scheduler/create_tables.sql

