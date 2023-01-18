.Phony: build buildnotest buildtrace clean create protocopy
build: clean
	./gradlew build
buildnotest: clean
	./gradlew build -x tests
buildtrace:
	./gradlew build --stacktrace
buildscan:
	./gradlew build --scan
clean:
	./gradlew clean
create:
	gradle init
protocopy:
	cp src/main/proto/*.proto ../pcBookgRPC/proto/
gen:
	protoc --proto_path=src/main/proto --java_out=build/generated/ src/main/proto/*.proto 

