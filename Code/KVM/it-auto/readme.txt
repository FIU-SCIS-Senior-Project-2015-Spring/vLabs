All the scripts have list of parameters that they expect. Here are some examples and some descriptions. Please do not hesitate to ask if you are not sure about a parameter. 

First Example, start_ve.py:

[portal@virtual-cluster-4 ~]$ start_ve.py
Usage: /home/sadjadi-vmstorage/sadjadi-vms/it-auto/start_ve.py <username> <ve_type> <first_port> <num_ports> <first_mac> <num_macs> <router_id> <storage_id> <register_action>

[portal@virtual-cluster-4 ~]$ start_ve.py sadjadi K2_1 15061 5 6073 6 1 4 2

- sadjadi is the username
- K2_1 is the ve_type (or the DEVA type)
- 15061 and 5 are for first_port and num_ports, respectively, that indicate that ports 15061 to 15065 (in total five ports for reserved for RDP connections to the five virtual machines behind the router, namely, w2k3, xp-1, xp-2, xp-3, and xp-4) are dedicated to this specific user
- 6073 and 6 for first_mac and num_macs, respectively, that indicate the serial numbers from 6073 to 6078 will be added to the first VMware allocated range of MAC addresses, namely 00:50:56:00:00:00, and those MAC addresses will belog to this user (e.g., in this case, the MAC addresses are 00:50:56:00:17:B9, 00:50:56:00:17:BB, 00:50:56:00:17:BC, 00:50:56:00:17:BD, and 00:50:56:00:17:BE; note that if you convert 6073 to hex, it would be 17B9, add this to 00:50:56:00:00:00 and you will get the first MAC address)
-1 is for the router_id; note that as we have 8 routers running all the time, the ids are fixed to 1 to 8; the first ve will get the first available router; for example, in this case that we have only one ve running on vc4, you can see this:

  [portal@virtual-cluster-4 ~]$ cat /etc/vmnats 
  (15061-15065) -> 172.16.48.100:(1024-1028)

  This means that the ports 15061 to 15065, dedicated to this user will be routed to the fixed ports 1024 to 1028 on network card 172.16.48.100 that belongs to the first router. The routers are configured to route the trafic on ports 1024 to 1028 to port 3389 (RDP port) on the five virtual machines (namely w2k3, xp-1, xp-2, xp-3, and xp-4; and the way they know them by specific ip addresses as 192.168.0.10:3389, 192.168.0.100:3389, 192.168.1.100:3389, 192.168.2.100:3389, and 192.168.2.200:3389, respectively)
-4 is for storage_id; we have assigned an id to each storage. For now, each host has only one storage id as follows:
vescheduler2=# select id,dir_path,gb_size from storage order by id;
 id |               dir_path                | gb_size 
----+---------------------------------------+---------
  0 | /home/ita-vm1/vm-storage/portal/exams |     200
  1 | /home/vc1/vm-storage/portal/exams     |    1000
  2 | /home/vc2/vm-storage/portal/exams     |    1000
  3 | /home/vc3/vm-storage/portal/exams     |    1000
  4 | /home/vc4/vm-storage/portal/exams     |    1000
  5 | /home/vc5/vm-storage/portal/exams     |    1000
  6 | /home/vc6/vm-storage/portal/exams     |    2500
  7 | /home/vc7/vm-storage/portal/exams     |    2500
  8 | /home/vc8/vm-storage/portal/exams     |    2500

  Here is the list of our preference on where to run a ve based on its storage location:
vescheduler2=# select storage_id,host_id,preference from host_storage order by storage_id,host_id;
 storage_id | host_id | preference 
------------+---------+------------
          0 |       0 |          1
          1 |       1 |          1
          2 |       2 |          1
          3 |       3 |          1
          4 |       4 |          1
          5 |       5 |          1
          6 |       6 |          1
          7 |       7 |          1
          8 |       8 |          1

  For example, the ve for sadjadi residing in storage 4 is preferred to run on host 4. Here is the list of hosts:
vescheduler2=# select id,name,ssh_port,username,password from host order by id;
 id |      name       | ssh_port | username |  password  
----+-----------------+----------+----------+------------
  0 | vc0.cis.fiu.edu |       22 | portal   | k4se*prt4l
  1 | vc1.cis.fiu.edu |       22 | portal   | k4se*prt4l
  2 | vc2.cis.fiu.edu |       22 | portal   | k4se*prt4l
  3 | vc3.cis.fiu.edu |       22 | portal   | k4se*prt4l
  4 | vc4.cis.fiu.edu |       22 | portal   | k4se*prt4l
  5 | vc5.cis.fiu.edu |       22 | portal   | k4se*prt4l
  6 | vc6.cis.fiu.edu |       22 | portal   | k4se*prt4l
  7 | vc7.cis.fiu.edu |       22 | portal   | k4se*prt4l
  8 | vc8.cis.fiu.edu |       22 | portal   | k4se*prt4l

  Therefore, this ve for sadjadi must start on host 4, which is vc4.cis.fiu.edu and that is why the start_ve.py command was executed on vc4.

