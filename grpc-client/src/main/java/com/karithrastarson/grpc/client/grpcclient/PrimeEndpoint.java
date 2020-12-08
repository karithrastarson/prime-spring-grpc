package com.karithrastarson.grpc.client.grpcclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeEndpoint {
    GRPCClientService grpcClientService;
    @Autowired
    public PrimeEndpoint(GRPCClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }
    @GetMapping("/prime/{max}")
    public String ping(@PathVariable("max") int max) {
        return grpcClientService.prime(max);
    }
}
