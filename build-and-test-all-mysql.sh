#! /bin/bash -e


. ./set-env.sh

./wait-for-infrastructure.sh

./gradlew -x :end-to-end-tests:test build

./wait-for-todo-list-services.sh

./gradlew :end-to-end-tests:cleanTest :end-to-end-tests:test
