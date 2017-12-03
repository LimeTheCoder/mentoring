FROM java:8
VOLUME /tmp
ADD class-management.jar app.jar
ADD startup.sh startup.sh
RUN bash -c 'chmod +x /startup.sh'
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["/bin/bash", "/startup.sh"]