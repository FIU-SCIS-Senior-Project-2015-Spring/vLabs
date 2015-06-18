#!/usr/bin/python

import subprocess
import time

while True:
    subprocess.call(["clear"], shell=True)
    subprocess.call(["ps aux --sort -%cpu | head -40"], shell=True)
    time.sleep(3)
