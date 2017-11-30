node() {
    stage "checkout"
    git url: 'https://github.com/helpermethod/microservices-workshop/'
    stage "package"
    stage "test"
    stage "UAT"
    timeout(time: 30, unit: 'SECONDS') {
        input 'Alles Ok'
    }
    stage "deploy"
}
