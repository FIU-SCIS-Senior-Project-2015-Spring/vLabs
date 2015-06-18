#!/bin/sh

cd /home/vc4/vm-storage/portal/exams/provisioned/K2_1/

for file in *; do
   if [ -d $file ]; then
      echo $file; 
      cd $file;
      ls -alR
      rm w2k3-1/w2k3-flat.vmdk w2k3-1/w2k3-Snapshot1.vmsn
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/w2k3-1/w2k3-flat.vmdk w2k3-1/w2k3-flat.vmdk
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/w2k3-1/w2k3-Snapshot1.vmsn w2k3-1/w2k3-Snapshot1.vmsn
      rm xp-1/xp1-flat.vmdk xp-1/xp1-Snapshot1.vmsn
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/xp-1/xp1-flat.vmdk xp-1/xp1-flat.vmdk
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/xp-1/xp1-Snapshot1.vmsn xp-1/xp1-Snapshot1.vmsn
      rm xp-2/xp1-flat.vmdk xp-2/xp1-Snapshot1.vmsn
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/xp-2/xp1-flat.vmdk xp-2/xp1-flat.vmdk
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/xp-2/xp1-Snapshot1.vmsn xp-2/xp1-Snapshot1.vmsn
      rm xp-3/xp1-flat.vmdk xp-3/xp1-Snapshot1.vmsn
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/xp-3/xp1-flat.vmdk xp-3/xp1-flat.vmdk
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/xp-3/xp1-Snapshot1.vmsn xp-3/xp1-Snapshot1.vmsn
      rm xp-4/xp1-flat.vmdk xp-4/xp1-Snapshot1.vmsn
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/xp-4/xp1-flat.vmdk xp-4/xp1-flat.vmdk
      ln -s /home/vc4/vm-storage/portal/exams/templates/temp-K2_1/xp-4/xp1-Snapshot1.vmsn xp-4/xp1-Snapshot1.vmsn
      ls -alR
      cd ..
   fi
done
