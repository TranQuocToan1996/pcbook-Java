import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.gitlab.techschool.pcbook.pb.CreateLaptopRequest;
import com.gitlab.techschool.pcbook.pb.LaptopServiceGrpc;
import com.gitlab.techschool.pcbook.sample.Generator;
import com.gitlab.techschool.pcbook.service.InMemoryLaptopStore;
import com.gitlab.techschool.pcbook.service.LaptopServer;
import com.gitlab.techschool.pcbook.service.LaptopStore;

import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;

public class LaptopServerTest {
    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();
    private LaptopStore store;
    private LaptopServer server;
    private ManagedChannel channel;

    @Before
    public void setUp() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        var serverBuilder = InProcessServerBuilder.forName(serverName).directExecutor();
        store = new InMemoryLaptopStore();
        server = new LaptopServer(serverBuilder, 0, store);
        server.start();
        channel = grpcCleanup.register(InProcessServerBuilder.forName(serverName).directExecutor().build());
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void createLaptopWithAValidID() {
        var generator = new Generator();
        var laptop = generator.NewLaptop();
        var request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();
        var stub = LaptopServiceGrpc.newBlockingStub(channel);
        var response = stub.createLaptop(request);
        assertNotNull(response);
        assertEquals(laptop.getId(),response.getId());
        var res = store.Find(response.getId());
        assertNotNull(res);
    }
}
