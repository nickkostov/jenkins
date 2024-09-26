# poc-jenkins
Jenkins POC with configuration as code plugin 


What is completed here:
- docker compose file
- begining of .env file 
- dsl jobs:

--> Spent time to learn how to use lists, loops and maps in it. Looped in a loop to have a good use case for creating as many as I want.

--> For the back up of the jenkins itself: 
---> Possible options:
----> Volume persistent to the configuration.
----> "NFS" on the home directory. In GCP I would just attach the disk there.
----> Plugin Configuration



### Warnings:

gradle:2.13 is faulty for some reason breaks the jenkins as code config.