#!/usr/bin/python

import subprocess
import time

while True:
    subprocess.call(["uptime"], shell=True)
    time.sleep(3)

