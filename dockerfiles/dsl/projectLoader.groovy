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
// Pseudo description
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

//multibranchPipelineJob("${projectDir}/${devFolder}/MultiBranchLogic") {
//}
job("${devFolder}/justAjOb") {

}
multibranchPipelineJob("${devFolder}/MultiBranchLogic") {
    displayName("Multi Branch Pipeline")
    description("This is a test multibranch coming out of a DSL script")

    branchSources {
         github {
           apiUri("https://api.github.com")
           repository("project-repo-template")
           repoOwner("nickkostov")
           scanCredentialsId("github_credentials")
           id("master")
           includes("master")
         }
    }
    factory {
        workflowBranchProjectFactory {
            scriptPath("Jenkinsfile")
        }
    }
}

folder(uatFolder) {
    displayName("${projectName} ${envProjectUat}")
    description(uatDescription)
}

folder(prodFolder) {
    displayName("${projectName} ${envProjectProd}")
    description(prodDescription)
}