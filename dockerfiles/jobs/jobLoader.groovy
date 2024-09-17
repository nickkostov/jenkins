// Project Logic
def projectName = "Business Application 1"
def projectDir = "Project 1"
// Environments 
def envProjectDev = "dev"
def envProjectUat = "uat"
def envProjectProd = "prod"
// Sub Dirs ... In vars cuz why not 
def devFolder = "${projectDir}/${envProjectDev}"
def uatFolder = "${projectDir}/${envProjectUat}"
def prodFolder = "${projectDir}/${envProjectProd}"
// 
def projectDescription = "Jenkins JOBS for ${projectName}"
// Dev Description:
def devDescription = "Dedicated Folder for all development (DEV) jobs associated with ${projectName}"
// UAT Description
def uatDescription = "Dedicated Folder for all User Acceptance and Testing (UAT) jobs associated with ${projectName}"
// Prod Description
def prodDescription = "Dedicated Folder for all Production (PROD) jobs associated with ${projectName}"
//
folder(projectDir) {
    displayName(projectName)
    description(projectDescription)
}

folder(devFolder) {
    displayName("${projectName} ${envProjectDev}")
    description(devDescription)
}


//multibranchPipelineJob("${devFolder}/MultiBranchLogic") {
//    branchSources {
//        git {
//            id('123456789') // IMPORTANT: use a constant and unique identifier
//            remote('git@github.com:nickkostov/project-repo-template.git')
//            credentials('git-ecdsa')
//            includes('JENKINS-*')
//        }
//    }
//    orphanedItemStrategy {
//        discardOldItems {
//            numToKeep(20)
//        }
//    }
//}



folder(uatFolder) {
    displayName("${projectName} ${envProjectUat}")
    description(uatDescription)
}

folder(prodFolder) {
    displayName("${projectName} ${envProjectProd}")
    description(prodDescription)
}

//// Project Information
//def projectName = "Business Application 1"
//def projectDir = "Project 1"
//
//// Environments
//def environments = ['dev', 'uat', 'prod']
//
//// Descriptions for each environment
//def envDescriptions = [
//    dev: "Dedicated Folder for all development (DEV) jobs associated with ${projectName}",
//    uat: "Dedicated Folder for all User Acceptance and Testing (UAT) jobs associated with ${projectName}",
//    prod: "Dedicated Folder for all Production (PROD) jobs associated with ${projectName}"
//]
//
//// Project Folder Description
//def projectDescription = "Jenkins JOBS for ${projectName}"
//
//// Function to create folders for each environment
//def createEnvironmentFolder(String env) {
//    def envFolder = "${projectDir}/${env}"
//    folder(envFolder) {
//        displayName("${projectName} ${env.toUpperCase()}")
//        description(envDescriptions[env])
//    }
//}
//
//// Create the main project folder
//folder(projectDir) {
//    displayName(projectName)
//    description(projectDescription)
//}
//
//// Create folders for each environment
//environments.each { env ->
//    createEnvironmentFolder(env)
//}