FROM jenkins/jenkins:2.462.2-jdk17

LABEL maintainer="nikolay.yavorov.kostov@gmail.com"

USER root

# Update and install required packages
RUN apt-get update && apt install -y lsb-release ca-certificates git sudo

# Install Docker CLI
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg && \
  echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list

RUN apt-get update && apt-get install -y docker-ce-cli

# Add Jenkins user to sudoers and docker group
RUN usermod -aG sudo jenkins && \
    usermod -aG docker jenkins && \
    echo "jenkins ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

# Ensure Jenkins home directory exists and set permissions
RUN mkdir -p /var/jenkins_home && \
    chown -R jenkins:jenkins /var/jenkins_home

USER jenkins

# Install Jenkins plugins
RUN jenkins-plugin-cli --plugins "configuration-as-code:1850.va_a_8c31d3158b_"

# Set Jenkins Configuration as Code (JCasC) file location
ENV CASC_JENKINS_CONFIG="/var/jenkins_home/jenkins.yaml"

# Add JCasC config and plugins list
ADD jenkins.yaml /var/jenkins_home/jenkins.yaml
ADD plugins.txt /usr/share/jenkins/ref/plugins.txt

# Install plugins from file
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Disable Jenkins setup wizard
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

# Add job configuration script
ADD job-one.groovy /usr/local/job-one.groovy
