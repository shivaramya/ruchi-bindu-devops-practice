node{
    dir("C:\\Temp\\jenkins-ws"){
    bat "whoami";
    def presentWorkDir = pwd();
    println "Starting Java pipeline for CI-CD in directory ${presentWorkDir}";
    try{
    stage("check-out"){
        bat "git clone https://github.com/shivaramya/sample-rest-app.git";
    }
    
    stage("maven-build"){
        dir("sample-rest-app"){
       // bat "set MAVEN_HOME=E:\\Softwares\\apache-maven-3.6.3-bin\\apache-maven-3.6.3";
    //     bat "set PATH=%PATH%;E:\\Softwares\\apache-maven-3.6.3-bin\\apache-maven-3.6.3\\bin";
     //    println "PATH is ";
     //    bat "echo %PATH%";
         bat "echo %MAVEN_HOME%"
        // tool name: 'MAVEN_HOME', type: 'maven';
     //   bat "set JAVA_HOME=\"C:\\Program Files\\Java\\jdk-11.0.9\"  ";
        bat "echo \"JAVA_HOME is %JAVA_HOME%\"";
     //   bat "set PATH=%PATH%;C:\\Program Files\\Java\\jdk-11.0.9\\bin";
     //    println "PATH is ";
         bat "echo %PATH%";
         bat "E:\\Softwares\\apache-maven-3.6.3-bin\\apache-maven-3.6.3\\bin\\mvn.cmd install";
        }
    }
    
        stage("deployment"){
        dir("sample-rest-app\\target"){
        bat "java -jar sample-rest-app-0.0.1.jar";
            
        }
    }
    
    }
    catch(ex){
        println "Please check the Exceptions!! Build failed..  ";
        throw ex;
    }
    finally{
        deleteDir();
    }

    
    } 
}