I suppose the target hosts you are working on will have storage and host ids from 101 and above.
-2 is for register_action; 0 indicates if this is the first time this ve is being scheduled ever, which means that is has to be provisioned first and its vms must be registered with the vmware server on this host; 1 indicates that this ve was provisioned before, but its vms were not registered with the vmware server on this host (we are not using this option anymore as running a vm from a remote storage is not efficient); 2 indicates that this ve was provisioned before and its vms have been previously registered with the vmware server on this host. Note that 0 would result in running the provisioner.py, which will be explained next.

Second Example, provisioner.py:

[portal@virtual-cluster-4 ~]$ provisioner.py
Usage: /home/sadjadi-vmstorage/sadjadi-vms/it-auto/provisioner.py <ve_type> <storage_id>

[portal@virtual-cluster-4 ~]$ provisioner.py K2_1 4
Template path /home/vc4/vm-storage/portal/exams/templates/temp-K2_1 exists: 
VE folder (/home/vc4/vm-storage/portal/exams/provisioned) is: 
vit_dir is /home/vc4/vm-storage/portal/exams/provisioned/K2_1/
Total slots: 101
    Used slots: 101
    Greatest: 182
There are 1 new slots
creating ve 183
Tue Mar 13 09:22:09 EDT 2012

This program creates new slots to be used by start_ve.py, if the parameter 0 is passed for register_action. We use dot files to indicate whether a ve slot has been used, started, stopped, etc. If you look under exams/provisioned directory, you can find examples of these dot files. For example, for sadjadi's ve, you can see the following when the ve is started:
[portal@virtual-cluster-4 ~]$ ls -al exams/provisioned/K2_1/158/
total 28
drwxr-xr-x   7 portal acrl 4096 Mar 13 09:27 ./
drwxr-xr-x 104 portal acrl 4096 Mar 13 09:22 ../
-rw-r--r--   1 portal acrl    0 Mar 13 09:27 .started
-rw-r--r--   1 portal acrl    0 Mar 13 09:27 .used
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:27 w2k3-1/
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:27 xp-1/
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:27 xp-2/
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:27 xp-3/
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:27 xp-4/

and this when it is stopped:
[portal@virtual-cluster-4 ~]$ ls -al exams/provisioned/K2_1/158/
total 28
drwxr-xr-x   7 portal acrl 4096 Mar 13 09:12 ./
drwxr-xr-x 104 portal acrl 4096 Mar 13 09:22 ../
-rw-r--r--   1 portal acrl    0 Mar 13 09:12 .stopped
-rw-r--r--   1 portal acrl    0 Mar 13 08:42 .used
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:12 w2k3-1/
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:12 xp-1/
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:12 xp-2/
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:12 xp-3/
drwxr-xr-x   2 portal acrl 4096 Mar 13 09:12 xp-4/

But how do we know that slot 158 belongs to sadjadi? We do this by a soft link. If you browse under the exams/assigned directory, you can find out what slots belong to what user for which one of its ves. For example, for sadjadi, you can see the followings:
[portal@virtual-cluster-4 ~]$ ls -al exams/assigned/sadjadi*
lrwxrwxrwx 1 portal acrl 54 Jan  7 21:03 exams/assigned/sadjadi-K2_1-14141 -> /home/vc4/vm-storage/portal/exams/provisioned/K2_1/122/
lrwxrwxrwx 1 portal acrl 54 Jan 19 23:27 exams/assigned/sadjadi-K2_1-14461 -> /home/vc4/vm-storage/portal/exams/provisioned/K2_1/132/
lrwxrwxrwx 1 portal acrl 54 Feb  3 10:51 exams/assigned/sadjadi-K2_1-14751 -> /home/vc4/vm-storage/portal/exams/provisioned/K2_1/145/
lrwxrwxrwx 1 portal acrl 54 Feb 14 10:43 exams/assigned/sadjadi-K2_1-15046 -> /home/vc4/vm-storage/portal/exams/provisioned/K2_1/164/
lrwxrwxrwx 1 portal acrl 54 Feb 13 09:52 exams/assigned/sadjadi-K2_1-15061 -> /home/vc4/vm-storage/portal/exams/provisioned/K2_1/158/

As you can see, sadjadi has 5 ves, but the one that we are working with at this moment is with ve type K2_1 and starting RDP port of 15061, which uniquely identify the K2_1/158 slot under the exams/provisioned directory.

Third Example, stope_ve.py:

[portal@virtual-cluster-4 ~]$ stop_ve.py
Usage: /home/sadjadi-vmstorage/sadjadi-vms/it-auto/stop_ve.py <username> <ve_type> <first_port> <num_ports> <router_id> <storage_id>

[portal@virtual-cluster-4 ~]$ stop_ve.py sadjadi K2_1 15061 5 1 4

I believe that you can understand all the parameters for this one! ;)
