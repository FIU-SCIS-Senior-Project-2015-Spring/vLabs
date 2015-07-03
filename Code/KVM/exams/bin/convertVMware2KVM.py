import os 
import re
import sys
import subprocess

homePath = "/home/vc12/vm-storage/portal/vc11/"

for (path, dirs, files) in os.walk(homePath):
  print path
  for fil in files:
    match = re.match(".*1\.vmdk", fil)
    if match is not None:
      filePath = os.path.join(path, fil)
      match_w2k3 = re.match(".*w2k3.*", path)
      match_winxp = re.match(".*winxp.*", path)
      if match_w2k3 is not None:
        fileConvert = os.path.join(path, "w2k8.qcow2")
        convert = "qemu-img convert -f vmdk -O qcow2 %s %s" % (filePath, fileConvert)
        print convert  
        subprocess.call([convert], shell=True)
      if match_winxp is not None:
        fileConvert = os.path.join(path, "w7.qcow2")
        convert = "qemu-img convert -f vmdk -O qcow2 %s %s" % (filePath, fileConvert)
        print convert  
        subprocess.call([convert], shell=True)

  for fil in files:
    match = re.match(".*qcow2", fil)
    if match is None:
      filePath = os.path.join(path, fil)
      remove = "rm %s" % filePath
      print remove
      subprocess.call([remove], shell=True)
  print "*****"
