package com.karithrastarson.grpc.server.grpcserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import static com.google.common.math.IntMath.isPrime;

@GrpcService
public class PrimeServiceImpl extends PrimeServiceGrpc.PrimeServiceImplBase {
    @Override
    public void prime(
            PrimeRequest request, StreamObserver<PrimeResponse> responseObserver) {
        String ping = new StringBuilder()
                .append(primes(request.getMax()))
                .toString();
        PrimeResponse response = PrimeResponse.newBuilder()
                .setPrimes(ping)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public String primes(int max) {
        String result = "";
        for (int i = 0; i < max; i++) {
            if (isPrime(i)) {
                result = result.concat(i + ", ");
            }
        }
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }
}
