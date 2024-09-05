job('seed_job') {
 scm {
  git {
   remote {
    url('https://github.com/nickkostov/poc-jenkins')
   }
   branch('main')
  }
 }
 steps {
  dsl {
   external('hellow_world_job.groovy')
  }
 }
}
