.Phony: build buildnotest buildtrace clean create
build: clean
	./gradlew app:build
buildnotest: clean
	./gradlew app:build -x tests
buildtrace:
	./gradlew app:build --stacktrace
buildscan:
	./gradlew app:build --scan
clean:
	./gradlew clean
create:
	gradle init