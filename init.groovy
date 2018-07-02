import jenkins.model.*
import hudson.security.*

def env = System.getenv()

def jenkins = Jenkins.getInstance()

def security = new HudsonPrivateSecurityRealm( false )
security.createAccount( env.JENKINS_USER, env.JENKINS_PASS )
security.save()

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()

jenkins.setSecurityRealm( security )
jenkins.setAuthorizationStrategy( strategy )
jenkins.save()
