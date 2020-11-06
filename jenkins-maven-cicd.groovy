node{
    dir("C:\\Temp\\jenkins-ws"){
    def presentWorkDir = pwd();
    println "Starting Java pipeline for CI-CD in directory ${presentWorkDir}";
    try{
    stage("check-out"){
        bat "git clone https://github.com/javabycode/spring-boot-maven-example-helloworld.git";
    }
    
    stage("maven-build"){
        dir("spring-boot-maven-example-helloworld"){
         println "PATH is ";
         //bat "%PATH%";
         bat "mvn install";
        }
    }
    
        stage("deployment"){
        println "deployment stage is yet to be implemented";
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
