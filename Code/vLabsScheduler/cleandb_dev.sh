#!/bin/sh


psql -d exams_dev -f vmportal/exams/create_tables.sql
psql -d vescheduler_dev -f vmportal/scheduler/create_tables.sql

