FROM registry.apps.dev.openshift.ised-isde.canada.ca/ised-ci/openjdk18-openshift:latest

COPY target/ROOT.jar /ROOT.jar

USER 1001

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ROOT.jar"]