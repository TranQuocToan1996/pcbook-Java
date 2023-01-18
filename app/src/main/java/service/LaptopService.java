package service;

import java.util.UUID;
import java.util.logging.Logger;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import pcbookJava.CreateLaptopRequest;
import pcbookJava.CreateLaptopResponse;
import pcbookJava.Laptop;
import pcbookJava.LaptopServiceGrpc.LaptopServiceImplBase;

public class LaptopService extends LaptopServiceImplBase {
    private static final Logger logger = Logger.getLogger(LaptopService.class.getName());
    private LaptopStore store;

    public LaptopService(LaptopStore store) {
        this.store = store;
    }

    @Override
    public void createLaptop(CreateLaptopRequest request,
            StreamObserver<CreateLaptopResponse> reponseObserver) {
        Laptop laptop = request.getLaptop();
        String id = laptop.getId();

        logger.info("got a request with ID: " + id);

        UUID uuid;
        if (id.isEmpty()) {
            uuid = UUID.randomUUID();
        } else {
            try {
                uuid = UUID.fromString(id);
            } catch (IllegalArgumentException e) {
                reponseObserver.onError(
                        Status.INVALID_ARGUMENT
                                .withDescription(e.getMessage())
                                .asRuntimeException());
                return;
            }
        }

        Laptop other = laptop.toBuilder().setId(uuid.toString()).build();
        try {
            store.Save(other);
        } catch (AlreadyExistExeption e) {
            reponseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription(e.getMessage())
                            .asRuntimeException());
            return;
        } catch (Exception e) {
            reponseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException());
            return;
        }
    }

    // CreateLaptopResponse.Builder

}
