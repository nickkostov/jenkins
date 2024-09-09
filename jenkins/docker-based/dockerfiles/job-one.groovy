job('Test Job') {
 scm {
  git {
   remote {
    url('git@github.com:nickkostov/poc-jenkins.git')
   }
   branch('master')
  }
 }
 steps {
  dsl {
   external('hello_world_job.groovy')
  }
 }
}
