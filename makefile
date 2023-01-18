.Phony: build buildnotest buildtrace clean create protocopy
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
protocopy:
	cp app/src/main/proto/*.proto ../pcBookgRPC/proto/
gen:
	protoc --proto_path=/src/main/proto --java_out=build/generated/ /src/main/proto/*.proto
