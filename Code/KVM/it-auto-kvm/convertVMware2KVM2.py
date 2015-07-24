#!/usr/bin/python

import os 
import re
import sys
import subprocess
import shutil

from storages import *

if len(sys.argv) != 3:
    print "Usage: %s <storage_id> <ve_type>" % sys.argv[0]
    sys.exit(1)

storage_id = sys.argv[1]
ve_type = sys.argv[2]

if not STORAGES.has_key(storage_id):
    print "Invalid storage_id: %s" % storage_id
    sys.exit(1)

basePath = os.path.join(STORAGES[storage_id], "provisioned")
print basePath
homePath = os.path.join(basePath, ve_type)
print homePath
backupPath = os.path.join(basePath, ve_type + "_backup")
print backupPath
try:
  os.stat(backupPath)
except:
  os.mkdir(backupPath)

for (path, dirs, files) in os.walk(homePath):
  print "path: " + path
  for fil in files:
    match = re.match(".*01\.vmdk", fil)
    if match is not None:
      filePath = os.path.join(path, fil)
      match_w2k3 = re.match(".*w2k3.*", path)
      match_winxp = re.match(".*xp.*", path)
      if match_w2k3 is not None:
        newPath = os.path.dirname(path)
        print newPath
        newPath = os.path.join(newPath, "w2k8-1")
        print newPath
        try:
          os.stat(newPath)
        except:
          os.mkdir(newPath)
        fileConvert = os.path.join(newPath, "snapw2k8.qcow2")
        print fileConvert
        print filePath
        convert = "qemu-img convert -f vmdk -O qcow2 %s %s" % (filePath, fileConvert)
        print convert  
        subprocess.call([convert], shell=True)
        baseDir1 = os.path.basename(os.path.dirname(filePath))
        baseDir2 = os.path.basename(os.path.dirname(os.path.dirname(filePath)))
        print "baseDir1: " + baseDir1  
        print "baseDir2: " + baseDir2  
        print "backupPath: " + backupPath
        backupDir2 = os.path.join(backupPath, baseDir2)
        backupDir1 = os.path.join(backupDir2, baseDir1)
        print "backupDir2: " + backupDir2
        print "backupDir1: " + backupDir1
        try:
          os.stat(backupDir2)
        except:
          os.mkdir(backupDir2)
        srcDir = os.path.dirname(filePath)
        print "srcDir: " + srcDir
        tarDir = backupDir2
        print "tarDir: " + tarDir
        shutil.move(srcDir, backupDir2);
      if match_winxp is not None:
        newPath = os.path.dirname(path)
        print newPath
        if re.match(".*xp-1.*", path) is not None:
          newPath = os.path.join(newPath, "w7-1")
        elif re.match(".*xp-2.*", path) is not None:
          newPath = os.path.join(newPath, "w7-2")
        elif re.match(".*xp-3.*", path) is not None:
          newPath = os.path.join(newPath, "w7-3")
        elif re.match(".*xp-4.*", path) is not None:
          newPath = os.path.join(newPath, "w7-4")
        print newPath
        try:
          os.stat(newPath)
        except:
          os.mkdir(newPath)
        fileConvert = os.path.join(newPath, "snapw2k8.qcow2")
        print fileConvert
        print filePath

        fileConvert = os.path.join(newPath, "snapw7.qcow2")
        convert = "qemu-img convert -f vmdk -O qcow2 %s %s" % (filePath, fileConvert)
        print convert  
        subprocess.call([convert], shell=True)
        baseDir1 = os.path.basename(os.path.dirname(filePath))
        baseDir2 = os.path.basename(os.path.dirname(os.path.dirname(filePath)))
        print "baseDir1: " + baseDir1
        print "baseDir2: " + baseDir2
        print "backupPath: " + backupPath
        backupDir2 = os.path.join(backupPath, baseDir2)
        backupDir1 = os.path.join(backupDir2, baseDir1)
        print "backupDir2: " + backupDir2
        print "backupDir1: " + backupDir1
        try:
          os.stat(backupDir2)
        except:
          os.mkdir(backupDir2)
        srcDir = os.path.dirname(filePath)
        print "srcDir: " + srcDir
        tarDir = backupDir2
        print "tarDir: " + tarDir
        shutil.move(srcDir, backupDir2);

#  for fil in files:
#    match = re.match(".*qcow2", fil)
#    if match is None:
#      filePath = os.path.join(path, fil)
#      remove = "rm %s" % filePath
#      print remove
#      subprocess.call([remove], shell=True)
  print "*****"
