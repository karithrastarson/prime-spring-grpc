package com.karithrastarson.grpc.client.grpcclient;


import com.karithrastarson.grpc.server.grpcserver.PrimeRequest;
import com.karithrastarson.grpc.server.grpcserver.PrimeResponse;
import com.karithrastarson.grpc.server.grpcserver.PrimeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GRPCClientService {
    public String prime(int max) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();
        PrimeServiceGrpc.PrimeServiceBlockingStub stub
                = PrimeServiceGrpc.newBlockingStub(channel);
        PrimeResponse primeResponse = stub.prime(PrimeRequest.newBuilder()
                .setMax(max)
                .build());
        channel.shutdown();
        return primeResponse.getPrimes();
    }
}

