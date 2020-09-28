package com.mycompany.app;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesRequest;

@SuppressWarnings("unused")
public class App implements RequestHandler<Object, Object> {

    public Object handleRequest(Object input, Context context) {
        AmazonEC2 ec2Client = AmazonEC2ClientBuilder.standard()
                .withRegion("us-east-1")
                .build();
        String instanceId = "i-088a86bc4c9b0265c";
        StartInstancesRequest request = new StartInstancesRequest().withInstanceIds(instanceId);
        ec2Client.startInstances(request);
        System.out.println("Started the Instnace with ID: "+instanceId);
        return "{\"result\": \"hello lambda java\"}";
    }  
}
    