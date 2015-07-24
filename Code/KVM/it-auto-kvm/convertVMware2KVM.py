#!/usr/bin/python

import os 
import re
import sys
import subprocess

from storages import *

if len(sys.argv) != 3:
    print "Usage: %s <storage_id> <ve_type>" % sys.argv[0]
    sys.exit(1)

storage_id = sys.argv[1]
ve_type = sys.argv[2]

if not STORAGES.has_key(storage_id):
    print "Invalid storage_id: %s" % storage_id
    sys.exit(1)

homePath = os.path.join(STORAGES[storage_id], "provisioned")
print homePath
homePath = os.path.join(homePath, ve_type)
print homePath

for (path, dirs, files) in os.walk(homePath):
  print path
  for fil in files:
    match = re.match(".*01\.vmdk", fil)
    if match is not None:
      filePath = os.path.join(path, fil)
      match_w2k3 = re.match(".*w2k3.*", path)
      match_winxp = re.match(".*xp.*", path)
      if match_w2k3 is not None:
        fileConvert = os.path.join(path, "snapw2k8.qcow2")
        convert = "qemu-img convert -f vmdk -O qcow2 %s %s" % (filePath, fileConvert)
        print convert  
        subprocess.call([convert], shell=True)
      if match_winxp is not None:
        fileConvert = os.path.join(path, "snapw7.qcow2")
        convert = "qemu-img convert -f vmdk -O qcow2 %s %s" % (filePath, fileConvert)
        print convert  
        subprocess.call([convert], shell=True)

#  for fil in files:
#    match = re.match(".*qcow2", fil)
#    if match is None:
#      filePath = os.path.join(path, fil)
#      remove = "rm %s" % filePath
#      print remove
#      subprocess.call([remove], shell=True)
  print "*****"
