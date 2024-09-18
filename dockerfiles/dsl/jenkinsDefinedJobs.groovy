// Project Logic
def projectBaseName = "Jenkins Predefined Jobs"
def projectBaseDir = "basedirectory"
def projectDescriptionBase = "Here you can find jobs for Jenkins"

// Will Create just the base dir :( kind useless
//folder(projectBaseDir) {
//    displayName(projectBaseName)
//    description(projectDescriptionBase)
//}

def dirList = ["1"]  // Example directories, you can customize this list

dirList.each { dirSuffix ->
    def newProjectDir = "${projectBaseDir} ${dirSuffix}"
    def newProjectName = "${projectBaseName} ${dirSuffix}"
    def newProjectDescription = "${projectDescriptionBase} ${dirSuffix}"

    folder(newProjectDir) {
        displayName(newProjectName)
        description(newProjectDescription)
    }
}

//
// def jobList = ["1"]
// 
// jobList.each { jobSuffix ->
//     def newMultiBranch = "basedirectory/jobs-${jobSuffix}"
//     multibranchPipelineJob("${newMultiBranch}") {
//     }
// }

def manyJobCreator  = [
    'Terraform': 'Job',
    'Terragrunt': 'Job',
    'Packer': 'Job',
    'Build': 'Job',
]
manyJobCreator.each { key, val ->
    multibranchPipelineJob("$key-$val") {

    }
}