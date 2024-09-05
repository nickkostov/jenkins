FROM jenkins/jenkins:2.462.2-jdk17
LABEL maintainer="nikolay.yavorov.kostov@gmail.com"
USER root
RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list

RUN apt-get update && apt-get install -y docker-ce-cli
USER jenkins

# Setting up as step in Dockerfile (might increase size but it will be needed)

RUN jenkins-plugin-cli --plugins "configuration-as-code:1850.va_a_8c31d3158b_"
RUN mkdir /var/jenkins_home/casc_configs
ENV CASC_JENKINS_CONFIG /var/jenkins_home/casc_configs/jenkins.yaml
COPY jenkins.yaml /var/jenkins_home/casc_configs/jenkins.yaml



# List of Plugins we install on the jenkins instnace from a file
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt
# Environment Variable to set up the configuration 

#############################################################################
#COPY seedjob.groovy /usr/local/seedjob.groovy
#ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
#

#RUN jenkins-plugin-cli --plugins "blueocean docker-workflow"